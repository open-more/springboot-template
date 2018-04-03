package org.openmore.coursemore.service.test.impl;

import org.openmore.coursemore.BaseTestCase;
import org.openmore.coursemore.service.PaymentService;
import org.junit.Test;
import org.openmore.common.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;

import static junit.framework.TestCase.assertTrue;

/**
 * PaymentServiceImpl Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>十月 18, 2017</pre>
 */
public class PaymentServiceImplTest extends BaseTestCase {

    @Autowired
    private PaymentService paymentService;

    /**
     * Method: wxPay(String title, String desc, String outTradeNumber, BigDecimal price)
     */
    @Test
    public void testWxPay() throws Exception {
        String result = paymentService.wxPay("test title", "test desc", CommonUtils.getNowDateString(4), new BigDecimal(1));
        assertTrue(!StringUtils.isEmpty(result));
    }

    /**
     * Method: doWxNotifyUrl(HttpServletRequest request)
     */
    @Test
    public void testDoWxNotifyUrl() throws Exception {
    }
} 
