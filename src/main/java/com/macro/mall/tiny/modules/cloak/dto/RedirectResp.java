package com.macro.mall.tiny.modules.cloak.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
@Data
public class RedirectResp {

    @ApiModelProperty(value = "重定向地址",required = true)
    private String url;

}
