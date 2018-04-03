package org.openmore.coursemore.controller.test.api;

import org.junit.Test;
import org.openmore.coursemore.BaseTestCase;
import org.openmore.common.exception.*
import org.openmore.common.utils.*;
import org.openmore.coursemore.dto.ThirdLoginDto;
import org.openmore.coursemore.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

import org.openmore.coursemore.service.*;

import static junit.framework.TestCase.assertTrue;

/**
 * AccountController Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>七月 30, 2017</pre>
 */
public class AccountControllerTest extends BaseTestCase {
    @Autowired
    private UserService userService;

    @Autowired
    private ThirdAuthorizationsService thirdAuthorizationsService;

//    @Autowired
//    private RedisOps redisOps;

    /**
     * Method: sendCaptchaCode(@PathVariable @ApiParam(required = true, value = "手机号，国际电话:+86xxx") String mobile)
     */
    @Test
    public void testSendCaptchaCode() throws Exception {
//    String resultMessage = smsService.sendCaptchaCode("13520664663");
//    redisOps.set("13520664663", "1234", 60);
//    String value = redisOps.get("13520664663");
//    assertTrue("1234".equals(value));
    }

    /**
     * Method: verifyCaptchaCode(@PathVariable @ApiParam(required = true, value = "手机号，国际电话:+86xxx") String mobile, @PathVariable @ApiParam(required = true, value = "4位验证码") String captcha)
     */
    @Test
    public void testVerifyCaptchaCode() throws Exception {
//    assertTrue(smsService.verifyCaptchaCode("13520664663", "998877"));
    }

    /**
     * Method: thirdPartyLogin(@RequestBody @ApiParam(required = true, value = "三方登录信息") ThirdLoginDto thirdLogin)
     */
    @Test
    public void testThirdPartyLogin() throws Exception {
        ThirdLoginDto dto = new ThirdLoginDto();
        dto.setUid(UUID.randomUUID().toString());
        dto.setNickname("testuser" + CommonUtils.randomString(6));
        dto.setThirdPartyName("qq");
        UserDto user = thirdAuthorizationsService.thirdLogin(dto, "none");
        assertTrue(user != null);
    }

    /**
     * Method: bindMobile(@PathVariable @ApiParam(required = true, value = "手机号") String mobile)
     */
    @Test
    public void testBindMobile() throws Exception {
        try {
            userService.bindMobile("13520664663");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            assertTrue(false);
        }
    }

    /**
     * Method: loginByToken()
     */
    @Test
    public void testLoginByToken() throws Exception {
        try {
            UserDto user = userService.tokenLogin("test_device_token");
        } catch (InvalidParamsException e) {
            assertTrue("用户信息不存在".equals(e.getMsg()));
        }
    }


    /**
     * Method: mobileLogin()
     */
    @Test
    public void testMobileLogin() throws Exception {
        UserDto user = userService.mobileLogin("13520664663", "test_device_token");
        user = userService.mobileLogin("13520888888", "test_device_token");
    }

    /**
     * Method: changeNickname()
     */
    @Test
    public void testChangeNickname() throws Exception {
        userService.changeNickname("new test_device_token");
    }
}
