package View;

import Bo.CampeonatoBO;
import Bo.CorridaBO;
import Bo.PilotoBO;
import Bo.PilotoParticipaCorridaBO;
import Bo.PilotoParticipandoCampeonatoBO;
import Bo.PontuacaoPosicaoBO;
import Model.Campeonato;
import Model.Corrida;
import Model.Piloto;
import Model.PilotoParticipaCorrida;
import Model.PilotoParticipandoCampeonato;
import Model.PontuacaoPosicao;
import Utilities.Colors;
import Utilities.Fonts;
import Utilities.Info;
import Utilities.InformacoesPiloto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Time;
import java.util.List;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ResultadosCampeonato extends JFrame implements ActionListener {
    
    private JPanel fundo;
    private JPanel drawer;
    private JButton btnFinalizarCorrida;
    private JLabel logo;
    private JLabel GanhadorLabel;
    private InformacoesPiloto informacoesPiloto;
    private JScrollPane jScrollPaneCampeonato;
    private JTable tabelaCampeonato;
    private JLabel campeonatosLabel;
    private JButton btnVerCorridas;
    
    private DefaultTableModel tabelamento;

    private Random aleatorio;

    private Piloto piloto;
    private Campeonato campeonato;

    public ResultadosCampeonato(Piloto piloto, Campeonato campeonato) {
        this.piloto = piloto;
        this.campeonato = campeonato;
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
        setSize(Info.MAXSCREENSIZE);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle(Info.APP_NAME);
        setResizable(false);
    }

    private void initializate() {

        aleatorio = new Random();
        
        fundo = new JPanel();
        drawer = new JPanel();
        
        informacoesPiloto = new InformacoesPiloto();
        btnFinalizarCorrida = new JButton();
        
        campeonatosLabel = new JLabel();
        logo = new JLabel();
        GanhadorLabel = new JLabel();
                
        jScrollPaneCampeonato = new JScrollPane();
        tabelaCampeonato = new JTable();
        
        btnVerCorridas = new JButton();

    }

    private void add() {
        add(btnFinalizarCorrida);
        add(informacoesPiloto);
        add(btnVerCorridas);
        add(GanhadorLabel);
        add(campeonatosLabel);
        add(logo);
        add(jScrollPaneCampeonato);
        add(drawer);
        add(fundo);
    }

    private void setTheme() {
        if (SplashScreen.getConfiguracao().isTema()) {
            // Se o tema for escuro, os itens ficam assim //
            fundo.setBackground(Colors.CINZAMEDB);
            drawer.setBackground(Colors.VERDEDARK);
   
            logo.setForeground(Colors.CINZAMEDB);
            tabelaCampeonato.setBackground(Colors.VERDELIGHT);
            tabelaCampeonato.setForeground(Colors.CINZADARKB);
            informacoesPiloto.setForeground(Colors.CINZALIGHTB);
            GanhadorLabel.setForeground(Colors.CINZAMEDA);
            campeonatosLabel.setForeground(Colors.CINZAMEDA);
            btnVerCorridas.setBackground(Colors.VERDEDARK);
            btnVerCorridas.setForeground(Colors.CINZADARKB);
            btnFinalizarCorrida.setForeground(Colors.CINZADARKB);
            btnFinalizarCorrida.setBackground(Colors.VERDEDARK);

        } else {

            fundo.setBackground(Colors.CINZAMEDA);
            drawer.setBackground(Colors.VERDEDARK);          
            logo.setForeground(Colors.CINZAMEDB);
            tabelaCampeonato.setForeground(Colors.CINZADARKB);
            tabelaCampeonato.setBackground(Colors.VERDEDARK);
            campeonatosLabel.setForeground(Colors.CINZALIGHTB);
            informacoesPiloto.setForeground(Colors.BRANCO);
            btnVerCorridas.setForeground(Colors.CINZADARKB);
            btnVerCorridas.setBackground(Colors.VERDEDARK);
            GanhadorLabel.setForeground(Colors.CINZALIGHTB);
            btnFinalizarCorrida.setForeground(Colors.CINZADARKB);
            btnFinalizarCorrida.setBackground(Colors.VERDEDARK);
         
        }
    }
    private void configs() {

        fundo.setSize(Info.MAXSCREENSIZE);

        drawer.setBounds(0, 0, 1280, 100);
        
        informacoesPiloto.setBounds(1000, 3, 200, 100);
        informacoesPiloto.setPiloto(piloto);

        try {

            jScrollPaneCampeonato.setViewportView(tabelaCampeonato);
            jScrollPaneCampeonato.setBounds(30, 150, 1200, 400);

            logo.setFont(Fonts.SANSSERIFMIN);
            logo.setBounds(20 , 30,760,35);
            logo.setText("RESULTADO DA CORRIDA - "+campeonato.getNome());

            GanhadorLabel.setBounds(180, 610, 300, 35);
            
            btnFinalizarCorrida.setBorderPainted(false);
            btnFinalizarCorrida.setFocusPainted(false);
            btnFinalizarCorrida.addActionListener(this);
            btnFinalizarCorrida.setBounds(180 , 640,200,35);
            btnFinalizarCorrida.setText("FINALIZAR CAMPEONATO"); 
            
            campeonatosLabel.setText("Selecionar resultado da corrida:");
            campeonatosLabel.setBounds(805 , 610,250,35);

            btnVerCorridas.setText("VER RESULTADOS DAS CORRIDAS"); 
            btnVerCorridas.setBounds(805, 640, 300, 35);
            btnVerCorridas.addActionListener(this);
            btnVerCorridas.setFocusPainted(false);
            btnVerCorridas.setBorderPainted(false);
            
            estiloninjaVamo_da_GG_nisso_carai();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
      
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnFinalizarCorrida) {
            dispose();
            new PerfilPiloto(piloto);
        }
        if (e.getSource() == btnVerCorridas) {
            dispose();
            new ResultadoCorrida(piloto,campeonato);
        }

    }

    public void estiloninjaVamo_da_GG_nisso_carai(){

        try {
            int posicao = 0;
            List<PontuacaoPosicao> valoresPontuacao = new PontuacaoPosicaoBO().listarPorCampeonato(campeonato); 
            List<PilotoParticipandoCampeonato> pilotos = new PilotoParticipandoCampeonatoBO().listarTodosPilotosQuePilotoParticipaNoCampeonato(campeonato);
            for(Corrida corrida : new CorridaBO().listarTodasAsCorridasMarcadas(campeonato)){
                
                for(int x =0; x < pilotos.size();x++){
                        PilotoParticipaCorrida pilotoParticipaCorrida = new PilotoParticipaCorridaBO().listarPilotoCorrida(corrida, pilotos.get(x));
                        if(pilotoParticipaCorrida.isStatus_Presenca()){
                            pilotoParticipaCorrida.setPosicaoDeLargada(x+1);
                            pilotoParticipaCorrida.setTempoParaTerminar(new Time((aleatorio.nextInt(250000)+50000)*corrida.getNumeroDeVoltas()));
                        }
                        else{
                            pilotoParticipaCorrida.setPosicaoDeLargada(0);
                            pilotoParticipaCorrida.setTempoParaTerminar(new Time(0));
                        }
                        new PilotoParticipaCorridaBO().alterar(pilotoParticipaCorrida);
                }
                posicao = 1;
                for(PilotoParticipaCorrida pilotoCorrida : new PilotoParticipaCorridaBO().listarTodosAscTimePorCorrida(corrida)){
                    if(pilotoCorrida.isStatus_Presenca()){
                        pilotoCorrida.setPosicao(posicao);
                        if(posicao -1 < 10){//o numero de valoresPontuacao só vai até dez então posicao só precisa informar até 10
                            pilotoCorrida.setPontuacao(valoresPontuacao.get(posicao-1).getPontuacao());
                        }else{
                            pilotoCorrida.setPontuacao(0);
                        }
                        new PilotoParticipaCorridaBO().alterar(pilotoCorrida);
                        posicao++;
                    }
                }
                
            }
                for(int x =0; x < pilotos.size();x++){
                    for(Corrida corridas : new CorridaBO().listarTodasAsCorridasMarcadas(campeonato)){        
                        PilotoParticipaCorrida pilotocorridas = new PilotoParticipaCorridaBO().listarPilotoCorrida(corridas, pilotos.get(x));
                        if(pilotocorridas.isStatus_Presenca()){
                            pilotos.get(x).setPontuacao(pilotos.get(x).getPontuacao()+pilotocorridas.getPontuacao());  
                            new PilotoParticipandoCampeonatoBO().alterar(pilotos.get(x));
                        }
                    }   
                    
                    
                }
                posicao = 1;
                if(campeonato.getTipoCorrida().equals(Info.CAMPEONATO_OFICIAL)){
                    for(PilotoParticipandoCampeonato pilotoscampeonato : new PilotoParticipandoCampeonatoBO().listarPilotoQueParticipaDeCampeonatoOrderPontuacao(campeonato)){

                        pilotoscampeonato.setPosicao(posicao);


                        if(pilotoscampeonato.getPosicao() == 1){//Bonus primeiro lugar 
                            GanhadorLabel.setText("GRANDE GANHADOR: "+pilotoscampeonato.getPiloto().getApelido());
                        }
                        new PilotoParticipandoCampeonatoBO().alterar(pilotoscampeonato);
                        Piloto piloto_ganhos = pilotoscampeonato.getPiloto();
                        piloto_ganhos.setPontuacao_nivel(pilotoscampeonato.getPontuacao()+piloto_ganhos.getPontuacao_nivel());
                        piloto_ganhos.setNivel(piloto_ganhos.getPontuacao_nivel()/Info.PONTUACAO_POR_LEVEL);
                        posicao++;
                        System.out.println(piloto_ganhos.toString());
                        new PilotoBO().alterar(piloto_ganhos);
                        
                    }
                }else{
                    for(PilotoParticipandoCampeonato pilotoscampeonato : new PilotoParticipandoCampeonatoBO().listarPilotoQueParticipaDeCampeonatoOrderPontuacao(campeonato)){
                        pilotoscampeonato.setPosicao(posicao);
                        if(pilotoscampeonato.getPosicao() == 1){
                                GanhadorLabel.setText("GRANDE GANHADOR: "+pilotoscampeonato.getPiloto().getApelido());
                        }
                        new PilotoParticipandoCampeonatoBO().alterar(pilotoscampeonato);
                        posicao++;
                    }
                
                }
            
                
            tabelaCampeonato.setModel(new DefaultTableModel(
                new Object[][]{

                },
                new String[]{
                        "PARTICIPANTE","POSIÇÃO","PONTUAÇÃO"
                }
            ) {
                boolean[] canEdit = new boolean[]{
                        false,false ,false
                };

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit[columnIndex];
                }

            });

            tabelamento = (DefaultTableModel) tabelaCampeonato.getModel();
            for(PilotoParticipandoCampeonato pilotosparticipamCampeonato : new PilotoParticipandoCampeonatoBO().listarPilotoQueParticipaDeCampeonatoOrderPontuacao(campeonato)){
                tabelamento.addRow(new Object[]{
                        pilotosparticipamCampeonato.getPiloto().getApelido(),
                        pilotosparticipamCampeonato.getPosicao(),
                        pilotosparticipamCampeonato.getPontuacao()
                });
            }
            campeonato.setSituacao("Finalizado");
            new CampeonatoBO().alterar(campeonato);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível Criar o resultado");
        }

    }

} 
