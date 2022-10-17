package biblioteca.main;

import java.util.ArrayList;

import biblioteca.gui.Tela;
import biblioteca.modelo.Impresso;
import biblioteca.modelo.Eletronico;
import biblioteca.modelo.AudioBook;
import biblioteca.modelo.Livro;
import biblioteca.servicos.BaseDeDados;

public class Main {
	public static Tela tela;
	public static ArrayList<Livro> livros;
	
	public static void main(String[] args) {
		//tela = new Tela();
		
		String stringGeral = "Martine";
		int itemSelecionado[] = {1,0,0,0,0,0,0,0,0,0,0,0};
		int tipoMarcado[] = {1,0,0};
				
		try {
			livros = BaseDeDados.lerBaseDeDados();
		} catch (Exception e) {
			System.out.println("ERROR: Falha ao ler base de dados");
			e.printStackTrace();
		}

//		for (Livro livro : livros) {
//			System.out.println(livro.getClass());
//			System.out.println(livro.getTitulo());
//			System.out.println();
//		}

		ArrayList<Livro> filtrado = new ArrayList<Livro>();
		ArrayList<Livro> tmp = new ArrayList<Livro>();
						
		//Filtrar Tipo
		if(tipoMarcado[0] == 1) { //Impresso
			tmp.clear();
			tmp = (filtraTipo(livros, 0));
			resultado(filtrado, tmp);
		}
		if(tipoMarcado[1] == 1) { //Eletronico
			tmp.clear();
			tmp = (filtraTipo(livros, 1));
			resultado(filtrado, tmp);
		}
		if(tipoMarcado[2] == 1) { //Audio Book
			tmp.clear();
			tmp = (filtraTipo(livros, 2));
			resultado(filtrado, tmp);
		}
		
		//Filtrar Coisas Gerais
		if(itemSelecionado[0] == 1) { //Nome 
			filtrado.retainAll(filtraNome(livros, stringGeral));
			
			//tmp.clear();
			//tmp = filtraNome(filtrado, stringGeral);
			//resultado(filtrado, tmp);
		}
		if(itemSelecionado[1] == 1) { //Escritor 
			//tmp.clear();
			//tmp = filtraEscritores(filtrado, stringGeral);
			//resultado(filtrado, tmp);
		}
		if(itemSelecionado[2] == 1) { //Ano
			//tmp.clear();
			//tmp = filtraAno(filtrado, numeroGeral);
			//resultado(filtrado, tmp);
		}
		if(itemSelecionado[3] == 1) { //Idioma
			//tmp.clear();
			//tmp = filtraIdioma(filtrado, stringGeral);
			//resultado(filtrado, tmp);
		}
		if(itemSelecionado[4] == 1) { //Palavra Chave
			//tmp.clear();
			//tmp = filtraPalavra(filtrado, stringGeral);
			//resultado(filtrado, tmp);
		}
		if(itemSelecionado[5] == 1) {//Capitulo
			//tmp.clear();
			//tmp = filtraCapitulos(filtrado, stringGeral);
			//resultado(filtrado, tmp);
		}
		
		//Filtrar Coisas Especificas do tipo
		if(itemSelecionado[6] == 1 && tipoMarcado[0] == 1) { //Livraria
			//tmp.clear();
			//tmp = filtraLivraria(filtrado, stringGeral);
			//resultado(filtrado, tmp);
		}
		if(itemSelecionado[7] == 1 && tipoMarcado[0] == 1) { //Coluna
			//tmp.clear();
			//tmp = filtraColuna(filtrado, numeroGeral);
			//resultado(filtrado, tmp);
		}
		
		if(itemSelecionado[8] == 1 && tipoMarcado[1] == 1) { //URL
			//tmp.clear();
			//tmp = filtraURL(filtrado, stringGeral);
			//resultado(filtrado, tmp);
		}
		if(itemSelecionado[9] == 1 && tipoMarcado[1] == 1) { //Formato Texto
			//tmp.clear();
			//tmp = filtraFormatoTexto(filtrado, stringGeral);
			//resultado(filtrado, tmp);
		}
		
		if(itemSelecionado[10] == 1 && tipoMarcado[2] == 1) { //Duracao
			//tmp.clear();
			//tmp = filtraDuracao(filtrado, numeroGeral);
			//resultado(filtrado, tmp);
		}
		if(itemSelecionado[11] == 1 && tipoMarcado[2] == 1) { //Formato Audio
			//tmp.clear();
			//tmp = filtraFormatoAudio(filtrado, stringGeral);
			//resultado(filtrado, tmp);
		}
			
		for (Livro livro : filtrado) {
			System.out.println(livro.getClass());
			System.out.println(livro.getTitulo());
			System.out.println();
		}
	
		//TIPO1: selecionar apenas uma campo ou geral (pesquisar em todos os campos) em combinação com o tipo = Uma string geral 
		
		//TIPO2: selecionar varios campos ou geral geral (pesquisar em todos os campos) em combinação com o tipo = Uma string geral
		
		//TIPO3: selecionar varios campos ou geral geral (pesquisar em todos os campos) em combinação com o tipo = Uma string para cada campo
		
	}
	
	public static void resultado (ArrayList<Livro> filtrada, ArrayList<Livro> tmp){
		for (Livro element : tmp){
            if (!filtrada.contains(element)) { 
            	filtrada.add(element); 
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
			if(livro.getTitulo().equals(texto)){
				retorno.add(livro);
			}
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
				if(tmp.getFormato().equals(texto)) 
					retorno.add(livro);					
			}
		}
		return retorno;
	}

}
