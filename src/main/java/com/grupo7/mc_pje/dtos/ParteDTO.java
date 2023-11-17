package com.grupo7.mc_pje.dtos;

import com.grupo7.mc_pje.entities.Endereco;

public record ParteDTO(String nome, String documento, String email, String cep, String numero, Endereco endereco) {
}
