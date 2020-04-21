package View;

import Email.EmailJava;
import Utilities.Colors;

import Utilities.Fonts;
import Utilities.Info;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class CadastrarKartodromo_pt1 extends JFrame implements ActionListener{
    private JPanel fundo;
    private JPanel drawer;
    
    private JFormattedTextField nomeKartodromo;
    private JFormattedTextField emailKartodromo;
    private JFormattedTextField emailConfirmacaoKartodromo;
    private JFormattedTextField codigo;
    private JFormattedTextField senha;
    
    private JLabel version;
    private JLabel logo;
    
    private JLabel nomeLabel;
    private JLabel emailLabel;
    private JLabel emailconfimacaoLabel;
    private JLabel codigoLabel;
    private JLabel senhaLabel;
    
    
    private JButton btnVoltar;
    private JButton btnEnviarCodigo;
    private JButton btnContinuar;
    
    public CadastrarKartodromo_pt1() {
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
        nomeKartodromo = new JFormattedTextField();
        emailKartodromo = new JFormattedTextField();
        emailConfirmacaoKartodromo = new JFormattedTextField();
        codigo = new JFormattedTextField();
        senha = new JFormattedTextField();
        version = new JLabel();
        logo = new JLabel();
        codigoLabel = new JLabel();
        emailconfimacaoLabel = new JLabel();   
        nomeLabel = new JLabel();
        emailLabel = new JLabel();     
        senhaLabel = new JLabel();
        btnVoltar = new JButton();
        btnEnviarCodigo = new JButton();
        btnContinuar = new JButton();
    }
    
    private void add() {
        
        add(nomeKartodromo);
        add(emailKartodromo);
        add(emailConfirmacaoKartodromo);
        add(codigo);
        add(senha);
        add(version);
        add(logo);
        add(codigoLabel);
        add(emailconfimacaoLabel);
        add(nomeLabel);
        add(emailLabel);
        add(senhaLabel);
        add(btnVoltar);
        add(btnEnviarCodigo);
        add(btnContinuar);
        add(drawer);
        add(fundo);
        
    }
    private void setTheme() {
        if (LoginFrame.getConfiguracao().isTema()) {
            // Se o tema for escuro, os itens ficam assim //
            fundo.setBackground(Colors.CINZAMEDB);
            drawer.setBackground(Colors.VERDEDARK);
            nomeKartodromo.setBackground(Colors.CINZALIGHTB);
            nomeKartodromo.setForeground(Colors.BRANCO);
            emailKartodromo.setBackground(Colors.CINZALIGHTB);
            emailKartodromo.setForeground(Colors.BRANCO);
            emailConfirmacaoKartodromo.setBackground(Colors.CINZALIGHTB);
            emailConfirmacaoKartodromo.setForeground(Colors.BRANCO);
            codigo.setBackground(Colors.CINZALIGHTB);       
            codigo.setForeground(Colors.BRANCO);            
            senha.setBackground(Colors.CINZALIGHTB);         
            senha.setForeground(Colors.BRANCO);                  
            codigoLabel.setForeground(Colors.CINZALIGHTB);
            emailconfimacaoLabel.setForeground(Colors.CINZALIGHTB);   
            emailLabel.setForeground(Colors.CINZALIGHTB);       
            senhaLabel.setForeground(Colors.CINZALIGHTB);
            nomeLabel.setForeground(Colors.CINZALIGHTB);
            version.setForeground(Colors.CINZALIGHTB);
            logo.setForeground(Colors.CINZAMEDB);
            btnVoltar.setBackground(Colors.VERDEDARK);
            btnVoltar.setForeground(Colors.CINZADARKB);
            btnContinuar.setBackground(Colors.VERDEDARK);
            btnContinuar.setForeground(Colors.CINZADARKB);
            btnEnviarCodigo.setBackground(Colors.VERDEDARK);
            btnEnviarCodigo.setForeground(Colors.CINZADARKB);
        } else {
            fundo.setBackground(Colors.CINZAMEDA);
            drawer.setBackground(Colors.VERDEDARK);
            nomeKartodromo.setBackground(Colors.CINZALIGHTB);
            nomeKartodromo.setForeground(Colors.CINZADARKA);
            emailKartodromo.setBackground(Colors.CINZALIGHTB);
            emailKartodromo.setForeground(Colors.CINZADARKA);
            emailConfirmacaoKartodromo.setBackground(Colors.CINZALIGHTB);
            emailConfirmacaoKartodromo.setForeground(Colors.CINZADARKA);
            codigo.setBackground(Colors.CINZALIGHTB);       
            codigo.setForeground(Colors.CINZADARKA);            
            senha.setBackground(Colors.CINZALIGHTB);         
            senha.setForeground(Colors.CINZADARKA);                  
            codigoLabel.setForeground(Colors.CINZALIGHTB);
            emailconfimacaoLabel.setForeground(Colors.CINZALIGHTB);   
            emailLabel.setForeground(Colors.CINZALIGHTB);       
            senhaLabel.setForeground(Colors.CINZALIGHTB);
            nomeLabel.setForeground(Colors.CINZALIGHTB);
            version.setForeground(Colors.CINZALIGHTB);
            logo.setForeground(Colors.CINZAMEDB);
            btnVoltar.setBackground(Colors.VERDEDARK);
            btnVoltar.setForeground(Colors.CINZADARKB);
            btnContinuar.setBackground(Colors.VERDEDARK);
            btnContinuar.setForeground(Colors.CINZADARKB);
            btnEnviarCodigo.setBackground(Colors.VERDEDARK);
            btnEnviarCodigo.setForeground(Colors.CINZADARKB);
        }
    }

    private void configs() {
        fundo.setSize(800,600);
        drawer.setBounds(0,0,800,200);

        nomeKartodromo.setBorder(BorderFactory.createEmptyBorder());
        nomeKartodromo.setBounds(60,280,300,35);
        nomeKartodromo.setHorizontalAlignment(JFormattedTextField.CENTER);
        
        nomeLabel.setText("NOME:");
        nomeLabel.setBounds(60,250,200,35);
  
        emailKartodromo.setBorder(BorderFactory.createEmptyBorder());
        emailKartodromo.setBounds(60,340,300,35);
        emailKartodromo.setHorizontalAlignment(JFormattedTextField.CENTER);

        emailLabel.setText("EMAIL:");
        emailLabel.setBounds(60,310,200,35);
                
        emailConfirmacaoKartodromo.setBorder(BorderFactory.createEmptyBorder());
        emailConfirmacaoKartodromo.setBounds(60,400,300,35);
        emailConfirmacaoKartodromo.setHorizontalAlignment(JFormattedTextField.CENTER);
                
        emailconfimacaoLabel.setText("CONFIRMAR EMAIL:");
        emailconfimacaoLabel.setBounds(60,370,200,35);

        version.setText(Info.APP_VERSION);
        version.setBounds(20,10,100,30);

        logo.setText(Info.APP_NAME);
        logo.setFont(Fonts.SANSSERIF);
        logo.setBounds(20,40,700,180);

        codigo.setBorder(BorderFactory.createEmptyBorder());
        codigo.setBounds(440,280,300,35);
        codigo.setHorizontalAlignment(JFormattedTextField.CENTER);
        
        codigoLabel.setText("CÓDIGO ENVIADO:");
        codigoLabel.setBounds(440,250,300,35);
        
        senha.setBorder(BorderFactory.createEmptyBorder());
        senha.setBounds(440,340,300,35);
        senha.setHorizontalAlignment(JFormattedTextField.CENTER);
        
        senhaLabel.setText("NOVA SENHA:");
        senhaLabel.setBounds(440,310,300,35);

        btnVoltar.setText("VOLTAR");
        btnVoltar.setBorderPainted(false);
        btnVoltar.setFocusPainted(false);
        btnVoltar.addActionListener(this);
        btnVoltar.setBounds(20,550, 100,35);

        btnContinuar.setFocusPainted(false);
        btnContinuar.setBorderPainted(false);
        btnContinuar.addActionListener(this);
        btnContinuar.setText("CONTINUAR CADASTRO");
        btnContinuar.setBounds(420,550,180,35);
        
        btnEnviarCodigo.setFocusPainted(false);
        btnEnviarCodigo.setBorderPainted(false);
        btnEnviarCodigo.addActionListener(this);
        btnEnviarCodigo.setText("ENVIAR CÓDIGO");
        btnEnviarCodigo.setBounds(620,550,160,35);
    
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnVoltar) {
            dispose();
            new LoginFrame();
        }
        if (e.getSource() == btnContinuar) {
            dispose();
            new CadastrarKartodromo_pt2();
        }
        if(e.getSource() == btnEnviarCodigo) {
            try {
                new EmailJava().EnviarEmailGmail(new StringBuilder(emailKartodromo.getText()),"Código de Envio 'KART ON ROAD'","");
            } catch (Exception err) {
                JOptionPane.showConfirmDialog(null,"Erro ao enviar email" + err.getMessage(),"Erro",JOptionPane.OK_OPTION);
            }
        }
    }
    
}
