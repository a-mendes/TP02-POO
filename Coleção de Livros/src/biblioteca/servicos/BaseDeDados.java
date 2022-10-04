package ao.co.a2x.biblioteca.servicos;
import java.util.Vector;
import java.io.FileReader;
import java.util.Scanner;
import ao.co.a2x.biblioteca.modelo.Livro;
import ao.co.a2x.biblioteca.modelo.Impresso;
import ao.co.a2x.biblioteca.modelo.AudioBook;
import ao.co.a2x.biblioteca.modelo.Eletronico;

public class BaseDeDados {

	private Vector<Livro>livros;
	
	public BaseDeDados(){
		livros = new Vector<>();
	}
	public boolean criarLivro(Livro livro) {
		return livros.add(livro);
	}
	public void leBaseDeDados(Vector<Livro>livros) {

		for (int i = 0; i < 16; ++i)
		{
			String arquivo = "data/" + (i+1) + ".txt";
			Scanner in = new Scanner(new FileReader(arquivo));

			/** 
			 * Faz verificação de tipo de livro e cria instancia adequada
			 */ 

			String recebeTipo = in.nextLine();
			int tipoLivro = Integer.parseInt(recebeTipo);

			switch(tipoLivro)
			{
				/**
				 //Impresso
				 */ 
				case 1:
				{
					Impresso livro = new Impresso();
					lerImpresso(arquivo, livro);
					livros.add(livro);
				}
				break;

				/**
				 * Eletronico
				 */ 
				case 2:
				{
					Eletronico livro = new Eletronico();
					lerEletronico(arquivo, livro);
					livros.add(livro);
				}
				break;

				/**
				 * AudioBook
				 */ 
				case 3:
				{
					AudioBook livro = new AudioBook();
					lerAudioBook(arquivo, livro);
					livros.add(livro);
				}
				break;
			}
		}
	}
	

void lerLivro(FILE arquivo, Livro livro)
{
	/**
	 * Titulo
	 */ 
	String titulo;
	getline(arquivo, titulo);
	livro.setTitulo(titulo);

	/**
	 * Escritores
	 */ 
	String strEscritores;
	getline(arquivo, strEscritores);
	Vector<string> escritores;
	split(strEscritores, escritores, ';');
	livro->setEscritores(escritores);

	/**
	 * Ano
	 */ 
	string ano;
	getline(arquivo, ano);
	livro->setAnoPublicacao(stoi(ano));

	/**
	 * Idioma
	 */ 
	string idioma;
	getline(arquivo, idioma);
	livro->setIdiomaOriginal(idioma);

	/**
	 * Keywords
	 */ 
	string strKeywords;
	getline(arquivo, strKeywords);
	vector<string> keywords;
	split(strKeywords, keywords, ';');
	livro->setKeywords(keywords);
	
	/**
	 * Capitulos
	 */ 
	string strCapitulos;
	getline(arquivo, strCapitulos);
	vector<string> capitulos;
	split(strCapitulos, capitulos, ';');
	livro->setCapitulos(capitulos);
}

	
	
}

