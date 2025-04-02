package com.senai.pessoal_richard.dtos;
import com.senai.pessoal_richard.entities.Hotel;
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

    public HotelDTO(Hotel hotel) {
        this.id = hotel.getId();
        this.nome = hotel.getNome();
        this.endereco = hotel.getEndereco();
        this.telefone = hotel.getTelefone();
        this.cnpj = hotel.getCnpj();
    }



}
