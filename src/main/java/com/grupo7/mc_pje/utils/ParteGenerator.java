/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo7.mc_pje.utils;

import com.grupo7.mc_pje.entities.Endereco;
import com.grupo7.mc_pje.entities.Parte;
import java.util.Random;

/**
 *
 * @author Nanda
 */

public class ParteGenerator {

    private static final String[] SOBRENOMES = {
            "Silva",
            "Souza",
            "Oliveira",
            "Pereira",
            "Costa",           
    };

    private static final String[] NOMES = {
            "Ana",
            "João",
            "Maria",
            "Pedro",
            "Luisa",            
    };

    private static final String[] EMAILS = {
            "exemplo@gmail.com",
            "outroexemplo@hotmail.com",
            "maisumexemplo@yahoo.com",            
    };

    private static final String[] CEP_COMPLEMENTOS = {
            "Bloco A",
            "Casa 101",
            "Apto 302",
            "Condomínio X",            
    };

    public static Parte gerarParte() {
        Random random = new Random();
        Parte parte = new Parte();

        parte.setNome(NOMES[random.nextInt(NOMES.length)] + " " + SOBRENOMES[random.nextInt(SOBRENOMES.length)]);
        parte.setDocumento(gerarDocumento());
        parte.setEmail(random.nextBoolean() ? EMAILS[random.nextInt(EMAILS.length)] : null);
        parte.setEndereco(gerarEndereco());

        return parte;
    }

    private static String gerarDocumento() {
        Random random = new Random();
        StringBuilder documento = new StringBuilder();

        // Gera CPF (11 caracteres) ou CNPJ (14 caracteres)
        if (random.nextBoolean()) {
            for (int i = 0; i < 11; i++) {
                documento.append(random.nextInt(10));
            }
        } else {
            for (int i = 0; i < 14; i++) {
                documento.append(random.nextInt(10));
            }
        }

        return documento.toString();
    }

    private static Endereco gerarEndereco() {
        Random random = new Random();
        Endereco endereco = new Endereco();

        // Adiciona CEP
        endereco.setCep(gerarCEP());

        // Adiciona número da casa
        endereco.setNumero(random.nextInt(1000));

        // Adiciona complemento se for um condomínio
        if (random.nextBoolean()) {
            endereco.setComplemento(CEP_COMPLEMENTOS[random.nextInt(CEP_COMPLEMENTOS.length)]);
        }

        return endereco;
    }

    private static String gerarCEP() {
        Random random = new Random();
        StringBuilder cep = new StringBuilder();

        for (int i = 0; i < 8; i++) {
            cep.append(random.nextInt(10));
        }

        return cep.toString();
    }

    public static void main(String[] args) {
        Parte parte = gerarParte();
        System.out.println("Nome: " + parte.getNome());
        System.out.println("Documento: " + parte.getDocumento());
        System.out.println("Email: " + parte.getEmail());
        System.out.println("Endereço: " + parte.getEndereco());
    }
}

