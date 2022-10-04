package ao.co.a2x.biblioteca.modelo;
import java.util.Vector;

public class Livro {

	private Vector<String> escritores;
	private Vector<String> keyWords;
	private Vector<String> capitulos;
	private String titulo;
	private String idioma;
	private String palavraChave;
	private int anoDePublicacao;
	
	
	 
//Sets
	
	public void setEscritores(Vector<String> escritores) {
		this.escritores = escritores;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public void setPalavraChave(String palavraChave) {
		this.palavraChave = palavraChave;
	}


	public void setAnoDePublicacao(int anoDePublicacao) {
		this.anoDePublicacao = anoDePublicacao;
	}
	
//Gets
	
	public int getAnoDePublicacao() {
		return anoDePublicacao;
	}

	public Vector<String> getEscritores() {
		return escritores;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getIdioma() {
		return idioma;
	}

	public String getPalavraChave() {
		return palavraChave;
	}

	public Vector<String> getKeyWords() {
		return keyWords;
	}

	public void setKeyWords(Vector<String> keyWords) {
		this.keyWords = keyWords;
	}

	public Vector<String> getCapitulos() {
		return capitulos;
	}

	public void setCapitulos(Vector<String> capitulos) {
		this.capitulos = capitulos;
	}




	 
	
	
}
	