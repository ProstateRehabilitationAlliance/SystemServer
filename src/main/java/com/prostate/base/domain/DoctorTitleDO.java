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
public class DoctorTitleDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//医生职称id
	private String id;
	//职称编号
	private String doctorTitleNumber;
	//职称名称
	private String doctorTitleName;
	//排序
	private String orderWeight;
	//创建人
	private String createUser;
	//创建时间
	private Date createTime;
	//修改人
	private String updateUser;
	//修改时间
	private Date updateTime;
	//删除人
	private String deleteUser;
	//删除时间
	private Date deleteTime;
	//删除标记
	private String delFlag;

	/**
	 * 设置：医生职称id
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 获取：医生职称id
	 */
	public String getId() {
		return id;
	}
	/**
	 * 设置：职称编号
	 */
	public void setDoctorTitleNumber(String doctorTitleNumber) {
		this.doctorTitleNumber = doctorTitleNumber;
	}
	/**
	 * 获取：职称编号
	 */
	public String getDoctorTitleNumber() {
		return doctorTitleNumber;
	}
	/**
	 * 设置：职称名称
	 */
	public void setDoctorTitleName(String doctorTitleName) {
		this.doctorTitleName = doctorTitleName;
	}
	/**
	 * 获取：职称名称
	 */
	public String getDoctorTitleName() {
		return doctorTitleName;
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
	 * 设置：创建人
	 */
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	/**
	 * 获取：创建人
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
	 * 设置：修改人
	 */
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	/**
	 * 获取：修改人
	 */
	public String getUpdateUser() {
		return updateUser;
	}
	/**
	 * 设置：修改时间
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：修改时间
	 */
	public Date getUpdateTime() {
		return updateTime;
	}
	/**
	 * 设置：删除人
	 */
	public void setDeleteUser(String deleteUser) {
		this.deleteUser = deleteUser;
	}
	/**
	 * 获取：删除人
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
