package com.macro.mall.tiny.modules.cloak.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Map;

@Data
public class RedirectReq {


    private Map<String,String> queryParams;

}
