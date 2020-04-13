package View;

import Utilities.Colors;

import Utilities.Fonts;
import Utilities.Info;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

public class CadastrarKartodromo_pt1 extends JFrame implements ActionListener{
    private JPanel fundo;
    private JPanel drawer;
    
    private JFormattedTextField nome_kartodromo;
    private JFormattedTextField email_kartodromo;
    private JFormattedTextField email_confirmacao_kartodromo;
    private JFormattedTextField codigo;
    private JFormattedTextField senha;
    
    private JLabel version;
    private JLabel logo;
    
    private JLabel nomeLabel;
    private JLabel emailLabel;
    private JLabel emailconfimacaoLabel;
    private JLabel codigoLabel;
    private JLabel senhaLabel;
    
    
    private JButton btn_Voltar;
    private JButton btn_enviar_codigo;
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
        nome_kartodromo = new JFormattedTextField();
        email_kartodromo = new JFormattedTextField();
        email_confirmacao_kartodromo = new JFormattedTextField(); 
        codigo = new JFormattedTextField();
        senha = new JFormattedTextField();
        version = new JLabel();
        logo = new JLabel();
        codigoLabel = new JLabel();
        emailconfimacaoLabel = new JLabel();   
        nomeLabel = new JLabel();
        emailLabel = new JLabel();     
        senhaLabel = new JLabel();
        btn_Voltar = new JButton();
        btn_enviar_codigo = new JButton();
        btnContinuar = new JButton();
    }
    
    private void add() {
        
        add(nome_kartodromo);
        add(email_kartodromo);
        add(email_confirmacao_kartodromo);
        add(codigo);
        add(senha);
        add(version);
        add(logo);
        add(codigoLabel);
        add(emailconfimacaoLabel);
        add(nomeLabel);
        add(emailLabel);
        add(senhaLabel);
        add(btn_Voltar);
        add(btn_enviar_codigo);
        add(btnContinuar);
        add(drawer);
        add(fundo);
        
    }
    private void setTheme() {
        if (Info.TEMA) {
            // Se o tema for escuro, os itens ficam assim //
            fundo.setBackground(Colors.CINZAMEDB);
            drawer.setBackground(Colors.VERDEDARK);
            nome_kartodromo.setBackground(Colors.CINZALIGHTB);
            nome_kartodromo.setForeground(Colors.BRANCO);            
            email_kartodromo.setBackground(Colors.CINZALIGHTB);
            email_kartodromo.setForeground(Colors.BRANCO);                 
            email_confirmacao_kartodromo.setBackground(Colors.CINZALIGHTB);
            email_confirmacao_kartodromo.setForeground(Colors.BRANCO);            
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
            btn_Voltar.setBackground(Colors.VERDEDARK);
            btn_Voltar.setForeground(Colors.CINZADARKB);
            btnContinuar.setBackground(Colors.VERDEDARK);
            btnContinuar.setForeground(Colors.CINZADARKB);
            btn_enviar_codigo.setBackground(Colors.VERDEDARK);
            btn_enviar_codigo.setForeground(Colors.CINZADARKB);
        } else {
            fundo.setBackground(Colors.CINZAMEDA);
            drawer.setBackground(Colors.VERDEDARK);
            nome_kartodromo.setBackground(Colors.CINZALIGHTB);
            nome_kartodromo.setForeground(Colors.CINZADARKA);            
            email_kartodromo.setBackground(Colors.CINZALIGHTB);
            email_kartodromo.setForeground(Colors.CINZADARKA);                 
            email_confirmacao_kartodromo.setBackground(Colors.CINZALIGHTB);
            email_confirmacao_kartodromo.setForeground(Colors.CINZADARKA);            
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
            btn_Voltar.setBackground(Colors.VERDEDARK);
            btn_Voltar.setForeground(Colors.CINZADARKB);
            btnContinuar.setBackground(Colors.VERDEDARK);
            btnContinuar.setForeground(Colors.CINZADARKB);
            btn_enviar_codigo.setBackground(Colors.VERDEDARK);
            btn_enviar_codigo.setForeground(Colors.CINZADARKB);
        }
    }

    private void configs() {
        fundo.setSize(800,600);
        drawer.setBounds(0,0,800,200);

        nome_kartodromo.setBorder(BorderFactory.createEmptyBorder());
        nome_kartodromo.setBounds(60,280,300,35);
        nome_kartodromo.setHorizontalAlignment(JFormattedTextField.CENTER);
        
        nomeLabel.setText("NOME:");
        nomeLabel.setBounds(60,250,200,35);
  
        email_kartodromo.setBorder(BorderFactory.createEmptyBorder());
        email_kartodromo.setBounds(60,340,300,35);
        email_kartodromo.setHorizontalAlignment(JFormattedTextField.CENTER);

        emailLabel.setText("EMAIL:");
        emailLabel.setBounds(60,310,200,35);
                
        email_confirmacao_kartodromo.setBorder(BorderFactory.createEmptyBorder());
        email_confirmacao_kartodromo.setBounds(60,400,300,35);
        email_confirmacao_kartodromo.setHorizontalAlignment(JFormattedTextField.CENTER);
                
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

        btn_Voltar.setText("VOLTAR");
        btn_Voltar.setBorderPainted(false);
        btn_Voltar.setFocusPainted(false);
        btn_Voltar.addActionListener(this);
        btn_Voltar.setBounds(20,550, 100,35);

        btnContinuar.setFocusPainted(false);
        btnContinuar.setBorderPainted(false);
        btnContinuar.addActionListener(this);
        btnContinuar.setText("CONTINUAR CADASTRO");
        btnContinuar.setBounds(420,550,180,35);
        
        btn_enviar_codigo.setFocusPainted(false);
        btn_enviar_codigo.setBorderPainted(false);
        btn_enviar_codigo.addActionListener(this);
        btn_enviar_codigo.setText("ENVIAR CÓDIGO");
        btn_enviar_codigo.setBounds(620,550,160,35);
    
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn_Voltar) {
            dispose();
            new LoginFrame();
        }
        if (e.getSource() == btnContinuar) {
            dispose();
            new CadastrarKartodromo_pt2();
        }
        if(e.getSource() == btn_enviar_codigo) {
            //enviar codigo no email
        }
    }
    
}
