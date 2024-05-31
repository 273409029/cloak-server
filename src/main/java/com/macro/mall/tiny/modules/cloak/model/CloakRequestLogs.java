package com.macro.mall.tiny.modules.cloak.model;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.extension.handlers.AbstractJsonTypeHandler;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.util.CollectionUtils;

/**
 * <p>
 * 请求日志表
 * </p>
 *
 * @author macro
 * @since 2024-05-22
 */
@Getter
@Setter
@TableName(value = "cloak_request_logs", autoResultMap = true)
@ApiModel(value = "CloakRequestLogs对象", description = "请求日志表")
public class CloakRequestLogs implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("请求的域名")
    private String domainName;

    @ApiModelProperty("请求IP")
    private String requestIp;

    @ApiModelProperty("IP所属地区")
    private String ipRegion;

    @ApiModelProperty("请求的用户代理（User-Agent）")
    private String userAgent;
    @ApiModelProperty("租户id")
    private Long tenantId;
    @ApiModelProperty("域名是否开启审核开关，0为关闭，1为开启")
    private Boolean checkStatus;

    @ApiModelProperty("匹配规则命中，未命中为NULL")
    @TableField(typeHandler = ArrayJacksonTypeHandler.class)
    private List<MatchRule> ruleMatched;

    @ApiModelProperty("重定向地址，未重定向为NULL")
    private String redirectUrl;

    @ApiModelProperty("header信息")
    private String headerInfo;

    @ApiModelProperty("创建时间")
    private Instant createTime;

    @ApiModelProperty("更新时间")
    private Instant updateTime;

    @ApiModelProperty("软删除")
    private Boolean isDelete;


    public static class ArrayJacksonTypeHandler extends AbstractJsonTypeHandler<List<MatchRule>> {

        public static final ObjectMapper mapper = new ObjectMapper();

        @Override
        protected List<MatchRule> parse(String json) {
            return JSONUtil.toList(json, MatchRule.class);
        }

        @Override
        protected String toJson(List<MatchRule> obj) {
            return CollectionUtils.isEmpty(obj)
                    ? JSONUtil.toJsonStr(new ArrayList())
                    : JSONUtil.toJsonStr(obj);
        }
    }
}
