package jsf;

import kitabim.Kitap;
import jsf.util.JsfUtil;
import jsf.util.JsfUtil.PersistAction;
import session.KitapFacade;

import java.io.Serializable;
import java.util.ArrayList;
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
import kitabim.Kategori;

@Named("kitapController")
@SessionScoped
public class KitapController implements Serializable {

    @EJB
    private session.KitapFacade ejbFacade;
    private List<Kitap> items = null;
    private Kitap selected;
    List<Kategori> selectedKategori=new ArrayList<>();
    public List<Kategori> getSelectedKategori(){
        return selectedKategori=selectedKategori;
    }
    public void setSelectedKategori(List<Kategori> selectedKategori){
        this.selectedKategori=selectedKategori;
    }

    public KitapController() {
    }

    public Kitap getSelected() {
        return selected;
    }

    public void setSelected(Kitap selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private KitapFacade getFacade() {
        return ejbFacade;
    }

    public Kitap prepareCreate() {
        selected = new Kitap();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        System.out.println("size:"+selectedKategori.size());
        System.out.println("selecteds:"+ selectedKategori.toString());
        
        selected.setKategoriCollection(selectedKategori);
        
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("KitapCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("KitapUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("KitapDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Kitap> getItems() {
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

    public Kitap getKitap(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Kitap> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Kitap> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Kitap.class)
    public static class KitapControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            KitapController controller = (KitapController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "kitapController");
            return controller.getKitap(getKey(value));
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
            if (object instanceof Kitap) {
                Kitap o = (Kitap) object;
                return getStringKey(o.getKid());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Kitap.class.getName()});
                return null;
            }
        }

    }

}
