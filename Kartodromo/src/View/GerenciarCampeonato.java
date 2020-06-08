package View;

import Bo.CampeonatoBO;
import Bo.ValidarString;
import Model.Campeonato;
import Model.Piloto;
import Utilities.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

public class GerenciarCampeonato extends JFrame implements ActionListener {

    private JPanel fundo;
    private JPanel drawer;
    private JComboBox<String> comboTipoCampeonato;
    private JFormattedTextField textFieldNomeCampeonato;
    private JFormattedTextField textFieldDataFinalCampeonato;
    private JFormattedTextField textFieldNumeroDeCorridas;
    private InformacoesPiloto informacoesPiloto;
    private JTable table;
    private JScrollPane scroll;
    private JLabel logo;
    private JLabel lblNumeroDeCorridas;
    private JLabel lblPontuacoes;
    private JLabel lblNomeCampeonato;
    private JLabel lblDataFinalCampeonato;
    private JLabel lblTipoCorrida;
    private JButton btnVoltar;
    private JButton btnAdicionarCorrida;
    private DefaultTableModel tabelamento;
    private Piloto piloto;
    private Campeonato campeonato;

    public GerenciarCampeonato(Piloto piloto) {

        this.piloto = piloto;

        // Instancia de itens //
        initializate();
        // Coloca o tema na tela
        setTheme();
        // Adiciona o item na tela //
        add();
        // Configura o item da tela (btn,label...) //
        configs();
        // Configura esse frame //
        configurateThis();

    }

    private void configurateThis() {
        setUndecorated(true);
        setSize(Info.MINSCREENSIZE);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle(Info.APP_NAME);
        setResizable(false);
    }

    private void initializate() {

        fundo = new JPanel();
        drawer = new JPanel();
        btnAdicionarCorrida = new JButton();
        table = new JTable();
        scroll = new JScrollPane();
        textFieldNomeCampeonato = new JFormattedTextField();
        textFieldDataFinalCampeonato = new JFormattedTextField();
        textFieldNumeroDeCorridas = new JFormattedTextField();
        lblPontuacoes = new JLabel();
        logo = new JLabel();
        lblNumeroDeCorridas = new JLabel();
        lblNomeCampeonato = new JLabel();
        informacoesPiloto = new InformacoesPiloto();
        lblDataFinalCampeonato = new JLabel();
        lblTipoCorrida = new JLabel();
        btnVoltar = new JButton();
        comboTipoCampeonato = new JComboBox<>();
        campeonato = new Campeonato();

    }

    private void add() {
        add(btnAdicionarCorrida);
        add(informacoesPiloto);
        add(logo);
        add(textFieldNumeroDeCorridas);
        add(comboTipoCampeonato);
        add(textFieldNomeCampeonato);
        add(scroll);
        add(lblPontuacoes);
        add(textFieldDataFinalCampeonato);
        add(lblNomeCampeonato);
        add(lblNumeroDeCorridas);
        add(lblDataFinalCampeonato);
        add(lblTipoCorrida);
        add(btnVoltar);
        add(drawer);
        add(fundo);
    }

    private void setTheme() {

        if (SplashScreen.getConfiguracao().isTema()) {
            // Se o tema for escuro, os itens ficam assim //
            fundo.setBackground(Colors.CINZAMEDB);
            drawer.setBackground(Colors.VERDEDARK);
            textFieldNomeCampeonato.setBackground(Colors.CINZALIGHTB);
            textFieldNomeCampeonato.setForeground(Colors.BRANCO);
            textFieldDataFinalCampeonato.setBackground(Colors.CINZALIGHTB);
            textFieldDataFinalCampeonato.setForeground(Colors.BRANCO);
            textFieldNumeroDeCorridas.setBackground(Colors.CINZALIGHTB);
            textFieldNumeroDeCorridas.setForeground(Colors.BRANCO);
            lblNomeCampeonato.setForeground(Colors.CINZALIGHTB);
            lblDataFinalCampeonato.setForeground(Colors.CINZALIGHTB);
            lblTipoCorrida.setForeground(Colors.CINZALIGHTB);
            lblNumeroDeCorridas.setForeground(Colors.CINZALIGHTB);
            lblPontuacoes.setForeground(Colors.CINZALIGHTB);
            logo.setForeground(Colors.CINZAMEDB);
            btnVoltar.setBackground(Colors.VERDEDARK);
            btnVoltar.setForeground(Colors.CINZADARKB);
            informacoesPiloto.setForeground(Colors.CINZAMEDB);
            btnAdicionarCorrida.setBackground(Colors.VERDEDARK);
            btnAdicionarCorrida.setForeground(Colors.CINZADARKB);
            comboTipoCampeonato.setForeground(Colors.BRANCO);
            comboTipoCampeonato.setBackground(Colors.CINZALIGHTB);
        } else {
            fundo.setBackground(Colors.CINZAMEDA);
            drawer.setBackground(Colors.VERDEDARK);
            textFieldNomeCampeonato.setBackground(Colors.CINZALIGHTB);
            textFieldNomeCampeonato.setForeground(Colors.CINZADARKA);
            textFieldDataFinalCampeonato.setBackground(Colors.CINZALIGHTB);
            textFieldDataFinalCampeonato.setForeground(Colors.CINZADARKA);
            textFieldNumeroDeCorridas.setBackground(Colors.CINZALIGHTB);
            textFieldNumeroDeCorridas.setForeground(Colors.CINZADARKA);
            lblNumeroDeCorridas.setForeground(Colors.CINZALIGHTB);
            lblNomeCampeonato.setForeground(Colors.CINZALIGHTB);
            lblDataFinalCampeonato.setForeground(Colors.CINZALIGHTB);
            lblPontuacoes.setForeground(Colors.CINZALIGHTB);
            lblTipoCorrida.setForeground(Colors.CINZALIGHTB);
            logo.setForeground(Colors.CINZAMEDB);
            informacoesPiloto.setForeground(Colors.BRANCO);
            btnVoltar.setBackground(Colors.VERDEDARK);
            btnVoltar.setForeground(Colors.CINZADARKB);
            btnAdicionarCorrida.setBackground(Colors.VERDEDARK);
            btnAdicionarCorrida.setForeground(Colors.CINZADARKB);
            comboTipoCampeonato.setBackground(Colors.CINZALIGHTB);
            comboTipoCampeonato.setForeground(Colors.CINZADARKA);
        }
    }

    private void configs() {

        fundo.setSize(Info.MINSCREENSIZE);
        drawer.setBounds(0, 0, 800, 100);

        informacoesPiloto.setBounds(620, 3, 180, 100);
        informacoesPiloto.setPiloto(piloto);

        lblNomeCampeonato.setText("NOME DO CAMPEONATO:");
        lblNomeCampeonato.setBounds(60, 185, 200, 35);

        textFieldNomeCampeonato.setBorder(BorderFactory.createEmptyBorder());
        textFieldNomeCampeonato.setBounds(60, 215, 300, 35);
        textFieldNomeCampeonato.setHorizontalAlignment(JFormattedTextField.CENTER);
        textFieldNomeCampeonato.setFocusLostBehavior(JFormattedTextField.PERSIST);

        textFieldDataFinalCampeonato.setBorder(BorderFactory.createEmptyBorder());
        textFieldDataFinalCampeonato.setBounds(60, 340, 300, 35);
        textFieldDataFinalCampeonato.setHorizontalAlignment(JFormattedTextField.CENTER);
        textFieldDataFinalCampeonato.setFocusLostBehavior(JFormattedTextField.PERSIST);

        textFieldNumeroDeCorridas.setBorder(BorderFactory.createEmptyBorder());
        textFieldNumeroDeCorridas.setBounds(60, 405, 300, 35);
        textFieldNumeroDeCorridas.setHorizontalAlignment(JFormattedTextField.CENTER);
        textFieldNumeroDeCorridas.setFocusLostBehavior(JFormattedTextField.PERSIST);

        lblNumeroDeCorridas.setText("NUMERO DE CORRIDAS DO CAMPEONATO:");
        lblNumeroDeCorridas.setBounds(60, 372, 300, 35);

        lblDataFinalCampeonato.setText("DATA DO CAMPEONATO:");
        lblDataFinalCampeonato.setBounds(60, 310, 200, 35);

        lblTipoCorrida.setText("STATUS DO CAMPEONATO:");
        lblTipoCorrida.setBounds(60, 250, 200, 35);

        comboTipoCampeonato.setBorder(BorderFactory.createEmptyBorder());
        comboTipoCampeonato.setBounds(60, 280, 300, 35);

        comboTipoCampeonato.addItem(Info.CAMPEONATO_NORMAL);
        comboTipoCampeonato.addItem(Info.CAMPEONATO_OFICIAL);

        logo.setBounds(20, 30, 760, 35);
        logo.setText("GERENCIAR CAMPEONATOS");
        logo.setFont(Fonts.SANSSERIFMIN);

        btnVoltar.setText("VOLTAR");
        btnVoltar.setBorderPainted(false);
        btnVoltar.setFocusPainted(false);
        btnVoltar.addActionListener(this);
        btnVoltar.setBounds(20, 550, 100, 35);

        btnAdicionarCorrida.setFocusPainted(false);
        btnAdicionarCorrida.setBorderPainted(false);
        btnAdicionarCorrida.addActionListener(this);
        btnAdicionarCorrida.setText("ADICIONAR CORRIDA");
        btnAdicionarCorrida.setBounds(590, 550, 190, 35);

        table.setModel(new DefaultTableModel(
                new Object[][]{

                },
                new String[]{
                        "Posição", "Valor"
                }
        ) {
            boolean[] canEdit = new boolean[]{
                    false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }

        });

        tabelamento = (DefaultTableModel) table.getModel();

        for (int x = 1; x <= 10; x++) {
            tabelamento.addRow(new Object[]{
                    x, 11 - x //por padrão uma pontuação que o piloto pode mudar
            });
        }

        scroll.setViewportView(table);
        scroll.setBounds(400, 220, 380, 180);

        lblPontuacoes.setText("INFORME AS PONTUAÇÕES DAS 10 PRIMEIRAS PONTUAÇÕES:");
        lblPontuacoes.setBounds(400, 170, 400, 60);

        try {
            textFieldDataFinalCampeonato.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("##/##/####")));
            textFieldNomeCampeonato.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("??????????????")));
            textFieldNumeroDeCorridas.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("##")));
        } catch (Exception error) {
            JOptionPane.showMessageDialog(null, "Não foi possível carregar a tela criar campeonato");
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnVoltar) {
            dispose();
            new PerfilPiloto(piloto);
        }

        if (e.getSource() == btnAdicionarCorrida) {

            // Validações da tela, fica na tela //

            if (ValidarString.isApenasLetras(textFieldNomeCampeonato.getText()) &&
                    ValidarString.isDataPadraoBRA(textFieldDataFinalCampeonato.getText())) {

                campeonato.setNome(textFieldNomeCampeonato.getText());
                campeonato.setSituacao("Aguardando Participantes");
                campeonato.setTipoCorrida(comboTipoCampeonato.getSelectedItem().toString());
                campeonato.setDataCadastro(Tempo.getCurrentDate());
                campeonato.setNome(textFieldNomeCampeonato.getText());
                campeonato.setDataInicio(Tempo.stringToDate(textFieldDataFinalCampeonato.getText()));
                campeonato.setNumeroCorridas(Numeros.stringToInt(textFieldNumeroDeCorridas.getText().replaceAll(" ", "")));

                try {
                    if (new CampeonatoBO().validarTelaGerenciarCampeonato(campeonato)) {
                        new CampeonatoBO().validarTabelaPontuacaoCampeonato(tabelamento);
                        this.setVisible(false);
                        new GerenciarCorrida(piloto,
                                campeonato,
                                tabelamento);
                    }
                } catch (Exception err) {
                    JOptionPane.showMessageDialog(null, err.getMessage(),
                            "Erro", JOptionPane.PLAIN_MESSAGE);
                }

            } else {
                JOptionPane.showMessageDialog(null,
                        "Verifique novamente os dados!",
                        "Erro",
                        JOptionPane.PLAIN_MESSAGE);
            }

        }

    }

}