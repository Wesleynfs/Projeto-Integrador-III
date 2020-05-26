package View;

import Model.Piloto;
import Utilities.Colors;

import Utilities.Fonts;
import Utilities.Info;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class EnviarAviso extends JFrame implements ActionListener {

    private JPanel fundo;
    private JPanel drawer;
    private JFormattedTextField assuntoTextField;
    private JTextPane contextojTextPane1;
    private JLabel logo;
    private JLabel relatoLabel;
    private JLabel assuntoLabel;
    private JLabel contextoLabel;
    private JScrollPane contextojScrollPane;
    private JButton btnVoltar;
    private JButton btnEnviar;

    private Piloto piloto;

    public EnviarAviso(Piloto piloto) {
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
        
        assuntoTextField = new JFormattedTextField();
        
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
        add(assuntoTextField);
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
        if (SplashScreen.getConfiguracao().isTema()) {
            // Se o tema for escuro, os itens ficam assim //
            fundo.setBackground(Colors.CINZAMEDB);
            drawer.setBackground(Colors.VERDEDARK);
            assuntoTextField.setBackground(Colors.CINZALIGHTB);
            assuntoTextField.setForeground(Colors.BRANCO);
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
            assuntoTextField.setBackground(Colors.CINZALIGHTB);
            assuntoTextField.setForeground(Colors.CINZADARKA);                  
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

        relatoLabel.setText("AVISO DO PILOTO ADM: NOME DO PILOTO");
        relatoLabel.setBounds(280,150, 300,35);
  
        contextojScrollPane.setBorder(BorderFactory.createEmptyBorder());
        contextojScrollPane.setBounds(200,280,400,240);
        contextojScrollPane.setViewportView(contextojTextPane1);
                
        assuntoLabel.setText("AVISO DA CORRIDA: NOME DA CORRIDA");
        assuntoLabel.setBounds(280,200,300,35);
       
        contextoLabel.setText("CONTEXTO DO AVISO:");
        contextoLabel.setBounds(200,250,300,35);

        logo.setBounds(20 , 30,600,35);
        logo.setText("ENVIAR AVISO AOS PILOTOS");
        logo.setFont(Fonts.SANSSERIFMIN);

        btnVoltar.setText("VOLTAR");
        btnVoltar.setBorderPainted(false);
        btnVoltar.setFocusPainted(false);
        btnVoltar.addActionListener(this);
        btnVoltar.setBounds(20,550, 100,35);
        
        btnEnviar.setFocusPainted(false);
        btnEnviar.setBorderPainted(false);
        btnEnviar.addActionListener(this);
        btnEnviar.setText("ENVIAR AVISO");
        btnEnviar.setBounds(620,550,160,35);
    
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnVoltar) {
            dispose();
            new PerfilPiloto(piloto);
        }

        if(e.getSource() == btnEnviar) {
            try {
                //enviar aviso
                


                //
                JOptionPane.showMessageDialog(null, "Aviso enviado aos outros piltos!");
            } catch (Exception error) {
                JOptionPane.showMessageDialog(null, "Não foi possível enviar o aviso");
            }
        }
    }
    
}
