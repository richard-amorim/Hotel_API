package com.senai.pessoal_richard.service;

import com.senai.pessoal_richard.dtos.HotelDTO;
import com.senai.pessoal_richard.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    @Transactional(readOnly = true)
    public HotelDTO getHotelById(Long id) {
        return hotelRepository.findById(id).map(hotel
                -> new
                HotelDTO(hotel.getId(),
                hotel.getNome(),
                hotel.getEndereco(),
                hotel.getTelefone(),
                hotel.getCnpj())).orElse(null);
    }


}
