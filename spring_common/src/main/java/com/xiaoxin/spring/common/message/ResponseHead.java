package com.xiaoxin.spring.common.message;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class ResponseHead implements Serializable {

    private static final long serialVersionUID = -1947086273391027325L;

    /** 状态码 */
    private String code;
    /** 消息 */
    private String message;
    /** 状态 */
    private String status;
    /** 响应时间 */
    private String serverDate;

    public ResponseHead(ResponseCode code) {
        this.code = code.getCode();
        this.message = code.getMessage();
        this.status = code.getStatus();
        this.serverDate = LocalDateTime.now().toString();
    }
}
