package com.address.api.service;

import com.address.api.model.mapper.AdressMapper;
import com.address.api.client.AddressClient;
import com.address.api.model.dto.AdressDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdressService {

    @Autowired
    private AddressClient addressClient;

    @Autowired
    private AdressMapper adressMapper;

    public AdressDTO getAdress(String cep){
        return adressMapper.adressToAdressDTO(addressClient.getAddress(cep));
    }

}
