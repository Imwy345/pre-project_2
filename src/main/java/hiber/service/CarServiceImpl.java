package hiber.service;

import hiber.dao.CarDao;
import hiber.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    CarDao carDao;
    @Override
    @Transactional
    public void add(String model,int series) {
        carDao.add(model,series);
    }

    @Override
    @Transactional
    public Car getCarById(Long id) {
        return carDao.getCarById(id);
    }
}
