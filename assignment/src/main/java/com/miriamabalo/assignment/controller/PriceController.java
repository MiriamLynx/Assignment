package com.miriamabalo.assignment.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.miriamabalo.assignment.model.response.PriceResponse;
import com.miriamabalo.assignment.service.PricesService;

@RestController
public class PriceController {

	@Autowired
	private PricesService service;

	@GetMapping(path = "/prices", produces = "application/json")
	public ResponseEntity<PriceResponse> findOne(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date applicationDate, @RequestParam Long productId, @RequestParam Long brandId) {
		return new ResponseEntity<PriceResponse>(service.findOne(applicationDate, productId, brandId), HttpStatus.OK);
	}

}
