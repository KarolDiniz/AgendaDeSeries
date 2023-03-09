package telas;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public abstract class EstruturaTelas extends JFrame {
	
	private JPanel painel;
	private static final long serialVersionUID = 1L;

	public EstruturaTelas(String titulo) {
		Container div = this.getContentPane();
		div.setBackground(new Color(179, 179, 179));
		addLookAndFeel();
		this.setLayout(null);
		this.setSize(700, 450);
		this.setTitle("Agenda de Séries - " + titulo);
		this.setResizable(true);
		this.setMinimumSize(new Dimension(650, 359));
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //TODO
		
		
	}
	
	public void addLookAndFeel() {
		try {
			
			String tema = "com.jtattoo.plaf.mint.MintLookAndFeel";

			UIManager.setLookAndFeel(tema);
		} catch (InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException
				| ClassNotFoundException e) {
			System.out.println("Erro LAF : " + e.getMessage());
		}
	}
	
	private static class BackgroundTela extends JPanel {
		private ImageIcon img;

		public BackgroundTela(String imagem){
			img = new ImageIcon(EstruturaTelas.class.getResource(imagem));
		}

		@Override
		public void paintComponent(Graphics g){
			super.paintComponent(g);

			g.drawImage(img.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);

		}

	}
	public void addBackground(String imagem){

		JPanel painel = new BackgroundTela(imagem);
		int width = this.getWidth();
		int height = this.getHeight();

		painel.setBounds(0,0,width,height);
		this.add(painel);
	}
	
	 public void adicionarPainel(int x, int y, int w, int h, int t) {
	        painel = new JPanel(); 
	        painel.setLayout(null);
	        painel.setBounds(x, y, w, h);
	        painel.setBackground(new java.awt.Color(240,248,255, t)); //COR E TRANSPARENCIA
	        painel.setOpaque(true);
	        add(painel);
	 }
	 
	 //---add
	 public static JPanel painelIcone = new JPanel(); 
	 public JPanel adicionarPainelParaAddComponentes(int x, int y, int w, int h, int t) {
		// painelIcone.removeAll();
		// painelIcone = new JPanel(); 
		 painelIcone.setLayout(null);
		 painelIcone.setBounds(x, y, w, h);
		 painelIcone.setBackground(new java.awt.Color(0,0,0, t)); //COR E TRANSPARENCIA
		 painelIcone.setOpaque(true);
	       
	        add(painelIcone);
	        return painelIcone;
	 }
	 //-----
	 
	 public static JRadioButton adicionarRadioButton(JFrame tela, String nome, int x, int y, int comprimento, int altura) {
			JRadioButton radioBotao = new JRadioButton(nome);
			radioBotao.setBounds(x, y, comprimento, altura);
			tela.add(radioBotao);
			return radioBotao;
		}
	
	 public static JCheckBox adicionarCheckBox(JFrame tela, String nome, int x, int y, int comprimento, int altura) {
			JCheckBox checkBox = new JCheckBox(nome);
			checkBox.setBounds(x,y,comprimento,altura);
			tela.add(checkBox);
			return checkBox;
		}
	 public JTextField adicionarJTextField(JFrame tela, String nome, int x, int y, int comprimento, int altura){
		 	JTextField jt = new JTextField(nome);
			jt.setBounds(x,y,comprimento,altura);
			tela.add(jt);
			return jt;
	 }
	 
	 public void adicionarIcone(int x, int y, int a, int c) {
			ImageIcon iconeAgenda = new ImageIcon("src/imagens/IconePrincipal.png");
			JLabel icone = new JLabel(iconeAgenda);
			icone.setBounds(x,y,c,a);
			add(icone);
		}
	 
	    public JPanel getPainel() {
	        return painel;
	    }

	    public void setPainel(JPanel painel) {
	        this.painel = painel;
	    }
}

