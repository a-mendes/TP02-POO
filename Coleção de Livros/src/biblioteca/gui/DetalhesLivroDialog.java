package biblioteca.gui;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import biblioteca.modelo.AudioBook;
import biblioteca.modelo.Eletronico;
import biblioteca.modelo.Impresso;
import biblioteca.modelo.Livro;

public class DetalhesLivroDialog extends JDialog {

	private static final long serialVersionUID = 1L;

	private JScrollPane scrollPane;
	
	public DetalhesLivroDialog(Livro livro) {
		setSize(700, 700);
        setLayout(new FlowLayout());
        setResizable(false);
        
        scrollPane = new JScrollPane();
        scrollPane.setPreferredSize(new Dimension(650, 640));
        scrollPane.setAutoscrolls(true);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(null);
        
        String content = ""; 
        if(livro.getClass().equals(AudioBook.class)) {
        	content = detalhesAudioBook((AudioBook) livro);
		}
		
		if(livro.getClass().equals(Impresso.class)) {
			content = detalhesImpresso((Impresso) livro);
		}
		
		if(livro.getClass().equals(Eletronico.class)) {
			content = detalhesEletronico((Eletronico) livro);
		}
		
		JLabel lblContent = new JLabel(content);
		if(getFont() != null)
			lblContent.setFont(getFont().deriveFont((float) 20));

		scrollPane.setViewportView(lblContent);
		
		getContentPane().add(scrollPane);
		
		setTitle("Detalhes do Livro");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

	}
	
	private String detalhesAudioBook(AudioBook audiobook) {
		String content = detalhesLivro(audiobook);
		
		/**
		 * Dura��o
		 */
		content += "<h1>Dura��o </h1> " + audiobook.getDuracao() + "<br/> <br/> <hr/>";
		
		/**
		 * Formato
		 */
		content += "<h1>Formato do arquivo </h1> " + audiobook.getFormato() + "<br/> <br/> <hr/>";
		
		return content;
	}
	
	private String detalhesImpresso(Impresso impresso) {
		String content = detalhesLivro(impresso);
		
		/**
		 * Numero de colunas
		 */
		content += "<h1>N�mero de Colunas </h1> " + impresso.getNumeroColunas() + "<br/> <br/> <hr/>";
		
		/**
		 * Livrarias
		 */
		content += "<h1>Livrarias </h1> "; 
		for (String livraria : impresso.getLivrarias()) {
			content += "-  " + livraria + "<br/>";
		}
		
		content += "<br/> <hr/>";
		return content;
	}
	
	private String detalhesEletronico(Eletronico eletronico) {
		String content = detalhesLivro(eletronico);
		
		/**
		 * URL
		 */
		content += "<h1>URL de acesso </h1> " + eletronico.getURL() + "<br/> <br/> <hr/>";
		
		/**
		 * Formato
		 */
		content += "<h1>Formato do arquivo </h1> " + eletronico.getFormato() + "<br/> <br/> <hr/>";
		
		
		return content;
	}
	
	private String detalhesLivro(Livro livro) {
		
		/**
		 * Usamos HTML para fazer a formata��o correta da String de exibi��o dos detalhes 
		 */
		String content = "<html><body>";
		
		/**
		 * T�tulo
		 */
		content += "<h1>T�tulo </h1> " + livro.getTitulo() + "<br/> <br/> <hr/>";
		
		/**
		 * Escritores
		 */
		content += "<h1>Escritores </h1> "; 
		for (String escritor : livro.getEscritores()) {
			content += "-  " + escritor + "<br/>";
		}
		
		content += "<br/> <hr/>";
		
		/**
		 * Ano Publica��o
		 */
		content += "<h1>Ano de Publica��o </h1> " + livro.getAnoDePublicacao() + "<br/> <br/> <hr/>";

		/**
		 * Idioma 
		 */
		content += "<h1>Idioma Original </h1> " + livro.getIdioma() + "<br/> <br/> <hr/>";
		
		/**
		 * Capitulos
		 */
		
		content += "<h1>Cap�tulos </h1> "; 
		for (String capitulo : livro.getCapitulos()) {
			content += "-  " + capitulo + "<br/>";
		}
		
		content += "<br/> <hr/>";
		
		/**
		 * Keywords
		 */
		
		content += "<h1>Palavras-Chave </h1> "; 
		for (String keyword : livro.getKeyWords()) {
			content += keyword + "; ";
		}
		
		content += "<br/> <br/> <hr/>";
		
		return content;
	}
}
