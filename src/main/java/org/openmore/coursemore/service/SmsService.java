package org.openmore.coursemore.service;


import org.openmore.common.exception.*;

import java.lang.reflect.InvocationTargetException;

/**
 * THIS IS AUTO GENERATED SOURCE CODE
 * Created by org.openmore.coursemore
 * on 2017-07-23
 */
public interface SmsService {

    /**
     * 发送验证码
     *
     * @param mobile 手机号，国内电话自动+86，国际电话需要输入时带有+86
     * @return
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     */
    String sendCaptchaCode(String mobile) throws InvalidParamsException;

    /**
     * 验证验证码
     *
     * @param mobile
     * @param captcha
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     */
    boolean verifyCaptchaCode(String mobile, String captcha) throws InvalidParamsException;

}
