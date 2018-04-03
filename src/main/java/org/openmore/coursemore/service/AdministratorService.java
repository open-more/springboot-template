package org.openmore.coursemore.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.openmore.common.shiro.IAdministratorService;
import org.openmore.coursemore.dto.AdministratorDto;
import org.openmore.coursemore.entity.Administrator;

/**
 * THIS IS AUTO GENERATED SOURCE CODE
 * Created by org.openmore.coursemore
 * on 2017-07-23
 */
public interface AdministratorService extends IAdministratorService<Administrator>{

    /**
     * 根据id获得后台管理员 Dto对象
     *
     * @param id
     * @return AdministratorDto
     */
    AdministratorDto getAdministratorDtoById(Integer id) throws IllegalAccessException, InvocationTargetException;

    /**
     * 根据id获得后台管理员 Db Entity对象
     *
     * @param id
     * @return Administrator Db Entity
     */
    Administrator getEntityById(Integer id);

    /**
     * 根据指定的参数对数据进行检索
     *
     * @return List<AdministratorDto>结果列表
     */
    List<AdministratorDto> searchAdministratorDto(Administrator administrator) throws IllegalAccessException, InvocationTargetException;

    /**
     * 根据指定的参数对数据进行检索
     *
     * @return List<Administrator>结果列表
     */
    List<Administrator> searchAdministrator(String email) throws IllegalAccessException, InvocationTargetException;

    /**
     * 创建后台管理员对象
     *
     * @param administrator 后台管理员 Db Entity对象
     */
    void create(Administrator administrator) throws Exception;

    /**
     * 删除指定id的后台管理员对象
     *
     * @param id 后台管理员id
     */
    void deleteById(Integer id);

    /**
     * 更新指定id的后台管理员对象为administrator
     *
     * @param administrator 需要更新的Db Entity对象
     */
    void update(Administrator administrator) throws Exception;

    /**
     * 管理员登录
     *
     * @param admin
     * @return
     */
    AdministratorDto login(Administrator admin) throws Exception;
}
