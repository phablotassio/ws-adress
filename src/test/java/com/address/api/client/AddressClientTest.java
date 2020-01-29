package com.address.api.client;

import com.address.api.configuration.RestTemplateConfiguration;
import com.address.api.dto.AddressClientResponseDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.client.ExpectedCount;
import org.springframework.test.web.client.MockRestServiceServer;

import java.net.URI;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withStatus;

@ExtendWith(SpringExtension.class)
@Import(RestTemplateConfiguration.class)
@RestClientTest(AddressClient.class)
class AddressClientTest {

    @Autowired
    private AddressClient addressClient;

    @Autowired
    private MockRestServiceServer server;

    @Test
    void getAddress() throws URISyntaxException {

        server.expect(ExpectedCount.once(),
                requestTo(new URI("http://localhost:8087/73080100/json")))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withStatus(HttpStatus.OK)
                        .contentType(MediaType.APPLICATION_JSON).body("{\n" +
                                "  \"cep\": \"73080-100\",\n" +
                                "  \"logradouro\": \"QMS 55A\",\n" +
                                "  \"complemento\": \"\",\n" +
                                "  \"bairro\": \"Setor de Mansões de Sobradinho\",\n" +
                                "  \"localidade\": \"Brasília\",\n" +
                                "  \"uf\": \"DF\",\n" +
                                "  \"unidade\": \"\",\n" +
                                "  \"ibge\": \"5300108\",\n" +
                                "  \"gia\": \"\"\n" +
                                "}"));

        AddressClientResponseDto responseDto = addressClient.getAddress("73080100");

        assertEquals("73080-100", responseDto.getCep());
        assertEquals("QMS 55A", responseDto.getLogradouro());
        assertEquals("", responseDto.getComplemento());
        assertEquals("Setor de Mansões de Sobradinho", responseDto.getBairro());
        assertEquals("Brasília", responseDto.getLocalidade());
        assertEquals("DF", responseDto.getUf());
        assertEquals("", responseDto.getUnidade());
        assertEquals("5300108", responseDto.getIbge());
        assertEquals("", responseDto.getGia());

        server.verify();


    }
}