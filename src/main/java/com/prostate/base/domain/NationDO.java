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
public class NationDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键id
	private String id;
	//民族名称
	private String nationName;
	//民族编号
	private String nationNumber;
	//排序
	private String orderWeight;
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
	 * 设置：民族名称
	 */
	public void setNationName(String nationName) {
		this.nationName = nationName;
	}
	/**
	 * 获取：民族名称
	 */
	public String getNationName() {
		return nationName;
	}
	/**
	 * 设置：民族编号
	 */
	public void setNationNumber(String nationNumber) {
		this.nationNumber = nationNumber;
	}
	/**
	 * 获取：民族编号
	 */
	public String getNationNumber() {
		return nationNumber;
	}
	/**
	 * 设置：排序
	 */
	public void setOrderWeight(String orderWeight) {
		this.orderWeight = orderWeight;
	}
	/**
	 * 获取：排序
	 */
	public String getOrderWeight() {
		return orderWeight;
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
}
