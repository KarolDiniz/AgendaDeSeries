package utilitarios;

import classes.Usuario;

public class LoginConfig {
	
    private Usuario email = null;
    private static LoginConfig login;
    
    private LoginConfig() {

    }
    public static LoginConfig getUnicaInstancia(){
        if(login == null){
            login = new LoginConfig();
        }
        return login;
    }
    public Usuario getEmailUsuario() { 
        return email;
    }

    public void setEmailUsuario(Usuario email) {
        this.email = email;
    }
}
