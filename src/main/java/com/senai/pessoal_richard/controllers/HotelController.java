package com.senai.pessoal_richard.controllers;


import com.senai.pessoal_richard.dtos.HotelDTO;
import com.senai.pessoal_richard.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/hotel")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @PostMapping
    public ResponseEntity<HotelDTO> createHotel (@RequestBody HotelDTO hotelDTO) {
        HotelDTO novoHotel = hotelService.createHotel(hotelDTO);
        return new ResponseEntity<>(novoHotel, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HotelDTO> getHotelById(@PathVariable Long id) {
        HotelDTO HotelDTO = hotelService.getHotelById(id);
        return ResponseEntity.ok(HotelDTO);
    }

   @GetMapping("/")
    public ResponseEntity<List<HotelDTO>> getAllHotel() {
        List<HotelDTO> list = hotelService.findAll();
        return ResponseEntity.ok(list);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HotelDTO> updateHotel(@PathVariable Long id, @RequestBody HotelDTO hotelDTO) {
        HotelDTO hotelDTO1 = hotelService.updateHotel(id, hotelDTO);
        return ResponseEntity.ok(hotelDTO1);
    }






}
