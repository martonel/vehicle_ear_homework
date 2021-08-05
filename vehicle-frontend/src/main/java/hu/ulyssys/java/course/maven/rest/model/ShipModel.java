package hu.ulyssys.java.course.maven.rest.model;

public class ShipModel extends CoreRestModel {

    private String licensePlateNumber;

    public String getLicensePlateNumber() {
        return licensePlateNumber;
    }

    public void setLicensePlateNumber(String licensePlateNumber) {
        this.licensePlateNumber = licensePlateNumber;
    }
}
