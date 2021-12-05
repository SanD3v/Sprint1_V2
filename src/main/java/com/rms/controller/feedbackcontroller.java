package com.rms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rms.model.FeedBack;
import com.rms.service.feedbackservice;

@RestController
public class feedbackcontroller {
	@Autowired
	private feedbackservice fbservice;

	@GetMapping("/feedbackWelcome")
	public String giveFeedback() {
		return ("Welcome to the Feedback portal,We will really appreciate if you give your valuable Feedback to us.");
	}

	@PostMapping("/F")
	public FeedBack addFeedBack(@RequestBody FeedBack feedback) {
		return fbservice.addFeedback(feedback);

	}

	@PostMapping("/Fb")
	public List<FeedBack> addFeedBacks(@RequestBody List<FeedBack> feedback) {
		return fbservice.addFeedBacks(feedback);

	}

	@GetMapping("/Find")
	public List<FeedBack> getAllFeedBacks() {
		return fbservice.getFeedBack();
	}

	@GetMapping("/find/{customerId}")
	public FeedBack findFeedbackById(@PathVariable int customerId) {
		return fbservice.getFeedBackById(customerId);
	}

	@PutMapping("/update")
	public FeedBack updateFeedback(@RequestBody FeedBack feedback) {
		return fbservice.updatefeedback(feedback);
	}

	@DeleteMapping("/delete/{customerId}")
	public ResponseEntity<FeedBack> deleteFeedBack(@PathVariable int customerId) {
		return fbservice.deleteFeedBack(customerId);
	}

}
