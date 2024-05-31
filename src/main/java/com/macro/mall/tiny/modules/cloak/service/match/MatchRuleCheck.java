package com.macro.mall.tiny.modules.cloak.service.match;

import com.macro.mall.tiny.modules.cloak.dto.RedirectReq;
import com.macro.mall.tiny.modules.cloak.model.CloakRequestLogs;
import com.macro.mall.tiny.modules.cloak.model.MatchRule;
import com.macro.mall.tiny.modules.cloak.model.MatchRuleTypeEnum;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

public interface MatchRuleCheck {
    boolean support(MatchRuleTypeEnum type);

    boolean match(MatchRule rule, CloakRequestLogs requestLogs, HttpServletRequest request, String ip,String region);
}
