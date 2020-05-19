package View;

import Model.Piloto;
import Utilities.Colors;
import Utilities.Fonts;
import Utilities.Info;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

public class IniciarCorridaPt2 extends JFrame implements ActionListener {

    private JPanel fundo;
    private JPanel drawer;
    private JButton btnVoltar;
    private JButton btndarfalta;
    private JButton btndarpresenca;
    private JButton btnIniciarCorrida;
    private JLabel logo;
    private JLabel SelecioneLabel;
    private JScrollPane jScrollPaneParticipantes;
    private JTable tableParticipantes_status;
    private DefaultTableModel tabelamento;

    private Piloto piloto;

    public IniciarCorridaPt2() {

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

        btnVoltar = new JButton();
        btnIniciarCorrida = new JButton();

        logo = new JLabel();

        jScrollPaneParticipantes = new JScrollPane();
        tableParticipantes_status = new JTable();
        SelecioneLabel = new JLabel();
        btndarfalta = new JButton();
        btndarpresenca = new JButton();

    }

    private void add() {
        add(btnVoltar);
        add(btnIniciarCorrida);
        add(logo);
        add(SelecioneLabel);
        add(btndarfalta);
        add(btndarpresenca);
        add(jScrollPaneParticipantes);
        add(drawer);
        add(fundo);
    }

    private void setTheme() {
        if (LoginFrame.getConfiguracao().isTema()) {
            // Se o tema for escuro, os itens ficam assim //
            fundo.setBackground(Colors.CINZAMEDB);
            drawer.setBackground(Colors.VERDEDARK);
            btnVoltar.setForeground(Colors.CINZADARKB);
            btnVoltar.setBackground(Colors.VERDEDARK);
            btnIniciarCorrida.setForeground(Colors.CINZADARKB);
            btnIniciarCorrida.setBackground(Colors.VERDEDARK);
            logo.setForeground(Colors.CINZAMEDB);
            tableParticipantes_status.setBackground(Colors.VERDELIGHT);
            tableParticipantes_status.setForeground(Colors.CINZADARKB);
            SelecioneLabel.setForeground(Colors.CINZAMEDA);
            btndarfalta.setForeground(Colors.CINZADARKB);
            btndarfalta.setBackground(Colors.VERDEDARK);
            btndarpresenca.setForeground(Colors.CINZADARKB);
            btndarpresenca.setBackground(Colors.VERDEDARK);

        } else {

            fundo.setBackground(Colors.CINZAMEDA);
            drawer.setBackground(Colors.VERDEDARK);            
            btnVoltar.setForeground(Colors.CINZADARKB);
            btnVoltar.setBackground(Colors.VERDEDARK);
            btnIniciarCorrida.setForeground(Colors.CINZADARKB);
            btnIniciarCorrida.setBackground(Colors.VERDEDARK);
            logo.setForeground(Colors.CINZAMEDB);
            tableParticipantes_status.setForeground(Colors.CINZADARKB);
            tableParticipantes_status.setBackground(Colors.VERDEDARK);
            SelecioneLabel.setForeground(Colors.CINZALIGHTB);
            btndarfalta.setForeground(Colors.CINZADARKB);
            btndarfalta.setBackground(Colors.VERDEDARK);
            btndarpresenca.setForeground(Colors.CINZADARKB);
            btndarpresenca.setBackground(Colors.VERDEDARK);

        }
    }

    private void configs() {

        fundo.setSize(Info.MINSCREENSIZE);

        drawer.setBounds(0, 0, 800, 100);

        try {

            tableParticipantes_status.setModel(new DefaultTableModel(
                    new Object[][]{

                    },
                    new String[]{
                            "NOME DO PARTICIPANTE","STATUS"
                    }
            ) {
                boolean[] canEdit = new boolean[]{
                        false, false
                };

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit[columnIndex];
                }

            });

            tabelamento = (DefaultTableModel) tableParticipantes_status.getModel();

            tabelamento.addRow(new Object[]{
                    "FILLUS",
                    "PRESENTE"
            });
            //Subistituir as linhas anteriores
            //          for (classe : classeDao.findALL()){
            //            tabelamento.addRow(new Object[]{
            //                class.nome,
            //            });
            //
            //          }
            jScrollPaneParticipantes.setViewportView(tableParticipantes_status);
            jScrollPaneParticipantes.setBounds(60, 150, 680, 250);

            logo.setFont(Fonts.SANSSERIFMIN);
            logo.setBounds(20 , 30,500,35);
            logo.setText("INICIAR CORRIDA");

            SelecioneLabel.setBounds(60, 120, 680, 35);
            SelecioneLabel.setText("Selecionar Corrida:");

            btndarfalta.setBorderPainted(false);
            btndarfalta.setFocusPainted(false);
            btndarfalta.addActionListener(this);
            btndarfalta.setBounds(570, 500, 200, 35);
            btndarfalta.setText("Atribuir Falta"); 
            
            btndarpresenca.setBorderPainted(false);
            btndarpresenca.setFocusPainted(false);
            btndarpresenca.addActionListener(this);
            btndarpresenca.setBounds(570, 450, 200, 35);
            btndarpresenca.setText("Atribuir Presenca");   

            btnIniciarCorrida.setBorderPainted(false);
            btnIniciarCorrida.setFocusPainted(false);
            btnIniciarCorrida.addActionListener(this);
            btnIniciarCorrida.setBounds(570, 550, 200, 35);
            btnIniciarCorrida.setText("Iniciar Corrida");
            
            btnVoltar.setBorderPainted(false);
            btnVoltar.setFocusPainted(false);
            btnVoltar.addActionListener(this);
            btnVoltar.setBounds(60 , 550,200,35);
            btnVoltar.setText("Voltar");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
      
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnVoltar) {
            dispose();
            new IniciarCorridaPt1();
        }
        if (e.getSource() == btndarfalta) {
            
        }
        if (e.getSource() == btndarpresenca) {
            
        }
        if (e.getSource() == btnIniciarCorrida) {
            dispose();
            new ResultadoCorrida(piloto);
        }

    }


} 
//Nessa tabela a ideia é o usuario selecionar na JTABLE o participante que 
//ele deseja colocar o status de falta ou presença
//quando ele colocar o status de falta e confimar a corrida
//os pilotos com a falta devem ter o numero de strikers aumentado em 1
