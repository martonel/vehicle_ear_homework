package hu.ulyssys.java.course.maven.dao.impl;

import hu.ulyssys.java.course.maven.dao.CarDAO;
import hu.ulyssys.java.course.maven.dao.OwnerDAO;
import hu.ulyssys.java.course.maven.entity.Car;
import hu.ulyssys.java.course.maven.entity.Owner;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@ApplicationScoped
public class OwnerDAOImpl extends CoreDAOImpl<Owner> implements OwnerDAO {

    @Override
    public Owner findByName(String name) {
        //select f from Farmer f where fullname=name;
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Owner> criteriaQuery = criteriaBuilder.createQuery(Owner.class);
        Root<Owner> root = criteriaQuery.from(Owner.class);
        criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("fullName"), name));
        TypedQuery<Owner> query = entityManager.createQuery(criteriaQuery);

        //TypedQuery<Farmer> query = entityManager.createQuery("select f from Farmer f where f.fullName=:name", Farmer.class);
        List<Owner> list = query.getResultList();
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    protected Class<Owner> getManagedClass() {
        return Owner.class;
    }
}
