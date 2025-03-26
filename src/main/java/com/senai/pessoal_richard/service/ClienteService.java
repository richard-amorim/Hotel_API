package com.senai.pessoal_richard.service;

import com.senai.pessoal_richard.dtos.ClienteDTO;
import com.senai.pessoal_richard.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Transactional(readOnly = true)
    public ClienteDTO getClienteById(Long id) {

        return clienteRepository.findById(id).map(cliente
                -> new
                ClienteDTO(cliente.getId(),
                cliente.getNome(),
                cliente.getEmail(),
                cliente.getTelefone())).orElse(null);

    }

}
