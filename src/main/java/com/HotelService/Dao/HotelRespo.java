package com.HotelService.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.HotelService.Model.Hotel;


public interface HotelRespo extends JpaRepository<Hotel, Integer> {

	
}
