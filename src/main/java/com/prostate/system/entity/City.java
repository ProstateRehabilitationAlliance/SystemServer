package com.prostate.system.entity;

import java.util.Date;

public class City {
    private String id;

    private String parentCityId;

    private String cityName;

    private String cityType;

    private String createUser;

    private Date createTime;

    private Integer cityWeight;
    private String orderWeight;

    private String updateUser;

    private Date updateTime;

    private String deleteUser;

    private Date deleteTime;

    private String delFlag;

    public String getOrderWeight() {
        return orderWeight;
    }

    public void setOrderWeight(String orderWeight) {
        this.orderWeight = orderWeight;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getParentCityId() {
        return parentCityId;
    }

    public void setParentCityId(String parentCityId) {
        this.parentCityId = parentCityId == null ? null : parentCityId.trim();
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName == null ? null : cityName.trim();
    }

    public String getCityType() {
        return cityType;
    }

    public void setCityType(String cityType) {
        this.cityType = cityType == null ? null : cityType.trim();
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    @Override
    public String toString() {
        return "City{" +
                "id='" + id + '\'' +
                ", parentCityId='" + parentCityId + '\'' +
                ", cityName='" + cityName + '\'' +
                ", cityType='" + cityType + '\'' +
                ", createUser='" + createUser + '\'' +
                ", createTime=" + createTime +
                ", cityWeight=" + cityWeight +
                ", updateUser='" + updateUser + '\'' +
                ", updateTime=" + updateTime +
                ", deleteUser='" + deleteUser + '\'' +
                ", deleteTime=" + deleteTime +
                ", delFlag='" + delFlag + '\'' +
                '}';
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCityWeight() {
        return cityWeight;
    }

    public void setCityWeight(Integer cityWeight) {
        this.cityWeight = cityWeight;
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
}