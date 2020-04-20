package com.yyzzzz.rbac.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yyzzzz.rbac.utils.PageUtils;
import com.yyzzzz.rbac.entity.SysRoleEntity;

import java.util.Map;

/**
 * 角色相关表 
 *
 * @author yyzzzz
 * @email yyzzzz@163.com
 * @date 2020-04-20 23:02:19
 */
public interface SysRoleService extends IService<SysRoleEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

