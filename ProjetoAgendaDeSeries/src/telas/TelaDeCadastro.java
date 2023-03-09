package telas;

import ouvintes.OuvinteBotoesCadastro;
import ouvintes.OuvinteBotoesLogin;
import telas.EstruturaTelas;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.text.ParseException;

import javax.swing.text.MaskFormatter;

public class TelaDeCadastro extends EstruturaTelas {

    private JTextField nomeDeUsuario;
    private JTextField email;
    private JTextField senha;
    private JFormattedTextField dataDeNascimento;
    private JRadioButton bMasculino = new JRadioButton("Masculino", false);
    private JRadioButton bfeminino = new JRadioButton("Feminino", false);

    public TelaDeCadastro() {
        super("Cadastre-se");
        try{
        	super.adicionarPainel(330, 15, 350, 380, 100);
    		super.adicionarIcone(50, 0, 250, 250);
        	this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        	this.setLayout(null);

            this.adicionarFormularios();
            this.adicionarCaixaDeTexto();
            this.adicionarBotoes();
            this.adicionarBotaoDuplo();
            this.adicionarTextos();
            
            this.addBackground("/imagens/CadastroBackground.jpeg");
            this.setResizable(false);
            this.setVisible(true);

        }catch(Exception e){
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null,"ERRO - Não foi possível prosseguir");
        }
    }
    
    public void adicionarTextos() {	
		JLabel subtitulo = new JLabel("<html>Já pensou em agendar suas séries<br> e filmes favoritos? na AGENDAON você<br> pode isso e muito mais!");
		subtitulo.setBounds(30,160,400,100);
		subtitulo.setFont(new Font("Arial", Font.BOLD, 12));
		subtitulo.setForeground(Color.WHITE); //cor da fonte
		this.add(subtitulo);
    }
    

    public void adicionarFormularios() {
    	JLabel principal = new JLabel("Welcome",JLabel.CENTER);
        JLabel nome = new JLabel("Nome:");
        JLabel sexo = new JLabel("Sexo:");
        JLabel email = new JLabel("Email:");
        JLabel senha = new JLabel("Senha:");
        JLabel data = new JLabel("Nascimento:");
        Font font = new Font("Arial",Font.BOLD,15);

        principal.setBounds(0, 10, 370, 25);
        principal.setFont(new Font("Arial",Font.BOLD,20));
        principal.setForeground(Color.WHITE);
        this.getPainel().add(principal);


        nome.setBounds(30, 47, 165, 30);
        nome.setFont(font);
        nome.setForeground(Color.white);
        this.getPainel().add(nome);

        sexo.setBounds(30, 89, 165, 30);
        sexo.setFont(font);
        sexo.setForeground(Color.white);
        this.getPainel().add(sexo);

        data.setBounds(30, 150, 165, 30 );
        data.setFont(font);
        data.setForeground(Color.white);
        this.getPainel().add(data);

        email.setBounds(30, 200, 100, 30);
        email.setFont(font);
        email.setForeground(Color.white);
        this.getPainel().add(email);
        
        senha.setBounds(30, 250, 100, 30);
        senha.setFont(font);
        senha.setForeground(Color.white);
        this.getPainel().add(senha);

    }

    public void adicionarBotaoDuplo () {
    	this.bMasculino.setBounds(120, 90, 100, 25);
        this.bMasculino.setBackground(null);
        this.getPainel().add(this.bMasculino);

        this.bfeminino.setBounds(220, 90, 99, 25);
        this.bfeminino.setBackground(null);
        this.getPainel().add(this.bfeminino);

        ButtonGroup group = new ButtonGroup();
        group.add(this.bMasculino);
        group.add(this.bfeminino);

        
    }
    public void adicionarCaixaDeTexto() throws ParseException {
        Font font = new Font("Arial",Font.BOLD,12);
        Color color = new Color(0,139,139);    
        
    	this.nomeDeUsuario = new JTextField();
        this.nomeDeUsuario.setBounds(120, 53, 200, 25);
        this.nomeDeUsuario.setForeground(color);
        this.nomeDeUsuario.setBorder(null);
        this.nomeDeUsuario.setBackground(Color.WHITE);
        this.nomeDeUsuario.setFont(font);
        this.getPainel().add(nomeDeUsuario);
        
        this.email = new JTextField();
        this.email.setBounds(120, 203, 200, 25);
        this.email.setForeground(color);
        this.email.setBorder(null);
        this.email.setFont(font);
        this.email.setBackground(Color.WHITE);

        this.getPainel().add(email);

        this.senha = new JTextField();
        this.senha.setBounds(120, 253, 200, 25);
        this.senha.setForeground(color);
        this.senha.setBorder(null);
        this.senha.setFont(font);
        this.senha.setBackground(Color.WHITE);

        this.getPainel().add(senha);

        MaskFormatter mascaraDeData = new MaskFormatter("##/##/####");
        this.dataDeNascimento = new JFormattedTextField(mascaraDeData);
        this.dataDeNascimento.setBounds(170, 153, 150, 25 );
        this.dataDeNascimento.setForeground(color);
        this.dataDeNascimento.setHorizontalAlignment(JLabel.CENTER);
        this.dataDeNascimento.setBorder(null);
        this.dataDeNascimento.setFont(font);
        this.dataDeNascimento.setBackground(Color.WHITE);
        this.getPainel().add(dataDeNascimento);
    }

    public void adicionarBotoes(){
        JButton enviar = new JButton("Enviar");
        JButton voltar = new JButton("Voltar");
        OuvinteBotoesCadastro ouvinte = new OuvinteBotoesCadastro(this);

        Font font = new Font("Arial",Font.BOLD,12);

        enviar.setBounds(190, 340, 135, 30);
        enviar.setFont(font);
        enviar.addActionListener(ouvinte);
        enviar.setBackground( new Color(0,139,139));
        enviar.setForeground(new Color(0,255,255));
        enviar.setForeground(Color.BLACK);
        
        voltar.setBounds(25,340,135,30);
        voltar.setFont(font);
        voltar.setBackground( new Color(0,139,139));
        voltar.setForeground(new Color(0,255,255));
        voltar.addActionListener(ouvinte);
        voltar.setForeground(Color.BLACK);

        this.getPainel().add(voltar);
        this.getPainel().add(enviar);
    }



    public String getNome() {
        return nomeDeUsuario.getText();
    }

    public String getEmail() {
        return email.getText();
    }

    public String getSenha() {
        return senha.getText();
    }

    public String getData(){
        return dataDeNascimento.getText();
    }

    public JRadioButton getBotaoMasculino(){
        return this.bMasculino;
    }
    public JRadioButton getBotaoFeminino(){
        return this.bfeminino;
    }

}
