package com.phablo.adress.ws.service;

import com.phablo.adress.ws.controller.AdressFeingService;
import com.phablo.adress.ws.model.Adress;
import com.phablo.adress.ws.model.dto.AdressDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdressService {

    @Autowired
    private AdressFeingService adressFeingService;

    public Adress getAdress(String cep){
        AdressDTO adressDTO = adressFeingService.getAdress(cep);
        return converDTOtoAdress(adressDTO);
    }

    public Adress converDTOtoAdress(AdressDTO adressDTO){

        Adress adress = new Adress();
        adress.setBairro(adressDTO.getBairro());
        adress.setEstado(adressDTO.getEstado_info().getNome());
        adress.setCep(adressDTO.getCep());
        adress.setLogradouro(adressDTO.getLogradouro());
        adress.setCidade(adressDTO.getCidade());

        return  adress;

    }


}
