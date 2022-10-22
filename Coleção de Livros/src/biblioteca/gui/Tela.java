package biblioteca.gui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import biblioteca.modelo.Livro;

public class Tela extends JFrame {

	private static final long serialVersionUID = 1L;

	private static final int HEIGHT = 900;
	private static final int WIDTH = 1200;
	
	private JTextField txtPesquisa;
	
	private JButton btnPesquisar;
	private JButton btnLimpar;
	
	private JCheckBox cbxTipoAudioBook;
	private JCheckBox cbxTipoEletronico;
	private JCheckBox cbxTipoImpresso;
	private JCheckBox cbxNome;
	private JCheckBox cbxEscritores;
	private JCheckBox cbxAnoPublicacao;
	private JCheckBox cbxIdioma;
	private JCheckBox cbxKeywords;
	private JCheckBox cbxLivraria;
	
	private ListagemPaginada listResultados;
	
	private JPanel pnlPrincipal;
	private JPanel pnlPesquisa;
	private JPanel pnlCheckBoxes;
	private JPanel pnlResultados;
	
	private ArrayList<Livro> listLivros;
	
	public Tela() {		

		pnlPrincipal = new JPanel();
		pnlPrincipal.setLayout(new FlowLayout());
		pnlPrincipal.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		
		initPanelPesquisa();
		initPanelCheckBoxes();
		initPanelResultados();
		
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		add(pnlPrincipal);
		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

	}
	
	public void setResultadoPesquisa(ArrayList<Livro> livros) {
		
	}

	private void initPanelPesquisa() {
		pnlPesquisa = new JPanel();
		pnlPesquisa.setPreferredSize(new Dimension(WIDTH - 50, 100));
		pnlPesquisa.setLayout(new FlowLayout());
		pnlPesquisa.setBorder(BorderFactory.createTitledBorder("Texto para pesquisar"));
		
		txtPesquisa = new JTextField("Ex.: 'Hobbit'");
		txtPesquisa.setPreferredSize(new Dimension(800, 50));
		txtPesquisa.setFont(new Font("ARIAL", Font.ITALIC, 26));
		pnlPesquisa.add(txtPesquisa);
		
		btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setPreferredSize(new Dimension(100, 50));
		//Add actionListeners 
		pnlPesquisa.add(btnPesquisar);
		
		pnlPrincipal.add(pnlPesquisa);
	}
	
	private void initPanelCheckBoxes() {
		pnlCheckBoxes = new JPanel();
		pnlCheckBoxes.setPreferredSize(new Dimension(WIDTH - 50, 100));
		pnlCheckBoxes.setLayout(new GridLayout(2, 5));
		pnlCheckBoxes.setBorder(BorderFactory.createTitledBorder("Filtros de Pesquisa"));
		
		cbxTipoAudioBook = new JCheckBox("Livros \"AudioBooks\"");
		pnlCheckBoxes.add(cbxTipoAudioBook);

		cbxTipoEletronico = new JCheckBox("Livros \"Eletronicos\"");
		pnlCheckBoxes.add(cbxTipoEletronico);
		
		cbxTipoImpresso = new JCheckBox("Livros \"Impressos\"");
		pnlCheckBoxes.add(cbxTipoImpresso);
		
		cbxNome = new JCheckBox("Nome");
		pnlCheckBoxes.add(cbxNome);
		
		cbxEscritores = new JCheckBox("Escritores");
		pnlCheckBoxes.add(cbxEscritores);
		
		cbxAnoPublicacao = new JCheckBox("Ano de Publicação");
		pnlCheckBoxes.add(cbxAnoPublicacao);
		
		cbxIdioma = new JCheckBox("Idioma");
		pnlCheckBoxes.add(cbxIdioma);

		cbxKeywords = new JCheckBox("Palavras-Chave");
		pnlCheckBoxes.add(cbxKeywords);
		
		cbxLivraria = new JCheckBox("Livrarias");
		pnlCheckBoxes.add(cbxLivraria);

		btnLimpar = new JButton("Limpar");
		btnLimpar.setMaximumSize(new Dimension(100, 50));
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparPesquisa();
			}
		});
		pnlCheckBoxes.add(btnLimpar);
		
		pnlPrincipal.add(pnlCheckBoxes);
	}
	
	private void initPanelResultados() {
		pnlResultados = new JPanel();
		pnlResultados.setPreferredSize(new Dimension(WIDTH - 50, 600));
		pnlResultados.setLayout(new FlowLayout());
		pnlResultados.setBorder(BorderFactory.createTitledBorder("Resultados da Pesquisa"));
		
		/*ArrayList<String> colunas = new ArrayList<>();
		colunas.toArray(new String[0]);
		colunas.add("Título");
		colunas.add("Escritores");
		colunas.add("Ano de Publicação");
		colunas.add("Idioma");
		colunas.add("Palavras-chave");
		colunas.add("Capitulos");*/
		
		/*listResultados = new ListagemPaginada(0, listLivros);
		pnlResultados.add(listResultados);*/
		
		pnlPrincipal.add(pnlResultados);
	}
	
	private void limparPesquisa() {
		/**
		 * Desselecionar os filtros de pesquisa
		 */
		cbxTipoAudioBook.setSelected(false);
		cbxTipoEletronico.setSelected(false);
		cbxTipoImpresso.setSelected(false);
		cbxNome.setSelected(false);
		cbxEscritores.setSelected(false);
		cbxAnoPublicacao.setSelected(false);
		cbxIdioma.setSelected(false);
		cbxKeywords.setSelected(false);
		cbxLivraria.setSelected(false);
		
		/**
		 * Remover textos de pesquisa
		 */
		txtPesquisa.setText("");
		
		/**
		 * TODO: Limpar tabela de resultados mostrando todos os registros
		 */
	}
}

