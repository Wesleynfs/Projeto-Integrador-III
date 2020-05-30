package View;

import Bo.CorridaBO;
import Bo.KartodromoBO;
import Model.Campeonato;
import Model.Corrida;
import Model.Kartodromo;
import Model.Piloto;
import Utilities.*;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GerenciarCorrida extends JFrame implements ActionListener {


    private JPanel fundo;
    private JPanel drawer;
    private JLabel logo;
    private JLabel lblNumeroDeVoltas;
    private JLabel lblNomeDaCorrida;
    private JFormattedTextField textFieldNomeCorrida;
    private JFormattedTextField textFieldVoltasDaCorrida;
    private JButton btnVoltar;
    private JButton btnCriarCorrida;
    private JButton btnRemoverCorrida;
    private JTable table;
    private GerenciarCampeonato gerenciarCampeonato;
    private JScrollPane scroll;
    private DefaultTableCellRenderer renderer;
    private JComboBox<String> comboNomeKartodromo;
    private JComboBox<String> comboTipoDeKart;
    private JLabel nomekartodromoLabel;
    private JLabel tipokartLabel;
    private JLabel lblenderecokartodromo;

    private Kartodromo kartodromo;
    private Piloto piloto;
    private Campeonato campeonato;
    private TabelaPiloto tabelaPiloto;

    public GerenciarCorrida(Piloto piloto, Campeonato campeonato, GerenciarCampeonato gerenciarCampeonato) {

        this.piloto = piloto;
        this.gerenciarCampeonato = gerenciarCampeonato;
        this.campeonato = campeonato;

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
        btnRemoverCorrida = new JButton();
        btnCriarCorrida = new JButton();
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

    }

    private void add() {
        add(logo);
        add(btnVoltar);
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
        add(btnCriarCorrida);
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
            btnCriarCorrida.setBackground(Colors.VERDEDARK);
            btnCriarCorrida.setForeground(Colors.CINZADARKB);
            btnRemoverCorrida.setBackground(Colors.VERDEDARK);
            btnRemoverCorrida.setForeground(Colors.CINZADARKB);
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
            btnCriarCorrida.setBackground(Colors.VERDEDARK);
            btnCriarCorrida.setForeground(Colors.CINZADARKB);
            btnRemoverCorrida.setBackground(Colors.VERDEDARK);
            btnRemoverCorrida.setForeground(Colors.CINZADARKB);
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

        textFieldNomeCorrida.setBorder(BorderFactory.createEmptyBorder());
        textFieldNomeCorrida.setBounds(30, 140, 230, 35);
        textFieldNomeCorrida.setHorizontalAlignment(JFormattedTextField.CENTER);

        lblNumeroDeVoltas.setText("Numero de voltas da corrida");
        lblNumeroDeVoltas.setBounds(540, 100, 200, 35);

        lblNomeDaCorrida.setText("Nome da corrida");
        lblNomeDaCorrida.setBounds(30, 100, 200, 35);

        lblenderecokartodromo.setBounds(480, 195, 250, 60);

        btnVoltar.setText("SALVAR / DESCARTAR");
        btnVoltar.setBorderPainted(false);
        btnVoltar.setFocusPainted(false);
        btnVoltar.addActionListener(this);
        btnVoltar.setBounds(20, 550, 170, 35);

        btnCriarCorrida.setFocusPainted(false);
        btnCriarCorrida.setBorderPainted(false);
        btnCriarCorrida.addActionListener(this);
        btnCriarCorrida.setText("ADICIONAR CORRIDA");
        btnCriarCorrida.setBounds(580, 550, 200, 35);

        btnRemoverCorrida.setFocusPainted(false);
        btnRemoverCorrida.setBorderPainted(false);
        btnRemoverCorrida.addActionListener(this);
        btnRemoverCorrida.setText("REMOVER CORRIDA");
        btnRemoverCorrida.setBounds(380, 550, 160, 35);

        if (!gerenciarCampeonato.getCorridaList().isEmpty()) {
            for (Corrida corrida : gerenciarCampeonato.getCorridaList()) {
                tabelaPiloto.addRow(corrida);
            }
            gerenciarCampeonato.setCorridaList(null);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnVoltar) {

            if (JOptionPane.showConfirmDialog(null,
                    "Deseja salvar alterações?",
                    "Salvar",
                    JOptionPane.YES_NO_OPTION) == 0) {

                this.dispose();
                gerenciarCampeonato.setCampeonato(campeonato);
                gerenciarCampeonato.setCorridaList(tabelaPiloto.getListCorrida());
                gerenciarCampeonato.getBtnCriarCampeonato().setEnabled(true);
                gerenciarCampeonato.getBtnCriarCampeonato().setVisible(true);
                gerenciarCampeonato.setVisible(true);

            } else {
                this.dispose();
                gerenciarCampeonato.setVisible(true);
            }

        }

        if (e.getSource() == btnCriarCorrida) {

            try {
                Corrida corrida = new Corrida();
                corrida.setTipoKart(comboTipoDeKart.getSelectedItem().toString());
                corrida.setKartodromo(new KartodromoBO().getById(comboNomeKartodromo.getSelectedIndex() + 1));
                corrida.setNomeCorrida(textFieldNomeCorrida.getText());
                corrida.setNumeroDeVoltas(Integer.valueOf(textFieldVoltasDaCorrida.getText()));
                CorridaBO corridaBO = new CorridaBO();
                if (corridaBO.validaTabelaPiloto(tabelaPiloto)) {
                    if (corridaBO.valida(corrida)) {
                        tabelaPiloto.addRow(corrida);
                    }
                }
            } catch (Exception error) {
                JOptionPane.showMessageDialog(null, error.getMessage());
            }

        }

        if (e.getSource() == btnRemoverCorrida) {
            if (table.getSelectedRow() != -1) {
                tabelaPiloto.removeRow(table.getSelectedRow());
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
