package controlador;

import modelo.SeccionalAspecto;
import controlador.util.JsfUtil;
import controlador.util.JsfUtil.PersistAction;
import fachada.SeccionalAspectoFacade;

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

@Named("seccionalAspectoController")
@SessionScoped
public class SeccionalAspectoController implements Serializable {

    @EJB
    private fachada.SeccionalAspectoFacade ejbFacade;
    private List<SeccionalAspecto> items = null;
    private SeccionalAspecto selected;

    public SeccionalAspectoController() {
    }

    public SeccionalAspecto getSelected() {
        return selected;
    }

    public void setSelected(SeccionalAspecto selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private SeccionalAspectoFacade getFacade() {
        return ejbFacade;
    }

    public SeccionalAspecto prepareCreate() {
        selected = new SeccionalAspecto();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("SeccionalAspectoCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("SeccionalAspectoUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("SeccionalAspectoDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<SeccionalAspecto> getItems() {
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

    public SeccionalAspecto getSeccionalAspecto(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<SeccionalAspecto> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<SeccionalAspecto> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = SeccionalAspecto.class)
    public static class SeccionalAspectoControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            SeccionalAspectoController controller = (SeccionalAspectoController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "seccionalAspectoController");
            return controller.getSeccionalAspecto(getKey(value));
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
            if (object instanceof SeccionalAspecto) {
                SeccionalAspecto o = (SeccionalAspecto) object;
                return getStringKey(o.getIdSECCIONALASPECTO());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), SeccionalAspecto.class.getName()});
                return null;
            }
        }

    }

}
