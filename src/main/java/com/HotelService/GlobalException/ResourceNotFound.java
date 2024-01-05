package com.HotelService.GlobalException;

public class ResourceNotFound extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ResourceNotFound() {
		super("Resource Not Found in database");
	}
	
	public  ResourceNotFound(String msg) {
		super(msg);
	}

	
}
