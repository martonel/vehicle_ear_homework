package hu.ulyssys.java.course.maven.converter;

import hu.ulyssys.java.course.maven.entity.Owner;
import hu.ulyssys.java.course.maven.service.OwnerService;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Optional;

@Named
@ApplicationScoped
public class OwnerConverter implements Converter {

    @Inject
    private OwnerService ownerService;

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        if (s == null) {
            return null;
        }
        //SQL query lesz majd, findByName
        return ownerService.findByName(s);

    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        if (o instanceof Owner) {
            return ((Owner) o).getFullName();
        }
        if (o instanceof String) {
            return o.toString();
        }
        return null;
    }
}
