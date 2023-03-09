package classes;

import java.time.DayOfWeek;
import java.util.ArrayList;

import enums.Genero;
import enums.StatusDeExibicao;
import enums.TipoDePrograma;

public class Programa {
	
	private String nome;
	private Canal canalDeTransmissao;
	private TipoDePrograma tipoDePrograma;
	private StatusDeExibicao status;
	private Genero genero;
	private boolean favorito;
	private String temporadas;
	private ArrayList <DayOfWeek> diasDaSemana;
	
	
	public Programa(String nome, Canal canalDeTransmissao, TipoDePrograma tipoDePrograma, StatusDeExibicao status,
			Genero genero, boolean favorito, String temporadas, ArrayList<DayOfWeek> diasDaSemana) {
		this.nome = nome;
		this.canalDeTransmissao = canalDeTransmissao;
		this.tipoDePrograma = tipoDePrograma;
		this.status = status;
		this.genero = genero;
		this.favorito = favorito;
		this.temporadas = temporadas;
		this.diasDaSemana = diasDaSemana;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Canal getCanalDeTransmissao() {
		return canalDeTransmissao;
	}

	public void setCanalDeTransmissao(Canal canalDeTransmissao) {
		this.canalDeTransmissao = canalDeTransmissao;
	}

	public TipoDePrograma getTipoDePrograma() {
		return tipoDePrograma;
	}

	public void setTipoDePrograma(TipoDePrograma tipoDePrograma) {
		this.tipoDePrograma = tipoDePrograma;
	}

	
	public StatusDeExibicao getStatus() {
		return status;
	}

	public void setStatus(StatusDeExibicao status) {
		this.status = status;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public boolean isFavorito() {
		return favorito;
	}

	public void setFavorito(boolean favorito) {
		this.favorito = favorito;
	}

	public String getTemporadas() {
		return temporadas;
	}

	public void setTemporadas(String temporadas) {
		this.temporadas = temporadas;
	}

	public ArrayList<DayOfWeek> getDiasDaSemana() {
		return diasDaSemana;
	}

	public void setDiasDaSemana(ArrayList<DayOfWeek> diasDaSemana) {
		this.diasDaSemana = diasDaSemana;
	}
}
