package com.example.demo.controller;

import com.example.demo.entity.Client;
import com.example.demo.entity.Feedback;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/feedbacks")
public class FeedbackController {

    private final FeedbackService feedbackService;

    @Autowired
    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @PostMapping("/add")
    public ResponseEntity<Feedback> saveFeedback(@RequestBody Feedback feedback) throws ResourceNotFoundException {
        Feedback savedFeedback = feedbackService.saveFeedback(feedback);
        return new ResponseEntity<>(savedFeedback, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Feedback>> getAllFeedbacks() {
        List<Feedback> feedbacks = feedbackService.getAllFeedbacks();
        return new ResponseEntity<>(feedbacks, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getFeedbackById(@PathVariable("id") int feedbackId) {
//        Feedback feedback = feedbackService.getFeedbackById(feedbackId);
//        if (feedback != null) {
//            return new ResponseEntity<>(feedback, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
        
        try {
            List<Feedback> feedback = feedbackService.getFeedbackById(feedbackId);
            return new ResponseEntity<>(feedback, HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
        	Map<String, String> map = new HashMap<>();
			map.put("errorMessage", e.getMessage());
            return new ResponseEntity<>(map,HttpStatus.NOT_FOUND);
        }
        
        
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFeedback(@PathVariable("id") int feedbackId) {
        feedbackService.deleteFeedback(feedbackId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
