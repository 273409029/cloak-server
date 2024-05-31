package com.macro.mall.tiny.modules.cloak.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.macro.mall.tiny.modules.cloak.model.CloakDomainInfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 域名信息表 服务类
 * </p>
 *
 * @author macro
 * @since 2024-05-22
 */
public interface CloakDomainInfoService extends IService<CloakDomainInfo> {

    Page<CloakDomainInfo> pageList(Integer pageSize, Integer pageNum,String domainName);
}
