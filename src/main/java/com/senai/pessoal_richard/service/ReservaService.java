package com.senai.pessoal_richard.service;

import com.senai.pessoal_richard.dtos.ReservaDTO;
import com.senai.pessoal_richard.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    @Transactional(readOnly = true)
    public ReservaDTO getReservaById(Long id) {
        return reservaRepository.findById(id).map(reserva
                -> new
                ReservaDTO(reserva.getId(),
                reserva.getNome(),
                reserva.getDescricao(),
                reserva.getPreco())).orElse(null);
    }


}
