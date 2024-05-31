package com.macro.mall.tiny.modules.cloak.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Set;


@Getter
@AllArgsConstructor
public enum MatchRuleTypeEnum {
    REGION("所属国家"),
    LANGUAGE("语言"),
    IS_MOBILE("是否移动设备"),
    IS_PROXY("是否开启代理");


    private final String desc;


}
