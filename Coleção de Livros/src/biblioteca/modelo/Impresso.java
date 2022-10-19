package biblioteca.modelo;
import java.util.ArrayList;


public class Impresso extends Livro {
	
	private ArrayList<String> livrarias;
	private int numeroColunas;
	
	public void setLivrarias(ArrayList<String> livrarias) {
		this.livrarias = livrarias;
	}
	public void setNumeroColunas(int numeroColunas) {
		this.numeroColunas = numeroColunas;
	}
	
	public int getNumeroColunas() {
		return numeroColunas;
	}
	
	public ArrayList<String> getLivrarias() {
		return livrarias;
	}

	@Override
    public boolean equals(Object obj) {
		if (!(obj instanceof Livro))
            return false;
        if (obj == this)
            return true;

        Impresso livro = (Impresso) obj;
  
        return super.equals(obj) && 
        	   (livrarias.equals(livro.livrarias)) &&
        	   (numeroColunas == livro.numeroColunas);
        	   
	}
	
    @Override
    public int hashCode() {
        int result = 17 + super.hashCode();

        result = 31 * result + livrarias.hashCode();
        result = 31 * result + Integer.valueOf(numeroColunas).hashCode();
        
        return result;
    }
	
}
