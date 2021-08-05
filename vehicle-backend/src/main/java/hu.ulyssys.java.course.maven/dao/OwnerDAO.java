package hu.ulyssys.java.course.maven.dao;

import hu.ulyssys.java.course.maven.entity.Car;
import hu.ulyssys.java.course.maven.entity.Owner;

import java.util.List;

public interface OwnerDAO extends CoreDAO<Owner>{

    Owner findByName(String name);

}
