package com.yyzzzz.rbac.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 权限相关更新记录表 
 * 
 * @author yyzzzz
 * @email yyzzzz@163.com
 * @date 2020-04-20 23:02:19
 */
@Data
@TableName("sys_log")
public class SysLogEntity extends SysBaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId(type = IdType.AUTO)
	private Integer id;
	/**
	 * 权限更新类型 1：部门，2：用户，3：权限模块，4：权限，5：角色，6：角色用户关系，7：角色权限关系
	 */
	private Integer type;
	/**
	 * 基于type的指定的主键id
	 */
	private Integer targetId;
	/**
	 * 原始值
	 */
	private String oldValue;
	/**
	 * 新值
	 */
	private String newValue;
	/**
	 * 当前是否复原过，0：否，1：是 当前是否复原过，0：否，1：是
	 */
	private Integer status;

}
