package org.openmore.coursemore.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * THIS IS AUTO GENERATED SOURCE CODE
 * Created by org.openmore.coursemore
 * on 2017-07-23
 */

@ApiModel("用户显示模型")
public class UserDto {
    @ApiModelProperty(value = "用户标识")
    public String uuid;
    @ApiModelProperty(value = "手机号")
    public String mobile;
    @ApiModelProperty(value = "用户姓名")
    public String nickname;
    @ApiModelProperty(value = "头像地址")
    public String avatar;
    @ApiModelProperty(value = "生日")
    public String birthday;
    @ApiModelProperty(value = "性别")
    public String gender;
    @ApiModelProperty(value = "位置")
    public String location;
    @ApiModelProperty(value = "是否为测试用户：0不是，10是")
    public int isTest;
    @ApiModelProperty(value = "用户状态，0正常，-1已删除")
    public int status;
    @ApiModelProperty(value = "金币数量")
    public int coinQuantity;
    @ApiModelProperty(value = "上次登录时间")
    public Date loginTime;
    @ApiModelProperty(value = "创建时间")
    public Date createdTime;
    @ApiModelProperty(value = "更新时间")
    public Date updatedTime;
    @ApiModelProperty(value = "展参id")
    public int exhibitionId;

    @ApiModelProperty(value = "token")
    public String token;

    public String getToken() {
        return token;
    }

    public int getExhibitionId() {
        return exhibitionId;
    }

    public void setExhibitionId(int exhibitionId) {
        this.exhibitionId = exhibitionId;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getUuid() {
        return this.uuid;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getMobile() {
        return this.mobile;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getBirthday() {
        return this.birthday;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return this.gender;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocation() {
        return this.location;
    }

    public void setIsTest(int isTest) {
        this.isTest = isTest;
    }

    public int getIsTest() {
        return this.isTest;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return this.status;
    }

    public void setCoinQuantity(int coinQuantity) {
        this.coinQuantity = coinQuantity;
    }

    public int getCoinQuantity() {
        return this.coinQuantity;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
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
