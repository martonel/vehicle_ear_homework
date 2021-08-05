package hu.ulyssys.java.course.maven.rest;

import hu.ulyssys.java.course.maven.entity.Owner;
import hu.ulyssys.java.course.maven.rest.model.OwnerModel;
import hu.ulyssys.java.course.maven.service.OwnerService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.stream.Collectors;

@Path("/farmer")
public class OwnerRestService {

    @Inject
    private OwnerService service;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        return Response.ok(service.getAll().stream().map(this::createModelFromEntity).collect(Collectors.toList())).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save(OwnerModel model) {
        Owner owner = new Owner();
        owner.setId(model.getId());
        owner.setFullName(model.getFullName());

        service.add(owner);
        return Response.ok(createModelFromEntity(owner)).build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(OwnerModel model) {
        Owner owner = service.findById(model.getId());
        if (owner == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        owner.setFullName(model.getFullName());
        service.update(owner);
        return Response.ok(createModelFromEntity(owner)).build();

    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") Long id) {
        Owner owner = service.findById(id);
        if (owner == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        service.remove(owner);
        return Response.ok().build();
    }

    private OwnerModel createModelFromEntity(Owner owner) {
        OwnerModel model = new OwnerModel();
        model.setId(owner.getId());
        model.setFullName(owner.getFullName());
        return model;
    }
}
