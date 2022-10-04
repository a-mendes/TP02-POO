package ao.co.a2x.biblioteca.modelo;
import java.util.Vector;
import ao.co.a2x.biblioteca.modelo.Livro;

public class Eletronico extends Livro {

	private String URL;
	private String formato;
	
	public void setURL(String uRL) {
		URL = uRL;
	}
	public void setFormato(String formato) {
		this.formato = formato;
	}
	
	public String getURL() {
		return URL;
	}
	public String getFormato() {
		return formato;
	}
	
	
}
