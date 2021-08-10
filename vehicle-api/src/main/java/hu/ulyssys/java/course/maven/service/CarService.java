package hu.ulyssys.java.course.maven.service;

import hu.ulyssys.java.course.maven.entity.Car;

public interface CarService extends CoreService<Car>,OwnerAwareService<Car> {

}
