package org.openmore.coursemore.service.impl;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.openmore.coursemore.service.SystemConfigService;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.openmore.coursemore.dto.SystemConfigDto;
import org.openmore.coursemore.dao.SystemConfigMapper;
import org.openmore.coursemore.entity.SystemConfig;

/**
 * THIS IS AUTO GENERATED SOURCE CODE
 * Created by org.openmore.coursemore
 * on 2017-07-23
 */
@Service
public class SystemConfigServiceImpl implements SystemConfigService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    // 注入Service依赖
    @Autowired
    private SystemConfigMapper systemConfigDao;

    /**
     * 根据id获得系统配置 Dto对象
     *
     * @param id
     * @return SystemConfigDto
     */
    @Transactional
    public SystemConfigDto getSystemConfigDtoById(Integer id) throws IllegalAccessException, InvocationTargetException {
        logger.debug(">> getSystemConfigDtoById(Integer id) id = " + id);
        SystemConfig entity = systemConfigDao.selectByPrimaryKey(id);
        if (entity == null) {
            return null;
        }
        SystemConfigDto dto = new SystemConfigDto();
        BeanUtils.copyProperties(dto, entity);
        return dto;
    }

    /**
     * 根据id获得系统配置 Db Entity对象
     *
     * @param id
     * @return SystemConfig Db Entity
     */
    @Transactional
    public SystemConfig getEntityById(Integer id) {
        logger.debug(">> getEntityById(Integer id)");
        return systemConfigDao.selectByPrimaryKey(id);
    }


    /**
     * 根据configName获得系统配置 Db Entity对象
     *
     * @param configName
     * @return SystemConfig Db Entity
     */
    @Transactional
    public SystemConfig getEntityByName(String configName) {
        logger.debug(">> getEntityByName(configName");
        return systemConfigDao.getConfigByName(configName);
    }

    /**
     * 根据指定的参数对数据进行检索
     *
     * @return List<SystemConfigDto>结果列表
     */
    @Transactional
    public List<SystemConfigDto> searchSystemConfigDto(SystemConfig systemConfig) throws IllegalAccessException, InvocationTargetException {
        logger.debug(">> searchSystemConfigDto(SystemConfig systemConfig)");
        List<SystemConfig> searchResult;
        if (systemConfig == null) {
            searchResult = systemConfigDao.selectAll();
        } else {
            searchResult = systemConfigDao.select(systemConfig);
        }

        List<SystemConfigDto> dtoResult = new ArrayList<>();
        for (SystemConfig u : searchResult) {
            SystemConfigDto dto = new SystemConfigDto();
            BeanUtils.copyProperties(dto, u);
            dtoResult.add(dto);
        }
        return dtoResult;
    }

    /**
     * 根据指定的参数对数据进行检索
     *
     * @return List<SystemConfig>结果列表
     */
    @Transactional
    public List<SystemConfig> searchSystemConfig(SystemConfig systemConfig) throws IllegalAccessException, InvocationTargetException {
        logger.debug(">> searchSystemConfig(SystemConfig systemConfig)");
        List<SystemConfig> searchResult;
        if (systemConfig == null) {
            searchResult = systemConfigDao.selectAll();
        } else {
            searchResult = systemConfigDao.select(systemConfig);
        }
        return searchResult;
    }


    /**
     * 创建系统配置对象
     *
     * @param systemConfig 系统配置 Db Entity对象
     */
    @Transactional
    public void create(SystemConfig systemConfig) throws Exception {
        logger.debug(">> create(SystemConfig systemConfig)");
        try {
            systemConfigDao.insertSelective(systemConfig);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }
    }

    /**
     * 删除指定id的系统配置对象
     *
     * @param id 系统配置id
     */
    @Transactional
    public void deleteById(Integer id) {
        logger.debug(">> deleteById(Integer id)");
        systemConfigDao.deleteByPrimaryKey(id);
    }

    /**
     * 更新指定id的系统配置对象为systemConfig
     *
     * @param systemConfig 需要更新的Db Entity对象
     */
    @Transactional
    public void update(SystemConfig systemConfig) throws Exception {
        logger.debug(">> update(SystemConfig systemConfig");
        // updateByPrimaryKeySelective only update field not null.
        try {
            systemConfigDao.updateByPrimaryKeySelective(systemConfig);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }
    }
}
