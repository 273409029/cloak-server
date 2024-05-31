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

import static com.macro.mall.tiny.modules.cloak.model.MatchRuleTypeEnum.IS_MOBILE;
import static com.macro.mall.tiny.modules.cloak.model.MatchRuleTypeEnum.REGION;

@Service
public class MobileCheck implements MatchRuleCheck{
    @Override
    public boolean support(MatchRuleTypeEnum type) {
        return IS_MOBILE.equals(type);
    }

    @Override
    public boolean match(MatchRule rule, CloakRequestLogs requestLogs, HttpServletRequest request, String ip,String region) {
        try{
             return rule.getCondition() == isMobileDevice(request);
        }catch (Exception e){
            return false;
        }
    }


    // 判断请求是否来自移动设备
    public  boolean isMobileDevice(HttpServletRequest request) {
        String userAgent = request.getHeader("User-Agent");
        if (userAgent == null) {
            return false;
        }

        // 定义常见的移动设备 User-Agent 标识
        String[] mobileAgents = {
                "Mobile", "Android", "iPhone", "iPad", "iPod", "BlackBerry", "Opera Mini", "IEMobile", "Windows Phone"
        };

        // 检查 User-Agent 是否包含移动设备标识
        for (String mobileAgent : mobileAgents) {
            if (userAgent.contains(mobileAgent)) {
                return true;
            }
        }

        return false;
    }
}
