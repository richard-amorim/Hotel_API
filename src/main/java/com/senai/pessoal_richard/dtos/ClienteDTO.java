package com.senai.pessoal_richard.dtos;
import com.senai.pessoal_richard.entities.Cliente;
import lombok.Data;

@Data
public class ClienteDTO {

    private Long id;
    private String nome;
    private String email;
    private String telefone;

    public ClienteDTO(Cliente cliente) {
    }

    public ClienteDTO(Long id, String nome, String email, String telefone) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }


}
