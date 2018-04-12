package ${basepackage!""}.${subpackage!""};
import ${basepackage!""}.BaseTestCase;
import ${basepackage!""}.dto.${className!""}Dto;
import ${basepackage!""}.entity.${className!""};
import ${basepackage!""}.service.${className!""}Service;
import org.junit.Rule;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.rules.ExpectedException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static junit.framework.TestCase.assertTrue;

/**
 * THIS IS AUTO GENERATED SOURCE CODE
 *
 * ${className!""}Service Tester.
 *   Created by ${author!"org.openmore"}
 *      on ${.now?string("yyyy-MM-dd")}
 *
 * @author <Authors name>
 * @since <pre>${.now?string("yyyy-MM-dd")}</pre>
 * @version 1.0
 */
public class ${className!""}ServiceTest extends BaseTestCase{


    @Autowired
    private ${className!""}Service ${className?uncap_first}Service;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     *
     * Method: get${className!""}ById(@PathVariable @ApiParam(required = true, value = "${className_zn!""}id") Integer id)
     *
     */
    @Test
    public void testGet${className!""}ById() throws Exception {
        assertTrue(${className?uncap_first}Service != null);
        ${className!""}Dto ${className?uncap_first}Dto = ${className?uncap_first}Service.get${className!""}DtoById(1);
        assertTrue(${className?uncap_first}Dto != null);

        // 测试不存在的数据
        ${className?uncap_first}Service.get${className!""}DtoById(99999);
    }

    /**
     *
     * Method: search${className!""}(@RequestParam(required = false)  @ApiParam("${className_zn!""}对象") {className!""} {className!uncap_first})
     *
     */
    @Test
    public void testSearch${className!""}() throws Exception {
        List<${className!""}Dto> ${className?uncap_first}DtoList = ${className?uncap_first}Service.search${className!""}Dto(null);
        assertTrue(${className?uncap_first}DtoList != null && ${className?uncap_first}DtoList.size() > 0);
        List<${className!""}> ${className?uncap_first}List = ${className?uncap_first}Service.search${className!""}(null);
        assertTrue(${className?uncap_first}List != null && ${className?uncap_first}List.size() > 0);
    }

    /**
     *
     * Method: update{className!""}(@PathVariable @ApiParam(value = "${className_zn!""}id", required = true) Integer id, @RequestBody @ApiParam(value = "新${className_zn!""}信息", required = true) ${className!""} ${className?uncap_first})
     *
     */
    @Test
    public void testUpdate${className!""}() throws Exception {
        String testName = "new_test_${className?uncap_first}";
        ${className!""} ${className?uncap_first} = ${className?uncap_first}Service.getEntityById(1);
        assertTrue(${className?uncap_first} != null);
        // TODO: 实现自己的测试逻辑
//        ${className?uncap_first}.setName(testName);
        ${className?uncap_first}Service.update(${className?uncap_first});

        ${className?uncap_first} = ${className?uncap_first}Service.getEntityById(1);
        assertTrue(${className?uncap_first} != null);
        // TODO: 实现自己的测试逻辑
//        assertTrue(${className?uncap_first}.getName().equals(testName));
    }

    /**
     *
     * Method: create${className!""}(@RequestBody @ApiParam(value = "创建${className_zn!""}", required = true) ${className!""} ${className?uncap_first})
     *
     */
    @Test
    public void testCreate${className!""}() throws Exception {
        ${className!""} ${className?uncap_first} = new ${className!""}();
//        ${className?uncap_first}.setName("test${className?uncap_first}");
//        ${className?uncap_first}.setBrief("test brief");
//        ${className?uncap_first}.setPrice(100);
//        ${className?uncap_first}.setResourceUrl("testurl");
//        ${className?uncap_first}.setStatus((short)10);
        // TODO: 实现自己的业务
        ${className?uncap_first}Service.create(${className?uncap_first});
    }

    /**
     *
     * Method: delete${className!""}(@PathVariable @ApiParam(value = "${className_zn!""}id", required = true) Integer id)
     *
     */
    @Test
    public void testDelete${className!""}() throws Exception {
        ${className?uncap_first}Service.deleteById(1);
        // 测试不存在的数据
        ${className?uncap_first}Service.get${className!""}DtoById(1);
    }
}


