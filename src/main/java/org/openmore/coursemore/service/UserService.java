package org.openmore.coursemore.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.openmore.common.shiro.IUserService;
import org.openmore.coursemore.dto.UserDto;
import org.openmore.coursemore.entity.User;

/**
 * THIS IS AUTO GENERATED SOURCE CODE
 * Created by org.openmore.coursemore
 * on 2017-07-23
 */
public interface UserService extends IUserService<User>{

    /**
     * 根据id获得用户 Dto对象
     *
     * @param id
     * @return UserDto
     */
    UserDto getUserDtoById(Integer id) throws IllegalAccessException, InvocationTargetException;

    /**
     * 根据id获得用户 Db Entity对象
     *
     * @param id
     * @return User Db Entity
     */
    User getEntityById(Integer id);

    /**
     * 根据指定的参数对数据进行检索
     *
     * @return List<UserDto>结果列表
     */
    List<UserDto> searchUserDto(User user) throws IllegalAccessException, InvocationTargetException;

    /**
     * 根据指定的参数对数据进行检索
     *
     * @return List<User>结果列表
     */
    List<User> searchUser(String nickname, String mobile) throws IllegalAccessException, InvocationTargetException;

    /**
     * 根据指定的参数对数据进行分页检索
     *
     * @return List<User>结果列表
     */
    List<User> searchUserByPage(String nickname, String mobile, Integer pageNum, Integer pageSize) throws IllegalAccessException, InvocationTargetException;

    /**
     * 创建用户对象
     *
     * @param user 用户 Db Entity对象
     */
    void create(User user) throws Exception;

    /**
     * 删除指定id的用户对象
     *
     * @param id 用户id
     */
    void deleteById(Integer id);

    /**
     * 更新用户金币数量
     *
     * @param uid    需要更新的Db Entity对象
     * @param amount 需要更新的Db Entity对象
     */
    void updateCoin(Integer uid, Integer amount) throws Exception;

    /**
     * 更新指定id的用户对象为user
     *
     * @param user 需要更新的Db Entity对象
     */
    void update(User user) throws Exception;

    /**
     * 登录后，app保存token，下次登录使用token登录，并换取新的tokne
     *
     * @param deviceToken
     * @return
     * @throws Exception
     */
    UserDto tokenLogin(String deviceToken) throws Exception;

    /**
     * 为当前登录的用户绑定手机
     *
     * @param mobile
     * @return
     * @throws Exception
     */
    UserDto bindMobile(String mobile) throws Exception;


    /**
     * 手机号登录/注册
     *
     * @param mobile
     * @param deviceToken
     * @return
     * @throws Exception
     */
    UserDto mobileLogin(String mobile, String deviceToken) throws Exception;

    /**
     * 修改用户昵称
     *
     * @param nickname
     * @return
     * @throws Exception
     */
    UserDto changeNickname(String nickname) throws Exception;
}
