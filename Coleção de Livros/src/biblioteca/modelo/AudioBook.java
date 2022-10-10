package biblioteca.modelo;

public class AudioBook extends Livro {
	
	private float duracao;
	private String formato;
	
	public void setDuracao(float duracao) {
		this.duracao = duracao;
	}
	public void setFormato(String formato) {
		this.formato = formato;
	}
	
	public float getDuracao() {
		return duracao;
	}
	public String getFormato() {
		return formato;
	}
}
