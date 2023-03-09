package ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import classes.Usuario;
import interfaces.EfetuarLogin;
import telas.TelaDeCadastro;
import telas.TelaDeHome;
import telas.TelaDeLogin;
import utilitarios.CentralDeInformacoes;
import utilitarios.LoginConfig;
import utilitarios.Persistencia;

public class OuvinteBotoesLogin implements ActionListener, EfetuarLogin {
	
    private TelaDeLogin telaDeLogin;
    private CentralDeInformacoes central;
    
    public OuvinteBotoesLogin(TelaDeLogin telaDeLogin){
        this.telaDeLogin = telaDeLogin;

    }
    @Override
    //
    public Usuario efetuarLogin(){
    	
    	String email = telaDeLogin.getEmail(); 
        String senha = telaDeLogin.getSenha();
        Persistencia persistencia = Persistencia.getPersistencia();
        central = persistencia.recuperar();
        
        for(Usuario usuario: central.getUsuario()){
            if(usuario.getEmail().equals(email) && usuario.getSenha().equals(senha)){
                return usuario;
            }
        }
        return null;
    }
    public void login(){
        String mensagem;
        try{
        	LoginConfig login = LoginConfig.getUnicaInstancia();
            Usuario user = this.efetuarLogin();
            String email = user.getEmail();
            
            login.setEmailUsuario(user);
            central.addLogin(login);
            central.salvar();
            telaDeLogin.dispose();
            new TelaDeHome(user);

        }catch(Exception e){
        	e.printStackTrace();
            mensagem = "Email ou senha incorretos, tente novamente!";
            JOptionPane.showMessageDialog(telaDeLogin,mensagem);
            new TelaDeLogin();
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton botao = (JButton) e.getSource();
        String nomeBtn = botao.getText();
        
        if(nomeBtn.equals("Entrar")){
            telaDeLogin.dispose();
        }
        if(nomeBtn.equals("Criar nova conta")){
        	telaDeLogin.dispose();
            new TelaDeCadastro();
        }else{
            this.login();
        }
    }
}
