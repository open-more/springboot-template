package org.openmore.coursemore.service;


import org.openmore.common.exception.*;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

/**
 * THIS IS AUTO GENERATED SOURCE CODE
 * Created by org.openmore.coursemore
 * on 2017-08-25
 */
public interface PaymentService {

    /**
     * 微信支付
     *
     * @return
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     */
    String wxPay(String title, String desc, String outTradeNumber, BigDecimal price) throws InvalidParamsException;

    /**
     * 处理微信的回调
     *
     * @param request
     */
    String doWxNotifyUrl(HttpServletRequest request) throws Exception;
}
