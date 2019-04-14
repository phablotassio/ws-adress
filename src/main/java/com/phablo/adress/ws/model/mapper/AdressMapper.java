package com.phablo.adress.ws.model.mapper;

import com.phablo.adress.ws.model.Adress;
import com.phablo.adress.ws.model.dto.AdressDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AdressMapper {

    @Mapping(source = "estado_info.nome", target = "estado")
    AdressDTO adressToAdressDTO(Adress adress);

}
