package View;

import Email.EmailJava;
import Utilities.Colors;

import Utilities.Fonts;
import Utilities.Info;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Relatar_Por_Email extends JFrame implements ActionListener{
    private JPanel fundo;
    private JPanel drawer;
    
    private JFormattedTextField assunto;
  
    private JTextPane contextojTextPane1;
    
    private JLabel logo;
    
    private JLabel relatoLabel;
    private JLabel assuntoLabel;
    private JLabel contextoLabel;

    private JScrollPane contextojScrollPane;
    
    private JButton btnVoltar;
    private JButton btnEnviar;

    public Relatar_Por_Email() {
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

        logo = new JLabel();
        
        assunto = new JFormattedTextField();
        
        contextojTextPane1 = new JTextPane();
                
        relatoLabel = new JLabel();
        assuntoLabel = new JLabel();
        contextoLabel = new JLabel();
        
        contextojScrollPane = new JScrollPane();
        
        btnVoltar = new JButton();
        btnEnviar = new JButton();
        
    }
    
    private void add() {
        add(logo);
        add(assunto);
        add(contextojScrollPane);
        add(relatoLabel);
        add(assuntoLabel);
        add(contextoLabel);
        add(btnVoltar);
        add(btnEnviar);
        add(drawer);
        add(fundo);
        
    }
    private void setTheme() {
        if (LoginFrame.getConfiguracao().isTema()) {
            // Se o tema for escuro, os itens ficam assim //
            fundo.setBackground(Colors.CINZAMEDB);
            drawer.setBackground(Colors.VERDEDARK);
            assunto.setBackground(Colors.CINZALIGHTB);
            assunto.setForeground(Colors.BRANCO);
            contextojTextPane1.setBackground(Colors.CINZALIGHTB);
            contextojTextPane1.setForeground(Colors.BRANCO);           
            relatoLabel.setForeground(Colors.CINZALIGHTB);
            assuntoLabel.setForeground(Colors.CINZALIGHTB);   
            contextoLabel.setForeground(Colors.CINZALIGHTB);       
            logo.setForeground(Colors.CINZAMEDB);
            btnVoltar.setBackground(Colors.VERDEDARK);
            btnVoltar.setForeground(Colors.CINZADARKB);
            btnEnviar.setBackground(Colors.VERDEDARK);
            btnEnviar.setForeground(Colors.CINZADARKB);
        } else {
            fundo.setBackground(Colors.CINZAMEDA);
            drawer.setBackground(Colors.VERDEDARK);
            contextojTextPane1.setBackground(Colors.CINZALIGHTB);
            contextojTextPane1.setForeground(Colors.CINZADARKA);
            assunto.setBackground(Colors.CINZALIGHTB);
            assunto.setForeground(Colors.CINZADARKA);                  
            relatoLabel.setForeground(Colors.CINZALIGHTB);
            assuntoLabel.setForeground(Colors.CINZALIGHTB);   
            contextoLabel.setForeground(Colors.CINZALIGHTB);       
            logo.setForeground(Colors.CINZAMEDB);
            btnVoltar.setBackground(Colors.VERDEDARK);
            btnVoltar.setForeground(Colors.CINZADARKB);
            btnEnviar.setBackground(Colors.VERDEDARK);
            btnEnviar.setForeground(Colors.CINZADARKB);
        }
    }

    private void configs() {
        fundo.setSize(800,600);
        drawer.setBounds(0,0,800,100);

        assunto.setBorder(BorderFactory.createEmptyBorder());
        assunto.setBounds(200,250,400,35);
        assunto.setHorizontalAlignment(JFormattedTextField.CENTER);
        
        //Aqui vai o nome do piloto
        
        
        
        //
        relatoLabel.setText("Relato do NomePiloto");
        relatoLabel.setBounds(20,210,200,35);
  
        contextojTextPane1.setBorder(BorderFactory.createEmptyBorder());
        contextojTextPane1.setSize(400,200);
        
        contextojScrollPane.setBorder(BorderFactory.createEmptyBorder());
        contextojScrollPane.setBounds(200,310,400,200);
        contextojScrollPane.setViewportView(contextojTextPane1);
                
        assuntoLabel.setText("ASSUNTO DO EMAIL:");
        assuntoLabel.setBounds(60,260,200,35);
       
        contextoLabel.setText("CONTEXTO DO EMAIL:");
        contextoLabel.setBounds(60,310,200,35);

        logo.setBounds(20 , 30,600,35);
        logo.setText("RELATAR AOS DESENVOLVEDORES");
        logo.setFont(Fonts.SANSSERIFMIN);

        btnVoltar.setText("VOLTAR");
        btnVoltar.setBorderPainted(false);
        btnVoltar.setFocusPainted(false);
        btnVoltar.addActionListener(this);
        btnVoltar.setBounds(20,550, 100,35);
        
        btnEnviar.setFocusPainted(false);
        btnEnviar.setBorderPainted(false);
        btnEnviar.addActionListener(this);
        btnEnviar.setText("ENVIAR EMAIL");
        btnEnviar.setBounds(620,550,160,35);
    
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnVoltar) {
            dispose();
            new PerfilPiloto();
        }

        if(e.getSource() == btnEnviar) {
            try {
                //enviar
                


                //
                JOptionPane.showMessageDialog(null, "Enviado! Agradeçemos o feedback");
            } catch (Exception error) {
                JOptionPane.showMessageDialog(null, "Não foi possível enviar o Email");
            }
        }
    }
    
}
