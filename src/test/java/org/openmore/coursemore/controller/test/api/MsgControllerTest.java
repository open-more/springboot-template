package org.openmore.coursemore.controller.test.api;

import org.openmore.coursemore.BaseTestCase;
import org.openmore.coursemore.dto.MessageDto;
import org.openmore.coursemore.entity.Message;
import org.openmore.coursemore.service.MessageService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static junit.framework.TestCase.assertTrue;

import java.util.List;

/**
 * MsgController Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>八月 6, 2017</pre>
 */
public class MsgControllerTest extends BaseTestCase {

    @Autowired
    private MessageService messageService;

    /**
     * Method: getMessageByUser()
     */
    @Test
    public void testGetMessageByUser() throws Exception {
        List<MessageDto> searchResult;
        searchResult = messageService.getMessageByUser();
        assertTrue(searchResult.size() > 0);
    }

    /**
     * Method: setHasRead(@RequestParam @ApiParam(value = "已读消息的id列表，以逗号为分隔符") String ids)
     */
    @Test
    public void testSetHasRead() throws Exception {
        String messageIdList = "1,2,3,4,5,6";
        messageService.setHasRead(messageIdList);
        Message msg = messageService.getEntityById(1);
        assertTrue(msg != null);
        assertTrue(msg.getIsRead() == 10);
    }

    /**
     * Method: deleteMsg(@RequestParam @ApiParam(value = "删除消息的id列表，以逗号为分隔符") String ids)
     */
    @Test
    public void testDeleteMsg() throws Exception {
        messageService.deleteById(1);
        Message msg = messageService.getEntityById(1);
        assertTrue(msg == null);
    }
} 
