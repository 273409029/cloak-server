package com.macro.mall.tiny.modules.cloak.model;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.Instant;

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
@ApiModel(value = "匹配规则", description = "匹配规则")
public class MatchRule  {

    @ApiModelProperty("规则")
    private MatchRuleTypeEnum matchRuleType;

    @ApiModelProperty("条件")
    private Boolean condition;

    @ApiModelProperty("值")
    private String value;


}
