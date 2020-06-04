package View;

import Bo.*;
import Model.*;
import Utilities.*;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

public class GerenciarCorrida extends JFrame implements ActionListener {

    private JPanel fundo;
    private JPanel drawer;
    private JLabel logo;
    private JLabel lblNumeroDeVoltas;
    private JLabel lblNomeDaCorrida;
    private JFormattedTextField textFieldNomeCorrida;
    private JFormattedTextField textFieldVoltasDaCorrida;
    private JButton btnVoltar;
    private JButton btnAdicionarPilotos;
    private JButton btnRemoverCorrida;
    private JButton btnAdicionarCorrida;
    private JTable table;
    private GerenciarCampeonato gerenciarCampeonato;
    private JScrollPane scroll;
    private DefaultTableCellRenderer renderer;
    private JComboBox<String> comboNomeKartodromo;
    private JComboBox<String> comboTipoDeKart;
    private JLabel nomekartodromoLabel;
    private JLabel tipokartLabel;
    private JLabel lblenderecokartodromo;

    private List<Corrida> corridaList;
    private Kartodromo kartodromo;
    private Piloto piloto;
    private Campeonato campeonato;
    private TabelaPiloto tabelaPiloto;
    private DefaultTableModel tabelamento;

    public GerenciarCorrida(GerenciarCampeonato gerenciarCampeonato, Piloto piloto, Campeonato campeonato, DefaultTableModel tabelamento) {

        this.piloto = piloto;
        this.gerenciarCampeonato = gerenciarCampeonato;
        this.campeonato = campeonato;
        this.tabelamento = tabelamento;

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
        logo = new JLabel();
        lblNumeroDeVoltas = new JLabel();
        lblNomeDaCorrida = new JLabel();
        textFieldNomeCorrida = new JFormattedTextField();
        textFieldVoltasDaCorrida = new JFormattedTextField();
        btnVoltar = new JButton();
        btnAdicionarCorrida = new JButton();
        btnRemoverCorrida = new JButton();
        btnAdicionarPilotos = new JButton();
        table = new JTable();
        tabelaPiloto = new TabelaPiloto();
        renderer = new DefaultTableCellRenderer();
        scroll = new JScrollPane(table);
        nomekartodromoLabel = new JLabel();
        tipokartLabel = new JLabel();
        lblNumeroDeVoltas = new JLabel();
        lblenderecokartodromo = new JLabel();
        comboNomeKartodromo = new JComboBox<>();
        comboTipoDeKart = new JComboBox<>();
        corridaList = new ArrayList<>();

    }

    private void add() {
        add(logo);
        add(btnVoltar);
        add(btnAdicionarCorrida);
        add(lblNumeroDeVoltas);
        add(lblNomeDaCorrida);
        add(comboTipoDeKart);
        add(comboNomeKartodromo);
        add(lblenderecokartodromo);
        add(nomekartodromoLabel);
        add(tipokartLabel);
        add(lblNumeroDeVoltas);
        add(textFieldNomeCorrida);
        add(textFieldVoltasDaCorrida);
        add(table);
        add(scroll);
        add(btnRemoverCorrida);
        add(btnAdicionarPilotos);
        add(drawer);
        add(fundo);
    }

    private void setTheme() {

        if (SplashScreen.getConfiguracao().isTema()) {
            // Se o tema for escuro, os itens ficam assim //
            fundo.setBackground(Colors.CINZAMEDB);
            drawer.setBackground(Colors.VERDEDARK);
            logo.setForeground(Colors.CINZAMEDB);
            btnVoltar.setBackground(Colors.VERDEDARK);
            lblNomeDaCorrida.setForeground(Colors.CINZALIGHTB);
            lblNumeroDeVoltas.setForeground(Colors.CINZALIGHTB);
            textFieldNomeCorrida.setBackground(Colors.CINZALIGHTB);
            textFieldNomeCorrida.setForeground(Colors.BRANCO);
            textFieldVoltasDaCorrida.setBackground(Colors.CINZALIGHTB);
            textFieldVoltasDaCorrida.setForeground(Colors.BRANCO);
            btnVoltar.setForeground(Colors.CINZADARKB);
            btnAdicionarPilotos.setBackground(Colors.VERDEDARK);
            btnAdicionarPilotos.setForeground(Colors.CINZADARKB);
            btnRemoverCorrida.setBackground(Colors.VERDEDARK);
            btnRemoverCorrida.setForeground(Colors.CINZADARKB);
            btnAdicionarCorrida.setBackground(Colors.VERDEDARK);
            btnAdicionarCorrida.setForeground(Colors.CINZADARKB);
            lblenderecokartodromo.setForeground(Colors.CINZALIGHTB);
            nomekartodromoLabel.setForeground(Colors.CINZALIGHTB);
            tipokartLabel.setForeground(Colors.CINZALIGHTB);
            lblNumeroDeVoltas.setForeground(Colors.CINZALIGHTB);
            comboNomeKartodromo.setBackground(Colors.CINZALIGHTB);
            comboNomeKartodromo.setForeground(Colors.BRANCO);
            comboTipoDeKart.setBackground(Colors.CINZALIGHTB);
            comboTipoDeKart.setForeground(Colors.BRANCO);
        } else {
            fundo.setBackground(Colors.CINZAMEDA);
            drawer.setBackground(Colors.VERDEDARK);
            logo.setForeground(Colors.CINZAMEDB);
            lblNumeroDeVoltas.setForeground(Colors.CINZALIGHTB);
            lblNomeDaCorrida.setForeground(Colors.CINZALIGHTB);
            textFieldVoltasDaCorrida.setBackground(Colors.CINZALIGHTB);
            textFieldVoltasDaCorrida.setForeground(Colors.CINZADARKA);
            textFieldNomeCorrida.setBackground(Colors.CINZALIGHTB);
            textFieldNomeCorrida.setForeground(Colors.CINZADARKA);
            btnVoltar.setBackground(Colors.VERDEDARK);
            btnVoltar.setForeground(Colors.CINZADARKB);
            btnAdicionarPilotos.setBackground(Colors.VERDEDARK);
            btnAdicionarPilotos.setForeground(Colors.CINZADARKB);
            btnRemoverCorrida.setBackground(Colors.VERDEDARK);
            btnRemoverCorrida.setForeground(Colors.CINZADARKB);
            btnAdicionarCorrida.setBackground(Colors.VERDEDARK);
            btnAdicionarCorrida.setForeground(Colors.CINZADARKB);
            lblenderecokartodromo.setForeground(Colors.CINZALIGHTB);
            nomekartodromoLabel.setForeground(Colors.CINZALIGHTB);
            tipokartLabel.setForeground(Colors.CINZALIGHTB);
            lblNumeroDeVoltas.setForeground(Colors.CINZALIGHTB);
            comboNomeKartodromo.setBackground(Colors.CINZALIGHTB);
            comboNomeKartodromo.setForeground(Colors.CINZADARKA);
            comboTipoDeKart.setBackground(Colors.CINZALIGHTB);
            comboTipoDeKart.setForeground(Colors.CINZADARKA);
        }
    }

    private void configs() {

        fundo.setSize(Info.MINSCREENSIZE);
        drawer.setBounds(0, 0, 800, 100);

        logo.setBounds(20, 30, 700, 35);
        logo.setText("GERENCIAR CORRIDAS");
        logo.setFont(Fonts.SANSSERIFMIN);

        try {
            for (Kartodromo kartodromo : new KartodromoBO().listarTodos()) {
                comboNomeKartodromo.addItem(kartodromo.getNomeKartodromo());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível carregar a tela criar campeonato");
        }

        if (kartodromo == null) {
            mudarCombo();
        }

        comboTipoDeKart.setBorder(BorderFactory.createEmptyBorder());
        comboTipoDeKart.setBounds(300, 200, 150, 35);

        nomekartodromoLabel.setText("KARTÓDROMO:");
        nomekartodromoLabel.setBounds(300, 100, 300, 35);

        comboNomeKartodromo.setBorder(BorderFactory.createEmptyBorder());
        comboNomeKartodromo.setBounds(300, 140, 150, 35);

        comboNomeKartodromo.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    mudarCombo();
                }
            }
        });

        tipokartLabel.setText("TIPO DE KART:");
        tipokartLabel.setBounds(300, 175, 300, 30);

        scroll.setViewportView(table);
        scroll.setBounds(30, 240, 740, 300);

        renderer.setHorizontalTextPosition(JLabel.CENTER);
        table.setModel(tabelaPiloto);
        table.setDefaultRenderer(String.class, renderer);

        textFieldVoltasDaCorrida.setBorder(BorderFactory.createEmptyBorder());
        textFieldVoltasDaCorrida.setBounds(540, 140, 230, 35);
        textFieldVoltasDaCorrida.setHorizontalAlignment(JFormattedTextField.CENTER);
        textFieldVoltasDaCorrida.setFocusLostBehavior(JFormattedTextField.PERSIST);

        textFieldNomeCorrida.setBorder(BorderFactory.createEmptyBorder());
        textFieldNomeCorrida.setBounds(30, 140, 230, 35);
        textFieldNomeCorrida.setHorizontalAlignment(JFormattedTextField.CENTER);
        textFieldNomeCorrida.setFocusLostBehavior(JFormattedTextField.PERSIST);

        lblNumeroDeVoltas.setText("Numero de voltas da corrida");
        lblNumeroDeVoltas.setBounds(540, 100, 200, 35);

        lblNomeDaCorrida.setText("Nome da corrida");
        lblNomeDaCorrida.setBounds(30, 100, 200, 35);

        lblenderecokartodromo.setBounds(480, 180, 250, 60);

        btnVoltar.setText("VOLTAR");
        btnVoltar.setBorderPainted(false);
        btnVoltar.setFocusPainted(false);
        btnVoltar.addActionListener(this);
        btnVoltar.setBounds(20, 550, 170, 35);

        btnAdicionarCorrida.setText("ADICIONAR CORRIDA");
        btnAdicionarCorrida.setBorderPainted(false);
        btnAdicionarCorrida.setFocusPainted(false);
        btnAdicionarCorrida.addActionListener(this);
        btnAdicionarCorrida.setBounds(395, 550, 160, 35);

        btnRemoverCorrida.setFocusPainted(false);
        btnRemoverCorrida.setBorderPainted(false);
        btnRemoverCorrida.addActionListener(this);
        btnRemoverCorrida.setText("REMOVER CORRIDA");
        btnRemoverCorrida.setBounds(215, 550, 160, 35);

        btnAdicionarPilotos.setFocusPainted(false);
        btnAdicionarPilotos.setBorderPainted(false);
        btnAdicionarPilotos.addActionListener(this);
        btnAdicionarPilotos.setText("ADICIONAR PILOTOS");
        btnAdicionarPilotos.setBounds(580, 550, 200, 35);

        try {
            textFieldVoltasDaCorrida.setFormatterFactory(new DefaultFormatterFactory(
                    new MaskFormatter("##")));
            textFieldNomeCorrida.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("LLLLLLLLLL")));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        if (!corridaList.isEmpty()) {
            for (Corrida corrida : corridaList) {
                tabelaPiloto.addRow(corrida);
            }
            this.corridaList = null;
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnVoltar) {

            if (JOptionPane.showConfirmDialog(null,
                    "Cancelar?",
                    "Cancelar",
                    JOptionPane.YES_NO_OPTION) == 0) {

                this.dispose();
                gerenciarCampeonato.setVisible(true);

            }

        }

        if (e.getSource() == btnAdicionarPilotos) {

            if (JOptionPane.showConfirmDialog(null,
                    "Criar uma Corrida lhe torna automaticamente um ADM desta corrida,"
                            + " você tem certeza que deseja assumir essa responsabilidade?",
                    "Termo de responsabilidade",
                    JOptionPane.YES_NO_OPTION) == 0) {

                new GerenciarCampeonatoAdicionarPilotos(this,
                        piloto,
                        campeonato,
                        tabelamento,
                        tabelaPiloto.getListCorrida());

            }

        }

        if (e.getSource() == btnRemoverCorrida) {
            if (table.getSelectedRow() != -1) {
                tabelaPiloto.removeRow(table.getSelectedRow());
            }
        }

        if (e.getSource() == btnAdicionarCorrida) {

            String textoValorVoltas = textFieldVoltasDaCorrida.getText().replaceAll(" ", "");

            if (ValidarString.isApenasLetras(textFieldNomeCorrida.getText())) {

                if (ValidarString.isApenasNumeros(textoValorVoltas)) {

                    try {

                        Corrida corrida = new Corrida();
                        corrida.setTipoKart(comboTipoDeKart.getSelectedItem().toString());
                        corrida.setKartodromo(new KartodromoBO().getById(comboNomeKartodromo.getSelectedIndex() + 1));
                        corrida.setNomeCorrida(textFieldNomeCorrida.getText());
                        corrida.setNumeroDeVoltas(Integer.valueOf(textoValorVoltas));
                        CorridaBO corridaBO = new CorridaBO();
                        if (corridaBO.validaTabelaPiloto(tabelaPiloto)) {
                            if (corridaBO.valida(corrida)) {
                                tabelaPiloto.addRow(corrida);
                            }
                        }

                    } catch (Exception error) {
                        JOptionPane.showMessageDialog(null, error.getMessage());
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Adicionar voltas da corrida!");
                }

            } else {
                JOptionPane.showMessageDialog(null, "Adicionar nome para corrida");
            }

        }

    }

    private void mudarCombo() {

        try {

            kartodromo = new KartodromoBO().getById(comboNomeKartodromo.getSelectedIndex() + 1);
            comboTipoDeKart.removeAllItems();
            lblenderecokartodromo.setText("<html>Endereço: " + kartodromo.getEstado() + ", " + kartodromo.getCidade() + ", " + kartodromo.getRua() + ", n°" + kartodromo.getNumero() + "</html>");

            if (kartodromo.isKartIndoor()) {
                comboTipoDeKart.addItem("INDOOR");
            }

            if (kartodromo.isKartMotor2Tempos()) {
                comboTipoDeKart.addItem("2 TEMPOS");
            }

            if (kartodromo.isKartMotor4Tempos()) {
                comboTipoDeKart.addItem("4 TEMPOS");
            }

            if (kartodromo.isKartSemMarcha()) {
                comboTipoDeKart.addItem("SEM MARCHA");
            }

            if (kartodromo.isKartShifter()) {
                comboTipoDeKart.addItem("SHIFTER");
            }

        } catch (Exception error) {
            JOptionPane.showMessageDialog(null, "Não foi possível encontrar kartodromo escolhido");
        }
    }
}
