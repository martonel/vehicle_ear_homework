package hu.ulyssys.java.course.maven.rest;
import hu.ulyssys.java.course.maven.entity.AbstractVehicle;
import hu.ulyssys.java.course.maven.rest.model.CoreRestModel;
import hu.ulyssys.java.course.maven.service.CoreService;
import hu.ulyssys.java.course.maven.service.OwnerService;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.stream.Collectors;
public abstract class CoreRestService<T extends AbstractVehicle, M extends CoreRestModel> {

    @Inject
    private OwnerService ownerService;
    @Inject
    private CoreService<T> catService;
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        return Response.ok(catService.getAll().stream().map(this::createModelFromEntity).collect(Collectors.toList())).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save(@Valid M model) {

        T entity = initNewEntity();
        populateEntityFromModel(entity, model);
        catService.add(entity);
        return Response.ok(createModelFromEntity(entity)).build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@Valid M model) {
        T entity = catService.findById(model.getId());
        if (entity == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        populateEntityFromModel(entity, model);
        catService.update(entity);
        return Response.ok(createModelFromEntity(entity)).build();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") Long id) {
        T entity = catService.findById(id);
        if (entity == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        catService.remove(entity);
        return Response.ok().build();
    }

    protected void populateEntityFromModel(T entity, M model) {
        if (model.getOwnerId() != null) {
            entity.setOwner(ownerService.findById(model.getOwnerId()));
        }
        entity.setManufacturer(model.getManufacturer());
        entity.setType(model.getType());
    }

    protected M createModelFromEntity(T entity) {
        M model = initNewModel();
        model.setManufacturer(entity.getManufacturer());
        model.setId(entity.getId());
        model.setType(entity.getType());
        if (entity.getOwner() != null) {
            model.setOwnerId(entity.getOwner().getId());
        }
        return model;
    }

    protected abstract T initNewEntity();
    protected abstract M initNewModel();

}