package com.HotelService.GlobalException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFound.class)
	public ResponseEntity<ApiResponse> handleResrounceNotFoundExce(ResourceNotFound resource){
		String message=resource.getMessage();
		ApiResponse apiResponse=ApiResponse.builder().message(message).build();
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiResponse);
		
		
	}
}
