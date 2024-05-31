package com.macro.mall.tiny.modules.cloak.controller;

import cn.hutool.json.JSONUtil;
import com.macro.mall.tiny.common.api.CommonResult;
import com.macro.mall.tiny.modules.cloak.dto.RedirectReq;
import com.macro.mall.tiny.modules.cloak.dto.RedirectResp;
import com.macro.mall.tiny.modules.cloak.service.impl.CloakRedirectMatchService;
import com.macro.mall.tiny.modules.ums.dto.UmsAdminParam;
import com.macro.mall.tiny.modules.ums.model.UmsAdmin;
import com.macro.mall.tiny.modules.ums.service.UmsAdminService;
import com.macro.mall.tiny.modules.ums.service.UmsRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * 后台用户管理
 * Created by macro on 2018/4/26.
 */
@Controller
@Api(tags = "UmsAdminController")
@Tag(name = "UmsAdminController",description = "后台用户管理")
@RequestMapping("/open")
@Slf4j
public class CloakController {

    @Resource
    private CloakRedirectMatchService cloakRedirectMatchService;


    @ApiOperation(value = "用户注册")
    @PostMapping(value = "/redirect")
    @ResponseBody
    public CommonResult<RedirectResp> getRedirectUrl(HttpServletRequest request, @RequestBody RedirectReq req) {
        HashMap<String, String> headerMap = new HashMap<>();
        HashMap<String, String> paramMap = new HashMap<>();
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            Enumeration<String> headers = request.getHeaders(headerName);
            while (headers.hasMoreElements()) {
                String headerValue = headers.nextElement();
                headerMap.put(headerName,headerValue);
            }
        }


        // 示例：获取请求的Accept-Language头
        String language = request.getHeader(HttpHeaders.ACCEPT_LANGUAGE);

        // 示例：获取请求的源IP地址
        // 注意：对于经过代理的请求，可能需要检查X-Forwarded-For头
        String ipAddress = getClientIp(request);


        log.info("请求header:{},req:{},ip:{}", JSONUtil.toJsonStr(headerMap),JSONUtil.toJsonStr(req),ipAddress);
        return CommonResult.success(cloakRedirectMatchService.getRedirectUrl(request,req,ipAddress));
    }
    public String getClientIp(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}
