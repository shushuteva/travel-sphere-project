package com.travelsphere.travelsphere.service;

import com.travelsphere.travelsphere.exceptions.*;
import com.travelsphere.travelsphere.model.Feedback;

import java.util.List;

public interface FeedbackService {
    public Feedback addFeedback(Feedback feedback, String key) throws CustomerException, LoginException;

    public List<Feedback> findByCustomer(String key)throws FeedbackException, CustomerException, LoginException;
    public List<Feedback> viewAllFeedback(String key) throws FeedbackException, LoginException;
}
