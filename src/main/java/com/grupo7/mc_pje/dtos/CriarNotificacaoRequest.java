package com.grupo7.mc_pje.dtos;

import java.util.UUID;

public record CriarNotificacaoRequest(UUID parteId, UUID enderecoId, String tipoNotificacao, String tipoEnvio) {
}
