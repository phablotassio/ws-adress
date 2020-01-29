package com.address.api.mapper;

import com.address.api.dto.AddressClientResponseDto;
import com.address.api.dto.AddressResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    @Mapping(source = "localidade", target = "city")
    @Mapping(source = "cep", target = "zipCode")
    @Mapping(source = "uf", target = "state")
    @Mapping(source = "bairro", target = "neighborhood")

    AddressResponseDTO addressToAddressResponseDTO(AddressClientResponseDto addressClientResponseDto);

}
