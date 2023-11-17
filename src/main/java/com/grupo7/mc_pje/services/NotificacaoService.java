/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo7.mc_pje.services;
import com.grupo7.mc_pje.entities.Endereco;
import com.grupo7.mc_pje.entities.Notificacao;
import com.grupo7.mc_pje.entities.Parte;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.grupo7.mc_pje.repositories.NotificacaoRepository;
import com.grupo7.mc_pje.repositories.ParteRepository;


@Service
public class NotificacaoService {

    @Autowired
    private NotificacaoRepository notificacaoRepository; 

    @Autowired
    private ParteRepository parteRepository;

    public Notificacao criarNotificacao(Parte parte, Endereco endereco, String tipoNotificacao, String tipoEnvio) {
        Notificacao notificacao = new Notificacao();
        notificacao.setParte(parte);
        notificacao.setEndereco(endereco);
        notificacao.setTipoNotificacao(tipoNotificacao);
        notificacao.setDataEnvio(new Date());
        notificacao.setStatus("não enviado");

        notificacao.setDadosNotificacao(gerarDadosNotificacaoString(parte, endereco, tipoNotificacao));

        // Salva a notificação no banco de dados
        return notificacaoRepository.save(notificacao);
    }

    private String gerarDadosNotificacaoString(Parte parte, Endereco endereco, String tipoNotificacao) {
        return String.format("{\"nome\": \"%s\", \"endereco\": \"%s %s, %s - %s\", \"tipoNotificacao\": \"%s\"}",
                parte.getNome(),
                endereco.getLogradouro(),
                endereco.getNumero(),
                endereco.getBairro(),
                endereco.getLocalidade(),
                tipoNotificacao);
    }

    public void criarNotificacao(Notificacao notificacao) {
        validarNotificacao(notificacao);

        // Atualiza o status antes de salvar
        notificacao.setStatus("não notificado");
        notificacao.setDataEnvio(new Date());

        // Salva a notificação
        notificacaoRepository.save(notificacao);
    }

    private void validarNotificacao(Notificacao notificacao) {
        if (notificacao.getParte() == null || !parteRepository.existsById(notificacao.getParte().getId())) {
            throw new IllegalArgumentException("Parte associada à notificação não existe");
        }
    }

    public void enviarNotificacao(Notificacao notificacao) {
        // Implemente a lógica de envio de notificação aqui
        // Pode ser o envio por e-mail, integração com API dos Correios, etc.
    }

    public List<Notificacao> consultarNotificacoesCorreios() {
        return notificacaoRepository.findByTipoNotificacao("correios");
    }

    public List<Notificacao> consultarNotificacoesEmail() {
        return notificacaoRepository.findByTipoNotificacao("email");
    }

    public List<Notificacao> consultarNotificacoesDje() {
        // Implemente a lógica para obter notificações DJe
        return notificacaoRepository.findByTipoNotificacao("DJe");
    }

    public List<Notificacao> obterNotificacoesCorreiosNaoEnviadas() {
        return notificacaoRepository.findByTipoNotificacaoAndTipoEnvioAndStatus("correios", "não enviado", "não enviado");
    }


}

