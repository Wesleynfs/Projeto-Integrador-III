package View;


import Bo.CampeonatoBO;
import Bo.CorridaBO;
import Bo.KartodromoBO;
import Bo.PilotoParticipandoCampeonatoBO;
import Model.Campeonato;
import Model.Corrida;
import Model.Kartodromo;
import Model.Piloto;
import Model.PilotoParticipandoCampeonato;
import Utilities.Colors;

import Utilities.Fonts;
import Utilities.Info;
import Utilities.Tempo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

public class GerenciarCampeonato extends JFrame implements ActionListener {

    private JPanel fundo;
    private JPanel drawer;
    private JComboBox<Object> comboNomeKartodromo;
    private JComboBox<String> comboTipoDeKart;
    private JComboBox<String> comboTipoCampeonato;
    private JFormattedTextField textFieldNomeCampeonato;
    private JFormattedTextField textFieldDataFinalCampeonato;
    private JLabel logo;
    private JLabel lblNomeCampeonato;
    private JLabel lblDataFinalCampeonato;
    private JLabel tipocorridaLabel;
    private JLabel nomekartodromoLabel;
    private JLabel tipokartLabel;
    private JLabel lblNumeroDeVoltas;
    private JLabel lblenderecokartodromo;
    private JButton btnVoltar;
    private JButton btnCriarCampeonato;
    private JButton btnAdicionarCorrida;

    private Kartodromo kartodromo;

    private List<Corrida> corridaList;

    public List<Corrida> getCorridaList() {
        return corridaList;
    }

    public void setCorridaList(List<Corrida> corridaList) {
        this.corridaList = corridaList;
    }

    private Piloto piloto;
    private Campeonato campeonato;

    public Campeonato getCampeonato() {
        return campeonato;
    }

    public void setCampeonato(Campeonato campeonato) {
        this.campeonato = campeonato;
    }

    public JButton getBtnCriarCampeonato() {
        return btnCriarCampeonato;
    }

    public void setBtnCriarCampeonato(JButton btnCriarCampeonato) {
        this.btnCriarCampeonato = btnCriarCampeonato;
    }

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
        btnAdicionarCorrida = new JButton();
        drawer = new JPanel();
        textFieldNomeCampeonato = new JFormattedTextField();
        textFieldDataFinalCampeonato = new JFormattedTextField();
        logo = new JLabel();
        lblNomeCampeonato = new JLabel();
        lblenderecokartodromo = new JLabel();
        lblDataFinalCampeonato = new JLabel();
        tipocorridaLabel = new JLabel();
        nomekartodromoLabel = new JLabel();
        tipokartLabel = new JLabel();
        lblNumeroDeVoltas = new JLabel();
        btnVoltar = new JButton();
        btnCriarCampeonato = new JButton();
        comboNomeKartodromo = new JComboBox<>();
        comboTipoDeKart = new JComboBox<>();
        comboTipoCampeonato = new JComboBox<>();
        campeonato = new Campeonato();
        corridaList = new ArrayList<>();

    }

    private void add() {
        add(btnAdicionarCorrida);
        add(comboNomeKartodromo);
        add(logo);
        add(comboTipoDeKart);
        add(comboTipoCampeonato);
        add(textFieldNomeCampeonato);
        add(lblenderecokartodromo);
        add(textFieldDataFinalCampeonato);
        add(lblNomeCampeonato);
        add(lblDataFinalCampeonato);
        add(tipocorridaLabel);
        add(nomekartodromoLabel);
        add(tipokartLabel);
        add(lblNumeroDeVoltas);
        add(btnVoltar);
        add(btnCriarCampeonato);
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
            lblNomeCampeonato.setForeground(Colors.CINZALIGHTB);
            lblDataFinalCampeonato.setForeground(Colors.CINZALIGHTB);
            lblenderecokartodromo.setForeground(Colors.CINZALIGHTB);
            tipocorridaLabel.setForeground(Colors.CINZALIGHTB);
            nomekartodromoLabel.setForeground(Colors.CINZALIGHTB);
            tipokartLabel.setForeground(Colors.CINZALIGHTB);
            lblNumeroDeVoltas.setForeground(Colors.CINZALIGHTB);
            logo.setForeground(Colors.CINZAMEDB);
            btnVoltar.setBackground(Colors.VERDEDARK);
            btnVoltar.setForeground(Colors.CINZADARKB);
            btnAdicionarCorrida.setBackground(Colors.VERDEDARK);
            btnAdicionarCorrida.setForeground(Colors.CINZADARKB);
            btnCriarCampeonato.setBackground(Colors.VERDEDARK);
            btnCriarCampeonato.setForeground(Colors.CINZADARKB);
            comboNomeKartodromo.setBackground(Colors.CINZALIGHTB);
            comboNomeKartodromo.setForeground(Colors.BRANCO);
            comboTipoDeKart.setBackground(Colors.CINZALIGHTB);
            comboTipoDeKart.setForeground(Colors.BRANCO);
            comboTipoCampeonato.setForeground(Colors.BRANCO);
            comboTipoCampeonato.setBackground(Colors.CINZALIGHTB);
        } else {
            fundo.setBackground(Colors.CINZAMEDA);
            drawer.setBackground(Colors.VERDEDARK);
            textFieldNomeCampeonato.setBackground(Colors.CINZALIGHTB);
            textFieldNomeCampeonato.setForeground(Colors.CINZADARKA);
            textFieldDataFinalCampeonato.setBackground(Colors.CINZALIGHTB);
            textFieldDataFinalCampeonato.setForeground(Colors.CINZADARKA);
            lblNomeCampeonato.setForeground(Colors.CINZALIGHTB);
            lblDataFinalCampeonato.setForeground(Colors.CINZALIGHTB);
            lblenderecokartodromo.setForeground(Colors.CINZALIGHTB);
            tipocorridaLabel.setForeground(Colors.CINZALIGHTB);
            nomekartodromoLabel.setForeground(Colors.CINZALIGHTB);
            tipokartLabel.setForeground(Colors.CINZALIGHTB);
            lblNumeroDeVoltas.setForeground(Colors.CINZALIGHTB);
            logo.setForeground(Colors.CINZAMEDB);
            btnVoltar.setBackground(Colors.VERDEDARK);
            btnVoltar.setForeground(Colors.CINZADARKB);
            btnAdicionarCorrida.setBackground(Colors.VERDEDARK);
            btnAdicionarCorrida.setForeground(Colors.CINZADARKB);
            btnCriarCampeonato.setBackground(Colors.VERDEDARK);
            btnCriarCampeonato.setForeground(Colors.CINZADARKB);
            comboNomeKartodromo.setBackground(Colors.CINZALIGHTB);
            comboNomeKartodromo.setForeground(Colors.CINZADARKA);
            comboTipoDeKart.setBackground(Colors.CINZALIGHTB);
            comboTipoDeKart.setForeground(Colors.CINZADARKA);
            comboTipoCampeonato.setBackground(Colors.CINZALIGHTB);
            comboTipoCampeonato.setForeground(Colors.CINZADARKA);
        }
    }

    private void configs() {

        fundo.setSize(Info.MINSCREENSIZE);
        drawer.setBounds(0, 0, 800, 100);

        lblNomeCampeonato.setText("NOME DO CAMPEONATO:");
        lblNomeCampeonato.setBounds(60, 185, 200, 35);

        textFieldNomeCampeonato.setBorder(BorderFactory.createEmptyBorder());
        textFieldNomeCampeonato.setBounds(60, 215, 300, 35);
        textFieldNomeCampeonato.setHorizontalAlignment(JFormattedTextField.CENTER);

        textFieldDataFinalCampeonato.setBorder(BorderFactory.createEmptyBorder());
        textFieldDataFinalCampeonato.setBounds(60, 340, 300, 35);
        textFieldDataFinalCampeonato.setHorizontalAlignment(JFormattedTextField.CENTER);

        try {
            textFieldDataFinalCampeonato.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("##/##/####")));

            for (Kartodromo tipo : new KartodromoBO().listarTodos()) {
                comboNomeKartodromo.addItem(tipo.getNomeKartodromo());
            }


        } catch (Exception error) {
            JOptionPane.showMessageDialog(null, "Não foi possível carregar a tela criar campeonato");
        }

        lblDataFinalCampeonato.setText("DATA DO CAMPEONATO:");
        lblDataFinalCampeonato.setBounds(60, 310, 200, 35);

        tipocorridaLabel.setText("STATUS DO CAMPEONATO:");
        tipocorridaLabel.setBounds(60, 250, 200, 35);

        comboTipoCampeonato.setBorder(BorderFactory.createEmptyBorder());
        comboTipoCampeonato.setBounds(60, 280, 300, 35);

        if (kartodromo == null) {
            mudarCombo();
        }

        lblenderecokartodromo.setBounds(440, 265, 300, 60);

        comboTipoCampeonato.addItem("CAMPEONATO NORMAL (CORRIDA RÁPIDA)");
        comboTipoCampeonato.addItem("CAMPEONATO OFICIAL (VALE PONTUAÇÕES)");

        logo.setBounds(20, 30, 600, 35);
        logo.setText("GERENCIAR CAMPEONATOS");
        logo.setFont(Fonts.SANSSERIFMIN);

        comboTipoDeKart.setBorder(BorderFactory.createEmptyBorder());
        comboTipoDeKart.setBounds(440, 340, 300, 35);

        nomekartodromoLabel.setText("KARTÓDROMO:");
        nomekartodromoLabel.setBounds(440, 185, 300, 35);

        comboNomeKartodromo.setBorder(BorderFactory.createEmptyBorder());
        comboNomeKartodromo.setBounds(440, 215, 300, 35);

        comboNomeKartodromo.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    mudarCombo();
                }
            }
        });

        tipokartLabel.setText("TIPO DE KART:");
        tipokartLabel.setBounds(440, 310, 300, 35);

        btnVoltar.setText("VOLTAR");
        btnVoltar.setBorderPainted(false);
        btnVoltar.setFocusPainted(false);
        btnVoltar.addActionListener(this);
        btnVoltar.setBounds(20, 550, 100, 35);

        btnCriarCampeonato.setFocusPainted(false);
        btnCriarCampeonato.setBorderPainted(false);
        btnCriarCampeonato.addActionListener(this);
        btnCriarCampeonato.setText("CRIAR CAMPEONATO");
        btnCriarCampeonato.setBounds(570, 550, 210, 35);
        btnCriarCampeonato.setVisible(false);

        btnAdicionarCorrida.setFocusPainted(false);
        btnAdicionarCorrida.setBorderPainted(false);
        btnAdicionarCorrida.addActionListener(this);
        btnAdicionarCorrida.setText("ADICIONAR CORRIDA");
        btnAdicionarCorrida.setBounds(100, 400, 190, 35);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnVoltar) {
            dispose();
            new PerfilPiloto(piloto);
        }

        if (e.getSource() == btnCriarCampeonato) {

            switch (JOptionPane.showConfirmDialog(null,
                    "Criar uma Corrida lhe torna automaticamente um ADM desta corrida,"
                            + " você tem certeza que deseja assumir essa responsabilidade?",
                    "Termo de responsabilidade",
                    JOptionPane.YES_NO_OPTION)) {
                case 0:

                    campeonato.setDataFinalizacao(Tempo.stringToDate(textFieldDataFinalCampeonato.getText()));
                    campeonato.setNome(textFieldNomeCampeonato.getText());
                    campeonato.setSituacao("Aguardando Participantes");
                    campeonato.setTipoCorrida(comboTipoCampeonato.getSelectedItem().toString());
                    campeonato.setTipoKart(this.comboTipoDeKart.getSelectedItem().toString());
                    campeonato.setDataCadastro(Tempo.getCurrentTime());
                    PilotoParticipandoCampeonato pilotoadm = new PilotoParticipandoCampeonato();

                    pilotoadm.setPiloto(piloto);
                    pilotoadm.setStatusAdm(true);
                    pilotoadm.setCampeonato(campeonato);
                    pilotoadm.setPontuacao(0);
                    pilotoadm.setPosicao(0);

                    try {

                        new CampeonatoBO().criar(campeonato);

                        CorridaBO corridabo = new CorridaBO();
                        for (Corrida corrida : getCorridaList()) {
                            corrida.setCampeonato(campeonato);
                            corridabo.criar(corrida);
                        }

                        new PilotoParticipandoCampeonatoBO().criar(pilotoadm);

                    } catch (Exception err) {
                        JOptionPane.showMessageDialog(null,
                                err.getMessage(),
                                "Erro", JOptionPane.PLAIN_MESSAGE);
                    }

                    dispose();
                    new PerfilPiloto(piloto);

                    break;
                    
                default: JOptionPane.showMessageDialog(null, "Ação cancelada! retornando ao menu principal!");
            }

        }

        if (e.getSource() == btnAdicionarCorrida) {

            campeonato.setNome(textFieldNomeCampeonato.getText());
            campeonato.setKartodromo(campeonato.getKartodromo());
            campeonato.setDataFinalizacao(Tempo.stringToDate(textFieldDataFinalCampeonato.getText()));

            this.setVisible(false);
            new CriarCorrida(piloto, campeonato, this);
        }

    }

    private void mudarCombo() {

        try {

            kartodromo = new KartodromoBO().getById(comboNomeKartodromo.getSelectedIndex() + 1);
            campeonato.setKartodromo(kartodromo);
            comboTipoDeKart.removeAllItems();
            lblenderecokartodromo.setText("<html>Endereço: " + campeonato.getKartodromo().getEstado() + ", " + campeonato.getKartodromo().getCidade() + ", " + campeonato.getKartodromo().getRua() + ", n°" + campeonato.getKartodromo().getNumero() + "</html>" );

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
