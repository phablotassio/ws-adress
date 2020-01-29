package com.address.api.mapper;

import com.address.api.dto.AddressClientResponseDto;
import com.address.api.dto.AddressResponseDTO;
import org.apache.commons.lang3.StringUtils;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    @Mapping(source = "localidade", target = "city")
    @Mapping(source = "cep", target = "zipCode")
    @Mapping(source = "uf", target = "state")
    @Mapping(source = "bairro", target = "neighborhood")
    @Mapping(source = "logradouro", target = "street")
    @Mapping(source = "complemento", target = "complement", qualifiedByName = "mapComplement")
    @Mapping(source = "ibge", target = "ibgeCode")
    AddressResponseDTO addressToAddressResponseDTO(AddressClientResponseDto addressClientResponseDto);

    @Named("mapComplement")
    default String mapComplement(String complement) {

        return StringUtils.isBlank(complement) ? null : complement;
    }

}
