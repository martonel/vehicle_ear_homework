package hu.ulyssys.java.course.maven.util;

import hu.ulyssys.java.course.maven.entity.AbstractVehicle;
import hu.ulyssys.java.course.maven.rest.model.CoreRestModel;
import hu.ulyssys.java.course.maven.service.OwnerService;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

public abstract class CoreModelMapperBean<M extends CoreRestModel, T extends AbstractVehicle> {

    @Inject
    private OwnerService ownerService;

    public M createModelFromEntity(T entity) {
        M model = initNewModel();
        model.setManufacturer(entity.getManufacturer());
        model.setId(entity.getId());
        model.setType(entity.getType());
        if (entity.getOwner() != null) {
            model.setOwnerId(entity.getOwner().getId());
        }
        return model;
    }

    public List<M> createModelsFromList(List<T> entity) {
        return entity.stream().map(this::createModelFromEntity).collect(Collectors.toList());
    }

    public void populateEntityFromModel(T entity, M model) {
        if (model.getOwnerId() != null) {
            entity.setOwner(ownerService.findById(model.getOwnerId()));
        }
        entity.setType(model.getType());
        entity.setManufacturer(model.getManufacturer());
    }

    public abstract M initNewModel();

}
