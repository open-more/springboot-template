package org.openmore.coursemore.controller.backend;

import io.swagger.annotations.*;
import org.openmore.coursemore.controller.common.BaseController;
import org.openmore.coursemore.dto.common.ErrorResponseEntity;
import org.openmore.coursemore.entity.Message;
import org.openmore.coursemore.service.MessageService;
import org.openmore.common.exception.*;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.openmore.coursemore.dto.MessageDto;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

/**
 * THIS IS AUTO GENERATED SOURCE CODE
 * Created by org.openmore.coursemore
 * on 2017-07-23
 */
@Api(value = "/Message", tags = "MessageApi", description = "通知表控制器")
@RequestMapping(value = "/backend/message", produces = {APPLICATION_JSON_UTF8_VALUE})
@RestController
public class MessageController extends BaseController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MessageService messageService;

    @ApiOperation(value = "根据id获取通知表信息", response = MessageDto.class)
    @ApiResponses(value = {@ApiResponse(code = 400, message = "请求失败：找不到id={id}的Message", response = ErrorResponseEntity.class)})
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity getMessageById(@PathVariable @ApiParam(required = true, value = "通知表id") Integer id) {
        logger.debug(">> getMessageById");
        MessageDto message;
        try {
            message = messageService.getMessageDtoById(id);
        } catch (Exception e) {
            throw new InvalidParamsException("请求失败：" + e.getMessage());
        }
        if (message == null) {
            throw new InvalidParamsException("请求失败：找不到id=" + id + "的通知表");
        }
        return new ResponseEntity(message, HttpStatus.OK);
    }

    @ApiOperation(value = "检索通知表信息，返回结果列表", response = Message.class, responseContainer = "List")
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity searchMessage(@RequestParam(required = false) @ApiParam("通知表对象") Message message
    ) {
        logger.debug(">> searchMessage");
        List<MessageDto> searchResult;
        try {
            searchResult = messageService.searchMessageDto(message);
        } catch (Exception e) {
            throw new InvalidParamsException("请求失败：" + e.getMessage());
        }
        return new ResponseEntity(searchResult, HttpStatus.OK);
    }

    @ApiOperation("更新通知表")
    @ApiResponses(value = {@ApiResponse(code = 400, message = "请求失败：更新的数据不存在", response = ErrorResponseEntity.class),
            @ApiResponse(code = 400, message = "请求失败：数据更新失败", response = ErrorResponseEntity.class)})
    @RequestMapping(method = RequestMethod.PUT, value = "{id}")
    public void updateMessage(@PathVariable @ApiParam(value = "通知表id", required = true) Integer id,
                              @RequestBody @ApiParam(value = "新通知表信息", required = true) Message message) {
        logger.debug(">> updateMessage");
        Message entity = messageService.getEntityById(message.getId());
        if (entity == null) {
            throw new InvalidParamsException("请求失败：更新的数据不存在");
        }

        // 如果entity里没有带id，自动添加上
        if (message.getId() == null) {
            message.setId(id);
        }

        try {
            messageService.update(message);
        } catch (Exception e) {
            throw new InvalidParamsException("请求失败：" + e.getMessage());
        }
    }

    @ApiOperation("创建通知表")
    @ApiResponses(value = {@ApiResponse(code = 400, message = "请求失败：数据创建失败", response = ErrorResponseEntity.class)})
    @RequestMapping(method = RequestMethod.POST, consumes = {APPLICATION_JSON_UTF8_VALUE})
    public void createMessage(@RequestBody @ApiParam(value = "创建通知表", required = true) Message message) {
        logger.debug(">> createMessage");
        try {
            messageService.create(message);
        } catch (Exception e) {
            throw new InvalidParamsException("请求失败：" + e.getMessage());
        }
    }

    @ApiOperation(value = "删除指定通知表")
    @ApiResponses(value = {@ApiResponse(code = 400, message = "请求失败：数据删除失败", response = ErrorResponseEntity.class)})
    @RequestMapping(method = RequestMethod.DELETE, value = "{id}")
    public void deleteMessage(@PathVariable @ApiParam(value = "通知表id", required = true) Integer id) {
        logger.debug(">> deleteMessage");
        try {
            messageService.deleteById(id);
        } catch (Exception e) {
            throw new InvalidParamsException("请求失败：" + e.getMessage());
        }
    }
}




