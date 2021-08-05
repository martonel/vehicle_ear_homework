package hu.ulyssys.java.course.maven.service.impl;


import hu.ulyssys.java.course.maven.dao.PlaneDAO;
import hu.ulyssys.java.course.maven.entity.Car;
import hu.ulyssys.java.course.maven.entity.Plane;
import hu.ulyssys.java.course.maven.service.CarService;
import hu.ulyssys.java.course.maven.service.PlaneService;

import javax.ejb.Stateless;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Stateless
public class PlaneServiceImpl extends AbstractServiceImpl<Plane> implements PlaneService {

}
