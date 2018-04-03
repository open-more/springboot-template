package org.openmore.coursemore.controller.test.backend;

import org.openmore.coursemore.BaseTestCase;
import org.openmore.coursemore.dto.AdministratorDto;
import org.openmore.coursemore.entity.Administrator;
import org.openmore.coursemore.service.AdministratorService;
import org.openmore.common.utils.*;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static junit.framework.TestCase.assertTrue;

/**
 * AdministratorController Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>八月 13, 2017</pre>
 */
public class AdministratorControllerTest extends BaseTestCase {
    @Autowired
    private AdministratorService administratorService;

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: getAdministratorById(@PathVariable @ApiParam(required = true, value = "后台管理员id") Integer id)
     */
    @Test
    public void testGetAdministratorById() throws Exception {
        AdministratorDto dto = administratorService.getAdministratorDtoById(1);
        assertTrue(dto != null);
    }

    /**
     * Method: searchAdministrator(@RequestParam(required = false)  @ApiParam("后台管理员对象") Administrator administrator)
     */
    @Test
    public void testSearchAdministrator() throws Exception {
        List<Administrator> list = administratorService.searchAdministrator("michaeltang");
        assertTrue(list.size() == 1);
    }

    /**
     * Method: updateAdministrator(@PathVariable @ApiParam(value = "后台管理员id", required = true) Integer id, @RequestBody @ApiParam(value = "新后台管理员信息", required = true) Administrator administrator)
     */
    @Test
    public void testUpdateAdministrator() throws Exception {
        String userToken = CommonUtils.getTokenByUserId(1, "none", CommonUtils.SCOPE_BACKEND);
        this.logintWithToken(userToken, "none");

        Administrator admin = administratorService.getEntityById(1);
        admin.setUsername("new user name");
        administratorService.update(admin);
        AdministratorDto dto = administratorService.getAdministratorDtoById(1);
        assertTrue(dto.getUsername().equals("new user name"));
    }

    /**
     * Method: createAdministrator(@RequestBody @ApiParam(value = "创建后台管理员", required = true) Administrator administrator)
     */
    @Test
    public void testCreateAdministrator() throws Exception {
        String userToken = CommonUtils.getTokenByUserId(1, "none", CommonUtils.SCOPE_BACKEND);
        this.logintWithToken("none", userToken);

        Administrator admin = new Administrator();
        admin.setAccount("new@openmore.org");
        admin.setPassword("111111");
        admin.setUsername("newUserName");
        admin.setStatus((short) 10);
        administratorService.create(admin);
    }

    /**
     * Method: deleteAdministrator(@PathVariable @ApiParam(value = "后台管理员id", required = true) Integer id)
     */
    @Test
    public void testDeleteAdministrator() throws Exception {
        String userToken = CommonUtils.getTokenByUserId(1, "none", CommonUtils.SCOPE_BACKEND);
        this.logintWithToken("none", userToken);
        administratorService.deleteById(1);
    }

    /**
     * Method: login(@RequestBody @ApiParam(value = "管理员dto，只需要account和password", required = true) Administrator admin)
     */
    @Test
    public void testLogin() throws Exception {
        Administrator admin = new Administrator();
        admin.setAccount("michaeltang@openmore.org");
        admin.setPassword("123456");
        AdministratorDto dto = administratorService.login(admin);
        assertTrue(dto != null);
    }


} 
