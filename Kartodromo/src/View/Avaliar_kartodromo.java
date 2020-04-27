package View;

import Utilities.Colors;

import Utilities.Fonts;
import Utilities.Info;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.ChangeEvent;

public class Avaliar_kartodromo extends JFrame implements ActionListener{
    
    private JPanel fundo;
    private JPanel drawer;

    private JTextPane contextojTextPane1;
    private JScrollPane contextojScrollPane;
    private JLabel logo;
    
    private JLabel nomekartodromoLabel;
    private JLabel nota;
    private JLabel comentarioLabel;
    private JLabel valordanotaLabel;
    
    private JSlider notajSlider;
    
    
    private JButton btnVoltar;
    private JButton btnEnviar;
    private JButton btnVerPerfil;

    private javax.swing.JComboBox<String> kartodromojComboBox;
    
    public Avaliar_kartodromo() {
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
   
        contextojTextPane1 = new JTextPane();
                
        nomekartodromoLabel = new JLabel();
        nota = new JLabel();
        comentarioLabel = new JLabel();
        valordanotaLabel = new JLabel();
        
        contextojScrollPane = new JScrollPane();
        
        kartodromojComboBox = new JComboBox();
        
        notajSlider = new JSlider();
        
        btnVoltar = new JButton();
        btnEnviar = new JButton();
        btnVerPerfil = new JButton();
        
    }
    
    private void add() {
        
        add(logo);
        add(contextojScrollPane);
        add(nomekartodromoLabel);
        add(nota);
        add(comentarioLabel);
        add(valordanotaLabel);
        add(notajSlider);
        add(valordanotaLabel);
        add(kartodromojComboBox);
        add(btnVerPerfil);
        add(btnVoltar);
        add(btnEnviar);
        add(drawer);
        add(fundo);
        
    }
    private void setTheme() {
        if (LoginFrame.getConfiguracao().isTema()) {
            // Se o tema for escuro, os itens ficam assim 
            fundo.setBackground(Colors.CINZAMEDB);
            drawer.setBackground(Colors.VERDEDARK);
            contextojTextPane1.setBackground(Colors.CINZALIGHTB);
            contextojTextPane1.setForeground(Colors.BRANCO);           
            nomekartodromoLabel.setForeground(Colors.CINZALIGHTB);
            nota.setForeground(Colors.CINZALIGHTB);   
            valordanotaLabel.setForeground(Colors.CINZALIGHTB);
            comentarioLabel.setForeground(Colors.CINZALIGHTB);
            logo.setForeground(Colors.CINZAMEDB);
            btnVoltar.setBackground(Colors.VERDEDARK);
            btnVoltar.setForeground(Colors.CINZADARKB);
            btnEnviar.setBackground(Colors.VERDEDARK);
            btnEnviar.setForeground(Colors.CINZADARKB);
            btnVerPerfil.setBackground(Colors.VERDEDARK);
            btnVerPerfil.setForeground(Colors.CINZADARKB);
            kartodromojComboBox.setBackground(Colors.VERDEDARK);
            kartodromojComboBox.setForeground(Colors.CINZADARKB);
        } else {
            fundo.setBackground(Colors.CINZAMEDA);
            drawer.setBackground(Colors.VERDEDARK);
            contextojTextPane1.setBackground(Colors.CINZALIGHTB);
            contextojTextPane1.setForeground(Colors.CINZADARKA);                  
            nomekartodromoLabel.setForeground(Colors.CINZALIGHTB);
            valordanotaLabel.setForeground(Colors.CINZALIGHTB);   
            comentarioLabel.setForeground(Colors.CINZALIGHTB); 
            nota.setForeground(Colors.CINZALIGHTB); 
            logo.setForeground(Colors.CINZAMEDB);
            btnVoltar.setBackground(Colors.VERDEDARK);
            btnVoltar.setForeground(Colors.CINZADARKB);
            btnEnviar.setBackground(Colors.VERDEDARK);
            btnEnviar.setForeground(Colors.CINZADARKB);
            btnVerPerfil.setBackground(Colors.VERDEDARK);
            btnVerPerfil.setForeground(Colors.CINZADARKB);
            kartodromojComboBox.setBackground(Colors.VERDEDARK);
            kartodromojComboBox.setForeground(Colors.CINZADARKB);
        }
    }

    private void configs() {
        fundo.setSize(800,600);
        drawer.setBounds(0,0,800,100);

        
  
        contextojTextPane1.setBorder(BorderFactory.createEmptyBorder());
        contextojTextPane1.setSize(400,200);
        
        contextojScrollPane.setBorder(BorderFactory.createEmptyBorder());
        contextojScrollPane.setBounds(360,150,400,200);
        contextojScrollPane.setViewportView(contextojTextPane1);
            
        nomekartodromoLabel.setText("NOME DO KARTÓDROMO:");
        nomekartodromoLabel.setBounds(60,120,200,35);
        
        valordanotaLabel.setText("MUITO BOM");
        valordanotaLabel.setBounds(100,290,200,35);
        
        comentarioLabel.setText("SEU COMENTÁRIO:");
        comentarioLabel.setBounds(360,120,200,35);
       
        nota.setText("SUA NOTA:");
        nota.setBounds(60,270,200,35);

        logo.setBounds(20 , 30,600,35);
        logo.setText("AVALIAR KARTÓDROMO");
        logo.setFont(Fonts.SANSSERIFMIN);
        
        notajSlider.setMaximum(5);
        notajSlider.setMinimum(1);
        notajSlider.setOrientation(javax.swing.JSlider.VERTICAL);
        notajSlider.setBounds(60, 300, 30, 200);
        
        kartodromojComboBox.setBorder(BorderFactory.createEmptyBorder());
        kartodromojComboBox.setBounds(60,150,200,35);

        btnVoltar.setText("VOLTAR");
        btnVoltar.setBorderPainted(false);
        btnVoltar.setFocusPainted(false);
        btnVoltar.addActionListener(this);
        btnVoltar.setBounds(20,550, 100,35);
        
        btnVerPerfil.setText("VER PERFIL DO KARTÓDROMO");
        btnVerPerfil.setBorderPainted(false);
        btnVerPerfil.setFocusPainted(false);
        btnVerPerfil.addActionListener(this);
        btnVerPerfil.setBounds(250,550, 250,35);
        
        btnEnviar.setFocusPainted(false);
        btnEnviar.setBorderPainted(false);
        btnEnviar.addActionListener(this);
        btnEnviar.setText("ENVIAR EMAIL");
        btnEnviar.setBounds(620,550,160,35);

        notajSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                notajSliderstateChanged(evt);
            }
        });
    }
    public void notajSliderstateChanged(ChangeEvent evt){
        switch (notajSlider.getValue()) {
            case 5:
                valordanotaLabel.setText("MUITO BOM");
                valordanotaLabel.setBounds(100,290,200,35);
                break;
            case 4:
                valordanotaLabel.setText("BOM");
                valordanotaLabel.setBounds(100,338,200,35);
                break;
            case 3:
                valordanotaLabel.setText("MÉDIO");
                valordanotaLabel.setBounds(100,384,200,35);
                break;
            case 2:
                valordanotaLabel.setText("RUIM");
                valordanotaLabel.setBounds(100,430,200,35);
                break;
            default:
                valordanotaLabel.setText("MUITO RUIM");
                valordanotaLabel.setBounds(100,478,200,35);
                break;
        }

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnVoltar) {
            dispose();
            new PerfilPiloto();
        }

        if(e.getSource() == btnEnviar) {
        
        }
        if(e.getSource() == btnVerPerfil) {
            try{
            
                
            } catch (Exception error) {
                JOptionPane.showMessageDialog(null, "Você não selecionou nenhum kartódromo!");
            }
        }
        
    }
    
}
