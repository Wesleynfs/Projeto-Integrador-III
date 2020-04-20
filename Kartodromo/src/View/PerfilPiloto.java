package View;

import Utilities.Colors;
import Utilities.Fonts;
import Utilities.Info;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

public class PerfilPiloto extends JFrame implements ActionListener {

    private JPanel fundo;
    private JPanel drawer;
    
    private JButton btnRelatar;
    private JButton btnSair;
    private JButton btnParticipar_corrida;
    private JButton btnCriar_corrida;
    private JButton btnVerificar_corridas;
    private JButton btnAvaliar_kartdromo;
    
    private JLabel numero_vitoriaLabel;
    private JLabel nome_piloto;
    private JLabel numero_strickers;
    private JLabel corridas_participandoLabel;
    private JLabel corridas_marcadasLabel;
   
    private JScrollPane jScrollPane1_corridas_participando;
    private JTable tabela_corridas_participando;
    private JScrollPane jScrollPane1_allcorridas;
    private JTable tabela_allcorridas;
    private DefaultTableModel tabelamento;
    
            
    public PerfilPiloto() {

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
        btnRelatar = new JButton();
        btnSair = new JButton();
        btnParticipar_corrida = new JButton();
        btnCriar_corrida = new JButton();
        btnVerificar_corridas = new JButton();
        btnAvaliar_kartdromo = new JButton();
    
        numero_vitoriaLabel = new JLabel();
        nome_piloto = new JLabel();
        numero_strickers = new JLabel();
        corridas_participandoLabel = new JLabel();
        corridas_marcadasLabel = new JLabel();
   
        jScrollPane1_corridas_participando = new JScrollPane();
        tabela_corridas_participando = new JTable();
        jScrollPane1_allcorridas = new JScrollPane();
        tabela_allcorridas = new JTable();
        
    }

    private void add() {

        add(btnRelatar);
        add(btnSair);
        add(btnParticipar_corrida);
        add(btnCriar_corrida);
        add(btnVerificar_corridas);
        add(btnAvaliar_kartdromo);
        add(numero_vitoriaLabel);
        add(nome_piloto);
        add(numero_strickers);
        add(corridas_participandoLabel);
        add(corridas_marcadasLabel);
        add(jScrollPane1_corridas_participando);
        add(jScrollPane1_allcorridas);
        add(drawer);
        add(fundo);
    }

    private void setTheme() {
        if (Info.TEMA) {
            // Se o tema for escuro, os itens ficam assim //
            fundo.setBackground(Colors.BRANCO);
            drawer.setBackground(Colors.VERDEDARK);
            numero_vitoriaLabel.setForeground(Colors.CINZALIGHTB);
            nome_piloto.setForeground(Colors.CINZALIGHTB);
            numero_strickers.setForeground(Colors.CINZALIGHTB);
            corridas_participandoLabel.setForeground(Colors.CINZALIGHTB);
            corridas_marcadasLabel.setForeground(Colors.CINZALIGHTB);

            btnRelatar.setForeground(Colors.CINZADARKB);
            btnSair.setForeground(Colors.CINZADARKB);
            btnParticipar_corrida.setForeground(Colors.CINZADARKB);
            btnCriar_corrida.setForeground(Colors.CINZADARKB);
            btnVerificar_corridas.setForeground(Colors.CINZADARKB);
            btnAvaliar_kartdromo.setForeground(Colors.CINZADARKB);
            btnRelatar.setBackground(Colors.VERDELIGHT);
            btnSair.setBackground(Colors.VERDEDARK);
            btnParticipar_corrida.setBackground(Colors.VERDEDARK);
            btnCriar_corrida.setBackground(Colors.VERDEDARK);
            btnVerificar_corridas.setBackground(Colors.VERDEDARK);
            btnAvaliar_kartdromo.setBackground(Colors.VERDEDARK);
            
            drawer.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Perfil Piloto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12), Colors.CINZALIGHTB)); // NOI18N
            
        } else {
            fundo.setBackground(Colors.CINZAMEDA);
            drawer.setBackground(Colors.VERDEDARK);
   
            numero_vitoriaLabel.setForeground(Colors.CINZALIGHTB);
            nome_piloto.setForeground(Colors.CINZALIGHTB);
            numero_strickers.setForeground(Colors.CINZALIGHTB);
            corridas_participandoLabel.setForeground(Colors.CINZALIGHTB);
            corridas_marcadasLabel.setForeground(Colors.CINZALIGHTB);
            
            btnRelatar.setBackground(Colors.CINZADARKA);
            btnSair.setBackground(Colors.VERDEDARK);
            btnParticipar_corrida.setBackground(Colors.VERDEDARK);
            btnCriar_corrida.setBackground(Colors.VERDEDARK);
            btnVerificar_corridas.setBackground(Colors.VERDEDARK);
            btnAvaliar_kartdromo.setBackground(Colors.VERDEDARK);
            btnRelatar.setForeground(Colors.CINZADARKB);
            btnSair.setForeground(Colors.CINZADARKB);
            btnParticipar_corrida.setForeground(Colors.CINZADARKB);
            btnCriar_corrida.setForeground(Colors.CINZADARKB);
            btnVerificar_corridas.setForeground(Colors.CINZADARKB);
            btnAvaliar_kartdromo.setForeground(Colors.CINZADARKB);
            
            drawer.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Perfil Piloto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12), Colors.CINZADARKB)); // NOI18N
            
        }
    }

    private void configs() {

        fundo.setSize(800, 600);

        drawer.setBounds(0, 0, 800, 100);

//        email.setBorder(BorderFactory.createEmptyBorder());
//        email.setBounds(210, 300, 400, 35);
//        email.setHorizontalAlignment(JFormattedTextField.CENTER);

        try {
            
            tabela_allcorridas.setModel(new DefaultTableModel(
            new Object [][] {
                
            },
            new String [] {
                "Nome", "Tipo", "Data"
            }
            ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }

        });
            
       tabelamento = (DefaultTableModel) tabela_allcorridas.getModel();

            tabelamento.addRow(new Object[]{
                "Test",
                "test1",
                "test2"
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
        jScrollPane1_allcorridas.setViewportView(tabela_allcorridas);

        jScrollPane1_allcorridas.setBounds(20, 200, 350, 200);
            
        // config jScrollPane1_corridas_participando
        
        tabela_corridas_participando.setModel(new DefaultTableModel(
            new Object [][] {
                
            },
            new String [] {
                "Nome", "Tipo", "Data"
            }
            ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }

        });
            
       tabelamento = (DefaultTableModel) tabela_corridas_participando.getModel();
            for(int x = 0; x<20;x++ ){
            tabelamento.addRow(new Object[]{
                "Test",
                "test1",
                "test2"
            });
            }
                //Subistituir as linhas anteriores
    //          for (classe : classeDao.findALL()){
    //            tabelamento.addRow(new Object[]{
    //                class.nome,
    //                class.tipo,
    //                class.data
    //            });
    //
    //          }
        jScrollPane1_corridas_participando.setViewportView(tabela_corridas_participando);

        jScrollPane1_corridas_participando.setBounds(400, 150, 350, 200);
        

        }  catch(Exception r){
            System.err.print(r);
        }
       

        btnRelatar.setBorderPainted(false);
        btnRelatar.setFocusPainted(false);
        btnRelatar.addActionListener(this);
        btnRelatar.setBounds(620,20, 100,35);
        btnRelatar.setText("Relatar");
        
        btnSair.setBorderPainted(false);
        btnSair.setFocusPainted(false);
        btnSair.addActionListener(this);
        btnSair.setBounds(600,550, 100,35);
        btnSair.setText("Sair");
        
//        btnSair.setBorderPainted(false);
//        btnSair.setFocusPainted(false);
//        btnSair.addActionListener(this);
//        btnSair.setBounds(600,550, 100,35);
//        btnSair.setText("Sair");
//        
//        btnSair.setBorderPainted(false);
//        btnSair.setFocusPainted(false);
//        btnSair.addActionListener(this);
//        btnSair.setBounds(600,550, 100,35);
     
    }

        
       

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSair) {
            System.exit(0);
        }
        if (e.getSource() == btnRelatar) {
           
        }
        if (e.getSource() == btnParticipar_corrida) {
           
        }
        if (e.getSource() == btnCriar_corrida) {
           
        }
        if (e.getSource() == btnVerificar_corridas) {
           
        }
        if (e.getSource() == btnAvaliar_kartdromo) {
           
        }
        
    }

    
} 
