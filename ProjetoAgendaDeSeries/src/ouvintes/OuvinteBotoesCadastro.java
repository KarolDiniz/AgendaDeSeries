package ouvintes;

import telas.TelaDeCadastro;
import telas.TelaDeLogin;
import utilitarios.CentralDeInformacoes;
import utilitarios.Persistencia;
import classes.Usuario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class OuvinteBotoesCadastro implements ActionListener {
    private static final Persistencia persistencia = Persistencia.getPersistencia();
    private static final CentralDeInformacoes central = persistencia.recuperar();
    private final TelaDeCadastro telaDeCadastro;
    
    @Override //eventos
    public void actionPerformed(ActionEvent clique) {
        JButton botao = (JButton) clique.getSource();
        try {
            if(botao.getText().equals("Enviar")){ //TODO 
                this.cadastroDeClientes();
            }else{
                this.fechaJanela();
            }
        } catch (Exception ex) {
        	ex.printStackTrace();
        	System.out.println("Estou aqui dentro");
        }
    }
    
    public OuvinteBotoesCadastro(TelaDeCadastro telaDeCadastro){
        this.telaDeCadastro = telaDeCadastro;
    }
    
    private void fechaJanela(){
        telaDeCadastro.dispose();
        new TelaDeLogin();
    }
    
    public String[] verificaEmailValido(){ //TODO 
        String[] info = { telaDeCadastro.getNome(),telaDeCadastro.getEmail(),
        telaDeCadastro.getSenha(),"",telaDeCadastro.getData()};
                
        JRadioButton masculino = telaDeCadastro.getBotaoMasculino();
        JRadioButton feminino = telaDeCadastro.getBotaoFeminino();
        
        if(masculino.isSelected()){ info[3]="Masculino";
        }else if(feminino.isSelected()){ info[3]="Feminino";}
       
        info[4] = info[0].equals("") || info[1].equals("")||info[2].equals("")  
        || info[3].equals("")||info[4].equals("")?"1":telaDeCadastro.getData();  
                     
        return info;
    }

    public void dataIsValida() throws Exception { 
        String data =  telaDeCadastro.getData();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        formato.setLenient(false);
            Date hoje = new Date();
            Date dataObject = formato.parse(data);
            if(dataObject.after(hoje)){
                throw new Exception("Informe uma data válida");
            }
    }

    public String[] permitirCadastroSe() throws Exception {
        String[] info = this.verificaEmailValido();
        if(!info[4].equals("1")){
            if(info[1].contains("@")) {
                ArrayList<Usuario> usuarios = central.getUsuario();
                for (Usuario user : usuarios) {
                    if (user.getEmail().equals(info[1])) {
                        throw new Exception("Este email já está cadastrado."
                        		+ "\nTente novamente!!");
                    }
                }
                return info;
            }
            throw new Exception("Email inválido. \n Tente novamente!");
        }else{
            throw new Exception("Há campos vazios. \n Preencha todos os campos!");
        }
    }

    public void cadastroDeClientes() throws Exception {
        String[] info = this.permitirCadastroSe();
        info[2] = (info[2]);

        this.dataIsValida();
        Usuario user = new Usuario(info[0], info[1], info[2],info[3],info[4]);
        central.addUser(user);
        central.salvar();
        this.showMessageDialog("Cadastro realizado com sucesso!");
        this.fechaJanela();
    }
    

    public void showMessageDialog(String msg){
        JOptionPane.showMessageDialog(telaDeCadastro, msg);

    }



}
