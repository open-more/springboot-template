package org.openmore.coursemore.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * THIS IS AUTO GENERATED SOURCE CODE
 * Created by org.openmore.coursemore
 * on 2017-07-23
 */

@ApiModel("后台管理员显示模型")
public class AdministratorDto {
    @ApiModelProperty(value = "邮箱")
    public String account;
    @ApiModelProperty(value = "姓名")
    public String username;
    @ApiModelProperty(value = "有订单是否通知，10通知，0不通知")
    public int notifyOrder;
    @ApiModelProperty(value = "管理员类型，10：root超级管理员，0：普通管理员")
    public int status;
    @ApiModelProperty(value = "创建时间")
    public Date createdTime;
    @ApiModelProperty(value = "更新时间")
    public Date updatedTime;

    @ApiModelProperty(value = "登录token")
    public String token = "";

    @ApiModelProperty(value = "id")
    public int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getAccount() {
        return this.account;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setNotifyOrder(int notifyOrder) {
        this.notifyOrder = notifyOrder;
    }

    public int getNotifyOrder() {
        return this.notifyOrder;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return this.status;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }
}
