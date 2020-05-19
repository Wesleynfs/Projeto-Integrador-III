package View;

import Utilities.Colors;
import Utilities.Fonts;
import Utilities.Info;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

public class IniciarCorridaPt1 extends JFrame implements ActionListener {

    private JPanel fundo;
    private JPanel drawer;

    private JButton btnVoltar;
    private JButton btnIniciarCorrida;

    private JLabel logo;
    private JLabel corrida_escolhidaLabel;
    private JLabel corridas_participandoLabel;

    private JComboBox<Object> corridasjComboBox;

    private JScrollPane jScrollPaneCorridasMarcadas;
    private JTable tableTodasAsCorridasMarcadas;
    
    private JScrollPane jScrollPanePilotosCorrida;
    private JTable tablePilotosCorrida;
    
    private DefaultTableModel tabelamento;

    public IniciarCorridaPt1() {

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
        corrida_escolhidaLabel = new JLabel();
        corridas_participandoLabel = new JLabel();;
    
        corridasjComboBox = new JComboBox();

        jScrollPaneCorridasMarcadas = new JScrollPane();
        tableTodasAsCorridasMarcadas = new JTable();
        
        jScrollPanePilotosCorrida = new JScrollPane();
        tablePilotosCorrida = new JTable();
    }

    private void add() {
        add(corrida_escolhidaLabel);
        add(btnVoltar);
        add(corridasjComboBox);
        add(jScrollPanePilotosCorrida);
        add(btnIniciarCorrida);
        add(logo);
        add(corridas_participandoLabel);
        add(jScrollPaneCorridasMarcadas);
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
            corrida_escolhidaLabel.setForeground(Colors.CINZAMEDA);
            corridas_participandoLabel.setForeground(Colors.CINZAMEDA);
            corridasjComboBox.setBackground(Colors.CINZALIGHTB);
            corridasjComboBox.setForeground(Colors.BRANCO);
            tableTodasAsCorridasMarcadas.setBackground(Colors.VERDELIGHT);
            tableTodasAsCorridasMarcadas.setForeground(Colors.CINZADARKB);
            tablePilotosCorrida.setBackground(Colors.VERDELIGHT);
            tablePilotosCorrida.setForeground(Colors.CINZADARKB);

        } else {

            fundo.setBackground(Colors.CINZAMEDA);
            drawer.setBackground(Colors.VERDEDARK);            
            btnVoltar.setForeground(Colors.CINZADARKB);
            btnVoltar.setBackground(Colors.VERDEDARK);
            btnIniciarCorrida.setForeground(Colors.CINZADARKB);
            btnIniciarCorrida.setBackground(Colors.VERDEDARK);
            logo.setForeground(Colors.CINZAMEDB);
            corrida_escolhidaLabel.setForeground(Colors.CINZALIGHTB);
            corridas_participandoLabel.setForeground(Colors.CINZALIGHTB);
            corridasjComboBox.setForeground(Colors.CINZADARKA);
            corridasjComboBox.setBackground(Colors.CINZALIGHTB);
            tableTodasAsCorridasMarcadas.setForeground(Colors.CINZADARKB);
            tableTodasAsCorridasMarcadas.setBackground(Colors.VERDEDARK);
            tablePilotosCorrida.setForeground(Colors.CINZADARKB);
            tablePilotosCorrida.setBackground(Colors.VERDEDARK);
        }
    }
    private void configs() {

        fundo.setSize(Info.MINSCREENSIZE);

        drawer.setBounds(0, 0, 800, 100);

        try {

            tableTodasAsCorridasMarcadas.setModel(new DefaultTableModel(
                    new Object[][]{

                    },
                    new String[]{
                            "TIPO","NOME DA CORRIDA","Data","VAGAS"
                    }
            ) {
                boolean[] canEdit = new boolean[]{
                        false, false, false, false
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
                    "test3"
            });
            //Subistituir as linhas anteriores
            //          for (classe : classeDao.findALL()){
            //            tabelamento.addRow(new Object[]{
            //                class.nome,
            //            });
            //
            //          }
            jScrollPaneCorridasMarcadas.setViewportView(tableTodasAsCorridasMarcadas);
            jScrollPaneCorridasMarcadas.setBounds(60, 150, 680, 200);

            tablePilotosCorrida.setModel(new DefaultTableModel(
                    new Object[][]{

                    },
                    new String[]{
                            "PARTICIPANTES"
                    }
            ) {
                boolean[] canEdit = new boolean[]{
                        false
                };

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit[columnIndex];
                }

            });

            tabelamento = (DefaultTableModel) tablePilotosCorrida.getModel();

            tabelamento.addRow(new Object[]{
                    "Test"
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
            jScrollPanePilotosCorrida.setViewportView(tablePilotosCorrida);
            jScrollPanePilotosCorrida.setBounds(60, 370, 230 , 150);

            logo.setFont(Fonts.SANSSERIFMIN);
            logo.setBounds(20 , 30,500,35);
            logo.setText("INICIAR CORRIDA");

            corrida_escolhidaLabel.setBounds(570 , 355,300,30);
            corrida_escolhidaLabel.setText("Selecionar Corrida:");

            corridas_participandoLabel.setBounds(60 , 120,300,30);
            corridas_participandoLabel.setText("Corridas participando:");
                    
            corridasjComboBox.setBorder(BorderFactory.createEmptyBorder());
            corridasjComboBox.setBounds(570,390,200,35);
//        ClasseDao dao = new ClasseDao();
//        for(classe c:dao.FindALL()){
//            NomeKartodromojComboBox.addItem(c);
//        }

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
            //new VerificarCorrida();
        }

        if (e.getSource() == btnIniciarCorrida) {
            try{
                dispose();
                new IniciarCorridaPt2();
                
            } catch (Exception error) {
                JOptionPane.showMessageDialog(null, "Você não selecionou nenhuma corrida!");
            }
        }

    }


} 
