package View;

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
import javax.swing.table.DefaultTableModel;

public class VerificarCorrida extends JFrame implements ActionListener, ItemListener {

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

    public VerificarCorrida(Piloto piloto) {

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
                            "NOME DA CORRIDA", "KARTODROMO", "TIPO DE KART", "DATA", "ENDEREÇO"
                    }
            ) {
                boolean[] canEdit = new boolean[]{
                        false, false, false, false, false
                };

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit[columnIndex];
                }

            });

            tabelamento = (DefaultTableModel) tableTodasAsCorridasMarcadas.getModel();

            tabelamento.addRow(new Object[]{
                    "Test",
                    "test1",
                    "test2",
                    "test3",
                    "test4"
            });

            //Subistituir as linhas anteriores
            //          for (classe : classeDao.findALL()){
            //            tabelamento.addRow(new Object[]{
            //                class.nome,
            //                class.tipo,
            //                class.data
            //            });
            //
            //          }

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
            btnVerHistorico.setBounds(550, 500, 200, 35);
            btnVerHistorico.setText("Ver Histórico");

            tornarAdm.setBounds(340, 400, 140, 30);
            tornarAdm.setText("Ser Administrador");
            tornarAdm.setFocusPainted(false);
            tornarAdm.addItemListener(this);

            logo.setFont(Fonts.SANSSERIFMIN);
            logo.setBounds(20, 30, 500, 35);
            logo.setText("VERIFICAR CORRIDAS");

            corridas_participandoinfoLabel.setBounds(60, 120, 300, 30);
            corridas_participandoinfoLabel.setText("Corridas que você está participando:");

            corridas_participandoLabel.setBounds(60, 370, 300, 30);
            corridas_participandoLabel.setText("Campeonatos:");

            corridas_participandojComboBox.setBorder(BorderFactory.createEmptyBorder());
            corridas_participandojComboBox.setBounds(540, 400, 200, 35);

//        ClasseDao dao = new ClasseDao();
//        for(classe c : dao.FindALL()){
//            NomeKartodromojComboBox.addItem(c.nome_corrida);
//        }

            piloto_convidarjComboBox.setBorder(BorderFactory.createEmptyBorder());
            piloto_convidarjComboBox.setBounds(60, 400, 200, 35);

//        ClasseDao dao = new ClasseDao();
//        for(classe c:dao.FindALL()){
//            NomeKartodromojComboBox.addItem(c.nome_corrida);
//        }

//          if(piloto for adm então){

            se_e_piloto_admLabel.setBounds(600, 120, 200, 30);
            se_e_piloto_admLabel.setText("Você é um piloto ADM");

            convidar_pilotoLabel.setBounds(540, 370, 200, 30);
            convidar_pilotoLabel.setText("Convidar Piloto:");

            btnConvidarPiloto.setBorderPainted(false);
            btnConvidarPiloto.setFocusPainted(false);
            btnConvidarPiloto.addActionListener(this);
            btnConvidarPiloto.setBounds(300, 550, 200, 35);
            btnConvidarPiloto.setText("Convidar Piloto");

            btnEnviarAviso.setBorderPainted(false);
            btnEnviarAviso.setFocusPainted(false);
            btnEnviarAviso.addActionListener(this);
            btnEnviarAviso.setBounds(550, 550, 200, 35);
            btnEnviarAviso.setText("Enviar Aviso");

            btnIniciarCorrida.setBorderPainted(false);
            btnIniciarCorrida.setFocusPainted(false);
            btnIniciarCorrida.addActionListener(this);
            btnIniciarCorrida.setBounds(300, 500, 200, 35);
            btnIniciarCorrida.setText("Iniciar Corrida");

//          }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnDesinscrever) {
            try {
                //Desinscrever o piloto 


                //
                JOptionPane.showMessageDialog(null, "Desinscrição Realizada! você não participa mais dessa corrida!");
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
                //enviar convite


                //
                JOptionPane.showMessageDialog(null, "Convite enviado ao piloto: NOME DO PILOTO");
            } catch (Exception error) {
                JOptionPane.showMessageDialog(null, "Não foi possível enviar o convite");
            }
        }
        if (e.getSource() == btnEnviarAviso) {
            dispose();
            new EnviarAviso(piloto);
        }
        if (e.getSource() == btnVerHistorico) {
            dispose();
            new Historico(piloto);
        }
        if (e.getSource() == btnIniciarCorrida) {
            try {
                dispose();
                new IniciarCorridaPt1();
            } catch (Exception error) {
                JOptionPane.showMessageDialog(null, "Você não selecionou nenhuma corrida!");
            }
        }
    }

    @Override
    public void itemStateChanged(ItemEvent itemEvent) {
        if (itemEvent.getSource() == tornarAdm && tornarAdm.isSelected()) {

        }
    }
}
