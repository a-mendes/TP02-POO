package biblioteca.modelo;

public class Eletronico extends Livro {

	private String URL;
	private String formato;
	
	public void setURL(String url) {
		URL = url;
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
