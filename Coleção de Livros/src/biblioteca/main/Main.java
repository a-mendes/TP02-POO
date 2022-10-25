package biblioteca.main;

import java.util.ArrayList;

import biblioteca.gui.Tela;
import biblioteca.modelo.Livro;
import biblioteca.servicos.BaseDeDados;


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
		tela = new Tela(livros);


//		System.out.println("--------------Completo--------------");
//		for (Livro livro : livros) {
//			System.out.println(livro.getClass());
//			System.out.println(livro.getTitulo());
//			System.out.println();
//		}
		
		//Filtragem.testeFiltragem(livros);
		//Relatorio.geradorRelatorio(livros);
	}

}
