package ${basepackage!""}.${subpackage!""};

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import ${basepackage!""}.dto.${className}Dto;
import ${basepackage!""}.entity.${className};

/**
 * THIS IS AUTO GENERATED SOURCE CODE
 *   Created by ${author!"org.openmore"}
 *      on ${.now?string("yyyy-MM-dd")}
 */
public interface ${className!""}Service {

    /**
     * 根据id获得${className_zn} Dto对象
     * @param id
     * @return ${className}Dto
     */
    ${className}Dto get${className}DtoById(Integer id) throws IllegalAccessException, InvocationTargetException;

    /**
     * 根据id获得${className_zn} Db Entity对象
     * @param id
     * @return ${className} Db Entity
     */
    ${className} getEntityById(Integer id);


    /**
     * 返回指定分页的所有信息
     * @return List<${className}>分页结果列表
     */
    List<${className}> getAllByPage(Integer pageNum, Integer pageSize) throws IllegalAccessException, InvocationTargetException;

    /**
     * 根据指定的参数对数据进行检索
     * @return List<${className}Dto>结果列表
     */
    List<${className}Dto> search${className}Dto(${className} ${className?uncap_first}) throws IllegalAccessException, InvocationTargetException;

    /**
     * 根据指定的参数对数据进行检索
     * @return List<${className}>结果列表
     */
    List<${className}> search${className}(${className} ${className?uncap_first}) throws IllegalAccessException, InvocationTargetException;

    /**
     * 创建${className_zn}对象
     * @param ${className?uncap_first} ${className_zn} Db Entity对象
     */
    void create(${className} ${className?uncap_first}) throws Exception;

    /**
     * 删除指定id的${className_zn}对象
     * @param id ${className_zn}id
     */
    void deleteById(Integer id);

    /**
     * 更新指定id的${className_zn}对象为${className?uncap_first}
     * @param ${className?uncap_first} 需要更新的Db Entity对象
     */
    void update(${className} ${className?uncap_first}) throws Exception;
}
