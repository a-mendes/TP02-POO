package biblioteca.main;

import java.util.ArrayList;

import biblioteca.gui.Tela;
import biblioteca.modelo.Livro;
import biblioteca.servicos.BaseDeDados;

public class Main {
	public static Tela tela;
	public static ArrayList<Livro> livros;
	
	public static void main(String[] args) {
		//tela = new Tela();
		String stringGeral = "O Hobbit";
		int itemSelecionado[] = {1,1,1,1,1,1,1,1,1,1,1};
		int tipoMarcado[] = {1,1,1};
		
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
		
		//ArrayList de ArrayList<Livro>
		//Passa por cada filtro
		//Juntar arrayList em uma so
		//Remover itemDuplicados = Mesmo Nome e Mesma Classe
		
		//ArrayList resultado de Livro
		//Passa por cada filtro 
		//Adiciona os elementos do arrayList retornado por cada filtro no arratList resultado apenas se ele n�o estiver presente 
		
		//TIPO1: selecionar apenas uma campo ou geral (pesquisar em todos os campos) em combina��o com o tipo = Uma string geral 

		//TIPO2: selecionar varios campos ou geral geral (pesquisar em todos os campos) em combina��o com o tipo = Uma string geral
				
		//TIPO3: selecionar varios campos ou geral geral (pesquisar em todos os campos) em combina��o com o tipo = Uma string para cada campo
		
	}
	
	public static void resultado (ArrayList<Livro> resultado, ArrayList<Livro> filtrada){
		for (Livro element : filtrada){
            if (!resultado.contains(element)) { 
                resultado.add(element); 
            } 
        }
	}
	
	public static ArrayList<Livro> filtraTipo(ArrayList<Livro> livros, int tipo){
		ArrayList<Livro> retorno = new ArrayList<Livro>();
		
		if(tipo == 0) {
			for (Livro livro : livros) {
				if(livro instanceof Impresso) {
					retorno.add(livro);
				}
			}
		}
		else if(tipo == 1) {
			for (Livro livro : livros) {
				if(livro instanceof Eletronico) {
					retorno.add(livro);
				}
			}
		}
		else if(tipo == 2) {
			for (Livro livro : livros) {
				if(livro instanceof AudioBook) {
					retorno.add(livro);
				}
			}
		}
		
		return retorno;
	}

	public static ArrayList<Livro> filtraNome(ArrayList<Livro> livros, String texto){
		ArrayList<Livro> retorno = new ArrayList<Livro>();
		for (Livro livro : livros) {
			if(livro.getTitulo() == texto){
				retorno.add(livro);
			}
		}
		return retorno;
	}

	public static ArrayList<Livro> filtraEscritores(ArrayList<Livro> livros, String texto){
		ArrayList<Livro> retorno = new ArrayList<Livro>();
		for (Livro livro : livros) {
			for(String escritor : livro.getEscritores())
				if(escritor == texto){
					retorno.add(livro);
					break;
				}
		}
		return retorno;
	}
	public static ArrayList<Livro> filtraAno(ArrayList<Livro> livros, int ano){//recever String e converter para inteiro se possivel
		ArrayList<Livro> retorno = new ArrayList<Livro>();
		for (Livro livro : livros) {
			if(livro.getAnoDePublicacao() == ano){
				retorno.add(livro);
			}
		}
		return retorno;
	}
	public static ArrayList<Livro> filtraIdioma(ArrayList<Livro> livros, String texto){
		ArrayList<Livro> retorno = new ArrayList<Livro>();
		for (Livro livro : livros) {
			if(livro.getIdioma() == texto){
				retorno.add(livro);
			}
		}
		return retorno;
	}
	public static ArrayList<Livro> filtraPalavra(ArrayList<Livro> livros, String texto){
		ArrayList<Livro> retorno = new ArrayList<Livro>();
		for (Livro livro : livros) {
			for(String palavraChave : livro.getKeyWords())
				if(palavraChave == texto){
					retorno.add(livro);
					break;
				}
		}
		return retorno;
	}
	
	public static ArrayList<Livro> filtraLivraria(ArrayList<Livro> livros, String texto){
		ArrayList<Livro> retorno = new ArrayList<Livro>();
		Impresso tmp = new Impresso();
		
		for (Livro livro : livros) {
			if(livro instanceof Impresso){
				tmp = (Impresso)livro;
				for(String livraria : tmp.getLivrarias())
					if(livraria == texto) {
						retorno.add(livro);
						break;
					}
			}
		}
		return retorno;
	}
	public static ArrayList<Livro> filtraColuna(ArrayList<Livro> livros, int texto){//recever String e converter para inteiro se possivel
		ArrayList<Livro> retorno = new ArrayList<Livro>();
		Impresso tmp = new Impresso();
		
		for (Livro livro : livros) {
			if(livro instanceof Impresso){
				tmp = (Impresso)livro;
				if(tmp.getNumeroColunas() == texto) 
					retorno.add(livro);					
			}
		}
		return retorno;
	}
	public static ArrayList<Livro> filtraURL(ArrayList<Livro> livros, String texto){
		ArrayList<Livro> retorno = new ArrayList<Livro>();
		Eletronico tmp = new Eletronico();
		
		for (Livro livro : livros) {
			if(livro instanceof Eletronico){
				tmp = (Eletronico)livro;
				if(tmp.getURL() == texto) 
					retorno.add(livro);					
			}
		}
		return retorno;
	}
	public static ArrayList<Livro> filtraFormatoTexto(ArrayList<Livro> livros, String texto){
		ArrayList<Livro> retorno = new ArrayList<Livro>();
		Eletronico tmp = new Eletronico();
		
		for (Livro livro : livros) {
			if(livro instanceof Eletronico){
				tmp = (Eletronico)livro;
				if(tmp.getFormato() == texto) 
					retorno.add(livro);					
			}
		}
		return retorno;
	}
	public static ArrayList<Livro> filtraDuracao(ArrayList<Livro> livros, double texto){//recever String e converter para double se possivel
		ArrayList<Livro> retorno = new ArrayList<Livro>();
		AudioBook tmp = new AudioBook();
		
		for (Livro livro : livros) {
			if(livro instanceof AudioBook){
				tmp = (AudioBook)livro;
				if(tmp.getDuracao() == texto) 
					retorno.add(livro);					
			}
		}
		return retorno;
	}
	public static ArrayList<Livro> filtraFormatoAudio(ArrayList<Livro> livros, String texto){
		ArrayList<Livro> retorno = new ArrayList<Livro>();
		AudioBook tmp = new AudioBook();
		
		for (Livro livro : livros) {
			if(livro instanceof AudioBook){
				tmp = (AudioBook)livro;
				if(tmp.getFormato() == texto) 
					retorno.add(livro);					
			}
		}
		return retorno;
	}

}
