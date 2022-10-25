package biblioteca.servicos;

import java.util.ArrayList;
import java.util.HashSet;

import biblioteca.modelo.AudioBook;
import biblioteca.modelo.Eletronico;
import biblioteca.modelo.Impresso;
import biblioteca.modelo.Livro;

public class Filtragem {
	
	public static void resultado (ArrayList<Livro> filtrada, ArrayList<Livro> tmp){
		//Hash set para n�o permitir duplicados 
		HashSet<Livro> hashSetTeste = new HashSet<Livro>(filtrada);
		
		//Os itens do arrayList tmp s�o adicionados no HashSet
		for (Livro element : tmp)
        	hashSetTeste.add(element); 
		
		//ArrayList � limpo por precau��o e os elementos do hashSetTeste s�o adicionados a ele 
		filtrada.clear();
		filtrada.addAll(hashSetTeste);
	}
	
	//Filtros retornam os elementos do arrayList "livros" que contei o atributo desejado 
	
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
			if(CasamentoAproximado.computeLevenshtein(livro.getTitulo().toLowerCase(), texto.toLowerCase()) <= Math.max((int)(livro.getTitulo().length()/2) - 1, 0))
				retorno.add(livro);
		}
		return retorno;
	}

	public static ArrayList<Livro> filtraEscritores(ArrayList<Livro> livros, String texto){
		ArrayList<Livro> retorno = new ArrayList<Livro>();
		for (Livro livro : livros) {
			for(String escritor : livro.getEscritores())
				if(CasamentoAproximado.computeLevenshtein(escritor.toLowerCase(), texto.toLowerCase()) <= Math.max((int)(escritor.length()/2) - 1, 0)) {
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
			if(CasamentoAproximado.computeLevenshtein(livro.getIdioma().toLowerCase(), texto.toLowerCase()) <= Math.max((int)(livro.getIdioma().length()/2) - 1, 0))
				retorno.add(livro);
			
		}
		return retorno;
	}
	
	public static ArrayList<Livro> filtraPalavra(ArrayList<Livro> livros, String texto){
		ArrayList<Livro> retorno = new ArrayList<Livro>();
		for (Livro livro : livros) {
			for(String palavraChave : livro.getKeyWords())
				if(CasamentoAproximado.computeLevenshtein(palavraChave.toLowerCase(), texto.toLowerCase()) <= Math.max((int)(palavraChave.length()/2) - 1, 0)) {
					retorno.add(livro);
					break;
				}
		}
		return retorno;
	}

	public static ArrayList<Livro> filtraCapitulos(ArrayList<Livro> livros, String texto){
		ArrayList<Livro> retorno = new ArrayList<Livro>();
		for (Livro livro : livros) {
			for(String capitulos : livro.getCapitulos()) {
				if(CasamentoAproximado.computeLevenshtein(capitulos.toLowerCase(), texto.toLowerCase()) <= Math.max((int)(capitulos.length()/2) - 1, 0)) {
					retorno.add(livro);
					break;
				}
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
					if(CasamentoAproximado.computeLevenshtein(livraria.toLowerCase(), texto.toLowerCase()) <= Math.max((int)(livraria.length()/2) - 1, 0)) {
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
				if(CasamentoAproximado.computeLevenshtein(tmp.getURL().toLowerCase(), texto.toLowerCase()) <= Math.max((int)(tmp.getURL().length()/2) - 1, 0))
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
				if(CasamentoAproximado.computeLevenshtein(tmp.getFormato().toLowerCase(), texto.toLowerCase()) <= Math.max((int)(tmp.getFormato().length()/2) - 1, 0))
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
				if(CasamentoAproximado.computeLevenshtein(tmp.getFormato().toLowerCase(), texto.toLowerCase()) <= Math.max((int)(tmp.getFormato().length()/2) - 1, 0))
					retorno.add(livro);					
			}
		}
		return retorno;
	}
	
	//Filtra os livros dado quais itens est�o marcados e as strings correspondentes 
	public static ArrayList<Livro> pesquisaEspecifica(ArrayList<Livro> livros, String[] stringGeral, int itemSelecionado[]){
		ArrayList<Livro> filtrado = new ArrayList<Livro>();
		
		/*
		A rela��o entre a filtragem de Tipos � ||
		Ou seja, tendo 2 tipos marcados o resultado da filtragem pode estar em um OU em outro
		*/
		
		//Filtrar Tipo
		if(itemSelecionado[0] == 1) //Impresso
			resultado(filtrado, filtraTipo(livros, 0));
		
		if(itemSelecionado[1] == 1) //Eletronico
			resultado(filtrado, filtraTipo(livros, 1));
		
		if(itemSelecionado[2] == 1) //Audio Book
			resultado(filtrado, filtraTipo(livros, 2));
		
		/*
		� feito um && a cada filtragem
		Os livros resultante devem atender a todos os itens marcados
		Ou seja, tendo "nome" e "Escritor" marcado, os livros resultantes devem ter o nome E o escritor determinado
		*/
		
		//Filtrar Campos Gerais
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
	
	//Filtra os livros em todos os campo, dadado uma string 
	public static ArrayList<Livro> pesquisaGeral(ArrayList<Livro> livros, String stringGeral, int itemSelecionado[]){
		ArrayList<Livro> filtradoTipo = new ArrayList<Livro>();
		ArrayList<Livro> filtradoCoisas = new ArrayList<Livro>();
		
		/*
		A rela��o entre a filtragem de Tipos � ||
		Ou seja, tendo 2 tipos marcados o resultado da filtragem pode estar em um OU em outro
		*/
		
		//Filtrar Tipo
		if(itemSelecionado[0] == 1) //Impresso
			resultado(filtradoTipo, filtraTipo(livros, 0));
		
		if(itemSelecionado[1] == 1) //Eletronico
			resultado(filtradoTipo, filtraTipo(livros, 1));
		
		if(itemSelecionado[2] == 1) //Audio Book
			resultado(filtradoTipo, filtraTipo(livros, 2));
		
		/*
		Todos os campos dos livros s�o verificados menos o Ano, Colunas e dura��o, se a string digitada for um valor n�o numerico
		� feito um || a cada filtragem
		Ou seja, se a string dada casar com o nome OU algum dos escritores do livro, este � selecioando 
		*/
		
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
