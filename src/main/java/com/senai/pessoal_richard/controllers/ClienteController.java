package com.senai.pessoal_richard.controllers;

import com.senai.pessoal_richard.dtos.ClienteDTO;
import com.senai.pessoal_richard.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @PostMapping
    public ResponseEntity<ClienteDTO> createCliente(@RequestBody ClienteDTO clienteDTO) {
        ClienteDTO novoCliente = clienteService.createCliente(clienteDTO); // Corrigido aqui
        return new ResponseEntity<>(novoCliente, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> getClienteById(@PathVariable Long id) {
        ClienteDTO clienteDTO = clienteService.getClienteById(id);
        return ResponseEntity.ok(clienteDTO);
    }

    @GetMapping("/")
    public ResponseEntity<List<ClienteDTO>> getAllClientes() {
        List<ClienteDTO> list = clienteService.findByAll();
        return ResponseEntity.ok(list);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteDTO> updateCliente(@PathVariable Long id, @RequestBody ClienteDTO clienteDTO) {
        ClienteDTO cliente = clienteService.updateCliente(id, clienteDTO);
        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("/{id}")
    public void deleteCliente(@PathVariable Long id) {
        clienteService.deleteCliente(id);
    }

}
