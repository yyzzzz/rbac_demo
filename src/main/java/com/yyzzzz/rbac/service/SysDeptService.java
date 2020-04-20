package com.yyzzzz.rbac.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yyzzzz.rbac.utils.PageUtils;
import com.yyzzzz.rbac.entity.SysDeptEntity;

import java.util.Map;

/**
 * 部门表 
 *
 * @author yyzzzz
 * @email yyzzzz@163.com
 * @date 2020-04-20 23:02:19
 */
public interface SysDeptService extends IService<SysDeptEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

