package org.openmore.coursemore.service.impl;

import org.openmore.coursemore.dto.ThirdLoginDto;
import org.openmore.coursemore.dto.UserDto;
import org.openmore.coursemore.entity.User;
import org.openmore.coursemore.service.UserService;
import org.openmore.common.exception.*;
import org.openmore.common.utils.*;
import org.apache.commons.beanutils.BeanUtils;
import org.openmore.coursemore.dao.ThirdAuthorizationsMapper;
import org.openmore.coursemore.dto.ThirdAuthorizationsDto;
import org.openmore.coursemore.service.ThirdAuthorizationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.openmore.coursemore.entity.ThirdAuthorizations;

/**
 * THIS IS AUTO GENERATED SOURCE CODE
 * Created by org.openmore.coursemore
 * on 2017-07-29
 */
@Service
public class ThirdAuthorizationsServiceImpl implements ThirdAuthorizationsService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    // 注入Service依赖
    @Autowired
    private ThirdAuthorizationsMapper thirdAuthorizationsDao;

    @Autowired
    private UserService userService;

    @Transactional
    public UserDto thirdLogin(ThirdLoginDto thirdInfo, String deviceToken) throws Exception {
        logger.debug(">> thirdLogin");
        if (thirdInfo == null) {
            throw new InvalidParamsException("三方信息不能为空");
        }

        if (deviceToken == null || deviceToken.length() == 0) {
            deviceToken = "none";
        }
        logger.debug(">> deviceToken = " + deviceToken);

        User user = thirdAuthorizationsDao.searchUserByThirdUid(thirdInfo.getUid());
        if (user != null) {
            // 更新本次登录时间
            user.setLoginTime(new Date());
            userService.update(user);

            UserDto dto = new UserDto();
            BeanUtils.copyProperties(dto, user);
            dto.setToken(CommonUtils.getTokenByUserId(user.getId(), deviceToken, CommonUtils.SCOPE_APP));
            return dto;
        }
        logger.debug("三方信息不存在，创建用户");

        // 先创建用户信息
        User newUser = new User();
        newUser.setNickname(thirdInfo.getNickname());
        newUser.setUuid(UUID.randomUUID().toString());
        newUser.setGender(thirdInfo.getGender());
        newUser.setAvatar(thirdInfo.getIconurl());
        newUser.setCoinQuantity(200);
        userService.create(newUser);

        newUser.setCreatedTime(new Date());
        newUser.setUpdatedTime(new Date());
        newUser.setLoginTime(new Date());

        // 再创建三方信息
        ThirdAuthorizations entity = new ThirdAuthorizations();
        entity.setThirdParty(thirdInfo.getThirdPartyName());
        entity.setThirdUid(thirdInfo.getUid());
        entity.setUserId(newUser.getId());
        if ("wechat".equals(thirdInfo.getThirdPartyName())) {
            entity.setWechatUnionid(thirdInfo.getUnionid());
        }
        this.create(entity);
        UserDto dto = new UserDto();
        BeanUtils.copyProperties(dto, newUser);
        dto.setToken(CommonUtils.getTokenByUserId(newUser.getId(), deviceToken, CommonUtils.SCOPE_APP));
        return dto;
    }

    /**
     * 根据id获得三方登录 Dto对象
     *
     * @param id
     * @return ThirdAuthorizationsDto
     */
    @Transactional
    public ThirdAuthorizationsDto getThirdAuthorizationsDtoById(Integer id) throws IllegalAccessException, InvocationTargetException {
        logger.debug(">> getThirdAuthorizationsDtoById(Integer id) id = " + id);
        ThirdAuthorizations entity = thirdAuthorizationsDao.selectByPrimaryKey(id);
        if (entity == null) {
            return null;
        }
        ThirdAuthorizationsDto dto = new ThirdAuthorizationsDto();
        BeanUtils.copyProperties(dto, entity);
        return dto;
    }

    /**
     * 根据id获得三方登录 Db Entity对象
     *
     * @param id
     * @return ThirdAuthorizations Db Entity
     */
    @Transactional
    public ThirdAuthorizations getEntityById(Integer id) {
        logger.debug(">> getEntityById(Integer id)");
        return thirdAuthorizationsDao.selectByPrimaryKey(id);
    }

    /**
     * 根据指定的参数对数据进行检索
     *
     * @return List<ThirdAuthorizationsDto>结果列表
     */
    @Transactional
    public List<ThirdAuthorizationsDto> searchThirdAuthorizationsDto(ThirdAuthorizations thirdAuthorizations) throws IllegalAccessException, InvocationTargetException {
        logger.debug(">> searchThirdAuthorizationsDto(ThirdAuthorizations thirdAuthorizations)");
        List<ThirdAuthorizations> searchResult;
        if (thirdAuthorizations == null) {
            searchResult = thirdAuthorizationsDao.selectAll();
        } else {
            searchResult = thirdAuthorizationsDao.select(thirdAuthorizations);
        }

        List<ThirdAuthorizationsDto> dtoResult = new ArrayList<>();
        for (ThirdAuthorizations u : searchResult) {
            ThirdAuthorizationsDto dto = new ThirdAuthorizationsDto();
            BeanUtils.copyProperties(dto, u);
            dtoResult.add(dto);
        }
        return dtoResult;
    }

    /**
     * 根据指定的参数对数据进行检索
     *
     * @return List<ThirdAuthorizations>结果列表
     */
    @Transactional
    public List<ThirdAuthorizations> searchThirdAuthorizations(ThirdAuthorizations thirdAuthorizations) throws IllegalAccessException, InvocationTargetException {
        logger.debug(">> searchThirdAuthorizations(ThirdAuthorizations thirdAuthorizations)");
        List<ThirdAuthorizations> searchResult;
        if (thirdAuthorizations == null) {
            searchResult = thirdAuthorizationsDao.selectAll();
        } else {
            searchResult = thirdAuthorizationsDao.select(thirdAuthorizations);
        }
        return searchResult;
    }


    /**
     * 创建三方登录对象
     *
     * @param thirdAuthorizations 三方登录 Db Entity对象
     */
    @Transactional
    public void create(ThirdAuthorizations thirdAuthorizations) throws Exception {
        logger.debug(">> create(ThirdAuthorizations thirdAuthorizations)");
        try {
            thirdAuthorizationsDao.insertSelective(thirdAuthorizations);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }
    }

    /**
     * 删除指定id的三方登录对象
     *
     * @param id 三方登录id
     */
    @Transactional
    public void deleteById(Integer id) {
        logger.debug(">> deleteById(Integer id)");
        thirdAuthorizationsDao.deleteByPrimaryKey(id);
    }

    /**
     * 更新指定id的三方登录对象为thirdAuthorizations
     *
     * @param thirdAuthorizations 需要更新的Db Entity对象
     */
    @Transactional
    public void update(ThirdAuthorizations thirdAuthorizations) throws Exception {
        logger.debug(">> update(ThirdAuthorizations thirdAuthorizations");
        try {
            thirdAuthorizationsDao.updateByPrimaryKeySelective(thirdAuthorizations);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }
    }
}
