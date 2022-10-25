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
	
	public static void Exec(ArrayList<Livro> livros, String []stringToda, int itemSelecionado[],int tipo) {
		//Filtrar Comando
	
		if(itemSelecionado[0] == 1) {//Adiconar
			criaArquivoLivro(stringToda,tipo);
			try {
				lerBaseDeDados();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else { //Remover
			remove(stringToda,tipo);
			try {
				lerBaseDeDados();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	private static void remove(String[] stringToda, int tipo) {
		BufferedReader re = null;
		File file = new File("data/");
		int count = file.listFiles().length;
		
		for (int i = 0; i < count ; ++i)
		{
			String path = "data/" + (i+1) + ".txt";
			File arquivo = new File(path);
			try {
				re = new BufferedReader(new FileReader(arquivo.getPath()));
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}

			/** 
			 * Faz verificacao de tipo de livro e cria instancia adequada
			 */ 

			String strTipoLivro = null;
			try {
				strTipoLivro =re.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			int tipoLivro = Integer.parseInt(strTipoLivro);
			if(tipoLivro == tipo) {
				String titulo = null;
			    try {
					titulo = re.readLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(titulo == stringToda[0]) {
					String strEscritores = null;
					try {
						strEscritores = re.readLine();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if(strEscritores == stringToda[1]) {
						Path pathOfFile1
			            = Paths.get(path);
						try {
							Files.delete(pathOfFile1);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						return ;
					}
				}
			}
		}
		System.out.println("Arquivo Não Encontrado");
	}
	
	
	
	
	
	
	private static void criaArquivoLivro(String[] stringGeral,int tipo) {
		
		File file = new File("data/");
		int count = file.listFiles().length;
		
		String caminhoArquivoPadrao = "data/" + count+1 + ".txt";

		try {
		    BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoArquivoPadrao));
		    
		    if(tipo == 1)
		    	writer.write(1);
		    else if(tipo == 2)
		    	writer.write(2);
		    else 
		    	writer.write(3);
		    
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
		    	
		    
	    	writer.close();	      
		    
	    } catch (IOException e) {
	      System.out.println("Erro de Abertura");
	      e.printStackTrace();
	    }
	}
}
