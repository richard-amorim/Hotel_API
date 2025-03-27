package com.senai.pessoal_richard.repository;

import com.senai.pessoal_richard.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Arrays;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
