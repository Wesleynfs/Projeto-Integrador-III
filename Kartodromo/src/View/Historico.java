package View;

import Bo.PilotoParticipandoCampeonatoBO;
import Model.Piloto;
import Model.PilotoParticipandoCampeonato;
import Utilities.Colors;
import Utilities.Fonts;
import Utilities.Info;
import Utilities.InformacoesPiloto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class Historico extends JFrame implements ActionListener {

    private JPanel fundo;
    private JPanel drawer;
    private JButton btnVoltar;
    private JButton btnListar;
    private InformacoesPiloto informacoesPiloto;
    private JLabel logo;
    private JLabel logoLabelCampeonato;
    private JLabel campeonatosParticipandoInfoLabel;
    private JScrollPane jScrollPaneCorridasRealizadas;
    private JTable tableTodasAsCorridasRealizadas;
    private JComboBox<String> comboCampeonato;
    private DefaultTableModel tabelamento;
    private List<PilotoParticipandoCampeonato> pilotoparticipando;

    private Piloto piloto;

    public Historico(Piloto piloto) {
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
        btnListar = new JButton();
        btnVoltar = new JButton();
        logo = new JLabel();
        logoLabelCampeonato = new JLabel();
        campeonatosParticipandoInfoLabel = new JLabel();
        informacoesPiloto = new InformacoesPiloto();
        comboCampeonato = new JComboBox<>();
        jScrollPaneCorridasRealizadas = new JScrollPane();
        tableTodasAsCorridasRealizadas = new JTable();
    }

    private void add() {
        add(btnVoltar);
        add(btnListar);
        add(logo);
        add(logoLabelCampeonato);
        add(comboCampeonato);
        add(campeonatosParticipandoInfoLabel);
        add(jScrollPaneCorridasRealizadas);
        add(informacoesPiloto);
        add(drawer);
        add(fundo);
    }

    private void setTheme() {

        if (SplashScreen.getConfiguracao().isTema()) {
            // Se o tema for escuro, os itens ficam assim //
            fundo.setBackground(Colors.CINZAMEDB);
            drawer.setBackground(Colors.VERDEDARK);
            logoLabelCampeonato.setForeground(Colors.BRANCO);
            btnVoltar.setForeground(Colors.CINZADARKB);
            btnVoltar.setBackground(Colors.VERDEDARK);
            btnListar.setForeground(Colors.CINZADARKB);
            btnListar.setBackground(Colors.VERDEDARK);
            logo.setForeground(Colors.CINZAMEDB);
            informacoesPiloto.setForeground(Colors.CINZALIGHTB);
            campeonatosParticipandoInfoLabel.setForeground(Colors.CINZAMEDA);
            tableTodasAsCorridasRealizadas.setBackground(Colors.VERDELIGHT);
            tableTodasAsCorridasRealizadas.setForeground(Colors.CINZADARKB);

        } else {

            fundo.setBackground(Colors.CINZAMEDA);
            drawer.setBackground(Colors.VERDEDARK);
            logoLabelCampeonato.setForeground(Colors.CINZAMEDB);
            informacoesPiloto.setForeground(Colors.CINZALIGHTB);
            btnVoltar.setForeground(Colors.CINZADARKB);
            btnVoltar.setBackground(Colors.VERDEDARK);
            btnListar.setForeground(Colors.CINZADARKB);
            btnListar.setBackground(Colors.VERDEDARK);
            logo.setForeground(Colors.CINZAMEDB);
            campeonatosParticipandoInfoLabel.setForeground(Colors.CINZALIGHTB);
            tableTodasAsCorridasRealizadas.setForeground(Colors.CINZADARKB);
            tableTodasAsCorridasRealizadas.setBackground(Colors.VERDEDARK);

        }
    }

    private void limparTabela() {
        for (int x = 0; x < tabelamento.getRowCount(); x++) {
            tabelamento.removeRow(x);
        }
    }

    private void configs() {

        try {

            tableTodasAsCorridasRealizadas.setModel(new DefaultTableModel(
                    new Object[][]{

                    },
                    new String[]{
                            "Nome", "Data", "Posição", "Pontuação"
                    }
            ) {
                boolean[] canEdit = new boolean[]{
                        false, false, false, false
                };

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit[columnIndex];
                }

            });

            tabelamento = (DefaultTableModel) tableTodasAsCorridasRealizadas.getModel();

            fundo.setSize(Info.MINSCREENSIZE);
            drawer.setBounds(0, 0, 800, 100);

            logoLabelCampeonato.setBounds(540, 120, 200, 35);
            logoLabelCampeonato.setText("Selecione o Campeonato");

            comboCampeonato.setBounds(540, 150, 200, 35);

            pilotoparticipando = new PilotoParticipandoCampeonatoBO().listarPilotoCampeonatosFinalizados(piloto);

            comboCampeonato.addItem("TODOS OS CAMPEONATOS");

            for (PilotoParticipandoCampeonato pilotoParticipandoCampeonato : pilotoparticipando) {
                comboCampeonato.addItem(pilotoParticipandoCampeonato.getCampeonato().getNome());
            }

            jScrollPaneCorridasRealizadas.setViewportView(tableTodasAsCorridasRealizadas);
            jScrollPaneCorridasRealizadas.setBounds(60, 230, 680, 300);

            informacoesPiloto.setBounds(10, 110, 200, 90);
            informacoesPiloto.setPiloto(piloto);

            btnVoltar.setBorderPainted(false);
            btnVoltar.setFocusPainted(false);
            btnVoltar.addActionListener(this);
            btnVoltar.setBounds(60, 550, 200, 35);
            btnVoltar.setText("Voltar");

            btnListar.setBorderPainted(false);
            btnListar.setFocusPainted(false);
            btnListar.addActionListener(this);
            btnListar.setBounds(540, 550, 200, 35);
            btnListar.setText("Listar");

            logo.setFont(Fonts.SANSSERIFMIN);
            logo.setBounds(20, 30, 500, 35);
            logo.setText("HISTÓRICO DE PARTIDAS");

            campeonatosParticipandoInfoLabel.setBounds(60, 200, 300, 30);
            campeonatosParticipandoInfoLabel.setText("Campeonato que você participou:");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnVoltar) {
            dispose();
            new VerificarCampeonatos(piloto);
        }

        if (e.getSource() == btnListar) {
            listarCampeonatos();
        }

    }

    private void listarCampeonatos() {

        limparTabela();

        if (comboCampeonato.getSelectedIndex() == 0) {
            try {
                for (PilotoParticipandoCampeonato pilotoparticipando : pilotoparticipando) {
                    tabelamento.addRow(new Object[]{
                            pilotoparticipando.getCampeonato().getNome(),
                            pilotoparticipando.getCampeonato().getDataFinalizacao(),
                            pilotoparticipando.getPosicao(),
                            pilotoparticipando.getPontuacao(),
                    });

                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        } else {
            try {
                for (PilotoParticipandoCampeonato pilotoparticipando : pilotoparticipando) {
                    if (comboCampeonato.getModel().getSelectedItem().toString().equalsIgnoreCase(pilotoparticipando.getCampeonato().getNome())) {
                        tabelamento.addRow(new Object[]{
                                pilotoparticipando.getCampeonato().getNome(),
                                pilotoparticipando.getCampeonato().getDataFinalizacao(),
                                pilotoparticipando.getPosicao(),
                                pilotoparticipando.getPontuacao(),
                        });
                    }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }

} 
