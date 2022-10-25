package biblioteca.servicos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

import biblioteca.modelo.AudioBook;
import biblioteca.modelo.Eletronico;
import biblioteca.modelo.Impresso;
import biblioteca.modelo.Livro;

public class AlteraBiblioteca extends BaseDeDados {
	//Função para testes 
	public static void testa(ArrayList<Livro> livros) {
//		String stringToda[] = new String[8];
//		stringToda[0] = "O Leao, a Feiticeira e o Guarda-Roupa 17";
//		stringToda[1] = "Clive Staples Lewis";
//		stringToda[2] = "1950";
//		stringToda[3] = "Ingles";
//		stringToda[4] = "romance;infantojuvenil;ficcao;narnia";
//		stringToda[5] = "Uma Estranha Descoberta;O Que Lucia Descobriu;Edmundo e o Guarda-Roupa;Manjar Turco;Outra Vez do Lado de Ca;Na Floresta;Um Dia com os Castores;Depois do Jantar;Na Casa da Feiticeira;O Encantamento Come�a a Quebrar-se;A Aproximacao de Aslam;A Primeira Batalha de Pedro;Magia Profunda na Aurora do Tempo;O Triunfo da Feiticeira;Magia Ainda Mais Profunda de Antes da Aurora do Tempo;O Que Aconteceu com as Estatuas;A Cacada ao Veado Branco";
//		stringToda[6] = "saraiva;leitura";
//		stringToda[7] = "1";
//		
//		Exec(livros, stringToda, 1, 1);
		
		String stringToda[] = new String[8];
		stringToda[0] = "Harry Potter e a Pedra Filosofal";
		stringToda[1] = "J. K. Rowling";
		stringToda[2] = "1950";
		stringToda[3] = "Ingles";
		stringToda[4] = "romance;infantojuvenil;ficcao;narnia";
		stringToda[5] = "Uma Estranha Descoberta;O Que Lucia Descobriu;Edmundo e o Guarda-Roupa;Manjar Turco;Outra Vez do Lado de Ca;Na Floresta;Um Dia com os Castores;Depois do Jantar;Na Casa da Feiticeira;O Encantamento Come�a a Quebrar-se;A Aproximacao de Aslam;A Primeira Batalha de Pedro;Magia Profunda na Aurora do Tempo;O Triunfo da Feiticeira;Magia Ainda Mais Profunda de Antes da Aurora do Tempo;O Que Aconteceu com as Estatuas;A Cacada ao Veado Branco";
		stringToda[6] = "saraiva;leitura";
		stringToda[7] = "1";
		
		Exec(livros, stringToda, 2, 1);
	}
	
	//Executa a ação de adicionar ou de remover livros 
	public static void Exec(ArrayList<Livro> livros, String []stringToda, int op,int tipo) {
		//Filtrar Comando
	
		if(op == 1) {//Adiconar
			criaArquivoLivro(stringToda,tipo); // Cria o arquivo com dados do livro
			try {
				lerBaseDeDados();// Reinicia Base de dados atualizada 
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		else { //Remover
			remove(stringToda,tipo); //Remove arquivo do livro
			try {
				lerBaseDeDados();//Reinicia Base de dados atualizada 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	private static void remove(String[] stringToda, int tipo) {
		//Leitor
		BufferedReader re = null;
		//Quantidade de arquivos 
		File file = new File("data/");
		int count = file.listFiles().length;
		//Variavel para saber qual arquivo será deletado
		int numeroDeletado = count;
		//Variavel para saber se encontrou o arquivo que deve ser deletado
		boolean encontrado = false;
		
		int tipoLivro = 0;
		String tituloLivro = null;
		String AutoresLivro = null;

		for (int i = 0; i < count ; ++i){
			
			String path = "data/" + (i+1) + ".txt";
			File arquivo = new File(path);
			try {
				re = new BufferedReader(new FileReader(arquivo.getPath()));
			} 
			catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
			//leitura de dados que serão usados para comparar 
			try {
				tipoLivro = Integer.parseInt(re.readLine());
				tituloLivro = re.readLine();
				AutoresLivro = re.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			//Fecha arquivo
			try {
				re.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}	
			//Caso seja compativel será excluido
			if(tipoLivro == tipo && stringToda[0].equals(tituloLivro) && stringToda[1].equals(AutoresLivro)) {
				encontrado = true;
				try {
					Files.deleteIfExists(Paths.get(path));
					numeroDeletado = i;
					break;
				}
				catch (Exception e) {
					e.printStackTrace();
		        }
				
			}
				
		}//Caso encontrado os arquivos posteriores serão renomeados para manter a ordem 
		if(encontrado) {
			for (int i = numeroDeletado+2; i <= count ; ++i) {
				String path = "data/" + (i) + ".txt";
				String pathNovo = "data/" + (i-1) + ".txt";
				
				try {
					File arquivo = new File(path);
					File arquivoNovo = new File(pathNovo);
					arquivo.renameTo(arquivoNovo);
				} 
				catch (Exception e1) {
					e1.printStackTrace();
				}
					
			}
			System.out.println("Arquivo Encontrado");
		}
		else 
			System.out.println("Arquivo Não Encontrado");
		
		
	}
	
	private static void criaArquivoLivro(String[] stringGeral,int tipo) {
		
		File file = new File("data/");
		int count = file.listFiles().length;
		int countPlus = count+1;
		
		String caminhoArquivoPadrao = "data/" + countPlus + ".txt";

		try {//Cria arquivo
		    BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoArquivoPadrao));
		    //Escreve dados  dados digitados pelo usuario 
		    if(tipo == 1)
		    	writer.write("1");
		    else if(tipo == 2)
		    	writer.write("2");
		    else 
		    	writer.write("3");
		    
			writer.write("\n");
		    
		    
	    	writer.write(stringGeral[0] + "\n");
	   
	    	writer.write(stringGeral[1] + "\n");
	   
	    	writer.write(stringGeral[2] + "\n");
	   
	    	writer.write(stringGeral[3] + "\n");
	   
	    	writer.write(stringGeral[4] + "\n");
	    
	    	writer.write(stringGeral[5] + "\n");
	    	
	    	if(tipo == 1){
	    		writer.write(stringGeral[6] + "\n");
	    		writer.write(stringGeral[7] + "\n");}
	    	
	    	else if(tipo == 2) {
	    		writer.write(stringGeral[8] + "\n");
	    		writer.write(stringGeral[9] + "\n");}
	    	else {
	    		writer.write(stringGeral[10] + "\n");
	    		writer.write(stringGeral[11] + "\n");}
		    	
		    
	    	writer.close();	      //Fecha arquivo
		    
	    } catch (IOException e) {
	      System.out.println("Erro de Abertura");
	      e.printStackTrace();
	    }
	}
}
