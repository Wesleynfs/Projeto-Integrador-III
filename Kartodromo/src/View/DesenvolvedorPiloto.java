package View;

import Utilities.Colors;

import Utilities.Fonts;
import Utilities.Info;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class DesenvolvedorPiloto extends JFrame implements ActionListener{
    private JPanel fundo;
    private JPanel drawer;
    
    private JFormattedTextField Nome_TextField;
    private JFormattedTextField senha_TextField;
    private JFormattedTextField cpf_TextField;
    private JFormattedTextField email_TextField;
    private JFormattedTextField data_nascimento_TextField;
    private JFormattedTextField status_atividade_TextField;
    
    private JSpinner numero_strikersJSpinner;
    private JSpinner numero_vitoriasJSpinner;
    private JSpinner idJSpinner;
    
    private JLabel logo;
    
    private JScrollPane jScrollPaneParticipantes;
    private JTable tableParticipantes_status;
    
    private DefaultTableModel tabelamento;
    
    private JLabel nomeLabel;
    private JLabel senhaLabel;
    private JLabel cpfLabel;
    private JLabel emailLabel;
    private JLabel numero_strikersLabel;
    private JLabel numero_vitoriasLabel;
    private JLabel data_nascimentoLabel;
    private JLabel status_atividadeLabel;
    private JLabel idLabel;
            
    private JButton btnSair;
    private JButton btnIrkartodromo;
    private JButton btnCadastrar;
    private JButton btnAlterar;
    private JButton btnDeletar;
    
    public DesenvolvedorPiloto() {
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
        
        numero_strikersJSpinner = new JSpinner();
        numero_vitoriasJSpinner = new JSpinner();
        idJSpinner = new JSpinner();
        
        Nome_TextField = new JFormattedTextField();
        senha_TextField = new JFormattedTextField();
        cpf_TextField = new JFormattedTextField(); 
        email_TextField = new JFormattedTextField();
        data_nascimento_TextField = new JFormattedTextField();
        status_atividade_TextField = new JFormattedTextField();
        logo = new JLabel();
        nomeLabel = new JLabel();
        senhaLabel = new JLabel();     
        cpfLabel = new JLabel();
        emailLabel = new JLabel();
        idLabel = new JLabel();
        numero_strikersLabel = new JLabel();
        numero_vitoriasLabel = new JLabel();
        data_nascimentoLabel = new JLabel();
        status_atividadeLabel = new JLabel();
        
        btnSair = new JButton();
        btnIrkartodromo = new JButton();
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
        add(jScrollPaneParticipantes);
        add(numero_strikersJSpinner);
        add(Nome_TextField);
        add(senha_TextField);
        add(cpf_TextField);
        add(email_TextField);
        add(status_atividade_TextField);
        add(data_nascimento_TextField);
        add(nomeLabel);
        add(senhaLabel);
        add(cpfLabel);
        add(emailLabel);
        add(idJSpinner);
        add(idLabel);
        add(data_nascimentoLabel);
        add(status_atividadeLabel);
        add(numero_strikersLabel);
        add(numero_vitoriasJSpinner);
        add(numero_vitoriasLabel);
        add(btnIrkartodromo);
        add(btnSair);

        add(drawer);
        add(fundo);

        
    }
    private void setTheme() {
        if (LoginFrame.getConfiguracao().isTema()) {
            // Se o tema for escuro, os itens ficam assim //
            tableParticipantes_status.setBackground(Colors.VERDELIGHT);
            tableParticipantes_status.setForeground(Colors.CINZADARKB);
            Nome_TextField.setBackground(Colors.CINZALIGHTB);
            Nome_TextField.setForeground(Colors.BRANCO);   
            senha_TextField.setBackground(Colors.CINZALIGHTB);
            senha_TextField.setForeground(Colors.BRANCO);     
            cpf_TextField.setBackground(Colors.CINZALIGHTB);
            cpf_TextField.setForeground(Colors.BRANCO); 
            email_TextField.setBackground(Colors.CINZALIGHTB);       
            email_TextField.setForeground(Colors.BRANCO);   
            data_nascimento_TextField.setBackground(Colors.CINZALIGHTB);  
            data_nascimento_TextField.setForeground(Colors.BRANCO); 
            status_atividade_TextField.setBackground(Colors.CINZALIGHTB);  
            status_atividade_TextField.setForeground(Colors.BRANCO); 
            status_atividadeLabel.setForeground(Colors.CINZALIGHTB);
            data_nascimentoLabel.setForeground(Colors.CINZALIGHTB);
            numero_strikersJSpinner.getEditor().getComponent(0).setBackground(Colors.CINZALIGHTB);
            numero_strikersJSpinner.getEditor().getComponent(0).setForeground(Colors.BRANCO);
            numero_vitoriasJSpinner.getEditor().getComponent(0).setBackground(Colors.CINZALIGHTB);
            numero_vitoriasJSpinner.getEditor().getComponent(0).setForeground(Colors.BRANCO);
            idJSpinner.getEditor().getComponent(0).setBackground(Colors.CINZALIGHTB);
            idJSpinner.getEditor().getComponent(0).setForeground(Colors.BRANCO);
            idLabel.setForeground(Colors.CINZALIGHTB);
            senhaLabel.setForeground(Colors.CINZALIGHTB);
            nomeLabel.setForeground(Colors.CINZALIGHTB);   
            cpfLabel.setForeground(Colors.CINZALIGHTB);       
            emailLabel.setForeground(Colors.CINZALIGHTB);
            numero_strikersLabel.setForeground(Colors.CINZALIGHTB);
            numero_vitoriasLabel.setForeground(Colors.CINZALIGHTB);
            logo.setForeground(Colors.CINZAMEDB);
            btnSair.setBackground(Colors.VERDEDARK);
            btnSair.setForeground(Colors.CINZADARKB);
            btnIrkartodromo.setBackground(Colors.VERDEDARK);
            btnIrkartodromo.setForeground(Colors.CINZADARKB);
            btnCadastrar.setBackground(Colors.VERDEDARK);
            btnAlterar.setBackground(Colors.VERDEDARK);
            btnDeletar.setBackground(Colors.VERDEDARK);
            btnCadastrar.setForeground(Colors.CINZADARKB);
            btnAlterar.setForeground(Colors.CINZADARKB);
            btnDeletar.setForeground(Colors.CINZADARKB);
            fundo.setBackground(Colors.CINZAMEDB);
            drawer.setBackground(Colors.VERDEDARK);
        } else {
            tableParticipantes_status.setForeground(Colors.CINZADARKB);
            tableParticipantes_status.setBackground(Colors.VERDEDARK);
            Nome_TextField.setBackground(Colors.CINZALIGHTB);
            Nome_TextField.setForeground(Colors.CINZADARKA);             
            senha_TextField.setBackground(Colors.CINZALIGHTB);
            senha_TextField.setForeground(Colors.CINZADARKA);     
            cpf_TextField.setBackground(Colors.CINZALIGHTB);
            cpf_TextField.setForeground(Colors.CINZADARKA);
            email_TextField.setBackground(Colors.CINZALIGHTB);       
            email_TextField.setForeground(Colors.CINZADARKA);
            data_nascimento_TextField.setBackground(Colors.CINZALIGHTB);
            data_nascimento_TextField.setForeground(Colors.CINZADARKA);
            status_atividade_TextField.setBackground(Colors.CINZALIGHTB);
            status_atividade_TextField.setForeground(Colors.CINZADARKA);
            status_atividadeLabel.setForeground(Colors.CINZALIGHTB);
            data_nascimentoLabel.setForeground(Colors.CINZALIGHTB);    
            idJSpinner.getEditor().getComponent(0).setBackground(Colors.CINZALIGHTB);
            idJSpinner.getEditor().getComponent(0).setForeground(Colors.BRANCO);
            idLabel.setForeground(Colors.CINZALIGHTB);
            numero_strikersJSpinner.getEditor().getComponent(0).setBackground(Colors.CINZALIGHTB);
            numero_strikersJSpinner.getEditor().getComponent(0).setForeground(Colors.BRANCO);
            numero_vitoriasJSpinner.getEditor().getComponent(0).setBackground(Colors.CINZALIGHTB);
            numero_vitoriasJSpinner.getEditor().getComponent(0).setForeground(Colors.BRANCO);
            numero_strikersLabel.setForeground(Colors.CINZALIGHTB);            
            nomeLabel.setForeground(Colors.CINZALIGHTB);
            senhaLabel.setForeground(Colors.CINZALIGHTB);   
            cpfLabel.setForeground(Colors.CINZALIGHTB);       
            emailLabel.setForeground(Colors.CINZALIGHTB);
            numero_vitoriasLabel.setForeground(Colors.CINZALIGHTB);
            logo.setForeground(Colors.CINZAMEDB);
            btnSair.setBackground(Colors.VERDEDARK);
            btnSair.setForeground(Colors.CINZADARKB);
            btnIrkartodromo.setBackground(Colors.VERDEDARK);
            btnIrkartodromo.setForeground(Colors.CINZADARKB);
  
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

        status_atividadeLabel.setText("Status de atividade:");
        status_atividadeLabel.setBounds(60,230,200,35);
        
        status_atividade_TextField.setBorder(BorderFactory.createEmptyBorder());
        status_atividade_TextField.setBounds(60,270,200,35);
        status_atividade_TextField.setHorizontalAlignment(JFormattedTextField.CENTER);

        data_nascimentoLabel.setText("Data de Nascimento:");
        data_nascimentoLabel.setBounds(60,310,200,35);
                
        data_nascimento_TextField.setBorder(BorderFactory.createEmptyBorder());
        data_nascimento_TextField.setBounds(60,350,200,35);
        data_nascimento_TextField.setHorizontalAlignment(JFormattedTextField.CENTER);       
                
        nomeLabel.setText("NOME:");
        nomeLabel.setBounds(400,230,200,35);
        
        Nome_TextField.setBorder(BorderFactory.createEmptyBorder());
        Nome_TextField.setBounds(400,260,150,35);
        Nome_TextField.setHorizontalAlignment(JFormattedTextField.CENTER);
        
        senhaLabel.setText("SENHA:");
        senhaLabel.setBounds(600,230,200,35);
        
        senha_TextField.setBorder(BorderFactory.createEmptyBorder());
        senha_TextField.setBounds(600,260,150,35);
        senha_TextField.setHorizontalAlignment(JFormattedTextField.CENTER);
        
        cpfLabel.setText("CPF:");
        cpfLabel.setBounds(400,290,200,35);
        
        cpf_TextField.setBorder(BorderFactory.createEmptyBorder());
        cpf_TextField.setBounds(400,330,150,35);
        cpf_TextField.setHorizontalAlignment(JFormattedTextField.CENTER);
        
        numero_strikersLabel.setText("Número Strikers:");
        numero_strikersLabel.setBounds(600,290,200,35);
        
        numero_vitoriasLabel.setText("Número vitórias:");
        numero_vitoriasLabel.setBounds(60,390,200,35);
        
        numero_strikersJSpinner.setBounds(600,330,150,35);
        numero_strikersJSpinner.setBorder(BorderFactory.createEmptyBorder());
        
        numero_vitoriasJSpinner.setBounds(60,430,50,35);
        numero_vitoriasJSpinner.setBorder(BorderFactory.createEmptyBorder());
        
        idLabel.setBounds(200,390,50,35);
        idLabel.setText("ID:");
        
        idJSpinner.setBounds(200,430,50,35);
        idJSpinner.setBorder(BorderFactory.createEmptyBorder());
        
        emailLabel.setText("EMAIL:");
        emailLabel.setBounds(400,370,200,35);
               
        email_TextField.setBorder(BorderFactory.createEmptyBorder());
        email_TextField.setBounds(400,410,350,35);
        email_TextField.setHorizontalAlignment(JFormattedTextField.CENTER);

        logo.setText("AMBIENTE DOS DESENVOLVEDORES");
        logo.setFont(Fonts.SANSSERIFMIN);
        logo.setBounds(20 , 30,550,35);

        btnSair.setText("VOLTAR");
        btnSair.setBorderPainted(false);
        btnSair.setFocusPainted(false);
        btnSair.addActionListener(this);
        btnSair.setBounds(20,550, 100,35);

        btnIrkartodromo.setFocusPainted(false);
        btnIrkartodromo.setBorderPainted(false);
        btnIrkartodromo.addActionListener(this);
        btnIrkartodromo.setText("ALTERAÇÕES EM KARTÓDROMO");
        btnIrkartodromo.setBounds(570,550,200,35);
        
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
                            "ID","NOME","SENHA","CPF","EMAIL"
                    }
            ) {
                boolean[] canEdit = new boolean[]{
                        false,false ,false, false,false
                };

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit[columnIndex];
                }

            });

            tabelamento = (DefaultTableModel) tableParticipantes_status.getModel();

            tabelamento.addRow(new Object[]{
                    "1","FELIPAO","12345","115.112.213-233","FELIPEFILLUS@GMAIL.com"
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
        
        
        if(e.getSource() == btnIrkartodromo) {
            dispose();
            new DesenvolvedorKartodromo();
        }
    }
    
}