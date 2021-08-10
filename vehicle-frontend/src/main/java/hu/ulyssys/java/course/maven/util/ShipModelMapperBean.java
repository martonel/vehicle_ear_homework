package hu.ulyssys.java.course.maven.util;

import hu.ulyssys.java.course.maven.entity.Car;
import hu.ulyssys.java.course.maven.entity.Ship;
import hu.ulyssys.java.course.maven.rest.model.CarModel;
import hu.ulyssys.java.course.maven.rest.model.ShipModel;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ShipModelMapperBean extends CoreModelMapperBean<ShipModel, Ship> {


    @Override
    public ShipModel createModelFromEntity(Ship entity) {
        ShipModel shipModel = super.createModelFromEntity(entity);
        shipModel.setLicensePlateNumber(entity.getLicensePlateNumber());
        return shipModel;
    }

    @Override
        public void populateEntityFromModel(Ship entity, ShipModel model) {
        super.populateEntityFromModel(entity, model);
        entity.setLicensePlateNumber(model.getLicensePlateNumber());
        entity.setLicensePlateNumber(model.getLicensePlateNumber());
    }

    @Override
    public ShipModel initNewModel() {
        return new ShipModel();
    }
}
