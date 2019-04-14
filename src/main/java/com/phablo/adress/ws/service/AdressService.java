package com.phablo.adress.ws.service;

import com.phablo.adress.ws.controller.AdressFeingService;
import com.phablo.adress.ws.model.dto.AdressDTO;
import com.phablo.adress.ws.model.mapper.AdressMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdressService {

    @Autowired
    private AdressFeingService adressFeingService;

    @Autowired
    private AdressMapper adressMapper;

    public AdressDTO getAdress(String cep){
        return adressMapper.adressToAdressDTO(adressFeingService.getAdress(cep));
    }

}
