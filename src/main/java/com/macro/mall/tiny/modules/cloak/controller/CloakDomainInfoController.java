package com.macro.mall.tiny.modules.cloak.controller;


import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.macro.mall.tiny.common.api.CommonResult;
import com.macro.mall.tiny.modules.cloak.dto.RedirectReq;
import com.macro.mall.tiny.modules.cloak.dto.RedirectResp;
import com.macro.mall.tiny.modules.cloak.mapper.CloakDomainInfoMapper;
import com.macro.mall.tiny.modules.cloak.model.CloakDomainInfo;
import com.macro.mall.tiny.modules.cloak.service.CloakDomainInfoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.time.Instant;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 域名信息表 前端控制器
 * </p>
 *
 * @author macro
 * @since 2024-05-22
 */
@RestController
@RequestMapping("/cloakDomainInfo")
public class CloakDomainInfoController {


    @Resource
    private CloakDomainInfoService cloakDomainInfoService;

    @ApiOperation(value = "列表")
    @GetMapping(value = "/list")
    @ResponseBody
    public CommonResult<Page<CloakDomainInfo>> list(@RequestParam(required = false) String domainName,
                                                    @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                    @RequestParam(value = "pageNum", defaultValue = "1")Integer pageNum) {
        Page<CloakDomainInfo> list = cloakDomainInfoService.pageList(pageSize,pageNum,domainName);
        return CommonResult.success(list);
    }


    @ApiOperation(value = "修改")
    @PostMapping(value = "/update")
    @ResponseBody
    public CommonResult<Void> update(@RequestBody CloakDomainInfo req) {
        cloakDomainInfoService.updateById(req);
        return CommonResult.success(null);
    }


    @ApiOperation(value = "用户注册")
    @PostMapping(value = "/add")
    @ResponseBody
    public CommonResult<Void> add(@RequestBody CloakDomainInfo req) {
        req.setTenantId(Instant.now().toEpochMilli());
        cloakDomainInfoService.save(req);
        return CommonResult.success(null);
    }


    @ApiOperation(value = "用户注册")
    @PostMapping(value = "/delete/{id}")
    @ResponseBody
    public CommonResult<Void> delete(@PathVariable Long id) {
        cloakDomainInfoService.removeById(id);
        return CommonResult.success(null);
    }
}

