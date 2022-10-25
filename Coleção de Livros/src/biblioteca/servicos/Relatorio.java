package biblioteca.servicos;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import biblioteca.modelo.AudioBook;
import biblioteca.modelo.Eletronico;
import biblioteca.modelo.Impresso;
import biblioteca.modelo.Livro;
import biblioteca.servicos.Relatorio;


public class Relatorio {
	
	
	public static void geradorRelatorio(ArrayList<Livro> livros, String[] stringGeral, int itemSelecionado[]){
		String caminhoArquivoPadrao = "relatorio.txt";

		try {
		    BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoArquivoPadrao));
		    writer.write("ESPECIFICAï¿½ï¿½ES DA PESQUISA\n");
		    
		    writer.write("Tipo: --------------- ");
		    if(itemSelecionado[0] == 1)
		    	writer.write("Impresso ");
		    if(itemSelecionado[1] == 1)
		    	writer.write("Eletronico ");
		    if(itemSelecionado[2] == 1)
		    	writer.write("AudioBook ");
		    
			writer.write("\n");
		    
		    if(itemSelecionado[3] == 1)
		    	writer.write("Nome: --------------- " + stringGeral[0] + "\n");
		    if(itemSelecionado[4] == 1)
		    	writer.write("Escritor: ----------- " + stringGeral[1] + "\n");
		    if(itemSelecionado[5] == 1)
		    	writer.write("Ano: ---------------- " + stringGeral[2] + "\n");
		    if(itemSelecionado[6] == 1)
		    	writer.write("Idioma: ------------- " + stringGeral[3] + "\n");
		    if(itemSelecionado[7] == 1)
		    	writer.write("Palavra Chave: ------ " + stringGeral[4] + "\n");
		    
		    
		    if(itemSelecionado[8] == 1)
		    	
		    	
		    	writer.write("Capitulo: ----------- " + stringGeral[5] + "\n");
		    if(itemSelecionado[9] == 1)
		    	writer.write("Livraria: ----------- " + stringGeral[6] + "\n");
		    if(itemSelecionado[10] == 1)
		    	writer.write("Colunas: ------------ " + stringGeral[7] + "\n");
		    if(itemSelecionado[11] == 1)
		    	writer.write("URL: ---------------- " + stringGeral[8] + "\n");
		    if(itemSelecionado[12] == 1)
		    	writer.write("Formato Texto: ------ " + stringGeral[9] + "\n");
		    if(itemSelecionado[13] == 1)
		    	writer.write("Duracao: ------------ " + stringGeral[10] + "\n");
		    if(itemSelecionado[14] == 1)
		    	writer.write("Formato Audio: ------ " + stringGeral[11] + "\n");
		    	
		    writer.write("\n\n------------------------------------------------------------------------------------\n\n");
		    
		    for(Livro elemento : livros) {
		    	 if(elemento instanceof Impresso) {
		    		 Impresso tmpImpresso = (Impresso)elemento;
		    		 writer.write(tmpImpresso.toString() + "\n\n");
		    	 }
		    	 if(elemento instanceof Eletronico) {
		    		 Eletronico tmpEletronico = (Eletronico)elemento;
		    		 writer.write(tmpEletronico.toString() + "\n\n");
		    	 }
		    	 if(elemento instanceof AudioBook) {
		    		 AudioBook tmpAudioBook = (AudioBook)elemento;
		    		 writer.write(tmpAudioBook.toString() + "\n\n");
		    	 }
		    	
		    }
		    
	    	writer.close();	      
		    
	    } catch (IOException e) {
	      System.out.println("Erro de Abertura");
	      e.printStackTrace();
	    }
			
		
	}
	
	public static void geradorRelatorioGeral(ArrayList<Livro> livros, String stringGeral, int itemSelecionado[]){
		String caminhoArquivoPadrao = "relatorio.txt";

		try {
		    BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoArquivoPadrao));
		    writer.write("ESPECIFICAÇÕES DA PESQUISA\n");
		    
		    writer.write("Tipo: --------------- ");
		    if(itemSelecionado[0] == 1)
		    	writer.write("Impresso ");
		    if(itemSelecionado[1] == 1)
		    	writer.write("Eletronico ");
		    if(itemSelecionado[2] == 1)
		    	writer.write("AudioBook ");
		    
			writer.write("\n");
		    
		    if(itemSelecionado[3] == 1)
		    	writer.write("Nome: --------------- " + stringGeral + "\n");
		    if(itemSelecionado[4] == 1)
		    	writer.write("Escritor: ----------- " + stringGeral + "\n");
		    if(itemSelecionado[5] == 1)
		    	writer.write("Ano: ---------------- " + stringGeral + "\n");
		    if(itemSelecionado[6] == 1)
		    	writer.write("Idioma: ------------- " + stringGeral + "\n");
		    if(itemSelecionado[7] == 1)
		    	writer.write("Palavra Chave: ------ " + stringGeral + "\n");
		    if(itemSelecionado[8] == 1)
		    	writer.write("Capitulo: ----------- " + stringGeral + "\n");
		    if(itemSelecionado[9] == 1)
		    	writer.write("Livraria: ----------- " + stringGeral + "\n");
		    if(itemSelecionado[10] == 1)
		    	writer.write("Colunas: ------------ " + stringGeral + "\n");
		    if(itemSelecionado[11] == 1)
		    	writer.write("URL: ---------------- " + stringGeral + "\n");
		    if(itemSelecionado[12] == 1)
		    	writer.write("Formato Texto: ------ " + stringGeral + "\n");
		    if(itemSelecionado[13] == 1)
		    	writer.write("Duracao: ------------ " + stringGeral + "\n");
		    if(itemSelecionado[14] == 1)
		    	writer.write("Formato Audio: ------ " + stringGeral + "\n");
		    	
		    writer.write("\n\n------------------------------------------------------------------------------------\n\n");
		    
		    for(Livro elemento : livros) {
		    	 if(elemento instanceof Impresso) {
		    		 Impresso tmpImpresso = (Impresso)elemento;
		    		 writer.write(tmpImpresso.toString() + "\n\n");
		    	 }
		    	 if(elemento instanceof Eletronico) {
		    		 Eletronico tmpEletronico = (Eletronico)elemento;
		    		 writer.write(tmpEletronico.toString() + "\n\n");
		    	 }
		    	 if(elemento instanceof AudioBook) {
		    		 AudioBook tmpAudioBook = (AudioBook)elemento;
		    		 writer.write(tmpAudioBook.toString() + "\n\n");
		    	 }
		    	
		    }
		    
	    	writer.close();	      
		    
	    } catch (IOException e) {
	      System.out.println("Erro de Abertura");
	      e.printStackTrace();
	    }
			
		
	}
	
}
