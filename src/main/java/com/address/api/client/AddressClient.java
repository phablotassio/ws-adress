package com.address.api.client;

import com.address.api.dto.AddressClientResponseDto;
import com.address.api.util.UrlUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AddressClient {

    @Value("${address.host}")
    private String addressHost;

    private RestTemplate restTemplate;

    public AddressClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public AddressClientResponseDto getAddress(String zipCode) {

        return restTemplate.exchange(addressHost.trim() + UrlUtils.ADDRESS_URL, HttpMethod.GET, new HttpEntity<>(new HttpHeaders()), AddressClientResponseDto.class, zipCode).getBody();
    }
}
