package hu.ulyssys.java.course.maven.service;



import hu.ulyssys.java.course.maven.entity.Owner;

import java.util.List;

public interface OwnerService extends CoreService<Owner>{

    Owner findByName(String name);
}
