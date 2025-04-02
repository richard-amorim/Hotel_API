package com.senai.pessoal_richard.controllers;

import com.senai.pessoal_richard.service.QuartoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/quarto")
public class QuartoController {

    @Autowired
    private QuartoService quartoService;

    @PostMapping
    public void createQuarto() {
        quartoService.createQuarto();
    }

    @GetMapping("/{id}")
    public void getQuartoById(@PathVariable Long id) {
        quartoService.getQuartoById(id);
    }

    @GetMapping("/")
    public void getAllQuarto() {
        quartoService.getAllQuarto();
    }

    @PutMapping("/{id}")
    public void updateQuarto(@PathVariable Long id) {
        quartoService.updateQuarto(id);
    }

    @DeleteMapping("/{id}")
    public void deleteQuarto(@PathVariable Long id) {
        quartoService.deleteQuarto(id);
    }
}
