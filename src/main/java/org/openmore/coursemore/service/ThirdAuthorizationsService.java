package org.openmore.coursemore.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.openmore.coursemore.dto.ThirdAuthorizationsDto;
import org.openmore.coursemore.dto.ThirdLoginDto;
import org.openmore.coursemore.dto.UserDto;
import org.openmore.coursemore.entity.ThirdAuthorizations;
import org.openmore.common.exception.*;

/**
 * THIS IS AUTO GENERATED SOURCE CODE
 * Created by org.openmore.coursemore
 * on 2017-07-29
 */
public interface ThirdAuthorizationsService {

    /**
     * 三方登录，如果不存在，则创建用户
     *
     * @param thirdInfo
     * @return
     * @throws InvalidParamsException
     */
    UserDto thirdLogin(ThirdLoginDto thirdInfo, String deviceToken) throws Exception;

    /**
     * 根据id获得三方登录 Dto对象
     *
     * @param id
     * @return ThirdAuthorizationsDto
     */
    ThirdAuthorizationsDto getThirdAuthorizationsDtoById(Integer id) throws IllegalAccessException, InvocationTargetException;

    /**
     * 根据id获得三方登录 Db Entity对象
     *
     * @param id
     * @return ThirdAuthorizations Db Entity
     */
    ThirdAuthorizations getEntityById(Integer id);

    /**
     * 根据指定的参数对数据进行检索
     *
     * @return List<ThirdAuthorizationsDto>结果列表
     */
    List<ThirdAuthorizationsDto> searchThirdAuthorizationsDto(ThirdAuthorizations thirdAuthorizations) throws IllegalAccessException, InvocationTargetException;

    /**
     * 根据指定的参数对数据进行检索
     *
     * @return List<ThirdAuthorizations>结果列表
     */
    List<ThirdAuthorizations> searchThirdAuthorizations(ThirdAuthorizations thirdAuthorizations) throws IllegalAccessException, InvocationTargetException;

    /**
     * 创建三方登录对象
     *
     * @param thirdAuthorizations 三方登录 Db Entity对象
     */
    void create(ThirdAuthorizations thirdAuthorizations) throws Exception;

    /**
     * 删除指定id的三方登录对象
     *
     * @param id 三方登录id
     */
    void deleteById(Integer id);

    /**
     * 更新指定id的三方登录对象为thirdAuthorizations
     *
     * @param thirdAuthorizations 需要更新的Db Entity对象
     */
    void update(ThirdAuthorizations thirdAuthorizations) throws Exception;
}
