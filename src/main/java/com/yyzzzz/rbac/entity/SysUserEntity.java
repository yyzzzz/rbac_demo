package com.yyzzzz.rbac.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 用户表 
 * 
 * @author yyzzzz
 * @email yyzzzz@163.com
 * @date 2020-04-20 23:02:19
 */
@Data
@TableName("sys_user")
public class SysUserEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 乐观锁
	 */
	private Integer revision;
	/**
	 * 创建人
	 */
	private String createdBy;
	/**
	 * 创建时间
	 */
	private Date createdTime;
	/**
	 * 更新人
	 */
	private String updatedBy;
	/**
	 * 更新时间
	 */
	private Date updatedTime;
	/**
	 * 用户id
	 */
	@TableId
	private Integer id;
	/**
	 * 用户名
	 */
	private String username;
	/**
	 * 电话
	 */
	private String telephone;
	/**
	 * 邮箱
	 */
	private String email;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 所属部门id
	 */
	private Integer deptId;
	/**
	 * 状态 状态1：正常 0：冻结  2删除
	 */
	private Integer status;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 最后一次操作者Ip
	 */
	private String operateIp;

}