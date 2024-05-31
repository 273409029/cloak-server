package com.macro.mall.tiny.modules.cloak.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.macro.mall.tiny.common.api.CommonResult;
import com.macro.mall.tiny.modules.cloak.model.CloakDomainInfo;
import com.macro.mall.tiny.modules.cloak.model.CloakRequestLogs;
import com.macro.mall.tiny.modules.cloak.service.CloakDomainInfoService;
import com.macro.mall.tiny.modules.cloak.service.CloakRequestLogsService;
import com.macro.mall.tiny.modules.ums.model.UmsResource;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.Instant;
import java.util.List;

/**
 * <p>
 * 请求日志表 前端控制器
 * </p>
 *
 * @author macro
 * @since 2024-05-22
 */
@RestController
@RequestMapping("/requestLogs")
public class CloakRequestLogsController {

    @Resource
    private CloakRequestLogsService cloakRequestLogsService;

    @ApiOperation(value = "日志列表")
    @GetMapping(value = "/list")
    @ResponseBody
    public CommonResult<Page<CloakRequestLogs>> pageList(@RequestParam(required = false) String domainName,
                                                         @RequestParam(required = false) Boolean isCheck,
                                                         @RequestParam(required = false) Long startTime,
                                                         @RequestParam(required = false) Long endTime,
                                                         @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                         @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        Page<CloakRequestLogs> resourceList  = cloakRequestLogsService.pageList(pageSize,pageNum,domainName,isCheck,startTime,endTime);
        return CommonResult.success(resourceList);
    }
}

