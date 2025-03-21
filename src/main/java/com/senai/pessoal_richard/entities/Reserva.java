package com.senai.pessoal_richard.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "reserva")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private String preco;


    @Temporal(TemporalType.TIMESTAMP)
    private Date data_cadastro;
    @Temporal(TemporalType.TIMESTAMP)
    private Date data_atualizacao;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Reserva reserva = (Reserva) o;
        return Objects.equals(id, reserva.id) && Objects.equals(nome, reserva.nome) && Objects.equals(descricao, reserva.descricao) && Objects.equals(preco, reserva.preco) && Objects.equals(data_cadastro, reserva.data_cadastro) && Objects.equals(data_atualizacao, reserva.data_atualizacao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, descricao, preco, data_cadastro, data_atualizacao);
    }

    @ManyToMany
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @OneToOne
    @JoinColumn(name = "id_quarto")
    private Quarto quarto;


}
