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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import biblioteca.modelo.Livro;

public class Tela extends JFrame {

	private static final long serialVersionUID = 1L;

	private static final int HEIGHT = 1000;
	private static final int WIDTH = 1200;
	
	/**
	 * Pesquisa em todas as colunas
	 */
	private JTextField txtPesquisa;
	
	/**
	 * Botões
	 */
	private JButton btnPesquisaEspecifica;
	private JButton btnPesquisaGeral;
	private JButton btnLimpar;
	
	/**
	 * Filtros de tipo de livro
	 */
	private JCheckBox cbxTipoAudioBook;
	private JCheckBox cbxTipoEletronico;
	private JCheckBox cbxTipoImpresso;
	
	/**
	 * Campos Gerais
	 */
	private JTextField txtNome;
	private JTextField txtEscritores;
	private JTextField txtAnoPublicacao;
	private JTextField txtIdioma;
	private JTextField txtKeywords;
	private JTextField txtCapitulo;
	
	/**
	 * Campos Específicos
	 */
	private JTextField txtLivrarias;
	private JTextField txtColunas;
	private JTextField txtURL;
	private JTextField txtFormatoEletronico;
	private JTextField txtDuracao;
	private JTextField txtFormatoAudioBook;
	
	/**
	 * Exibição dos resultados
	 */
	private ListagemPaginada listResultados;
	
	/**
	 * Panels
	 */
	private JPanel pnlPrincipal;
	private JPanel pnlPesquisa;
	private JPanel pnlFiltroPesquisaGeral;
	private JPanel pnlFiltroPesquisaEspecifica;
	private JPanel pnlFiltroTipoLivro;
	private JPanel pnlResultados;
	
	/**
	 * Lista contendo os livros fornecidos
	 */
	private ArrayList<Livro> listLivros;
	
	public Tela(ArrayList<Livro> livros) {
		
		listLivros = livros;
		
		pnlPrincipal = new JPanel();
		pnlPrincipal.setLayout(new FlowLayout());
		pnlPrincipal.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		
		initPanelPesquisa();
		initPanelFiltroPesquisaGeral();
		initPanelTipoLivro();
		initPanelFiltroPesquisaEspecifica();
		initPanelResultados();
		
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		add(pnlPrincipal);
		pack();
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

	}

	private void initPanelPesquisa() {
		pnlPesquisa = new JPanel();
		pnlPesquisa.setPreferredSize(new Dimension(WIDTH - 50, 100));
		pnlPesquisa.setLayout(new FlowLayout());
		pnlPesquisa.setBorder(BorderFactory.createTitledBorder("Pesquisar"));
		
		txtPesquisa = new JTextField("Ex.: 'Hobbit'");
		txtPesquisa.setPreferredSize(new Dimension(800, 50));
		txtPesquisa.setFont(new Font("ARIAL", Font.ITALIC, 26));
		pnlPesquisa.add(txtPesquisa);
		
		btnPesquisaEspecifica = new JButton("Pesquisar");
		btnPesquisaEspecifica.setPreferredSize(new Dimension(100, 50));
		//Add actionListeners 
		pnlPesquisa.add(btnPesquisaEspecifica);
		
		btnLimpar = new JButton("Limpar");
		btnLimpar.setPreferredSize(new Dimension(100, 50));
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparPesquisa();
			}
		});
		pnlPesquisa.add(btnLimpar);
		
		pnlPrincipal.add(pnlPesquisa);
	}
	
	private void initPanelFiltroPesquisaGeral() {
		pnlFiltroPesquisaGeral = new JPanel();
		pnlFiltroPesquisaGeral.setPreferredSize(new Dimension(WIDTH - 50, 100));
		pnlFiltroPesquisaGeral.setLayout(new GridLayout(2, 3));
		pnlFiltroPesquisaGeral.setBorder(BorderFactory.createTitledBorder("Filtros de Pesquisa"));
		
		/**
		 * Nome
		 */
		txtNome = new JTextField();
		JPanel pnlNome = getLabelxTextFieldPanel(txtNome, "Nome ");
		pnlFiltroPesquisaGeral.add(pnlNome);
		
		/**
		 * Escritores
		 */
		txtEscritores = new JTextField();
		JPanel pnlEscritores = getLabelxTextFieldPanel(txtEscritores, "Escritores ");
		pnlFiltroPesquisaGeral.add(pnlEscritores);
		
		/**
		 * Ano Publicacao 
		 */
		//Filtro de numeros
		txtAnoPublicacao = new JTextField();
		JPanel pnlAno = getLabelxTextFieldPanel(txtAnoPublicacao, "Ano ");
		pnlFiltroPesquisaGeral.add(pnlAno);
		
		/**
		 * Idioma
		 */
		txtIdioma = new JTextField();
		JPanel pnlIdioma = getLabelxTextFieldPanel(txtIdioma, "Idioma ");
		pnlFiltroPesquisaGeral.add(pnlIdioma);
		
		/**
		 * Keywords
		 */
		txtKeywords = new JTextField();
		JPanel pnlKeywords = getLabelxTextFieldPanel(txtKeywords, "Palavras-chave ");
		pnlFiltroPesquisaGeral.add(pnlKeywords);
		
		/**
		 * Capitulo
		 */
		txtCapitulo = new JTextField();
		JPanel pnlCapitulo = getLabelxTextFieldPanel(txtCapitulo, "Capitulos ");
		pnlFiltroPesquisaGeral.add(pnlCapitulo);
		
		pnlPrincipal.add(pnlFiltroPesquisaGeral);
	}
	
	private JPanel getLabelxTextFieldPanel(JTextField txtField, String nomeCampo) {
		JPanel jpanel = new JPanel();
		jpanel.setLayout(new FlowLayout());
		jpanel.setPreferredSize(new Dimension(350, 50));
		
		JLabel lbl = new JLabel(nomeCampo, SwingConstants.RIGHT);
		lbl.setPreferredSize(new Dimension(130, 30));
		jpanel.add(lbl);
		
		txtField.setPreferredSize(new Dimension(200, 30));
		jpanel.add(txtField);
		
		return jpanel;
	}
	
	private void initPanelTipoLivro() {
		pnlFiltroTipoLivro = new JPanel();
		pnlFiltroTipoLivro.setPreferredSize(new Dimension(200, 200));
		pnlFiltroTipoLivro.setLayout(new GridLayout(3, 1));
		pnlFiltroTipoLivro.setBorder(BorderFactory.createTitledBorder("Filtro por \"Tipo de Livro\""));
		
		cbxTipoAudioBook = new JCheckBox("AudioBooks");
		pnlFiltroTipoLivro.add(cbxTipoAudioBook);

		cbxTipoEletronico = new JCheckBox("Eletronicos");
		pnlFiltroTipoLivro.add(cbxTipoEletronico);
		
		cbxTipoImpresso = new JCheckBox("Impressos");
		pnlFiltroTipoLivro.add(cbxTipoImpresso);
		
		pnlPrincipal.add(pnlFiltroTipoLivro);
	}
	
	private void initPanelFiltroPesquisaEspecifica() {
 		pnlFiltroPesquisaEspecifica = new JPanel();
 		pnlFiltroPesquisaEspecifica.setPreferredSize(new Dimension(945, 200));
 		pnlFiltroPesquisaEspecifica.setLayout(new GridLayout(2, 3));
 		pnlFiltroPesquisaEspecifica.setBorder(BorderFactory.createTitledBorder("Filtros específicos por \"Tipo de Livro\""));
 		
 		/**
 		 * Livrarias
 		 */
 		txtLivrarias = new JTextField();
 		JPanel pnlLivrarias = getLabelxTextFieldPanel(txtLivrarias, "Livrarias ");
 		pnlFiltroPesquisaEspecifica.add(pnlLivrarias);

 		/**
		 * Colunas
		 */
		txtColunas = new JTextField();
		JPanel pnlColunas = getLabelxTextFieldPanel(txtColunas, "Colunas ");
		pnlFiltroPesquisaEspecifica.add(pnlColunas);
		
		/**
		 * URL
		 */
		txtURL = new JTextField();
		JPanel pnlURL = getLabelxTextFieldPanel(txtURL, "URL ");
		pnlFiltroPesquisaEspecifica.add(pnlURL);
		
		/**
		 * Formato Eletronico
		 */
		txtFormatoEletronico = new JTextField();
		JPanel pnlFormatoEletronico = getLabelxTextFieldPanel(txtFormatoEletronico, "Formato \"Eletronico\" ");
		pnlFiltroPesquisaEspecifica.add(pnlFormatoEletronico);
		
		/**
		 * Duracao
		 */
		txtDuracao = new JTextField();
		JPanel pnlDuracao = getLabelxTextFieldPanel(txtDuracao, "Duracao ");
		pnlFiltroPesquisaEspecifica.add(pnlDuracao);
		
		/**
		 * FormatoAudioBook
		 */
		txtFormatoAudioBook = new JTextField();
		JPanel pnlFormatoAudioBook = getLabelxTextFieldPanel(txtFormatoAudioBook, "Formato \"AudioBook\" ");
		pnlFiltroPesquisaEspecifica.add(pnlFormatoAudioBook);
		
		pnlPrincipal.add(pnlFiltroPesquisaEspecifica);
	}
	
	private void initPanelResultados() {
		pnlResultados = new JPanel();
		pnlResultados.setPreferredSize(new Dimension(WIDTH - 50, 500));
		pnlResultados.setLayout(new FlowLayout());
		pnlResultados.setBorder(BorderFactory.createTitledBorder("Resultados da Pesquisa"));
		
		listResultados = new ListagemPaginada(5, listLivros);
		pnlResultados.add(listResultados);
		
		pnlPrincipal.add(pnlResultados);
	}
	
	private void limparPesquisa() {
		/**
		 * Desselecionar os filtros de pesquisa
		 */
		cbxTipoAudioBook.setSelected(false);
		cbxTipoEletronico.setSelected(false);
		cbxTipoImpresso.setSelected(false);
		
		/**
		 * Remover textos de pesquisa
		 */
		txtPesquisa.setText("");
		txtNome.setText("");
		txtEscritores.setText("");
		txtAnoPublicacao.setText("");
		txtIdioma.setText("");
		txtKeywords.setText("");
		txtCapitulo.setText("");
		txtLivrarias.setText("");
		txtColunas.setText("");
		txtURL.setText("");
		txtFormatoEletronico.setText("");
		txtDuracao.setText("");
		txtFormatoAudioBook.setText("");
		
		/**
		 * TODO: Limpar tabela de resultados mostrando todos os registros
		 */
	}
}

