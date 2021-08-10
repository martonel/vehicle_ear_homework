package hu.ulyssys.java.course.maven.rest;

import hu.ulyssys.java.course.maven.entity.*;
import hu.ulyssys.java.course.maven.rest.model.OwnerDataModel;
import hu.ulyssys.java.course.maven.rest.model.OwnerModel;
import hu.ulyssys.java.course.maven.service.CarService;
import hu.ulyssys.java.course.maven.service.OwnerService;
import hu.ulyssys.java.course.maven.service.PlaneService;
import hu.ulyssys.java.course.maven.service.ShipService;
import hu.ulyssys.java.course.maven.util.CarModelMapperBean;
import hu.ulyssys.java.course.maven.util.PlaneModelMapperBean;
import hu.ulyssys.java.course.maven.util.ShipModelMapperBean;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
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

    @Inject
    private CarModelMapperBean carModelMapperBean;
    @Inject
    private PlaneModelMapperBean planeModelMapperBean;
    @Inject
    private ShipModelMapperBean shipModelMapperBean;

    @GET
    @Path("/data/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findDataById(@PathParam("id") Long id) {
        Owner owner = service.findById(id);
        if (owner == null) {
            return Response.status(Response.Status.NOT_FOUND).build();

        }
        List<Car> carList = carService.findByOwnerId(id);
        List<Plane> planeList = planeService.findByOwnerId(id);

        List<Ship> shipList = shipService.findByOwnerId(id);

        OwnerDataModel dataModel = new OwnerDataModel();
        dataModel.setId(owner.getId());
        dataModel.setFullName(owner.getFullName());
        dataModel.setCars(carModelMapperBean.createModelsFromList(carList));
        dataModel.setPlanes(planeModelMapperBean.createModelsFromList(planeList));
        dataModel.setShips(shipModelMapperBean.createModelsFromList(shipList));

        return Response.ok(dataModel).build();
    }







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
