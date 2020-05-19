package View;

import Model.Piloto;
import Utilities.Colors;
import Utilities.Fonts;
import Utilities.Info;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class RelatarPorEmail extends JFrame implements ActionListener {

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
    private JLabel pilotoLabel;

    private Piloto piloto;

    public RelatarPorEmail(Piloto piloto) {

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
        pilotoLabel = new JLabel();
        
    }
    
    private void add() {
        add(pilotoLabel);
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
        if (LoginFrame.getConfiguracao().isTema()) {
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
            pilotoLabel.setForeground(Colors.CINZALIGHTB);
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
            pilotoLabel.setForeground(Colors.CINZALIGHTB);
        }
    }

    private void configs() {
        fundo.setSize(Info.MINSCREENSIZE);
        drawer.setBounds(0,0,800,100);

        assuntoTextField.setBorder(BorderFactory.createEmptyBorder());
        assuntoTextField.setBounds(200,250,400,35);
        assuntoTextField.setHorizontalAlignment(JFormattedTextField.CENTER);

        pilotoLabel.setText(piloto.getNomePiloto().toUpperCase());
        pilotoLabel.setBounds(200 , 210 , 400 , 35);

        relatoLabel.setText("NOME DO PILOTO : ");
        relatoLabel.setBounds(60,210,200,35);
  
        contextojTextPane1.setBorder(BorderFactory.createEmptyBorder());
        contextojTextPane1.setSize(400,200);
        
        contextojScrollPane.setBorder(BorderFactory.createEmptyBorder());
        contextojScrollPane.setBounds(200,310,400,200);
        contextojScrollPane.setViewportView(contextojTextPane1);
                
        assuntoLabel.setText("ASSUNTO DO EMAIL:");
        assuntoLabel.setBounds(60,250,200,35);
       
        contextoLabel.setText("CONTEXTO DO EMAIL:");
        contextoLabel.setBounds(60,300,200,35);

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
            new PerfilPiloto(piloto);
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
