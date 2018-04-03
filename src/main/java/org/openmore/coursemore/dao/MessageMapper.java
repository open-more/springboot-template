package org.openmore.coursemore.dao;

import org.openmore.coursemore.dto.MessageDto;
import org.openmore.coursemore.entity.Message;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface MessageMapper extends Mapper<Message> {
    List<MessageDto> getMessageByUser(Integer uid);

    void deleteSelected(@Param("uid") Integer uid, @Param("messageIdList") String[] messageIdList);

    void setHasRead(@Param("uid") Integer uid, @Param("messageIdList") String[] messageIdList);
}
