package ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import telas.TelaDeCadastroCanal;
import telas.TelaDeHome;
import utilitarios.CentralDeInformacoes;
import utilitarios.Persistencia;

public class OuvinteBotoesCadastroCanal implements ActionListener{
	private TelaDeCadastroCanal tela;
	
    public OuvinteBotoesCadastroCanal(TelaDeCadastroCanal tela) {
    	this.tela = tela;
    }
	public void actionPerformed(ActionEvent e) {
		    JButton button = (JButton) e.getSource();
		    if(button.getText().equals("Voltar")){
		    	this.tela.dispose();    
		    	new TelaDeHome(tela.getUser()); 
		    	
		    }else if (button.getText().equals("Salvar")){
		    	Persistencia p = Persistencia.getPersistencia();
				CentralDeInformacoes central = p.recuperar();
				tela.salvarCanal();
				central.addCanal(tela.getCanal());
				central.salvar();
		    }
	}

}





