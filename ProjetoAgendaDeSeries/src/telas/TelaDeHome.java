package telas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.Border;

import classes.Usuario;
import ouvintes.OuvinteBotoesHome;
import ouvintes.OuvinteBotoesHome;

public class TelaDeHome extends EstruturaTelas{

    private String nome;
    private Usuario user;

    public Usuario getUser() {
        return user;
    }

    public TelaDeHome(Usuario user) {
        super("Home");
        super.adicionarPainel(330, 20, 300, 350, 110);
        
        this.nome = user.getNome();
        this.user = user;
        
        this.adicionarTextos();
        this.adicionarBotoes();
        this.addBackground("/imagens/CadastroBackground.jpeg");
        this.setVisible(true);
        this.setLayout(null);

    }


	public void adicionarTextos() {
    	
        Font font = new Font("Arial",Font.BOLD,20);

        JLabel bemvindo = new JLabel("Bem vindo(a),");
        bemvindo.setBounds(50, 53, 300, 60);
        bemvindo.setFont(font);
        bemvindo.setForeground(Color.WHITE);
        //bemvindo.setBorder(BorderFactory.createLineBorder(Color.black)); borda
        this.add(bemvindo);

        JLabel nome = new JLabel(this.nome);
        nome.setBounds(50, 100, 300, 20);
        nome.setFont(font);
        nome.setForeground(Color.WHITE);
        this.add(nome);
        
        JLabel subtitulo = new JLabel("<html>Cadastre canais e programas que serão <br>transmitidos através deles!<br> Atribua nomes, temporadas, gêneros <br>e muito mais! edite e liste sempre que quiser!");
		subtitulo.setBounds(30,140,400,100);
		subtitulo.setFont(new Font("Arial", Font.BOLD, 12));
		subtitulo.setForeground(Color.WHITE); //cor da fonte
		this.add(subtitulo);
        
        
        JLabel menu = new JLabel("Menu de opções:", JLabel.CENTER);
        menu.setBounds(0, 55, 300, 20);
        menu.setFont(font);
        menu.setForeground(Color.WHITE);
        this.getPainel().add(menu);
        

    }
    		
    
    public void adicionarBotoes() {
        OuvinteBotoesHome ouvinte = new OuvinteBotoesHome(this);
        Color cor = new Color(0,139,139);
        Font font = new Font("Arial",Font.BOLD,13);
        
        JButton jbCanais = new JButton("Canais");
        jbCanais.setBounds(75, 110, 150, 25);
        jbCanais.setFont(font);
        jbCanais.setForeground(new Color(0,255,255));
        jbCanais.addActionListener(ouvinte);
        this.getPainel().add(jbCanais);
        
        JButton jbProgramas = new JButton("Programas");
        jbProgramas.setBounds(75, 150, 150, 25);
        jbProgramas.setFont(font);
        jbProgramas.setForeground(new Color(0,255,255));
        jbProgramas.addActionListener(ouvinte);
        this.getPainel().add(jbProgramas);
        
        JButton jbFavoritos = new JButton("Favoritos");
        jbFavoritos.setBounds(75, 190, 150, 25);
        jbFavoritos.setFont(font);
        jbFavoritos.addActionListener(ouvinte);
        this.getPainel().add(jbFavoritos);
        

        JButton jbSair = new JButton("Sair");
        jbSair.setBounds(75, 230, 150, 25);
        jbSair.setFont(font);
        jbSair.setForeground(new Color(229, 33, 33));
        jbSair.addActionListener(ouvinte);
        this.getPainel().add(jbSair);
        
        JButton jbApagarConta = new JButton("Deletar perfil");
        jbApagarConta.setBounds(75, 265, 150, 25);
        jbApagarConta.setFont(font);
        jbApagarConta.setForeground(new Color(229, 33, 33));
        jbApagarConta.addActionListener(ouvinte);
        this.getPainel().add(jbApagarConta);

    }



}
