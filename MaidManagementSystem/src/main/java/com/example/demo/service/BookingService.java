package com.example.demo.service;

import com.example.demo.entity.Booking;
import com.example.demo.exception.ResourceNotFoundException;

import java.util.List;

public interface BookingService {
    List<Booking> getAllBookings();
    List<Booking> getBookingById(int bookingId)throws ResourceNotFoundException;
    Booking createBooking(Booking booking) throws ResourceNotFoundException;
    // Other service methods...
}
