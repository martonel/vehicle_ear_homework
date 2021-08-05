package hu.ulyssys.java.course.maven.rest.model;

//CatDTO - Data Transfer Object
public class CarModel extends CoreRestModel {
    private Integer doorNumbers;
    private String licensePlateNumber;

    public Integer getDoorNumbers() {
        return doorNumbers;
    }

    public void setDoorNumbers(Integer doorNumbers) {
        this.doorNumbers = doorNumbers;
    }

    public String getLicensePlateNumber() {
        return licensePlateNumber;
    }

    public void setLicensePlateNumber(String licensePlateNumber) {
        this.licensePlateNumber = licensePlateNumber;
    }
}
