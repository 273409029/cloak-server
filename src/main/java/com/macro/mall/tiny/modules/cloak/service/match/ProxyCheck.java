package com.macro.mall.tiny.modules.cloak.service.match;

import com.macro.mall.tiny.modules.cloak.model.CloakRequestLogs;
import com.macro.mall.tiny.modules.cloak.model.MatchRule;
import com.macro.mall.tiny.modules.cloak.model.MatchRuleTypeEnum;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import static com.macro.mall.tiny.modules.cloak.model.MatchRuleTypeEnum.IS_PROXY;
import static com.macro.mall.tiny.modules.cloak.model.MatchRuleTypeEnum.REGION;

@Service
public class ProxyCheck implements MatchRuleCheck{
    @Override
    public boolean support(MatchRuleTypeEnum type) {
        return IS_PROXY.equals(type);
    }

    @Override
    public boolean match(MatchRule rule, CloakRequestLogs requestLogs, HttpServletRequest request, String ip,String region) {
        try{
            return rule.getCondition() == isProxyRequest(request);
        }catch (Exception e){
            return false;
        }
    }


    // 判断请求是否通过代理服务器发出
    public  boolean isProxyRequest(HttpServletRequest request) {
        // 检查常见的代理头信息
        String[] proxyHeaders = {
                "X-Forwarded-For", "Via", "X-Real-IP", "Forwarded", "Client-IP", "Proxy-Client-IP", "WL-Proxy-Client-IP"
        };

        for (String header : proxyHeaders) {
            String headerValue = request.getHeader(header);
            if (headerValue != null && !headerValue.isEmpty()) {
                return true;
            }
        }

        return false;
    }
}
