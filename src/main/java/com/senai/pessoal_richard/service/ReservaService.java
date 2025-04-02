package com.senai.pessoal_richard.service;

import com.senai.pessoal_richard.dtos.ReservaDTO;
import com.senai.pessoal_richard.entities.Reserva;
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

,

    @Transactional
    public void createReserva() {
        Reserva reserva = new Reserva();
        reservaRepository.save(reserva);
    }

    @Transactional(readOnly = true)
    public void getAllReserva() {
        reservaRepository.findAll();
    }

    @Transactional(readOnly = true)
    public void updateReserva(Long id) {
        Reserva reserva = reservaRepository.findById(id).orElseThrow(( ()
                -> new ResourceNotFoundException("Reserva not found")));
        reservaRepository.save(reserva);
    }

    @Transactional
    public void deleteReserva(Long id) {
        Reserva reserva = reservaRepository.findById(id).orElseThrow(( ()
                -> new ResourceNotFoundException("Reserva not found")));
        if (!reservaRepository.existsById(id)) {
            throw new ResourceNotFoundException("Reserva not found");
        }
        reservaRepository.deleteById(id);
    }
}
