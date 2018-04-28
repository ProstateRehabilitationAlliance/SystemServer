package com.prostate.system.entity;

import java.util.Date;

public class AnamnesisType {
    private String id;

    private String anamnesisTypeName;

    private String anamnesisTypeNumber;

    private String orderWeight;

    private String createUser;

    private Date createTime;

    private String updateUser;

    private Date updateTime;

    private String deleteUser;

    private Date deleteTime;

    private String delFlag;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getAnamnesisTypeName() {
        return anamnesisTypeName;
    }

    public void setAnamnesisTypeName(String anamnesisTypeName) {
        this.anamnesisTypeName = anamnesisTypeName == null ? null : anamnesisTypeName.trim();
    }

    public String getAnamnesisTypeNumber() {
        return anamnesisTypeNumber;
    }

    public void setAnamnesisTypeNumber(String anamnesisTypeNumber) {
        this.anamnesisTypeNumber = anamnesisTypeNumber == null ? null : anamnesisTypeNumber.trim();
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

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser == null ? null : updateUser.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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

    @Override
    public String toString() {
        return "AnamnesisType{" +
                "id='" + id + '\'' +
                ", anamnesisTypeName='" + anamnesisTypeName + '\'' +
                ", anamnesisTypeNumber='" + anamnesisTypeNumber + '\'' +
                ", orderWeight='" + orderWeight + '\'' +
                ", createUser='" + createUser + '\'' +
                ", createTime=" + createTime +
                ", updateUser='" + updateUser + '\'' +
                ", updateTime=" + updateTime +
                ", deleteUser='" + deleteUser + '\'' +
                ", deleteTime=" + deleteTime +
                ", delFlag='" + delFlag + '\'' +
                '}';
    }
}