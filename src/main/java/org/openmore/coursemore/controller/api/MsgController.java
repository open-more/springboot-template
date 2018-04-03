package org.openmore.coursemore.controller.api;


import org.openmore.common.annotation.TokenAuthCheck;
import org.openmore.common.exception.*;
import org.openmore.coursemore.controller.common.BaseController;
import org.openmore.coursemore.dto.MessageDto;
import org.openmore.coursemore.dto.common.ErrorResponseEntity;
import org.openmore.coursemore.service.MessageService;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

/**
 * THIS IS AUTO GENERATED SOURCE CODE
 * Created by org.openmore.coursemore
 * on 2017-07-23
 */
@Api(value = "/Message", tags = "MessageApi", description = "通知表控制器")
@RequestMapping(value = "/api/message", produces = {APPLICATION_JSON_UTF8_VALUE})
@RestController
public class MsgController extends BaseController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MessageService messageService;

    @TokenAuthCheck
    @ApiOperation(value = "获得当前用户的通知(需要token)", response = MessageDto.class, responseContainer = "List")
    @ApiResponses(value = {@ApiResponse(code = 400, message = "请求失败：找不到id={id}的Message", response = ErrorResponseEntity.class)})
    @RequestMapping(method = RequestMethod.GET, value = "/byUser")
    public ResponseEntity getMessageByUser() {
        logger.debug(">> getMessageByUser");
        List<MessageDto> searchResult;
        try {
            searchResult = messageService.getMessageByUser();
        } catch (Exception e) {
            throw new InvalidParamsException("请求失败：" + e.getMessage());
        }
        return new ResponseEntity(searchResult, HttpStatus.OK);
    }

    @TokenAuthCheck
    @ApiOperation(value = "设置消息列表为已读(需要token)")
    @ApiResponses(value = {@ApiResponse(code = 400, message = "请求失败：找不到id={id}的Message", response = ErrorResponseEntity.class)})
    @RequestMapping(method = RequestMethod.PUT, value = "/hasRead")
    public void setHasRead(@RequestParam @ApiParam(value = "已读消息的id列表，以逗号为分隔符") String ids) {
        logger.debug(">> setHasRead({})", ids);
        try {
            messageService.setHasRead(ids);
        } catch (Exception e) {
            throw new InvalidParamsException("请求失败：" + e.getMessage());
        }
    }

    @TokenAuthCheck
    @ApiOperation(value = "物理删除消息(需要token)")
    @ApiResponses(value = {@ApiResponse(code = 400, message = "请求失败", response = ErrorResponseEntity.class)})
    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteMsg(@RequestParam @ApiParam(value = "删除消息的id列表，以逗号为分隔符") String ids) {
        logger.debug(">> deleteMsg({})", ids);
        try {
            messageService.deleteSelected(ids);
        } catch (Exception e) {
            throw new InvalidParamsException("请求失败：" + e.getMessage());
        }
    }
}




