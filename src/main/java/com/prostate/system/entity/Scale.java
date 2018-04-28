package com.prostate.system.entity;

import java.util.Date;

public class Scale {
    private String id;

    private String parentId;

    private String scaleTitle;

    private String scaleScore;

    private String scaleType;

    private String scaleWeight;

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

    public String getScaleTitle() {
        return scaleTitle;
    }

    public void setScaleTitle(String scaleTitle) {
        this.scaleTitle = scaleTitle == null ? null : scaleTitle.trim();
    }

    public String getScaleScore() {
        return scaleScore;
    }

    public void setScaleScore(String scaleScore) {
        this.scaleScore = scaleScore == null ? null : scaleScore.trim();
    }

    public String getScaleType() {
        return scaleType;
    }

    public void setScaleType(String scaleType) {
        this.scaleType = scaleType == null ? null : scaleType.trim();
    }

    public String getScaleWeight() {
        return scaleWeight;
    }

    public void setScaleWeight(String scaleWeight) {
        this.scaleWeight = scaleWeight == null ? null : scaleWeight.trim();
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