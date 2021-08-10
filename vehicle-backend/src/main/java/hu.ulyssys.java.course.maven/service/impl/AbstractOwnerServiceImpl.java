package hu.ulyssys.java.course.maven.service.impl;

import hu.ulyssys.java.course.maven.dao.OwnerAwareDAO;
import hu.ulyssys.java.course.maven.entity.AbstractVehicle;
import hu.ulyssys.java.course.maven.service.OwnerAwareService;

import java.util.List;


public abstract class AbstractOwnerServiceImpl<T extends AbstractVehicle> extends AbstractServiceImpl<T> implements OwnerAwareService<T> {
    @Override
    public List<T> findByOwnerId(Long id) {
        return ((OwnerAwareDAO<T>) dao).findByOwnerId(id);
    }
}
