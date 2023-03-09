package utilitarios;

import utilitarios.LoginConfig;
import classes.Canal;
import classes.Usuario;
import utilitarios.Persistencia;

import java.util.ArrayList;

public class CentralDeInformacoes {
    private ArrayList usuarios = new ArrayList<Usuario>();
    private ArrayList canais = new ArrayList<Canal>();
    private LoginConfig loginSeguranca;
    
    public void salvar(){
        Persistencia persistencia = Persistencia.getPersistencia(); //salvar na persistencia
        try {
            persistencia.salvar(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void addUser(Usuario usuario){ //adicionar usuarios no array
        this.usuarios.add(usuario);
    }

    public void addLogin(LoginConfig loginSeguranca){
        this.loginSeguranca = loginSeguranca;
    }


    public ArrayList<Usuario> getUsuario() {
        return this.usuarios;
    }

    public LoginConfig getLogin(){
        return this.loginSeguranca;
    }
    
    public void addCanal(Canal canal){ //adicionar canais no array
        this.canais.add(canal);
    }
    public ArrayList<Canal> getCanal() {
        return this.canais;
    }
    
    
    
}