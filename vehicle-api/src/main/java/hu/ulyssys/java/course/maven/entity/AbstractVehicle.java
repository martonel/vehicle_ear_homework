package hu.ulyssys.java.course.maven.entity;

import javax.persistence.*;

@MappedSuperclass
public abstract class AbstractVehicle extends AbstractEntity implements VehicleTypeAware {
    // long - 0 primitive
    // Long - null referencia/objektum típusú

    @Column(name = "manufacturer")
    private String manufacturer;
    @Column(name = "type")
    private String type;
    @JoinColumn(name = "owner_id")
    @ManyToOne
    private Owner owner;

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public AbstractVehicle() {
    }


    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public VehicleType getVehicleType() {
        return null;
    }
}
