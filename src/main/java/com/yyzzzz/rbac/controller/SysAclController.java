package com.yyzzzz.rbac.controller;

import com.yyzzzz.rbac.entity.SysAclEntity;
import com.yyzzzz.rbac.service.SysAclService;
import com.yyzzzz.rbac.utils.PageUtils;
import com.yyzzzz.rbac.common.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;



/**
 * 权限表 
 *
 * @author yyzzzz
 * @email yyzzzz@163.com
 * @date 2020-04-20 23:02:19
 */
@RestController
@RequestMapping("rbac/sysacl")
public class SysAclController {
    @Autowired
    private SysAclService sysAclService;

    /**
     * 列表
     */
    @RequestMapping("/list")
//    @RequiresPermissions("rbac:sysacl:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = sysAclService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
//    @RequiresPermissions("rbac:sysacl:info")
    public R info(@PathVariable("id") Integer id){
		SysAclEntity sysAcl = sysAclService.getById(id);

        return R.ok().put("sysAcl", sysAcl);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
//    @RequiresPermissions("rbac:sysacl:save")
    public R save(@RequestBody SysAclEntity sysAcl){
		sysAclService.save(sysAcl);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
//    @RequiresPermissions("rbac:sysacl:update")
    public R update(@RequestBody SysAclEntity sysAcl){
		sysAclService.updateById(sysAcl);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
//    @RequiresPermissions("rbac:sysacl:delete")
    public R delete(@RequestBody Integer[] ids){
		sysAclService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
