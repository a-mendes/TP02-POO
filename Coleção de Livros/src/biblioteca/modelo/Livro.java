package biblioteca.modelo;

import java.util.ArrayList;

public class Livro {

	private ArrayList <String> escritores;
	private ArrayList <String> keyWords;
	private ArrayList <String> capitulos;
	private String titulo;
	private String idioma;
	private String palavraChave;
	private int anoDePublicacao;
	 
	/**
	 * Sets
	 */
	
	public void setEscritores(ArrayList<String> escritores) {
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
	
	/**
	 * Gets
	 */
	
	public int getAnoDePublicacao() {
		return anoDePublicacao;
	}

	public ArrayList<String> getEscritores() {
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

	public ArrayList<String> getKeyWords() {
		return keyWords;
	}

	public void setKeyWords(ArrayList<String> keyWords) {
		this.keyWords = keyWords;
	}

	public ArrayList<String> getCapitulos() {
		return capitulos;
	}

	public void setCapitulos(ArrayList<String> capitulos) {
		this.capitulos = capitulos;
	}
	
}
	