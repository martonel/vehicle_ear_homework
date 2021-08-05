package hu.ulyssys.java.course.maven.dao.impl;


import hu.ulyssys.java.course.maven.dao.OwnerDAO;
import hu.ulyssys.java.course.maven.dao.PlaneDAO;
import hu.ulyssys.java.course.maven.entity.Owner;
import hu.ulyssys.java.course.maven.entity.Plane;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class PlaneDAOImpl  extends CoreDAOImpl<Plane> implements PlaneDAO {

    @Override
    protected Class<Plane> getManagedClass() {
        return Plane.class;
    }
}
