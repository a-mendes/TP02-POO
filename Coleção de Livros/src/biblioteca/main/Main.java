package biblioteca.main;

import java.util.ArrayList;

import biblioteca.gui.Teste;
import biblioteca.modelo.Livro;
import biblioteca.servicos.BaseDeDados;
import biblioteca.servicos.Filtragem;
import biblioteca.servicos.Relatorio;


public class Main {
	public static Teste tela;
	public static ArrayList<Livro> livros;
	
	public static void main(String[] args) {
		tela = new Teste();
				
		try {
			livros = BaseDeDados.lerBaseDeDados();
		} catch (Exception e) {
			System.out.println("ERROR: Falha ao ler base de dados");
			e.printStackTrace();
		}

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
