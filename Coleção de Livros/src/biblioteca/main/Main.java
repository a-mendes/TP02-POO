package biblioteca.main;

import java.util.ArrayList;

import biblioteca.gui.Tela;
import biblioteca.modelo.Livro;
import biblioteca.servicos.BaseDeDados;

public class Main {
	public static Tela tela;
	public static ArrayList<Livro> livros;
	
	public static void main(String[] args) {
		tela = new Tela();
		
		try {
			livros = BaseDeDados.lerBaseDeDados();
		} catch (Exception e) {
			System.out.println("ERROR: Falha ao ler base de dados");
			e.printStackTrace();
		}
		
		for (Livro livro : livros) {
			System.out.println(livro.getClass());
			System.out.println(livro.getTitulo());
			System.out.println();
		}
		
//		ArrayList<Livro> pesquisa;
//		pesquisa = Main.pesquisa(livros);
//
//		for (Livro livro : pesquisa) {
//			System.out.println(livro.getClass());
//			System.out.println(livro.getTitulo());
//			System.out.println();
//		}
	}
	
	public static ArrayList<Livro> pesquisa(ArrayList<Livro> livros) {

		ArrayList<Livro> retorno = new ArrayList<Livro>(); 
		
		//String tipoMarcado = "Impresso";
		//String stringPesquisa = "Hobbit";
		//vetor com os outros itens marcoados ou desmarcados;
		
		//Tipo = Tipo da Classe
//		if(vetorMarcados[0] == "") {
//			for (Livro livro : livros) {
//				if(livro.getClass() == tipoMarcado || tipoMarcado == "") {
//					retorno.add(livro);
//				}
//			}
//		}
	
		//Nome = String
		//Escritor = Array de Strings
		//Ano de Publicacao = Int
		//Idioma = String
		//Palavras Chave = Array de Strings
		
		//Livrarias = Array de Strins
		//Colunas = Int
		
		//URL = String
		//Formato = String
		
		//Duracao = Float
		//FormatoAudio = String
		
		//Remove os duplicados do retorno
		
		return retorno;

	}
}
