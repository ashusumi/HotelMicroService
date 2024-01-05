package com.HotelService.Service;

import java.util.List;

import com.HotelService.Model.Hotel;

public interface HotelService {

	public List<Hotel> getllHotels();
	
	public Hotel getHotelById(Integer id);
	
	public Hotel addHotel(Hotel hotel);
	
	public String updateHotel(Integer id,Hotel hotel);
	
	public String deleteHotel(Integer id);
}
