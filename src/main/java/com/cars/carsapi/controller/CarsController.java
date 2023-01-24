package com.cars.carsapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cars.carsapi.DTO.CreateCarDTO;
import com.cars.carsapi.repository.CarRepository;
import com.cars.carsapi.model.Car;

@RestController
@RequestMapping("/cars")
public class CarsController {
	@Autowired
	private CarRepository repository;

	@GetMapping
	public List<Car> getAll() {
		return repository.findAll();
	}

	@PostMapping
	public void create(@RequestBody CreateCarDTO car) {
		repository.save(new Car(car));
	}
}
