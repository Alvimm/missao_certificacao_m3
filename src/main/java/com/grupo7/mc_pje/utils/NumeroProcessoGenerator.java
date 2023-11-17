/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo7.mc_pje.utils;

import java.util.Random;

/**
 *
 * @author Nanda
 */

public class NumeroProcessoGenerator {

    private static final String[] TIPOS_PROCESSO = {
            "Intimação Judicial",
            "Notificação sobre o processo",
            "Conclusão do processo",
            "Decisão Judicial",
            // Adicionar outros tipos de processo se necessário
    };

    public static String gerarNumeroProcesso() {
        Random random = new Random();
        StringBuilder numeroProcesso = new StringBuilder();
        
        for (int i = 0; i < 14; i++) {
            numeroProcesso.append(random.nextInt(10));
            if (i == 6 || i == 9 || i == 12) {
                numeroProcesso.append(".");
            }
        }
     
        numeroProcesso.append("-");
        numeroProcesso.append(TIPOS_PROCESSO[random.nextInt(TIPOS_PROCESSO.length)].charAt(0));

        return numeroProcesso.toString();
    }

    public static void main(String[] args) {
        String numeroProcesso = gerarNumeroProcesso();
        System.out.println(numeroProcesso);
    }
}
