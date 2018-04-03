package org.openmore.coursemore.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "third_authorizations")
public class ThirdAuthorizations {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "third_uid")
    private String thirdUid;

    @Column(name = "third_party")
    private String thirdParty;

    @Column(name = "wechat_unionid")
    private String wechatUnionid;

    @Column(name = "created_time")
    private Date createdTime;

    @Column(name = "updated_time")
    private Date updatedTime;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return user_id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * @return third_uid
     */
    public String getThirdUid() {
        return thirdUid;
    }

    /**
     * @param thirdUid
     */
    public void setThirdUid(String thirdUid) {
        this.thirdUid = thirdUid;
    }

    /**
     * @return third_party
     */
    public String getThirdParty() {
        return thirdParty;
    }

    /**
     * @param thirdParty
     */
    public void setThirdParty(String thirdParty) {
        this.thirdParty = thirdParty;
    }

    /**
     * @return wechat_unionid
     */
    public String getWechatUnionid() {
        return wechatUnionid;
    }

    /**
     * @param wechatUnionid
     */
    public void setWechatUnionid(String wechatUnionid) {
        this.wechatUnionid = wechatUnionid;
    }

    /**
     * @return created_time
     */
    public Date getCreatedTime() {
        return createdTime;
    }

    /**
     * @param createdTime
     */
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * @return updated_time
     */
    public Date getUpdatedTime() {
        return updatedTime;
    }

    /**
     * @param updatedTime
     */
    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }
}
