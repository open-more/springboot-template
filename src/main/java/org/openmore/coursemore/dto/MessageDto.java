package org.openmore.coursemore.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * THIS IS AUTO GENERATED SOURCE CODE
 * Created by org.openmore.coursemore
 * on 2017-07-23
 */

@ApiModel("通知表显示模型")
public class MessageDto {
    @ApiModelProperty(value = "用户id")
    public int userId;
    @ApiModelProperty(value = "id")
    public int id;
    @ApiModelProperty(value = "类型：10表示系统消息，20表示订单消息")
    public int type;
    @ApiModelProperty(value = "消息标题")
    public String title;
    @ApiModelProperty(value = "消息内容")
    public String content;
    @ApiModelProperty(value = "消息跳转地址")
    public String action;
    @ApiModelProperty(value = "是否已经读取，0未读取，10已经读取")
    public int isRead;
    @ApiModelProperty(value = "创建时间")
    public Date createdTime;
    @ApiModelProperty(value = "消息过期时间")
    public Date expiredTime;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getType() {
        return this.type;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return this.content;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getAction() {
        return this.action;
    }

    public void setIsRead(int isRead) {
        this.isRead = isRead;
    }

    public int getIsRead() {
        return this.isRead;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getExpiredTime() {
        return expiredTime;
    }

    public void setExpiredTime(Date expiredTime) {
        this.expiredTime = expiredTime;
    }
}
