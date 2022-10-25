package biblioteca.gui;

import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import biblioteca.modelo.Livro;
import biblioteca.servicos.Filtragem;
import biblioteca.servicos.Relatorio;

public class Tela extends JFrame {

	private static final long serialVersionUID = 1L;

	private static final int HEIGHT = 1000;
	private static final int WIDTH = 1200;
	
	/**
	 * Pesquisa em todas as colunas
	 */
	private JTextField txtPesquisa;
	
	/**
	 * Botï¿½es
	 */
	private JButton btnPesquisa;
	private JButton btnRelatorio;
	private JButton btnLimpar;
	private JButton btnAjuda;
	
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
	 * Campos Especï¿½ficos
	 */
	private JTextField txtLivrarias;
	private JTextField txtColunas;
	private JTextField txtURL;
	private JTextField txtFormatoEletronico;
	private JTextField txtDuracao;
	private JTextField txtFormatoAudioBook;
	
	/**
	 * Exibicao dos resultados
	 */
	private ListagemPaginada listResultados;
	
	/**
	 * Panels
	 */
	private JPanel pnlPrincipal;
	private JPanel pnlPesquisa;
	private JPanel pnlFiltroPesquisaGeral;
	private JPanel pnlPesquisaEspecifica;
	private JPanel pnlFiltroPesquisaEspecifica;
	private JPanel pnlFiltroTipoLivro;
	private JPanel pnlResultados;
	
	/**
	 * Lista contendo os livros fornecidos
	 */
	private ArrayList<Livro> listLivrosOriginal;
	
	/**
	 * Lista contendo os Livros filtrados
	 */
	private ArrayList<Livro> listLivrosFiltro;
	
	public Tela(ArrayList<Livro> livros) {
        
		listLivrosOriginal = livros;
		listLivrosFiltro = listLivrosOriginal;

		/**
		 * Configuração de panels
		 */
		pnlPrincipal = new JPanel();
		pnlPrincipal.setLayout(new FlowLayout());
		pnlPrincipal.setPreferredSize(new Dimension(WIDTH-50, HEIGHT-50));
		
		initPanelPesquisa();
		initPanelFiltroPesquisaGeral();
		initPanelPesquisaEspecifica();
		initPanelResultados();
		
		/**
		 * Habilita barra de rolagem
		 */
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		scrollPane.setViewportView(pnlPrincipal);
		getContentPane().add(scrollPane);
		
		/**
		 * Configuraï¿½ï¿½es de exibiï¿½ï¿½o do JFrame
		 */
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

	}

	private void initPanelPesquisaEspecifica() {
		/**
		 * Configura o panel 
		 */
		pnlPesquisaEspecifica = new JPanel();
		initPanelTipoLivro();
		initPanelFiltroPesquisaEspecifica();
		pnlPrincipal.add(pnlPesquisaEspecifica);
		
	}

	private void initPanelPesquisa() {
		/**
		 * Configura o panel 
		 */
		pnlPesquisa = new JPanel();
		pnlPesquisa.setPreferredSize(new Dimension(WIDTH - 50, 100));
		pnlPesquisa.setLayout(new FlowLayout());
		pnlPesquisa.setBorder(BorderFactory.createTitledBorder("Pesquisar"));
		
		/**
		 * Configuracao de TextField para pesquisa geral
		 */
		txtPesquisa = new JTextField("Ex.: 'Hobbit'");
		txtPesquisa.setPreferredSize(new Dimension(600, 50));
		txtPesquisa.setFont(new Font("ARIAL", Font.ITALIC, 26));
		pnlPesquisa.add(txtPesquisa);
		
		/**
		 * Botao Pesquisa
		 */
		btnPesquisa = new JButton("Pesquisar");
		btnPesquisa.setPreferredSize(new Dimension(100, 50));
		btnPesquisa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doPesquisa();	
				validate();
				repaint();
			}
		});
		pnlPesquisa.add(btnPesquisa);
		
		/**
		 * Botao de Relatorio
		 */
		btnRelatorio = new JButton("Relatório");
		btnRelatorio.setPreferredSize(new Dimension(100, 50));
		btnRelatorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				emitirRelatorio();
				JOptionPane.showMessageDialog(null, "Relatorio gerado com sucesso no arquivo 'relatorio.txt'");
			}
		});
		pnlPesquisa.add(btnRelatorio);
		
		/**
		 * Botão Limpar
		 */
		btnLimpar = new JButton("Limpar");
		btnLimpar.setPreferredSize(new Dimension(100, 50));
		btnLimpar.addActionListener((ActionEvent e) -> limparPesquisa());
		pnlPesquisa.add(btnLimpar);
		
		/**
		 * Botão Ajuda
		 */
		Icon icon = new ImageIcon("res/Icons/ajuda.png");
		btnAjuda = new JButton("Ajuda", icon);
		btnAjuda.setPreferredSize(new Dimension(100, 50));
		btnAjuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
				    try {
				    	//TODO set url 
						Desktop.getDesktop().browse(new URI("http://www.google.com"));
					} catch (IOException|URISyntaxException e1) {
						e1.printStackTrace();
					} 
				}
			}
		});
		pnlPesquisa.add(btnAjuda);
		
		pnlPrincipal.add(pnlPesquisa);
	}
	
	private void initPanelFiltroPesquisaGeral() {
		/**
		 * Configura o panel 
		 */
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
		 * Ano Publicacao (apenas inteiros)
		 */

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

	/**
	 * Realiza o dimensionamento dos campos de texto com relação as labels
	 * @param txtField - campo de texto
	 * @param nomeCampo - label correpondente ao campo
	 * @return Jpanel com o dimensionamento correto
	 */
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
		/**
		 * Configura o panel 
		 */
		pnlFiltroTipoLivro = new JPanel();
		pnlFiltroTipoLivro.setPreferredSize(new Dimension(200, 200));
		pnlFiltroTipoLivro.setLayout(new GridLayout(3, 1));
		pnlFiltroTipoLivro.setBorder(BorderFactory.createTitledBorder("Filtro por \"Tipo de Livro\""));
		
		/**
		 * Checkboxes para tipo de livro
		 */
		cbxTipoAudioBook = new JCheckBox("AudioBooks");
		pnlFiltroTipoLivro.add(cbxTipoAudioBook);

		cbxTipoEletronico = new JCheckBox("Eletronicos");
		pnlFiltroTipoLivro.add(cbxTipoEletronico);
		
		cbxTipoImpresso = new JCheckBox("Impressos");
		pnlFiltroTipoLivro.add(cbxTipoImpresso);
		
		pnlPesquisaEspecifica.add(pnlFiltroTipoLivro);
	}
	
	
	private void initPanelFiltroPesquisaEspecifica() {
		/**
		 * Configura o panel 
		 */
 		pnlFiltroPesquisaEspecifica = new JPanel();
 		pnlFiltroPesquisaEspecifica.setPreferredSize(new Dimension(945, 200));
 		pnlFiltroPesquisaEspecifica.setLayout(new GridLayout(1, 3));
 		pnlFiltroPesquisaEspecifica.setBorder(BorderFactory.createTitledBorder("Filtros especificos por \"Tipo de Livro\""));
 		
 		/*****
 		 * 
 		 * Livros Impressos
 		 * 
 		 *****/
 		
 		JPanel pnlFiltroImpresso = new JPanel();
 		pnlFiltroImpresso.setPreferredSize(new Dimension(300, 180));
 		pnlFiltroImpresso.setLayout(new GridLayout(2, 1));
 		pnlFiltroImpresso.setBorder(BorderFactory.createTitledBorder("Impresso"));
 		
 		/**
 		 * Livrarias
 		 */
 		txtLivrarias = new JTextField();
 		JPanel pnlLivrarias = getLabelxTextFieldPanel(txtLivrarias, "Livrarias ");
 		pnlFiltroImpresso.add(pnlLivrarias);

 		/**
		 * Colunas (apenas inteiros)
		 */
		txtColunas = new JTextField();
		JPanel pnlColunas = getLabelxTextFieldPanel(txtColunas, "Colunas ");
		pnlFiltroImpresso.add(pnlColunas);
		
		pnlFiltroPesquisaEspecifica.add(pnlFiltroImpresso);
		
		/*****
 		 * 
 		 * Livros Eletronicos
 		 * 
 		 *****/
		JPanel pnlFiltroEletronico = new JPanel();
		pnlFiltroEletronico.setPreferredSize(new Dimension(300, 180));
		pnlFiltroEletronico.setLayout(new GridLayout(2, 1));
		pnlFiltroEletronico.setBorder(BorderFactory.createTitledBorder("Eletronico"));
 		
		/**
		 * URL
		 */
		txtURL = new JTextField();
		JPanel pnlURL = getLabelxTextFieldPanel(txtURL, "URL ");
		pnlFiltroEletronico.add(pnlURL);
		
		/**
		 * Formato Eletronico
		 */
		txtFormatoEletronico = new JTextField();
		JPanel pnlFormatoEletronico = getLabelxTextFieldPanel(txtFormatoEletronico, "Formato \"Eletronico\" ");
		pnlFiltroEletronico.add(pnlFormatoEletronico);
		
		pnlFiltroPesquisaEspecifica.add(pnlFiltroEletronico);
		
		
		/*****
 		 * 
 		 * Livros AudioBooks
 		 * 
 		 *****/
		JPanel pnlFiltroAudioBook = new JPanel();
		pnlFiltroAudioBook.setPreferredSize(new Dimension(300, 180));
		pnlFiltroAudioBook.setLayout(new GridLayout(2, 1));
		pnlFiltroAudioBook.setBorder(BorderFactory.createTitledBorder("AudioBook"));
		
		/**
		 * Duracao (numeros decimais)
		 */
		txtDuracao = new JTextField();
		JPanel pnlDuracao = getLabelxTextFieldPanel(txtDuracao, "Duracao ");
		pnlFiltroAudioBook.add(pnlDuracao);
		
		/**
		 * FormatoAudioBook
		 */
		txtFormatoAudioBook = new JTextField();
		JPanel pnlFormatoAudioBook = getLabelxTextFieldPanel(txtFormatoAudioBook, "Formato \"AudioBook\" ");
		pnlFiltroAudioBook.add(pnlFormatoAudioBook);
		
		pnlFiltroPesquisaEspecifica.add(pnlFiltroAudioBook);
		
		pnlPesquisaEspecifica.add(pnlFiltroPesquisaEspecifica);
	}
	
	private void initPanelResultados() {
		/**
		 * Configura o panel 
		 */
		pnlResultados = new JPanel();
		pnlResultados.setPreferredSize(new Dimension(WIDTH - 50, 500));
		pnlResultados.setLayout(new FlowLayout());
		pnlResultados.setBorder(BorderFactory.createTitledBorder("Resultados da Pesquisa"));
		
		/**
		 * Lista de resultados
		 */
		listResultados = new ListagemPaginada(5, listLivrosFiltro);
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
	}
	
	private void emitirRelatorio() {
		/**
		 * Lista de campos a serem pesquisados
		 */
		int itemSelecionado[] = getIndicesFiltrados();

		char tipoPesquisa = doPesquisa();
		
		/**
		 * Relatorios diferentes de acordo com a pesquisa
		 * E - pesquisa Específica
		 * G - pesquisa Geral
		 */
		if(tipoPesquisa == 'E') {
			String[] stringGeral = getStringFiltros();
			Relatorio.geradorRelatorio(listLivrosFiltro, stringGeral, itemSelecionado);

		}
		else {
			Relatorio.geradorRelatorioGeral(listLivrosFiltro, txtPesquisa.getText(), itemSelecionado);
		}
			
	}
	
	/**
	 * 
	 * @return char - tipo de pesquisa feita
	 */
	private char doPesquisa() {
		int itemSelecionado[] = getIndicesFiltrados();
	
		/**
		 * Valida as escolhas do usuário de modo a evitar erros 
		 * e problemas de uso.
		 */
		if(itemSelecionado[0] == 0 && itemSelecionado[1] == 0 && itemSelecionado[2] == 0) {
			itemSelecionado[0] = 1; 
			itemSelecionado[1] = 1;
			itemSelecionado[2] = 1;
			JOptionPane.showMessageDialog(null, "Nenhum tipo Marcado. Todos foram marcados internamente");
		}
		
		if((itemSelecionado[0] == 0) && (itemSelecionado[9] == 1 || itemSelecionado[10] == 1)) {
			itemSelecionado[9] = 0;
			itemSelecionado[10] = 0;
			JOptionPane.showMessageDialog(null, "Itens especificos de tipo \"IMPRESSO\" informados sem marcar tipo \"IMPRESSO\". \nItens foram desmarcados internamente");
		}
		if((itemSelecionado[1] == 0) && (itemSelecionado[11] == 1 || itemSelecionado[12] == 1)) {
			itemSelecionado[11] = 0;
			itemSelecionado[12] = 0;
			JOptionPane.showMessageDialog(null, "Itens especificos de tipo \"ELETRONICO\" digitados sem marcar tipo \"ELETRONICO\". \nItens foram desmarcados internamente");
		}
		if((itemSelecionado[2] == 0) && (itemSelecionado[13] == 1 || itemSelecionado[14] == 1)) {
			itemSelecionado[13] = 0;
			itemSelecionado[14] = 0;
			JOptionPane.showMessageDialog(null, "Itens especificos de tipo \"AudioBook\" digitados sem marcar tipo \"AudioBook\". \nItens foram desmarcados internamente");
		}


		
		boolean todosNulos = true;
		for(int i = 3; i < itemSelecionado.length; i++) {
			if(itemSelecionado[i] == 1) {
				todosNulos = false;
				break;
			}
		}

		/**
		 * Se nenhum campo foi preenchido, realiza-se uma pesquisa geral
		 */
		if(todosNulos) {
			String filtro = txtPesquisa.getText();
			for(int i = 3; i < itemSelecionado.length; i++)
				itemSelecionado[i] = 1;
		
			validaNumeros(itemSelecionado, filtro);
			listLivrosFiltro = Filtragem.pesquisaGeral(listLivrosOriginal, filtro, itemSelecionado);
			listResultados.setListLivros(listLivrosFiltro);
			
			return 'G';
		}
		
		String[] stringGeral = getStringFiltros();
		validaNumeros(itemSelecionado, stringGeral);
		listLivrosFiltro = Filtragem.pesquisaEspecifica(listLivrosOriginal, stringGeral, itemSelecionado);
		listResultados.setListLivros(listLivrosFiltro);
			
		return 'E';
	}
	
	private String[] getStringFiltros() {
		/**
		 * Cria um vetor indicando com os valores dos campos a serem pesquisados
		 */
		String[] stringGeral = new String[12];
				 stringGeral[0] = txtNome.getText();
				 stringGeral[1] = txtEscritores.getText();
				 stringGeral[2] = txtAnoPublicacao.getText();
				 stringGeral[3] = txtIdioma.getText();
				 stringGeral[4] = txtKeywords.getText();
				 stringGeral[5] = txtCapitulo.getText();
				 stringGeral[6] = txtLivrarias.getText();
				 stringGeral[7] = txtColunas.getText();
				 stringGeral[8] = txtURL.getText();
				 stringGeral[9] = txtFormatoEletronico.getText();
				 stringGeral[10] = txtDuracao.getText();
				 stringGeral[11] = txtFormatoAudioBook.getText();
	
		return stringGeral;
	}
	
	private int[] getIndicesFiltrados() {

		/**
		 * Cria um vetor indicando com "1" os campos a serem pesquisados e 0
		 * campos a ignorar
		 */
		int[] itemSelecionado = new int[15];
			itemSelecionado[0] = (cbxTipoImpresso.isSelected()) ? (1) : (0);
			itemSelecionado[1] = (cbxTipoEletronico.isSelected()) ? (1) : (0);
			itemSelecionado[2] = (cbxTipoAudioBook.isSelected()) ? (1) : (0);
			itemSelecionado[3] = (!txtNome.getText().isEmpty())? (1) : (0);
			itemSelecionado[4] = (!txtEscritores.getText().isEmpty())? (1) : (0);
			itemSelecionado[5] = (!txtAnoPublicacao.getText().isEmpty())? (1) : (0);
			itemSelecionado[6] = (!txtIdioma.getText().isEmpty())? (1) : (0);
			itemSelecionado[7] = (!txtKeywords.getText().isEmpty())? (1) : (0);
			itemSelecionado[8] = (!txtCapitulo.getText().isEmpty())? (1) : (0);
			itemSelecionado[9] = (!txtLivrarias.getText().isEmpty())? (1) : (0);
			itemSelecionado[10] = (!txtColunas.getText().isEmpty())? (1) : (0);
			itemSelecionado[11] = (!txtURL.getText().isEmpty())? (1) : (0);
			itemSelecionado[12] = (!txtFormatoEletronico.getText().isEmpty())? (1) : (0);
			itemSelecionado[13] = (!txtDuracao.getText().isEmpty())? (1) : (0);
			itemSelecionado[14] = (!txtFormatoAudioBook.getText().isEmpty())? (1) : (0);
		
		/**
		 * Se nenhum tipo de livro for selecionado, todos serão pesquisados
		 */
		if(itemSelecionado[0] == 0 && itemSelecionado[1] == 0 && itemSelecionado[2] == 0) {
			itemSelecionado[0] = 1; 
			itemSelecionado[1] = 1;
			itemSelecionado[2] = 1;
		}
			
		return itemSelecionado;
	}

	/**
	 * Tenta converter a string de pesquisa geral para numero, se falhar, inabilita 
	 * as pesquisas para os campos numericos
	 * 
	 * @param itemSelecionado
	 * @param stringGeral
	 */
	private void validaNumeros(int itemSelecionado[], String stringGeral) {
		
		try {
			if(itemSelecionado[5] == 1 || itemSelecionado[10] == 1 || itemSelecionado[13] == 1)
				Integer.parseInt(stringGeral);
		}
		catch (Exception x) {
			itemSelecionado[5] = 0;
			itemSelecionado[10] = 0;
			itemSelecionado[13] = 0;
		}
	}
	
private void validaNumeros(int itemSelecionado[], String[] stringGeral) {
		
		try {
			if(itemSelecionado[5] == 1)
				Integer.parseInt(stringGeral[2]);
			}
			catch (Exception x) {
				itemSelecionado[5] = 0;
				JOptionPane.showMessageDialog(null, "Alguns dos valores informados não correspondem ao tipo esperado, portanto, foram ignorados na pesquisa");
			}
			
		try {
			if(itemSelecionado[10] == 1)
				Integer.parseInt(stringGeral[7]);
			}
		catch (Exception x) {
				itemSelecionado[10] = 0;
				JOptionPane.showMessageDialog(null, "Alguns dos valores informados não correspondem ao tipo esperado, portanto, foram ignorados na pesquisa");
			}
		
		try {
			if(itemSelecionado[13] == 1)
				Integer.parseInt(stringGeral[10]);
		}
		catch (Exception x) {
			itemSelecionado[13] = 0;
			JOptionPane.showMessageDialog(null, "Alguns dos valores informados não correspondem ao tipo esperado, portanto, foram ignorados na pesquisa");
		}
	}
}

