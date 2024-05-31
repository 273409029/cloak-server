package com.macro.mall.tiny.modules.cloak.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.macro.mall.tiny.modules.cloak.model.CloakDomainInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 域名信息表 Mapper 接口
 * </p>
 *
 * @author macro
 * @since 2024-05-22
 */
public interface CloakDomainInfoMapper extends BaseMapper<CloakDomainInfo> {

    default CloakDomainInfo selectByDomainName(String domainName){
        return this.selectOne( new LambdaQueryWrapper<CloakDomainInfo>()
                .eq(CloakDomainInfo::getDomainName, domainName)
                .eq(CloakDomainInfo::getIsDelete, false)
                .last("LIMIT 1"));
    }
}
