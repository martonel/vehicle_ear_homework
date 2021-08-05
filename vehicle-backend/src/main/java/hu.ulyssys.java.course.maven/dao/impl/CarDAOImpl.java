package hu.ulyssys.java.course.maven.dao.impl;

import hu.ulyssys.java.course.maven.dao.CarDAO;
import hu.ulyssys.java.course.maven.entity.Car;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@ApplicationScoped
public class CarDAOImpl  extends CoreDAOImpl<Car> implements CarDAO {

    @Override
    protected Class<Car> getManagedClass() {
        return Car.class;
    }
}
