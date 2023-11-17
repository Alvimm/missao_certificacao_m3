package com.grupo7.mc_pje.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "notificacao")
public class Notificacao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "parte_id")
    private Parte parte;
    @ManyToOne
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;
    private String tipoProcesso;
    private String numeroProcesso;
    @Lob
    private String dadosNotificacao;
    private String tipoNotificacao; // "correios", "email" ou "DJe"
    private String status; // "não notificado", "enviado"
    private Date dataEnvio;

}
