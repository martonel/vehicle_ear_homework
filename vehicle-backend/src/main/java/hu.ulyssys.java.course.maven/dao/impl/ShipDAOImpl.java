package hu.ulyssys.java.course.maven.dao.impl;

import hu.ulyssys.java.course.maven.dao.CarDAO;
import hu.ulyssys.java.course.maven.dao.OwnerDAO;
import hu.ulyssys.java.course.maven.dao.ShipDAO;
import hu.ulyssys.java.course.maven.entity.Car;
import hu.ulyssys.java.course.maven.entity.Owner;
import hu.ulyssys.java.course.maven.entity.Ship;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class ShipDAOImpl  extends CoreDAOImpl<Ship> implements ShipDAO {


    @Override
    protected Class<Ship> getManagedClass() {
        return Ship.class;
    }
}
