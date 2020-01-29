package com.address.api.controller;

import com.address.api.dto.AddressResponseDTO;
import com.address.api.service.AddressService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/zip-code/")
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("{zip-code}")
    public AddressResponseDTO getCep(@PathVariable("zip-code") String zipCode) {
        return addressService.getAddress(zipCode);
    }

}
