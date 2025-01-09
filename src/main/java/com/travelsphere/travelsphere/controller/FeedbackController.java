package com.travelsphere.travelsphere.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.travelsphere.travelsphere.exceptions.*;
import com.travelsphere.travelsphere.model.*;
import com.travelsphere.travelsphere.service.*;
@RestController
public class FeedbackController {

    @Autowired
    FeedbackService feedbackService;


    @PostMapping("/Feedback/{key}")
    public ResponseEntity<Feedback> createFeedback(@Valid @RequestBody Feedback feedback,@PathVariable("key") String key) throws CustomerException, LoginException{

        Feedback saveFeedback=feedbackService.addFeedback(feedback,key);


        return new ResponseEntity<Feedback>(saveFeedback,HttpStatus.CREATED);

    }

    @GetMapping("/Feedback/{key}")
    public ResponseEntity<List<Feedback>> CustomerFeedbacks(@PathVariable("key") String key) throws FeedbackException, CustomerException, LoginException{


        List<Feedback> GetFeedbacks=feedbackService.findByCustomer(key);


        return new ResponseEntity<List<Feedback>>(GetFeedbacks,HttpStatus.OK);

    }

    @GetMapping("/Feedbacks/{key}")
    public ResponseEntity<List<Feedback>> ViewAllFeedbacks(@PathVariable("key") String key) throws FeedbackException, LoginException{


        List<Feedback> GetFeedbacks=feedbackService.viewAllFeedback(key);


        return new ResponseEntity<List<Feedback>>(GetFeedbacks,HttpStatus.OK);

    }

}

