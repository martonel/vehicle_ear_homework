package hu.ulyssys.java.course.maven.mbean;


import hu.ulyssys.java.course.maven.entity.AbstractVehicle;
import hu.ulyssys.java.course.maven.entity.Car;
import hu.ulyssys.java.course.maven.entity.Owner;
import hu.ulyssys.java.course.maven.entity.Plane;
import hu.ulyssys.java.course.maven.service.CoreService;
import hu.ulyssys.java.course.maven.service.OwnerService;
import hu.ulyssys.java.course.maven.service.PlaneService;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class PlaneCRUDMbean extends OwnerAwareCRUDMbean<Plane> implements Serializable  {

    @Inject
    public PlaneCRUDMbean(PlaneService service, OwnerService ownerService) {
        super(service, ownerService);
    }

    @Override
    protected String dialogName() {
        return "planeDialog";
    }

    @Override
    protected Plane initNewEntity() {
        return new Plane();
    }
}
