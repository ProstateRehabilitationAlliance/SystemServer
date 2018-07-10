package com.prostate.base.domain;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;



/**
 * 疾病表
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-05-07 14:02:35
 */
public class IllnessDO implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotNull(message = "id不能为空",groups = GroupID.class)
	@Pattern(regexp = "^[A-Za-z0-9]{32}",message = "id必须是32位字符串",groups = GroupID.class)
	private String id;
	//疾病名称
	@NotBlank(message =" 名称不能为空，且长度必须大于0" ,groups = {GroupWithoutID.class})
	private String illnessName;
	//疾病编号
	@NotBlank(message =" 编号不能为空，且长度必须大于0" ,groups = {GroupWithoutID.class})
	private String illnessNumber;
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
	 * 设置：疾病名称
	 */
	public void setIllnessName(String illnessName) {
		this.illnessName = illnessName;
	}
	/**
	 * 获取：疾病名称
	 */
	public String getIllnessName() {
		return illnessName;
	}
	/**
	 * 设置：疾病编号
	 */
	public void setIllnessNumber(String illnessNumber) {
		this.illnessNumber = illnessNumber;
	}
	/**
	 * 获取：疾病编号
	 */
	public String getIllnessNumber() {
		return illnessNumber;
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

	@Override
	public String toString() {
		return "IllnessDO{" +
				"id='" + id + '\'' +
				", illnessName='" + illnessName + '\'' +
				", illnessNumber='" + illnessNumber + '\'' +
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

	public IllnessDO() {
	}
}
