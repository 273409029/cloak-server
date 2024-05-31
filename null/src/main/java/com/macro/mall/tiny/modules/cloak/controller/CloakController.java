package com.macro.mall.tiny.modules.cloak.controller;

import com.macro.mall.tiny.common.api.CommonResult;
import com.macro.mall.tiny.modules.cloak.dto.RedirectResp;
import com.macro.mall.tiny.modules.ums.dto.UmsAdminParam;
import com.macro.mall.tiny.modules.ums.model.UmsAdmin;
import com.macro.mall.tiny.modules.ums.service.UmsAdminService;
import com.macro.mall.tiny.modules.ums.service.UmsRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 后台用户管理
 * Created by macro on 2018/4/26.
 */
@Controller
@Api(tags = "UmsAdminController")
@Tag(name = "UmsAdminController",description = "后台用户管理")
@RequestMapping("/cloak")
public class CloakController {

    @Autowired
    private UmsAdminService adminService;
    @Autowired
    private UmsRoleService roleService;

    @ApiOperation(value = "用户注册")
    @PostMapping(value = "/redirect")
    @ResponseBody
    public CommonResult<RedirectResp> getRedirectUrl(HttpServletRequest request, Map<String,String> params) {
        // 示例：获取请求的Accept-Language头
        String language = request.getHeader(HttpHeaders.ACCEPT_LANGUAGE);

        // 示例：获取请求的源IP地址
        // 注意：对于经过代理的请求，可能需要检查X-Forwarded-For头
        String ipAddress = request.getRemoteAddr();

        // 根据语言和IP地址逻辑选择重定向地址
        // 这里只是一个示例，你需要根据实际逻辑填充
        String redirectUrl;
        if (language != null && language.startsWith("zh")) {
            redirectUrl = "http://www.baidu.com"; // 假设中文用户跳转到.cn域名
        } else {
            redirectUrl = "http://www.google.com"; // 其他用户跳转到.com域名
        }

        RedirectResp result = new RedirectResp();
        result.setUrl(redirectUrl);
        return CommonResult.success(result);
    }

}
