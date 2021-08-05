package hu.ulyssys.java.course.maven.mbean;


import hu.ulyssys.java.course.maven.entity.AbstractVehicle;
import hu.ulyssys.java.course.maven.entity.Owner;
import hu.ulyssys.java.course.maven.service.CoreService;
import hu.ulyssys.java.course.maven.service.OwnerService;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;



@Named
@ViewScoped
public class OwnerCRUDMbean extends CoreCRUDMbean<Owner> implements Serializable{

    @Inject
    public OwnerCRUDMbean(OwnerService service) {
        super(service);
    }

    @Override
    protected String dialogName() {
        return "ownerDialog";
    }

    @Override
    protected Owner initNewEntity() {
        return new Owner();
    }
}
