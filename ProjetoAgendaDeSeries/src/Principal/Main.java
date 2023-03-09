package Principal;

import classes.Usuario;
import telas.TelaDeCadastro;
import telas.TelaDeLogin;
import telas.TelaDePrograma;
import utilitarios.CentralDeInformacoes;
import utilitarios.Persistencia;

public class Main {
	
	public static void main(String[] args) {
		
		Persistencia p = Persistencia.getPersistencia();
		CentralDeInformacoes central = new CentralDeInformacoes();
		
		if(central.getUsuario()!= null) {
			TelaDeLogin tela = new TelaDeLogin();
			tela.getTrilha().play();
		}
		else {
			TelaDeCadastro tela = new TelaDeCadastro();
		}

	}

}
