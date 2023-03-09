package classes;

import java.sql.Date;
import java.util.ArrayList;

public class Usuario { //Class base para armazenar dados de um user
	
    private String nome;
    private String email;
    private String senha;
    private String sexo;
    private String dataDeNascimento;//TODO convert para Date
    private ArrayList<Programa> programasFavoritos;

    public Usuario(String nome, String email,
                   String senha, String sexo,
                   String dataDeNascimento) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.sexo = sexo;
        this.dataDeNascimento = dataDeNascimento;

    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(String dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}