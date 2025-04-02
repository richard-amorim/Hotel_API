package com.senai.pessoal_richard.controllers;

import com.senai.pessoal_richard.service.ReservaService;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reserva")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @PostMapping
    public void createReserva() {
        reservaService.createReserva();
    }

    @GetMapping("/{id}")
    public void getReservaById(@PathVariable Long id) {
        reservaService.getReservaById(id);
    }

    @GetMapping("/")
    public void getAllReserva() {
        reservaService.getAllReserva();
    }

    @PutMapping("/{id}")
    public void updateReserva(@PathVariable Long id) {
        reservaService.updateReserva(id);
    }

    @DeleteMapping("/{id}")
    public void deleteReserva(@PathVariable Long id) {
        reservaService.deleteReserva(id);
    }
}
