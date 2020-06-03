package View;

import Bo.PilotoParticipandoCampeonatoBO;
import Model.Piloto;
import Model.PilotoParticipandoCampeonato;
import Utilities.Colors;
import Utilities.Fonts;
import Utilities.Info;
import Utilities.InformacoesPiloto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

public class Historico extends JFrame implements ActionListener {

    private JPanel fundo;
    private JPanel drawer;
    private JButton btnVoltar;
    private InformacoesPiloto informacoesPiloto;
    private JLabel logo;
    private JLabel campeonatos_participandoinfoLabel;
    private JScrollPane jScrollPaneCorridasRealizadas;
    private JTable tableTodasAsCorridasRealizadas;
    private DefaultTableModel tabelamento;
    
    private Piloto piloto;

    public Historico(Piloto piloto) {
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
        logo = new JLabel();
        campeonatos_participandoinfoLabel = new JLabel();
        informacoesPiloto = new InformacoesPiloto();
        jScrollPaneCorridasRealizadas = new JScrollPane();
        tableTodasAsCorridasRealizadas = new JTable();
    }

    private void add() {
        add(btnVoltar);
        add(logo);
        add(campeonatos_participandoinfoLabel);
        add(jScrollPaneCorridasRealizadas);
        add(informacoesPiloto);
        add(drawer);
        add(fundo);
    }

    private void setTheme() {
        if (SplashScreen.getConfiguracao().isTema()) {
            // Se o tema for escuro, os itens ficam assim //
            fundo.setBackground(Colors.CINZAMEDB);
            drawer.setBackground(Colors.VERDEDARK);
            btnVoltar.setForeground(Colors.CINZADARKB);
            btnVoltar.setBackground(Colors.VERDEDARK);
            logo.setForeground(Colors.CINZAMEDA);
            informacoesPiloto.setForeground(Colors.CINZALIGHTB);
            campeonatos_participandoinfoLabel.setForeground(Colors.CINZAMEDA);
            tableTodasAsCorridasRealizadas.setBackground(Colors.VERDELIGHT);
            tableTodasAsCorridasRealizadas.setForeground(Colors.CINZADARKB);

        } else {

            fundo.setBackground(Colors.CINZAMEDA);
            drawer.setBackground(Colors.VERDEDARK);
            informacoesPiloto.setForeground(Colors.CINZALIGHTB);
            btnVoltar.setForeground(Colors.CINZADARKB);
            btnVoltar.setBackground(Colors.VERDEDARK);
            logo.setForeground(Colors.CINZALIGHTB);
            campeonatos_participandoinfoLabel.setForeground(Colors.CINZALIGHTB);
            tableTodasAsCorridasRealizadas.setForeground(Colors.CINZADARKB);
            tableTodasAsCorridasRealizadas.setBackground(Colors.VERDEDARK);

        }
    }
    private void configs() {

        fundo.setSize(Info.MINSCREENSIZE);

        drawer.setBounds(0, 0, 800, 100);

        try {

            tableTodasAsCorridasRealizadas.setModel(new DefaultTableModel(
                    new Object[][]{

                    },
                    new String[]{
                            "Nome","Data","Posição","Pontuação","Tempo Total"
                    }
            ) {
                boolean[] canEdit = new boolean[]{
                        false, false, false, false, false
                };

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit[columnIndex];
                }

            });

            tabelamento = (DefaultTableModel) tableTodasAsCorridasRealizadas.getModel();

            for(PilotoParticipandoCampeonato pilotoparticipando : new PilotoParticipandoCampeonatoBO().ListarpilotocampeonatoFinalizados(piloto)){
                tabelamento.addRow(new Object[]{
                    pilotoparticipando.getCampeonato().getNome(),
                    pilotoparticipando.getCampeonato().getDataFinalizacao(),
                    pilotoparticipando.getPosicao(),
                    pilotoparticipando.getPontuacao(),
                    pilotoparticipando.getTempoParaTerminar()

                });
            
            }
            
            jScrollPaneCorridasRealizadas.setViewportView(tableTodasAsCorridasRealizadas);
            jScrollPaneCorridasRealizadas.setBounds(60, 220, 680, 300);

            informacoesPiloto.setBounds(10,110,200,90);
            informacoesPiloto.setPiloto(piloto);
            
            btnVoltar.setBorderPainted(false);
            btnVoltar.setFocusPainted(false);
            btnVoltar.addActionListener(this);
            btnVoltar.setBounds(60 , 550,200,35);
            btnVoltar.setText("Voltar");
            
            logo.setFont(Fonts.SANSSERIFMIN);
            logo.setBounds(20 , 30,500,35);
            logo.setText("HISTÓRICO DE PARTIDAS");

            campeonatos_participandoinfoLabel.setBounds(60 , 170,300,30);
            campeonatos_participandoinfoLabel.setText("Campeonato que você participou:");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
      
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
       
        if (e.getSource() == btnVoltar) {
            dispose();
            new VerificarCampeonatos(piloto);
        }

    }


} 
