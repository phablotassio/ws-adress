package com.address.api.service;

import com.address.api.client.AddressClient;
import com.address.api.dto.AddressClientResponseDto;
import com.address.api.exception.MessageErrorImpl;
import com.address.api.exceptionhandler.AbstractRuntimeException;
import com.address.api.mapper.AddressMapper;
import com.address.api.util.MessagesUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AddressServiceTest {

    @InjectMocks
    private AddressService addressService;

    @Mock
    private AddressClient addressClient;

    @Mock
    private AddressMapper addressMapper;

    private final int ONE_INVOCATION = 1;

    @Test
    void getAddress() {

        AddressClientResponseDto addressClientResponseDto = spy(AddressClientResponseDto.class);

        when(addressClient.getAddress(anyString())).thenReturn(addressClientResponseDto);

        addressService.getAddress("73080-100");

        verify(addressMapper, times(ONE_INVOCATION)).addressToAddressResponseDTO(addressClientResponseDto);
        verify(addressClient, times(ONE_INVOCATION)).getAddress("73080100");


    }

    @Test
    void getAddressWithInvalidZipCode() {

        AbstractRuntimeException abstractRuntimeException = assertThrows(AbstractRuntimeException.class, () -> addressService.getAddress("73080-100321321"));

        assertEquals(HttpStatus.BAD_REQUEST, abstractRuntimeException.getHttpStatus());
        assertEquals(MessagesUtil.getMessage(MessageErrorImpl.INVALID_ZIP_CODE), abstractRuntimeException.getMessage());
        assertEquals(MessagesUtil.getMessage(MessageErrorImpl.INVALID_ZIP_CODE), abstractRuntimeException.getMessages().get(0));

    }


    @Test
    void getAddressWithInvalidZipCodeNotFound() {

        AddressClientResponseDto addressClientResponseDto = spy(AddressClientResponseDto.class);

        when(addressClient.getAddress(anyString())).thenReturn(addressClientResponseDto);
        addressClientResponseDto.setErro(Boolean.TRUE);

        AbstractRuntimeException abstractRuntimeException = assertThrows(AbstractRuntimeException.class, () -> addressService.getAddress("73080-100"));

        assertEquals(HttpStatus.NOT_FOUND, abstractRuntimeException.getHttpStatus());
        assertEquals(MessagesUtil.getMessage(MessageErrorImpl.ZIP_CODE_NOT_FOUND), abstractRuntimeException.getMessage());
        assertEquals(MessagesUtil.getMessage(MessageErrorImpl.ZIP_CODE_NOT_FOUND), abstractRuntimeException.getMessages().get(0));

    }
}