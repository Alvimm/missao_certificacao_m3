package com.grupo7.mc_pje.repositories;

import com.grupo7.mc_pje.entities.Parte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParteRepository  extends JpaRepository<Parte, Long> {
}
