package com.address.api.service;

import com.address.api.client.AddressClient;
import com.address.api.dto.AddressClientResponseDto;
import com.address.api.dto.AddressResponseDTO;
import com.address.api.exception.MessageErrorImpl;
import com.address.api.exceptionhandler.AbstractRuntimeException;
import com.address.api.mapper.AddressMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AddressService {

    private final AddressClient addressClient;

    private final AddressMapper addressMapper;

    public AddressService(AddressClient addressClient, AddressMapper addressMapper) {
        this.addressClient = addressClient;
        this.addressMapper = addressMapper;
    }

    public AddressResponseDTO getAddress(String zipCode) {

        int SIZE_ZIP_CODE = 8;

        String unmaskedZipCode = zipCode.trim().replaceAll("\\D", "");

        if (unmaskedZipCode.length() != SIZE_ZIP_CODE) {
            throw new AbstractRuntimeException(HttpStatus.BAD_REQUEST, MessageErrorImpl.INVALID_ZIP_CODE);
        }

        AddressClientResponseDto address = addressClient.getAddress(zipCode);

        if(Objects.nonNull(address.isErro())){
           throw new AbstractRuntimeException(HttpStatus.NOT_FOUND, MessageErrorImpl.ZIP_CODE_NOT_FOUND);
       }

        return addressMapper.addressToAddressResponseDTO(address);
    }

}
