package hu.ulyssys.java.course.maven.mbean;

import hu.ulyssys.java.course.maven.entity.AbstractVehicle;
import hu.ulyssys.java.course.maven.entity.Owner;
import hu.ulyssys.java.course.maven.service.CoreService;
import hu.ulyssys.java.course.maven.service.OwnerService;

import java.util.List;

public abstract class OwnerAwareCRUDMbean<T extends AbstractVehicle> extends CoreCRUDMbean<T>{
    private List<Owner> ownerList;

    public OwnerAwareCRUDMbean(CoreService<T> service, OwnerService ownerService) {
        super(service);
        ownerList = ownerService.getAll();
    }

    public List<Owner> getOwnerList() {
        return ownerList;
    }

    public void setOwnerList(List<Owner> ownerList) {
        this.ownerList = ownerList;
    }
}
