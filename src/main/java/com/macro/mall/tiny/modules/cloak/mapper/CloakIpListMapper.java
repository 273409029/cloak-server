package com.macro.mall.tiny.modules.cloak.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.macro.mall.tiny.modules.cloak.model.CloakDomainInfo;
import com.macro.mall.tiny.modules.cloak.model.CloakIpList;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * ip表 Mapper 接口
 * </p>
 *
 * @author macro
 * @since 2024-05-22
 */
public interface CloakIpListMapper extends BaseMapper<CloakIpList> {
    default Boolean exist(String ip, Long tenantId,Boolean isWhite){
        return this.exists( new LambdaQueryWrapper<CloakIpList>()
                .eq(CloakIpList::getId, ip)
                .eq(CloakIpList::getTenantId, tenantId)
                .eq(CloakIpList::getIsWhite, isWhite)
                .eq(CloakIpList::getIsDelete, false));
    }
}
