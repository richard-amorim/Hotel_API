package com.senai.pessoal_richard.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Entity
@Table(name = "quarto")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Quarto {
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

    @ManyToOne
    @JoinColumn(name = "id_reserva")
    private Reserva reserva;

    @OneToOne
    @JoinColumn(name = "id_hotel")
    private Hotel hotel;


}
