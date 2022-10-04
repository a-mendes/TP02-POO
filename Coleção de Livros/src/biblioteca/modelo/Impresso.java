package ao.co.a2x.biblioteca.modelo;
import java.util.Vector;
import ao.co.a2x.biblioteca.modelo.Livro;


public class Impresso extends Livro{
	private Vector<String>Livrarias;
	private int NumeroColunas;
	

	public void setLivrarias(Vector<String> livrarias) {
		Livrarias = livrarias;
	}
	public void setNumeroColunas(int numeroColunas) {
		NumeroColunas = numeroColunas;
	}
	
	public int getNumeroColunas() {
		return NumeroColunas;
	}
	
	public Vector<String> getLivrarias() {
		return Livrarias;
	}
	
}
