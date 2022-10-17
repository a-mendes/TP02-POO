package biblioteca.modelo;

import java.util.ArrayList;
import biblioteca.modelo.Impresso;
import biblioteca.modelo.Eletronico;
import biblioteca.modelo.AudioBook;

public class Livro {

	private ArrayList <String> escritores;
	private ArrayList <String> keyWords;
	private ArrayList <String> capitulos;
	private String titulo;
	private String idioma;
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

	public void setAnoDePublicacao(int anoDePublicacao) {
		this.anoDePublicacao = anoDePublicacao;
	}
	
	public void setCapitulos(ArrayList<String> capitulos) {
		this.capitulos = capitulos;
	}

	public void setKeyWords(ArrayList<String> keyWords) {
		this.keyWords = keyWords;
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

	public ArrayList<String> getKeyWords() {
		return keyWords;
	}

	public ArrayList<String> getCapitulos() {
		return capitulos;
	}
	
	@Override
    public boolean equals(Object obj) {
		if (!(obj instanceof Livro))
            return false;
        if (obj == this)
            return true;

        Livro livro = (Livro) obj;
  
        return (titulo == livro.titulo) &&
        	   (idioma == livro.idioma) &&
        	   (anoDePublicacao == livro.anoDePublicacao) &&
        	   (escritores.equals(livro.escritores)) &&
        	   (keyWords.equals(livro.keyWords)) &&
        	   (capitulos.equals(livro.capitulos));
       		
	}

	@Override
    public int hashCode() {
        int result = 17;

        result = 31 * result + titulo.hashCode();
        result = 31 * result + idioma.hashCode();
        result = 31 * result + Integer.valueOf(anoDePublicacao).hashCode();
        result = 31 * result + escritores.hashCode();
        result = 31 * result + keyWords.hashCode();
        result = 31 * result + capitulos.hashCode();
        
        return result;
    }
	
}
	