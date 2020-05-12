package View;

import Utilities.Colors;

import Utilities.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.ChangeEvent;

public class AvaliarKartodromo extends JFrame implements ActionListener{
    
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
    private JLabel estrelasLabel[] = new JLabel[6];

    private JComboBox<String> kartodromojComboBox;
    
    public AvaliarKartodromo() {
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
        
        estrelasLabel[0] = new JLabel();
        estrelasLabel[1] = new JLabel();
        estrelasLabel[2] = new JLabel();
        estrelasLabel[3] = new JLabel();
        estrelasLabel[4] = new JLabel();
        estrelasLabel[5] = new JLabel();
    }
    
    private void add() {
        add(estrelasLabel[0]);
        add(estrelasLabel[1]);
        add(estrelasLabel[2]);
        add(estrelasLabel[3]);
        add(estrelasLabel[4]);
        add(estrelasLabel[5]);
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

        fundo.setSize(Info.MINSCREENSIZE);
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
       
        nota.setText("<html>Nota que você está atribuindo:</html>");
        nota.setBounds(40,245,100,60);

        estrelasLabel[0].setBounds(130,275,16,16);
        estrelasLabel[1].setBounds(146,275,16,16);
        estrelasLabel[2].setBounds(162,275,16,16);
        estrelasLabel[3].setBounds(178,275,16,16);
        estrelasLabel[4].setBounds(194,275,16,16);
        estrelasLabel[5].setBounds(210,275,16,16);
        estrelasLabel[0].setIcon(new ImageIcon(getClass().getResource("/Utilities/star.png")));
        estrelasLabel[1].setIcon(new ImageIcon(getClass().getResource("/Utilities/star.png")));
        estrelasLabel[2].setIcon(new ImageIcon(getClass().getResource("/Utilities/star.png")));
        estrelasLabel[3].setIcon(new ImageIcon(getClass().getResource("/Utilities/star.png")));
        estrelasLabel[4].setIcon(new ImageIcon(getClass().getResource("/Utilities/star.png")));
        estrelasLabel[5].setIcon(new ImageIcon(getClass().getResource("/Utilities/award_star_add.png")));
        logo.setBounds(20 , 30,600,35);
        logo.setText("AVALIAR KARTÓDROMO");
        logo.setFont(Fonts.SANSSERIFMIN);
        
        notajSlider.setMaximum(5);
        notajSlider.setMinimum(1);
        notajSlider.setOrientation(JSlider.VERTICAL);
        notajSlider.setBounds(60, 300, 30, 200);
        notajSlider.setBackground(Colors.CINZAMEDB);
        
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
        btnEnviar.setText("MANDAR AVALIAÇÃO");
        btnEnviar.setBounds(600,550,180,35);

        notajSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(ChangeEvent evt) {
                notajSliderstateChanged(evt);
            }
        });
    }

    public void notajSliderstateChanged(ChangeEvent evt) {
        switch (notajSlider.getValue()) {
            case 5:
                estrelasLabel[4].setVisible(true);
                estrelasLabel[5].setVisible(true);
                valordanotaLabel.setText("MUITO BOM");
                valordanotaLabel.setBounds(100,290,200,35);
                break;
            case 4:
                estrelasLabel[3].setVisible(true);
                estrelasLabel[4].setVisible(false);
                estrelasLabel[5].setVisible(false);
                valordanotaLabel.setText("BOM");
                valordanotaLabel.setBounds(100,338,200,35);
                break;
            case 3:
                estrelasLabel[1].setVisible(true);
                estrelasLabel[2].setVisible(true);
                estrelasLabel[3].setVisible(false);
                valordanotaLabel.setText("MÉDIO");
                valordanotaLabel.setBounds(100,384,200,35);
                break;
            case 2:
                estrelasLabel[0].setIcon(new ImageIcon(getClass().getResource("/Utilities/star.png")));
                estrelasLabel[1].setVisible(true);
                estrelasLabel[2].setVisible(false);
                valordanotaLabel.setText("RUIM");
                valordanotaLabel.setBounds(100,430,200,35);
                break;
            default:
                estrelasLabel[0].setIcon(new ImageIcon(getClass().getResource("/Utilities/award_star_delete.png")));
                estrelasLabel[1].setVisible(false);
                estrelasLabel[2].setVisible(false);
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
            try {
                //enviar
                


                //
                JOptionPane.showMessageDialog(null, "SUA AVALIAÇÃO FOI FEITA COM SUCESSO!");
            } catch (Exception error) {
                JOptionPane.showMessageDialog(null, "Não foi possível enviar sua avaliação");
            }
        }

        if(e.getSource() == btnVerPerfil) {
            try{
                dispose();
                new Perfil_Kartodromo();
                
            } catch (Exception error) {
                JOptionPane.showMessageDialog(null, "Você não selecionou nenhum kartódromo!");
            }
        }
    }
}
