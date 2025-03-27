package com.senai.pessoal_richard.service;

import com.senai.pessoal_richard.dtos.ClienteDTO;
import com.senai.pessoal_richard.entities.Cliente;
import com.senai.pessoal_richard.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

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

    @Transactional(readOnly = true)
    public List<ClienteDTO> findByAll() {
        return clienteRepository.findAll().stream().map(cliente
                -> new ClienteDTO(cliente.getId(),
                cliente.getNome(),
                cliente.getEmail(),
                cliente.getTelefone())).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ClienteDTO updateCliente(Long id, ClienteDTO clienteDTO) {
        Cliente cliente = clienteRepository.findById(id).orElseThrow(( ()
                -> new ResourceNotFoundException("Cliente not found")));

        cliente.setNome(clienteDTO.getNome());
        cliente.setEmail(clienteDTO.getEmail());
        cliente.setTelefone(clienteDTO.getTelefone());
        cliente = clienteRepository.save(cliente);

        return new ClienteDTO(cliente);

    }

    @Transactional
    public void deleteCliente(Long id) {
        Cliente cliente = clienteRepository.findById(id).orElseThrow(( ()
                -> new ResourceNotFoundException("Cliente not found")));
        if (!clienteRepository.existsById(id)) {
            throw new ResourceNotFoundException("OrderItem not found");
        }
        clienteRepository.deleteById(id);
    }

    private ClienteDTO copyDtoToEntity(ClienteDTO dto, Cliente entity) {
        entity.setNome(dto.getNome());
        entity.setEmail(dto.getEmail());
        entity.setTelefone(dto.getTelefone());
        return new ClienteDTO(entity);
    }

    public ClienteDTO createCliente(ClienteDTO clienteDTO) {
        Cliente entity = new Cliente();
        copyDtoToEntity(clienteDTO, entity);
        entity = clienteRepository.save(entity);
        return new ClienteDTO(entity);
    }
}
