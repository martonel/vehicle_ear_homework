package hu.ulyssys.java.course.maven.service;

import hu.ulyssys.java.course.maven.entity.AbstractVehicle;

import java.util.List;

public interface OwnerAwareService<T extends AbstractVehicle> {

    List<T> findByOwnerId(Long id);
}
