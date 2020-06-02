package View;

import Bo.CampeonatoBO;
import Bo.ConviteCampeonatoBO;
import Bo.PilotoBO;
import Bo.PilotoParticipandoCampeonatoBO;
import Model.Campeonato;
import Model.ConviteCampeonato;
import Model.Piloto;
import Model.PilotoParticipandoCampeonato;
import Utilities.Colors;
import Utilities.Fonts;
import Utilities.Info;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class VerificarCampeonatos extends JFrame implements ActionListener {

    private JPanel fundo;
    private JPanel drawer;
    private JButton btnDesinscrever;
    private JButton btnVoltar;
    private JButton btnConvidarPiloto;
    private JButton btnEnviarAviso;
    private JButton btnVerHistorico;
    private JButton btnIniciarCorrida;
    private JLabel logo;
    private JLabel corridas_participandoinfoLabel;
    private JLabel corridas_participandoLabel;
    private JLabel se_e_piloto_admLabel;
    private JLabel convidar_pilotoLabel;
    private JComboBox<Object> corridas_participandojComboBox;
    private JComboBox<Object> piloto_convidarjComboBox;
    private JScrollPane jScrollPaneCorridasMarcadas;
    private JTable tableTodasAsCorridasMarcadas;
    private DefaultTableModel tabelamento;
    private JCheckBox tornarAdm;

    private Piloto piloto;

    public VerificarCampeonatos(Piloto piloto) {

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
        btnDesinscrever = new JButton();
        btnVoltar = new JButton();
        btnConvidarPiloto = new JButton();
        btnEnviarAviso = new JButton();
        btnVerHistorico = new JButton();
        btnIniciarCorrida = new JButton();
        logo = new JLabel();
        corridas_participandoinfoLabel = new JLabel();
        corridas_participandoLabel = new JLabel();
        se_e_piloto_admLabel = new JLabel();
        convidar_pilotoLabel = new JLabel();
        corridas_participandojComboBox = new JComboBox();
        piloto_convidarjComboBox = new JComboBox();
        tornarAdm = new JCheckBox();
        jScrollPaneCorridasMarcadas = new JScrollPane();
        tableTodasAsCorridasMarcadas = new JTable();

    }

    private void add() {

        add(tornarAdm);
        add(btnDesinscrever);
        add(btnVoltar);
        add(btnConvidarPiloto);
        add(btnEnviarAviso);
        add(btnVerHistorico);
        add(btnIniciarCorrida);
        add(logo);
        add(corridas_participandoinfoLabel);
        add(corridas_participandoLabel);
        add(se_e_piloto_admLabel);
        add(convidar_pilotoLabel);
        add(corridas_participandojComboBox);
        add(piloto_convidarjComboBox);
        add(jScrollPaneCorridasMarcadas);
        add(drawer);
        add(fundo);

    }

    private void setTheme() {

        if (SplashScreen.getConfiguracao().isTema()) {
            // Se o tema for escuro, os itens ficam assim //
            fundo.setBackground(Colors.CINZAMEDB);
            drawer.setBackground(Colors.VERDEDARK);
            tornarAdm.setBackground(Colors.CINZAMEDB);
            tornarAdm.setForeground(Colors.CINZAMEDA);
            btnDesinscrever.setForeground(Colors.CINZADARKB);
            btnDesinscrever.setBackground(Colors.VERDEDARK);
            btnVoltar.setForeground(Colors.CINZADARKB);
            btnVoltar.setBackground(Colors.VERDEDARK);
            btnConvidarPiloto.setForeground(Colors.CINZADARKB);
            btnConvidarPiloto.setBackground(Colors.VERDEDARK);
            btnEnviarAviso.setForeground(Colors.CINZADARKB);
            btnEnviarAviso.setBackground(Colors.VERDEDARK);
            btnVerHistorico.setForeground(Colors.CINZADARKB);
            btnVerHistorico.setBackground(Colors.VERDEDARK);
            btnIniciarCorrida.setForeground(Colors.CINZADARKB);
            btnIniciarCorrida.setBackground(Colors.VERDEDARK);
            logo.setForeground(Colors.CINZAMEDB);
            corridas_participandoinfoLabel.setForeground(Colors.CINZAMEDA);
            corridas_participandoLabel.setForeground(Colors.CINZAMEDA);
            se_e_piloto_admLabel.setForeground(Colors.CINZAMEDA);
            convidar_pilotoLabel.setForeground(Colors.CINZAMEDA);
            corridas_participandojComboBox.setBackground(Colors.CINZALIGHTB);
            corridas_participandojComboBox.setForeground(Colors.BRANCO);
            piloto_convidarjComboBox.setBackground(Colors.CINZALIGHTB);
            piloto_convidarjComboBox.setForeground(Colors.BRANCO);
            tableTodasAsCorridasMarcadas.setBackground(Colors.VERDELIGHT);
            tableTodasAsCorridasMarcadas.setForeground(Colors.CINZADARKB);

        } else {

            fundo.setBackground(Colors.CINZAMEDA);
            drawer.setBackground(Colors.VERDEDARK);
            btnDesinscrever.setForeground(Colors.CINZADARKB);
            btnDesinscrever.setBackground(Colors.VERDEDARK);
            btnVoltar.setForeground(Colors.CINZADARKB);
            btnVoltar.setBackground(Colors.VERDEDARK);
            btnConvidarPiloto.setForeground(Colors.CINZADARKB);
            btnConvidarPiloto.setBackground(Colors.VERDEDARK);
            btnEnviarAviso.setForeground(Colors.CINZADARKB);
            btnEnviarAviso.setBackground(Colors.VERDEDARK);
            btnVerHistorico.setForeground(Colors.CINZADARKB);
            btnVerHistorico.setBackground(Colors.VERDEDARK);
            btnIniciarCorrida.setForeground(Colors.CINZADARKB);
            btnIniciarCorrida.setBackground(Colors.VERDEDARK);
            logo.setForeground(Colors.CINZAMEDB);
            corridas_participandoinfoLabel.setForeground(Colors.CINZALIGHTB);
            corridas_participandoLabel.setForeground(Colors.CINZALIGHTB);
            se_e_piloto_admLabel.setForeground(Colors.CINZALIGHTB);
            convidar_pilotoLabel.setForeground(Colors.CINZALIGHTB);
            corridas_participandojComboBox.setForeground(Colors.CINZADARKA);
            corridas_participandojComboBox.setBackground(Colors.CINZALIGHTB);
            piloto_convidarjComboBox.setForeground(Colors.CINZADARKA);
            piloto_convidarjComboBox.setBackground(Colors.CINZALIGHTB);
            tornarAdm.setBackground(Colors.CINZALIGHTB);
            tornarAdm.setForeground(Colors.CINZADARKA);
            tableTodasAsCorridasMarcadas.setForeground(Colors.CINZADARKB);
            tableTodasAsCorridasMarcadas.setBackground(Colors.VERDEDARK);
        }
    }

    private void limpaTabela() {
        tabelamento.setRowCount(0);
    }

    private void configs() {

        fundo.setSize(Info.MINSCREENSIZE);
        drawer.setBounds(0, 0, 800, 100);

        try {

            tableTodasAsCorridasMarcadas.setModel(new DefaultTableModel(
                    new Object[][]{

                    },
                    new String[]{
                            "CAMPEONATO", "DATA", "TOTAL DE PARTICIPANTES"
                    }
            ) {
                boolean[] canEdit = new boolean[]{
                        false, false, false
                };

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit[columnIndex];
                }

            });

            tabelamento = (DefaultTableModel) tableTodasAsCorridasMarcadas.getModel();

            PilotoParticipandoCampeonatoBO pilotoParticipandoCampeonatoBO = new PilotoParticipandoCampeonatoBO();

            try {
                List<PilotoParticipandoCampeonato> listaCampeonatoDoPiloto = pilotoParticipandoCampeonatoBO.listarTodosPilotosQuePilotoParticipaNoCampeonato(piloto);
                if (listaCampeonatoDoPiloto.isEmpty()) {
                    tabelamento.addRow(new Object[]{
                            "Nem um campeonato na lista!"
                    });
                } else {
                    for (PilotoParticipandoCampeonato list : listaCampeonatoDoPiloto) {
                        corridas_participandojComboBox.addItem(list.getCampeonato().getNome());
                        List<PilotoParticipandoCampeonato> listaTotalPiloto = pilotoParticipandoCampeonatoBO.listarTodosPilotosQuePilotoParticipaNoCampeonato(list.getCampeonato());
                        tabelamento.addRow(new Object[]{
                                list.getCampeonato().getNome(),
                                list.getCampeonato().getDataFinalizacao(),
                                listaTotalPiloto.size()
                        });
                    }
                    mudarComboConvites();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }


            jScrollPaneCorridasMarcadas.setViewportView(tableTodasAsCorridasMarcadas);
            jScrollPaneCorridasMarcadas.setBounds(60, 150, 680, 200);

            btnDesinscrever.setBorderPainted(false);
            btnDesinscrever.setFocusPainted(false);
            btnDesinscrever.addActionListener(this);
            btnDesinscrever.setBounds(40, 500, 200, 35);
            btnDesinscrever.setText("Desinscrever");

            btnVoltar.setBorderPainted(false);
            btnVoltar.setFocusPainted(false);
            btnVoltar.addActionListener(this);
            btnVoltar.setBounds(40, 550, 200, 35);
            btnVoltar.setText("Voltar");

            btnVerHistorico.setBorderPainted(false);
            btnVerHistorico.setFocusPainted(false);
            btnVerHistorico.addActionListener(this);
            btnVerHistorico.setBounds(550, 550, 200, 35);
            btnVerHistorico.setText("Ver Histórico");

            btnEnviarAviso.setBorderPainted(false);
            btnEnviarAviso.setFocusPainted(false);
            btnEnviarAviso.addActionListener(this);
            btnEnviarAviso.setBounds(550, 500, 200, 35);
            btnEnviarAviso.setText("Enviar Aviso");

            tornarAdm.setBounds(340, 400, 140, 30);
            tornarAdm.setText("Ser Administrador");
            tornarAdm.setFocusPainted(false);
            tornarAdm.addActionListener(this);

            logo.setFont(Fonts.SANSSERIFMIN);
            logo.setBounds(20, 30, 500, 35);
            logo.setText("VERIFICAR CAMPEONATOS");

            corridas_participandoinfoLabel.setBounds(60, 120, 300, 30);
            corridas_participandoinfoLabel.setText("Corridas que você está participando:");

            corridas_participandoLabel.setBounds(60, 370, 300, 30);
            corridas_participandoLabel.setText("Campeonatos:");

            corridas_participandojComboBox.setBorder(BorderFactory.createEmptyBorder());
            corridas_participandojComboBox.setBounds(60, 400, 200, 35);

            piloto_convidarjComboBox.setBorder(BorderFactory.createEmptyBorder());
            piloto_convidarjComboBox.setBounds(540, 400, 200, 35);

            se_e_piloto_admLabel.setBounds(600, 120, 200, 30);
            se_e_piloto_admLabel.setText("Você é um piloto ADM");

            convidar_pilotoLabel.setBounds(540, 370, 200, 30);
            convidar_pilotoLabel.setText("Convidar Piloto:");

            btnConvidarPiloto.setBorderPainted(false);
            btnConvidarPiloto.setFocusPainted(false);
            btnConvidarPiloto.addActionListener(this);
            btnConvidarPiloto.setBounds(300, 550, 200, 35);
            btnConvidarPiloto.setText("Convidar Piloto");

            btnIniciarCorrida.setBorderPainted(false);
            btnIniciarCorrida.setFocusPainted(false);
            btnIniciarCorrida.addActionListener(this);
            btnIniciarCorrida.setBounds(300, 500, 200, 35);
            btnIniciarCorrida.setText("Iniciar Corrida");

            corridas_participandojComboBox.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        mudarComboConvites();
                    }
                }
            });

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnDesinscrever) {
            try {
                if (JOptionPane.showConfirmDialog(null,
                        "você tem certeza que deseja se desincrever?",
                        "Desincrever de Campeonato",
                        JOptionPane.YES_NO_OPTION) == 0) {

                    Campeonato campeonato = new CampeonatoBO().getByNome(corridas_participandojComboBox.getSelectedItem().toString());

                    for (PilotoParticipandoCampeonato pilotoqueparticipamcampeonatodesincrever : new PilotoParticipandoCampeonatoBO().Listar_o_piloto_do_campeonato(piloto, campeonato)) {
                        new PilotoParticipandoCampeonatoBO().deletar(pilotoqueparticipamcampeonatodesincrever);
                    }
                    corridas_participandojComboBox.removeItemAt(corridas_participandojComboBox.getSelectedIndex());
                }

                JOptionPane.showMessageDialog(null, "Desinscrição Realizada! você não participa mais dessa corrida!");

                dispose();
                new VerificarCampeonatos(piloto);

                //funciona kappa XD minha missão é deixar funcional

            } catch (Exception error) {
                JOptionPane.showMessageDialog(null, "Eita, não foi possível fazer a desinscrição!");
            }
        }
        if (e.getSource() == btnVoltar) {
            dispose();
            new PerfilPiloto(piloto);
        }
        if (e.getSource() == btnConvidarPiloto) {
            try {

                Campeonato campeonato = new CampeonatoBO().getByNome(corridas_participandojComboBox.getSelectedItem().toString());

                Piloto piloto_convidado = new PilotoBO().listarPorApelido(piloto_convidarjComboBox.getSelectedItem().toString());

                ConviteCampeonato conviteCampeonato = new ConviteCampeonato();
                conviteCampeonato.setCampeonato(campeonato);
                conviteCampeonato.setPilotoQueConvidou(piloto);
                conviteCampeonato.setPilotoConvidado(piloto_convidado);
                conviteCampeonato.setStatusConvite("Não respondido");
                if (new ConviteCampeonatoBO().verificarConviteExistente(conviteCampeonato) == false) {
                    new ConviteCampeonatoBO().criar(conviteCampeonato);
                    piloto_convidarjComboBox.removeItemAt(piloto_convidarjComboBox.getSelectedIndex());
                }
                JOptionPane.showMessageDialog(null, "Convite enviado ao piloto: " + piloto_convidado.getApelido());
            } catch (Exception error) {
                JOptionPane.showMessageDialog(null, "Não foi possível enviar o convite");
            }
        }
        if (e.getSource() == btnEnviarAviso) {
            try {
                Campeonato campeonato = new CampeonatoBO().getByNome(corridas_participandojComboBox.getSelectedItem().toString());
                dispose();
                new EnviarAviso(piloto, campeonato);

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Não foi possível entrar em enviar aviso");
            }

        }
        if (e.getSource() == btnVerHistorico) {
            dispose();
            new Historico(piloto);
        }
        if (e.getSource() == btnIniciarCorrida) {
            try {
                dispose();
                new IniciarCorridaPt1(piloto);
            } catch (Exception error) {
                JOptionPane.showMessageDialog(null, "Você não selecionou nenhuma corrida!");
            }
        }
        if (e.getSource() == tornarAdm) {
            try {
                if (tornarAdm.isSelected()) {
                    if (JOptionPane.showConfirmDialog(null,
                            "você tem certeza que deseja assumir a responsabilidade de ADM?",
                            "Termo de responsabilidade",
                            JOptionPane.YES_NO_OPTION) == 0) {
                        mudarstatusadm();
                    }
                } else {
                    if (JOptionPane.showConfirmDialog(null,

                            "você tem certeza que deseja remover seu ADM desse campeonato?",
                            "Remover status de ADM",
                            JOptionPane.YES_NO_OPTION) == 0) {
                        mudarstatusadm();
                    }
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Não foi possível alterar status de ADM!");
            }

        }
    }

    private void mudarstatusadm() throws Exception {
        Campeonato campeonato = new CampeonatoBO().getByNome(corridas_participandojComboBox.getSelectedItem().toString());

        List<PilotoParticipandoCampeonato> pilotoqueparticipamcampeonato = new PilotoParticipandoCampeonatoBO().Listar_o_piloto_do_campeonato(piloto, campeonato);

        PilotoParticipandoCampeonato pilotoatual = pilotoqueparticipamcampeonato.get(0);
        if (pilotoatual.isStatusAdm()) {
            pilotoatual.setStatusAdm(false);
        } else {
            pilotoatual.setStatusAdm(true);
        }
        PilotoParticipandoCampeonatoBO pilotoparticipandobo = new PilotoParticipandoCampeonatoBO();

        pilotoparticipandobo.alterar(pilotoatual);

        verificarADM(campeonato);
        JOptionPane.showMessageDialog(null, "Status de ADM alterado!");
    }

    private void mudarComboConvites() {

        try {
            piloto_convidarjComboBox.removeAllItems();
            Campeonato campeonato = new CampeonatoBO().getByNome(corridas_participandojComboBox.getSelectedItem().toString());
            for (Piloto pilotos : new PilotoBO().listarTodos()) {
                if (pilotos.getIdPiloto() != piloto.getIdPiloto()) {
                    //remove o proprio piloto
                    boolean pilotoparticipadocampeonato = false;
                    for (PilotoParticipandoCampeonato pilotoqueparticipamcampeonato : new PilotoParticipandoCampeonatoBO().listarTodosPilotosQuePilotoParticipaNoCampeonato(campeonato)) {

                        if (pilotoqueparticipamcampeonato.getPiloto().getIdPiloto() == pilotos.getIdPiloto()) {
                            pilotoparticipadocampeonato = true;
                        }
                    }
                    ConviteCampeonato verificarsejafoiconvidado = new ConviteCampeonato();
                    verificarsejafoiconvidado.setCampeonato(campeonato);
                    verificarsejafoiconvidado.setPilotoConvidado(pilotos);
                    if (pilotoparticipadocampeonato == false && new ConviteCampeonatoBO().verificarConviteExistente(verificarsejafoiconvidado) == false) {
                        piloto_convidarjComboBox.addItem(pilotos.getApelido());
                    }
                }
            }
            verificarADM(campeonato);

        } catch (Exception error) {
            JOptionPane.showMessageDialog(null, "Não foi possível encontrar os piloto para convidar");
        }

    }

    private void verificarADM(Campeonato campeonato) throws Exception {
        List<PilotoParticipandoCampeonato> lista = new PilotoParticipandoCampeonatoBO().Listar_o_piloto_do_campeonato(piloto, campeonato);
        PilotoParticipandoCampeonato pilotoparticipando = lista.get(0);
        if (pilotoparticipando.isStatusAdm()) {
            se_e_piloto_admLabel.setText("Você é um piloto ADM");

            convidar_pilotoLabel.setVisible(true);

            btnConvidarPiloto.setVisible(true);

            btnEnviarAviso.setVisible(true);

            btnIniciarCorrida.setVisible(true);

            piloto_convidarjComboBox.setVisible(true);

            tornarAdm.setSelected(true);

        } else {
            se_e_piloto_admLabel.setText("Você é não um piloto ADM");

            convidar_pilotoLabel.setVisible(false);

            btnConvidarPiloto.setVisible(false);

            btnEnviarAviso.setVisible(false);

            btnIniciarCorrida.setVisible(false);

            piloto_convidarjComboBox.setVisible(false);

            tornarAdm.setSelected(false);

        }
    }

}
