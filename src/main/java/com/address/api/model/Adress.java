package com.address.api.model;

public class Adress {

    private String cep;
    private String cidade;
    private String logradouro;
    private String bairro;
    private String uf;
    private StateInfo estado_info;

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public StateInfo getEstado_info() {
        return estado_info;
    }

    public void setEstado_info(StateInfo estado_info) {
        this.estado_info = estado_info;
    }
}
