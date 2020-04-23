package com.yyzzzz.rbac.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 部门表 
 * 
 * @author yyzzzz
 * @email yyzzzz@163.com
 * @date 2020-04-20 23:02:19
 */
@Data
@TableName("sys_dept")
public class SysDeptEntity extends SysBaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 部门id
	 */
	@TableId(type = IdType.AUTO)
	private Integer id;
	/**
	 * 部门名称
	 */
	private String name;
	/**
	 * 上级部门id
	 */
	private Integer parentId;
	/**
	 * 部门层级
	 */
	private String level;
	/**
	 * 次序
	 */
	private Integer seq;
	/**
	 * 备注
	 */
	private String remark;

}
