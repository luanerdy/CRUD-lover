package com.cars.carsapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cars.carsapi.model.Car;

public interface CarRepository extends JpaRepository<Car, Long> {

}
