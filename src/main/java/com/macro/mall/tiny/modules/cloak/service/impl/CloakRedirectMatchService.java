package com.macro.mall.tiny.modules.cloak.service.impl;

import cn.hutool.extra.servlet.ServletUtil;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.macro.mall.tiny.modules.cloak.dto.RedirectReq;
import com.macro.mall.tiny.modules.cloak.dto.RedirectResp;
import com.macro.mall.tiny.modules.cloak.mapper.CloakDomainInfoMapper;
import com.macro.mall.tiny.modules.cloak.mapper.CloakIpListMapper;
import com.macro.mall.tiny.modules.cloak.mapper.CloakRequestLogsMapper;
import com.macro.mall.tiny.modules.cloak.model.CloakDomainInfo;
import com.macro.mall.tiny.modules.cloak.model.CloakRequestLogs;
import com.macro.mall.tiny.modules.cloak.model.MatchRule;
import com.macro.mall.tiny.modules.cloak.service.CloakDomainInfoService;
import com.macro.mall.tiny.modules.cloak.service.CloakRequestLogsService;
import com.macro.mall.tiny.modules.cloak.service.match.MatchRuleCheck;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static cn.hutool.extra.servlet.ServletUtil.getHeaderMap;

/**
 * <p>
 * 域名信息表 服务实现类
 * </p>
 *
 * @author macro
 * @since 2024-05-22
 */
@Service
public class CloakRedirectMatchService  {

    @Resource
    private CloakDomainInfoMapper cloakDomainInfoMapper;

    @Resource
    private CloakIpListMapper cloakIpListMapper;

    @Resource
    private CloakRequestLogsMapper cloakRequestLogsMapper;


    @Resource
    private List<MatchRuleCheck> matchRuleCheck;

    public RedirectResp getRedirectUrl(HttpServletRequest request, RedirectReq req, String ip) {
        Map<String, String> headerMap = ServletUtil.getHeaderMap(request);
        String region = deduceRegion(ip);
        CloakRequestLogs requestLogs = new CloakRequestLogs();
        requestLogs.setHeaderInfo(JSONUtil.toJsonStr(headerMap));
        RedirectResp redirectResp = new RedirectResp();
        String domainName = req.getQueryParams().get("domainName");
        Assert.hasText(domainName,"域名参数不存在");
        CloakDomainInfo cloakDomainInfo = cloakDomainInfoMapper.selectByDomainName(domainName);
        requestLogs.setDomainName(domainName);
        requestLogs.setRequestIp(ip);
        requestLogs.setCheckStatus(cloakDomainInfo.getIsCheck());
        requestLogs.setUserAgent(request.getHeader(HttpHeaders.USER_AGENT));
        requestLogs.setTenantId(cloakDomainInfo.getTenantId());
        List<MatchRule> matchRules = cloakDomainInfo.getMatchRule();
        //命中白名单跳真页面
        if(cloakIpListMapper.exist(ip,cloakDomainInfo.getTenantId(),true)){
            redirectResp.setUrl(cloakDomainInfo.getMaskRedirectUrl());

        }
        //审核中跳假页面
        else if(cloakDomainInfo.getIsCheck()){
            redirectResp.setUrl(cloakDomainInfo.getWhiteListRedirectUrl());
        }
        //命中黑名单跳假页面
        else if(cloakIpListMapper.exist(ip,cloakDomainInfo.getTenantId(),false)){
            redirectResp.setUrl(cloakDomainInfo.getWhiteListRedirectUrl());
        }
        //命中所有匹配规则跳真页面
        else if(CollectionUtils.isEmpty(matchRules) || matchRules.stream().allMatch(it -> matchRuleCheck.stream().filter(match -> match.support(it.getMatchRuleType())).findFirst().get().match(it,requestLogs, request,ip,region) )){
            redirectResp.setUrl(cloakDomainInfo.getMaskRedirectUrl());
        }else{
            redirectResp.setUrl(cloakDomainInfo.getWhiteListRedirectUrl());
        }

        requestLogs.setRedirectUrl(redirectResp.getUrl());
        requestLogs.setIpRegion(region);
        requestLogs.setRuleMatched(cloakDomainInfo.getMatchRule());
        cloakRequestLogsMapper.insert(requestLogs);
        return redirectResp;
    }

    private String deduceRegion(String ip){
        try{
            URL url = new URL("http://ip-api.com/json/" + ip + "?lang=zh-CN");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            String regionZh = response.toString();
            return JSONUtil.parseObj(regionZh).get("country", String.class);
        }catch (Exception e){
            return "未知";
        }

    }
}
