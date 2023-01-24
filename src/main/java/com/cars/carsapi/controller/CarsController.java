package com.cars.carsapi.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cars.carsapi.DTO.CreateCarDTO;

@RestController
@RequestMapping("/cars")
public class CarsController {
	@PostMapping
	public void create(@RequestBody CreateCarDTO car) {
		System.out.println(car);
	}
}
