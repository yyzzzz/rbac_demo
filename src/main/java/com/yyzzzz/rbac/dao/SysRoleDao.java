package com.yyzzzz.rbac.dao;

import com.yyzzzz.rbac.entity.SysRoleEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 角色相关表 
 * 
 * @author yyzzzz
 * @email yyzzzz@163.com
 * @date 2020-04-20 23:02:19
 */
@Mapper
public interface SysRoleDao extends BaseMapper<SysRoleEntity> {
	
}
