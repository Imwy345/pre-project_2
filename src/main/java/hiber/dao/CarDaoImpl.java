package hiber.dao;

import hiber.model.Car;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CarDaoImpl implements CarDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(String model,int series) {
        sessionFactory.getCurrentSession().save(new Car(model,series));
    }

    @Override
    public Car getCarById(Long id) {
        return sessionFactory.getCurrentSession().get(Car.class,id);
    }
}
