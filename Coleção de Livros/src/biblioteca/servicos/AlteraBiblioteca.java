package biblioteca.servicos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import biblioteca.modelo.Livro;

public class AlteraBiblioteca extends BaseDeDados {
	
	public static void Exec(ArrayList<Livro> livros, String []stringToda, int op,int tipo) {
		//Filtrar Comando
	
		if(op == 1) {//Adiconar
			criaArquivoLivro(stringToda,tipo);
			try {
				lerBaseDeDados();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		else { //Remover
			remove(stringToda,tipo);
			try {
				lerBaseDeDados();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	private static void remove(String[] stringToda, int tipo) {
		BufferedReader re = null;
		File file = new File("data/");
		int count = file.listFiles().length;
		int numeroDeletado = count;
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
			
			try {
				tipoLivro = Integer.parseInt(re.readLine());
				tituloLivro = re.readLine();
				AutoresLivro = re.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			try {
				re.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}	
			
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
				
		}
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

		try {
		    BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoArquivoPadrao));
		    
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
		    	
		    
	    	writer.close();	      
		    
	    } catch (IOException e) {
	      System.out.println("Erro de Abertura");
	      e.printStackTrace();
	    }
	}
}
