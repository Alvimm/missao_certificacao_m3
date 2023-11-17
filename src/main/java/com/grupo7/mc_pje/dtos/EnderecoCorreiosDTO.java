package com.grupo7.mc_pje.dtos;

public record EnderecoCorreiosDTO(String cep, String logradouro, String complemento, String bairro, String localidade, String uf, String ibge, String gia, String ddd, String siafi, boolean erro) {
}
