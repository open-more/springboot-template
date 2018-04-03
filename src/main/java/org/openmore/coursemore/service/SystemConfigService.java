package org.openmore.coursemore.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.openmore.coursemore.dto.SystemConfigDto;
import org.openmore.coursemore.entity.SystemConfig;

/**
 * THIS IS AUTO GENERATED SOURCE CODE
 * Created by org.openmore.coursemore
 * on 2017-07-23
 */
public interface SystemConfigService {

    /**
     * 根据id获得系统配置 Dto对象
     *
     * @param id
     * @return SystemConfigDto
     */
    SystemConfigDto getSystemConfigDtoById(Integer id) throws IllegalAccessException, InvocationTargetException;

    /**
     * 根据id获得系统配置 Db Entity对象
     *
     * @param id
     * @return SystemConfig Db Entity
     */
    SystemConfig getEntityById(Integer id);

    /**
     * 根据configName获得系统配置 Db Entity对象
     *
     * @param configName
     * @return SystemConfig Db Entity
     */
    SystemConfig getEntityByName(String configName);

    /**
     * 根据指定的参数对数据进行检索
     *
     * @return List<SystemConfigDto>结果列表
     */
    List<SystemConfigDto> searchSystemConfigDto(SystemConfig systemConfig) throws IllegalAccessException, InvocationTargetException;


    /**
     * 根据指定的参数对数据进行检索
     *
     * @return List<SystemConfig>结果列表
     */
    List<SystemConfig> searchSystemConfig(SystemConfig systemConfig) throws IllegalAccessException, InvocationTargetException;

    /**
     * 创建系统配置对象
     *
     * @param systemConfig 系统配置 Db Entity对象
     */
    void create(SystemConfig systemConfig) throws Exception;

    /**
     * 删除指定id的系统配置对象
     *
     * @param id 系统配置id
     */
    void deleteById(Integer id);

    /**
     * 更新指定id的系统配置对象为systemConfig
     *
     * @param systemConfig 需要更新的Db Entity对象
     */
    void update(SystemConfig systemConfig) throws Exception;
}
