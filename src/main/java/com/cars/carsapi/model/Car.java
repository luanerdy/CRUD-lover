package com.cars.carsapi.model;

import java.util.Date;

import com.cars.carsapi.dto.CreateCarDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Car {
	public Car(CreateCarDTO car) {
		this.modelo = car.modelo();
		this.fabricante = car.fabricante();
		this.dataFabricacao = car.dataFabricacao();
		this.valor = car.valor();
		this.anoModelo = car.anoModelo();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(length = 50, nullable = false)
	private String modelo;

	@Column(length = 50, nullable = false)
	private String fabricante;

	@Column(length = 50, nullable = false)
	private Date dataFabricacao;

	@Column(length = 50, nullable = false)
	private double valor;

	@Column(length = 50, nullable = false)
	private int anoModelo;
}
