package biblioteca.servicos;

import java.util.ArrayList;
import java.util.HashSet;

import biblioteca.modelo.AudioBook;
import biblioteca.modelo.Eletronico;
import biblioteca.modelo.Impresso;
import biblioteca.modelo.Livro;

public class Filtragem {
	
	public static void testeFiltragem(ArrayList<Livro> livros) {
		
		ArrayList<Livro> testeFiltrado = new ArrayList<Livro>();
		
//		String[] stringGeral = new String[]{"Harry Potter e a Pedra Filosofal","teste","","","","","","","","","","",};
//		int itemSelecionado[] = {1,1,1,1,0,0,0,0,0,0,0,0,0,0,0};
//		testeFiltrado = pesquisaEspecifica(livros, stringGeral, itemSelecionado);
		
		String stringGeral = "O Senhor dos Aneis";
		int itemSelecionado[] = {1,1,1,1,1,0,1,1,1,1,0,1,1,0,1};
		testeFiltrado = pesquisaGeral(livros, stringGeral, itemSelecionado);
		
		System.out.println("--------------Filtado--------------");
		for (Livro livro : testeFiltrado) {
			System.out.println(livro.getClass());
			System.out.println(livro.getTitulo());
			System.out.println();
		}

	}
	
	public static void resultado (ArrayList<Livro> filtrada, ArrayList<Livro> tmp){
		HashSet<Livro> hashSetTeste = new HashSet<Livro>(filtrada);
		
		for (Livro element : tmp)
        	hashSetTeste.add(element); 
		
		filtrada.clear();
		filtrada.addAll(hashSetTeste);
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
			if(livro.getTitulo().equals(texto))
				retorno.add(livro);
		}
		return retorno;
	}

	public static ArrayList<Livro> filtraEscritores(ArrayList<Livro> livros, String texto){
		ArrayList<Livro> retorno = new ArrayList<Livro>();
		for (Livro livro : livros) {
			for(String escritor : livro.getEscritores())
				if(escritor.equals(texto)){
					retorno.add(livro);
					break;
				}
		}
		return retorno;
	}	
	
	public static ArrayList<Livro> filtraAno(ArrayList<Livro> livros, int ano){
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
			if(livro.getIdioma().equals(texto)){
				retorno.add(livro);
			}
		}
		return retorno;
	}
	
	public static ArrayList<Livro> filtraPalavra(ArrayList<Livro> livros, String texto){
		ArrayList<Livro> retorno = new ArrayList<Livro>();
		for (Livro livro : livros) {
			for(String palavraChave : livro.getKeyWords())
				if(palavraChave.equals(texto)){
					retorno.add(livro);
					break;
				}
		}
		return retorno;
	}

	public static ArrayList<Livro> filtraCapitulos(ArrayList<Livro> livros, String texto){
		ArrayList<Livro> retorno = new ArrayList<Livro>();
		for (Livro livro : livros) {
			for(String capitulos : livro.getCapitulos())
				if(capitulos.equals(texto)){
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
					if(livraria.equals(texto)) {
						retorno.add(livro);
						break;
					}
			}
		}
		return retorno;
	}
	
	public static ArrayList<Livro> filtraColuna(ArrayList<Livro> livros, int texto){
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
				if(tmp.getURL().equals(texto)) 
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
				if(tmp.getFormato().equals(texto)) 
					retorno.add(livro);					
			}
		}
		return retorno;
	}
	
	public static ArrayList<Livro> filtraDuracao(ArrayList<Livro> livros, double texto){
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
				if(tmp.getFormato().equals(texto)) 
					retorno.add(livro);					
			}
		}
		return retorno;
	}
	
	public static ArrayList<Livro> pesquisaEspecifica(ArrayList<Livro> livros, String[] stringGeral, int itemSelecionado[]){
		ArrayList<Livro> filtrado = new ArrayList<Livro>();
							
		//Filtrar Tipo
		if(itemSelecionado[0] == 1) //Impresso
			resultado(filtrado, filtraTipo(livros, 0));
		
		if(itemSelecionado[1] == 1) //Eletronico
			resultado(filtrado, filtraTipo(livros, 1));
		
		if(itemSelecionado[2] == 1) //Audio Book
			resultado(filtrado, filtraTipo(livros, 2));
		
		//Filtrar Coisas Gerais
		if(itemSelecionado[3] == 1) //Nome 
			filtrado = filtraNome(filtrado, stringGeral[0]);
		
		if(itemSelecionado[4] == 1) //Escritor 
			filtrado = filtraEscritores(filtrado, stringGeral[1]);
		
		if(itemSelecionado[5] == 1) //Ano
			filtrado = filtraAno(filtrado, Integer.parseInt(stringGeral[2])); //Nao vai lancar exeção porque ja for testado antes 
		
		if(itemSelecionado[6] == 1) //Idioma
			filtrado = filtraIdioma(filtrado, stringGeral[3]);
					
		if(itemSelecionado[7] == 1) //Palavra Chave
			filtrado = filtraPalavra(filtrado, stringGeral[4]);
					
		if(itemSelecionado[8] == 1) //Capitulo
			filtrado = filtraCapitulos(filtrado, stringGeral[5]);
		
		//Filtrar Coisas Especificas do tipo
		if(itemSelecionado[9] == 1 && itemSelecionado[0] == 1) //Livraria
			filtrado = filtraLivraria(filtrado, stringGeral[6]);
			
		if(itemSelecionado[10] == 1 && itemSelecionado[0] == 1) //Coluna
			filtrado = filtraColuna(filtrado, Integer.parseInt(stringGeral[7])); //Nao vai lancar exeção porque ja for testado antes 
				
		if(itemSelecionado[11] == 1 && itemSelecionado[1] == 1) //URL
			filtrado = filtraURL(filtrado, stringGeral[8]);

		if(itemSelecionado[12] == 1 && itemSelecionado[1] == 1) //Formato Texto
			filtrado = filtraFormatoTexto(filtrado, stringGeral[9]);
		
		if(itemSelecionado[13] == 1 && itemSelecionado[2] == 1) //Duracao
			filtrado = filtraDuracao(filtrado, Integer.parseInt(stringGeral[10])); //Nao vai lancar exeção porque ja for testado antes
			
		if(itemSelecionado[14] == 1 && itemSelecionado[2] == 1) //Formato Audio
			filtrado = filtraFormatoAudio(filtrado, stringGeral[11]);
			
			
		return filtrado;		
	}
	
	public static ArrayList<Livro> pesquisaGeral(ArrayList<Livro> livros, String stringGeral, int itemSelecionado[]){
		ArrayList<Livro> filtradoTipo = new ArrayList<Livro>();
		ArrayList<Livro> filtradoCoisas = new ArrayList<Livro>();
							
		//Filtrar Tipo
		if(itemSelecionado[0] == 1) //Impresso
			resultado(filtradoTipo, filtraTipo(livros, 0));
		
		if(itemSelecionado[1] == 1) //Eletronico
			resultado(filtradoTipo, filtraTipo(livros, 1));
		
		if(itemSelecionado[2] == 1) //Audio Book
			resultado(filtradoTipo, filtraTipo(livros, 2));
		
		
		//Filtrar Coisas Gerais
		if(itemSelecionado[3] == 1) //Nome 
			resultado(filtradoCoisas, filtraNome(filtradoTipo, stringGeral));
		
		if(itemSelecionado[4] == 1) //Escritor 
			resultado(filtradoCoisas, filtraEscritores(filtradoTipo, stringGeral));
		
		if(itemSelecionado[5] == 1) //Ano
			resultado(filtradoCoisas, filtraAno(filtradoTipo, Integer.parseInt(stringGeral)));
		
		if(itemSelecionado[6] == 1) //Idioma
			resultado(filtradoCoisas, filtraIdioma(filtradoTipo, stringGeral));
		
		if(itemSelecionado[7] == 1) //Palavra Chave
			resultado(filtradoCoisas, filtraPalavra(filtradoTipo, stringGeral));
		
		if(itemSelecionado[8] == 1)//Capitulo
			resultado(filtradoCoisas, filtraCapitulos(filtradoTipo, stringGeral));
		
		
		//Filtrar Coisas Especificas do tipo
		if(itemSelecionado[9] == 1 && itemSelecionado[0] == 1) //Livraria
			resultado(filtradoCoisas, filtraLivraria(filtradoTipo, stringGeral));
		
		if(itemSelecionado[10] == 1 && itemSelecionado[0] == 1) //Coluna
			resultado(filtradoCoisas, filtraColuna(filtradoTipo, Integer.parseInt(stringGeral)));
		
		if(itemSelecionado[11] == 1 && itemSelecionado[1] == 1) //URL
			resultado(filtradoCoisas, filtraURL(filtradoTipo, stringGeral));
		
		if(itemSelecionado[12] == 1 && itemSelecionado[1] == 1) //Formato Texto
			resultado(filtradoCoisas, filtraFormatoTexto(filtradoTipo, stringGeral));
		
		if(itemSelecionado[13] == 1 && itemSelecionado[2] == 1) //Duracao
			resultado(filtradoCoisas, filtraDuracao(filtradoTipo, Integer.parseInt(stringGeral)));
		
		if(itemSelecionado[14] == 1 && itemSelecionado[2] == 1) //Formato Audio
			resultado(filtradoCoisas, filtraFormatoAudio(filtradoTipo, stringGeral));
		
		
		return filtradoCoisas;		
	}


}
