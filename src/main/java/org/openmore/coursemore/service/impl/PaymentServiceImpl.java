package org.openmore.coursemore.service.impl;

import com.github.binarywang.wxpay.bean.notify.WxPayOrderNotifyResult;
import com.github.binarywang.wxpay.bean.order.WxPayAppOrderResult;
import com.github.binarywang.wxpay.bean.request.*;
import com.github.binarywang.wxpay.constant.WxPayConstants;
import com.github.binarywang.wxpay.exception.WxPayException;
import com.github.binarywang.wxpay.service.impl.WxPayServiceImpl;
import com.google.gson.Gson;
import org.openmore.common.exception.InvalidParamsException;
import org.openmore.coursemore.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.math.BigDecimal;
import java.net.InetAddress;
import java.util.List;

/**
 * THIS IS AUTO GENERATED SOURCE CODE
 *   Created by com.focus3d
 *      on 2017-07-23
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private WxPayServiceImpl payService;


    @Override
    public String wxPay(String title, String desc, String outTradeNumber, BigDecimal price) throws InvalidParamsException {
        try {
            logger.debug("wxPay()" + title + desc + "," + price.intValue());

            String ip = InetAddress.getLocalHost().getHostAddress().toString();

            WxPayUnifiedOrderRequest payInfo = WxPayUnifiedOrderRequest.newBuilder()
                    .outTradeNo(outTradeNumber)
                    .totalFee(price.intValue() * 100)   // 价格过来是元，微信需要的分
//                    .totalFee(1)   // 测试时，1分钱
                    .body(desc)
                    .tradeType(WxPayConstants.TradeType.APP)
                    .spbillCreateIp(ip)
                    .build();
            WxPayAppOrderResult result = this.payService.createOrder(payInfo);
            if(result == null){
                throw new InvalidParamsException("无法获得支付信息");
            }
            return new Gson().toJson(result);
        }catch (WxPayException e){
            logger.debug("exception:" + e);
            throw new InvalidParamsException(e.getErrCodeDes());
        } catch (Exception e){
            throw new InvalidParamsException(e.getMessage());
        }
    }

    @Override
    public String doWxNotifyUrl(HttpServletRequest request) throws Exception
    {
        logger.debug("doWxNotifyUrl()");
        BufferedReader br = request.getReader();
        String str, requestBody = "";
        while((str = br.readLine()) != null){
            requestBody += str;
        }
        logger.debug(requestBody);
        WxPayOrderNotifyResult result = this.payService.parseOrderNotifyResult(requestBody);
        if(result.getResultCode().equals("SUCCESS")){
            logger.debug(result.getOutTradeNo() + "支付成功");
            String tradNumber = result.getOutTradeNo();
            // TODO::修改商品状态为已经支付及其它相关支付成功逻辑
        } else {
            logger.error(result.getOutTradeNo() + "支付失败，原因：" + result.getReturnMsg());
        }
        return  "<xml>" +
                "<return_code><![CDATA[SUCCESS]]></return_code>" +
                "  <return_msg><![CDATA[OK]]></return_msg>" +
                "</xml>";
    }
}