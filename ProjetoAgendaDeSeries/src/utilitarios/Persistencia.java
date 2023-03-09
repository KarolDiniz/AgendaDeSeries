package utilitarios;

import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class Persistencia{
	
	private XStream xStream = new XStream(new DomDriver("UTF-8"));
	private static Persistencia persistencia;

	private Persistencia(){ }

	public void salvar(CentralDeInformacoes central) throws Exception {
		File arquivo = new File("DataBase.xml");
		String xml="";
		
		arquivo.createNewFile();
		xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n";

		PrintWriter pw = new PrintWriter(arquivo);
		this.exibir();
		xml += xStream.toXML(central);
		pw.write(xml);
		pw.close();
	}
	
	public CentralDeInformacoes recuperar() {
		try{
			File arquivo = new File("DataBase.xml");
			this.exibir();
			if(arquivo.exists()) {
				FileReader fr = new FileReader(arquivo);
				return (CentralDeInformacoes) xStream.fromXML(fr);
			}
		}catch(Exception ignored){
		}
		return new CentralDeInformacoes();
	}
	
	public static Persistencia getPersistencia(){
		if(persistencia == null){  persistencia = new Persistencia();  }
		return persistencia;
	}
	
	public void exibir(){
		xStream.alias("CentralDeInformacoes", CentralDeInformacoes.class);
		xStream.alias("login", LoginConfig.class);

	}

}
