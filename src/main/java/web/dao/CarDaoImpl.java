package web.dao;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CarDaoImpl implements CarDao {
    private final List<Car> carList = Arrays.asList(
            new Car("Toyota Camry", 2021, "Black"),
            new Car("Honda Accord", 2020, "White"),
            new Car("Ford Mustang", 2022, "Red"),
            new Car("BMW 3 Series", 2019, "Blue"),
            new Car("Audi A4", 2021, "Silver"));

    @Override
    public List<Car> getCarsByCount(int count) {
        List<Car> cars = new ArrayList<>();
        if (count > 0) {
            int lenght = count;
            if (count > 5) {
                lenght = 5;
            }
            for (int i = 0; i < lenght; i++) {
                cars.add(carList.get(i));
            }
            return cars;
        } else {
            return null;
        }
    }
}
