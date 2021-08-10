package hu.ulyssys.java.course.maven.service.impl;

import hu.ulyssys.java.course.maven.dao.ShipDAO;
import hu.ulyssys.java.course.maven.entity.Car;
import hu.ulyssys.java.course.maven.entity.Ship;
import hu.ulyssys.java.course.maven.service.CarService;
import hu.ulyssys.java.course.maven.service.ShipService;

import javax.ejb.Stateless;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Stateless
public class ShipServiceImpl extends AbstractOwnerServiceImpl<Ship> implements ShipService {

}
