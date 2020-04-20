package com.yyzzzz.rbac.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yyzzzz.rbac.entity.SysAclEntity;
import com.yyzzzz.rbac.utils.PageUtils;

import java.util.Map;

/**
 * 权限表 
 *
 * @author yyzzzz
 * @email yyzzzz@163.com
 * @date 2020-04-20 23:02:19
 */
public interface SysAclService extends IService<SysAclEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

