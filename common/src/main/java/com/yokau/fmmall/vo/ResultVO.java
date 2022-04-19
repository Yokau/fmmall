package com.yokau.fmmall.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResultVO {
    //响应给前端的状态码
    private int code;
    //响应给前段的提示信息
    private String msg;
    //响应给前段的数据
    private Object data;
}
