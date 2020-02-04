package com.address.api.exception;

public enum MessageErrorImpl implements MessageError{

    MALFORMED_REQUEST_JSON(1),
    JSON_TO_OBJECT_FAIL(2),
    OBJECT_TO_JSON_FAIL(3),
    SERVICE_UNAVAILABLE(4),
    INVALID_ZIP_CODE(5),
    ZIP_CODE_NOT_FOUND(6);

    private Integer code;

    MessageErrorImpl(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

}
