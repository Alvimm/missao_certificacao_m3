package com.grupo7.mc_pje.entities;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;


@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "criar_notificacao_request")
public class CriarNotificacaoRequest implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private UUID parteId;
    private UUID enderecoId;
    private String tipoNotificacao;
    private String tipoEnvio;

}

