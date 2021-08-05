package hu.ulyssys.java.course.maven.entity;

import javax.persistence.*;

@Entity
@Table
public class Plane extends AbstractVehicle {
    @Column(name = "passenger_number")
    private int passengerNumber;
    public int getPassengerNumber() {
        return passengerNumber;
    }

    public void setPassengerNumber(int passengerNumber) {
        this.passengerNumber = passengerNumber;
    }

    @Override
    public VehicleType getVehicleType() {
        return VehicleType.PLANE;
    }
}
