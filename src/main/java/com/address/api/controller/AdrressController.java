package com.address.api.controller;

import com.address.api.model.dto.AdressDTO;
import com.address.api.service.AdressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/cep/")
public class AdrressController {

    @Autowired
    private AdressService adressService;

    @GetMapping("{cep}")
    public AdressDTO getCep(@PathVariable String cep) {
        return adressService.getAdress(cep);
    }

}
