package hu.ulyssys.java.course.maven.rest;

import hu.ulyssys.java.course.maven.entity.Ship;
import hu.ulyssys.java.course.maven.rest.model.ShipModel;
import javax.ws.rs.Path;

@Path("/ship")
public class ShipRestService extends CoreRestService<Ship, ShipModel>{

    @Override
    protected Ship initNewEntity() {
        return new Ship();
    }

    @Override
    protected ShipModel initNewModel() {
        return new ShipModel();
    }


    @Override
    protected void populateEntityFromModel(Ship entity, ShipModel model) {
        super.populateEntityFromModel(entity, model);
        entity.setLicensePlateNumber(model.getLicensePlateNumber());
    }

    @Override
    protected ShipModel createModelFromEntity(Ship entity) {
        ShipModel shipModel = super.createModelFromEntity(entity);
        shipModel.setLicensePlateNumber(entity.getLicensePlateNumber());
        return shipModel;
    }
}
