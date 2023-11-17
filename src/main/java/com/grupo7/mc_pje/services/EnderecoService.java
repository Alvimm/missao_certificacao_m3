/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo7.mc_pje.services;

import com.grupo7.mc_pje.entities.Endereco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.grupo7.mc_pje.repositories.EnderecoRepository;

import java.util.UUID;

/**
 *
 * @author Nanda
 */
@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public Endereco salvarEndereco(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }
    
    public Endereco obterEnderecoPorId(UUID id) {
    return enderecoRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Endereco nao encontrado com ID: " + id));
    }
}
