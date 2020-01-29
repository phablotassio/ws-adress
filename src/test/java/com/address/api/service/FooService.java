package com.address.api.service;

import com.address.api.exception.MessageErrorImpl;
import com.address.api.exceptionhandler.AbstractRuntimeException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class FooService {

    public void throwException() {

        throw new AbstractRuntimeException(HttpStatus.SERVICE_UNAVAILABLE, MessageErrorImpl.SERVICE_UNAVAILABLE);
    }


}
