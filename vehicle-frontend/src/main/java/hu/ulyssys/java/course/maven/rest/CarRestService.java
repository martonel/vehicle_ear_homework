package hu.ulyssys.java.course.maven.rest;

import hu.ulyssys.java.course.maven.entity.Car;
import hu.ulyssys.java.course.maven.rest.model.CarModel;

import javax.ws.rs.*;

@Path("/car")
public class CarRestService extends CoreRestService<Car, CarModel>{

    @Override
    protected Car initNewEntity() {
        return new Car();
    }

    @Override
    protected CarModel initNewModel() {
        return new CarModel();
    }
    @Override
    protected void populateEntityFromModel(Car entity, CarModel model) {
        super.populateEntityFromModel(entity, model);
        entity.setDoorNumbers(model.getDoorNumbers());
        entity.setLicensePlateNumber(model.getLicensePlateNumber());
    }

    @Override
    protected CarModel createModelFromEntity(Car entity) {
        CarModel carModel = super.createModelFromEntity(entity);
        carModel.setDoorNumbers(entity.getDoorNumbers());
        carModel.setLicensePlateNumber(entity.getLicensePlateNumber());
        return carModel;
    }
}
