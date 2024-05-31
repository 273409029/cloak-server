package com.macro.mall.tiny.modules.cloak.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.macro.mall.tiny.modules.cloak.model.CloakDomainInfo;
import com.macro.mall.tiny.modules.cloak.mapper.CloakDomainInfoMapper;
import com.macro.mall.tiny.modules.cloak.model.CloakDomainInfo;
import com.macro.mall.tiny.modules.cloak.service.CloakDomainInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Objects;

/**
 * <p>
 * 域名信息表 服务实现类
 * </p>
 *
 * @author macro
 * @since 2024-05-22
 */
@Service
public class CloakDomainInfoServiceImpl extends ServiceImpl<CloakDomainInfoMapper, CloakDomainInfo> implements CloakDomainInfoService {

    @Override
    public Page<CloakDomainInfo> pageList(Integer pageSize, Integer pageNum,String domainName) {
        Page<CloakDomainInfo> page = new Page<>(pageNum,pageSize);
        LambdaQueryWrapper<CloakDomainInfo> wrapper = new LambdaQueryWrapper<CloakDomainInfo>()
                .like(StringUtils.isNotBlank(domainName), CloakDomainInfo::getDomainName, domainName)
                .orderByDesc(CloakDomainInfo::getCreateTime);
        return page(page,wrapper);
    }
}
