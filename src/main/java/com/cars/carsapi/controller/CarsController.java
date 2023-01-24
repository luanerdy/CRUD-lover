package com.cars.carsapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cars.carsapi.repository.CarRepository;

import jakarta.validation.Valid;

import com.cars.carsapi.dto.CreateCarDTO;
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
	public void create(@RequestBody @Valid CreateCarDTO car) {
		repository.save(new Car(car));
	}

	@DeleteMapping("/{id}")
	public void erase(@PathVariable Long id) {
		repository.deleteById(id);
	}

	@PutMapping("/{id}")
	public void update(@PathVariable Long id, @RequestBody @Valid CreateCarDTO body) {
		repository.findById(id).map(car -> {
			car.setAnoModelo(body.anoModelo());
			car.setModelo(body.modelo());
			car.setFabricante(body.fabricante());
			car.setDataFabricacao(body.dataFabricacao());
			car.setValor(body.valor());
			return repository.save(car);
		});
	}
}
