package hiber.dao;

import hiber.model.Car;

public interface CarDao {
    void add(String model,int series);
    Car getCarById(Long id);
}
