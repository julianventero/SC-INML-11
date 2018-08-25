package controlador;

import modelo.EncuestaCriterio;
import controlador.util.JsfUtil;
import controlador.util.JsfUtil.PersistAction;
import fachada.EncuestaCriterioFacade;

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

@Named("encuestaCriterioController")
@SessionScoped
public class EncuestaCriterioController implements Serializable {

    @EJB
    private fachada.EncuestaCriterioFacade ejbFacade;
    private List<EncuestaCriterio> items = null;
    private EncuestaCriterio selected;

    public EncuestaCriterioController() {
    }

    public EncuestaCriterio getSelected() {
        return selected;
    }

    public void setSelected(EncuestaCriterio selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private EncuestaCriterioFacade getFacade() {
        return ejbFacade;
    }

    public EncuestaCriterio prepareCreate() {
        selected = new EncuestaCriterio();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("EncuestaCriterioCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("EncuestaCriterioUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("EncuestaCriterioDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<EncuestaCriterio> getItems() {
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

    public EncuestaCriterio getEncuestaCriterio(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<EncuestaCriterio> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<EncuestaCriterio> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = EncuestaCriterio.class)
    public static class EncuestaCriterioControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            EncuestaCriterioController controller = (EncuestaCriterioController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "encuestaCriterioController");
            return controller.getEncuestaCriterio(getKey(value));
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
            if (object instanceof EncuestaCriterio) {
                EncuestaCriterio o = (EncuestaCriterio) object;
                return getStringKey(o.getIdENCUESTACRITERIO());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), EncuestaCriterio.class.getName()});
                return null;
            }
        }

    }

}
