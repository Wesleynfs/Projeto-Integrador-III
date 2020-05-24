package View;


import Bo.CampeonatoBO;
import Model.Campeonato;
import Model.Corrida;
import Model.Piloto;
import Utilities.Colors;

import Utilities.Fonts;
import Utilities.Info;
import Utilities.Tempo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;
import javax.swing.*;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

public class CriarCampeonato extends JFrame implements ActionListener {

    private JPanel fundo;
    private JPanel drawer;
    private JComboBox<Object> comboNomeKartodromo;
    private JComboBox<String> comboTipoDeKart;
    private JComboBox<String> comboStatusCampeonato;
    private JFormattedTextField textFieldNomeCampeonato;
    private JFormattedTextField textFieldDataFinalCampeonato;
    private JFormattedTextField textFieldDataInicioCampeonato;
    private JLabel logo;
    private JLabel lblNomeCampeonato;
    private JLabel lblDataFinalCampeonato;
    private JLabel tipocorridaLabel;
    private JLabel nomekartodromoLabel;
    private JLabel tipokartLabel;
    private JLabel lblNumeroDeVoltas;
    private JLabel lblDataInicioCampeonato;
    private JButton btnVoltar;
    private JButton btnCriarCampeonato;
    private JButton btnAdicionarCorrida;

    private Piloto piloto;
    private Campeonato campeonato;
    
    public CriarCampeonato() {

        this.piloto = null;

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

    public CriarCampeonato(Piloto piloto , List<Corrida> corridaList) {

        this.piloto = piloto;

        corridaList.forEach((C) -> campeonato.setCorrida(C));

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
        btnAdicionarCorrida = new JButton();
        drawer = new JPanel();
        textFieldNomeCampeonato = new JFormattedTextField();
        textFieldDataFinalCampeonato = new JFormattedTextField();
        logo = new JLabel();
        lblNomeCampeonato = new JLabel();
        lblDataFinalCampeonato = new JLabel();
        tipocorridaLabel = new JLabel();
        nomekartodromoLabel = new JLabel();     
        tipokartLabel = new JLabel();
        lblNumeroDeVoltas = new JLabel();
        btnVoltar = new JButton();
        btnCriarCampeonato = new JButton();
        comboNomeKartodromo = new JComboBox<>();
        comboTipoDeKart = new JComboBox<>();
        comboStatusCampeonato = new JComboBox<>();
        lblDataInicioCampeonato = new JLabel();
        textFieldDataInicioCampeonato = new JFormattedTextField();
        campeonato = new Campeonato();
        
    }
    
    private void add() {
        add(btnAdicionarCorrida);
        add(comboNomeKartodromo);
        add(logo);
        add(comboTipoDeKart);
        add(comboStatusCampeonato);
        add(textFieldNomeCampeonato);
        add(textFieldDataFinalCampeonato);
        add(textFieldDataInicioCampeonato);
        add(lblNomeCampeonato);
        add(lblDataFinalCampeonato);
        add(lblDataInicioCampeonato);
        add(tipocorridaLabel);
        add(nomekartodromoLabel);
        add(tipokartLabel);
        add(lblNumeroDeVoltas);
        add(btnVoltar);
        add(btnCriarCampeonato);
        add(drawer);
        add(fundo);
    }

    private void setTheme() {
        //LoginFrame.getConfiguracao().isTema()
        if (true) {
            // Se o tema for escuro, os itens ficam assim //
            fundo.setBackground(Colors.CINZAMEDB);
            drawer.setBackground(Colors.VERDEDARK);
            textFieldNomeCampeonato.setBackground(Colors.CINZALIGHTB);
            textFieldNomeCampeonato.setForeground(Colors.BRANCO);
            textFieldDataFinalCampeonato.setBackground(Colors.CINZALIGHTB);
            textFieldDataFinalCampeonato.setForeground(Colors.BRANCO);
            textFieldDataInicioCampeonato.setBackground(Colors.CINZALIGHTB);
            textFieldDataInicioCampeonato.setForeground(Colors.BRANCO);
            lblNomeCampeonato.setForeground(Colors.CINZALIGHTB);
            lblDataFinalCampeonato.setForeground(Colors.CINZALIGHTB);
            lblDataInicioCampeonato.setForeground(Colors.CINZALIGHTB);
            tipocorridaLabel.setForeground(Colors.CINZALIGHTB);       
            nomekartodromoLabel.setForeground(Colors.CINZALIGHTB);
            tipokartLabel.setForeground(Colors.CINZALIGHTB);
            lblNumeroDeVoltas.setForeground(Colors.CINZALIGHTB);
            logo.setForeground(Colors.CINZAMEDB);
            btnVoltar.setBackground(Colors.VERDEDARK);
            btnVoltar.setForeground(Colors.CINZADARKB);
            btnAdicionarCorrida.setBackground(Colors.VERDEDARK);
            btnAdicionarCorrida.setForeground(Colors.CINZADARKB);
            btnCriarCampeonato.setBackground(Colors.VERDEDARK);
            btnCriarCampeonato.setForeground(Colors.CINZADARKB);
            comboStatusCampeonato.setBackground(Colors.CINZALIGHTB);
            comboStatusCampeonato.setForeground(Colors.BRANCO);
            comboNomeKartodromo.setBackground(Colors.CINZALIGHTB);
            comboNomeKartodromo.setForeground(Colors.BRANCO);
            comboTipoDeKart.setBackground(Colors.CINZALIGHTB);
            comboTipoDeKart.setForeground(Colors.BRANCO);
        } else {
            fundo.setBackground(Colors.CINZAMEDA);
            drawer.setBackground(Colors.VERDEDARK);
            textFieldNomeCampeonato.setBackground(Colors.CINZALIGHTB);
            textFieldNomeCampeonato.setForeground(Colors.CINZADARKA);
            textFieldDataFinalCampeonato.setBackground(Colors.CINZALIGHTB);
            textFieldDataFinalCampeonato.setForeground(Colors.CINZADARKA);
            textFieldDataInicioCampeonato.setBackground(Colors.CINZALIGHTB);
            textFieldDataInicioCampeonato.setForeground(Colors.CINZADARKA);
            lblNomeCampeonato.setForeground(Colors.CINZALIGHTB);
            lblDataFinalCampeonato.setForeground(Colors.CINZALIGHTB);
            lblDataInicioCampeonato.setForeground(Colors.CINZALIGHTB);
            tipocorridaLabel.setForeground(Colors.CINZALIGHTB);       
            nomekartodromoLabel.setForeground(Colors.CINZALIGHTB);
            tipokartLabel.setForeground(Colors.CINZALIGHTB);
            lblNumeroDeVoltas.setForeground(Colors.CINZALIGHTB);
            logo.setForeground(Colors.CINZAMEDB);
            btnVoltar.setBackground(Colors.VERDEDARK);
            btnVoltar.setForeground(Colors.CINZADARKB);
            btnAdicionarCorrida.setBackground(Colors.VERDEDARK);
            btnAdicionarCorrida.setForeground(Colors.CINZADARKB);
            btnCriarCampeonato.setBackground(Colors.VERDEDARK);
            btnCriarCampeonato.setForeground(Colors.CINZADARKB);
            comboStatusCampeonato.setBackground(Colors.CINZALIGHTB);
            comboStatusCampeonato.setForeground(Colors.CINZADARKA);
            comboNomeKartodromo.setBackground(Colors.CINZALIGHTB);
            comboNomeKartodromo.setForeground(Colors.CINZADARKA);
            comboTipoDeKart.setBackground(Colors.CINZALIGHTB);
            comboTipoDeKart.setForeground(Colors.CINZADARKA);
        }
    }

    private void configs() {

        fundo.setSize(Info.MINSCREENSIZE);
        drawer.setBounds(0,0,800,100);

        lblNomeCampeonato.setText("NOME DO CAMPEONATO:");
        lblNomeCampeonato.setBounds(60,185,200,35);

        textFieldNomeCampeonato.setBorder(BorderFactory.createEmptyBorder());
        textFieldNomeCampeonato.setBounds(60,215,300,35);
        textFieldNomeCampeonato.setHorizontalAlignment(JFormattedTextField.CENTER);

        textFieldDataInicioCampeonato.setBorder(BorderFactory.createEmptyBorder());
        textFieldDataInicioCampeonato.setBounds(60,280,300,35);
        textFieldDataInicioCampeonato.setHorizontalAlignment(JFormattedTextField.CENTER);
  
        textFieldDataFinalCampeonato.setBorder(BorderFactory.createEmptyBorder());
        textFieldDataFinalCampeonato.setBounds(60,340,300,35);
        textFieldDataFinalCampeonato.setHorizontalAlignment(JFormattedTextField.CENTER);
                
        try {
            textFieldDataInicioCampeonato.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("##/##/####")));
            textFieldDataFinalCampeonato.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("##/##/####")));
        } catch (Exception error) {
            JOptionPane.showMessageDialog(null, "Não carregar a tela criar campeonato");
        }

        lblDataFinalCampeonato.setText("DATA DE FIM DO CAMPEONATO:");
        lblDataFinalCampeonato.setBounds(60,310,200,35);

        lblDataInicioCampeonato.setText("DATA DE INICIO DO CAMPEONATO:");
        lblDataInicioCampeonato.setBounds(60,250,200,35);
                
        comboStatusCampeonato.setBorder(BorderFactory.createEmptyBorder());
        comboStatusCampeonato.setBounds(440,400,300,35);
        comboStatusCampeonato.setModel(new DefaultComboBoxModel<>(new String[] { "ATIVO","CANCELADO" }));

        tipocorridaLabel.setText("STATUS DO CAMPEONATO:");
        tipocorridaLabel.setBounds(440,370,200,35);

        logo.setBounds(20 , 30,600,35);
        logo.setText("GERENCIAR CAMPEONATOS");
        logo.setFont(Fonts.SANSSERIFMIN);

        comboTipoDeKart.setBorder(BorderFactory.createEmptyBorder());
        comboTipoDeKart.setBounds(440,340,300,35);

        /*

        if (campeonato.getKartodromo().isKartIndoor()) {
            comboTipoDeKart.addItem("INDOOR");
        }

        if (campeonato.getKartodromo().isKartMotor2Tempos()) {
            comboTipoDeKart.addItem("2 TEMPOS");
        }

        if (campeonato.getKartodromo().isKartMotor4Tempos()) {
            comboTipoDeKart.addItem("4 TEMPOS");
        }

        if (campeonato.getKartodromo().isKartSemMarcha()) {
            comboTipoDeKart.addItem("SEM MARCHA");
        }

        if (campeonato.getKartodromo().isKartShifter()) {
            comboTipoDeKart.addItem("SHIFTER");
        }

        */
        
        nomekartodromoLabel.setText("O KARTÓDROMO:");
        nomekartodromoLabel.setBounds(440,250,300,35);
        
        comboNomeKartodromo.setBorder(BorderFactory.createEmptyBorder());
        comboNomeKartodromo.setBounds(440,280,300,35);

//        ClasseDao dao = new ClasseDao();
//        for(classe c:dao.FindALL()){
//            NomeKartodromojComboBox.addItem(c);
//        }
        //se selecionar um kartodromo em especifico ele

        comboNomeKartodromo.addItemListener(new ItemListener(){

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
        
        btnCriarCampeonato.setFocusPainted(false);
        btnCriarCampeonato.setBorderPainted(false);
        btnCriarCampeonato.addActionListener(this);
        btnCriarCampeonato.setText("CRIAR CAMPEONATO");
        btnCriarCampeonato.setBounds(620,550,160,35);

        if (campeonato.getCorrida() != null) {
            btnCriarCampeonato.setEnabled(true);
        } else {
            btnCriarCampeonato.setEnabled(false);
        }

        btnAdicionarCorrida.setFocusPainted(false);
        btnAdicionarCorrida.setBorderPainted(false);
        btnAdicionarCorrida.addActionListener(this);
        btnAdicionarCorrida.setText("ADICIONAR CORRIDA");
        btnAdicionarCorrida.setBounds(130,400,160,35);
    
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnVoltar) {
            dispose();
            new PerfilPiloto(piloto);
        }

        if (e.getSource() == btnCriarCampeonato) {

            // VALIDAR CAMPEONATO //

            try {
                new CampeonatoBO().criar(campeonato);
            } catch (Exception err) {
                JOptionPane.showMessageDialog(null,
                        err.getMessage(),
                        "Erro",JOptionPane.PLAIN_MESSAGE);
            }

            /*
            switch (JOptionPane.showConfirmDialog(null,
                "Criar uma Corrida lhe torna automaticamente um ADM desta corrida,"
                        + " você tem certeza que deseja assumir essa responsabilidade?",//contexto
                        "Termo de responsabilidade",//nome
                JOptionPane.YES_NO_OPTION)) {
                case 0 : System.out.println("SIM");
                    break;
                default: System.out.println("APERTAR NO X OU CLICAR EM NÃO DA NA MESMA kk");
            }
            */
        }

        if (e.getSource() == btnAdicionarCorrida) {

            campeonato.setNome(textFieldNomeCampeonato.getText());
            campeonato.setKartodromo(campeonato.getKartodromo());
            campeonato.setDataInicio(Tempo.stringToDate(textFieldDataInicioCampeonato.getText()));
            campeonato.setDataFinalizacao(Tempo.stringToDate(textFieldDataFinalCampeonato.getText()));
            campeonato.setDataCadastro(Tempo.getCurrentTime());

            dispose();
            new CriarCorrida(piloto , this);
        }

    }
}
