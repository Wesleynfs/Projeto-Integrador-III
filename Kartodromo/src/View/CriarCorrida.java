package View;

import Email.EmailJava;
import Model.Kartodromo;
import Utilities.Colors;

import Utilities.Fonts;
import Utilities.Info;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

public class CriarCorrida extends JFrame implements ActionListener{
    private JPanel fundo;
    private JPanel drawer;
    
    private JComboBox<Object> NomeKartodromojComboBox;
    private JComboBox<String> TipoKartjComboBox;
    private JComboBox<String> TipoCorridajComboBox;
    
    private JFormattedTextField nomeCorrida;
    private JFormattedTextField dataCorrida;

    private JLabel logo;
    
    private JLabel nomecorridaLabel;
    private JLabel dataLabel;
    private JLabel tipocorridaLabel;
    private JLabel nomekartodromoLabel;
    private JLabel tipokartLabel;
    
    
    private JButton btnVoltar;

    private JButton btnCriarCorrida;
    
    public CriarCorrida() {
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
        nomeCorrida = new JFormattedTextField();
        dataCorrida = new JFormattedTextField();
        logo = new JLabel();
        nomecorridaLabel = new JLabel();
        dataLabel = new JLabel();   
        tipocorridaLabel = new JLabel();
        nomekartodromoLabel = new JLabel();     
        tipokartLabel = new JLabel();
        btnVoltar = new JButton();
        btnCriarCorrida = new JButton();
        NomeKartodromojComboBox = new JComboBox<>();
        TipoKartjComboBox = new JComboBox<>();
        TipoCorridajComboBox = new JComboBox<>();
        
    }
    
    private void add() {
        add(NomeKartodromojComboBox);
        add(logo);
        add(TipoKartjComboBox);
        add(TipoCorridajComboBox);
        add(nomeCorrida);
        add(dataCorrida);
        add(nomecorridaLabel);
        add(dataLabel);
        add(tipocorridaLabel);
        add(nomekartodromoLabel);
        add(tipokartLabel);
        add(btnVoltar);
        add(btnCriarCorrida);
        add(drawer);
        add(fundo);
        
    }
    private void setTheme() {
        if (LoginFrame.getConfiguracao().isTema()) {
            // Se o tema for escuro, os itens ficam assim //
            fundo.setBackground(Colors.CINZAMEDB);
            drawer.setBackground(Colors.VERDEDARK);
            nomeCorrida.setBackground(Colors.CINZALIGHTB);
            nomeCorrida.setForeground(Colors.BRANCO);
            dataCorrida.setBackground(Colors.CINZALIGHTB);
            dataCorrida.setForeground(Colors.BRANCO);         
            nomecorridaLabel.setForeground(Colors.CINZALIGHTB);
            dataLabel.setForeground(Colors.CINZALIGHTB);   
            tipocorridaLabel.setForeground(Colors.CINZALIGHTB);       
            nomekartodromoLabel.setForeground(Colors.CINZALIGHTB);
            tipokartLabel.setForeground(Colors.CINZALIGHTB);
            logo.setForeground(Colors.CINZAMEDB);
            btnVoltar.setBackground(Colors.VERDEDARK);
            btnVoltar.setForeground(Colors.CINZADARKB);
            btnCriarCorrida.setBackground(Colors.VERDEDARK);
            btnCriarCorrida.setForeground(Colors.CINZADARKB);
            TipoCorridajComboBox.setBackground(Colors.CINZALIGHTB);
            TipoCorridajComboBox.setForeground(Colors.BRANCO);
            NomeKartodromojComboBox.setBackground(Colors.CINZALIGHTB);
            NomeKartodromojComboBox.setForeground(Colors.BRANCO);
            TipoKartjComboBox.setBackground(Colors.CINZALIGHTB);
            TipoKartjComboBox.setForeground(Colors.BRANCO);
        } else {
            fundo.setBackground(Colors.CINZAMEDA);
            drawer.setBackground(Colors.VERDEDARK);
            nomeCorrida.setBackground(Colors.CINZALIGHTB);
            nomeCorrida.setForeground(Colors.CINZADARKA);
            dataCorrida.setBackground(Colors.CINZALIGHTB);
            dataCorrida.setForeground(Colors.CINZADARKA);               
            nomecorridaLabel.setForeground(Colors.CINZALIGHTB);
            dataLabel.setForeground(Colors.CINZALIGHTB);   
            tipocorridaLabel.setForeground(Colors.CINZALIGHTB);       
            nomekartodromoLabel.setForeground(Colors.CINZALIGHTB);
            tipokartLabel.setForeground(Colors.CINZALIGHTB);
            logo.setForeground(Colors.CINZAMEDB);
            btnVoltar.setBackground(Colors.VERDEDARK);
            btnVoltar.setForeground(Colors.CINZADARKB);
            btnCriarCorrida.setBackground(Colors.VERDEDARK);
            btnCriarCorrida.setForeground(Colors.CINZADARKB);
            TipoCorridajComboBox.setBackground(Colors.CINZALIGHTB);
            TipoCorridajComboBox.setForeground(Colors.CINZADARKA);
            NomeKartodromojComboBox.setBackground(Colors.CINZALIGHTB);
            NomeKartodromojComboBox.setForeground(Colors.CINZADARKA);
            TipoKartjComboBox.setBackground(Colors.CINZALIGHTB);
            TipoKartjComboBox.setForeground(Colors.CINZADARKA);
        }
    }

    private void configs() {

        fundo.setSize(Info.MINSCREENSIZE);
        drawer.setBounds(0,0,800,100);

        nomeCorrida.setBorder(BorderFactory.createEmptyBorder());
        nomeCorrida.setBounds(60,280,300,35);
        nomeCorrida.setHorizontalAlignment(JFormattedTextField.CENTER);

        //aqui vai o nome do piloto
        nomeCorrida.setText("Corrida do(a) NOMEPILOTO");
        //
        
        nomecorridaLabel.setText("NOME DA CORRIDA:");
        nomecorridaLabel.setBounds(60,250,200,35);
  
        dataCorrida.setBorder(BorderFactory.createEmptyBorder());
        dataCorrida.setBounds(60,340,300,35);
        dataCorrida.setHorizontalAlignment(JFormattedTextField.CENTER);

        try {
            dataCorrida.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("##/##/####")));
        } catch (Exception error) {
            JOptionPane.showMessageDialog(null, "Não carregar a tela criar corrida");
        }

        dataLabel.setText("DATA DA CORRIDA:");
        dataLabel.setBounds(60,310,200,35);
                
        TipoCorridajComboBox.setBorder(BorderFactory.createEmptyBorder());
        TipoCorridajComboBox.setBounds(440,400,300,35);
        TipoCorridajComboBox.setModel(new DefaultComboBoxModel<>(new String[] { "CAMPEONATO","CORRIDA NORMAL" }));
                
        tipocorridaLabel.setText("TIPO DE CORRIDA:");
        tipocorridaLabel.setBounds(440,370,200,35);

        logo.setBounds(20 , 30,600,35);
        logo.setText("CRIAR CORRIDA");
        logo.setFont(Fonts.SANSSERIFMIN);

        TipoKartjComboBox.setBorder(BorderFactory.createEmptyBorder());
        TipoKartjComboBox.setBounds(440,340,300,35);
        
        nomekartodromoLabel.setText("O KARTÓDROMO:");
        nomekartodromoLabel.setBounds(440,250,300,35);
        
        NomeKartodromojComboBox.setBorder(BorderFactory.createEmptyBorder());
        NomeKartodromojComboBox.setBounds(440,280,300,35);
//        ClasseDao dao = new ClasseDao();
//        for(classe c:dao.FindALL()){
//            NomeKartodromojComboBox.addItem(c);
//        }
        //se selecionar um kartodromo em especifico ele
        NomeKartodromojComboBox.addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent e) {

                if (e.getStateChange() == ItemEvent.SELECTED) {
//                    Kartodromo kartodromo = new Kartodromo();
//                    kartodromo = (Kartodromo) e.getItem();
//                    if(kartodromo.tipokartsemmarcha == true){
//                        TipoKartjComboBox.addItem("KART SEM MARCHA");
//                    }
//                    if(se o kartodromo tem esse kart){
//                      a combo coloco o tipo do kart como escolha
//                    }
//                    if(){
//                    
//                    }  
//                    if(){
//                    
//                    }
                }
            }
       });

        tipokartLabel.setText("TIPO DE KART:");
        tipokartLabel.setBounds(440,310,300,35);

        btnVoltar.setText("VOLTAR");
        btnVoltar.setBorderPainted(false);
        btnVoltar.setFocusPainted(false);
        btnVoltar.addActionListener(this);
        btnVoltar.setBounds(20,550, 100,35);
        
        btnCriarCorrida.setFocusPainted(false);
        btnCriarCorrida.setBorderPainted(false);
        btnCriarCorrida.addActionListener(this);
        btnCriarCorrida.setText("CRIAR CORRIDA");
        btnCriarCorrida.setBounds(620,550,160,35);
    
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnVoltar) {
            dispose();
            new PerfilPiloto();
        }
        if (e.getSource() == btnCriarCorrida) {
            switch (JOptionPane.showConfirmDialog(null,
                "Criar uma Corrida lhe torna automaticamente um ADM desta corrida,"
                        + " você tem certeza que deseja assumir essa responsabilidade?",//contexto
                        "Termo de responsabilidade",//nome
                JOptionPane.YES_NO_OPTION)) {
                case 0 :
                    System.out.println("SIM");
                    break;
                case 1:
                    System.out.println("NÃO");
                    break;
                default:
                    System.out.println("APERTAR NO X");
            }
        }
    }
    
}
