package telas;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.time.DayOfWeek;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

import classes.Usuario;
import ouvintes.OuvinteTelaPrograma;

public class TelaDePrograma extends EstruturaTelas {

	private static final long serialVersionUID = 1L;
	private JRadioButton seriesRegulares;
	private JRadioButton realityShows;
	private JRadioButton programaContinuo;
	private DayOfWeek[] dia;
	private Usuario user;
	private String nomePrograma;
	private ArrayList<String> listaDeProgramas = new ArrayList<>();
	private ArrayList<JCheckBox> diaDaSemana = new ArrayList<JCheckBox>();
	private JRadioButton favoritos;
	private JButton iconePrograma = new JButton("Button");
	private JComboBox<String> estiloPrograma;
	private String[] estilos = {"Live Action", "Animada"};
	OuvinteTelaPrograma ouvinteProgramas = new OuvinteTelaPrograma(this);
	
	public Usuario getUser() {
		return user;
	}

	public TelaDePrograma(Usuario user) {
		super("Cadastro De Programas");
		super.adicionarPainel(95, 20, 500, 350, 30);
		this.user = user;
		
		JPanel painelIcone = adicionarPainelParaAddComponentes(250-62, 350-125, 125, 125, 200);
		iconePrograma = new JButton(new ImageIcon("src/imagens/Pipocas.png"));
		iconePrograma.setBounds(0,0,125,125);
	    painelIcone.add(iconePrograma);
	    
	    this.add(painelIcone);
		this.adicionarTextos();
		this.addBarraMenuTopo();
		this.adicionarJCB();
		this.adicionarRadios();
		this.adicionarCheckBox(180);
		this.adicionarIcone();
		this.addBackground("/imagens/CadastroBackground.jpeg");
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLayout(null);
		this.setResizable(false);
		setVisible(true);
	}
	public JButton pegarIconePrograma() {
			return iconePrograma;
	}
	public void setIconePrograma(JButton iconePrograma) {
		this.iconePrograma = iconePrograma;
	}
	public void adicionarJCB() {
		estiloPrograma = new JComboBox<String>(estilos);
		estiloPrograma.setBounds(280, 350-145, 150, 30);
		this.getPainel().add(estiloPrograma);
	}
	public JComboBox<String> getEstiloPrograma() {
		return estiloPrograma;
	}
	public JButton getIconePrograma() {
		return iconePrograma;
	}
	
	public JButton adicionarIcone() {
		JButton b = new JButton("Icone");		
		b.setContentAreaFilled(false);
		b.setHorizontalTextPosition(SwingConstants.CENTER);
		b.setVerticalTextPosition(SwingConstants.BOTTOM);
		b.setFont(new Font("Arial", Font.BOLD, 16));
		b.setOpaque(false);
		b.setForeground(Color.WHITE);
		return b;
	}
	
	private void adicionarCheckBox(int x) {

		diaDaSemana.add(EstruturaTelas.adicionarCheckBox(this,"Segunda-Feira", 170, 300-x, 120, 30));
		diaDaSemana.add(EstruturaTelas.adicionarCheckBox(this, "Terca-Feira", 290, 300-x, 120, 30));
		diaDaSemana.add(EstruturaTelas.adicionarCheckBox(this, "Quarta-Feira", 410, 300-x, 120, 30));
		diaDaSemana.add(EstruturaTelas.adicionarCheckBox(this, "Quinta-Feira", 170, 330-x, 120, 30));
		diaDaSemana.add(EstruturaTelas.adicionarCheckBox(this, "Sexta-Feira", 290, 330-x, 120,30));
		diaDaSemana.add(EstruturaTelas.adicionarCheckBox(this, "Sábado", 410, 330-x, 120, 30));
		diaDaSemana.add(EstruturaTelas.adicionarCheckBox(this, "Domingo", 170, 360-x, 360, 30));
		
		diaDaSemana.get(0).addActionListener(ouvinteProgramas);
		diaDaSemana.get(1).addActionListener(ouvinteProgramas);
		diaDaSemana.get(2).addActionListener(ouvinteProgramas);
		diaDaSemana.get(3).addActionListener(ouvinteProgramas);
		diaDaSemana.get(4).addActionListener(ouvinteProgramas);
		diaDaSemana.get(5).addActionListener(ouvinteProgramas);
		diaDaSemana.get(6).addActionListener(ouvinteProgramas);
		
	}
	private void adicionarRadios() { 
		seriesRegulares = EstruturaTelas.adicionarRadioButton(this, "Series Regulares", 105, 70, 125, 30);
		seriesRegulares.setSelected(true);
		realityShows = EstruturaTelas.adicionarRadioButton(this, "Reality Show", 235, 70, 100, 30);
		programaContinuo = EstruturaTelas.adicionarRadioButton(this, "Programa Continuo", 340, 70, 145, 30);
		favoritos = EstruturaTelas.adicionarRadioButton(this, "Favoritado", 490, 70, 90, 30);

		ButtonGroup group = new ButtonGroup();
		group.add(seriesRegulares);
		group.add(realityShows);
		group.add(programaContinuo);
	}
	 public void adicionarTextos() {
			JLabel titulo = new JLabel("Cadastro de Programas",JLabel.CENTER);
			titulo.setBounds(26, 0, 500, 50); 
			titulo.setFont(new Font("Arial", Font.BOLD, 18));
			titulo.setForeground(Color.WHITE);
			this.getPainel().add(titulo);
	    }
	 public void addBarraMenuTopo() {
		 
			JMenuBar barraDeMenu = new JMenuBar();
			setJMenuBar(barraDeMenu);
			
			JMenu novoMenu = new JMenu("Novo");
			barraDeMenu.add(novoMenu);
			barraMenuAddItem(novoMenu, "Nova Serie","NovaSerie");
			barraMenuAddItem(novoMenu, "Remover Série","RemoverS");
			
			JMenu novoMenu0 = new JMenu("Voltar");
			barraDeMenu.add(novoMenu0);
			barraMenuAddItem(novoMenu0, "Pagina inicial","Voltar");
			
			JMenu novoMenu1 = new JMenu("Extras");
			barraDeMenu.add(novoMenu1);
			
			barraMenuAddItem(novoMenu1,"Favoritos", null);
			barraMenuAddItem(novoMenu1, "Tudo", null);
		
			JMenu mudarIcon = new JMenu("Mudar icon");
			barraDeMenu.add(mudarIcon);
			barraMenuAddItem(mudarIcon, "Icon 1", null);
			barraMenuAddItem(mudarIcon, "Icon 2", null);
			barraMenuAddItem(mudarIcon, "Icon 3", null);
			barraMenuAddItem(mudarIcon, "Icon 4", null);
			barraMenuAddItem(mudarIcon, "Icon 5", null);
			
		}
	 	public void barraMenuAddItem(JMenu addmenu, String nomeItem, String setActionC) {
	 		 
			JMenuItem icon = new JMenuItem(nomeItem);
			addmenu.add(icon);
			
			if(setActionC != null) {
				icon.setActionCommand(setActionC);
			}
			icon.addActionListener(ouvinteProgramas);
		}
	 
		public JRadioButton getSeriesRegulares() {
			return seriesRegulares;
		}

		public void setSeriesRegulares(JRadioButton seriesRegulares) {
			this.seriesRegulares = seriesRegulares;
		}

		public JRadioButton getRealityShows() {
			return realityShows;
		}

		public void setRealityShows(JRadioButton realityShows) {
			this.realityShows = realityShows;
		}

		public JRadioButton getProgramaContinuo() {
			return programaContinuo;
		}

		public void setProgramaContinuo(JRadioButton programaContinuo) {
			this.programaContinuo = programaContinuo;
		}

		public JRadioButton getFavoritos() {
			return favoritos;
		}

		public void setFavoritos(JRadioButton favoritos) {
			this.favoritos = favoritos;
		}

		
		public OuvinteTelaPrograma getOuvinteProgramas() {
			return ouvinteProgramas;
		}

		public void setOuvinteProgramas(OuvinteTelaPrograma ouvinteProgramas) {
			this.ouvinteProgramas = ouvinteProgramas;
		}

		public void setUser(Usuario user) {
			this.user = user;
		}
	 
}