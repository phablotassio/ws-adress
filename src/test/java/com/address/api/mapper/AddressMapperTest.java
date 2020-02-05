package com.address.api.mapper;

import com.address.api.dto.AddressClientResponseDto;
import com.address.api.dto.AddressResponseDTO;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.spy;

class AddressMapperTest {


    private AddressMapper addressMapper = Mappers.getMapper(AddressMapper.class);

    @Test
    void addressToAddressResponseDTO() {

        AddressClientResponseDto addressClientResponseDto = spy(AddressClientResponseDto.class);
        addressClientResponseDto.setCep("73080-100");
        addressClientResponseDto.setLogradouro("QMS 55A");
        addressClientResponseDto.setComplemento("Ao lado do longa");
        addressClientResponseDto.setBairro("Setor de Mansões de Sobradinho");
        addressClientResponseDto.setLocalidade("Brasília");
        addressClientResponseDto.setUf("DF");
        addressClientResponseDto.setIbge("5300108");

        AddressResponseDTO addressResponseDTO = addressMapper.addressToAddressResponseDTO(addressClientResponseDto);

        assertEquals("73080100", addressResponseDTO.getZipCode());
        assertEquals("QMS 55A", addressResponseDTO.getStreet());
        assertEquals("Ao lado do longa", addressResponseDTO.getComplement());
        assertEquals("Setor de Mansões de Sobradinho", addressResponseDTO.getNeighborhood());
        assertEquals("Brasília", addressResponseDTO.getCity());
        assertEquals("DF", addressResponseDTO.getState());
        assertEquals("5300108", addressResponseDTO.getIbgeCode());
    }

    @Test
    void addressToAddressResponseDTOWithoutComplement() {

        AddressClientResponseDto addressClientResponseDto = spy(AddressClientResponseDto.class);
        addressClientResponseDto.setCep("73080-100");
        addressClientResponseDto.setLogradouro("QMS 55A");
        addressClientResponseDto.setComplemento("");
        addressClientResponseDto.setBairro("Setor de Mansões de Sobradinho");
        addressClientResponseDto.setLocalidade("Brasília");
        addressClientResponseDto.setUf("DF");
        addressClientResponseDto.setIbge("5300108");

        AddressResponseDTO addressResponseDTO = addressMapper.addressToAddressResponseDTO(addressClientResponseDto);

        assertEquals("73080100", addressResponseDTO.getZipCode());
        assertEquals("QMS 55A", addressResponseDTO.getStreet());
        assertNull(addressResponseDTO.getComplement());
        assertEquals("Setor de Mansões de Sobradinho", addressResponseDTO.getNeighborhood());
        assertEquals("Brasília", addressResponseDTO.getCity());
        assertEquals("DF", addressResponseDTO.getState());
        assertEquals("5300108", addressResponseDTO.getIbgeCode());
    }


    @Test
    void addressToAddressResponseDTOWithNullParam() {

        AddressResponseDTO addressResponseDTO = addressMapper.addressToAddressResponseDTO(null);

        assertNull(addressResponseDTO);
    }
}