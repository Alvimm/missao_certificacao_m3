/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo7.mc_pje.repositories;

import com.grupo7.mc_pje.entities.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 *
 * @author Nanda
 */

public interface EnderecoRepository extends JpaRepository<Endereco, UUID> {
}

