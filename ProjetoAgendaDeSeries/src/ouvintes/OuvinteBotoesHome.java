package ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import classes.Usuario;
import telas.TelaDeCadastroCanal;
import telas.TelaDeHome;
import telas.TelaDeLogin;
import telas.TelaDePrograma;
import utilitarios.CentralDeInformacoes;
import utilitarios.Persistencia;

public class OuvinteBotoesHome implements ActionListener {
	
	private TelaDeHome telaDeHome;
    private CentralDeInformacoes central = Persistencia.getPersistencia().recuperar();
    
    public OuvinteBotoesHome(TelaDeHome telaDeHome){
        this.telaDeHome = telaDeHome;
    }
    
    public boolean apagarConta() {
    	String mensagem="";
    	try {
    		String senha1 = JOptionPane.showInputDialog(telaDeHome, "Digite sua senha: ");
    		String confirmacaoDeSenha = (telaDeHome.getUser().getSenha());
    		
    		
    		if(senha1.equals(confirmacaoDeSenha)) {
    			int result = JOptionPane.showConfirmDialog(telaDeHome,
    					"Essa ação não poderá ser desfeita \n"+"Tem certeza que deseja continuar?",
    					"Apagar User",
    					JOptionPane.YES_NO_OPTION);
    			if(result==0) {
    				for(Usuario u : central.getUsuario()) {
    					if(u.getEmail().equals(telaDeHome.getUser().getEmail())) {
    						central.getUsuario().remove(u);
    						central.getLogin().setEmailUsuario(null);
    						central.salvar();
    						break;
    					}
    				}
    				mensagem = "Feito!";
    				telaDeHome.dispose();
    				new TelaDeLogin();
    				
    			}
    			
    		}
    		
    	}catch(Exception e) {
    		mensagem="Operação Cancelada";
    		
    	}finally {
    		JOptionPane.showMessageDialog(null, mensagem);
    	}
    	
    	
    	
    	return false;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton botao = (JButton) e.getSource();
        switch (botao.getText()){
	        case"Canais":
	            this.telaDeHome.dispose();
	            new TelaDeCadastroCanal(telaDeHome.getUser()); //Programar aba de favoritos
	            break;
	        case"Programas":
	            this.telaDeHome.dispose();
	            new TelaDePrograma(telaDeHome.getUser()); 
	            break;
            case"Favoritos":
                this.telaDeHome.dispose();
                //new Tela(this.tela.getUser(), "Favoritos"); //Programar aba de favoritos
                break;
            case"Sair":
                this.telaDeHome.dispose();
                central.getLogin().setEmailUsuario(null);
                central.salvar();
                new TelaDeLogin();
                break;
            case"Deletar perfil":
            	this.apagarConta();
            	
        }

    }
 
}
