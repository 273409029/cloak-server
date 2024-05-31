package com.macro.mall.tiny.modules.cloak.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.macro.mall.tiny.modules.cloak.model.CloakRequestLogs;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.Instant;

/**
 * <p>
 * 请求日志表 服务类
 * </p>
 *
 * @author macro
 * @since 2024-05-22
 */
public interface CloakRequestLogsService extends IService<CloakRequestLogs> {

    Page<CloakRequestLogs> pageList(Integer pageSize, Integer pageNum,String domainName,
                                   Boolean isCheck,
                                    Long startTime,
                                    Long endTime);
}
