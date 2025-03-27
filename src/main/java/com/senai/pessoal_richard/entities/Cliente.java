package com.senai.pessoal_richard.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "cliente")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String endereco;
    private String data_nascimento;
    private String cpf;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;

        return Objects.equals(id, cliente.id) && Objects.equals(nome, cliente.nome)
                && Objects.equals(email, cliente.email) && Objects.equals(telefone, cliente.telefone)
                && Objects.equals(endereco, cliente.endereco) && Objects.equals(data_nascimento, cliente.data_nascimento)
                && Objects.equals(cpf, cliente.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, email, telefone, endereco, data_nascimento, cpf);
    }

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCadastro;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAtualizacao;

    @ManyToOne
    @JoinColumn(name = "id_reserva")
    private Reserva reserva;

}