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
	
}
