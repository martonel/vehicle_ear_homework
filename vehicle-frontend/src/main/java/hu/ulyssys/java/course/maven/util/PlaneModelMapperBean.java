package hu.ulyssys.java.course.maven.util;

import hu.ulyssys.java.course.maven.entity.Car;
import hu.ulyssys.java.course.maven.entity.Plane;
import hu.ulyssys.java.course.maven.rest.model.CarModel;
import hu.ulyssys.java.course.maven.rest.model.PlaneModel;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PlaneModelMapperBean extends CoreModelMapperBean<PlaneModel, Plane> {

    @Override
    public PlaneModel createModelFromEntity(Plane entity) {
        PlaneModel carModel = super.createModelFromEntity(entity);
        carModel.setPassengerNumber(entity.getPassengerNumber());
        return carModel;
    }

    @Override
    public void populateEntityFromModel(Plane entity, PlaneModel model) {
        super.populateEntityFromModel(entity, model);
        entity.setPassengerNumber(model.getPassengerNumber());
    }

    @Override
    public PlaneModel initNewModel() {
        return new PlaneModel();
    }
}
