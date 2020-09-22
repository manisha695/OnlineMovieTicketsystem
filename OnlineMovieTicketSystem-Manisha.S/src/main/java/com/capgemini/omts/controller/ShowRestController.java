package com.capgemini.omts.controller;

import java.util.List;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.omts.entity.ShowBean;
import com.capgemini.omts.service.ShowServiceImpl;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping({ "/show" })
public class ShowRestController {
	@Autowired
	ShowServiceImpl showserviceimpl;

	@PostMapping("/create")
	public ResponseEntity<ShowBean> createShow(@Valid @RequestBody ShowBean bean) {
		ShowBean showbean = showserviceimpl.addShow(bean);
		ResponseEntity<ShowBean> responseEntity = new ResponseEntity<ShowBean>(showbean, HttpStatus.OK);

		return responseEntity;
	}

	@DeleteMapping("/removeById/{showId}")

	public ResponseEntity<String> deleteShowById(@PathVariable int showId) {
		try {

			showserviceimpl.removeShow(showId);

			ResponseEntity<String> responseEntity = new ResponseEntity(true, HttpStatus.OK);
			System.out.println("response entity=" + responseEntity);
			return responseEntity; // return "Your Show is deleted succesfully";
		} catch (Exception e) {

			return new ResponseEntity<String>("Invalid Id", HttpStatus.BAD_REQUEST);

		}
	}

	@GetMapping("/findall") // viewing all the shows which are available public
	public ResponseEntity<List<ShowBean>> getallshows() {

		List<ShowBean> bean = showserviceimpl.getAllShows();
		return new ResponseEntity<List<ShowBean>>(bean, new HttpHeaders(), HttpStatus.OK);

	}

	@GetMapping("/{showId}") 
	public ResponseEntity<ShowBean> getshows(@PathVariable int showId) {

		ShowBean bean = showserviceimpl.getShows(showId);
		return new ResponseEntity(bean, new HttpHeaders(), HttpStatus.OK);

	}

	@ExceptionHandler(Exception.class)
	public String inValid(Exception e) {
		return e.getMessage();
	}

}
