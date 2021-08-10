package hu.ulyssys.java.course.maven.rest.model;

import java.util.List;

public class OwnerDataModel extends OwnerModel {

    private List<CarModel> cars;
    private List<PlaneModel> planes;
    private List<ShipModel> ships;

    public List<CarModel> getCars() {
        return cars;
    }

    public void setCars(List<CarModel> cars) {
        this.cars = cars;
    }

    public List<PlaneModel> getPlanes() {
        return planes;
    }

    public void setPlanes(List<PlaneModel> planes) {
        this.planes = planes;
    }

    public List<ShipModel> getShips() {
        return ships;
    }

    public void setShips(List<ShipModel> ships) {
        this.ships = ships;
    }
}
