package com.senai.pessoal_richard.service;

import com.senai.pessoal_richard.dtos.QuartoDTO;
import com.senai.pessoal_richard.entities.Quarto;
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


    @Transactional
    public void createQuarto() {
        Quarto quarto = new Quarto();
        quartoRepository.save(quarto);
    }

    @Transactional(readOnly = true)
    public void getAllQuarto() {
        quartoRepository.findAll();
    }

    @Transactional(readOnly = true)
    public void updateQuarto(Long id) {
        Quarto quarto = quartoRepository.findById(id).orElseThrow(( ()
                -> new ResourceNotFoundException("Quarto not found")));
        quartoRepository.save(quarto);
    }

    @Transactional
    public void deleteQuarto(Long id) {
        Quarto quarto = quartoRepository.findById(id).orElseThrow(( ()
                -> new ResourceNotFoundException("Quarto not found")));
        if (!quartoRepository.existsById(id)) {
            throw new ResourceNotFoundException("Quarto not found");
        }
        quartoRepository.deleteById(id);
    }
}
