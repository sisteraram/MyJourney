package org.honeyrock.controller;

import java.util.List;

import org.honeyrock.domain.PointVO;
import org.honeyrock.mapper.SearchMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Setter;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/map/*")
@Log
public class DataController {
	
	@Setter(onMethod_ = @Autowired)
	private SearchMapper mapper;
	
	@GetMapping(value = "/recommendData", produces= {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<List<PointVO>> getData(){
		log.info("data........");
		return new ResponseEntity<>(mapper.getRecommendList(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/siteData", produces= {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<List<PointVO>> getSiteData(){
		log.info("site........");
		return new ResponseEntity<>(mapper.getSiteList(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/restaurantData", produces= {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<List<PointVO>> getRestaurantData(){
		log.info("Restaurant........");
		return new ResponseEntity<>(mapper.getRestaurantList(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/hotelData", produces= {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<List<PointVO>> getHotelData(){
		log.info("hotel........");
		return new ResponseEntity<>(mapper.getHotelList(), HttpStatus.OK);
	}

}
