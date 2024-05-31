package com.macro.mall.tiny.modules.cloak.service.match;

import com.macro.mall.tiny.modules.cloak.model.CloakRequestLogs;
import com.macro.mall.tiny.modules.cloak.model.MatchRule;
import com.macro.mall.tiny.modules.cloak.model.MatchRuleTypeEnum;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import static com.macro.mall.tiny.modules.cloak.model.MatchRuleTypeEnum.REGION;

@Service
public class RegionCheck implements MatchRuleCheck{
    @Override
    public boolean support(MatchRuleTypeEnum type) {
        return REGION.equals(type);
    }

    @Override
    public boolean match(MatchRule rule, CloakRequestLogs requestLogs, HttpServletRequest request, String ip,String region) {
        try{
             return rule.getCondition() == region.contains(rule.getValue());
        }catch (Exception e){
            return false;
        }
    }
}
