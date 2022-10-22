package biblioteca.gui;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import biblioteca.modelo.Livro;

public class ListagemPaginada extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JButton btnNextPage;
	private JButton btnPrevPage;
	
	private JLabel lblCurrentPage;
	
	private JPanel pnlNavegacao;
	private JPanel pnlElementos;
	
	private ArrayList<Button> listElementos;
	
	private int currentPage = 1;
	private int maxPage;
	
	private int qtdItensPagina;
	private ArrayList<Livro> listLivros;
	
	public ListagemPaginada(int qtdItensPagina, ArrayList<Livro> listLivros) {

		this.qtdItensPagina = qtdItensPagina;
		this.listLivros = listLivros;
		this.maxPage = listLivros.size() / qtdItensPagina;
		
		
		setLayout(new FlowLayout()); 
		setPreferredSize(new Dimension(800, 600));
		
		
		
		initPnlNavegacao();
	}
	
	private void initPnlElementos() {
		pnlElementos = new JPanel(new GridLayout(qtdItensPagina, 3));
		pnlElementos.setPreferredSize(new Dimension(800, 500));
		
		for (int i = 0; i < qtdItensPagina; i++) {
			Livro livro = listLivros.get(i + (qtdItensPagina * (currentPage - 1)));
			Button btnElemento = new Button(livro.getTitulo());
			listElementos.add(btnElemento);
			pnlElementos.add(btnElemento);
		}
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
		
		add(pnlNavegacao);
	}
	
	private void prevPage() {
		/**
		 * Diminui valor da pagina atual
		 */
		currentPage--;
		lblCurrentPage.setText(String.valueOf(currentPage));
		
		/**
		 * Desativa o botao de prévia caso esteja na primeira pagina
		 */
		if(currentPage == 1)
			btnPrevPage.setEnabled(false);
		
		/**
		 * Força a ativação do botão de next 
		 */
		btnNextPage.setEnabled(true);
		
		/**
		 * Atualiza os componentes redesenhando o panel
		 */
		validate();
		repaint();
	}

	private void nextPage() {
		/**
		 * Aumenta valor da pagina atual
		 */
		currentPage++;
		lblCurrentPage.setText(String.valueOf(currentPage));
		
		/**
		 * Desativa o botao de next caso esteja na ultima pagina
		 */
		if(currentPage == maxPage)
			btnNextPage.setEnabled(false);
		
		/**
		 * Força a ativação do botão de prévia 
		 */
		btnPrevPage.setEnabled(true);
		
		/**
		 * Atualiza os componentes redesenhando o panel
		 */
		validate();
		repaint();
	}

}
