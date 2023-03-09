package classes;

import java.util.ArrayList;

import enums.TipoDeCanal;

public class Canal {
	 
	private Usuario user;
	private String nome;
	private String numeroOuLinkDeAcesso;
	private TipoDeCanal tipoDeCanal;
	private ArrayList<Programa> programas;
	

	public Canal(String nome, TipoDeCanal tipoDeCanal, String numeroOuLinkDeAcesso ) {
		
		this.nome = nome;
		this.tipoDeCanal = tipoDeCanal;
		this.numeroOuLinkDeAcesso = numeroOuLinkDeAcesso;
		
	}

	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public TipoDeCanal getTipoDeCanal() {
		return tipoDeCanal;
	}
	public void setTipoDeCanal(TipoDeCanal tipoDeCanal) {
		this.tipoDeCanal = tipoDeCanal;
	}

	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}

	public String getNumeroOuLinkDeAcesso() {
		return numeroOuLinkDeAcesso;
	}

	public void setNumeroOuLinkDeAcesso(String numeroOuLinkDeAcesso) {
		this.numeroOuLinkDeAcesso = numeroOuLinkDeAcesso;
	}

	public ArrayList<Programa> getProgramas() {
		return programas;
	}

	public void setProgramas(ArrayList<Programa> programas) {
		this.programas = programas;
	}
	
}

