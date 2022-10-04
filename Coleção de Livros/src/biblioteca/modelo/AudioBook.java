package biblioteca.modelo;

public class AudioBook extends Livro{
	
	private int duracao;
	private String formato;
	
	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}
	public void setFormato(String formato) {
		this.formato = formato;
	}
	
	public int getDuracao() {
		return duracao;
	}
	public String getFormato() {
		return formato;
	}
}
