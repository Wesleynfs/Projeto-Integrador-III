package View;

import Utilities.Colors;

import Utilities.Fonts;
import Utilities.Info;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class DesenvolvedorKartodromo extends JFrame implements ActionListener{

    private JPanel fundo;
    private JPanel drawer;
    private JFormattedTextField paisJTextField;
    private JFormattedTextField estadoJTextField;
    private JFormattedTextField cidadeJTextField;
    private JFormattedTextField ruaJTextField;
    private JFormattedTextField nomeJTextField;
    private JFormattedTextField senhaJTextField;
    private JFormattedTextField emailJTextField;
    private JSpinner numeroJSpinner;
    private JSpinner idJSpinner;
    private JLabel logo;
    private JScrollPane jScrollPaneParticipantes;
    private JTable tableParticipantes_status;
    private DefaultTableModel tabelamento;
    private JLabel diassemanaLabel;
    private JLabel tipokartsLabel;
    private JLabel paisLabel;
    private JLabel estadoLabel;
    private JLabel cidadeLabel;
    private JLabel ruaLabel;
    private JLabel numeroLabel;
    private JLabel idLabel;
    private JLabel nomeLabel;
    private JLabel senhaLabel; 
    private JLabel emailLabel;
    private JCheckBox domingoCheckBox;
    private JCheckBox segundaCheckBox;
    private JCheckBox tercaCheckBox;
    private JCheckBox quartaCheckBox; 
    private JCheckBox quintaCheckBox;
    private JCheckBox sextaCheckBox;
    private JCheckBox sabadoCheckBox;
    private JCheckBox kartindoorCheckBox;
    private JCheckBox kart2motorCheckBox;
    private JCheckBox kart4motorCheckBox;
    private JCheckBox kartshiCheckBox;
    private JCheckBox kartsemmarchaCheckBox;
    private JButton btnSair;
    private JButton btnIrparapiloto;
    private JButton btnCadastrar;
    private JButton btnAlterar;
    private JButton btnDeletar;
    
    public DesenvolvedorKartodromo() {
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
    private void configurateThis(){
        setUndecorated(true);
        setSize(Info.MINSCREENSIZE);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle(Info.APP_NAME);
        setResizable(false);
    }
    
    private void initializate(){
        
        fundo = new JPanel();
        drawer = new JPanel();
        
        numeroJSpinner = new JSpinner();
        idJSpinner = new JSpinner();
        paisJTextField = new JFormattedTextField();
        estadoJTextField = new JFormattedTextField();
        cidadeJTextField = new JFormattedTextField(); 
        ruaJTextField = new JFormattedTextField();
        nomeJTextField = new JFormattedTextField();
        senhaJTextField = new JFormattedTextField();
        emailJTextField = new JFormattedTextField();
        logo = new JLabel();
        paisLabel = new JLabel();
        estadoLabel = new JLabel();     
        cidadeLabel = new JLabel();
        ruaLabel = new JLabel();
        numeroLabel = new JLabel();
        diassemanaLabel = new JLabel();
        tipokartsLabel = new JLabel();
        idLabel = new JLabel();
        nomeLabel = new JLabel();
        senhaLabel = new JLabel();
        emailLabel = new JLabel();
        domingoCheckBox = new JCheckBox();
        segundaCheckBox = new JCheckBox();
        tercaCheckBox = new JCheckBox();
        quartaCheckBox = new JCheckBox(); 
        quintaCheckBox = new JCheckBox();
        sextaCheckBox = new JCheckBox();
        sabadoCheckBox = new JCheckBox();
    
        kartindoorCheckBox = new JCheckBox();
        kart2motorCheckBox = new JCheckBox();
        kart4motorCheckBox = new JCheckBox();
        kartshiCheckBox  = new JCheckBox();
        kartsemmarchaCheckBox = new JCheckBox();
        
        btnSair = new JButton();
        btnIrparapiloto = new JButton();
        btnCadastrar = new JButton();
        btnAlterar = new JButton();
        btnDeletar = new JButton();
        
        jScrollPaneParticipantes = new JScrollPane();
        tableParticipantes_status = new JTable();
    }
    
    private void add() {
        add(logo);
        add(btnCadastrar);
        add(btnAlterar);
        add(btnDeletar);
        add(senhaJTextField);
        add(nomeJTextField);
        add(emailJTextField);
        add(nomeLabel);
        add(senhaLabel);
        add(emailLabel);
        add(jScrollPaneParticipantes);
        add(numeroJSpinner);
        add(paisJTextField);
        add(estadoJTextField);
        add(cidadeJTextField);
        add(ruaJTextField);
        add(paisLabel);
        add(estadoLabel);
        add(cidadeLabel);
        add(ruaLabel);
        add(numeroLabel);
        add(diassemanaLabel);
        add(tipokartsLabel);
        add(domingoCheckBox);
        add(segundaCheckBox);
        add(tercaCheckBox);
        add(quartaCheckBox);
        add(quintaCheckBox);
        add(sextaCheckBox);
        add(sabadoCheckBox);
        add(idJSpinner);
        add(idLabel);
        add(kartindoorCheckBox);
        add(kart2motorCheckBox);
        add(kart4motorCheckBox);
        add(kartshiCheckBox);
        add(kartsemmarchaCheckBox);
        add(btnIrparapiloto);
        add(btnSair);

        add(drawer);
        add(fundo);

        
    }
    private void setTheme() {
        if (SplashScreen.getConfiguracao().isTema()) {
            // Se o tema for escuro, os itens ficam assim //
            tableParticipantes_status.setBackground(Colors.VERDELIGHT);
            tableParticipantes_status.setForeground(Colors.CINZADARKB);
            paisJTextField.setBackground(Colors.CINZALIGHTB);
            paisJTextField.setForeground(Colors.BRANCO);   
            estadoJTextField.setBackground(Colors.CINZALIGHTB);
            estadoJTextField.setForeground(Colors.BRANCO);     
            cidadeJTextField.setBackground(Colors.CINZALIGHTB);
            cidadeJTextField.setForeground(Colors.BRANCO); 
            ruaJTextField.setBackground(Colors.CINZALIGHTB);       
            ruaJTextField.setForeground(Colors.BRANCO);   
            senhaJTextField.setBackground(Colors.CINZALIGHTB);
            senhaJTextField.setForeground(Colors.BRANCO);
            nomeJTextField.setBackground(Colors.CINZALIGHTB);
            nomeJTextField.setForeground(Colors.BRANCO);
            emailJTextField.setBackground(Colors.CINZALIGHTB);
            emailJTextField.setForeground(Colors.BRANCO);
            nomeLabel.setForeground(Colors.CINZALIGHTB);
            senhaLabel.setForeground(Colors.CINZALIGHTB);
            emailLabel.setForeground(Colors.CINZALIGHTB);
            numeroJSpinner.getEditor().getComponent(0).setBackground(Colors.CINZALIGHTB);
            numeroJSpinner.getEditor().getComponent(0).setForeground(Colors.BRANCO);
            idJSpinner.getEditor().getComponent(0).setBackground(Colors.CINZALIGHTB);
            idJSpinner.getEditor().getComponent(0).setForeground(Colors.BRANCO);
            estadoLabel.setForeground(Colors.CINZALIGHTB);
            paisLabel.setForeground(Colors.CINZALIGHTB);   
            cidadeLabel.setForeground(Colors.CINZALIGHTB);       
            ruaLabel.setForeground(Colors.CINZALIGHTB);
            numeroLabel.setForeground(Colors.CINZALIGHTB);
            tipokartsLabel.setForeground(Colors.CINZALIGHTB);
            diassemanaLabel.setForeground(Colors.CINZALIGHTB);
            idLabel.setForeground(Colors.CINZALIGHTB);
            logo.setForeground(Colors.CINZAMEDB);

            domingoCheckBox.setForeground(Colors.BRANCO);
            domingoCheckBox.setBackground(Colors.CINZALIGHTB);
            sabadoCheckBox.setForeground(Colors.BRANCO);
            sabadoCheckBox.setBackground(Colors.CINZALIGHTB);
            segundaCheckBox.setForeground(Colors.BRANCO);
            segundaCheckBox.setBackground(Colors.CINZALIGHTB);
            tercaCheckBox.setForeground(Colors.BRANCO);
            tercaCheckBox.setBackground(Colors.CINZALIGHTB);
            quartaCheckBox.setForeground(Colors.BRANCO);
            quartaCheckBox.setBackground(Colors.CINZALIGHTB);
            quintaCheckBox.setForeground(Colors.BRANCO);
            quintaCheckBox.setBackground(Colors.CINZALIGHTB);
            sextaCheckBox.setForeground(Colors.BRANCO);
            sextaCheckBox.setBackground(Colors.CINZALIGHTB);

            kartindoorCheckBox.setForeground(Colors.BRANCO);
            kartindoorCheckBox.setBackground(Colors.CINZALIGHTB);

            kart2motorCheckBox.setForeground(Colors.BRANCO);
            kart2motorCheckBox.setBackground(Colors.CINZALIGHTB);

            kart4motorCheckBox.setForeground(Colors.BRANCO);
            kart4motorCheckBox.setBackground(Colors.CINZALIGHTB);

            kartshiCheckBox.setForeground(Colors.BRANCO);
            kartshiCheckBox.setBackground(Colors.CINZALIGHTB);

            kartsemmarchaCheckBox.setForeground(Colors.BRANCO);
            kartsemmarchaCheckBox.setBackground(Colors.CINZALIGHTB);

            btnSair.setBackground(Colors.VERDEDARK);
            btnSair.setForeground(Colors.CINZADARKB);
            btnIrparapiloto.setBackground(Colors.VERDEDARK);
            btnIrparapiloto.setForeground(Colors.CINZADARKB);
            btnCadastrar.setBackground(Colors.VERDEDARK);
            btnAlterar.setBackground(Colors.VERDEDARK);
            btnDeletar.setBackground(Colors.VERDEDARK);
            btnCadastrar.setForeground(Colors.CINZADARKB);
            btnAlterar.setForeground(Colors.CINZADARKB);
            btnDeletar.setForeground(Colors.CINZADARKB);
            fundo.setBackground(Colors.CINZAMEDB);
            drawer.setBackground(Colors.VERDEDARK);
        } else {
            senhaJTextField.setBackground(Colors.CINZALIGHTB);
            senhaJTextField.setForeground(Colors.CINZADARKA);
            nomeJTextField.setBackground(Colors.CINZALIGHTB);
            nomeJTextField.setForeground(Colors.CINZADARKA);
            emailJTextField.setBackground(Colors.CINZALIGHTB);
            emailJTextField.setForeground(Colors.CINZADARKA);
            nomeLabel.setForeground(Colors.CINZALIGHTB);   
            senhaLabel.setForeground(Colors.CINZALIGHTB);   
            emailLabel.setForeground(Colors.CINZALIGHTB);   
            tableParticipantes_status.setForeground(Colors.CINZADARKB);
            tableParticipantes_status.setBackground(Colors.VERDEDARK);
            paisJTextField.setBackground(Colors.CINZALIGHTB);
            paisJTextField.setForeground(Colors.CINZADARKA);             
            estadoJTextField.setBackground(Colors.CINZALIGHTB);
            estadoJTextField.setForeground(Colors.CINZADARKA);     
            cidadeJTextField.setBackground(Colors.CINZALIGHTB);
            cidadeJTextField.setForeground(Colors.CINZADARKA);
            ruaJTextField.setBackground(Colors.CINZALIGHTB);       
            ruaJTextField.setForeground(Colors.CINZADARKA);
            numeroJSpinner.getEditor().getComponent(0).setBackground(Colors.CINZALIGHTB);
            numeroJSpinner.getEditor().getComponent(0).setForeground(Colors.BRANCO);
            idJSpinner.getEditor().getComponent(0).setBackground(Colors.CINZALIGHTB);
            idJSpinner.getEditor().getComponent(0).setForeground(Colors.BRANCO);
            numeroLabel.setForeground(Colors.CINZALIGHTB);            
            paisLabel.setForeground(Colors.CINZALIGHTB);
            estadoLabel.setForeground(Colors.CINZALIGHTB);   
            cidadeLabel.setForeground(Colors.CINZALIGHTB);       
            ruaLabel.setForeground(Colors.CINZALIGHTB);
            tipokartsLabel.setForeground(Colors.CINZALIGHTB);
            diassemanaLabel.setForeground(Colors.CINZALIGHTB);
            idLabel.setForeground(Colors.CINZALIGHTB);
            logo.setForeground(Colors.CINZAMEDB);
            btnSair.setBackground(Colors.VERDEDARK);
            btnSair.setForeground(Colors.CINZADARKB);
            btnIrparapiloto.setBackground(Colors.VERDEDARK);
            btnIrparapiloto.setForeground(Colors.CINZADARKB);

            domingoCheckBox.setForeground(Colors.BRANCO);
            domingoCheckBox.setBackground(Colors.CINZALIGHTB);
            sabadoCheckBox.setForeground(Colors.BRANCO);
            sabadoCheckBox.setBackground(Colors.CINZALIGHTB);
            segundaCheckBox.setForeground(Colors.BRANCO);
            segundaCheckBox.setBackground(Colors.CINZALIGHTB);
            tercaCheckBox.setForeground(Colors.BRANCO);
            tercaCheckBox.setBackground(Colors.CINZALIGHTB);
            quartaCheckBox.setForeground(Colors.BRANCO);
            quartaCheckBox.setBackground(Colors.CINZALIGHTB);
            quintaCheckBox.setForeground(Colors.BRANCO);
            quintaCheckBox.setBackground(Colors.CINZALIGHTB);
            sextaCheckBox.setForeground(Colors.BRANCO);
            sextaCheckBox.setBackground(Colors.CINZALIGHTB);

            kartindoorCheckBox.setForeground(Colors.BRANCO);
            kartindoorCheckBox.setBackground(Colors.CINZALIGHTB);

            kart2motorCheckBox.setForeground(Colors.BRANCO);
            kart2motorCheckBox.setBackground(Colors.CINZALIGHTB);

            kart4motorCheckBox.setForeground(Colors.BRANCO);
            kart4motorCheckBox.setBackground(Colors.CINZALIGHTB);

            kartshiCheckBox.setForeground(Colors.BRANCO);
            kartshiCheckBox.setBackground(Colors.CINZALIGHTB);

            kartsemmarchaCheckBox.setForeground(Colors.BRANCO);
            kartsemmarchaCheckBox.setBackground(Colors.CINZALIGHTB);
            btnCadastrar.setBackground(Colors.VERDEDARK);
            btnAlterar.setBackground(Colors.VERDEDARK);
            btnDeletar.setBackground(Colors.VERDEDARK);
            btnCadastrar.setForeground(Colors.CINZADARKB);
            btnAlterar.setForeground(Colors.CINZADARKB);
            btnDeletar.setForeground(Colors.CINZADARKB);
            fundo.setBackground(Colors.CINZAMEDA);
            drawer.setBackground(Colors.VERDEDARK);
        }
    }
    private void configs() {

        fundo.setSize(800,600);
        drawer.setBounds(0,0,800,100);

        diassemanaLabel.setText("Dias de Funcionamento:");
        diassemanaLabel.setBounds(20,230,150,35);
        
        domingoCheckBox.setText("Domingo");
        domingoCheckBox.setFocusPainted(false);
        domingoCheckBox.setBounds(20,260,150,30);
        sabadoCheckBox.setText("Sabado");
        sabadoCheckBox.setFocusPainted(false);
        sabadoCheckBox.setBounds(20,290,150,30);
        segundaCheckBox.setText("Segunda - Feira");
        segundaCheckBox.setFocusPainted(false);
        segundaCheckBox.setBounds(20,320,150,30);
        tercaCheckBox.setText("Terça - Feira");
        tercaCheckBox.setFocusPainted(false);
        tercaCheckBox.setBounds(20,350,150,30);
        quartaCheckBox.setText("Quarta - Feira");
        quartaCheckBox.setFocusPainted(false);
        quartaCheckBox.setBounds(20,380,150,30);
        quintaCheckBox.setText("Quinta - Feira");
        quintaCheckBox.setFocusPainted(false);
        quintaCheckBox.setBounds(20,410,150,30);
        sextaCheckBox.setText("Sexta - Feira");
        sextaCheckBox.setFocusPainted(false);
        sextaCheckBox.setBounds(20,440,150,30);
        
        tipokartsLabel.setText("Tipos de Kart (MOTOR)");
        tipokartsLabel.setBounds(210,230,150,35);
        kartindoorCheckBox.setText("Indoor");
        kartindoorCheckBox.setFocusPainted(false);
        kartindoorCheckBox.setBounds(210,260,150,35);
        kart2motorCheckBox.setText("Motor 2 Tempos");
        kart2motorCheckBox.setFocusPainted(false);
        kart2motorCheckBox.setBounds(210,290,150,35);
        kart4motorCheckBox.setText("Motor 4 Tempos");
        kart4motorCheckBox.setFocusPainted(false);
        kart4motorCheckBox.setBounds(210,320,150,35);
        kartshiCheckBox.setText("Shifter");
        kartshiCheckBox.setFocusPainted(false);
        kartshiCheckBox.setBounds(210,380,150,35);
        kartsemmarchaCheckBox.setText("Sem Marcha");
        kartsemmarchaCheckBox.setFocusPainted(false);
        kartsemmarchaCheckBox.setBounds(210,350,150,35);
        paisLabel.setText("País:");
        paisLabel.setBounds(400,230,200,35);
        
        paisJTextField.setBorder(BorderFactory.createEmptyBorder());
        paisJTextField.setBounds(400,260,150,35);
        paisJTextField.setHorizontalAlignment(JFormattedTextField.CENTER);
        
        estadoLabel.setText("Estado:");
        estadoLabel.setBounds(600,230,200,35);
        
        estadoJTextField.setBorder(BorderFactory.createEmptyBorder());
        estadoJTextField.setBounds(600,260,150,35);
        estadoJTextField.setHorizontalAlignment(JFormattedTextField.CENTER);
        
        cidadeLabel.setText("Cidade:");
        cidadeLabel.setBounds(400,285,200,35);
        
        cidadeJTextField.setBorder(BorderFactory.createEmptyBorder());
        cidadeJTextField.setBounds(400,310,150,35);
        cidadeJTextField.setHorizontalAlignment(JFormattedTextField.CENTER);
        
        numeroLabel.setText("Número:");
        numeroLabel.setBounds(600,285,200,35);
        
        idLabel.setText("ID:");
        idLabel.setBounds(700,285,200,35);
        
        numeroJSpinner.setBounds(600,310,50,35);
        numeroJSpinner.setBorder(BorderFactory.createEmptyBorder());
        
        idJSpinner.setBounds(700,310,50,35);
        idJSpinner.setBorder(BorderFactory.createEmptyBorder());
        
        ruaLabel.setText("Rua:");
        ruaLabel.setBounds(400,340,200,35);
               
        ruaJTextField.setBorder(BorderFactory.createEmptyBorder());
        ruaJTextField.setBounds(400,370,350,35);
        ruaJTextField.setHorizontalAlignment(JFormattedTextField.CENTER);

        nomeLabel.setText("Nome:");
        nomeLabel.setBounds(400,420,200,35);
        
        nomeJTextField.setBorder(BorderFactory.createEmptyBorder());
        nomeJTextField.setBounds(400,450,150,35);
        nomeJTextField.setHorizontalAlignment(JFormattedTextField.CENTER);
        
        senhaLabel.setText("Senha:");
        senhaLabel.setBounds(600,420,200,35);
        
        senhaJTextField.setBorder(BorderFactory.createEmptyBorder());
        senhaJTextField.setBounds(600,450,150,35);
        senhaJTextField.setHorizontalAlignment(JFormattedTextField.CENTER);
        
        emailLabel.setText("Email");
        emailLabel.setBounds(210,420,150,35);
                
        emailJTextField.setBorder(BorderFactory.createEmptyBorder());
        emailJTextField.setBounds(210,450,150,35);
        emailJTextField.setHorizontalAlignment(JFormattedTextField.CENTER);
        
        logo.setText("AMBIENTE DOS DESENVOLVEDORES");
        logo.setFont(Fonts.SANSSERIFMIN);
        logo.setBounds(20 , 30,550,35);

        btnSair.setText("VOLTAR");
        btnSair.setBorderPainted(false);
        btnSair.setFocusPainted(false);
        btnSair.addActionListener(this);
        btnSair.setBounds(20,550, 100,35);

        btnIrparapiloto.setFocusPainted(false);
        btnIrparapiloto.setBorderPainted(false);
        btnIrparapiloto.addActionListener(this);
        btnIrparapiloto.setText("ALTERAÇÕES EM PILOTO");
        btnIrparapiloto.setBounds(570,550,200,35);
        
        btnCadastrar.setFocusPainted(false);
        btnCadastrar.setBorderPainted(false);      
        btnCadastrar.addActionListener(this);        
        btnCadastrar.setText("CADASTRAR");     
        btnCadastrar.setBounds(60,500,170,35);      
        btnAlterar.setFocusPainted(false);       
        btnAlterar.setBorderPainted(false);
        btnAlterar.addActionListener(this);
        btnAlterar.setText("ALTERAR");        
        btnAlterar.setBounds(286,500,150,35);              
        btnDeletar.setFocusPainted(false);
        btnDeletar.setBorderPainted(false);        
        btnDeletar.addActionListener(this);       
        btnDeletar.setText("DELETAR");      
        btnDeletar.setBounds(514,500,150,35);         
 
        try {

            tableParticipantes_status.setModel(new DefaultTableModel(
                    new Object[][]{

                    },
                    new String[]{
                            "ID","NOME","SENHA","ENDEREÇO"
                    }
            ) {
                boolean[] canEdit = new boolean[]{
                        false,false ,false, false
                };

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit[columnIndex];
                }

            });

            tabelamento = (DefaultTableModel) tableParticipantes_status.getModel();

            tabelamento.addRow(new Object[]{
                    "1","KARTEASY","LSWKQDKEWKRKW","BRASIL, ACRE, RUA MALARIA, 123"
            });
            //Subistituir as linhas anteriores
            //          for (classe : classeDao.findALL()){
            //            tabelamento.addRow(new Object[]{
            //                class.nomeJTextField,
            //            });
            //
            //          }
            jScrollPaneParticipantes.setViewportView(tableParticipantes_status);
            jScrollPaneParticipantes.setBounds(60, 110, 680, 120);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
      
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSair) {
            if (JOptionPane.showConfirmDialog(null,"Tem certeza?" , "Confirmação",JOptionPane.YES_NO_OPTION) == 0) {
                System.exit(0);
            }
        }
        if(e.getSource() == btnCadastrar) {
            //CADASTRAR KARTODROMO
        }
        if(e.getSource() == btnAlterar) {
            //ALTERAR KARTODROMO
        }
        if(e.getSource() == btnDeletar) {
            //DELETAR KARTODROMO
        }
        
        
        if(e.getSource() == btnIrparapiloto) {
            dispose();
            new DesenvolvedorPiloto();
        }
    }
    
}