package com.yyzzzz.rbac.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 角色相关表 
 * 
 * @author yyzzzz
 * @email yyzzzz@163.com
 * @date 2020-04-20 23:02:19
 */
@Data
@TableName("sys_role")
public class SysRoleEntity extends SysBaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 角色id
	 */
	@TableId
	private Integer id;
	/**
	 * 角色名称
	 */
	private String name;
	/**
	 * 类型 类型1：管理员2：其他
	 */
	private Integer type;
	/**
	 * 状态 状态1：正常 0：冻结
	 */
	private Integer status;
	/**
	 * 备注
	 */
	private String remark;

}
