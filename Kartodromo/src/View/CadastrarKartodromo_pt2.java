package View;

import Utilities.Colors;

import Utilities.Fonts;
import Utilities.Info;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSpinner;

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
        setSize(800,600);
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

        add( version);
        add( logo);
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
            numero.setBackground(Colors.CINZALIGHTB);       
            numero.setForeground(Colors.BRANCO);        
            
          
            estadoLabel.setForeground(Colors.CINZALIGHTB);
            paisLabel.setForeground(Colors.CINZALIGHTB);   
            cidadeLabel.setForeground(Colors.CINZALIGHTB);       
            ruaLabel.setForeground(Colors.CINZALIGHTB);
            numeroLabel.setForeground(Colors.CINZALIGHTB);
            tipokartsLabel.setForeground(Colors.CINZALIGHTB);
            diassemanaLabel.setForeground(Colors.CINZALIGHTB);
            version.setForeground(Colors.CINZALIGHTB);
            logo.setForeground(Colors.CINZAMEDB);
            
            domingoCheckBox.setForeground(Colors.CINZALIGHTB);
            sabadoCheckBox.setForeground(Colors.CINZALIGHTB);
            segundaCheckBox.setForeground(Colors.CINZALIGHTB);
            tercaCheckBox.setForeground(Colors.CINZALIGHTB);
            quartaCheckBox.setForeground(Colors.CINZALIGHTB);
            quintaCheckBox.setForeground(Colors.CINZALIGHTB);
            sextaCheckBox.setForeground(Colors.CINZALIGHTB); 
            
            kartindoorCheckBox.setForeground(Colors.CINZALIGHTB); 
            kart2motorCheckBox.setForeground(Colors.CINZALIGHTB); 
            kart4motorCheckBox.setForeground(Colors.CINZALIGHTB); 
            kartshiCheckBox.setForeground(Colors.CINZALIGHTB); 
            kartsemmarchaCheckBox.setForeground(Colors.CINZALIGHTB); 
            
            btn_Voltar.setBackground(Colors.VERDEDARK);
            btn_Voltar.setForeground(Colors.CINZADARKB);
            
            btnCadastrar.setBackground(Colors.VERDEDARK);
            btnCadastrar.setForeground(Colors.CINZADARKB);
            
            fundo.setBackground(Colors.BRANCO);
            drawer.setBackground(Colors.VERDEDARK);
            drawer.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cadastro de Kartódromo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12), Colors.CINZAMEDB));
            
            
        } else {
            pais.setBackground(Colors.CINZALIGHTB);
            pais.setForeground(Colors.CINZADARKA);             
            estado.setBackground(Colors.CINZALIGHTB);
            estado.setForeground(Colors.CINZADARKA);     
            cidade.setBackground(Colors.CINZALIGHTB);
            cidade.setForeground(Colors.CINZADARKA);
            rua.setBackground(Colors.CINZALIGHTB);       
            rua.setForeground(Colors.CINZADARKA);  
            numero.setBackground(Colors.CINZALIGHTB);         
            numero.setForeground(Colors.CINZADARKA);              
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
            domingoCheckBox.setForeground(Colors.CINZADARKB);
            sabadoCheckBox.setForeground(Colors.CINZADARKB);
            segundaCheckBox.setForeground(Colors.CINZADARKB);
            tercaCheckBox.setForeground(Colors.CINZADARKB);
            quartaCheckBox.setForeground(Colors.CINZADARKB);
            quintaCheckBox.setForeground(Colors.CINZADARKB);
            sextaCheckBox.setForeground(Colors.CINZADARKB);
            kartindoorCheckBox.setForeground(Colors.CINZADARKB);
            kart2motorCheckBox.setForeground(Colors.CINZADARKB);
            kart4motorCheckBox.setForeground(Colors.CINZADARKB);
            kartshiCheckBox.setForeground(Colors.CINZADARKB);
            kartsemmarchaCheckBox.setForeground(Colors.CINZADARKB);
            fundo.setBackground(Colors.CINZAMEDA);
            drawer.setBackground(Colors.VERDEDARK);
            drawer.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cadastro de Kartódromo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12), Colors.CINZADARKB)); // NOI18N
            
        }
    }
    private void configs() {


        fundo.setSize(800,600);

        drawer.setBounds(0,0,800,200);

        diassemanaLabel.setText("<html>Dias que o Kartódromo não trabalha:</html>");
        diassemanaLabel.setBounds(20,230,150,35);
        
        domingoCheckBox.setText("Domingo");
        domingoCheckBox.setBounds(20,260,150,30);
        sabadoCheckBox.setText("Sabado");
        sabadoCheckBox.setBounds(20,290,150,30);
        segundaCheckBox.setText("Segunda");
        segundaCheckBox.setBounds(20,320,150,30);
        tercaCheckBox.setText("Terça");
        tercaCheckBox.setBounds(20,350,150,30);
        quartaCheckBox.setText("Quarta");
        quartaCheckBox.setBounds(20,380,150,30);
        quintaCheckBox.setText("Quinta");
        quintaCheckBox.setBounds(20,410,150,30);
        sextaCheckBox.setText("Sexta");
        sextaCheckBox.setBounds(20,440,150,30);
        
        tipokartsLabel.setText("<html>Tipos de Kart disponibilizados:</html>");
        tipokartsLabel.setBounds(230,230,150,35);
        
        kartindoorCheckBox.setText("Kart indoor");
        kartindoorCheckBox.setBounds(230,260,150,35);
                
        kart2motorCheckBox.setText("<html>Kart de Motor 2 Tempos</html>");
        kart2motorCheckBox.setBounds(230,260,150,35);
                
        kart4motorCheckBox.setText("<html>Kart de Motor 2 Tempos</html>");
        kart4motorCheckBox.setBounds(230,290,150,35);
        
        kartshiCheckBox.setText("Kart Shifter");
        kartshiCheckBox.setBounds(230,320,150,35);
                
        kartsemmarchaCheckBox.setText("Kart sem marcha");
        kartsemmarchaCheckBox.setBounds(230,350,150,35);
        
        
        
        
        
        
        
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
        
        numero.setBounds(600,340,80,40);
        
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
            System.exit(0);
        }

        if(e.getSource() == btnCadastrar) {
            //enviar codigo no email
        }
    }
    
}