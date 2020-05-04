package View;

import Utilities.Colors;

import Utilities.Fonts;
import Utilities.Info;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Desenvolvedor_Kartodromo extends JFrame implements ActionListener{
    private JPanel fundo;
    private JPanel drawer;
    
    private JFormattedTextField pais;
    private JFormattedTextField estado;
    private JFormattedTextField cidade;
    private JFormattedTextField rua;
    private JFormattedTextField nome;
    private JFormattedTextField senha;
    private JFormattedTextField email;
    
    private JSpinner numero;
    private JSpinner id;
    
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
    
    public Desenvolvedor_Kartodromo() {
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
        
        numero = new JSpinner();
        id = new JSpinner();
        pais = new JFormattedTextField();
        estado = new JFormattedTextField();
        cidade = new JFormattedTextField(); 
        rua = new JFormattedTextField();
        nome = new JFormattedTextField();
        senha = new JFormattedTextField();
        email = new JFormattedTextField();
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
        add(senha);
        add(nome);
        add(email);
        add(nomeLabel);
        add(senhaLabel);
        add(emailLabel);
        add(jScrollPaneParticipantes);
        add(numero);
        add(pais);
        add(estado);
        add(cidade);
        add(rua);
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
        add(id);
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
        if (LoginFrame.getConfiguracao().isTema()) {
            // Se o tema for escuro, os itens ficam assim //
            tableParticipantes_status.setBackground(Colors.VERDELIGHT);
            tableParticipantes_status.setForeground(Colors.CINZADARKB);
            pais.setBackground(Colors.CINZALIGHTB);
            pais.setForeground(Colors.BRANCO);   
            estado.setBackground(Colors.CINZALIGHTB);
            estado.setForeground(Colors.BRANCO);     
            cidade.setBackground(Colors.CINZALIGHTB);
            cidade.setForeground(Colors.BRANCO); 
            rua.setBackground(Colors.CINZALIGHTB);       
            rua.setForeground(Colors.BRANCO);   
            senha.setBackground(Colors.CINZALIGHTB);
            senha.setForeground(Colors.BRANCO);
            nome.setBackground(Colors.CINZALIGHTB);
            nome.setForeground(Colors.BRANCO);
            email.setBackground(Colors.CINZALIGHTB);
            email.setForeground(Colors.BRANCO);
            nomeLabel.setForeground(Colors.CINZALIGHTB);
            senhaLabel.setForeground(Colors.CINZALIGHTB);
            emailLabel.setForeground(Colors.CINZALIGHTB);
            numero.getEditor().getComponent(0).setBackground(Colors.CINZALIGHTB);
            numero.getEditor().getComponent(0).setForeground(Colors.BRANCO);
            id.getEditor().getComponent(0).setBackground(Colors.CINZALIGHTB);
            id.getEditor().getComponent(0).setForeground(Colors.BRANCO);
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
            senha.setBackground(Colors.CINZALIGHTB);
            senha.setForeground(Colors.CINZADARKA);
            nome.setBackground(Colors.CINZALIGHTB);
            nome.setForeground(Colors.CINZADARKA);
            email.setBackground(Colors.CINZALIGHTB);
            email.setForeground(Colors.CINZADARKA);
            nomeLabel.setForeground(Colors.CINZALIGHTB);   
            senhaLabel.setForeground(Colors.CINZALIGHTB);   
            emailLabel.setForeground(Colors.CINZALIGHTB);   
            tableParticipantes_status.setForeground(Colors.CINZADARKB);
            tableParticipantes_status.setBackground(Colors.VERDEDARK);
            pais.setBackground(Colors.CINZALIGHTB);
            pais.setForeground(Colors.CINZADARKA);             
            estado.setBackground(Colors.CINZALIGHTB);
            estado.setForeground(Colors.CINZADARKA);     
            cidade.setBackground(Colors.CINZALIGHTB);
            cidade.setForeground(Colors.CINZADARKA);
            rua.setBackground(Colors.CINZALIGHTB);       
            rua.setForeground(Colors.CINZADARKA);
            numero.getEditor().getComponent(0).setBackground(Colors.CINZALIGHTB);
            numero.getEditor().getComponent(0).setForeground(Colors.BRANCO);
            id.getEditor().getComponent(0).setBackground(Colors.CINZALIGHTB);
            id.getEditor().getComponent(0).setForeground(Colors.BRANCO);
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
        
        pais.setBorder(BorderFactory.createEmptyBorder());
        pais.setBounds(400,260,150,35);
        pais.setHorizontalAlignment(JFormattedTextField.CENTER);
        
        estadoLabel.setText("Estado:");
        estadoLabel.setBounds(600,230,200,35);
        
        estado.setBorder(BorderFactory.createEmptyBorder());
        estado.setBounds(600,260,150,35);
        estado.setHorizontalAlignment(JFormattedTextField.CENTER);
        
        cidadeLabel.setText("Cidade:");
        cidadeLabel.setBounds(400,285,200,35);
        
        cidade.setBorder(BorderFactory.createEmptyBorder());
        cidade.setBounds(400,310,150,35);
        cidade.setHorizontalAlignment(JFormattedTextField.CENTER);
        
        numeroLabel.setText("Número:");
        numeroLabel.setBounds(600,285,200,35);
        
        idLabel.setText("ID:");
        idLabel.setBounds(700,285,200,35);
        
        numero.setBounds(600,310,50,35);
        numero.setBorder(BorderFactory.createEmptyBorder());
        
        id.setBounds(700,310,50,35);
        id.setBorder(BorderFactory.createEmptyBorder());
        
        ruaLabel.setText("Rua:");
        ruaLabel.setBounds(400,340,200,35);
               
        rua.setBorder(BorderFactory.createEmptyBorder());
        rua.setBounds(400,370,350,35);
        rua.setHorizontalAlignment(JFormattedTextField.CENTER);

        nomeLabel.setText("Nome:");
        nomeLabel.setBounds(400,420,200,35);
        
        nome.setBorder(BorderFactory.createEmptyBorder());
        nome.setBounds(400,450,150,35);
        nome.setHorizontalAlignment(JFormattedTextField.CENTER);
        
        senhaLabel.setText("Senha:");
        senhaLabel.setBounds(600,420,200,35);
        
        senha.setBorder(BorderFactory.createEmptyBorder());
        senha.setBounds(600,450,150,35);
        senha.setHorizontalAlignment(JFormattedTextField.CENTER);
        
        emailLabel.setText("Email");
        emailLabel.setBounds(210,420,150,35);
                
        email.setBorder(BorderFactory.createEmptyBorder());
        email.setBounds(210,450,150,35);
        email.setHorizontalAlignment(JFormattedTextField.CENTER);
        
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
            //                class.nome,
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
            //new DESENVOLVEDOR_PILOTO();
        }
    }
    
}