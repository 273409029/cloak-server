package com.macro.mall.tiny.modules.cloak.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.Instant;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * ip表
 * </p>
 *
 * @author macro
 * @since 2024-05-22
 */
@Getter
@Setter
@TableName("cloak_ip_list")
@ApiModel(value = "CloakIpList对象", description = "ip表")
public class CloakIpList implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("租户id")
    private Integer tenantId;

    @ApiModelProperty("请求IP")
    private String requestIp;

    @ApiModelProperty("0-否：黑名单，1-是：白名单")
    private Boolean isWhite;

    @ApiModelProperty("创建时间")
    private Instant createTime;

    @ApiModelProperty("更新时间")
    private Instant updateTime;

    @ApiModelProperty("软删除")
    private Boolean isDelete;


}
