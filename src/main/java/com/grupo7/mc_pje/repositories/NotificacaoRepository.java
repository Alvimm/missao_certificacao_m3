package com.grupo7.mc_pje.repositories;

import com.grupo7.mc_pje.entities.Notificacao;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificacaoRepository extends JpaRepository<Notificacao, UUID> {
   List<Notificacao> findByTipoNotificacao(String tipoNotificacao);
   List<Notificacao> findByTipoNotificacaoAndTipoEnvioAndStatus(String tipoNotificacao, String tipoEnvio, String status);
}

