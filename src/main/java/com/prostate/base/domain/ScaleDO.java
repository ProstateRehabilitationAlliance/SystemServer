package com.prostate.base.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-05-07 14:02:36
 */
public class ScaleDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键
	private String id;
	//父id
	private String parentId;
	//标题
	private String scaleTitle;
	//分数
	private String scaleScore;
	//类别
	private String scaleType;
	//权重
	private String scaleWeight;
	//排序
	private Integer orderWeight;
	//创建人
	private String createUser;
	//创建时间
	private Date createTime;
	//删除人
	private String deleteUser;
	//删除时间
	private Date deleteTime;
	//删除标记
	private String delFlag;

	/**
	 * 设置：主键
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 获取：主键
	 */
	public String getId() {
		return id;
	}
	/**
	 * 设置：父id
	 */
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	/**
	 * 获取：父id
	 */
	public String getParentId() {
		return parentId;
	}
	/**
	 * 设置：标题
	 */
	public void setScaleTitle(String scaleTitle) {
		this.scaleTitle = scaleTitle;
	}
	/**
	 * 获取：标题
	 */
	public String getScaleTitle() {
		return scaleTitle;
	}
	/**
	 * 设置：分数
	 */
	public void setScaleScore(String scaleScore) {
		this.scaleScore = scaleScore;
	}
	/**
	 * 获取：分数
	 */
	public String getScaleScore() {
		return scaleScore;
	}
	/**
	 * 设置：类别
	 */
	public void setScaleType(String scaleType) {
		this.scaleType = scaleType;
	}
	/**
	 * 获取：类别
	 */
	public String getScaleType() {
		return scaleType;
	}
	/**
	 * 设置：权重
	 */
	public void setScaleWeight(String scaleWeight) {
		this.scaleWeight = scaleWeight;
	}
	/**
	 * 获取：权重
	 */
	public String getScaleWeight() {
		return scaleWeight;
	}

	public Integer getOrderWeight() {
		return orderWeight;
	}

	public void setOrderWeight(Integer orderWeight) {
		this.orderWeight = orderWeight;
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

	@Override
	public String toString() {
		return "ScaleDO{" +
				"id='" + id + '\'' +
				", parentId='" + parentId + '\'' +
				", scaleTitle='" + scaleTitle + '\'' +
				", scaleScore='" + scaleScore + '\'' +
				", scaleType='" + scaleType + '\'' +
				", scaleWeight='" + scaleWeight + '\'' +
				", orderWeight=" + orderWeight +
				", createUser='" + createUser + '\'' +
				", createTime=" + createTime +
				", deleteUser='" + deleteUser + '\'' +
				", deleteTime=" + deleteTime +
				", delFlag='" + delFlag + '\'' +
				'}';
	}
}
