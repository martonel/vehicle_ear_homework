package hu.ulyssys.java.course.maven.rest;

import hu.ulyssys.java.course.maven.entity.Car;
import hu.ulyssys.java.course.maven.entity.Plane;
import hu.ulyssys.java.course.maven.rest.model.CarModel;
import hu.ulyssys.java.course.maven.rest.model.PlaneModel;

import javax.ws.rs.*;

@Path("/plane")
public class PlaneRestService extends CoreRestService<Plane, PlaneModel>{

    @Override
    protected Plane initNewEntity() {
        return new Plane();
    }

    @Override
    protected PlaneModel initNewModel() {
        return new PlaneModel();
    }

    @Override
    protected void populateEntityFromModel(Plane entity, PlaneModel model) {
        super.populateEntityFromModel(entity, model);
        entity.setPassengerNumber(model.getPassengerNumber());
    }

    @Override
    protected PlaneModel createModelFromEntity(Plane entity) {
        PlaneModel planeModel = super.createModelFromEntity(entity);
        planeModel.setPassengerNumber(entity.getPassengerNumber());
        return planeModel;
    }
}

