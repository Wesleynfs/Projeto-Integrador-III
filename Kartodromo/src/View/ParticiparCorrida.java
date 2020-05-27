package View;

import Bo.CampeonatoBO;
import Bo.CorridaBO;
import Bo.PilotoParticipandoCampeonatoBO;
import Model.Campeonato;
import Model.Corrida;
import Model.Piloto;
import Model.PilotoParticipandoCampeonato;
import Utilities.Colors;
import Utilities.Fonts;
import Utilities.Info;
import java.awt.GridLayout;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class ParticiparCorrida extends JFrame implements ActionListener {

    private JPanel fundo;
    private JPanel drawer;
    private JButton btnParticiparCorrida;
    private JButton btnVoltar;
    private JButton btnOrdenarNome;
    private JButton btnOrdenarData;
    private JButton btnOrdenarKartodromo;
    private JButton btnOrdenarVagas;
    private JLabel logo;
    private JLabel ordenarporLabel;
    private JLabel corridaLabel;
    private JComboBox<String> CorridasjComboBox;
    private JScrollPane jScrollPaneCorridasMarcadas;
    private JTable tableTodasAsCorridasMarcadas;
    private DefaultTableModel tabelamento;
    private JPanel painel_Ordenar;

    private Piloto piloto;
    
    public ParticiparCorrida(Piloto piloto) {

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
        drawer = new JPanel();
        btnVoltar = new JButton();
        btnParticiparCorrida = new JButton();
        btnOrdenarNome = new JButton();
        btnOrdenarData = new JButton();
        btnOrdenarKartodromo = new JButton();
        btnOrdenarVagas = new JButton();
        logo = new JLabel();
        ordenarporLabel = new JLabel();
        corridaLabel = new JLabel();
        jScrollPaneCorridasMarcadas = new JScrollPane();
        tableTodasAsCorridasMarcadas = new JTable();
        CorridasjComboBox = new JComboBox<>();
        painel_Ordenar = new JPanel();
    }

    private void add() {
        add(btnVoltar);
        add(btnParticiparCorrida);
        add(logo);
        add(ordenarporLabel);
        add(corridaLabel);
        add(CorridasjComboBox);
        add(jScrollPaneCorridasMarcadas);
        add(painel_Ordenar);
        add(drawer);
        add(fundo);
    }

    private void setTheme() {
        if (SplashScreen.getConfiguracao().isTema()) {
            // Se o tema for escuro, os itens ficam assim //
            fundo.setBackground(Colors.CINZAMEDB);
            drawer.setBackground(Colors.VERDEDARK);
            logo.setForeground(Colors.CINZAMEDB);
            ordenarporLabel.setForeground(Colors.CINZAMEDA);
            corridaLabel.setForeground(Colors.CINZAMEDA);
            btnParticiparCorrida.setForeground(Colors.CINZADARKB);
            btnVoltar.setForeground(Colors.CINZADARKB);
            btnParticiparCorrida.setBackground(Colors.VERDEDARK);
            btnVoltar.setBackground(Colors.VERDEDARK);
            CorridasjComboBox.setBackground(Colors.VERDEDARK);
            CorridasjComboBox.setForeground(Colors.CINZADARKB); 
            btnOrdenarNome.setBackground(Colors.VERDEDARK);
            btnOrdenarNome.setForeground(Colors.CINZADARKB);
            btnOrdenarData.setBackground(Colors.VERDEDARK);
            btnOrdenarData.setForeground(Colors.CINZADARKB);
            btnOrdenarKartodromo.setBackground(Colors.VERDEDARK);
            btnOrdenarKartodromo.setForeground(Colors.CINZADARKB);
            btnOrdenarVagas.setBackground(Colors.VERDEDARK);
            btnOrdenarVagas.setForeground(Colors.CINZADARKB);
            tableTodasAsCorridasMarcadas.setBackground(Colors.VERDELIGHT);
            tableTodasAsCorridasMarcadas.setForeground(Colors.CINZADARKB);
        } else {
            fundo.setBackground(Colors.CINZAMEDA);
            drawer.setBackground(Colors.VERDEDARK);
            logo.setForeground(Colors.CINZAMEDB);
            ordenarporLabel.setForeground(Colors.CINZALIGHTB);
            corridaLabel.setForeground(Colors.CINZALIGHTB);
            btnVoltar.setBackground(Colors.VERDEDARK);
            btnParticiparCorrida.setBackground(Colors.VERDEDARK);
            btnVoltar.setForeground(Colors.CINZADARKB);
            btnParticiparCorrida.setForeground(Colors.CINZADARKB);
            CorridasjComboBox.setForeground(Colors.CINZADARKB);
            CorridasjComboBox.setBackground(Colors.VERDEDARK);
            btnOrdenarNome.setForeground(Colors.CINZADARKB);
            btnOrdenarNome.setBackground(Colors.VERDEDARK);
            btnOrdenarData.setForeground(Colors.CINZADARKB);
            btnOrdenarData.setBackground(Colors.VERDEDARK);
            btnOrdenarKartodromo.setForeground(Colors.CINZADARKB);
            btnOrdenarKartodromo.setBackground(Colors.VERDEDARK);
            btnOrdenarVagas.setForeground(Colors.CINZADARKB);
            btnOrdenarVagas.setBackground(Colors.VERDEDARK);
            tableTodasAsCorridasMarcadas.setForeground(Colors.CINZADARKB);
            tableTodasAsCorridasMarcadas.setBackground(Colors.VERDELIGHT);
        }
    }

    private void configs() {

        fundo.setSize(Info.MINSCREENSIZE);
        drawer.setBounds(0, 0, 800, 100);

        try {

            tableTodasAsCorridasMarcadas.setModel(new DefaultTableModel(
                    new Object[][]{

                    },
                    new String[]{
                            "ID","KARTÓDROMO","DATA","ENDEREÇO","TIPO KART","VAGAS","TIPO"
                    }
            ) {
                boolean[] canEdit = new boolean[]{
                        false, false, false, false, false, false, false
                };

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit[columnIndex];
                }

            });

            tabelamento = (DefaultTableModel) tableTodasAsCorridasMarcadas.getModel();
        
            CampeonatoBO campeonatobo = new CampeonatoBO(); 
            PilotoParticipandoCampeonatoBO pilotoparticipandocampeonatobo = new PilotoParticipandoCampeonatoBO();
            System.out.println("oojd");
            for(Campeonato campeonato : campeonatobo.listarTodos()){
                System.out.println("oojd");
                List<PilotoParticipandoCampeonato> campeonato_para_participar = pilotoparticipandocampeonatobo.Listarcampeonatosparticipaticipando(piloto, campeonato);
                System.out.println("oojd");
                if(campeonato_para_participar.isEmpty()){//verificação de se o campeonato for nulo quer dizer que o piloto não participa deste campeonato
                    System.out.println("oojd");
                    List<PilotoParticipandoCampeonato> numero_de_participantes = pilotoparticipandocampeonatobo.ListarPilotoParticipadeCameponato(campeonato);
                    if(true){ //incluir regras de negocio como piloto menor de idade e max de pessoas
                        tabelamento.addRow(new Object[]{
                                campeonato.getIdCampeonato(),
                                campeonato.getKartodromo().getNomeKartodromo(),
                                campeonato.getDataFinalizacao(),
                                //MUDAR DATA PARA PT-BR
                                "<html>"
                                        + campeonato.getKartodromo().getEstado()
                                        + ", " + campeonato.getKartodromo().getCidade()
                                        + ", " + campeonato.getKartodromo().getRua() 
                                        + ", n°" + campeonato.getKartodromo().getNumero() 
                                        + "</html>",
                                campeonato.getTipoKart(),
                                numero_de_participantes.size(),//aqui vai um calculo para descobrir o total de vagas
                                campeonato.getTipoCorrida()

                        });
                                        
                    }
                }
            }
            jScrollPaneCorridasMarcadas.setViewportView(tableTodasAsCorridasMarcadas);
            jScrollPaneCorridasMarcadas.setBounds(60, 150, 680, 220);

            CorridasjComboBox.setBorder(BorderFactory.createEmptyBorder());
            CorridasjComboBox.setBounds(250,480,300,35);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        painel_Ordenar.setLayout(new GridLayout());
        painel_Ordenar.setBounds(60, 400, 500, 40);
        painel_Ordenar.add(this.btnOrdenarNome);
        painel_Ordenar.add(this.btnOrdenarData);
        painel_Ordenar.add(this.btnOrdenarKartodromo);
        painel_Ordenar.add(this.btnOrdenarVagas);
        
        btnOrdenarNome.setText("NOME");
        btnOrdenarData.setText("DATA");
        btnOrdenarKartodromo.setText("KARTÓDROMO");
        btnOrdenarVagas.setText("VAGAS");
        
        btnVoltar.setBorderPainted(false);
        btnVoltar.setFocusPainted(false);
        btnVoltar.addActionListener(this);
        btnVoltar.setBounds(60, 550, 100, 35);
        btnVoltar.setText("Voltar");

        btnParticiparCorrida.setBorderPainted(false);
        btnParticiparCorrida.setFocusPainted(false);
        btnParticiparCorrida.addActionListener(this);
        btnParticiparCorrida.setBounds(550 , 550, 200 , 35);
        btnParticiparCorrida.setText("Participar de uma Corrida");

        logo.setBounds(20 , 30,500,35);
        logo.setText("PARTICIPAR DE CORRIDAS");
        logo.setFont(Fonts.SANSSERIFMIN);

        // Mudar para valores reais aqui //

        ordenarporLabel.setBounds(60 , 370,200,30);
        ordenarporLabel.setText("ORDENAR TABELA POR:");

        corridaLabel.setBounds(310 , 450,200,35);
        corridaLabel.setText("ESCOLHER UMA CORRIDA:");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnVoltar) {
           dispose();
           new PerfilPiloto(piloto);
        }
        if (e.getSource() == btnParticiparCorrida) {

        }
        if (e.getSource() == btnOrdenarNome) {

        }
        if (e.getSource() == btnOrdenarData) {

        }
        if (e.getSource() == btnOrdenarKartodromo) {

        }
        if (e.getSource() == btnOrdenarVagas) {

        }

    }


} 
