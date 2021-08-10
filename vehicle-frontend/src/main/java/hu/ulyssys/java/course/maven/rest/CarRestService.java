package hu.ulyssys.java.course.maven.rest;


import hu.ulyssys.java.course.maven.entity.Car;
import hu.ulyssys.java.course.maven.rest.model.CarModel;

import javax.ws.rs.Path;
@Path("/car")
public class CarRestService extends CoreRestService<Car, CarModel> {



    @Override
    protected Car initNewEntity() {
        return new Car();
    }
    @Override
    protected CarModel initNewModel() {
        return new CarModel();
    }
}