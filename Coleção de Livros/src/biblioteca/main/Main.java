package biblioteca.main;

import java.util.ArrayList;

import biblioteca.gui.Tela;
import biblioteca.modelo.Livro;
import biblioteca.servicos.BaseDeDados;
import biblioteca.servicos.AlteraBiblioteca;


public class Main {
	public static Tela tela;
	public static ArrayList<Livro> livros;
	
	public static void main(String[] args) {

		/**
		 * Leitura da Base de Dados
		 */
		try {
			livros = BaseDeDados.lerBaseDeDados();
		} catch (Exception e) {
			System.out.println("ERROR: Falha ao ler base de dados");
			e.printStackTrace();
		}
		
		/**
		 * Instancia da interface gráfica
		 */
		//tela = new Tela(livros);
		
		AlteraBiblioteca.testa(livros);

	}

}
