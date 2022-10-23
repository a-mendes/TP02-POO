package biblioteca.gui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import biblioteca.modelo.AudioBook;
import biblioteca.modelo.Eletronico;
import biblioteca.modelo.Impresso;
import biblioteca.modelo.Livro;

public class ListagemPaginada extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JButton btnNextPage;
	private JButton btnPrevPage;
	
	private JLabel lblCurrentPage;
	
	private JPanel pnlNavegacao;
	private JPanel pnlElementos;
	
	private ArrayList<JButton> listElementos;
	
	private int currentPage = 1;
	private int maxPage;
	
	private int qtdItensPagina;
	private ArrayList<Livro> listLivros;
	
	public ListagemPaginada(int qtdItensPagina, ArrayList<Livro> listLivros) {

		this.qtdItensPagina = (qtdItensPagina <= 0) ? (1) : (qtdItensPagina);
		this.listLivros = listLivros;
		int paginaIncompleta = (listLivros.size() % qtdItensPagina >= 1) ? (1) : (0);
		this.maxPage = listLivros.size() / qtdItensPagina + paginaIncompleta;
		
		
		setLayout(new FlowLayout()); 
		setPreferredSize(new Dimension(800, 500));
		
		initPnlElementos();
	}
	
	private void initPnlElementos() {
		pnlElementos = new JPanel(new GridLayout(qtdItensPagina, 1));
		pnlElementos.setPreferredSize(new Dimension(800, 400));
		
		listElementos = new ArrayList<JButton>();
		
		atualizarElementos();
	}
	
	private void atualizarElementos() {
		pnlElementos.removeAll();
		
		/**
		 * Recupera os livros a serem exibidos de acordo com a paginação
		 */
		for (int i = 0; i < qtdItensPagina; i++) {
			int indexLivro = i + (qtdItensPagina * (currentPage - 1));
			if(indexLivro >= listLivros.size())
				break;
			
			Livro livro = listLivros.get(indexLivro);
			
			Icon icon = new ImageIcon("res/Icons/PretoBranco/" + getIconLivro(livro));
			JButton btnElemento = new JButton(livro.getTitulo(), icon);
			btnElemento.setIconTextGap(50);
			btnElemento.setHorizontalAlignment(SwingConstants.LEFT);
			btnElemento.setFocusPainted(false);
			btnElemento.setContentAreaFilled(false);
			btnElemento.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new DetalhesLivroDialog(livro);
				}
			});
			
			listElementos.add(btnElemento);
			pnlElementos.add(btnElemento);
		}
		
		add(pnlElementos);
		if(pnlNavegacao != null)
			remove(pnlNavegacao);
		initPnlNavegacao();
	}
	
	private String getIconLivro(Livro livro) {
		if(livro.getClass().equals(AudioBook.class)) {
			return "audiobook.png";
		}
		
		if(livro.getClass().equals(Impresso.class)) {
			return "impresso.png";
		}
		
		if(livro.getClass().equals(Eletronico.class)) {
			return "eletronico.png";
		}
		
		return null;
	}
	
	private void initPnlNavegacao() {
		pnlNavegacao = new JPanel(new GridLayout(1, 3));
		pnlNavegacao.setPreferredSize(new Dimension(200, 40));
		
		btnPrevPage = new JButton("<");
		btnPrevPage.addActionListener((ActionEvent e) -> prevPage());
		pnlNavegacao.add(btnPrevPage);
		
		lblCurrentPage = new JLabel(String.valueOf(currentPage), SwingConstants.CENTER);
		pnlNavegacao.add(lblCurrentPage);
		
		btnNextPage = new JButton(">");
		btnNextPage.addActionListener((ActionEvent e) -> nextPage());
		pnlNavegacao.add(btnNextPage);
		
		/**
		 * Desativa o botao de prévia caso esteja na primeira pagina
		 */
		if(currentPage == 1)
			btnPrevPage.setEnabled(false);
		
		/**
		 * Desativa o botao de next caso esteja na ultima pagina
		 */
		if(currentPage == maxPage)
			btnNextPage.setEnabled(false);
		
		
		add(pnlNavegacao);
	}
	
	private void prevPage() {
		
		/**
		 * Remove os elementos da página atual
		 */
		remove(pnlElementos);
		
		/**
		 * Diminui valor da pagina atual
		 */
		
		currentPage--;
		lblCurrentPage.setText(String.valueOf(currentPage));
	
		/**
		 * Atualiza os componentes redesenhando o panel
		 */
		atualizarElementos();
		validate();
		repaint();
	}

	private void nextPage() {
		
		/**
		 * Remove os itens da página atual
		 */
		remove(pnlElementos);
		/**
		 * Aumenta valor da pagina atual
		 */
		currentPage++;
		lblCurrentPage.setText(String.valueOf(currentPage));
		
		/**
		 * Atualiza os componentes redesenhando o panel
		 */
		atualizarElementos();
		validate();
		repaint();
	}

}
