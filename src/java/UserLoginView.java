 
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
 
import org.primefaces.context.RequestContext;
 
@ManagedBean
public class UserLoginView {
        
     String username;
     
     String password;
 
    public String getUsername() {
        return username;
    }
 
    public void setUsername(String username) {
        this.username = username;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }

    public String login(){
            RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage mesaj = null;
        boolean giris = false;
    
        if(username != null && username.equals("esra") && password != null && password.equals("esra"))
        {
           giris = true;
            mesaj = new FacesMessage(FacesMessage.SEVERITY_INFO, "Kitap otomasyonuna hoşgeldin", username);
            return "a?faces-redirect=true";
        }
      else
        {
            giris=false;
            mesaj = new FacesMessage(FacesMessage.SEVERITY_INFO, "Kitap otomasyonuna girilemedi", username);
           return "notfound.xhtml?faces-redirect=true";
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
 
   
    
    
    
   /*
    <h:outputLabel for="username" value="kullanıcı adı:" />
            <p:inputText id="username" value="#{userLoginView.username}" required="true" label="username" />
 
            <h:outputLabel for="password" value="Şifresi:" />
            <p:password id="password" value="#{userLoginView.password}" required="true" label="password" />
 
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public String login() {
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage mesaj = null;
        boolean giris = false;
         
        if(username != null && username.equals("esra") && password != null && password.equals("admin")) {
           giris = true;
            mesaj = new FacesMessage(FacesMessage.SEVERITY_INFO, "Kitap otomasyonuna hoşgeldin", username);
            return "a?faces-redirect=true";
            
        } else {
            giris = false;
            mesaj = new FacesMessage(FacesMessage.SEVERITY_WARN, "bir şeyler ters gitti", username);
        }
         
        FacesContext.getCurrentInstance().addMessage(null, mesaj);
        context.addCallbackParam("loggedIn", giris);
    }*/
}
