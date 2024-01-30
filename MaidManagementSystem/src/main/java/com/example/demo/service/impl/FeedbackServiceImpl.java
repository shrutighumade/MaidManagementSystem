package com.example.demo.service.impl;

import com.example.demo.entity.Client;
import com.example.demo.entity.Feedback;
import com.example.demo.entity.Maid;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ClientRepository;
import com.example.demo.repository.FeedbackRepository;
import com.example.demo.repository.MaidRepository;
import com.example.demo.service.FeedbackService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FeedbackServiceImpl implements FeedbackService {

	@Autowired
	private FeedbackRepository feedbackRepository;
   
    @Autowired
    private ClientRepository clientRepository;
    
    @Autowired
    private MaidRepository maidRepository;
    
	@Autowired
	ModelMapper modelMapper;
    
    @Override
    public Feedback saveFeedback(Feedback feedback) throws ResourceNotFoundException {
    	Client client = clientRepository.findById(feedback.getClient().getId()).orElseThrow(
				() -> new ResourceNotFoundException("Client", " id", feedback.getClient().getId()));

		Maid maid = maidRepository.findById(feedback.getMaid().getMaidId())
				.orElseThrow(() -> new ResourceNotFoundException("Maid", " id", feedback.getMaid().getMaidId()));

		feedback.setClient(client);
		feedback.setMaid(maid);
        return feedbackRepository.save(feedback);
    }

    @Override
    public List<Feedback> getAllFeedbacks() {
        return feedbackRepository.findAll();
    }

    @Override
    public List<Feedback> getFeedbackById(int feedbackId) throws ResourceNotFoundException{
        Optional<Feedback> optionalFeedback = feedbackRepository.findById(feedbackId);
//        return optionalFeedback.orElse(null);
        if (optionalFeedback.isPresent()) {
			return optionalFeedback.stream().map(client -> modelMapper.map(optionalFeedback, Feedback.class))
					.collect(Collectors.toList());
		} else {
			// Handle the case where the customer with the given ID is not found
			throw new ResourceNotFoundException("Feedback", " id", feedbackId);
		}
        
    }

    @Override
    public void deleteFeedback(int feedbackId) {
        feedbackRepository.deleteById(feedbackId);
    }
}
