package biblioteca.servicos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import biblioteca.modelo.AudioBook;
import biblioteca.modelo.Eletronico;
import biblioteca.modelo.Impresso;
import biblioteca.modelo.Livro;

public class BaseDeDados {
	//Responsavel pela leitura do arquivo
	private static BufferedReader reader;
	static ArrayList<Livro> livros = new ArrayList<Livro>();
	//Responsavel por ler arquivos com as descrições dos livros 
	public static ArrayList<Livro> lerBaseDeDados() throws Exception {
	//Descobre quantos arquivos possui na pasta 
		File file = new File("data/");

		int qtdArquivos = file.listFiles().length;
		
		for (int i = 0; i < qtdArquivos ; ++i)
		{
			String path = "data/" + (i+1) + ".txt";
			File arquivo = new File(path);
			try {
				reader = new BufferedReader(new FileReader(arquivo.getPath()));
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}

			/** 
			 * Faz verificacao de tipo de livro e cria instancia adequada
			 */ 

			String strTipoLivro;
			strTipoLivro = reader.readLine();
		
			int tipoLivro = Integer.parseInt(strTipoLivro);
			//Adiciona Livros ao Array
			adicionaLivro(tipoLivro);
			//Fecha arquivos 
			reader.close();
		}
		
		return livros;
	}

	public static void adicionaLivro(int tipoLivro) {
		switch(tipoLivro)
		{
			/**
			 * Impresso
			 */ 
			case 1:
			{
				Impresso livro = new Impresso();
				try {
					lerImpresso(livro);
				} catch (Exception e) {
					e.printStackTrace();
				}
				livros.add(livro);
			}
			break;

			/**
			 * 
			 * Eletronico
			 */ 
			case 2:
			{
				Eletronico livro = new Eletronico();
				try {
					lerEletronico(livro);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				livros.add(livro);
			}
			break;

			/**
			 * AudioBook
			 */ 
			case 3:
			{
				AudioBook livro = new AudioBook();
				try {
					lerAudioBook(livro);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				livros.add(livro);
			}
			break;
		}
	}
	//Responsavel por ler e "setar" todos os dados basicos  dos livros 
	private static void lerLivro(Livro livro) throws IOException 
	{
		/**
		 * Titulo
		 */ 
		String titulo;
	    titulo = reader.readLine();
	    livro.setTitulo(titulo);
	
		/**
		 * Escritores
		 */ 
		String strEscritores;
		strEscritores = reader.readLine();
		ArrayList<String> escritores = new ArrayList<>(Arrays.asList(strEscritores.split(";")));
		livro.setEscritores(escritores);
	
		/**
		 * Ano
		 */ 
		String ano;
		ano = reader.readLine();
		livro.setAnoDePublicacao(Integer.parseInt(ano));
	
		/**
		 * Idioma
		 */ 
		String idioma;
		idioma = reader.readLine();
		livro.setIdioma(idioma);
	
		/**
		 * Keywords
		 */ 
		String strKeywords;
		strKeywords = reader.readLine();
		ArrayList<String> keywords = new ArrayList<String>(Arrays.asList(strKeywords.split(";")));
		livro.setKeyWords(keywords);
		
		/**
		 * Capitulos
		 */ 
		String strCapitulos;
		strCapitulos = reader.readLine();
		ArrayList<String> capitulos = new ArrayList<String>(Arrays.asList(strCapitulos.split(";")));
		livro.setCapitulos(capitulos);
	}
	//"Seta" Caracteristicas especiais 
	private static void lerAudioBook(AudioBook audioBook) throws Exception
	{
		lerLivro(audioBook);
	
		/**
		 * Duracao Audio
		 */ 
		String duracao;
		duracao = reader.readLine();
		audioBook.setDuracao(Float.parseFloat(duracao));
		
		/**
		 * Formato Audio
		 */ 
		String formato;
		formato = reader.readLine();
		audioBook.setFormato(formato);
	}
	
	private static void lerEletronico(Eletronico eletronico) throws Exception
	{
		lerLivro(eletronico);
	
		/**
		 * Url
		 */ 
		String url;
		url = reader.readLine();
		eletronico.setURL(url);
		
		/**
		 * Formato Audio
		 */ 
		String formato;
		formato = reader.readLine();
		eletronico.setFormato(formato);
	}
	
	private static void lerImpresso(Impresso impresso) throws Exception
	{
		lerLivro(impresso);
	
		/**
		 * Livrarias
		 */ 
		String strLivrarias;
		strLivrarias = reader.readLine();
		ArrayList<String> livrarias = new ArrayList<String>(Arrays.asList(strLivrarias.split(";")));
		impresso.setLivrarias(livrarias);
		
		/**
		 * Colunas
		 */
		String colunas;
		colunas = reader.readLine();
		impresso.setNumeroColunas(Integer.parseInt(colunas));
	}
}
