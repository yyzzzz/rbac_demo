package com.yyzzzz.rbac.controller;

import com.yyzzzz.rbac.entity.SysLogEntity;
import com.yyzzzz.rbac.service.SysLogService;
import com.yyzzzz.rbac.utils.PageUtils;
import com.yyzzzz.rbac.common.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;



/**
 * 权限相关更新记录表 
 *
 * @author yyzzzz
 * @email yyzzzz@163.com
 * @date 2020-04-20 23:02:19
 */
@RestController
@RequestMapping("rbac/syslog")
public class SysLogController {
    @Autowired
    private SysLogService sysLogService;

    /**
     * 列表
     */
    @RequestMapping("/list")
//    @RequiresPermissions("rbac:syslog:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = sysLogService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
//    @RequiresPermissions("rbac:syslog:info")
    public R info(@PathVariable("id") Integer id){
		SysLogEntity sysLog = sysLogService.getById(id);

        return R.ok().put("sysLog", sysLog);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
//    @RequiresPermissions("rbac:syslog:save")
    public R save(@RequestBody SysLogEntity sysLog){
		sysLogService.save(sysLog);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
//    @RequiresPermissions("rbac:syslog:update")
    public R update(@RequestBody SysLogEntity sysLog){
		sysLogService.updateById(sysLog);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
//    @RequiresPermissions("rbac:syslog:delete")
    public R delete(@RequestBody Integer[] ids){
		sysLogService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
