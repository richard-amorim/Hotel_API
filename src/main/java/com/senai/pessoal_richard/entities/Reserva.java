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
    private Date dataCadastro;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAtualizacao;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Reserva reserva = (Reserva) o;
        return Objects.equals(id, reserva.id) && Objects.equals(nome, reserva.nome)
                && Objects.equals(descricao, reserva.descricao) && Objects.equals(preco, reserva.preco)
                && Objects.equals(dataCadastro, reserva.dataCadastro)
                && Objects.equals(dataAtualizacao, reserva.dataAtualizacao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, descricao, preco, dataCadastro, dataAtualizacao);
    }

    @OneToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @OneToOne
    @JoinColumn(name = "id_quarto")
    private Quarto quarto;


}
