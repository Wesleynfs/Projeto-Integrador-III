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
    private JLabel lblDataCorrida;
    private JLabel lblNumeroDeVoltas;
    private JLabel lblNomeDaCorrida;
    private JFormattedTextField textFieldNomeCorrida;
    private JFormattedTextField textFieldVoltasDaCorrida;
    private JFormattedTextField textFieldHoraCorrida;
    private JButton btnVoltar;
    private JButton btnAdicionarPilotos;
    private JButton btnRemoverCorrida;
    private JButton btnAdicionarCorrida;
    private JTable table;
    private InformacoesPiloto informacoesPiloto;
    private JScrollPane scroll;
    private DefaultTableCellRenderer renderer;
    private JComboBox<String> comboNomeKartodromo;
    private JComboBox<String> comboTipoDeKart;
    private JLabel nomekartodromoLabel;
    private JLabel tipokartLabel;
    private JLabel lblEnderecoKartodromo;
    private JLabel lblHoraCorrida;
    private JFormattedTextField textFieldDataCorrida;
    private List<Corrida> corridaList;
    private Kartodromo kartodromo;
    private Piloto piloto;
    private Campeonato campeonato;
    private TabelaPiloto tabelaPiloto;
    private DefaultTableModel tabelamento;

    public GerenciarCorrida(Piloto piloto, Campeonato campeonato, DefaultTableModel tabelamento) {

        this.piloto = piloto;
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
        setSize(1100,600);
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
        textFieldHoraCorrida = new JFormattedTextField();
        textFieldDataCorrida = new JFormattedTextField();
        informacoesPiloto = new InformacoesPiloto();
        btnAdicionarCorrida = new JButton();
        btnRemoverCorrida = new JButton();
        btnAdicionarPilotos = new JButton();
        table = new JTable();
        lblHoraCorrida = new JLabel();
        lblDataCorrida = new JLabel();
        tabelaPiloto = new TabelaPiloto();
        renderer = new DefaultTableCellRenderer();
        scroll = new JScrollPane(table);
        nomekartodromoLabel = new JLabel();
        tipokartLabel = new JLabel();
        lblNumeroDeVoltas = new JLabel();
        lblEnderecoKartodromo = new JLabel();
        comboNomeKartodromo = new JComboBox<>();
        comboTipoDeKart = new JComboBox<>();
        corridaList = new ArrayList<>();

    }

    private void add() {
        add(logo);
        add(btnVoltar);
        add(textFieldDataCorrida);
        add(lblDataCorrida);
        add(btnAdicionarCorrida);
        add(lblNumeroDeVoltas);
        add(lblHoraCorrida);
        add(textFieldHoraCorrida);
        add(lblNomeDaCorrida);
        add(comboTipoDeKart);
        add(comboNomeKartodromo);
        add(lblEnderecoKartodromo);
        add(nomekartodromoLabel);
        add(tipokartLabel);
        add(lblNumeroDeVoltas);
        add(textFieldNomeCorrida);
        add(textFieldVoltasDaCorrida);
        add(table);
        add(scroll);
        add(informacoesPiloto);
        add(btnRemoverCorrida);
        add(btnAdicionarPilotos);
        add(drawer);
        add(fundo);
    }

    private void setTheme() {
        //SplashScreen.getConfiguracao().isTema()
        if (true) {
            // Se o tema for escuro, os itens ficam assim //
            fundo.setBackground(Colors.CINZAMEDB);
            drawer.setBackground(Colors.VERDEDARK);
            logo.setForeground(Colors.CINZAMEDB);
            lblDataCorrida.setForeground(Colors.CINZALIGHTB);
            informacoesPiloto.setForeground(Colors.CINZAMEDB);
            btnVoltar.setBackground(Colors.VERDEDARK);
            lblNomeDaCorrida.setForeground(Colors.CINZALIGHTB);
            lblNumeroDeVoltas.setForeground(Colors.CINZALIGHTB);
            textFieldNomeCorrida.setBackground(Colors.CINZALIGHTB);
            textFieldNomeCorrida.setForeground(Colors.BRANCO);
            textFieldVoltasDaCorrida.setBackground(Colors.CINZALIGHTB);
            textFieldVoltasDaCorrida.setForeground(Colors.BRANCO);
            textFieldDataCorrida.setBackground(Colors.CINZALIGHTB);
            textFieldDataCorrida.setForeground(Colors.BRANCO);
            textFieldHoraCorrida.setBackground(Colors.CINZALIGHTB);
            textFieldHoraCorrida.setForeground(Colors.BRANCO);
            btnVoltar.setForeground(Colors.CINZADARKB);
            btnAdicionarPilotos.setBackground(Colors.VERDEDARK);
            btnAdicionarPilotos.setForeground(Colors.CINZADARKB);
            btnRemoverCorrida.setBackground(Colors.VERDEDARK);
            btnRemoverCorrida.setForeground(Colors.CINZADARKB);
            btnAdicionarCorrida.setBackground(Colors.VERDEDARK);
            btnAdicionarCorrida.setForeground(Colors.CINZADARKB);
            lblEnderecoKartodromo.setForeground(Colors.CINZALIGHTB);
            nomekartodromoLabel.setForeground(Colors.CINZALIGHTB);
            tipokartLabel.setForeground(Colors.CINZALIGHTB);
            lblHoraCorrida.setForeground(Colors.CINZALIGHTB);
            lblNumeroDeVoltas.setForeground(Colors.CINZALIGHTB);
            comboNomeKartodromo.setBackground(Colors.CINZALIGHTB);
            comboNomeKartodromo.setForeground(Colors.BRANCO);
            comboTipoDeKart.setBackground(Colors.CINZALIGHTB);
            comboTipoDeKart.setForeground(Colors.BRANCO);
        } else {
            fundo.setBackground(Colors.CINZAMEDA);
            drawer.setBackground(Colors.VERDEDARK);
            logo.setForeground(Colors.CINZAMEDB);
            informacoesPiloto.setForeground(Colors.BRANCO);
            lblNumeroDeVoltas.setForeground(Colors.CINZALIGHTB);
            lblNomeDaCorrida.setForeground(Colors.CINZALIGHTB);
            textFieldVoltasDaCorrida.setBackground(Colors.CINZALIGHTB);
            textFieldVoltasDaCorrida.setForeground(Colors.CINZADARKA);
            textFieldNomeCorrida.setBackground(Colors.CINZALIGHTB);
            textFieldNomeCorrida.setForeground(Colors.CINZADARKA);
            textFieldDataCorrida.setBackground(Colors.CINZALIGHTB);
            textFieldDataCorrida.setForeground(Colors.CINZADARKA);
            textFieldHoraCorrida.setBackground(Colors.CINZALIGHTB);
            textFieldHoraCorrida.setForeground(Colors.CINZADARKA);
            btnVoltar.setBackground(Colors.VERDEDARK);
            lblDataCorrida.setForeground(Colors.CINZALIGHTB);
            btnVoltar.setForeground(Colors.CINZADARKB);
            btnAdicionarPilotos.setBackground(Colors.VERDEDARK);
            btnAdicionarPilotos.setForeground(Colors.CINZADARKB);
            btnRemoverCorrida.setBackground(Colors.VERDEDARK);
            btnRemoverCorrida.setForeground(Colors.CINZADARKB);
            btnAdicionarCorrida.setBackground(Colors.VERDEDARK);
            btnAdicionarCorrida.setForeground(Colors.CINZADARKB);
            lblEnderecoKartodromo.setForeground(Colors.CINZALIGHTB);
            nomekartodromoLabel.setForeground(Colors.CINZALIGHTB);
            tipokartLabel.setForeground(Colors.CINZALIGHTB);
            lblNumeroDeVoltas.setForeground(Colors.CINZALIGHTB);
            lblHoraCorrida.setForeground(Colors.CINZALIGHTB);
            comboNomeKartodromo.setBackground(Colors.CINZALIGHTB);
            comboNomeKartodromo.setForeground(Colors.CINZADARKA);
            comboTipoDeKart.setBackground(Colors.CINZALIGHTB);
            comboTipoDeKart.setForeground(Colors.CINZADARKA);
        }
    }

    private void configs() {

        fundo.setSize(1100,600);
        drawer.setBounds(0, 0, 1100, 100);

        informacoesPiloto.setBounds(930, 3, 180, 100);
        informacoesPiloto.setPiloto(piloto);

        logo.setBounds(20, 30, 760, 35);
        logo.setText("GERENCIAR CORRIDAS - " + campeonato.getNome());
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

        scroll.setViewportView(table);
        scroll.setBounds(320, 140, 740, 350);

        renderer.setHorizontalTextPosition(JLabel.CENTER);
        table.setModel(tabelaPiloto);
        table.setDefaultRenderer(String.class, renderer);

        textFieldVoltasDaCorrida.setBorder(BorderFactory.createEmptyBorder());
        textFieldVoltasDaCorrida.setBounds(30, 205, 230, 35);
        textFieldVoltasDaCorrida.setHorizontalAlignment(JFormattedTextField.CENTER);
        textFieldVoltasDaCorrida.setFocusLostBehavior(JFormattedTextField.PERSIST);

        textFieldNomeCorrida.setBorder(BorderFactory.createEmptyBorder());
        textFieldNomeCorrida.setBounds(30, 140, 230, 35);
        textFieldNomeCorrida.setHorizontalAlignment(JFormattedTextField.CENTER);
        textFieldNomeCorrida.setFocusLostBehavior(JFormattedTextField.PERSIST);

        textFieldDataCorrida.setBorder(BorderFactory.createEmptyBorder());
        textFieldDataCorrida.setBounds(30, 335, 230, 35);
        textFieldDataCorrida.setHorizontalAlignment(JFormattedTextField.CENTER);
        textFieldDataCorrida.setFocusLostBehavior(JFormattedTextField.PERSIST);

        textFieldHoraCorrida.setBorder(BorderFactory.createEmptyBorder());
        textFieldHoraCorrida.setBounds(30, 270, 230, 35);
        textFieldHoraCorrida.setHorizontalAlignment(JFormattedTextField.CENTER);
        textFieldHoraCorrida.setFocusLostBehavior(JFormattedTextField.PERSIST);

        lblHoraCorrida.setText("Hora da corrida");
        lblHoraCorrida.setBounds(30, 240, 200, 35);

        lblDataCorrida.setText("Data da corrida");
        lblDataCorrida.setBounds(30, 305, 200, 35);

        lblNumeroDeVoltas.setText("Numero de voltas da corrida");
        lblNumeroDeVoltas.setBounds(30, 175, 200, 35);

        lblNomeDaCorrida.setText("Nome da corrida");
        lblNomeDaCorrida.setBounds(30, 110, 200, 35);

        tipokartLabel.setText("Tipo de Kart");
        tipokartLabel.setBounds(30, 435, 300, 35);

        comboTipoDeKart.setBorder(BorderFactory.createEmptyBorder());
        comboTipoDeKart.setBounds(30, 465, 150, 35);

        nomekartodromoLabel.setText("Kartódromo:");
        nomekartodromoLabel.setBounds(30, 370, 300, 30);

        comboNomeKartodromo.setBorder(BorderFactory.createEmptyBorder());
        comboNomeKartodromo.setBounds(30, 400, 150, 35);
        comboNomeKartodromo.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    mudarCombo();
                }
            }
        });

        lblEnderecoKartodromo.setBounds(30, 520, 250, 60);

        btnVoltar.setText("VOLTAR");
        btnVoltar.setBorderPainted(false);
        btnVoltar.setFocusPainted(false);
        btnVoltar.addActionListener(this);
        btnVoltar.setBounds(290, 530, 150, 35);

        btnRemoverCorrida.setFocusPainted(false);
        btnRemoverCorrida.setBorderPainted(false);
        btnRemoverCorrida.addActionListener(this);
        btnRemoverCorrida.setText("REMOVER CORRIDA");
        btnRemoverCorrida.setBounds(470, 530, 160, 35);

        btnAdicionarCorrida.setText("ADICIONAR CORRIDA");
        btnAdicionarCorrida.setBorderPainted(false);
        btnAdicionarCorrida.setFocusPainted(false);
        btnAdicionarCorrida.addActionListener(this);
        btnAdicionarCorrida.setBounds(660, 530, 180, 35);

        btnAdicionarPilotos.setFocusPainted(false);
        btnAdicionarPilotos.setBorderPainted(false);
        btnAdicionarPilotos.addActionListener(this);
        btnAdicionarPilotos.setText("ADICIONAR PILOTOS");
        btnAdicionarPilotos.setBounds(870, 530, 200, 35);

        try {
            textFieldVoltasDaCorrida.setFormatterFactory(new DefaultFormatterFactory(
                    new MaskFormatter("##")));
            textFieldNomeCorrida.setFormatterFactory(new DefaultFormatterFactory(
                    new MaskFormatter("????????????????????")));
            textFieldDataCorrida.setFormatterFactory(new DefaultFormatterFactory(
                    new MaskFormatter("##/##/####")));
            textFieldHoraCorrida.setFormatterFactory(new DefaultFormatterFactory(
                    new MaskFormatter("##:##")));
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
                new GerenciarCampeonato(piloto);

            }
        }

        if (e.getSource() == btnAdicionarPilotos) {

            if (JOptionPane.showConfirmDialog(null,
                    "Criar uma Corrida lhe torna automaticamente um ADM desta corrida,"
                            + " você tem certeza que deseja assumir essa responsabilidade?",
                    "Termo de responsabilidade",
                    JOptionPane.YES_NO_OPTION) == 0) {

                try {
                    if (new CorridaBO().validarTelaGerenciarCorrida(tabelaPiloto.getListCorrida(), campeonato)) {
                        dispose();
                        new GerenciarPiloto(piloto,
                                campeonato,
                                tabelamento,
                                tabelaPiloto.getListCorrida());
                    }
                } catch (Exception err) {
                    JOptionPane.showConfirmDialog(null, err.getMessage() , "Erro" , JOptionPane.PLAIN_MESSAGE);
                }

            }

        }

        if (e.getSource() == btnRemoverCorrida) {
            if (table.getSelectedRow() != -1) {
                tabelaPiloto.removeRow(table.getSelectedRow());
            }
        }

        if (e.getSource() == btnAdicionarCorrida) {

            String textoValorVoltas = textFieldVoltasDaCorrida.getText().replaceAll(" ", "");
            String textoValorHora = textFieldHoraCorrida.getText().replaceAll(" ", "");
            String textoValorData = textFieldDataCorrida.getText().replaceAll(" ", "");

            if (ValidarString.isApenasLetras(textFieldNomeCorrida.getText())) {
                if (ValidarString.isApenasNumeros(textoValorVoltas)) {
                    if (ValidarString.isHorario(textoValorHora)) {
                        if (ValidarString.isDataPadraoBRA(textoValorData)) {

                            try {

                                Corrida corrida = new Corrida();
                                corrida.setTipoKart(comboTipoDeKart.getSelectedItem().toString());
                                corrida.setKartodromo(new KartodromoBO().getById(comboNomeKartodromo.getSelectedIndex() + 1));
                                corrida.setNomeCorrida(textFieldNomeCorrida.getText());
                                corrida.setNumeroDeVoltas(Integer.valueOf(textoValorVoltas));
                                corrida.setDataDaCorrida(Tempo.stringToDate(textoValorData));
                                corrida.setHoraDaCorrida(Tempo.stringToTime(textoValorHora));
                                tabelaPiloto.addRow(corrida);

                            } catch (Exception error) {
                                JOptionPane.showMessageDialog(null, error.getMessage() , "Erro!" , JOptionPane.PLAIN_MESSAGE);
                            }

                        } else {
                            JOptionPane.showMessageDialog(null, "Adicionar data da corrida!" , "Erro!" , JOptionPane.PLAIN_MESSAGE);
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "Adicionar horário da corrida!" , "Erro!" , JOptionPane.PLAIN_MESSAGE);
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Adicionar voltas da corrida!" , "Erro!" , JOptionPane.PLAIN_MESSAGE);
                }

            } else {
                JOptionPane.showMessageDialog(null, "Adicionar nome para corrida" , "Erro!" , JOptionPane.PLAIN_MESSAGE);
            }

        }

    }

    private void mudarCombo() {

        try {

            kartodromo = new KartodromoBO().getById(comboNomeKartodromo.getSelectedIndex() + 1);
            comboTipoDeKart.removeAllItems();
            lblEnderecoKartodromo.setText("<html>Endereço: " + kartodromo.getEstado() + ", " + kartodromo.getCidade() + ", " + kartodromo.getRua() + ", n°" + kartodromo.getNumero() + "</html>");

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
