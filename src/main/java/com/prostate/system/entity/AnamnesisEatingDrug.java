package com.prostate.system.entity;

import java.util.Date;

public class AnamnesisEatingDrug {
    private String id;

    private String eatingDrugName;

    private String eatingDrugNumber;

    private String orderWeight;

    public String getOrderWeight() {
        return orderWeight;
    }

    public void setOrderWeight(String orderWeight) {
        this.orderWeight = orderWeight;
    }

    private String createName;

    private Date createTime;

    private String updateName;

    private Date updateTime;

    private String deleteName;

    private Date deleteTime;

    private String delFlag;




    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getEatingDrugName() {
        return eatingDrugName;
    }

    public void setEatingDrugName(String eatingDrugName) {
        this.eatingDrugName = eatingDrugName == null ? null : eatingDrugName.trim();
    }

    public String getEatingDrugNumber() {
        return eatingDrugNumber;
    }

    public void setEatingDrugNumber(String eatingDrugNumber) {
        this.eatingDrugNumber = eatingDrugNumber == null ? null : eatingDrugNumber.trim();
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName == null ? null : createName.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateName() {
        return updateName;
    }

    public void setUpdateName(String updateName) {
        this.updateName = updateName == null ? null : updateName.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getDeleteName() {
        return deleteName;
    }

    public void setDeleteName(String deleteName) {
        this.deleteName = deleteName == null ? null : deleteName.trim();
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
        return "AnamnesisEatingDrug{" +
                "id='" + id + '\'' +
                ", eatingDrugName='" + eatingDrugName + '\'' +
                ", eatingDrugNumber='" + eatingDrugNumber + '\'' +
                ", createName='" + createName + '\'' +
                ", createTime=" + createTime +
                ", updateName='" + updateName + '\'' +
                ", updateTime=" + updateTime +
                ", deleteName='" + deleteName + '\'' +
                ", deleteTime=" + deleteTime +
                ", delFlag='" + delFlag + '\'' +
                ", orderWeight='" + orderWeight + '\'' +
                '}';
    }
}