package com.senai.pessoal_richard.dtos;
import lombok.Data;

@Data
public class ReservaDTO {

    private Long id;
    private String nome;
    private String descricao;
    private String preco;

    public ReservaDTO() {
    }

    public ReservaDTO(Long id, String nome, String descricao, String preco) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
    }
}
