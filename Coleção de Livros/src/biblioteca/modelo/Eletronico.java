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
	
	@Override
    public boolean equals(Object obj) {
		if (!(obj instanceof Livro))
            return false;
        if (obj == this)
            return true;

        Eletronico livro = (Eletronico) obj;
  
        return super.equals(obj) && 
        	   (URL == livro.URL) &&
        	   (formato == livro.formato);
        	   
	}
	
    @Override
    public int hashCode() {
        int result = 17 + super.hashCode();

        result = 31 * result + URL.hashCode();
        result = 31 * result + formato.hashCode();
        
        return result;
    }
}
