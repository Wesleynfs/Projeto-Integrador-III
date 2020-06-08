package View;

import Bo.*;
import Model.Campeonato;
import Model.Corrida;
import Model.Piloto;
import Model.PilotoParticipaCorrida;
import Model.PilotoParticipandoCampeonato;
import Utilities.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

public class IniciarCampeonatoPt2 extends JFrame implements ActionListener {

    private JPanel fundo;
    private JPanel drawer;
    private JButton btnVoltar;
    private JButton btndarfalta;
    private JButton btndarpresenca;
    private JButton btnIniciarCorridaCampeonato;
    private JButton btnAdicionarTempoDeCorrida;
    private JLabel logo;
    private JLabel SelecioneLabel;
    private JLabel lblSelecionarCorridaDoCampeonato;
    private JLabel labelAdicionarTempo;
    private JLabel labelAdicionarTempoExemplo;
    private JScrollPane jScrollPaneParticipantes;
    private InformacoesPiloto informacoesPiloto;
    private JTable tableParticipantesStatus;
    private DefaultTableModel tabelamento;
    private JFormattedTextField textfieldAdicionarTempo;
    private JComboBox<String> comboBoxCorridas;

    private Piloto piloto;
    private Campeonato campeonato;

    public IniciarCampeonatoPt2(Piloto piloto, Campeonato campeonato) {
        this.piloto = piloto;
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
        setSize(800, 620);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle(Info.APP_NAME);
        setResizable(false);
    }

    private void initializate() {

        btnAdicionarTempoDeCorrida = new JButton();
        textfieldAdicionarTempo = new JFormattedTextField();
        fundo = new JPanel();
        drawer = new JPanel();
        btnVoltar = new JButton();
        btnIniciarCorridaCampeonato = new JButton();
        comboBoxCorridas = new JComboBox<>();
        logo = new JLabel();
        lblSelecionarCorridaDoCampeonato = new JLabel();
        jScrollPaneParticipantes = new JScrollPane();
        tableParticipantesStatus = new JTable();
        SelecioneLabel = new JLabel();
        labelAdicionarTempoExemplo = new JLabel();
        labelAdicionarTempo = new JLabel();
        btndarfalta = new JButton();
        btndarpresenca = new JButton();
        informacoesPiloto = new InformacoesPiloto();

    }

    private void add() {
        add(btnVoltar);
        add(btnIniciarCorridaCampeonato);
        add(logo);
        add(textfieldAdicionarTempo);
        add(lblSelecionarCorridaDoCampeonato);
        add(SelecioneLabel);
        add(labelAdicionarTempoExemplo);
        add(btndarfalta);
        add(btnAdicionarTempoDeCorrida);
        add(btndarpresenca);
        add(labelAdicionarTempo);
        add(comboBoxCorridas);
        add(informacoesPiloto);
        add(jScrollPaneParticipantes);
        add(drawer);
        add(fundo);
    }

    private void setTheme() {
        if (SplashScreen.getConfiguracao().isTema()) {
            // Se o tema for escuro, os itens ficam assim //
            fundo.setBackground(Colors.CINZAMEDB);
            drawer.setBackground(Colors.VERDEDARK);
            btnVoltar.setForeground(Colors.CINZADARKB);
            btnVoltar.setBackground(Colors.VERDEDARK);
            btnIniciarCorridaCampeonato.setForeground(Colors.CINZADARKB);
            btnIniciarCorridaCampeonato.setBackground(Colors.VERDEDARK);
            btnAdicionarTempoDeCorrida.setForeground(Colors.CINZADARKB);
            btnAdicionarTempoDeCorrida.setBackground(Colors.VERDEDARK);
            logo.setForeground(Colors.CINZAMEDB);
            textfieldAdicionarTempo.setBackground(Colors.CINZALIGHTB);
            textfieldAdicionarTempo.setForeground(Colors.BRANCO);
            tableParticipantesStatus.setBackground(Colors.VERDELIGHT);
            tableParticipantesStatus.setForeground(Colors.CINZADARKB);
            SelecioneLabel.setForeground(Colors.CINZAMEDA);
            btndarfalta.setForeground(Colors.CINZADARKB);
            btndarfalta.setBackground(Colors.VERDEDARK);
            comboBoxCorridas.setBackground(Colors.VERDEDARK);
            comboBoxCorridas.setForeground(Colors.CINZADARKB);
            btndarpresenca.setForeground(Colors.CINZADARKB);
            btndarpresenca.setBackground(Colors.VERDEDARK);
            labelAdicionarTempoExemplo.setForeground(Colors.BRANCO);
            informacoesPiloto.setForeground(Colors.CINZAMEDB);
            labelAdicionarTempo.setForeground(Colors.BRANCO);
            lblSelecionarCorridaDoCampeonato.setForeground(Colors.BRANCO);

        } else {

            fundo.setBackground(Colors.CINZAMEDA);
            drawer.setBackground(Colors.VERDEDARK);
            textfieldAdicionarTempo.setBackground(Colors.CINZALIGHTB);
            textfieldAdicionarTempo.setForeground(Colors.BRANCO);
            lblSelecionarCorridaDoCampeonato.setForeground(Colors.CINZADARKB);
            btnVoltar.setForeground(Colors.CINZADARKB);
            btnVoltar.setBackground(Colors.VERDEDARK);
            comboBoxCorridas.setForeground(Colors.CINZADARKB);
            comboBoxCorridas.setBackground(Colors.VERDEDARK);
            informacoesPiloto.setForeground(Colors.BRANCO);
            btnIniciarCorridaCampeonato.setForeground(Colors.CINZADARKB);
            btnIniciarCorridaCampeonato.setBackground(Colors.VERDEDARK);
            btnAdicionarTempoDeCorrida.setForeground(Colors.CINZADARKB);
            btnAdicionarTempoDeCorrida.setBackground(Colors.VERDEDARK);
            logo.setForeground(Colors.CINZAMEDB);
            labelAdicionarTempoExemplo.setForeground(Colors.CINZADARKB);
            tableParticipantesStatus.setForeground(Colors.CINZADARKB);
            tableParticipantesStatus.setBackground(Colors.VERDEDARK);
            SelecioneLabel.setForeground(Colors.CINZALIGHTB);
            labelAdicionarTempo.setForeground(Colors.CINZALIGHTB);
            btndarfalta.setForeground(Colors.CINZADARKB);
            btndarfalta.setBackground(Colors.VERDEDARK);
            btndarpresenca.setForeground(Colors.CINZADARKB);
            btndarpresenca.setBackground(Colors.VERDEDARK);

        }
    }

    private void configs() {

        fundo.setBounds(0, 0, 800, 620);
        drawer.setBounds(0, 0, 800, 100);
        informacoesPiloto.setBounds(630, 3, 200, 100);
        informacoesPiloto.setPiloto(piloto);

        try {

            tableParticipantesStatus.setModel(new DefaultTableModel(
                    new Object[][]{

                    },
                    new String[]{
                            "APELIDO DO PARTICIPANTE", "STATUS", "TEMPO PILOTO"
                    }
            ) {
                boolean[] canEdit = new boolean[]{
                        false, false
                };

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit[columnIndex];
                }

            });

            tabelamento = (DefaultTableModel) tableParticipantesStatus.getModel();

            for (PilotoParticipandoCampeonato pilotosparticipantes : new PilotoParticipandoCampeonatoBO().listarTodosPilotosQuePilotoParticipaNoCampeonato(campeonato)) {
                tabelamento.addRow(new Object[]{
                        pilotosparticipantes.getPiloto().getApelido(),
                        "FALTOU",
                        "00:00.000"
                });

            }

            jScrollPaneParticipantes.setViewportView(tableParticipantesStatus);
            jScrollPaneParticipantes.setBounds(60, 150, 680, 250);

            logo.setFont(Fonts.SANSSERIFMIN);
            logo.setBounds(20, 30, 500, 35);
            logo.setText("QUAIS FORAM OS RESULTADOS?");

            SelecioneLabel.setBounds(60, 120, 730, 35);
            SelecioneLabel.setText("Selecione os pilotos participantes para atribuir uma FALTA ou uma PRESENÇA, e o TEMPO de corrida do mesmo!");

            btndarfalta.setBorderPainted(false);
            btndarfalta.setFocusPainted(false);
            btndarfalta.addActionListener(this);
            btndarfalta.setBounds(540, 510, 230, 35);
            btndarfalta.setText("Atribuir Falta ao Piloto");

            btndarpresenca.setBorderPainted(false);
            btndarpresenca.setFocusPainted(false);
            btndarpresenca.addActionListener(this);
            btndarpresenca.setBounds(540, 460, 230, 35);
            btndarpresenca.setText("Atribuir Presenca ao Piloto");

            btnAdicionarTempoDeCorrida.setBorderPainted(false);
            btnAdicionarTempoDeCorrida.setFocusPainted(false);
            btnAdicionarTempoDeCorrida.addActionListener(this);
            btnAdicionarTempoDeCorrida.setBounds(540, 410, 230, 35);
            btnAdicionarTempoDeCorrida.setText("Atribuir Tempo ao Piloto");

            labelAdicionarTempo.setText("Tempo de corrida FINAL do piloto");
            labelAdicionarTempo.setBounds(60, 455, 350, 35);

            labelAdicionarTempoExemplo.setText("Exemplo: 02:45.578 > Minutos,Segundos,Milésimos");
            labelAdicionarTempoExemplo.setBounds(60, 475, 350, 35);

            textfieldAdicionarTempo.setBounds(60, 510, 200, 35);
            textfieldAdicionarTempo.setHorizontalAlignment(JFormattedTextField.CENTER);
            textfieldAdicionarTempo.setBorder(BorderFactory.createEmptyBorder());

            try {
                textfieldAdicionarTempo.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("##:##.###")));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.PLAIN_MESSAGE);
            }

            btnIniciarCorridaCampeonato.setBorderPainted(false);
            btnIniciarCorridaCampeonato.setFocusPainted(false);
            btnIniciarCorridaCampeonato.addActionListener(this);
            btnIniciarCorridaCampeonato.setBounds(540, 560, 230, 35);
            btnIniciarCorridaCampeonato.setText("Iniciar Corrida do Campeonato");

            btnVoltar.setBorderPainted(false);
            btnVoltar.setFocusPainted(false);
            btnVoltar.addActionListener(this);
            btnVoltar.setBounds(60, 560, 200, 35);
            btnVoltar.setText("Voltar");

            criarPilotosDaCorrida();

            lblSelecionarCorridaDoCampeonato.setText("Selecione a corrida");
            lblSelecionarCorridaDoCampeonato.setBounds(60, 395, 200, 35);

            comboBoxCorridas.setBorder(BorderFactory.createEmptyBorder());
            comboBoxCorridas.setBounds(60, 425, 200, 35);
            comboBoxCorridas.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        mudarTabelaCorrida();
                    }
                }
            });
            for (Corrida corridas : new CorridaBO().listarTodasAsCorridasMarcadas(campeonato)) {
                comboBoxCorridas.addItem(corridas.getNomeCorrida());
            }

            mudarTabelaCorrida();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        int[] todasAsLinhasSelecionadas = tableParticipantesStatus.getSelectedRows();

        if (e.getSource() == btnVoltar) {
            dispose();
            new IniciarCampeonatoPt1(piloto);
        }

        if (e.getSource() == btndarfalta) {
            if (todasAsLinhasSelecionadas.length != 0) {
                for (int x = 0; x < todasAsLinhasSelecionadas.length; x++) {
                    if (piloto.getApelido().equals(tableParticipantesStatus.getValueAt(todasAsLinhasSelecionadas[x], 0))) {
                        JOptionPane.showMessageDialog(null, "Você não pode dar falta a você mesmo!");
                    } else {
                        tableParticipantesStatus.setValueAt("FALTOU", todasAsLinhasSelecionadas[x], 1);
                        mudarStatusPresencaPiloto(x);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Selecione um piloto!");
            }
        }

        if (e.getSource() == btnAdicionarTempoDeCorrida) {
            if (todasAsLinhasSelecionadas.length != 0) {
                for (int x = 0; x < todasAsLinhasSelecionadas.length; x++) {
                    tableParticipantesStatus.setValueAt(textfieldAdicionarTempo.getText().replaceAll(" " , ""), todasAsLinhasSelecionadas[x], 2);
                    mudarTempoPiloto(tableParticipantesStatus.getSelectedRow());
                }
            } else {
                JOptionPane.showMessageDialog(null, "Selecione um piloto!");
            }
        }

        if (e.getSource() == btndarpresenca) {
            if (todasAsLinhasSelecionadas.length != 0) {
                for (int x = 0; x < todasAsLinhasSelecionadas.length; x++) {
                    tableParticipantesStatus.setValueAt("PRESENTE", todasAsLinhasSelecionadas[x], 1);
                    mudarStatusPresencaPiloto(x);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Selecione um piloto!");
            }
        }

        if (e.getSource() == btnIniciarCorridaCampeonato) {
            try {
                if (new CorridaBO().validarTelaResultadosTabelaDeParticipantes(tableParticipantesStatus)) {
                    for (int x = 0; x < tableParticipantesStatus.getRowCount(); x++) {
                        try {
                            for (Corrida corridas : new CorridaBO().listarTodasAsCorridasMarcadas(campeonato)) {
                                for (PilotoParticipaCorrida pilotoCorrida : new PilotoParticipaCorridaBO().listarPilotoCorridaOrderApelido(corridas)) {
                                    if (pilotoCorrida.isStatusPresenca() == false) {
                                        Piloto pilotoStrike = pilotoCorrida.getPilotoParticipaCampeonato().getPiloto();
                                        pilotoStrike.setNumeroDeStrikesPiloto(pilotoStrike.getNumeroDeStrikesPiloto() + 1);
                                        if (pilotoStrike.getNumeroDeStrikesPiloto() > 3) {
                                            pilotoStrike.setAtivo(false);
                                        }
                                        new PilotoBO().alterar(pilotoStrike);
                                    }
                                }
                            }
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, "Não foi pssivel modificar o status dos pilotos!");
                        }
                    }
                    dispose();
                    new ResultadosCampeonato(piloto, campeonato);
                }
            } catch (Exception err) {
                JOptionPane.showMessageDialog(null,err.getMessage(),"Erro",JOptionPane.PLAIN_MESSAGE);
            }
        }
    }

    public void criarPilotosDaCorrida() throws Exception {
        for (PilotoParticipandoCampeonato pilotoparticipacampeonato : new PilotoParticipandoCampeonatoBO().listarTodosPilotosQuePilotoParticipaNoCampeonato(campeonato)) {
            for (Corrida corrida : new CorridaBO().listarTodasAsCorridasMarcadas(campeonato)) {
                PilotoParticipaCorrida pilotocorrida = new PilotoParticipaCorrida();
                pilotocorrida.setStatusPresenca(true);
                if (new PilotoParticipaCorridaBO().listarPilotoApelidoCorrida(corrida, pilotoparticipacampeonato.getPiloto().getApelido()) == null) {
                    pilotocorrida.setCorrida(corrida);
                    pilotocorrida.setPilotoparticipacampeonato(pilotoparticipacampeonato);
                    new PilotoParticipaCorridaBO().criar(pilotocorrida);
                } else {
                    PilotoParticipaCorrida pilotocorridaaltera = new PilotoParticipaCorridaBO().listarPilotoApelidoCorrida(corrida, pilotoparticipacampeonato.getPiloto().getApelido());
                    new PilotoParticipaCorridaBO().alterar(pilotocorridaaltera);
                }
            }
        }
    }

    public void mudarTempoPiloto(int linhaDoPiloto) {
        try {
            Corrida corrida = new CorridaBO().getByNome(comboBoxCorridas.getSelectedItem().toString());
            PilotoParticipaCorrida pilotocorrida = new PilotoParticipaCorridaBO().listarPilotoApelidoCorrida(corrida, tableParticipantesStatus.getValueAt(linhaDoPiloto, 0).toString());
            pilotocorrida.setTempoAoTerminar(Tempo.stringToLapTime(tableParticipantesStatus.getValueAt(linhaDoPiloto, 2).toString()));
            new PilotoParticipaCorridaBO().alterar(pilotocorrida);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.PLAIN_MESSAGE);
        }
    }

    public void mudarStatusPresencaPiloto(int linhaDoPiloto) {
        try {
            Corrida corrida = new CorridaBO().getByNome(comboBoxCorridas.getSelectedItem().toString());
            PilotoParticipaCorrida pilotocorrida = new PilotoParticipaCorridaBO().listarPilotoApelidoCorrida(corrida, tableParticipantesStatus.getValueAt(linhaDoPiloto, 0).toString());
            if (tableParticipantesStatus.getValueAt(linhaDoPiloto, 1).equals("PRESENTE")) {
                pilotocorrida.setStatusPresenca(true);
            } else {
                pilotocorrida.setStatusPresenca(false);
            }
            new PilotoParticipaCorridaBO().alterar(pilotocorrida);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "não foi possível mutar o status", "Erro", JOptionPane.PLAIN_MESSAGE);
        }
    }

    public void mudarTabelaCorrida() {

        try {
            tableParticipantesStatus.setModel(new DefaultTableModel(
                    new Object[][]{

                    },
                    new String[]{
                            "NOME DO PARTICIPANTE", "STATUS", "TEMPO PILOTO"
                    }
            ) {
                boolean[] canEdit = new boolean[]{
                        false, false, false
                };

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit[columnIndex];
                }

            });

            tabelamento = (DefaultTableModel) tableParticipantesStatus.getModel();
            Corrida corrida = new CorridaBO().getByNome(comboBoxCorridas.getSelectedItem().toString());
            String presenca = null;

            List<PilotoParticipaCorrida> pilotoParticipaCorridaList = new PilotoParticipaCorridaBO().listarPilotoCorridaOrderApelido(corrida);

            for (PilotoParticipaCorrida pilotoscorrida : pilotoParticipaCorridaList) {
                if (pilotoscorrida.isStatusPresenca()) {
                    presenca = "PRESENTE";
                } else {
                    presenca = "FALTOU";
                }
                tabelamento.addRow(new Object[]{
                        pilotoscorrida.getPilotoParticipaCampeonato().getPiloto().getApelido(),
                        presenca
                });
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível Localizar Corridas na Combo");
        }

    }


} 

