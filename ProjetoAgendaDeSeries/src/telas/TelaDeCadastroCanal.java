package telas;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import classes.Canal;
import classes.Usuario;
import enums.TipoDeCanal;
import ouvintes.OuvinteBotoesCadastroCanal;

public class TelaDeCadastroCanal extends EstruturaTelas{

	private JTextField nomeDoCanal;
	private Canal canal;
	private JComboBox<String> jcb;
    private Usuario user;
    private TipoDeCanal tipo;
    
    private String[] tipos = {"CANAL ABERTO DE TELEVISAO", "BROADCASTING ABERTO NA INTERNET",
    		"PACOTE DE ASSINATURA", "ASSINATURA INDIVIDUAL DE TELEVISAO", 
    "ASSINATURA INDIVIDUAL DE BROADCASTING"};
    
    public Canal getCanal(){
    	return canal;
    }
    public Usuario getUser() {
        return user;
    }
	
	public TelaDeCadastroCanal(Usuario user) {
		super("CADASTRO DE CANAL");
	
		this.user = user;
		super.adicionarPainel(150, 15, 400, 380, 100);
		
		this.adicionarTitulo();
		this.adicionarCaixaDeTexto();
		this.adicionarJCB();
		this.adicionarBotoes();

		this.addBackground("/imagens/LoginBackground.jpeg");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLayout(null);
		this.setResizable(false);
		setVisible(true);
		
	}	
	
	public void salvarCanal () {
		
		if(jcb.getSelectedItem().equals("CANAL ABERTO DE TELEVISAO")) {
			
			tipo = TipoDeCanal.CANAL_ABERTO_DE_TELEVISAO;
			
		}else if(jcb.getSelectedItem().equals("BROADCASTING ABERTO NA INTERNET")) {
			
			tipo = TipoDeCanal.BROADCASTING_ABERTO_NA_INTERNET;
			
		}else if(jcb.getSelectedItem().equals("PACOTE DE ASSINATURA")) {
			
			tipo = TipoDeCanal.PACOTE_DE_ASSINATURA;
			
		}else if(jcb.getSelectedItem().equals("ASSINATURA INDIVIDUAL DE TELEVISAO")) {
			
			tipo = TipoDeCanal.ASSINATURA_INDIVIDUAL_DE_TELEVISAO;
			
		}else if(jcb.getSelectedItem().equals( "ASSINATURA INDIVIDUAL DE BROADCASTING")) {
			
			tipo = TipoDeCanal.ASSINATURA_INDIVIDUAL_DE_BROADCASTING;
			
		}
			
		String link = JOptionPane.showInputDialog(this, "QUAL É O NÚMERO OU LINK DESTE CANAL? ");
				
		this.canal = new Canal(nomeDoCanal.getText(), tipo, link);
	}
	
	
	public void adicionarTitulo() {
		JLabel titulo = new JLabel("CADASTRE UM CANAL",JLabel.CENTER);
		titulo.setBounds(70, 50, 250, 20); 
		titulo.setFont(new Font("Arial", Font.BOLD, 18));
		titulo.setForeground(Color.WHITE); 
		this.getPainel().add(titulo);		 		           
        
		JLabel nomeDoCanal = new JLabel("Nome: ");
		nomeDoCanal.setBounds(30, 130, 120, 20); 
		nomeDoCanal.setFont(new Font("Arial", Font.BOLD,12));
		nomeDoCanal.setForeground(Color.WHITE); 
		this.getPainel().add(nomeDoCanal);
		
		JLabel tipoDoCanal = new JLabel("Tipo: ");
		tipoDoCanal.setBounds(30, 180, 120, 20);
		tipoDoCanal.setFont(new Font("Arial", Font.BOLD,12));
		tipoDoCanal.setForeground(Color.WHITE); 
		this.getPainel().add(tipoDoCanal);
		
	}
	
	public void adicionarCaixaDeTexto() {
		this.nomeDoCanal = new JTextField();
		nomeDoCanal.setBounds(100, 130, 250, 30);
		nomeDoCanal.setFont(new Font("Arial",Font.BOLD,12));
		nomeDoCanal.setBackground(Color.white);
		nomeDoCanal.setForeground(new Color(255, 0, 0));
		nomeDoCanal.setBorder(null);
		this.getPainel().add(nomeDoCanal);
	
	}
	public void adicionarJCB() {
		jcb = new JComboBox<String>(tipos);
		jcb.setBounds(100, 180, 250, 30);
		this.getPainel().add(jcb);

	}
	
    public void adicionarBotoes() {
    	OuvinteBotoesCadastroCanal ouvinte = new OuvinteBotoesCadastroCanal(this);
        Font font = new Font("Arial",Font.BOLD,13);
        
        JButton voltar = new JButton("Voltar");
        voltar.setBounds(50, 330, 130, 25);
        voltar.setFont(font);
        voltar.addActionListener(ouvinte);
        voltar.setBackground(Color.WHITE);
        this.getPainel().add(voltar);
        
        JButton salvar = new JButton("Salvar");
        salvar.setBounds(220, 330, 130, 25);
        salvar.setFont(font);
        salvar.addActionListener(ouvinte);
        salvar.setBackground(Color.WHITE);
        this.getPainel().add(salvar);

    }
	
}

