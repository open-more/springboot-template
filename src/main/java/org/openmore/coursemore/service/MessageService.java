package org.openmore.coursemore.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.openmore.coursemore.dto.MessageDto;
import org.openmore.coursemore.entity.Message;

/**
 * THIS IS AUTO GENERATED SOURCE CODE
 * Created by org.openmore.coursemore
 * on 2017-07-23
 */
public interface MessageService {

    /**
     * 根据id获得通知表 Dto对象
     *
     * @param id
     * @return MessageDto
     */
    MessageDto getMessageDtoById(Integer id) throws IllegalAccessException, InvocationTargetException;

    /**
     * 根据id获得通知表 Db Entity对象
     *
     * @param id
     * @return Message Db Entity
     */
    Message getEntityById(Integer id);

    /**
     * 根据指定的参数对数据进行检索
     *
     * @return List<MessageDto>结果列表
     */
    List<MessageDto> searchMessageDto(Message message) throws IllegalAccessException, InvocationTargetException;

    /**
     * 根据指定的参数对数据进行检索
     *
     * @return List<Message>结果列表
     */
    List<Message> searchMessage(Message message) throws IllegalAccessException, InvocationTargetException;

    /**
     * 创建通知表对象
     *
     * @param message 通知表 Db Entity对象
     */
    void create(Message message) throws Exception;

    /**
     * 删除指定id的通知表对象
     *
     * @param id 通知表id
     */
    void deleteById(Integer id);

    /**
     * 更新指定id的通知表对象为message
     *
     * @param message 需要更新的Db Entity对象
     */
    void update(Message message) throws Exception;


    /**
     * 获得当前用户的所有有效通知
     */
    List<MessageDto> getMessageByUser() throws Exception;

    /**
     * 设置消息列表为已读
     *
     * @param messageIdList
     */
    void setHasRead(String messageIdList);

    /**
     * 物理删除消息
     *
     * @param messageIdList
     */
    void deleteSelected(String messageIdList);
}
