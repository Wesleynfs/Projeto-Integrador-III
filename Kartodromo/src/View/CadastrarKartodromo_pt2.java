package View;

import Utilities.Colors;

import Utilities.Fonts;
import Utilities.Info;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class CadastrarKartodromo_pt2 extends JFrame implements ActionListener{
    private JPanel fundo;
    private JPanel drawer;
    
    private JFormattedTextField pais;
    private JFormattedTextField estado;
    private JFormattedTextField cidade;
    private JFormattedTextField rua;
    private JSpinner numero;
    
    private JLabel version;
    private JLabel logo;
    
  
    private JLabel diassemanaLabel;
    private JLabel tipokartsLabel;
    private JLabel paisLabel;
    private JLabel estadoLabel;
    private JLabel cidadeLabel;
    private JLabel ruaLabel;
    private JLabel numeroLabel;
    
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
            
    private JButton btn_Voltar;
   
    private JButton btnCadastrar;
    
    public CadastrarKartodromo_pt2() {
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
        pais = new JFormattedTextField();
        estado = new JFormattedTextField();
        cidade = new JFormattedTextField(); 
        rua = new JFormattedTextField();
      
        version = new JLabel();
        logo = new JLabel();
        paisLabel = new JLabel();
        estadoLabel = new JLabel();     
        cidadeLabel = new JLabel();
        ruaLabel = new JLabel();
        numeroLabel = new JLabel();
        diassemanaLabel = new JLabel();
        tipokartsLabel = new JLabel();
        
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
        
        btn_Voltar = new JButton();
        btnCadastrar = new JButton();
    }
    
    private void add() {

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

        add(kartindoorCheckBox);
        add(kart2motorCheckBox);
        add(kart4motorCheckBox);
        add(kartshiCheckBox);
        add(kartsemmarchaCheckBox);

        add(version);
        add(logo);
        add(btnCadastrar);
        add(btn_Voltar);

        add(drawer);
        add(fundo);

        
    }
    private void setTheme() {
        if (Info.TEMA) {
            // Se o tema for escuro, os itens ficam assim //
            
            pais.setBackground(Colors.CINZALIGHTB);
            pais.setForeground(Colors.BRANCO);   
            estado.setBackground(Colors.CINZALIGHTB);
            estado.setForeground(Colors.BRANCO);     
            cidade.setBackground(Colors.CINZALIGHTB);
            cidade.setForeground(Colors.BRANCO); 
            rua.setBackground(Colors.CINZALIGHTB);       
            rua.setForeground(Colors.BRANCO);    
            numero.getEditor().getComponent(0).setBackground(Colors.CINZALIGHTB);
            numero.getEditor().getComponent(0).setForeground(Colors.BRANCO);
            estadoLabel.setForeground(Colors.CINZALIGHTB);
            paisLabel.setForeground(Colors.CINZALIGHTB);   
            cidadeLabel.setForeground(Colors.CINZALIGHTB);       
            ruaLabel.setForeground(Colors.CINZALIGHTB);
            numeroLabel.setForeground(Colors.CINZALIGHTB);
            tipokartsLabel.setForeground(Colors.CINZALIGHTB);
            diassemanaLabel.setForeground(Colors.CINZALIGHTB);
            version.setForeground(Colors.CINZALIGHTB);
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

            btn_Voltar.setBackground(Colors.VERDEDARK);
            btn_Voltar.setForeground(Colors.CINZADARKB);
            btnCadastrar.setBackground(Colors.VERDEDARK);
            btnCadastrar.setForeground(Colors.CINZADARKB);
            fundo.setBackground(Colors.CINZAMEDB);
            drawer.setBackground(Colors.VERDEDARK);
        } else {
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
            numeroLabel.setForeground(Colors.CINZALIGHTB);            
            paisLabel.setForeground(Colors.CINZALIGHTB);
            estadoLabel.setForeground(Colors.CINZALIGHTB);   
            cidadeLabel.setForeground(Colors.CINZALIGHTB);       
            ruaLabel.setForeground(Colors.CINZALIGHTB);
            tipokartsLabel.setForeground(Colors.CINZALIGHTB);
            diassemanaLabel.setForeground(Colors.CINZALIGHTB);
            version.setForeground(Colors.CINZALIGHTB);
            logo.setForeground(Colors.CINZAMEDB);
            btn_Voltar.setBackground(Colors.VERDEDARK);
            btn_Voltar.setForeground(Colors.CINZADARKB);
            btnCadastrar.setBackground(Colors.VERDEDARK);
            btnCadastrar.setForeground(Colors.CINZADARKB);

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

            fundo.setBackground(Colors.CINZAMEDA);
            drawer.setBackground(Colors.VERDEDARK);
        }
    }
    private void configs() {

        fundo.setSize(800,600);
        drawer.setBounds(0,0,800,200);

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
        cidadeLabel.setBounds(400,310,200,35);
        
        cidade.setBorder(BorderFactory.createEmptyBorder());
        cidade.setBounds(400,340,150,35);
        cidade.setHorizontalAlignment(JFormattedTextField.CENTER);
        
        numeroLabel.setText("Número:");
        numeroLabel.setBounds(600,310,200,35);
        
        numero.setBounds(600,340,150,35);
        numero.setBorder(BorderFactory.createEmptyBorder());
        
        ruaLabel.setText("Rua:");
        ruaLabel.setBounds(400,390,200,35);
               
        rua.setBorder(BorderFactory.createEmptyBorder());
        rua.setBounds(400,420,350,35);
        rua.setHorizontalAlignment(JFormattedTextField.CENTER);
        
        version.setText(Info.APP_VERSION);
        version.setBounds(20,10,100,30);

        logo.setText(Info.APP_NAME);
        logo.setFont(Fonts.SANSSERIF);
        logo.setBounds(20,40,700,180);

        btn_Voltar.setText("VOLTAR");
        btn_Voltar.setBorderPainted(false);
        btn_Voltar.setFocusPainted(false);
        btn_Voltar.addActionListener(this);
        btn_Voltar.setBounds(20,550, 100,35);

        btnCadastrar.setFocusPainted(false);
        btnCadastrar.setBorderPainted(false);
        btnCadastrar.addActionListener(this);
        btnCadastrar.setText("CADASTRAR");
        btnCadastrar.setBounds(620,550,160,35);

    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn_Voltar) {
            if (JOptionPane.showConfirmDialog(null,"Tem certeza?" , "Confirmação",JOptionPane.YES_NO_OPTION) == 0) {
                dispose();
                new CadastrarKartodromo_pt1();
            }
        }

        if(e.getSource() == btnCadastrar) {
            //enviar codigo no email
        }
    }
    
}