package biblioteca.servicos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.lang.String;

import biblioteca.modelo.AudioBook;
import biblioteca.modelo.Eletronico;
import biblioteca.modelo.Impresso;
import biblioteca.modelo.Livro;

public class BaseDeDados {

	public static ArrayList<Livro> livros;
	private static BufferedReader reader;
	
	public static void lerBaseDeDados() {
		livros = new ArrayList<Livro>();

		for (int i = 0; i < 16; ++i)
		{
			String path = "data/" + (i+1) + ".txt";
			File arquivo = new File(path);
			try {
				reader = new BufferedReader(new FileReader(arquivo.getPath()));
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}

			/** 
			 * Faz verificação de tipo de livro e cria instancia adequada
			 */ 

			String recebeTipo;
			try {
				recebeTipo = reader.readLine();
			
				int tipoLivro = Integer.parseInt(recebeTipo);
	
				switch(tipoLivro)
				{
					/**
					 //Impresso
					 */ 
					case 1:
					{
						Impresso livro = new Impresso();
						//lerImpresso(arquivo, livro);
						livros.add(livro);
						System.out.println("Impresso");
					}
					break;
	
					/**
					 * Eletronico
					 */ 
					case 2:
					{
						Eletronico livro = new Eletronico();
						//lerEletronico(arquivo, livro);
						livros.add(livro);
						System.out.println("Eletronico");
					}
					break;
	
					/**
					 * AudioBook
					 */ 
					case 3:
					{
						AudioBook livro = new AudioBook();
						//lerAudioBook(arquivo, livro);
						livros.add(livro);
						System.out.println("Audiobook");
					}
					break;
				}
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	
	

void lerLivro(File arquivo, Livro livro) throws Exception
{
	/**
	 * Titulo
	 */ 
	String titulo;
    reader = new BufferedReader(new FileReader(arquivo.getPath()));
    titulo = reader.readLine();
    livro.setTitulo(titulo);

	/**
	 * Escritores
	 */ 
	String strEscritores;
	reader = new BufferedReader(new FileReader(arquivo.getPath()));
	strEscritores = reader.readLine();
	String[] escritores;
	escritores = strEscritores.split(";");
	ArrayList<String> recebeEscritores = null;
	for(int i=0;i<escritores.length;i++) {
		recebeEscritores.add(escritores[i]);
	}
	livro.setEscritores(recebeEscritores);

	/**
	 * Ano
	 */ 
	String ano;
	reader = new BufferedReader(new FileReader(arquivo.getPath()));
	ano = reader.readLine();
	livro.setAnoDePublicacao(Integer.parseInt(ano));

	/**
	 * Idioma
	 */ 
	String idioma;
	reader = new BufferedReader(new FileReader(arquivo.getPath()));
	idioma = reader.readLine();
	livro.setIdioma(idioma);

//	/**
//	 * Keywords
//	 */ 
	String strKeywords;
	reader = new BufferedReader(new FileReader(arquivo.getPath()));
	strKeywords = reader.readLine();
	String[] keywords;
	keywords = strKeywords.split(";");
	ArrayList<String> recebeKeyWords = null;
	for(int i=0;i<keywords.length;i++) {
		recebeKeyWords.add(keywords[i]);
	}
	
	livro.setKeyWords(recebeKeyWords);
	
//	/**
//	 * Capitulos
//	 */ 
	String strCapitulos;
	reader = new BufferedReader(new FileReader(arquivo.getPath()));
	strCapitulos = reader.readLine();
	String[] capitulos;
	capitulos = strCapitulos.split(";");
	ArrayList<String> recebeCapitulos = null;
	for(int i=0;i<capitulos.length;i++) {
		recebeCapitulos.add(capitulos[i]);
	}
	
	livro.setCapitulos(recebeCapitulos);
	}


void lerAudioBook(File arquivo, AudioBook audioBook) throws Exception
{
	lerLivro(arquivo, audioBook);

	/**
	 * Duracao Audio
	 */ 
	String duracao;
	reader = new BufferedReader(new FileReader(arquivo.getPath()));
	duracao = reader.readLine();
	audioBook.setDuracao(Integer.parseInt(duracao));
	
	/**
	 * Formato Audio
	 */ 
	String formato;
	reader = new BufferedReader(new FileReader(arquivo.getPath()));
	formato = reader.readLine();
	audioBook.setFormato(formato);
}

void lerEletronico(File arquivo, Eletronico eletronico) throws Exception
{
	lerLivro(arquivo, eletronico);

	/**
	 * Url
	 */ 
	String url;
	reader = new BufferedReader(new FileReader(arquivo.getPath()));
	url = reader.readLine();
	eletronico.setURL(url);
	
	/**
	 * Formato Audio
	 */ 
	String formato;
	reader = new BufferedReader(new FileReader(arquivo.getPath()));
	formato = reader.readLine();
	eletronico.setFormato(formato);
}

void lerImpresso(File arquivo, Impresso impresso) throws Exception
{
	lerLivro(arquivo, impresso);

	/**
	 * Livrarias
	 */ 
	String strLivrarias;
	reader = new BufferedReader(new FileReader(arquivo.getPath()));
	strLivrarias = reader.readLine();
	String[] livrarias;
	livrarias = strLivrarias.split(";");
	ArrayList<String> recebeLivrarias = null;
	for(int i=0;i<livrarias.length;i++) {
		recebeLivrarias.add(livrarias[i]);
	}
	
	impresso.setLivrarias(recebeLivrarias);
	
	String colunas;
	reader = new BufferedReader(new FileReader(arquivo.getPath()));
	colunas = reader.readLine();
	impresso.setNumeroColunas(Integer.parseInt(colunas));
}
}
