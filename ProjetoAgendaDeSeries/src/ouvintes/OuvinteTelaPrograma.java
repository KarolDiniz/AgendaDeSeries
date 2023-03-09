package ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import telas.EstruturaTelas;
import telas.TelaDeHome;
import telas.TelaDePrograma;
import utilitarios.CentralDeInformacoes;
import utilitarios.Persistencia;

public class OuvinteTelaPrograma  implements ActionListener{
	private TelaDePrograma telaDePrograma;
    private CentralDeInformacoes central = Persistencia.getPersistencia().recuperar();
    
    public OuvinteTelaPrograma(TelaDePrograma telaDePrograma){
        this.telaDePrograma = telaDePrograma;
    }
    
    
	public void actionPerformed(ActionEvent e) {
		
		options(e.getActionCommand());
		System.out.println(telaDePrograma.pegarIconePrograma().getActionCommand());
		
	}
	
	private String[] listIconesSerie = {"src/imagens/youtube.png","src/imagens/Camera.png","src/imagens/Cinema.png","src/imagens/Misto.png","src/imagens/Pipocas.png"};
	public void options(String op) {
			System.out.println(op);
			
			switch(op) {
			case "Icon 1":
				JPanel painelIcone = EstruturaTelas.painelIcone;
				painelIcone.removeAll();
				ImageIcon icone =  new ImageIcon(listIconesSerie[0]);
				JButton localIcone = new JButton(icone);
				localIcone.setBounds(0,0,125,125);
			    painelIcone.add(localIcone);
			    painelIcone.repaint();
			    painelIcone.setVisible(true);
				break;
			case "Icon 2":
				JPanel painelIcone1 = EstruturaTelas.painelIcone;
				painelIcone1.removeAll();
				ImageIcon icone1 =  new ImageIcon(listIconesSerie[1]);
				JButton localIcone1 = new JButton(icone1);
				localIcone1.setBounds(0,0,125,125);
			    painelIcone1.add(localIcone1);
			    painelIcone1.repaint();
			    painelIcone1.setVisible(true);
				
				System.out.println("Mude para icon 2");
				break;
			case "Icon 3":
				JPanel painelIcone2 = EstruturaTelas.painelIcone;
				painelIcone2.removeAll();
				ImageIcon icone2 =  new ImageIcon(listIconesSerie[2]);
				JButton localIcone2 = new JButton(icone2);
				localIcone2.setBounds(0,0,125,125);
			    painelIcone2.add(localIcone2);
			    painelIcone2.repaint();
			    painelIcone2.setVisible(true);
				System.out.println("Mude para icon 3");
				break;
			case "Icon 4":
				JPanel painelIcone3 = EstruturaTelas.painelIcone;
				painelIcone3.removeAll();
				ImageIcon icone3 =  new ImageIcon(listIconesSerie[3]);
				JButton localIcone3 = new JButton(icone3);
				localIcone3.setBounds(0,0,125,125);
			    painelIcone3.add(localIcone3);
			    painelIcone3.repaint();
			    painelIcone3.setVisible(true);
				System.out.println("Mude para icon 4");
				break;
			case "Icon 5":
				JPanel painelIcone4 = EstruturaTelas.painelIcone;
				painelIcone4.removeAll();
				ImageIcon icone4 =  new ImageIcon(listIconesSerie[4]);
				JButton localIcone4 = new JButton(icone4);
				localIcone4.setBounds(0,0,125,125);
			    painelIcone4.add(localIcone4);
			    painelIcone4.repaint();
			    painelIcone4.setVisible(true);
				System.out.println("Mude para icon 5");
				break;
				
			case "Voltar":
				 telaDePrograma.dispose();
		        new TelaDeHome(telaDePrograma.getUser()); 
				break;
			}
			
			telaDePrograma.setIconePrograma(telaDePrograma.pegarIconePrograma());
			
			
	}
	
}