package org.openmore.coursemore.controller.api;

import org.openmore.coursemore.controller.common.BaseController;
import org.openmore.coursemore.dto.common.ErrorResponseEntity;
import org.openmore.coursemore.service.PaymentService;
import org.openmore.common.exception.*;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

/**
 * THIS IS AUTO GENERATED SOURCE CODE
 * Created by org.openmore.coursemore
 * on 2017-10-17
 */
@Api(value = "/payment", tags = "Payment", description = "支付相关接口")
@RequestMapping(value = "/api/payment", produces = {APPLICATION_JSON_UTF8_VALUE})
@RestController
public class PaymentController extends BaseController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PaymentService paymentService;

    @ApiOperation(value = "处理微信支付通知", response = String.class)
    @ApiResponses(value = {@ApiResponse(code = 400, message = "请求失败：失败原因", response = ErrorResponseEntity.class)})
    @RequestMapping(method = RequestMethod.POST, value = "/wechatNotfiy")
    public String wechatNotify() {
        logger.debug(">> wechatNotify()");
        try {
            return paymentService.doWxNotifyUrl(this.request);
        } catch (Exception e) {
            throw new InvalidParamsException("请求失败：" + e.getMessage());
        }
    }
}




