package telas;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Font;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import ouvintes.OuvinteBotoesLogin;

public class TelaDeLogin extends EstruturaTelas {

	URL som = EstruturaTelas.class.getResource("/imagens/Cigarettes.wav");
	private AudioClip trilha = Applet.newAudioClip(som);
	
    private JTextField email;
    private JPasswordField senha;
	
	public TelaDeLogin() {
		super("Login");
		super.adicionarPainel(350, 30, 300, 350, 100);
		super.adicionarIcone(50, 5, 250, 250);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		this.adicionarCaixaDeTexto();
		this.AdicionarBotao();
		this.adicionarTitulo();
		this.addBackground("/imagens/LoginBackground.jpeg");
		
		setVisible(true);
	}
	
	public void AdicionarBotao() {
		OuvinteBotoesLogin ouvinte = new OuvinteBotoesLogin(this);
		Font font = new Font("Arial",Font.BOLD,12);
		
		JButton entrar = new JButton("Entrar");
        entrar.setBounds(32, 253, 250, 30);
        entrar.setForeground(new Color(0,255,255));
        entrar.addActionListener(ouvinte);
        this.getPainel().add(entrar);

        JButton cadastre = new JButton("Criar nova conta");  
        cadastre.setBounds(90, 280, 190, 30);
        cadastre.setForeground(new Color(0,255,255));
        cadastre.setFont(font);
        cadastre.addActionListener(ouvinte);
        this.add(cadastre);
	}
	
	public void adicionarTitulo() {
		Font font = new Font("Arial",Font.BOLD,12);
		JLabel titulo = new JLabel("Entrar no AgendaON",JLabel.CENTER);
		titulo.setBounds(0, 50, 300, 20); //x (largura, encima),y,c,a
		titulo.setFont(new Font("Arial", Font.BOLD, 17));
		titulo.setForeground(Color.WHITE); //cor da fonte
		this.getPainel().add(titulo);
		
		JLabel subtitulo = new JLabel("<html>Ainda não possui uma conta? <br> realize seu cadastro agora mesmo!");
		subtitulo.setBounds(50,180,400,100);
		subtitulo.setFont(new Font("Arial", Font.BOLD, 12));
		subtitulo.setForeground(Color.WHITE); //cor da fonte
		this.add(subtitulo);
		
        JLabel email = new JLabel("E-mail:",JLabel.RIGHT);
        email.setBounds(0, 145, 80, 20);
        email.setFont(font);
        email.setForeground(Color.WHITE);
        email.setBorder(null);
        this.getPainel().add(email);
        
        JLabel senha = new JLabel("Senha:",JLabel.RIGHT);
        senha.setBounds(0, 185, 80, 20);
        senha.setFont(font);
        senha.setForeground(Color.WHITE);
        senha.setBorder(null);
        this.getPainel().add(senha);
	}
		
	public void adicionarCaixaDeTexto() {
        this.email = new JTextField();
        email.setBounds(90, 142, 170, 25);
        email.setFont(new Font("Arial",Font.BOLD,12));
        email.setBackground(Color.white);
        email.setForeground(new Color(0,139,139));
        email.setBorder(null);
        this.getPainel().add(email);
        
        this.senha = new JPasswordField();
        senha.setBounds(90, 182, 170, 25);
        senha.setFont(new Font("Arial",Font.BOLD,12));
        senha.setForeground(new Color(0,139,139));
        senha.setBorder(null);
        senha.setBackground(Color.white);
        this.getPainel().add(senha);

	}
    public String getEmail() {
        return email.getText();
    }

    @SuppressWarnings("deprecation") //TODO 
	public String getSenha() {
        return senha.getText();
    }
  
    public void setEmail(JTextField email) {
        this.email = email;
    }

    public void setSenha(JPasswordField senha) {
        this.senha = senha;
    }

	public AudioClip getTrilha() {
		return trilha;
	}

	public void setTrilha(AudioClip trilha) {
		this.trilha = trilha;
	}
}
