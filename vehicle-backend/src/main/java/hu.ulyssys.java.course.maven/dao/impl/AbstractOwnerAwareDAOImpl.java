package hu.ulyssys.java.course.maven.dao.impl;

import hu.ulyssys.java.course.maven.dao.OwnerAwareDAO;
import hu.ulyssys.java.course.maven.entity.AbstractVehicle;

import javax.persistence.TypedQuery;
import java.util.List;

public abstract class AbstractOwnerAwareDAOImpl<T extends AbstractVehicle> extends CoreDAOImpl<T> implements OwnerAwareDAO<T> {

    @Override
    public List<T> findByOwnerId(Long id) {
        TypedQuery<T> query = entityManager.createQuery("select n from " + getManagedClass().getSimpleName() + " n where n.owner.id=:id order by n.id", getManagedClass());
        query.setParameter("id", id);
        return query.getResultList();
    }
}
