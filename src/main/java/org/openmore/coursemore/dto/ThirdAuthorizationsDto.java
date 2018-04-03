package org.openmore.coursemore.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * THIS IS AUTO GENERATED SOURCE CODE
 * Created by org.openmore.coursemore
 * on 2017-07-29
 */

@ApiModel("三方登录显示模型")
public class ThirdAuthorizationsDto {
    @ApiModelProperty(value = "用户id")
    public int userId;
    @ApiModelProperty(value = "三方OpenId")
    public String thirdUid;
    @ApiModelProperty(value = "三方平台名")
    public String thirdParty;
    @ApiModelProperty(value = "微信统一ID")
    public String wechatUnionid;
    @ApiModelProperty(value = "创建日期")
    public Date createdTime;
    @ApiModelProperty(value = "更新日期")
    public Date updatedTime;

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserId() {
        return this.userId;
    }

    public void setThirdUid(String thirdUid) {
        this.thirdUid = thirdUid;
    }

    public String getThirdUid() {
        return this.thirdUid;
    }

    public void setThirdParty(String thirdParty) {
        this.thirdParty = thirdParty;
    }

    public String getThirdParty() {
        return this.thirdParty;
    }

    public void setWechatUnionid(String wechatUnionid) {
        this.wechatUnionid = wechatUnionid;
    }

    public String getWechatUnionid() {
        return this.wechatUnionid;
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
