package com.senai.pessoal_richard.dtos;
import lombok.Data;

@Data
public class HotelDTO {

    private Long id;
    private String nome;
    private String endereco;
    private String telefone;
    private String cnpj;

    public HotelDTO() {
    }

    public HotelDTO(Long id, String nome, String endereco, String telefone, String cnpj) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.cnpj = cnpj;
    }

}
