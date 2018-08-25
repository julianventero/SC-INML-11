package controlador;

import modelo.SeccionalCriterio;
import controlador.util.JsfUtil;
import controlador.util.JsfUtil.PersistAction;
import fachada.SeccionalCriterioFacade;

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

@Named("seccionalCriterioController")
@SessionScoped
public class SeccionalCriterioController implements Serializable {

    @EJB
    private fachada.SeccionalCriterioFacade ejbFacade;
    private List<SeccionalCriterio> items = null;
    private SeccionalCriterio selected;

    public SeccionalCriterioController() {
    }

    public SeccionalCriterio getSelected() {
        return selected;
    }

    public void setSelected(SeccionalCriterio selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private SeccionalCriterioFacade getFacade() {
        return ejbFacade;
    }

    public SeccionalCriterio prepareCreate() {
        selected = new SeccionalCriterio();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("SeccionalCriterioCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("SeccionalCriterioUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("SeccionalCriterioDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<SeccionalCriterio> getItems() {
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

    public SeccionalCriterio getSeccionalCriterio(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<SeccionalCriterio> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<SeccionalCriterio> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = SeccionalCriterio.class)
    public static class SeccionalCriterioControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            SeccionalCriterioController controller = (SeccionalCriterioController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "seccionalCriterioController");
            return controller.getSeccionalCriterio(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof SeccionalCriterio) {
                SeccionalCriterio o = (SeccionalCriterio) object;
                return getStringKey(o.getIdSECCIONALCRITERIO());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), SeccionalCriterio.class.getName()});
                return null;
            }
        }

    }

}
