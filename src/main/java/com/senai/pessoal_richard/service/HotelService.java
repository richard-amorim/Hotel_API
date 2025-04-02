package com.senai.pessoal_richard.service;

import com.senai.pessoal_richard.dtos.HotelDTO;
import com.senai.pessoal_richard.entities.Hotel;
import com.senai.pessoal_richard.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

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


    @Transactional
    public HotelDTO createHotel(HotelDTO hotelDTO) {
        Hotel hotel = new Hotel();
        hotel.setNome(hotelDTO.getNome());
        hotel.setEndereco(hotelDTO.getEndereco());
        hotel.setTelefone(hotelDTO.getTelefone());
        hotel.setCnpj(hotelDTO.getCnpj());
        hotel = hotelRepository.save(hotel);
        return new HotelDTO(hotel);
    }

    @Transactional(readOnly = true)
    public List<HotelDTO> findAll() {
        return hotelRepository.findAll().stream().map(hotel
                -> new HotelDTO(hotel.getId(),
                hotel.getNome(),
                hotel.getEndereco(),
                hotel.getTelefone(),
                hotel.getCnpj())).collect(Collectors.toList());
    }


    @Transactional(readOnly = true)
    public HotelDTO updateHotel(Long id, HotelDTO hotelDTO) {
        Hotel hotel = hotelRepository.findById(id).orElseThrow(( ()
                -> new ResourceNotFoundException("Hotel not found")));

        hotel.setNome(hotelDTO.getNome());
        hotel.setEndereco(hotelDTO.getEndereco());
        hotel.setTelefone(hotelDTO.getTelefone());
        hotel.setCnpj(hotelDTO.getCnpj());
        hotel = hotelRepository.save(hotel);

        return new HotelDTO(hotel);
    }

    @Transactional
    public void deleteHotel(Long id) {
        Hotel hotel = hotelRepository.findById(id).orElseThrow(( ()
                -> new ResourceNotFoundException("Hotel not found")));
        if (!hotelRepository.existsById(id)) {
            throw new ResourceNotFoundException("Hotel not found");
        }
        hotelRepository.deleteById(id);
    }
}
