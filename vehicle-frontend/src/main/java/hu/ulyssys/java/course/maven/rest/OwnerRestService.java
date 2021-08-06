package hu.ulyssys.java.course.maven.rest;

import com.itextpdf.text.Paragraph;
import hu.ulyssys.java.course.maven.entity.*;
import hu.ulyssys.java.course.maven.rest.model.OwnerModel;
import hu.ulyssys.java.course.maven.service.CarService;
import hu.ulyssys.java.course.maven.service.OwnerService;
import hu.ulyssys.java.course.maven.service.PlaneService;
import hu.ulyssys.java.course.maven.service.ShipService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Path("/owner")
public class OwnerRestService {

    @Inject
    private OwnerService service;

    @Inject
    private CarService carService;

    @Inject
    private PlaneService planeService;

    @Inject
    private ShipService shipService;

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



    @GET
    @Path("/demo/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findByOwnerID(@PathParam("id") Long id) {
        //select * form vehicle where ownerid =1
        List<AbstractVehicle> list = new ArrayList<>();
        int i = 0;
        for (Car car : carService.getAll()) {
            if(car.getOwner()!=null){
                if(car.getOwner().getId().equals(id)) {
                    list.add(car);
                }
            }
        }
        for (Plane plane : planeService.getAll()) {
            if(plane.getOwner()!=null){
                if(plane.getOwner().getId().equals(id)){
                    list.add(plane);
                }
            }
        }
        for (Ship ship : shipService.getAll()) {
            if(ship.getOwner()!=null){
                if(ship.getOwner().getId().equals(id)){
                    list.add(ship);
                }
            }
        }
        if(list.size()==0){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(list).build();
    }

    private OwnerModel createModelFromEntity(Owner owner) {
        OwnerModel model = new OwnerModel();
        model.setId(owner.getId());
        model.setFullName(owner.getFullName());
        return model;
    }
}
