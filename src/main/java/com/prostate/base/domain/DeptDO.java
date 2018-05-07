package com.prostate.base.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 科室表
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-05-07 14:02:35
 */
public class DeptDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private String id;
	//上级科室ID
	private String parentDeptId;
	//科室名称
	private String deptName;
	//科室等级
	private String deptGrade;
	//科室简介
	private String deptInform;
	//权重排序用
	private Integer deptWeight;
	//排序
	private Integer orderWeight;
	//创建人ID(后台管理员)
	private String createUser;
	//创建时间
	private Date createTime;
	//修改人ID(后台管理员)
	private String updateUser;
	//修改时间
	private Date updateTime;
	//删除人ID(后台管理员)
	private String deleteUser;
	//删除时间
	private Date deleteTime;
	//删除标记
	private String delFlag;

	/**
	 * 设置：
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public String getId() {
		return id;
	}
	/**
	 * 设置：上级科室ID
	 */
	public void setParentDeptId(String parentDeptId) {
		this.parentDeptId = parentDeptId;
	}
	/**
	 * 获取：上级科室ID
	 */
	public String getParentDeptId() {
		return parentDeptId;
	}
	/**
	 * 设置：科室名称
	 */
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	/**
	 * 获取：科室名称
	 */
	public String getDeptName() {
		return deptName;
	}
	/**
	 * 设置：科室等级
	 */
	public void setDeptGrade(String deptGrade) {
		this.deptGrade = deptGrade;
	}
	/**
	 * 获取：科室等级
	 */
	public String getDeptGrade() {
		return deptGrade;
	}
	/**
	 * 设置：科室简介
	 */
	public void setDeptInform(String deptInform) {
		this.deptInform = deptInform;
	}
	/**
	 * 获取：科室简介
	 */
	public String getDeptInform() {
		return deptInform;
	}
	/**
	 * 设置：权重排序用
	 */
	public void setDeptWeight(Integer deptWeight) {
		this.deptWeight = deptWeight;
	}
	/**
	 * 获取：权重排序用
	 */
	public Integer getDeptWeight() {
		return deptWeight;
	}

	public Integer getOrderWeight() {
		return orderWeight;
	}

	public void setOrderWeight(Integer orderWeight) {
		this.orderWeight = orderWeight;
	}

	/**
	 * 设置：创建人ID(后台管理员)
	 */
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	/**
	 * 获取：创建人ID(后台管理员)
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
	 * 设置：修改人ID(后台管理员)
	 */
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	/**
	 * 获取：修改人ID(后台管理员)
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
	 * 设置：删除人ID(后台管理员)
	 */
	public void setDeleteUser(String deleteUser) {
		this.deleteUser = deleteUser;
	}
	/**
	 * 获取：删除人ID(后台管理员)
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
