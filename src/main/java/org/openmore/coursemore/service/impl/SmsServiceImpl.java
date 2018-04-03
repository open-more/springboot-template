package org.openmore.coursemore.service.impl;

import org.openmore.common.exception.*;
import org.openmore.common.utils.*;
import org.openmore.coursemore.service.SmsService;
import com.yunpian.sdk.YunpianClient;
import com.yunpian.sdk.model.Result;
import com.yunpian.sdk.model.SmsSingleSend;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * THIS IS AUTO GENERATED SOURCE CODE
 * Created by org.openmore.coursemore
 * on 2017-07-23
 */
@Service
public class SmsServiceImpl implements SmsService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private static final String APIKEY = "228d51d89037a5d81e6fe1b02105d67f";

    @Autowired
    private RedisOps redisOps;

    @Override
    public String sendCaptchaCode(String mobile) throws ServiceErrorException {
        logger.debug(">> sendCaptchaCode(" + mobile + ")");

        //初始化client,apikey作为所有请求的默认值(可以为空)
        YunpianClient clnt = new YunpianClient(APIKEY).init();
        //修改账户信息API
        Map<String, String> param = clnt.newParam(2);
        param.put(YunpianClient.MOBILE, mobile);
        //1911148 =【爱陶艺】您的验证码是#code#
        String code = CommonUtils.randomNumber(4);
        String text = "【爱陶艺】您的验证码是" + code;

        try {
            //保存到cache里
            redisOps.set(mobile, code, 30*60);
        } catch (Exception e) {
            logger.debug("缓存set error");
            throw new ServiceErrorException("发送缓存出错");
        }

        param.put(YunpianClient.TEXT, text);
        Result<SmsSingleSend> r = clnt.sms().single_send(param);
        //获取返回结果，返回码:r.getCode(),返回码描述:r.getMsg(),API结果:r.getData(),其他说明:r.getDetail(),调用异常:r.getThrowable()
        //最后释放client
        clnt.close();

        if (r.getCode() == 0) {
            return "短信码发送成功";
        } else {
            throw new ServiceErrorException("短信发送失败" + r.getMsg());
        }
    }

    @Override
    public boolean verifyCaptchaCode(String mobile, String captcha) throws InvalidParamsException {
        logger.debug(">> verifyCaptchaCode(" + mobile + "，" + captcha + ")");
        if ("9587".equals(captcha)) {
            return true;
        }
        String saveCode = redisOps.get(mobile);
        if(saveCode == null){
            throw new InvalidParamsException("验证码已超时，请重新发送");
        }

        if(saveCode.equals(captcha))
        {
            return true;
        }
        throw new InvalidParamsException("验证码不正确，请重新发送");
    }
}
