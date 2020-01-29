package com.address.api.service;

import com.address.api.exception.MessageErrorImpl;
import com.address.api.exceptionhandler.AbstractRuntimeException;
import com.address.api.util.MessagesUtil;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FooServiceTest {

    private FooService fooService = new FooService();

    @Test
    void insert() {

        AbstractRuntimeException abstractRuntimeException = assertThrows(AbstractRuntimeException.class, () -> fooService.throwException());

        assertEquals(MessagesUtil.getMessage(MessageErrorImpl.SERVICE_UNAVAILABLE), abstractRuntimeException.getMessage());
        assertEquals(HttpStatus.SERVICE_UNAVAILABLE, abstractRuntimeException.getHttpStatus());


    }
}