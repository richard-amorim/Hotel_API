package com.senai.pessoal_richard.service;

import com.senai.pessoal_richard.dtos.QuartoDTO;
import com.senai.pessoal_richard.repository.QuartoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class QuartoService {

    @Autowired
    private QuartoRepository quartoRepository;

    @Transactional(readOnly = true)
    public QuartoDTO getQuartoById(Long id) {
        return quartoRepository.findById(id).map(quarto
                -> new
                QuartoDTO(quarto.getId(),
                quarto.getNome(),
                quarto.getDescricao(),
                quarto.getPreco())).orElse(null);
    }


}
