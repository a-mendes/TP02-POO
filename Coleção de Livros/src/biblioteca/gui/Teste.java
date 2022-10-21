/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package biblioteca.gui;


/**
 *
 * @author mateu
 */
public class Teste extends javax.swing.JFrame {

    /**
     * Creates new form Teste
     */
    public Teste() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton4 = new javax.swing.JButton();
        jInternalFrame4 = new javax.swing.JInternalFrame();
        limparFiltros = new javax.swing.JButton();
        RelatorioGeral = new javax.swing.JButton();
        relatorioEspecifico = new javax.swing.JButton();
        escolhaTipo = new javax.swing.JInternalFrame();
        checkImpresso = new javax.swing.JCheckBox();
        checkEletronico = new javax.swing.JCheckBox();
        checkAudioBook = new javax.swing.JCheckBox();
        labelTipo = new javax.swing.JLabel();
        escolhaEspecifica = new javax.swing.JInternalFrame();
        checkLivrarias = new javax.swing.JCheckBox();
        checkColunas = new javax.swing.JCheckBox();
        checkURL = new javax.swing.JCheckBox();
        checkFormatoTexto = new javax.swing.JCheckBox();
        checkDuracao = new javax.swing.JCheckBox();
        checkFormatoAudio = new javax.swing.JCheckBox();
        labelEspecifica = new javax.swing.JLabel();
        textoLivraria = new javax.swing.JTextField();
        textoColuna = new javax.swing.JTextField();
        textoFormatoTexto = new javax.swing.JTextField();
        textoDuracao = new javax.swing.JTextField();
        textoFormatoAudio = new javax.swing.JTextField();
        textoURL = new javax.swing.JTextField();
        escolhaGeral = new javax.swing.JInternalFrame();
        checkNome = new javax.swing.JCheckBox();
        checkEscritores = new javax.swing.JCheckBox();
        checkAno = new javax.swing.JCheckBox();
        checkIdioma = new javax.swing.JCheckBox();
        checkPalavra = new javax.swing.JCheckBox();
        checkCapitulos = new javax.swing.JCheckBox();
        labelGeral = new javax.swing.JLabel();
        textoNome = new javax.swing.JTextField();
        textoIdioma = new javax.swing.JTextField();
        textoEscritor = new javax.swing.JTextField();
        textoAno = new javax.swing.JTextField();
        textoPalavra = new javax.swing.JTextField();
        jTextField24 = new javax.swing.JTextField();
        textoPesquisaGeral = new javax.swing.JTextField();
        pesquisaGeral = new javax.swing.JButton();
        pesquisaEspecifica = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton4.setText("Ajuda");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jInternalFrame4.setVisible(true);

        limparFiltros.setText("Limpar");
        limparFiltros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limparFiltrosActionPerformed(evt);
            }
        });

        RelatorioGeral.setText("Relatorio");
        RelatorioGeral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioGeralActionPerformed(evt);
            }
        });

        relatorioEspecifico.setText("Relatorio");
        relatorioEspecifico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                relatorioEspecificoActionPerformed(evt);
            }
        });

        escolhaTipo.setVisible(true);

        checkImpresso.setText("Impresso");
        checkImpresso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkImpressoActionPerformed(evt);
            }
        });

        checkEletronico.setText("Eletronico");
        checkEletronico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkEletronicoActionPerformed(evt);
            }
        });

        checkAudioBook.setText("Audio-Book");
        checkAudioBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkAudioBookActionPerformed(evt);
            }
        });

        labelTipo.setText("Tipo");

        javax.swing.GroupLayout escolhaTipoLayout = new javax.swing.GroupLayout(escolhaTipo.getContentPane());
        escolhaTipo.getContentPane().setLayout(escolhaTipoLayout);
        escolhaTipoLayout.setHorizontalGroup(
            escolhaTipoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(escolhaTipoLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(escolhaTipoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkEletronico)
                    .addComponent(checkImpresso)
                    .addComponent(labelTipo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, escolhaTipoLayout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(checkAudioBook)
                .addContainerGap())
        );
        escolhaTipoLayout.setVerticalGroup(
            escolhaTipoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(escolhaTipoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTipo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(checkImpresso)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(checkEletronico)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(checkAudioBook)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        escolhaEspecifica.setVisible(true);

        checkLivrarias.setText("Livrarias");
        checkLivrarias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkLivrariasActionPerformed(evt);
            }
        });

        checkColunas.setText("Colunas");
        checkColunas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkColunasActionPerformed(evt);
            }
        });

        checkURL.setText("URL");
        checkURL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkURLActionPerformed(evt);
            }
        });

        checkFormatoTexto.setText("Formato Texto");
        checkFormatoTexto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkFormatoTextoActionPerformed(evt);
            }
        });

        checkDuracao.setText("Duração");
        checkDuracao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkDuracaoActionPerformed(evt);
            }
        });

        checkFormatoAudio.setText("Foramto Audio");
        checkFormatoAudio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkFormatoAudioActionPerformed(evt);
            }
        });

        labelEspecifica.setText("Coisas Específicas");

        javax.swing.GroupLayout escolhaEspecificaLayout = new javax.swing.GroupLayout(escolhaEspecifica.getContentPane());
        escolhaEspecifica.getContentPane().setLayout(escolhaEspecificaLayout);
        escolhaEspecificaLayout.setHorizontalGroup(
            escolhaEspecificaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(escolhaEspecificaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(escolhaEspecificaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkColunas)
                    .addComponent(checkLivrarias)
                    .addComponent(labelEspecifica)
                    .addComponent(checkURL)
                    .addComponent(checkDuracao)
                    .addComponent(checkFormatoAudio)
                    .addComponent(checkFormatoTexto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(escolhaEspecificaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textoColuna, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textoLivraria, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textoFormatoTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textoDuracao, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textoFormatoAudio, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textoURL, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        escolhaEspecificaLayout.setVerticalGroup(
            escolhaEspecificaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(escolhaEspecificaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelEspecifica)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(escolhaEspecificaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkLivrarias)
                    .addComponent(textoLivraria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(escolhaEspecificaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkColunas)
                    .addComponent(textoColuna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(escolhaEspecificaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkURL)
                    .addComponent(textoURL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(escolhaEspecificaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(escolhaEspecificaLayout.createSequentialGroup()
                        .addComponent(checkFormatoTexto)
                        .addGap(24, 24, 24)
                        .addGroup(escolhaEspecificaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(checkDuracao)
                            .addComponent(textoDuracao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(escolhaEspecificaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(checkFormatoAudio)
                            .addComponent(textoFormatoAudio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(textoFormatoTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        escolhaGeral.setVisible(true);

        checkNome.setText("Nome");
        checkNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkNomeActionPerformed(evt);
            }
        });

        checkEscritores.setText("Escritores");
        checkEscritores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkEscritoresActionPerformed(evt);
            }
        });

        checkAno.setText("Ano");
        checkAno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkAnoActionPerformed(evt);
            }
        });

        checkIdioma.setText("Idioma");
        checkIdioma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkIdiomaActionPerformed(evt);
            }
        });

        checkPalavra.setText("Palavra-Chave");
        checkPalavra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkPalavraActionPerformed(evt);
            }
        });

        checkCapitulos.setText("Capitulos");
        checkCapitulos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkCapitulosActionPerformed(evt);
            }
        });

        labelGeral.setText("Coisas Gerais");

        textoNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textoNomeActionPerformed(evt);
            }
        });

        textoIdioma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textoIdiomaActionPerformed(evt);
            }
        });

        textoEscritor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textoEscritorActionPerformed(evt);
            }
        });

        textoAno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textoAnoActionPerformed(evt);
            }
        });

        textoPalavra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textoPalavraActionPerformed(evt);
            }
        });

        jTextField24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField24ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout escolhaGeralLayout = new javax.swing.GroupLayout(escolhaGeral.getContentPane());
        escolhaGeral.getContentPane().setLayout(escolhaGeralLayout);
        escolhaGeralLayout.setHorizontalGroup(
            escolhaGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(escolhaGeralLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(escolhaGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(escolhaGeralLayout.createSequentialGroup()
                        .addGroup(escolhaGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(checkEscritores)
                            .addComponent(labelGeral)
                            .addComponent(checkAno))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(escolhaGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textoEscritor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textoAno, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(escolhaGeralLayout.createSequentialGroup()
                        .addComponent(checkNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(textoNome, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(escolhaGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, escolhaGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(escolhaGeralLayout.createSequentialGroup()
                            .addComponent(checkCapitulos)
                            .addGap(32, 32, 32))
                        .addGroup(escolhaGeralLayout.createSequentialGroup()
                            .addComponent(checkIdioma)
                            .addGap(45, 45, 45)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, escolhaGeralLayout.createSequentialGroup()
                        .addComponent(checkPalavra)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(escolhaGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textoIdioma, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textoPalavra, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField24, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        escolhaGeralLayout.setVerticalGroup(
            escolhaGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(escolhaGeralLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(labelGeral)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(escolhaGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(escolhaGeralLayout.createSequentialGroup()
                        .addGroup(escolhaGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(checkNome)
                            .addComponent(textoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(escolhaGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(checkEscritores)
                            .addComponent(textoEscritor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(escolhaGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(checkAno)
                            .addComponent(textoAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(escolhaGeralLayout.createSequentialGroup()
                        .addGroup(escolhaGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(escolhaGeralLayout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(checkIdioma))
                            .addGroup(escolhaGeralLayout.createSequentialGroup()
                                .addComponent(textoIdioma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(escolhaGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(checkPalavra)
                                    .addComponent(textoPalavra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(escolhaGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(escolhaGeralLayout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(checkCapitulos))
                            .addGroup(escolhaGeralLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        textoPesquisaGeral.setText("Ex Hobbit");
        textoPesquisaGeral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textoPesquisaGeralActionPerformed(evt);
            }
        });

        pesquisaGeral.setText("Geral");
        pesquisaGeral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesquisaGeralActionPerformed(evt);
            }
        });

        pesquisaEspecifica.setText("Especifica");

        javax.swing.GroupLayout jInternalFrame4Layout = new javax.swing.GroupLayout(jInternalFrame4.getContentPane());
        jInternalFrame4.getContentPane().setLayout(jInternalFrame4Layout);
        jInternalFrame4Layout.setHorizontalGroup(
            jInternalFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame4Layout.createSequentialGroup()
                        .addComponent(escolhaTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(escolhaEspecifica))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(limparFiltros))
                    .addGroup(jInternalFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jInternalFrame4Layout.createSequentialGroup()
                            .addComponent(textoPesquisaGeral, javax.swing.GroupLayout.PREFERRED_SIZE, 615, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jInternalFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(pesquisaGeral)
                                .addComponent(RelatorioGeral))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jInternalFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(pesquisaEspecifica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(relatorioEspecifico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(escolhaGeral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(23, 23, 23))
        );
        jInternalFrame4Layout.setVerticalGroup(
            jInternalFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame4Layout.createSequentialGroup()
                .addGroup(jInternalFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame4Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(textoPesquisaGeral, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jInternalFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame4Layout.createSequentialGroup()
                                .addComponent(RelatorioGeral)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pesquisaGeral))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame4Layout.createSequentialGroup()
                                .addComponent(relatorioEspecifico)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pesquisaEspecifica)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(escolhaGeral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jInternalFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(escolhaTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(escolhaEspecifica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(limparFiltros)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 846, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jInternalFrame4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jInternalFrame4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4)
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void pesquisaGeralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisaGeralActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pesquisaGeralActionPerformed

    private void textoPesquisaGeralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textoPesquisaGeralActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textoPesquisaGeralActionPerformed

    private void jTextField24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField24ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField24ActionPerformed

    private void textoPalavraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textoPalavraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textoPalavraActionPerformed

    private void textoAnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textoAnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textoAnoActionPerformed

    private void textoEscritorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textoEscritorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textoEscritorActionPerformed

    private void textoIdiomaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textoIdiomaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textoIdiomaActionPerformed

    private void textoNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textoNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textoNomeActionPerformed

    private void checkCapitulosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkCapitulosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkCapitulosActionPerformed

    private void checkPalavraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkPalavraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkPalavraActionPerformed

    private void checkIdiomaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkIdiomaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkIdiomaActionPerformed

    private void checkAnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkAnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkAnoActionPerformed

    private void checkEscritoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkEscritoresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkEscritoresActionPerformed

    private void checkNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkNomeActionPerformed

    private void checkFormatoAudioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkFormatoAudioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkFormatoAudioActionPerformed

    private void checkDuracaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkDuracaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkDuracaoActionPerformed

    private void checkFormatoTextoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkFormatoTextoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkFormatoTextoActionPerformed

    private void checkURLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkURLActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkURLActionPerformed

    private void checkColunasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkColunasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkColunasActionPerformed

    private void checkLivrariasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkLivrariasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkLivrariasActionPerformed

    private void checkAudioBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkAudioBookActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkAudioBookActionPerformed

    private void checkEletronicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkEletronicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkEletronicoActionPerformed

    private void checkImpressoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkImpressoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkImpressoActionPerformed

    private void relatorioEspecificoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_relatorioEspecificoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_relatorioEspecificoActionPerformed

    private void RelatorioGeralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioGeralActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RelatorioGeralActionPerformed

    private void limparFiltrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparFiltrosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_limparFiltrosActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton RelatorioGeral;
    private javax.swing.JCheckBox checkAno;
    private javax.swing.JCheckBox checkAudioBook;
    private javax.swing.JCheckBox checkCapitulos;
    private javax.swing.JCheckBox checkColunas;
    private javax.swing.JCheckBox checkDuracao;
    private javax.swing.JCheckBox checkEletronico;
    private javax.swing.JCheckBox checkEscritores;
    private javax.swing.JCheckBox checkFormatoAudio;
    private javax.swing.JCheckBox checkFormatoTexto;
    private javax.swing.JCheckBox checkIdioma;
    private javax.swing.JCheckBox checkImpresso;
    private javax.swing.JCheckBox checkLivrarias;
    private javax.swing.JCheckBox checkNome;
    private javax.swing.JCheckBox checkPalavra;
    private javax.swing.JCheckBox checkURL;
    private javax.swing.JInternalFrame escolhaEspecifica;
    private javax.swing.JInternalFrame escolhaGeral;
    private javax.swing.JInternalFrame escolhaTipo;
    private javax.swing.JButton jButton4;
    private javax.swing.JInternalFrame jInternalFrame4;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField24;
    private javax.swing.JLabel labelEspecifica;
    private javax.swing.JLabel labelGeral;
    private javax.swing.JLabel labelTipo;
    private javax.swing.JButton limparFiltros;
    private javax.swing.JButton pesquisaEspecifica;
    private javax.swing.JButton pesquisaGeral;
    private javax.swing.JButton relatorioEspecifico;
    private javax.swing.JTextField textoAno;
    private javax.swing.JTextField textoColuna;
    private javax.swing.JTextField textoDuracao;
    private javax.swing.JTextField textoEscritor;
    private javax.swing.JTextField textoFormatoAudio;
    private javax.swing.JTextField textoFormatoTexto;
    private javax.swing.JTextField textoIdioma;
    private javax.swing.JTextField textoLivraria;
    private javax.swing.JTextField textoNome;
    private javax.swing.JTextField textoPalavra;
    private javax.swing.JTextField textoPesquisaGeral;
    private javax.swing.JTextField textoURL;
    // End of variables declaration//GEN-END:variables
}
