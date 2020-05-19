
package View;

import Model.Piloto;
import Utilities.Colors;
import Utilities.Fonts;
import Utilities.Info;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

public class ResultadoCorrida extends JFrame implements ActionListener {

    private JPanel fundo;
    private JPanel drawer;
    private JButton btnFinalizarCorrida;
    private JLabel logo;
    private JLabel ReultadodacorridaLabel;
    private JLabel GanhadorLabel;
    private JScrollPane jScrollPaneParticipantes;
    private JTable tableParticipantes_status;
    private DefaultTableModel tabelamento;

    private Piloto piloto;

    public ResultadoCorrida(Piloto piloto) {

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

        this.piloto = piloto;

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

        btnFinalizarCorrida = new JButton();

        logo = new JLabel();
        ReultadodacorridaLabel = new JLabel();
        GanhadorLabel = new JLabel();
                
        jScrollPaneParticipantes = new JScrollPane();
        tableParticipantes_status = new JTable();

    }

    private void add() {
        add(btnFinalizarCorrida);
        add(ReultadodacorridaLabel);
        add(GanhadorLabel);
        add(logo);
        add(jScrollPaneParticipantes);
        add(drawer);
        add(fundo);
    }

    private void setTheme() {
        if (LoginFrame.getConfiguracao().isTema()) {
            // Se o tema for escuro, os itens ficam assim //
            fundo.setBackground(Colors.CINZAMEDB);
            drawer.setBackground(Colors.VERDEDARK);
   
            logo.setForeground(Colors.CINZAMEDB);
            tableParticipantes_status.setBackground(Colors.VERDELIGHT);
            tableParticipantes_status.setForeground(Colors.CINZADARKB);
            GanhadorLabel.setForeground(Colors.CINZAMEDA);
            ReultadodacorridaLabel.setForeground(Colors.CINZAMEDA);
            btnFinalizarCorrida.setForeground(Colors.CINZADARKB);
            btnFinalizarCorrida.setBackground(Colors.VERDEDARK);

        } else {

            fundo.setBackground(Colors.CINZAMEDA);
            drawer.setBackground(Colors.VERDEDARK);          
            logo.setForeground(Colors.CINZAMEDB);
            tableParticipantes_status.setForeground(Colors.CINZADARKB);
            tableParticipantes_status.setBackground(Colors.VERDEDARK);
            GanhadorLabel.setForeground(Colors.CINZALIGHTB);
            ReultadodacorridaLabel.setForeground(Colors.CINZALIGHTB);
            btnFinalizarCorrida.setForeground(Colors.CINZADARKB);
            btnFinalizarCorrida.setBackground(Colors.VERDEDARK);
         
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
                            "NOME DO PARTICIPANTE","STATUS","T1","T2","T3","TF","Pontuação"
                    }
            ) {
                boolean[] canEdit = new boolean[]{
                        false,false ,false, false, false, false, false
                };

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit[columnIndex];
                }

            });

            tabelamento = (DefaultTableModel) tableParticipantes_status.getModel();

            tabelamento.addRow(new Object[]{
                    "FILLUS",
                    "PRESENTE",
                    "1.22",
                    "1.34",
                    "1.12",
                    "1.26",
                    "60"
            });
            //Subistituir as linhas anteriores
            //          for (classe : classeDao.findALL()){
            //            tabelamento.addRow(new Object[]{
            //                class.nome,
            //            });
            //
            //          }
            jScrollPaneParticipantes.setViewportView(tableParticipantes_status);
            jScrollPaneParticipantes.setBounds(60, 150, 680, 300);

            logo.setFont(Fonts.SANSSERIFMIN);
            logo.setBounds(20 , 30,500,35);
            logo.setText("RESULTADO DA CORRIDA");

            ReultadodacorridaLabel.setBounds(300, 120, 300, 35);
            ReultadodacorridaLabel.setText("REULTADO: NOME DA CORRIDA");
            // AQUI COLOCA O NOME DA CORRIDA
            //
            GanhadorLabel.setBounds(280, 480, 300, 35);
            GanhadorLabel.setText("GRANDE GANHADOR: NOME PILOTO VENCEDOR");
            //AQUI COLOCA O NOME DO PRIMEIRO COLOCADO DA CORRIDA      
            //        
                    
                    
            btnFinalizarCorrida.setBorderPainted(false);
            btnFinalizarCorrida.setFocusPainted(false);
            btnFinalizarCorrida.addActionListener(this);
            btnFinalizarCorrida.setBounds(320 , 540,200,35);
            btnFinalizarCorrida.setText("FINALIZAR CORRIDA"); 
            

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

    }


} 
