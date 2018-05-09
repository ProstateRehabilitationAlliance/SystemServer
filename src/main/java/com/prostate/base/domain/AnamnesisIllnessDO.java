package com.prostate.base.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-05-07 14:02:35
 */
public class AnamnesisIllnessDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键id
	private String id;
	//既往病史名称
	private String anamnesisIllnessName;
	//中文缩写
	private String spellName;
	//既往病史编号
	private String anamnesisIllnessNumber;
	//排序
	private Integer orderWeight;
	//创建人员
	private String createUser;
	//创建时间
	private Date createTime;
	//更新人员
	private String updateUser;
	//更新时间
	private Date updateTime;
	//删除人员
	private String deleteUser;
	//删除时间
	private Date deleteTime;
	//删除标记
	private String delFlag;

	/**
	 * 设置：主键id
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 获取：主键id
	 */
	public String getId() {
		return id;
	}
	/**
	 * 设置：既往病史名称
	 */
	public void setAnamnesisIllnessName(String anamnesisIllnessName) {
		this.anamnesisIllnessName = anamnesisIllnessName;
	}
	/**
	 * 获取：既往病史名称
	 */
	public String getAnamnesisIllnessName() {
		return anamnesisIllnessName;
	}
	/**
	 * 设置：中文缩写
	 */
	public void setSpellName(String spellName) {
		this.spellName = spellName;
	}
	/**
	 * 获取：中文缩写
	 */
	public String getSpellName() {
		return spellName;
	}
	/**
	 * 设置：既往病史编号
	 */
	public void setAnamnesisIllnessNumber(String anamnesisIllnessNumber) {
		this.anamnesisIllnessNumber = anamnesisIllnessNumber;
	}
	/**
	 * 获取：既往病史编号
	 */
	public String getAnamnesisIllnessNumber() {
		return anamnesisIllnessNumber;
	}

	public Integer getOrderWeight() {

		return orderWeight;
	}

	public void setOrderWeight(Integer orderWeight) {
		this.orderWeight = orderWeight;
	}

	/**
	 * 设置：创建人员
	 */
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	/**
	 * 获取：创建人员
	 */
	public String getCreateUser() {
		return createUser;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：更新人员
	 */
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	/**
	 * 获取：更新人员
	 */
	public String getUpdateUser() {
		return updateUser;
	}
	/**
	 * 设置：更新时间
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：更新时间
	 */
	public Date getUpdateTime() {
		return updateTime;
	}
	/**
	 * 设置：删除人员
	 */
	public void setDeleteUser(String deleteUser) {
		this.deleteUser = deleteUser;
	}
	/**
	 * 获取：删除人员
	 */
	public String getDeleteUser() {
		return deleteUser;
	}
	/**
	 * 设置：删除时间
	 */
	public void setDeleteTime(Date deleteTime) {
		this.deleteTime = deleteTime;
	}
	/**
	 * 获取：删除时间
	 */
	public Date getDeleteTime() {
		return deleteTime;
	}
	/**
	 * 设置：删除标记
	 */
	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}
	/**
	 * 获取：删除标记
	 */
	public String getDelFlag() {
		return delFlag;
	}

	@Override
	public String toString() {
		return "AnamnesisIllnessDO{" +
				"id='" + id + '\'' +
				", anamnesisIllnessName='" + anamnesisIllnessName + '\'' +
				", spellName='" + spellName + '\'' +
				", anamnesisIllnessNumber='" + anamnesisIllnessNumber + '\'' +
				", orderWeight=" + orderWeight +
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
