package com.senai.pessoal_richard.dtos;
import lombok.Data;

@Data
public class QuartoDTO {

    private Long id;
    private String nome;
    private String descricao;
    private String preco;

    public QuartoDTO() {
    }

    public QuartoDTO(Long id, String nome, String descricao, String preco) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
    }
}
