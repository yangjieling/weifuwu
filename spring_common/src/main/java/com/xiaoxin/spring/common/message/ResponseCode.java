package com.xiaoxin.spring.common.message;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResponseCode {

    SUCCESS("000000","SUCCESS", "成功"),
    EXCEPTION("000000","SUCCESS", "异常"),
    ERROR("000000","SUCCESS", "错误");

    private String code;
    private String status;
    private String message;
}
