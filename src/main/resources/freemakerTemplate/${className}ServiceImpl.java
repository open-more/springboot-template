package ${basepackage!""}.${subpackage!""}.impl;

import com.github.pagehelper.PageHelper;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import ${basepackage!""}.${subpackage!""}.${className!""}Service;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ${basepackage!""}.dto.${className!""}Dto;
import ${basepackage!""}.dao.${className!""}Mapper;
import ${basepackage!""}.entity.${className!""};

/**
 * THIS IS AUTO GENERATED SOURCE CODE
 *   Created by ${author!"org.openmore"}
 *      on ${.now?string("yyyy-MM-dd")}
 */
@Service
public class ${className}ServiceImpl implements ${className}Service{
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    // 注入Service依赖
    @Autowired
    private ${className!""}Mapper ${className?uncap_first}Dao;

    /**
     * 根据id获得${className_zn} Dto对象
     * @param id
     * @return ${className}Dto
     */
    @Transactional
    public ${className}Dto get${className}DtoById(Integer id) throws IllegalAccessException, InvocationTargetException
    {
        logger.debug(">> get${className}DtoById(Integer id) id = " + id);
        ${className} entity = ${className?uncap_first}Dao.selectByPrimaryKey(id);
        if(entity == null){
            return null;
        }
        ${className}Dto dto = new ${className}Dto();
        BeanUtils.copyProperties(dto, entity);
        return dto;
    }

    /**
     * 根据id获得${className_zn} Db Entity对象
     * @param id
     * @return ${className} Db Entity
     */
    @Transactional
    public ${className} getEntityById(Integer id)
    {
        logger.debug(">> getEntityById(Integer id)");
        return ${className?uncap_first}Dao.selectByPrimaryKey(id);
    }

    /**
     * 返回指定分页的所有信息
     * @return List<${className}>分页结果列表
     */
    @Transactional
    public List<${className}> getAllByPage(Integer pageNum, Integer pageSize) throws IllegalAccessException, InvocationTargetException
    {
        logger.debug(">> getAllByPage()");
        List<${className}> searchResult;
        PageHelper.startPage(pageNum, pageSize);
        searchResult = ${className?uncap_first}Dao.selectAll();
        return searchResult;
    }


    /**
     * 根据指定的参数对数据进行检索
     * @return List<${className}Dto>结果列表
     */
    @Transactional
    public List<${className}Dto> search${className}Dto(${className} ${className?uncap_first}) throws IllegalAccessException, InvocationTargetException
    {
        logger.debug(">> search${className}Dto(${className} ${className?uncap_first})");
        List<${className}> searchResult;
        if(${className?uncap_first} == null){
            searchResult = ${className?uncap_first}Dao.selectAll();
        }else{
            searchResult = ${className?uncap_first}Dao.select(${className?uncap_first});
        }

        List<${className}Dto> dtoResult = new ArrayList<>();
        for(${className} u : searchResult)
        {
            ${className}Dto dto = new ${className}Dto();
            BeanUtils.copyProperties(dto, u);
            dtoResult.add(dto);
        }
        return dtoResult;
    }

    /**
     * 根据指定的参数对数据进行检索
     * @return List<${className}>结果列表
     */
    @Transactional
    public List<${className}> search${className}(${className} ${className?uncap_first}) throws IllegalAccessException, InvocationTargetException
    {
        logger.debug(">> search${className}(${className} ${className?uncap_first})");
        List<${className}> searchResult;
        if(${className?uncap_first} == null){
            searchResult = ${className?uncap_first}Dao.selectAll();
        }else{
            searchResult = ${className?uncap_first}Dao.select(${className?uncap_first});
        }
        return searchResult;
    }


/**
 * 创建${className_zn}对象
 * @param ${className?uncap_first} ${className_zn} Db Entity对象
 */
    @Transactional
    public void create(${className} ${className?uncap_first}) throws Exception
    {
        logger.debug(">> create(${className} ${className?uncap_first})");
        try{
            ${className?uncap_first}Dao.insertSelective(${className?uncap_first});
        }catch (Exception e){
            logger.error(e.getMessage());
            throw e;
        }
    }

    /**
     * 删除指定id的${className_zn}对象
     * @param id ${className_zn}id
     */
    @Transactional
    public void deleteById(Integer id)
    {
        logger.debug(">> deleteById(Integer id)");
        ${className?uncap_first}Dao.deleteByPrimaryKey(id);
    }

    /**
     * 更新指定id的${className_zn}对象为${className?uncap_first}
     * @param ${className?uncap_first} 需要更新的Db Entity对象
     */
    @Transactional
    public void update(${className} ${className?uncap_first}) throws Exception
    {
        logger.debug(">> update(${className} ${className?uncap_first}");
        // updateByPrimaryKeySelective only update field not null.
        try{
            ${className?uncap_first}Dao.updateByPrimaryKeySelective(${className?uncap_first});
        }catch (Exception e){
            logger.error(e.getMessage());
            throw e;
        }
    }
}
