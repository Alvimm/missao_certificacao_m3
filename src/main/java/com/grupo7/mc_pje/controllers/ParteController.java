package com.grupo7.mc_pje.controllers;

import com.grupo7.mc_pje.repositories.ParteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ParteController {
    @Autowired
    ParteRepository parteRepository;

    @PostMapping("/parte")
    public void saveParte(){
        return;
    }

    @GetMapping("/parte")
    public void getAll(){
        return;
    }

    @GetMapping("/parte/{id}")
    public void getOne(){
        return;
    }

    @PutMapping("/parte/{id}")
    public void updateParte(){
        return;
    }

    @DeleteMapping("/parte/{id}")
    public void deleteParte(){
        return;
    }
}
