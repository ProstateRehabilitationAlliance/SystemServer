package com.prostate.system.entity;

import java.util.Date;

public class Ipss {
    private String id;

    private String parentId;

    private String ipssTitle;

    private String ipssScore;

    private String ipssWeight;

    private String orderWeight;

    private String createUser;

    private Date createTime;

    private String deleteUser;

    private Date deleteTime;

    private String delFlag;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }

    public String getIpssTitle() {
        return ipssTitle;
    }

    public void setIpssTitle(String ipssTitle) {
        this.ipssTitle = ipssTitle == null ? null : ipssTitle.trim();
    }

    public String getIpssScore() {
        return ipssScore;
    }

    public void setIpssScore(String ipssScore) {
        this.ipssScore = ipssScore == null ? null : ipssScore.trim();
    }

    public String getIpssWeight() {
        return ipssWeight;
    }

    public void setIpssWeight(String ipssWeight) {
        this.ipssWeight = ipssWeight == null ? null : ipssWeight.trim();
    }

    public String getOrderWeight() {
        return orderWeight;
    }

    public void setOrderWeight(String orderWeight) {
        this.orderWeight = orderWeight == null ? null : orderWeight.trim();
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getDeleteUser() {
        return deleteUser;
    }

    public void setDeleteUser(String deleteUser) {
        this.deleteUser = deleteUser == null ? null : deleteUser.trim();
    }

    public Date getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(Date deleteTime) {
        this.deleteTime = deleteTime;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }
}