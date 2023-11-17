package com.grupo7.mc_pje.services;
import com.grupo7.mc_pje.entities.Parte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.grupo7.mc_pje.repositories.ParteRepository;

import java.util.UUID;

@Service
public class ParteService {

    @Autowired
    private ParteRepository parteRepository;

    public Parte salvarParte(Parte parte) {

        Parte parteExistente = parteRepository.findByDocumento(parte.getDocumento());

        if (parteExistente != null) {
            return parteExistente;
        }

        return parteRepository.save(parte);
    }

    public Parte obterPartePorId(UUID id) {

        return parteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Parte não encontrada com ID: " + id));
    }
}
