package com.address.api.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.ExpectedCount;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withStatus;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class AddressControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private MockRestServiceServer mockServer;

    @Autowired
    @Qualifier("restTemplate")
    private RestTemplate restTemplate;

    @BeforeEach
    void setup() {

        mockServer = MockRestServiceServer.createServer(restTemplate);
    }

    @Test
    void get() throws Exception {


        mockServer.expect(ExpectedCount.once(),
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

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/zip-code/73080100")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.zipCode", is("73080-100")))
                .andExpect(jsonPath("$.city", is("Brasília")))
                .andExpect(jsonPath("$.street", is("QMS 55A")))
                .andExpect(jsonPath("$.neighborhood", is("Setor de Mansões de Sobradinho")))
                .andExpect(jsonPath("$.state", is("DF")))
                .andExpect(jsonPath("$.ibgeCode", is("5300108")));


    }


}