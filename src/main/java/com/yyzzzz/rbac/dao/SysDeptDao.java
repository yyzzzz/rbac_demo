package com.yyzzzz.rbac.dao;

import com.yyzzzz.rbac.entity.SysDeptEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 部门表 
 * 
 * @author yyzzzz
 * @email yyzzzz@163.com
 * @date 2020-04-20 23:02:19
 */
@Mapper
public interface SysDeptDao extends BaseMapper<SysDeptEntity> {
	
}
