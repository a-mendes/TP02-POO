package biblioteca.servicos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

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
	
}
	

//void lerLivro(FILE arquivo, Livro livro)
//{
//	/**
//	 * Titulo
//	 */ 
//	String titulo;
//	getline(arquivo, titulo);
//	livro.setTitulo(titulo);
//
//	/**
//	 * Escritores
//	 */ 
//	String strEscritores;
//	getline(arquivo, strEscritores);
//	ArrayList<string> escritores;
//	split(strEscritores, escritores, ';');
//	livro->setEscritores(escritores);
//
//	/**
//	 * Ano
//	 */ 
//	string ano;
//	getline(arquivo, ano);
//	livro->setAnoPublicacao(stoi(ano));
//
//	/**
//	 * Idioma
//	 */ 
//	string idioma;
//	getline(arquivo, idioma);
//	livro->setIdiomaOriginal(idioma);
//
//	/**
//	 * Keywords
//	 */ 
//	string strKeywords;
//	getline(arquivo, strKeywords);
//	ArrayList<string> keywords;
//	split(strKeywords, keywords, ';');
//	livro->setKeywords(keywords);
//	
//	/**
//	 * Capitulos
//	 */ 
//	string strCapitulos;
//	getline(arquivo, strCapitulos);
//	ArrayList<string> capitulos;
//	split(strCapitulos, capitulos, ';');
//	livro->setCapitulos(capitulos);
//}
//
//	
//	
//}

