package hu.ulyssys.java.course.maven.util;

import hu.ulyssys.java.course.maven.entity.Car;
import hu.ulyssys.java.course.maven.rest.model.CarModel;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CarModelMapperBean extends CoreModelMapperBean<CarModel, Car> {

    @Override
    public CarModel createModelFromEntity(Car entity) {
        CarModel carModel = super.createModelFromEntity(entity);
        carModel.setLicensePlateNumber(entity.getLicensePlateNumber());
        carModel.setDoorNumbers(entity.getDoorNumbers());
        return carModel;
    }

    @Override
    public void populateEntityFromModel(Car entity, CarModel model) {
        super.populateEntityFromModel(entity, model);
        entity.setLicensePlateNumber(model.getLicensePlateNumber());
        entity.setDoorNumbers(model.getDoorNumbers());
    }

    @Override
    public CarModel initNewModel() {
        return new CarModel();
    }
}
