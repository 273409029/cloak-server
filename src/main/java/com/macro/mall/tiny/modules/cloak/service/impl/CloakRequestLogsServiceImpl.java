package com.macro.mall.tiny.modules.cloak.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.macro.mall.tiny.modules.cloak.model.CloakDomainInfo;
import com.macro.mall.tiny.modules.cloak.model.CloakRequestLogs;
import com.macro.mall.tiny.modules.cloak.mapper.CloakRequestLogsMapper;
import com.macro.mall.tiny.modules.cloak.service.CloakRequestLogsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Objects;

/**
 * <p>
 * 请求日志表 服务实现类
 * </p>
 *
 * @author macro
 * @since 2024-05-22
 */
@Service
public class CloakRequestLogsServiceImpl extends ServiceImpl<CloakRequestLogsMapper, CloakRequestLogs> implements CloakRequestLogsService {

    @Override
    public Page<CloakRequestLogs> pageList(Integer pageSize, Integer pageNum,String domainName,
                                           Boolean isCheck,
                                           Long startTime,
                                           Long endTime) {
        Page<CloakRequestLogs> page = new Page<>(pageNum,pageSize);
        LambdaQueryWrapper<CloakRequestLogs> wrapper = new LambdaQueryWrapper<CloakRequestLogs>().eq(Objects.nonNull(isCheck), CloakRequestLogs::getCheckStatus, isCheck)
                .like(StringUtils.isNotBlank(domainName), CloakRequestLogs::getDomainName, domainName);
        if(Objects.nonNull(startTime)){
            wrapper.gt(CloakRequestLogs::getCreateTime, Instant.ofEpochMilli(startTime));
        }
        if(Objects.nonNull(endTime)){
            wrapper.lt(CloakRequestLogs::getCreateTime, Instant.ofEpochMilli(endTime));
        }
        return page(page,wrapper);
    }
}
