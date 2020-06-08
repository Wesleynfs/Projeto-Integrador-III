package View;

import Bo.CorridaBO;
import Bo.PilotoParticipaCorridaBO;
import Bo.PilotoParticipandoCampeonatoBO;
import Model.*;
import Utilities.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.table.DefaultTableModel;


public class ResultadoCorrida extends JFrame implements ActionListener {

    private JPanel fundo;
    private JPanel drawer;
    private JButton btnFinalizarCorrida;
    private JLabel logo;
    private JLabel ReultadodacorridaLabel;
    private JLabel GanhadorLabel;
    private InformacoesPiloto informacoesPiloto;
    private JScrollPane jScrollPaneCorrida;
    private JTable tabelaCorrida;
    private JLabel campeonatosLabel;

    private JButton btnOrdenarPorPosicao;
    private JButton btnOrdenarPorApelido;
    private JButton btnApenasPilotoAtual;

    private JComboBox<String> CorridasjComboBox;


    private DefaultTableModel tabelamento;

    private Piloto piloto;
    private Campeonato campeonato;

    public ResultadoCorrida(Piloto piloto, Campeonato campeonato) {
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
        setSize(Info.MAXSCREENSIZE);
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

        CorridasjComboBox = new JComboBox<>();
        campeonatosLabel = new JLabel();
        informacoesPiloto = new InformacoesPiloto();
        btnFinalizarCorrida = new JButton();
        btnOrdenarPorPosicao = new JButton();
        btnApenasPilotoAtual = new JButton();
        btnOrdenarPorApelido = new JButton();

        logo = new JLabel();
        ReultadodacorridaLabel = new JLabel();
        GanhadorLabel = new JLabel();

        jScrollPaneCorrida = new JScrollPane();
        tabelaCorrida = new JTable();

    }

    private void add() {
        add(btnFinalizarCorrida);
        add(informacoesPiloto);
        add(ReultadodacorridaLabel);
        add(GanhadorLabel);
        add(jScrollPaneCorrida);
        add(campeonatosLabel);
        add(CorridasjComboBox);
        add(btnOrdenarPorPosicao);
        add(btnApenasPilotoAtual);
        add(btnOrdenarPorApelido);
        add(logo);
        add(drawer);
        add(fundo);
    }

    private void setTheme() {
        if (SplashScreen.getConfiguracao().isTema()) {
            // Se o tema for escuro, os itens ficam assim //
            fundo.setBackground(Colors.CINZAMEDB);
            drawer.setBackground(Colors.VERDEDARK);

            logo.setForeground(Colors.CINZAMEDB);
            tabelaCorrida.setBackground(Colors.VERDELIGHT);
            campeonatosLabel.setForeground(Colors.CINZAMEDA);
            informacoesPiloto.setForeground(Colors.CINZAMEDB);
            tabelaCorrida.setForeground(Colors.CINZADARKB);
            GanhadorLabel.setForeground(Colors.CINZAMEDA);
            ReultadodacorridaLabel.setForeground(Colors.CINZAMEDA);
            CorridasjComboBox.setBackground(Colors.VERDEDARK);
            CorridasjComboBox.setForeground(Colors.CINZADARKB);
            btnFinalizarCorrida.setForeground(Colors.CINZADARKB);
            btnFinalizarCorrida.setBackground(Colors.VERDEDARK);
            btnOrdenarPorPosicao.setForeground(Colors.CINZADARKB);
            btnApenasPilotoAtual.setForeground(Colors.CINZADARKB);
            btnOrdenarPorApelido.setForeground(Colors.CINZADARKB);
            btnOrdenarPorPosicao.setBackground(Colors.VERDEDARK);
            btnApenasPilotoAtual.setBackground(Colors.VERDEDARK);
            btnOrdenarPorApelido.setBackground(Colors.VERDEDARK);

        } else {

            fundo.setBackground(Colors.CINZAMEDA);
            drawer.setBackground(Colors.VERDEDARK);
            logo.setForeground(Colors.CINZAMEDB);
            CorridasjComboBox.setForeground(Colors.CINZADARKB);
            informacoesPiloto.setForeground(Colors.BRANCO);
            CorridasjComboBox.setBackground(Colors.VERDEDARK);
            tabelaCorrida.setForeground(Colors.CINZADARKB);
            tabelaCorrida.setBackground(Colors.VERDEDARK);
            GanhadorLabel.setForeground(Colors.CINZALIGHTB);
            ReultadodacorridaLabel.setForeground(Colors.CINZALIGHTB);
            btnFinalizarCorrida.setForeground(Colors.CINZADARKB);
            campeonatosLabel.setForeground(Colors.CINZALIGHTB);
            btnFinalizarCorrida.setBackground(Colors.VERDEDARK);
            btnOrdenarPorPosicao.setForeground(Colors.CINZADARKB);
            btnApenasPilotoAtual.setForeground(Colors.CINZADARKB);
            btnOrdenarPorApelido.setForeground(Colors.CINZADARKB);
            btnOrdenarPorPosicao.setBackground(Colors.VERDEDARK);
            btnApenasPilotoAtual.setBackground(Colors.VERDEDARK);
            btnOrdenarPorApelido.setBackground(Colors.VERDEDARK);

        }
    }

    private void configs() {

        fundo.setSize(Info.MAXSCREENSIZE);

        drawer.setBounds(0, 0, 1280, 100);

        informacoesPiloto.setBounds(1100, 3, 200, 100);
        informacoesPiloto.setPiloto(piloto);

        try {
            jScrollPaneCorrida.setViewportView(tabelaCorrida);
            jScrollPaneCorrida.setBounds(30, 150, 1200, 400);

            logo.setFont(Fonts.SANSSERIFMIN);
            logo.setBounds(20, 30, 760, 35);
            logo.setText("RESULTADO DA CORRIDA - " + campeonato.getNome());

            ReultadodacorridaLabel.setBounds(30, 110, 300, 35);
            ReultadodacorridaLabel.setText("RESULTADO DE " + campeonato.getNome());

            GanhadorLabel.setBounds(180, 610, 300, 35);

            btnFinalizarCorrida.setBorderPainted(false);
            btnFinalizarCorrida.setFocusPainted(false);
            btnFinalizarCorrida.addActionListener(this);
            btnFinalizarCorrida.setBounds(180, 640, 200, 35);
            btnFinalizarCorrida.setText("FINALIZAR CAMPEONATO");

            btnOrdenarPorPosicao.setBorderPainted(false);
            btnOrdenarPorPosicao.setFocusPainted(false);
            btnOrdenarPorPosicao.addActionListener(this);
            btnOrdenarPorPosicao.setText("ORDENAR POR POSIÇÃO");
            btnOrdenarPorPosicao.setBounds(1040, 650, 200, 35);

            campeonatosLabel.setText("Selecionar resultado da corrida:");
            campeonatosLabel.setBounds(805, 580, 250, 35);

            btnApenasPilotoAtual.setBorderPainted(false);
            btnApenasPilotoAtual.setFocusPainted(false);
            btnApenasPilotoAtual.addActionListener(this);
            btnApenasPilotoAtual.setText("APEANAS SEU RESULTADO");
            btnApenasPilotoAtual.setBounds(805, 650, 200, 35);

            btnOrdenarPorApelido.setBorderPainted(false);
            btnOrdenarPorApelido.setFocusPainted(false);
            btnOrdenarPorApelido.addActionListener(this);
            btnOrdenarPorApelido.setText("ORDENAR POR PILOTO");
            btnOrdenarPorApelido.setBounds(1040, 610, 200, 35);

            CorridasjComboBox.setBorder(BorderFactory.createEmptyBorder());
            CorridasjComboBox.setBounds(805, 640, 200, 35);
            CorridasjComboBox.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        mudarTabelaCorrida();
                    }
                }
            });
            for (Corrida corridas : new CorridaBO().listarTodasAsCorridasMarcadas(campeonato)) {
                CorridasjComboBox.addItem(corridas.getNomeCorrida());
            }


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnFinalizarCorrida) {
            dispose();
            new PerfilPiloto(piloto);
        }

        if (e.getSource() == this.btnOrdenarPorPosicao) {

            try {
                
                Corrida corrida = new CorridaBO().getByNome(CorridasjComboBox.getSelectedItem().toString());
                configtabela();
                for (PilotoParticipaCorrida pilotocorrida : new PilotoParticipaCorridaBO().listarPilotoCorridaOrderPontuacao(corrida)) {
                    tabelamento.addRow(new Object[]{
                            pilotocorrida.getCorrida().getNomeCorrida(),
                            pilotocorrida.getPilotoParticipaCampeonato().getPiloto().getApelido(),
                            Tempo.lapTimeToString(pilotocorrida.getTempoAoTerminar()),
                            pilotocorrida.getPosicao(),
                            pilotocorrida.getPontuacao()
                    });
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Não foi possível Criar o resultado");
            }
        }

        if (e.getSource() == this.btnApenasPilotoAtual) {

            try {
                Corrida corrida = new CorridaBO().getByNome(CorridasjComboBox.getSelectedItem().toString());
                PilotoParticipandoCampeonato Pilotoparticipa = new PilotoParticipandoCampeonatoBO().Listar_o_piloto_de_campeonato(piloto, campeonato);
                configtabela();
                PilotoParticipaCorrida pilotocorrida = new PilotoParticipaCorridaBO().listarPilotoCorrida(corrida, Pilotoparticipa);
                tabelamento.addRow(new Object[]{
                        pilotocorrida.getCorrida().getNomeCorrida(),
                        pilotocorrida.getPilotoParticipaCampeonato().getPiloto().getApelido(),
                        Tempo.lapTimeToString(pilotocorrida.getTempoAoTerminar()),
                        pilotocorrida.getPosicao(),
                        pilotocorrida.getPontuacao()
                });
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Não foi possível Criar o resultado");
            }
        }
        if (e.getSource() == this.btnOrdenarPorApelido) {
            try {
                Corrida corrida = new CorridaBO().getByNome(CorridasjComboBox.getSelectedItem().toString());
                configtabela();
                for (PilotoParticipaCorrida pilotocorrida : new PilotoParticipaCorridaBO().listarPilotoCorridaOrderApelido(corrida)) {
                    tabelamento.addRow(new Object[]{
                            pilotocorrida.getCorrida().getNomeCorrida(),
                            pilotocorrida.getPilotoParticipaCampeonato().getPiloto().getApelido(),
                            Tempo.lapTimeToString(pilotocorrida.getTempoAoTerminar()),
                            pilotocorrida.getPosicao(),
                            pilotocorrida.getPontuacao()
                    });
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Não foi possível Criar o resultado");
            }
        }
    }

    public void mudarTabelaCorrida() {
        try {
            Corrida corrida = new CorridaBO().getByNome(CorridasjComboBox.getSelectedItem().toString());
            configtabela();
            for (PilotoParticipaCorrida pilotoscorrida : new PilotoParticipaCorridaBO().listarPilotoCorridaOrderPontuacao(corrida)) {
                if (pilotoscorrida.getPosicao() == 1) {
                    GanhadorLabel.setText("Grande vencedor da Corrida: " + pilotoscorrida.getPilotoParticipaCampeonato().getPiloto().getApelido());
                }
                tabelamento.addRow(new Object[]{
                        pilotoscorrida.getCorrida().getNomeCorrida(),
                        pilotoscorrida.getPilotoParticipaCampeonato().getPiloto().getApelido(),
                        Tempo.lapTimeToString(pilotoscorrida.getTempoAoTerminar()),
                        pilotoscorrida.getPosicao(),
                        pilotoscorrida.getPontuacao()
                });
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível Localizar Corridas na Combo");
        }

    }

    public void configtabela() {
        tabelaCorrida.setModel(new DefaultTableModel(
                new Object[][]{

                },
                new String[]{
                        "CORRIDA", "PARTICIPANTE", "TEMPO", "POSIÇÃO", "PONTUAÇÃO"
                }
        ) {
            boolean[] canEdit = new boolean[]{
                    false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }

        });

        tabelamento = (DefaultTableModel) tabelaCorrida.getModel();

    }

} 
