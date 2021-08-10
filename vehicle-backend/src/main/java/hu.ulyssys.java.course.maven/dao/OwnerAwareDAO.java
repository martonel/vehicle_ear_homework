package hu.ulyssys.java.course.maven.dao;

import hu.ulyssys.java.course.maven.dao.CoreDAO;
import hu.ulyssys.java.course.maven.entity.AbstractVehicle;

import java.util.List;

public interface OwnerAwareDAO <T extends AbstractVehicle> extends CoreDAO<T>
{
        List<T> findByOwnerId(Long id);
}
