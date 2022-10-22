package biblioteca.main;

import java.util.ArrayList;

import biblioteca.gui.Tela;
import biblioteca.modelo.Livro;
import biblioteca.servicos.BaseDeDados;
import biblioteca.servicos.Filtragem;
import biblioteca.servicos.Relatorio;


public class Main {
	public static Tela tela;
	public static ArrayList<Livro> livros;
	
	public static void main(String[] args) {
		/**
		 * Instância da interface gráfica
		 */
		tela = new Tela();

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
		 * A Tabela de resultados da pesquisa se inicia com todos os registros
		 */
		tela.setResultadoPesquisa(livros);


		System.out.println("--------------Completo--------------");
		for (Livro livro : livros) {
			System.out.println(livro.getClass());
			System.out.println(livro.getTitulo());
			System.out.println();
		}
		
		//Filtragem.testeFiltragem(livros);
		//Relatorio.geradorRelatorio(livros);
	}


}
