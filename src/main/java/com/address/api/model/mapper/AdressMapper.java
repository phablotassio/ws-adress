package com.address.api.model.mapper;

import com.address.api.model.Adress;
import com.address.api.model.dto.AdressDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AdressMapper {

    @Mapping(source = "estado_info.nome", target = "estado")
    AdressDTO adressToAdressDTO(Adress adress);

}
