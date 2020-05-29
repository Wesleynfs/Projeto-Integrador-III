package View;


import Bo.CampeonatoBO;
import Bo.CorridaBO;
import Bo.KartodromoBO;
import Bo.PilotoParticipandoCampeonatoBO;
import Bo.Pontuacao_posicaoBO;
import Model.Campeonato;
import Model.Corrida;
import Model.Kartodromo;
import Model.Piloto;
import Model.PilotoParticipandoCampeonato;
import Model.Pontuacao_posicao;
import Utilities.Colors;

import Utilities.Fonts;
import Utilities.Info;
import Utilities.Tempo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;


public class GerenciarCampeonato extends JFrame implements ActionListener {

    private JPanel fundo;
    private JPanel drawer;
    private JComboBox<String> comboTipoCampeonato;
    private JFormattedTextField textFieldNomeCampeonato;
    private JFormattedTextField textFieldDataFinalCampeonato;
    private JTable table;
    private JScrollPane scroll;
    private JLabel logo;
    private JLabel lblpontuacoes;
    private JLabel lblNomeCampeonato;
    private JLabel lblDataFinalCampeonato;
    private JLabel lblinfoPiloto;
    private JLabel tipocorridaLabel;
    private JButton btnVoltar;
    private JButton btnCriarCampeonato;
    private JButton btnAdicionarCorrida;
    private DefaultTableModel tabelamento;
    
    private List<Corrida> corridaList;

    public List<Corrida> getCorridaList() {
        return corridaList;
    }

    public void setCorridaList(List<Corrida> corridaList) {
        this.corridaList = corridaList;
    }

    private Piloto piloto;
    private Campeonato campeonato;

    public Campeonato getCampeonato() {
        return campeonato;
    }

    public void setCampeonato(Campeonato campeonato) {
        this.campeonato = campeonato;
    }

    public JButton getBtnCriarCampeonato() {
        return btnCriarCampeonato;
    }

    public void setBtnCriarCampeonato(JButton btnCriarCampeonato) {
        this.btnCriarCampeonato = btnCriarCampeonato;
    }

    public GerenciarCampeonato(Piloto piloto) {

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

    private void configurateThis() {
        setUndecorated(true);
        setSize(Info.MINSCREENSIZE);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle(Info.APP_NAME);
        setResizable(false);
    }

    private void initializate() {

        fundo = new JPanel();
        btnAdicionarCorrida = new JButton();
        drawer = new JPanel();
        table = new JTable();
        scroll = new JScrollPane();
        textFieldNomeCampeonato = new JFormattedTextField();
        textFieldDataFinalCampeonato = new JFormattedTextField();
        lblpontuacoes = new JLabel();
        logo = new JLabel();
        lblNomeCampeonato = new JLabel();
        lblinfoPiloto = new JLabel();
        lblDataFinalCampeonato = new JLabel();
        tipocorridaLabel = new JLabel();
        btnVoltar = new JButton();
        btnCriarCampeonato = new JButton();
        comboTipoCampeonato = new JComboBox<>();
        campeonato = new Campeonato();
        corridaList = new ArrayList<>();

    }

    private void add() {
        add(btnAdicionarCorrida);
        add(logo);
        add(comboTipoCampeonato);
        add(textFieldNomeCampeonato);
        add(scroll);
        add(lblpontuacoes);
        add(textFieldDataFinalCampeonato);
        add(lblNomeCampeonato);
        add(lblDataFinalCampeonato);
        add(tipocorridaLabel);
        add(lblinfoPiloto);
        add(btnVoltar);
        add(btnCriarCampeonato);
        add(drawer);
        add(fundo);
    }

    private void setTheme() {

        if (SplashScreen.getConfiguracao().isTema()) {
            // Se o tema for escuro, os itens ficam assim //
            fundo.setBackground(Colors.CINZAMEDB);
            drawer.setBackground(Colors.VERDEDARK);
            textFieldNomeCampeonato.setBackground(Colors.CINZALIGHTB);
            textFieldNomeCampeonato.setForeground(Colors.BRANCO);
            textFieldDataFinalCampeonato.setBackground(Colors.CINZALIGHTB);
            textFieldDataFinalCampeonato.setForeground(Colors.BRANCO);
            lblNomeCampeonato.setForeground(Colors.CINZALIGHTB);
            lblDataFinalCampeonato.setForeground(Colors.CINZALIGHTB);
            tipocorridaLabel.setForeground(Colors.CINZALIGHTB);
            lblpontuacoes.setForeground(Colors.CINZALIGHTB);
            logo.setForeground(Colors.CINZAMEDB);
            btnVoltar.setBackground(Colors.VERDEDARK);
            btnVoltar.setForeground(Colors.CINZADARKB);
            lblinfoPiloto.setForeground(Colors.CINZALIGHTB);
            btnAdicionarCorrida.setBackground(Colors.VERDEDARK);
            btnAdicionarCorrida.setForeground(Colors.CINZADARKB);
            btnCriarCampeonato.setBackground(Colors.VERDEDARK);
            btnCriarCampeonato.setForeground(Colors.CINZADARKB);
            comboTipoCampeonato.setForeground(Colors.BRANCO);
            comboTipoCampeonato.setBackground(Colors.CINZALIGHTB);
        } else {
            fundo.setBackground(Colors.CINZAMEDA);
            drawer.setBackground(Colors.VERDEDARK);
            textFieldNomeCampeonato.setBackground(Colors.CINZALIGHTB);
            textFieldNomeCampeonato.setForeground(Colors.CINZADARKA);
            textFieldDataFinalCampeonato.setBackground(Colors.CINZALIGHTB);
            textFieldDataFinalCampeonato.setForeground(Colors.CINZADARKA);
            lblNomeCampeonato.setForeground(Colors.CINZALIGHTB);
            lblDataFinalCampeonato.setForeground(Colors.CINZALIGHTB);
            lblpontuacoes.setForeground(Colors.CINZALIGHTB);
            tipocorridaLabel.setForeground(Colors.CINZALIGHTB);
            logo.setForeground(Colors.CINZAMEDB);
            lblinfoPiloto.setForeground(Colors.CINZALIGHTB); 
            btnVoltar.setBackground(Colors.VERDEDARK);
            btnVoltar.setForeground(Colors.CINZADARKB);
            btnAdicionarCorrida.setBackground(Colors.VERDEDARK);
            btnAdicionarCorrida.setForeground(Colors.CINZADARKB);
            btnCriarCampeonato.setBackground(Colors.VERDEDARK);
            btnCriarCampeonato.setForeground(Colors.CINZADARKB);
            comboTipoCampeonato.setBackground(Colors.CINZALIGHTB);
            comboTipoCampeonato.setForeground(Colors.CINZADARKA);
        }
    }

    private void configs() {

        fundo.setSize(Info.MINSCREENSIZE);
        drawer.setBounds(0, 0, 800, 100);

        lblNomeCampeonato.setText("NOME DO CAMPEONATO:");
        lblNomeCampeonato.setBounds(60, 185, 200, 35);

        textFieldNomeCampeonato.setBorder(BorderFactory.createEmptyBorder());
        textFieldNomeCampeonato.setBounds(60, 215, 300, 35);
        textFieldNomeCampeonato.setHorizontalAlignment(JFormattedTextField.CENTER);

        textFieldDataFinalCampeonato.setBorder(BorderFactory.createEmptyBorder());
        textFieldDataFinalCampeonato.setBounds(60, 340, 300, 35);
        textFieldDataFinalCampeonato.setHorizontalAlignment(JFormattedTextField.CENTER);

        try {
            textFieldDataFinalCampeonato.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("##/##/####")));
        } catch (Exception error) {
            JOptionPane.showMessageDialog(null, "Não foi possível carregar a tela criar campeonato");
        }

        lblDataFinalCampeonato.setText("DATA DO CAMPEONATO:");
        lblDataFinalCampeonato.setBounds(60, 310, 200, 35);

        tipocorridaLabel.setText("STATUS DO CAMPEONATO:");
        tipocorridaLabel.setBounds(60, 250, 200, 35);

        comboTipoCampeonato.setBorder(BorderFactory.createEmptyBorder());
        comboTipoCampeonato.setBounds(60, 280, 300, 35);



        comboTipoCampeonato.addItem("CAMPEONATO NORMAL (CORRIDA RÁPIDA)");
        comboTipoCampeonato.addItem("CAMPEONATO OFICIAL (VALE PONTUAÇÕES)");

        logo.setBounds(20, 30, 600, 35);
        logo.setText("GERENCIAR CAMPEONATOS");
        logo.setFont(Fonts.SANSSERIFMIN);


        btnVoltar.setText("VOLTAR");
        btnVoltar.setBorderPainted(false);
        btnVoltar.setFocusPainted(false);
        btnVoltar.addActionListener(this);
        btnVoltar.setBounds(20, 550, 100, 35);

        btnCriarCampeonato.setFocusPainted(false);
        btnCriarCampeonato.setBorderPainted(false);
        btnCriarCampeonato.addActionListener(this);
        btnCriarCampeonato.setText("CRIAR CAMPEONATO");
        btnCriarCampeonato.setBounds(570, 550, 210, 35);
        btnCriarCampeonato.setVisible(false);

        btnAdicionarCorrida.setFocusPainted(false);
        btnAdicionarCorrida.setBorderPainted(false);
        btnAdicionarCorrida.addActionListener(this);
        btnAdicionarCorrida.setText("ADICIONAR CORRIDA");
        btnAdicionarCorrida.setBounds(100, 400, 190, 35);
        
        lblinfoPiloto.setText("<html>NOME: "+piloto.getNomePiloto()+ "<br/>"
        + "APELIDO: "+piloto.getApelido()+ "<br/>"
        + "NÍVEL: "+piloto.getNivel() + "<br/>"
        +"</html>");
        lblinfoPiloto.setBounds(10,110,200,90);
        
        table.setModel(new DefaultTableModel(
                    new Object[][]{

                    },
                    new String[]{
                            "Posição", "VALOR"
                    }
            ) {
                boolean[] canEdit = new boolean[]{
                        false, true
                };

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit[columnIndex];
                }

            });

            tabelamento = (DefaultTableModel) table.getModel();
            for(int posicao = 1; posicao <= 10; posicao++){
                tabelamento.addRow(new Object[]{
                        posicao,
                        11 - posicao//por padrão uma pontuação que o piloto pode mudar
                });
            }
            
            scroll.setViewportView(table);
            scroll.setBounds(400, 220, 230, 180);
            
            lblpontuacoes.setText("<html>Informe as Pontuações das 10 primeiras posições:</html>");
            lblpontuacoes.setBounds(400, 160, 240, 60);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnVoltar) {
            dispose();
            new PerfilPiloto(piloto);
        }

        if (e.getSource() == btnCriarCampeonato) {

            switch (JOptionPane.showConfirmDialog(null,
                    "Criar uma Corrida lhe torna automaticamente um ADM desta corrida,"
                            + " você tem certeza que deseja assumir essa responsabilidade?",
                    "Termo de responsabilidade",
                    JOptionPane.YES_NO_OPTION)) {
                case 0:
                    try {
                        int verificar_consistencia = 0;
                        for (int i = 0 ; tabelamento.getRowCount() > i; i++ ) {
                            if(Integer.valueOf(tabelamento.getValueAt(i, 1).toString()) > 100){
                                JOptionPane.showMessageDialog(null,
                                "<html>Sua pontuação está muito elevada!<br/>Use pontuações menores que 100!</html>",
                                "Erro", JOptionPane.PLAIN_MESSAGE);
                            }
                            if(i == 0 ){
                                verificar_consistencia = Integer.valueOf(tabelamento.getValueAt(i, 1).toString());
                                continue;
                            }
                            if(verificar_consistencia < Integer.valueOf(tabelamento.getValueAt(i, 1).toString())){
                                JOptionPane.showMessageDialog(null,
                                "<html>Sua pontuação está incoerente!<br/>Coloque em ordem do maior para menor</html>",
                                "Erro", JOptionPane.PLAIN_MESSAGE);
                                return;
                            }
                            verificar_consistencia = Integer.valueOf(tabelamento.getValueAt(i, 1).toString());
                        }

                    } catch (Exception err) {
                        JOptionPane.showMessageDialog(null,
                                "<html>Sua pontuação está com informações inválidas!<br/>Coloque apenas números inteiros</html>",
                                "Erro", JOptionPane.PLAIN_MESSAGE);
                        return;
                    }

                    campeonato.setDataFinalizacao(Tempo.stringToDate(textFieldDataFinalCampeonato.getText()));
                    campeonato.setNome(textFieldNomeCampeonato.getText());
                    campeonato.setSituacao("Aguardando Participantes");
                    campeonato.setTipoCorrida(comboTipoCampeonato.getSelectedItem().toString());
                    campeonato.setDataCadastro(Tempo.getCurrentTime());
                    
                    PilotoParticipandoCampeonato pilotoadm = new PilotoParticipandoCampeonato();

                    pilotoadm.setPiloto(piloto);
                    pilotoadm.setStatusAdm(true);
                    pilotoadm.setCampeonato(campeonato);
                    pilotoadm.setPontuacao(0);
                    pilotoadm.setPosicao(0);
 
                    try {

                        new CampeonatoBO().criar(campeonato);
                        
                        try {

                        Pontuacao_posicaoBO pontuacao_posicaobo = new Pontuacao_posicaoBO(); 
                        for (int i = 0 ; tabelamento.getRowCount() > i; i++ ) {
                                Pontuacao_posicao pontuacao_posicao = new Pontuacao_posicao();     
                                pontuacao_posicao.setPontuacao(Integer.valueOf(tabelamento.getValueAt(i, 1).toString()));
                                pontuacao_posicao.setPosicao(Integer.valueOf(tabelamento.getValueAt(i, 0).toString()));
                                pontuacao_posicao.setCampeonato(campeonato);
                                System.out.println(pontuacao_posicao.getPontuacao()+" / "+ pontuacao_posicao.getPosicao());
                                pontuacao_posicaobo.criar(pontuacao_posicao);
                        }

                        } catch (Exception err) {
                            JOptionPane.showMessageDialog(null,
                                    err,"Erro", JOptionPane.PLAIN_MESSAGE);
                        }

                        CorridaBO corridabo = new CorridaBO();
                        for (Corrida corrida : getCorridaList()) {
                            corrida.setCampeonato(campeonato);
                            corridabo.criar(corrida);
                        }

                        new PilotoParticipandoCampeonatoBO().criar(pilotoadm);

                    } catch (Exception err) {
                        JOptionPane.showMessageDialog(null,
                                err.getMessage(),
                                "Erro", JOptionPane.PLAIN_MESSAGE);
                    }

                    dispose();
                    new PerfilPiloto(piloto);

                    break;
                    
                default: JOptionPane.showMessageDialog(null, "Ação cancelada! retornando ao menu principal!");
            }

        }

        if (e.getSource() == btnAdicionarCorrida) {

            campeonato.setNome(textFieldNomeCampeonato.getText());
            campeonato.setDataFinalizacao(Tempo.stringToDate(textFieldDataFinalCampeonato.getText()));

            this.setVisible(false);
            new CriarCorrida(piloto, campeonato, this);
        }

    }

}
