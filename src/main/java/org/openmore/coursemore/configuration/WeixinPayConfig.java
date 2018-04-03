package org.openmore.coursemore.configuration;

import com.github.binarywang.wxpay.config.WxPayConfig;
import com.github.binarywang.wxpay.service.WxPayService;
import com.github.binarywang.wxpay.service.impl.WxPayServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * Created by michaeltang on 2018/3/22.
 */
@Configuration
public class WeixinPayConfig {

    @Autowired
    private Environment env;

    @Bean
    public WxPayConfig wxPayConfig() {
        WxPayConfig config = new WxPayConfig();
        config.setAppId(env.getProperty("wechat.pay.appId"));
        config.setMchId(env.getProperty("wechat.pay.mchId"));
        config.setMchKey(env.getProperty("wechat.pay.mchKey"));
        config.setNotifyUrl(env.getProperty("wechat.pay.notifyUrl"));
        return config;
    }

    @Bean
    public WxPayServiceImpl payService() {
        WxPayServiceImpl impl = new WxPayServiceImpl();
        impl.setConfig(this.wxPayConfig());
        return impl;
    }
}


