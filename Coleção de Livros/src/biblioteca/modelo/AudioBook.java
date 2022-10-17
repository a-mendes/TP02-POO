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
	
	@Override
    public boolean equals(Object obj) {
		if (!(obj instanceof Livro))
            return false;
        if (obj == this)
            return true;

        AudioBook livro = (AudioBook) obj;
  
        return super.equals(obj) && 
        	   (duracao == livro.duracao) &&
        	   (formato == livro.formato);
        	   
	}
	
    @Override
    public int hashCode() {
        int result = 17;

        result = 31 * result + Float.valueOf(duracao).hashCode();
        result = 31 * result + formato.hashCode();
        
        return result;
    }
}
