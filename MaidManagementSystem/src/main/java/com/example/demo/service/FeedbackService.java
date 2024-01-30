package com.example.demo.service;

import com.example.demo.entity.Feedback;
import com.example.demo.exception.ResourceNotFoundException;

import java.util.List;

public interface FeedbackService {
    Feedback saveFeedback(Feedback feedback) throws ResourceNotFoundException;
    List<Feedback> getAllFeedbacks();
    List<Feedback> getFeedbackById(int feedbackId)throws ResourceNotFoundException;
    void deleteFeedback(int feedbackId);
}
