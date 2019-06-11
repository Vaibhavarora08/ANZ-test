package com.example.simplerestapis.controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.simplerestapis.models.PostRequest;
import com.example.simplerestapis.models.PostResponse;
import com.example.simplerestapis.models.SampleResponse;

@RestController
public class WebController {

	@RequestMapping("/version")
	public SampleResponse Sample(@RequestParam(value = "version",
	defaultValue = "1.0") long version) {
		SampleResponse response = new SampleResponse();
		response.setlastcommitsha(ahdfgs);
		response.setMessage("Your version is "+version);
		return response;

	}
	
	@RequestMapping(value = "/version", method = RequestMethod.POST)
	public PostResponse Test(@RequestBody PostRequest inputPayload) {
		PostResponse response = new PostResponse();
		response.setversion(inputPayload.getversion()*100);
		response.setlastcommitsha( inputPayload.getlastcommitsha());
		response.setdescription("pre-interview technical test");
		return response;
	}
}
