package com.HotelService.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.HotelService.Model.Hotel;
import com.HotelService.ServiceImpl.HotelServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/hotel")
public class HotelController {

	@Autowired
	private HotelServiceImpl impl;

	@GetMapping("/getAllHotels")
	public ResponseEntity<List<Hotel>> getAllHotels() {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(impl.getllHotels());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}

	@PostMapping("/addHotel")
	public ResponseEntity<Hotel> addHotels(@RequestBody Hotel hotel) {
		try {
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(impl.addHotel(hotel));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteHotel(@PathVariable Integer id) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(impl.deleteHotel(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateHotel(@PathVariable Integer id, @RequestBody Hotel entity) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(impl.updateHotel(id, entity));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	} 
	
	@GetMapping("/hotelById")
	public ResponseEntity<?> getHotelById(@RequestParam Integer id) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(impl.getHotelById(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}
	
}
