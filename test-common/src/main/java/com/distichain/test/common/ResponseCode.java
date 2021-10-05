package com.distichain.test.common;

import lombok.Getter;

@Getter
public enum  ResponseCode {

    TECHNICAL_ERROR(-1, "Technical Error"),
    SUCCESS(0, "Success"),
    SKU_ALREADY_EXIST(1, "Sku already exist"),
    SKU_NOT_EXIST(2, "Sku not exist");

    private Integer code;
    private String description;

    ResponseCode(Integer code, String description) {
        this.code = code;
        this.description = description;
    }
}
