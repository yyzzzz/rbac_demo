package com.yyzzzz.rbac.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 权限表 
 * 
 * @author yyzzzz
 * @email yyzzzz@163.com
 * @date 2020-04-20 23:02:19
 */
@Data
@TableName("sys_acl")
public class SysAclEntity extends SysBaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;


	/**
	 * 权限id
	 */
	@TableId
	private Integer id;
	/**
	 * 权限名称
	 */
	private String name;
	/**
	 * 权限码
	 */
	private String code;
	/**
	 * 请求url
	 */
	private String url;
	/**
	 * 类型 类型1：菜单2：按钮3：其他
	 */
	private Integer type;
	/**
	 * 所属权限模块
	 */
	private Integer aclModuleId;
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
