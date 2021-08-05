package hu.ulyssys.java.course.maven.mbean;


import hu.ulyssys.java.course.maven.entity.AbstractVehicle;
import hu.ulyssys.java.course.maven.entity.Car;
import hu.ulyssys.java.course.maven.entity.Owner;
import hu.ulyssys.java.course.maven.entity.Ship;
import hu.ulyssys.java.course.maven.service.CoreService;
import hu.ulyssys.java.course.maven.service.OwnerService;
import hu.ulyssys.java.course.maven.service.ShipService;
import org.primefaces.PrimeFaces;

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
public class ShipCRUDMbean extends OwnerAwareCRUDMbean<Ship> implements Serializable  {

    @Inject
    public ShipCRUDMbean(ShipService service, OwnerService ownerService) {
        super(service, ownerService);
    }

    @Override
    protected String dialogName() {
        return "shipDialog";
    }

    @Override
    protected Ship initNewEntity() {
        return new Ship();
    }
}
