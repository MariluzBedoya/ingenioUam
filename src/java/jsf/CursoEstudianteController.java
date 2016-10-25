package jsf;

import entidades.CursoEstudiante;
import jsf.util.JsfUtil;
import jsf.util.JsfUtil.PersistAction;
import session.CursoEstudianteFacade;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("cursoEstudianteController")
@SessionScoped
public class CursoEstudianteController implements Serializable {

    @EJB
    private session.CursoEstudianteFacade ejbFacade;
    private List<CursoEstudiante> items = null;
    private CursoEstudiante selected;

    public CursoEstudianteController() {
    }

    public CursoEstudiante getSelected() {
        return selected;
    }

    public void setSelected(CursoEstudiante selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
        selected.getCursoEstudiantePK().setCedulaEstudiante(selected.getEstudiante().getCedula());
        selected.getCursoEstudiantePK().setIdCurso(selected.getCurso().getId());
    }

    protected void initializeEmbeddableKey() {
        selected.setCursoEstudiantePK(new entidades.CursoEstudiantePK());
    }

    private CursoEstudianteFacade getFacade() {
        return ejbFacade;
    }

    public CursoEstudiante prepareCreate() {
        selected = new CursoEstudiante();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("CursoEstudianteCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("CursoEstudianteUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("CursoEstudianteDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<CursoEstudiante> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public CursoEstudiante getCursoEstudiante(entidades.CursoEstudiantePK id) {
        return getFacade().find(id);
    }

    public List<CursoEstudiante> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<CursoEstudiante> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = CursoEstudiante.class)
    public static class CursoEstudianteControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            CursoEstudianteController controller = (CursoEstudianteController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "cursoEstudianteController");
            return controller.getCursoEstudiante(getKey(value));
        }

        entidades.CursoEstudiantePK getKey(String value) {
            entidades.CursoEstudiantePK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new entidades.CursoEstudiantePK();
            key.setCedulaEstudiante(values[0]);
            key.setIdCurso(Integer.parseInt(values[1]));
            return key;
        }

        String getStringKey(entidades.CursoEstudiantePK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getCedulaEstudiante());
            sb.append(SEPARATOR);
            sb.append(value.getIdCurso());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof CursoEstudiante) {
                CursoEstudiante o = (CursoEstudiante) object;
                return getStringKey(o.getCursoEstudiantePK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), CursoEstudiante.class.getName()});
                return null;
            }
        }

    }

}
