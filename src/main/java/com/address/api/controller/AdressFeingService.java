package com.address.api.controller;

import com.address.api.model.Adress;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@FeignClient(name = "cepService", url = "http://api.postmon.com.br")
public interface AdressFeingService {

    @RequestMapping("/v1/cep/{cep}")
    Adress getAdress(@PathVariable("cep") String cep);
}
