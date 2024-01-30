package com.example.demo.service.impl;


import org.modelmapper.ModelMapper;

import com.example.demo.entity.Booking;
import com.example.demo.entity.Client;
import com.example.demo.entity.Maid;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.BookingRepository;
import com.example.demo.repository.ClientRepository;
import com.example.demo.repository.MaidRepository;
import com.example.demo.service.BookingService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;
    
    @Autowired
    private ClientRepository clientRepository;
    
    @Autowired
    private MaidRepository maidRepository;

    @Autowired
	ModelMapper modelMapper;
    
    @Override
    public Booking createBooking(Booking booking) throws ResourceNotFoundException {
    			Client client = clientRepository.findById(booking.getClient().getId()).orElseThrow(
    					() -> new ResourceNotFoundException("Client", " id", booking.getClient().getId()));

    			Maid maid = maidRepository.findById(booking.getMaid().getMaidId())
    					.orElseThrow(() -> new ResourceNotFoundException("Maid", " id", booking.getMaid().getMaidId()));

    			booking.setClient(client);
    			booking.setMaid(maid);
    			
        return bookingRepository.save(booking);
    }
    
    
    @Override
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public List<Booking> getBookingById(int bookingId) throws ResourceNotFoundException{
    	Optional<Booking> optionalBooking = bookingRepository.findById(bookingId);
      
    	if (optionalBooking.isPresent()) {
			return optionalBooking.stream().map(booking -> modelMapper.map(optionalBooking, Booking.class))
					.collect(Collectors.toList());
		} else {
			// Handle the case where the customer with the given ID is not found
			throw new ResourceNotFoundException("Booking ", " id", bookingId);
		}
    
    }

    


}
