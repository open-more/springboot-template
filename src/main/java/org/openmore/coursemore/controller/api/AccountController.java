package org.openmore.coursemore.controller.api;

import org.openmore.common.exception.*;
import org.openmore.common.annotation.TokenAuthCheck;
import org.openmore.coursemore.controller.common.BaseController;
import org.openmore.coursemore.dto.ThirdLoginDto;
import org.openmore.coursemore.dto.UserDto;
import org.openmore.coursemore.dto.common.ErrorResponseEntity;
import org.openmore.coursemore.service.SmsService;
import org.openmore.coursemore.service.ThirdAuthorizationsService;
import org.openmore.coursemore.service.UserService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

/**
 * THIS IS AUTO GENERATED SOURCE CODE
 * Created by org.openmore.coursemore
 * on 2017-07-30
 */
@Api(value = "/Account", tags = "Account", description = "用户账户控制器-账户登录相关")
@RequestMapping(value = "/api/account", produces = {APPLICATION_JSON_UTF8_VALUE})
@RestController
public class AccountController extends BaseController {

    @Autowired
    private SmsService smsService;

    @Autowired
    private UserService userService;

    @Autowired
    private ThirdAuthorizationsService thirdAuthorizationsService;

    @ApiOperation(value = "向指定手机号发送4位数字验证码", response = String.class)
    @ApiResponses(value = {@ApiResponse(code = 400, message = "请求失败：短信服务商返回错误信息", response = ErrorResponseEntity.class)})
    @RequestMapping(method = RequestMethod.GET, value = "/sendCaptcha/{mobile}")
    public ResponseEntity sendCaptchaCode(@PathVariable @ApiParam(required = true, value = "手机号，国际电话:+86xxx") String mobile) {
        logger.debug(">> sendCaptchaCode");
        String resultMessage;
        try {
            resultMessage = smsService.sendCaptchaCode(mobile);
            logger.debug(resultMessage);
        } catch (Exception e) {
            throw new InvalidParamsException("请求失败：" + e.getMessage());
        }
        return new ResponseEntity(resultMessage, HttpStatus.OK);
    }

    @ApiOperation(value = "验证验证码有效性")
    @ApiResponses(value = {@ApiResponse(code = 400, message = "请求失败：验证码不正确，请重新发送", response = ErrorResponseEntity.class)})
    @RequestMapping(method = RequestMethod.GET, value = "/verifyCaptcha/{mobile}/{captcha}")
    public void verifyCaptchaCode(@PathVariable @ApiParam(required = true, value = "手机号，国际电话:+86xxx") String mobile,
                                  @PathVariable @ApiParam(required = true, value = "4位验证码") String captcha) {
        logger.debug(">> verifyCaptchaCode");
        try {
            smsService.verifyCaptchaCode(mobile, captcha);
        } catch (InvalidParamsException e) {
            throw e;
        } catch (Exception e) {
            throw new InvalidParamsException("请求失败：" + e.getMessage());
        }
    }

    @ApiOperation(value = "手机号验证码快速登录/注册")
    @ApiResponses(value = {@ApiResponse(code = 400, message = "请求失败：验证码不正确，请重新发送", response = UserDto.class)})
    @RequestMapping(method = RequestMethod.GET, value = "/mobileLogin/{mobile}/{captcha}")
    public ResponseEntity mobileLogin(@PathVariable @ApiParam(required = true, value = "手机号，国际电话:+86xxx") String mobile,
                                      @PathVariable @ApiParam(required = true, value = "4位验证码") String captcha) {
        logger.debug(">> mobileLogin");
        try {
            smsService.verifyCaptchaCode(mobile, captcha);
            String deviceToken = request.getHeader("X-DEVICE_TOKEN");
            UserDto dto = userService.mobileLogin(mobile, deviceToken);
            return new ResponseEntity(dto, HttpStatus.OK);
        } catch (InvalidParamsException e) {
            throw e;
        } catch (Exception e) {
            throw new InvalidParamsException("请求失败：" + e.getMessage());
        }
    }

    @ApiOperation(value = "三方登录，如果不存在，则创建用户，支持：微信、微博、QQ", response = UserDto.class)
    @ApiResponses(value = {@ApiResponse(code = 400, message = "请求失败：三方登录失败", response = ErrorResponseEntity.class)})
    @RequestMapping(method = RequestMethod.POST, value = "/thirdPartyAuthLogin")
    public ResponseEntity thirdPartyLogin(@RequestBody @ApiParam(required = true, value = "三方登录信息") ThirdLoginDto thirdLogin) {
        logger.debug(">> thirdPartyAuthLogin");
        String deviceToken = request.getHeader("X-DEVICE_TOKEN");
        UserDto user;
        try {
            user = thirdAuthorizationsService.thirdLogin(thirdLogin, deviceToken);
        } catch (Exception e) {
            throw new InvalidParamsException("请求失败：" + e.getMessage());
        }
        return new ResponseEntity(user, HttpStatus.OK);
    }

    @TokenAuthCheck
    @ApiOperation(value = "将手机绑定到当前的用户账户上(需要token)", response = UserDto.class)
    @ApiResponses(value = {@ApiResponse(code = 400, message = "请求失败：手机绑定失败", response = ErrorResponseEntity.class)})
    @RequestMapping(method = RequestMethod.PUT, value = "/bindMobile/{mobile}")
    public ResponseEntity bindMobile(@PathVariable @ApiParam(required = true, value = "手机号") String mobile) {
        logger.debug(">> bindMobile");
        // 检查授权
        UserDto user = null;
        try {
            user = userService.bindMobile(mobile);
        } catch (Exception e) {
            throw new InvalidParamsException("请求失败：" + e.getMessage());
        }
        return new ResponseEntity(user, HttpStatus.OK);
    }

    @TokenAuthCheck
    @ApiOperation(value = "登录后保存token，下次启动直接使用token登录(需要token)", response = UserDto.class)
    @ApiResponses(value = {@ApiResponse(code = 401, message = "请求失败：登录失败", response = ErrorResponseEntity.class)})
    @RequestMapping(method = RequestMethod.POST, value = "/loginByToken")
    public ResponseEntity loginByToken() {
        logger.debug(">> loginByToken");
        UserDto user;
        String deviceToken = request.getHeader("X-DEVICE_TOKEN");
        try {
            user = userService.tokenLogin(deviceToken);
        } catch (Exception e) {
            throw new InvalidParamsException("请求失败：" + e.getMessage());
        }
        return new ResponseEntity(user, HttpStatus.OK);
    }

    @TokenAuthCheck
    @ApiOperation(value = "修改当前用户的昵称(需要token)", response = UserDto.class)
    @ApiResponses(value = {@ApiResponse(code = 400, message = "请求失败：手机绑定失败", response = ErrorResponseEntity.class)})
    @RequestMapping(method = RequestMethod.PUT, value = "/nickname/{nickname}")
    public ResponseEntity changeNickname(@PathVariable @ApiParam(required = true, value = "昵称") String nickname) {
        logger.debug(">> changeNickname");
        // 检查授权
        UserDto user = null;
        try {
            user = userService.changeNickname(nickname);
        } catch (Exception e) {
            throw new InvalidParamsException("请求失败：" + e.getMessage());
        }
        return new ResponseEntity(user, HttpStatus.OK);
    }
}




