package com.HotelService.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HotelService.Dao.HotelRespo;
import com.HotelService.GlobalException.ResourceNotFound;
import com.HotelService.Model.Hotel;
import com.HotelService.Service.HotelService;

@Service
public class HotelServiceImpl implements HotelService {

	@Autowired
	private HotelRespo hotelRespo;

	@Override
	public List<Hotel> getllHotels() {
		return hotelRespo.findAll();
	}

	@Override
	public Hotel addHotel(Hotel hotel) {
		Hotel hotel2 = Hotel.builder().name(hotel.getName()).location(hotel.getLocation()).about(hotel.getAbout())
				.build();
		hotelRespo.save(hotel2);
		return hotel2;
	}

	@Override
	public String updateHotel(Integer id, Hotel hotel) {
		Hotel hotel2 = hotelRespo.findById(id)
				.orElseThrow(() -> new ResourceNotFound("Unable to find the hotel your seeking!" + id));
		hotelRespo.save(hotel2);
		return "Hotel updated successfully";
	}

	@Override
	public String deleteHotel(Integer id) {
		Hotel hotel = hotelRespo.findById(id).orElseThrow(() -> new ResourceNotFound("No Hotel found for given id"));
		hotelRespo.deleteById(id);
		return "Hotel deleted Successfully";
	}

	@Override
	public Hotel getHotelById(Integer id) {
	

			Hotel hotel=hotelRespo.findById(id).orElseThrow(()->new ResourceNotFound("No Hotel Found"));
			return hotel;
	
	
	}

}
