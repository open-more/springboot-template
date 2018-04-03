package org.openmore.coursemore.service.impl;

import org.openmore.coursemore.entity.User;
import org.openmore.common.exception.*;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.openmore.coursemore.dao.MessageMapper;
import org.openmore.coursemore.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.openmore.coursemore.dto.MessageDto;
import org.openmore.coursemore.entity.Message;

/**
 * THIS IS AUTO GENERATED SOURCE CODE
 * Created by org.openmore.coursemore
 * on 2017-07-23
 */
@Service
public class MessageServiceImpl implements MessageService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    // 注入Service依赖
    @Autowired
    private MessageMapper messageDao;

    /**
     * 根据id获得通知表 Dto对象
     *
     * @param id
     * @return MessageDto
     */
    @Transactional
    public MessageDto getMessageDtoById(Integer id) throws IllegalAccessException, InvocationTargetException {
        logger.debug(">> getMessageDtoById(Integer id) id = " + id);
        Message entity = messageDao.selectByPrimaryKey(id);
        if (entity == null) {
            return null;
        }
        MessageDto dto = new MessageDto();
        BeanUtils.copyProperties(dto, entity);
        return dto;
    }

    /**
     * 根据id获得通知表 Db Entity对象
     *
     * @param id
     * @return Message Db Entity
     */
    @Transactional
    public Message getEntityById(Integer id) {
        logger.debug(">> getEntityById(Integer id)");
        return messageDao.selectByPrimaryKey(id);
    }

    /**
     * 根据指定的参数对数据进行检索
     *
     * @return List<MessageDto>结果列表
     */
    @Transactional
    public List<MessageDto> searchMessageDto(Message message) throws IllegalAccessException, InvocationTargetException {
        logger.debug(">> searchMessageDto(Message message)");
        List<Message> searchResult;
        if (message == null) {
            searchResult = messageDao.selectAll();
        } else {
            searchResult = messageDao.select(message);
        }

        List<MessageDto> dtoResult = new ArrayList<>();
        for (Message u : searchResult) {
            MessageDto dto = new MessageDto();
            BeanUtils.copyProperties(dto, u);
            dtoResult.add(dto);
        }
        return dtoResult;
    }

    /**
     * 根据指定的参数对数据进行检索
     *
     * @return List<Message>结果列表
     */
    @Transactional
    public List<Message> searchMessage(Message message) throws IllegalAccessException, InvocationTargetException {
        logger.debug(">> searchMessage(Message message)");
        List<Message> searchResult;
        if (message == null) {
            searchResult = messageDao.selectAll();
        } else {
            searchResult = messageDao.select(message);
        }
        return searchResult;
    }


    /**
     * 创建通知表对象
     *
     * @param message 通知表 Db Entity对象
     */
    @Transactional
    public void create(Message message) throws Exception {
        logger.debug(">> create(Message message)");
        try {
            messageDao.insertSelective(message);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }
    }

    /**
     * 删除指定id的通知表对象
     *
     * @param id 通知表id
     */
    @Transactional
    public void deleteById(Integer id) {
        logger.debug(">> deleteById(Integer id)");
        messageDao.deleteByPrimaryKey(id);
    }

    /**
     * 更新指定id的通知表对象为message
     *
     * @param message 需要更新的Db Entity对象
     */
    @Transactional
    public void update(Message message) throws Exception {
        logger.debug(">> update(Message message");
        // updateByPrimaryKeySelective only update field not null.
        try {
            messageDao.updateByPrimaryKeySelective(message);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }
    }

    /**
     * 获得当前用户的所有有效通知
     */
    @Transactional
    public List<MessageDto> getMessageByUser() throws Exception {
        logger.debug(">> getMessageByUser");
        Subject subject = SecurityUtils.getSubject();
        Object obj = subject.getPrincipal();
        if (obj == null || !(obj instanceof User)) {
            throw new InvalidParamsException("用户信息不存在");
        }
        User user = (User) obj;
        logger.debug(">> uid = {}", user.getId());
        try {
            return messageDao.getMessageByUser(user.getId());
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }
    }

    /**
     * 设置消息列表为已读
     *
     * @param messageIdList
     */
    @Transactional
    public void setHasRead(String messageIdList) {
        logger.debug(">> setHasRead");
        Subject subject = SecurityUtils.getSubject();
        Object obj = subject.getPrincipal();
        if (obj == null || !(obj instanceof User)) {
            throw new InvalidParamsException("用户信息不存在");
        }
        User user = (User) obj;
        try {
            messageDao.setHasRead(user.getId(), messageIdList.split(","));
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }
    }


    /**
     * 物理删除消息
     *
     * @param messageIdList
     */
    @Transactional
    public void deleteSelected(String messageIdList) {
        logger.debug(">> deleteSelected");
        Subject subject = SecurityUtils.getSubject();
        Object obj = subject.getPrincipal();
        if (obj == null || !(obj instanceof User)) {
            throw new InvalidParamsException("用户信息不存在");
        }
        User user = (User) obj;
        try {
            messageDao.deleteSelected(user.getId(), messageIdList.split(","));
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }
    }
}
