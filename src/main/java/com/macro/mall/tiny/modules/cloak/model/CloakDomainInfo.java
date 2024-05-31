package com.macro.mall.tiny.modules.cloak.model;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.Date;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 域名信息表
 * </p>
 *
 * @author macro
 * @since 2024-05-22
 */
@Getter
@Setter
@TableName(value = "cloak_domain_info",autoResultMap = true)
@ApiModel(value = "CloakDomainInfo对象", description = "域名信息表")
public class CloakDomainInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("为用户分配的域名")
    private String domainName;

    @ApiModelProperty("绑定域名")
    private String domainPrefix;

    @ApiModelProperty("介绍")
    private String description;

    @ApiModelProperty("是否正在审核中")
    private Boolean isCheck;

    @ApiModelProperty("开启审核 && 黑名单用户 && 匹配规则未命中重定向地址")
    private String maskRedirectUrl;

    @ApiModelProperty("开启审核 && 黑名单用户 && 匹配规则未命中重定向地址")
    private String whiteListRedirectUrl;

    @ApiModelProperty("匹配规则")
    @TableField(typeHandler = CloakRequestLogs.ArrayJacksonTypeHandler.class)
    private List<MatchRule> matchRule;

    @ApiModelProperty("租户id")
    private Long tenantId;

    @ApiModelProperty("创建时间")
    private Instant createTime;

    @ApiModelProperty("更新时间")
    private Instant updateTime;

    @ApiModelProperty("软删除")
    private Boolean isDelete;


}
