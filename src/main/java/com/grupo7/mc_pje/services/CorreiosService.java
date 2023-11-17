/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo7.mc_pje.services;

import entities.Endereco;
import entities.EnderecoCorreios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Nanda
 */

@Service
public class CorreiosService {
    
    @Autowired
    private EnderecoService enderecoService;

    public EnderecoCorreios obterEnderecoPorCep(String cep) {
        // Validação do formato do CEP
        if (!validarFormatoCep(cep)) {            
            throw new IllegalArgumentException("Formato de CEP invalido");
        }
        
        String url = "https://viacep.com.br/ws/" + cep + "/json/";

        RestTemplate restTemplate = new RestTemplate();
        try {
            ResponseEntity<EnderecoCorreios> responseEntity = restTemplate.getForEntity(url, EnderecoCorreios.class);
            EnderecoCorreios enderecoCorreios = responseEntity.getBody();

            // Verifica se houve erro na consulta
            if (enderecoCorreios != null && enderecoCorreios.isErro()) {                
                throw new IllegalArgumentException("CEP inexistente");
            }
            
            salvarEnderecoNoBanco(enderecoCorreios);
            return enderecoCorreios;
        } catch (HttpClientErrorException ex) {
            // Se o status da resposta for 400 (Bad Request), trata como CEP inexistente
            if (ex.getStatusCode() == HttpStatus.BAD_REQUEST) {               
                throw new IllegalArgumentException("CEP inexistente");
            }
            throw ex;
        }
    }
    
    private void salvarEnderecoNoBanco(EnderecoCorreios enderecoCorreios) {
        // Crie uma instância de Endereco usando os dados de EnderecoCorreios
        // Pode ser necessário mapear os dados, dependendo da estrutura das classes
        Endereco endereco = new Endereco();
        endereco.setCep(enderecoCorreios.getCep());
        endereco.setLogradouro(enderecoCorreios.getLogradouro());
        endereco.setComplemento(enderecoCorreios.getComplemento());
        endereco.setBairro(enderecoCorreios.getBairro());
        endereco.setLocalidade(enderecoCorreios.getLocalidade());
        endereco.setUf(enderecoCorreios.getUf());

        // Use o serviço EnderecoService para salvar o endereço no banco de dados
        enderecoService.salvarEndereco(endereco);
    }

    private boolean validarFormatoCep(String cep) {
        return cep != null && cep.matches("\\d{8}");
    }
}
