package hiber.service;

import hiber.model.Car;

public interface CarService {
    void add(String model,int series);
    Car getCarById(Long id);
}
