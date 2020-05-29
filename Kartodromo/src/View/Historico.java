package View;

import Model.Piloto;
import Utilities.Colors;
import Utilities.Fonts;
import Utilities.Info;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

public class Historico extends JFrame implements ActionListener {

    private JPanel fundo;
    private JPanel drawer;
    private JButton btnVoltar;
    private JLabel lblinfoPiloto;
    private JLabel logo;
    private JLabel corridas_participandoinfoLabel;
    private JScrollPane jScrollPaneCorridasRealizadas;
    private JTable tableTodasAsCorridasRealizadas;
    private DefaultTableModel tabelamento;
    
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
        
        btnVoltar = new JButton();

        logo = new JLabel();
        corridas_participandoinfoLabel = new JLabel();
        lblinfoPiloto = new JLabel();

        jScrollPaneCorridasRealizadas = new JScrollPane();
        tableTodasAsCorridasRealizadas = new JTable();
    }

    private void add() {
        add(btnVoltar);
        add(logo);
        add(corridas_participandoinfoLabel);
        add(jScrollPaneCorridasRealizadas);
        add(lblinfoPiloto);
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
            logo.setForeground(Colors.CINZAMEDA);
            lblinfoPiloto.setForeground(Colors.CINZALIGHTB);
            corridas_participandoinfoLabel.setForeground(Colors.CINZAMEDA);
            tableTodasAsCorridasRealizadas.setBackground(Colors.VERDELIGHT);
            tableTodasAsCorridasRealizadas.setForeground(Colors.CINZADARKB);

        } else {

            fundo.setBackground(Colors.CINZAMEDA);
            drawer.setBackground(Colors.VERDEDARK);            
            lblinfoPiloto.setForeground(Colors.CINZALIGHTB);
            btnVoltar.setForeground(Colors.CINZADARKB);
            btnVoltar.setBackground(Colors.VERDEDARK);
            logo.setForeground(Colors.CINZALIGHTB);
            corridas_participandoinfoLabel.setForeground(Colors.CINZALIGHTB);

            tableTodasAsCorridasRealizadas.setForeground(Colors.CINZADARKB);
            tableTodasAsCorridasRealizadas.setBackground(Colors.VERDEDARK);
        }
    }
    private void configs() {

        fundo.setSize(Info.MINSCREENSIZE);

        drawer.setBounds(0, 0, 800, 100);

        try {

            tableTodasAsCorridasRealizadas.setModel(new DefaultTableModel(
                    new Object[][]{

                    },
                    new String[]{
                            "Nome","Data","Posição","Pontuação"
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

            tabelamento.addRow(new Object[]{
                    "Test",
                    "test1",
                    "test2",
                    "test3"
            });

            jScrollPaneCorridasRealizadas.setViewportView(tableTodasAsCorridasRealizadas);
            jScrollPaneCorridasRealizadas.setBounds(60, 200, 680, 350);

            lblinfoPiloto.setText("<html>NOME: "+piloto.getNomePiloto()+ "<br/>"
            + "APELIDO: "+piloto.getApelido()+ "<br/>"
            + "NÍVEL: "+piloto.getNivel() + "<br/>"
            +"</html>");
            lblinfoPiloto.setBounds(10,110,200,90);
            
            btnVoltar.setBorderPainted(false);
            btnVoltar.setFocusPainted(false);
            btnVoltar.addActionListener(this);
            btnVoltar.setBounds(60 , 550,200,35);
            btnVoltar.setText("Voltar");
            
            logo.setFont(Fonts.SANSSERIFMIN);
            logo.setBounds(20 , 30,500,35);
            logo.setText("HISTÓRICO DE PARTIDAS");

            corridas_participandoinfoLabel.setBounds(60 , 170,300,30);
            corridas_participandoinfoLabel.setText("Corridas que você participou:");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
      
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
       
        if (e.getSource() == btnVoltar) {
            dispose();
            new VerificarCorrida(piloto);
        }

    }


} 
