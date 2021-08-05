package hu.ulyssys.java.course.maven.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table
public class Owner extends AbstractEntity{
    @Column(name = "full_name", unique = true)
    private String fullName;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Owner owner = (Owner) o;

        if (getId() != null ? !getId().equals(owner.getId()) : owner.getId() != null) return false;
        return fullName != null ? fullName.equals(owner.fullName) : owner.fullName == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (fullName != null ? fullName.hashCode() : 0);
        return result;
    }
}
