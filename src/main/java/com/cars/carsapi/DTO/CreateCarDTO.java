package com.cars.carsapi.DTO;

public record CreateCarDTO(String modelo, String fabricante, String dataFabricacao, double valor, int anoModelo) {
}
