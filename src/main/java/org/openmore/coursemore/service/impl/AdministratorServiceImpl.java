package org.openmore.coursemore.service.impl;

import org.apache.commons.beanutils.BeanUtils;
import org.openmore.coursemore.dao.AdministratorMapper;
import org.openmore.coursemore.entity.Administrator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.openmore.coursemore.service.AdministratorService;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.openmore.coursemore.dto.AdministratorDto;
import org.springframework.util.StringUtils;

import org.openmore.common.exception.*;
import org.openmore.common.utils.*;


/**
 * THIS IS AUTO GENERATED SOURCE CODE
 * Created by org.openmore.coursemore
 * on 2017-07-23
 */
@Service
public class AdministratorServiceImpl implements AdministratorService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    // 注入Service依赖
    @Autowired
    private AdministratorMapper administratorDao;

    /**
     * 根据id获得后台管理员 Dto对象
     *
     * @param id
     * @return AdministratorDto
     */
    @Transactional
    public AdministratorDto getAdministratorDtoById(Integer id) throws IllegalAccessException, InvocationTargetException {
        logger.debug(">> getAdministratorDtoById(Integer id) id = " + id);
        Administrator entity = administratorDao.selectByPrimaryKey(id);
        if (entity == null) {
            return null;
        }
        AdministratorDto dto = new AdministratorDto();
        BeanUtils.copyProperties(dto, entity);
        return dto;
    }

    /**
     * 根据id获得后台管理员 Db Entity对象
     *
     * @param id
     * @return Administrator Db Entity
     */
    @Transactional
    public Administrator getEntityById(Integer id) {
        logger.debug(">> getEntityById(Integer id)");
        return administratorDao.selectByPrimaryKey(id);
    }

    /**
     * 根据指定的参数对数据进行检索
     *
     * @return List<AdministratorDto>结果列表
     */
    @Transactional
    public List<AdministratorDto> searchAdministratorDto(Administrator administrator) throws IllegalAccessException, InvocationTargetException {
        logger.debug(">> searchAdministratorDto(Administrator administrator)");
        List<Administrator> searchResult;
        if (administrator == null) {
            searchResult = administratorDao.selectAll();
        } else {
            searchResult = administratorDao.select(administrator);
        }

        List<AdministratorDto> dtoResult = new ArrayList<>();
        for (Administrator u : searchResult) {
            AdministratorDto dto = new AdministratorDto();
            BeanUtils.copyProperties(dto, u);
            dtoResult.add(dto);
        }
        return dtoResult;
    }

    /**
     * 根据指定的参数对数据进行检索
     *
     * @return List<Administrator>结果列表
     */
    @Transactional
    public List<Administrator> searchAdministrator(String email) throws IllegalAccessException, InvocationTargetException {
        logger.debug(">> searchAdministrator(Administrator administrator)");
        List<Administrator> searchResult;
        if (StringUtils.isEmpty(email)) {
            searchResult = administratorDao.selectAll();
        } else {
            searchResult = administratorDao.selectByEmail(email);
        }
        return searchResult;
    }


    /**
     * 创建后台管理员对象
     *
     * @param administrator 后台管理员 Db Entity对象
     */
    @Transactional
    public void create(Administrator administrator) throws Exception {
        logger.debug(">> create(Administrator administrator)");
        try {
            // 密码加密
            administrator.setPassword(CommonUtils.md5(administrator.getPassword()));
            administratorDao.insertSelective(administrator);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }
    }

    /**
     * 删除指定id的后台管理员对象
     *
     * @param id 后台管理员id
     */
    @Transactional
    public void deleteById(Integer id) {
        logger.debug(">> deleteById(Integer id)");
        administratorDao.deleteByPrimaryKey(id);
    }

    /**
     * 更新指定id的后台管理员对象为administrator
     *
     * @param administrator 需要更新的Db Entity对象
     */
    @Transactional
    public void update(Administrator administrator) throws Exception {
        logger.debug(">> update(Administrator administrator");
        // updateByPrimaryKeySelective only update field not null.
        try {
            String password = administrator.getPassword();
            if (password != null && password.length() > 0) {
                administrator.setPassword(CommonUtils.md5(password));
            }
            administratorDao.updateByPrimaryKeySelective(administrator);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }
    }


    /**
     * 管理员登录
     *
     * @param admin
     * @return
     */
    @Transactional
    public AdministratorDto login(Administrator admin) throws Exception {
        logger.debug(">> login()");
        if (admin.getAccount() == null || admin.getPassword() == null
                || admin.getAccount().length() <= 0 || admin.getPassword().length() <= 0) {
            throw new InvalidParamsException("用户名或密码不能为空");
        }
        Administrator entity = administratorDao.login(admin.getAccount(), CommonUtils.md5(admin.getPassword()));
        if (entity == null) {
            throw new InvalidParamsException("用户名或密码不正确");
        }
        AdministratorDto dto = new AdministratorDto();
        BeanUtils.copyProperties(dto, entity);
        dto.setToken(CommonUtils.getTokenByUserId(entity.getId(), "none", CommonUtils.SCOPE_BACKEND));
        return dto;
    }
}
