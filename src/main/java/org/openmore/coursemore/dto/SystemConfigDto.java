package org.openmore.coursemore.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * THIS IS AUTO GENERATED SOURCE CODE
 * Created by org.openmore.coursemore
 * on 2017-07-23
 */

@ApiModel("系统配置显示模型")
public class SystemConfigDto {
    @ApiModelProperty(value = "配置名")
    public String name;
    @ApiModelProperty(value = "值")
    public String value;
    @ApiModelProperty(value = "备注")
    public String remark;
    @ApiModelProperty(value = "创建时间")
    public Date createdTime;
    @ApiModelProperty(value = "更新时间")
    public Date updatedTime;

    @ApiModelProperty(value = "id")
    public int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRemark() {
        return this.remark;
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
