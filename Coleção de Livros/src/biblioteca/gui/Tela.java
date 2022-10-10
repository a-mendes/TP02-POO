package biblioteca.gui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Tela extends JFrame {

	private static final long serialVersionUID = 1L;

	private static final int HEIGHT = 900;
	private static final int WIDTH = 1200;
	
	private JTextField txtPesquisa;
	
	private JButton btnPesquisar;
	private JButton btnLimpar;
	
	private JCheckBox cbxTipo;
	private JCheckBox cbxNome;
	private JCheckBox cbxEscritores;
	private JCheckBox cbxAnoPublicacao;
	private JCheckBox cbxIdioma;
	private JCheckBox cbxKeywords;
	private JCheckBox cbxLivraria;
	
	private JPanel pnlPrincipal;
	private JPanel pnlPesquisa;
	private JPanel pnlCheckBoxes;
	//Tabela de Resultados private JPanel pnlResultados;
	
	public Tela() {		

		pnlPrincipal = new JPanel();
		pnlPrincipal.setLayout(new FlowLayout());
		pnlPrincipal.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		
		initPanelPesquisa(pnlPrincipal);
		initPanelCheckBoxes(pnlPrincipal);
		
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		add(pnlPrincipal);
		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

	}

	private void initPanelPesquisa(JPanel pnlPrincipal) {
		pnlPesquisa = new JPanel();
		pnlPesquisa.setPreferredSize(new Dimension(WIDTH - 50, 100));
		pnlPesquisa.setLayout(new FlowLayout());
		pnlPesquisa.setBorder(BorderFactory.createTitledBorder("Texto Pesquisa"));
		
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
	
	private void initPanelCheckBoxes(JPanel pnlPrincipal) {
		pnlCheckBoxes = new JPanel();
		pnlCheckBoxes.setPreferredSize(new Dimension(WIDTH - 50, 100));
		pnlCheckBoxes.setLayout(new GridLayout(2, 4));
		pnlCheckBoxes.setBorder(BorderFactory.createTitledBorder("Filtros de Pesquisa"));
		
		//Talvez precise adicionar os checkboxes a um buttonGroup

		cbxTipo = new JCheckBox("Tipo");
		pnlCheckBoxes.add(cbxTipo);
		
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
		//Add ActionListeners
		pnlCheckBoxes.add(btnLimpar);
		
		pnlPrincipal.add(pnlCheckBoxes);
	}
}

