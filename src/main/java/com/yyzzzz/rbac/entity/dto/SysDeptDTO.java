package com.yyzzzz.rbac.entity.dto;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 部门表 
 * 
 * @author yyzzzz
 * @email yyzzzz@163.com
 * @date 2020-04-20 23:02:19
 */
@Data
@TableName("sys_dept")
public class SysDeptDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;

	@NotBlank(message = "部门名称不能为空！")
	@Length(max = 15, min = 2, message = "部门名称必须在2-15个字之间")
	private String name;

	private Integer parentId;

	private String level;

	@NotNull(message = "展示顺序不能为空！")
	private Integer seq;

	@Length(max = 150, message = "备注长度必须在150个字之内！")
	private String remark;

}
