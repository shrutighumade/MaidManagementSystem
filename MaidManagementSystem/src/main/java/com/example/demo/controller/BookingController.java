package com.example.demo.controller;

import com.example.demo.entity.Booking;
import com.example.demo.entity.Client;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/bookings")
public class BookingController {
	 
	
	@PostMapping("/add")
	    public Booking createBooking(@RequestBody Booking booking) throws ResourceNotFoundException {
	        return bookingService.createBooking(booking);
	    }

    @Autowired
    private BookingService bookingService;

    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }

    @GetMapping("/{bookingId}")
    public ResponseEntity<Object> getBookingById(@PathVariable int bookingId) {
    	try {
            List<Booking> booking = bookingService.getBookingById(bookingId);
            return new ResponseEntity<>(booking, HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
        	Map<String, String> map = new HashMap<>();
			map.put("errorMessage", e.getMessage());
            return new ResponseEntity<>(map,HttpStatus.NOT_FOUND);
        }
//    	return bookingService.getBookingById(bookingId);
    }

   

}
