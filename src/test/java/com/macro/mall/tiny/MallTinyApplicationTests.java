package com.macro.mall.tiny;
import cn.hutool.json.JSONUtil;
import com.macro.mall.tiny.modules.cloak.model.MatchRuleTypeEnum;
import java.time.Instant;
import java.util.ArrayList;

import com.macro.mall.tiny.modules.cloak.mapper.CloakDomainInfoMapper;
import com.macro.mall.tiny.modules.cloak.model.CloakDomainInfo;
import com.macro.mall.tiny.modules.cloak.model.MatchRule;
import com.macro.mall.tiny.modules.ums.dto.UpdateAdminPasswordParam;
import com.macro.mall.tiny.modules.ums.mapper.UmsAdminLoginLogMapper;
import com.macro.mall.tiny.modules.ums.mapper.UmsResourceMapper;
import com.macro.mall.tiny.modules.ums.mapper.UmsRoleMapper;
import com.macro.mall.tiny.modules.ums.model.UmsAdmin;
import com.macro.mall.tiny.modules.ums.service.UmsAdminCacheService;
import com.macro.mall.tiny.modules.ums.service.UmsAdminRoleRelationService;
import com.macro.mall.tiny.modules.ums.service.UmsAdminService;
import com.macro.mall.tiny.modules.ums.service.impl.UmsAdminServiceImpl;
import com.macro.mall.tiny.security.util.JwtTokenUtil;
import com.macro.mall.tiny.security.util.SpringUtil;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
public class MallTinyApplicationTests {

    private static final Logger LOGGER = LoggerFactory.getLogger(UmsAdminServiceImpl.class);
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UmsAdminLoginLogMapper loginLogMapper;
    @Autowired
    private UmsAdminRoleRelationService adminRoleRelationService;
    @Autowired
    private UmsRoleMapper roleMapper;
    @Autowired
    private CloakDomainInfoMapper cloakDomainInfoMapper;
    @Test
    public void contextLoads() {
        SpringUtil.getBean(UmsAdminCacheService.class).delAdmin(3L);
    }

    @Test
    public void cloakDomainInfoMappertest1() {
        CloakDomainInfo cloakDomainInfo = new CloakDomainInfo();
        ArrayList<MatchRule> matchRules = new ArrayList<>();
        MatchRule matchRule = new MatchRule();
        matchRule.setMatchRuleType(MatchRuleTypeEnum.REGION);
        matchRule.setCondition(true);
        matchRule.setValue("中国");

        matchRules.add(matchRule);
        cloakDomainInfo.setDescription("test");
        cloakDomainInfo.setIsCheck(false);
        cloakDomainInfo.setMaskRedirectUrl("www.baidu.com");
        cloakDomainInfo.setWhiteListRedirectUrl("www.google.com");
        cloakDomainInfo.setMatchRule(matchRules);
        cloakDomainInfo.setTenantId(0L);
        cloakDomainInfo.setIsDelete(false);

        cloakDomainInfo.setDomainName("test");


        cloakDomainInfoMapper.insert(cloakDomainInfo);
    }

}
