package com.yyzzzz.rbac.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 权限模块表 
 * 
 * @author yyzzzz
 * @email yyzzzz@163.com
 * @date 2020-04-20 23:02:19
 */
@Data
@TableName("sys_acl_module")
public class SysAclModuleEntity extends SysBaseEntity implements Serializable{
	private static final long serialVersionUID = 1L;

	/**
	 * 权限模块id
	 */
	@TableId
	private Integer id;
	/**
	 * 权限模块名称
	 */
	private String name;
	/**
	 * 上级权限模块id
	 */
	private Integer parentId;
	/**
	 * 权限模块层级
	 */
	private String level;
	/**
	 * 状态 状态1：正常 0：冻结
	 */
	private Integer status;
	/**
	 * 次序
	 */
	private Integer seq;
	/**
	 * 备注
	 */
	private String remark;

}
