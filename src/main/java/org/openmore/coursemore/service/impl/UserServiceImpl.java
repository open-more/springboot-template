package org.openmore.coursemore.service.impl;

import org.openmore.common.exception.*;
import org.openmore.common.utils.*;
import com.github.pagehelper.PageHelper;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.openmore.coursemore.dao.UserMapper;
import org.openmore.coursemore.dto.UserDto;
import org.openmore.coursemore.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.openmore.coursemore.service.UserService;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * THIS IS AUTO GENERATED SOURCE CODE
 * Created by org.openmore.coursemore
 * on 2017-07-23
 */
@Service
public class UserServiceImpl implements UserService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserMapper userDao;

    /**
     * 根据id获得用户 Dto对象
     *
     * @param id
     * @return UserDto
     */
    @Transactional
    public UserDto getUserDtoById(Integer id) throws IllegalAccessException, InvocationTargetException {
        logger.debug(">> getUserDtoById(Integer id) id = " + id);
        User entity = userDao.selectByPrimaryKey(id);
        if (entity == null) {
            return null;
        }
        UserDto dto = new UserDto();
        BeanUtils.copyProperties(dto, entity);
        return dto;
    }

    /**
     * 根据id获得用户 Db Entity对象
     *
     * @param id
     * @return User Db Entity
     */
    @Transactional
    public User getEntityById(Integer id) {
        logger.debug(">> getEntityById(Integer id)");
        return userDao.selectByPrimaryKey(id);
    }

    /**
     * 根据指定的参数对数据进行检索
     *
     * @return List<UserDto>结果列表
     */
    @Transactional
    public List<UserDto> searchUserDto(User user) throws IllegalAccessException, InvocationTargetException {
        logger.debug(">> searchUserDto(User user)");
        List<User> searchResult;
        if (user == null) {
            searchResult = userDao.selectAll();
        } else {
            searchResult = userDao.select(user);
        }

        List<UserDto> dtoResult = new ArrayList<>();
        for (User u : searchResult) {
            UserDto dto = new UserDto();
            BeanUtils.copyProperties(dto, u);
            dtoResult.add(dto);
        }
        return dtoResult;
    }

    /**
     * 根据指定的参数对数据进行检索
     *
     * @return List<User>结果列表
     */
    @Transactional
    public List<User> searchUser(String nickname, String mobile) throws IllegalAccessException, InvocationTargetException {
        logger.debug(">> searchUser(User user)");
        return userDao.selectUser(nickname, mobile);
    }

    /**
     * 根据指定的参数对数据进行分页检索
     *
     * @return List<User>结果列表
     */
    @Transactional
    public List<User> searchUserByPage(String nickname, String mobile, Integer pageNum, Integer pageSize) throws IllegalAccessException, InvocationTargetException {
        logger.debug(">> searchUser(User user)");
        PageHelper.startPage(pageNum, pageSize);
        return userDao.selectUser(nickname, mobile);
    }

    /**
     * 创建用户对象
     *
     * @param user 用户 Db Entity对象
     */
    @Transactional
    public void create(User user) throws Exception {
        logger.debug(">> create(User user)");
        try {
            userDao.insertSelective(user);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }
    }

    /**
     * 删除指定id的用户对象
     *
     * @param id 用户id
     */
    @Transactional
    public void deleteById(Integer id) {
        logger.debug(">> deleteById(Integer id)");
        userDao.deleteByPrimaryKey(id);
    }

    /**
     * 更新指定id的用户对象为user
     *
     * @param user 需要更新的Db Entity对象
     */
    @Transactional
    public void update(User user) throws Exception {
        logger.debug(">> update(User user");
        // updateByPrimaryKeySelective only update field not null.
        try {
            userDao.updateByPrimaryKeySelective(user);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }
    }

    /**
     * 更新用户金币数量
     *
     * @param uid    需要更新的Db Entity对象
     * @param amount 需要更新的Db Entity对象
     */
    @Transactional
    public void updateCoin(Integer uid, Integer amount) throws Exception {
        logger.debug(">> updateCoin()");
        try {
            userDao.updateCoin(uid, amount);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }
    }

    /**
     * 登录后，app保存token，下次登录使用token登录，并换取新的tokne
     *
     * @param deviceToken
     * @return
     * @throws Exception
     */
    @Transactional
    public UserDto tokenLogin(String deviceToken) throws Exception {
        logger.debug(">> tokenLogin");

        if (deviceToken == null || deviceToken.length() == 0) {
            deviceToken = "none";
        }

        Subject subject = SecurityUtils.getSubject();

        if (!subject.isAuthenticated()) {
            throw new ForbiddenException();
        }

        Object obj = subject.getPrincipal();
        if (obj == null || !(obj instanceof User)) {
            throw new InvalidParamsException("用户信息不存在");
        }
//        User user = (User)obj;
        User cacheUser = (User) obj;
        User user = this.getEntityById(cacheUser.getId());
        // 更新本次登录时间
        user.setLoginTime(new Date());
        this.update(user);
        UserDto dto = new UserDto();
        BeanUtils.copyProperties(dto, user);
        dto.setToken(CommonUtils.getTokenByUserId(user.getId(), deviceToken, CommonUtils.SCOPE_APP));

        return dto;
    }


    /**
     * 当前用户绑定手机
     *
     * @param mobile
     * @return
     * @throws Exception
     */
    @Transactional
    public UserDto bindMobile(String mobile) throws Exception {
        logger.debug(">> bindMobile");
        Subject subject = SecurityUtils.getSubject();

        Object obj = subject.getPrincipal();
        if (obj == null || !(obj instanceof User)) {
            logger.debug(">> 用户信息不存在");
            throw new InvalidParamsException("用户信息不存在");
        }
        User cacheUser = (User) obj;
        User user = this.getEntityById(cacheUser.getId());
        user.setMobile(mobile);
        this.update(user);

        UserDto dto = new UserDto();
        BeanUtils.copyProperties(dto, user);
        dto.setToken("");
        return dto;
    }


    /**
     * 手机号登录/注册
     *
     * @param mobile
     * @param deviceToken
     * @return
     * @throws Exception
     */
    @Transactional
    public UserDto mobileLogin(String mobile, String deviceToken) throws Exception {
        if (deviceToken == null || deviceToken.length() == 0) {
            deviceToken = "none";
        }
        List<User> result = this.searchUser(null, mobile);
        if (result != null && result.size() > 0) {
            logger.debug("用户已经存在，直接返回用户信息");
            // 用户已经存在，直接返回用户信息
            User user = result.get(0);
            // 更新本次登录时间
            user.setLoginTime(new Date());
            this.update(user);

            UserDto dto = new UserDto();
            BeanUtils.copyProperties(dto, user);
            dto.setToken(CommonUtils.getTokenByUserId(user.getId(), deviceToken, CommonUtils.SCOPE_APP));
            return dto;
        }
        logger.debug("用户不存在，创建用户");

        // 先创建用户信息
        User newUser = new User();
        newUser.setNickname(CommonUtils.randomString(8));
        newUser.setUuid(UUID.randomUUID().toString());
        newUser.setMobile(mobile);
        newUser.setBirthday("");
        newUser.setLocation("");
        newUser.setGender("0");
        newUser.setAvatar("http://static.3dfocus.cn/icon/Icon-64.png");
        newUser.setCoinQuantity(200);
        this.create(newUser);

        newUser.setCreatedTime(new Date());
        newUser.setUpdatedTime(new Date());
        newUser.setLoginTime(new Date());

        UserDto dto = new UserDto();
        BeanUtils.copyProperties(dto, newUser);
        dto.setToken(CommonUtils.getTokenByUserId(newUser.getId(), deviceToken, CommonUtils.SCOPE_APP));
        return dto;
    }


    /**
     * 修改用户昵称
     *
     * @param nickname
     * @return
     * @throws Exception
     */
    @Transactional
    public UserDto changeNickname(String nickname) throws Exception {
        logger.debug(">> changeNickname");
        Subject subject = SecurityUtils.getSubject();

        Object obj = subject.getPrincipal();
        if (obj == null || !(obj instanceof User)) {
            logger.debug(">> 用户信息不存在");
            throw new InvalidParamsException("用户信息不存在");
        }
        User cacheUser = (User) obj;
        User user = this.getEntityById(cacheUser.getId());
        user.setNickname(nickname);
        this.update(user);

        UserDto dto = new UserDto();
        BeanUtils.copyProperties(dto, user);
        dto.setToken("");
        return dto;
    }
}
