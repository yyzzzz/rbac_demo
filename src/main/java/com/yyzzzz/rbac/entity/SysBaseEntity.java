package com.yyzzzz.rbac.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.util.Date;

/**
 * @author yyzzzz
 * @Date 2020/4/22 21:35
 */
@Data
public class SysBaseEntity {

    /**
     * 乐观锁
     */
    private Integer revision;
    /**
     * 创建人
     */
    @TableField(fill = FieldFill.INSERT)
    private String createdBy;
    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createdTime;
    /**
     * 更新人
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String updatedBy;
    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updatedTime;
    /**
     * 最后一次操作者Ip
     */
    @TableField(fill = FieldFill.INSERT)
    private String operateIp;
    /**
     * 是否删除 0: 否 1： 是
     */
    private Integer isDeleted;
}
