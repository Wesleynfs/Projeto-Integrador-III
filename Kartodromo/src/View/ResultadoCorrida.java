
package View;

import Bo.CampeonatoBO;
import Bo.CorridaBO;
import Bo.PilotoParticipaCorridaBO;
import Bo.PilotoParticipandoCampeonatoBO;
import Bo.PontuacaoPosicaoBO;
import Model.*;
import Utilities.Colors;
import Utilities.Fonts;
import Utilities.Info;
import java.sql.Time;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;


public class ResultadoCorrida extends JFrame implements ActionListener {
    
    private JPanel fundo;
    private JPanel drawer;
    private JButton btnFinalizarCorrida;
    private JLabel logo;
    private JLabel ReultadodacorridaLabel;
    private JLabel GanhadorLabel;
    private JScrollPane jScrollPaneCampeonato;
    private JTable tabelaCampeonato;
    private JScrollPane jScrollPaneCorrida;
    private JTable tabelaCorrida;
    
    private DefaultTableModel tabelamento;
    
    private Date data;
    private Random aleatorio;

    private Piloto piloto;
    private Campeonato campeonato;

    public ResultadoCorrida(Piloto piloto, Campeonato campeonato) {
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

        btnFinalizarCorrida = new JButton();

        logo = new JLabel();
        ReultadodacorridaLabel = new JLabel();
        GanhadorLabel = new JLabel();
                
        jScrollPaneCampeonato = new JScrollPane();
        tabelaCampeonato = new JTable();
        
        jScrollPaneCorrida = new JScrollPane();
        tabelaCorrida = new JTable();

    }

    private void add() {
        add(btnFinalizarCorrida);
        add(ReultadodacorridaLabel);
        add(GanhadorLabel);
        add(jScrollPaneCorrida);
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
            tabelaCorrida.setBackground(Colors.VERDELIGHT);
            tabelaCorrida.setForeground(Colors.CINZADARKB);
            GanhadorLabel.setForeground(Colors.CINZAMEDA);
            ReultadodacorridaLabel.setForeground(Colors.CINZAMEDA);
            btnFinalizarCorrida.setForeground(Colors.CINZADARKB);
            btnFinalizarCorrida.setBackground(Colors.VERDEDARK);

        } else {

            fundo.setBackground(Colors.CINZAMEDA);
            drawer.setBackground(Colors.VERDEDARK);          
            logo.setForeground(Colors.CINZAMEDB);
            tabelaCampeonato.setForeground(Colors.CINZADARKB);
            tabelaCampeonato.setBackground(Colors.VERDEDARK);
            tabelaCorrida.setForeground(Colors.CINZADARKB);
            tabelaCorrida.setBackground(Colors.VERDEDARK);
            GanhadorLabel.setForeground(Colors.CINZALIGHTB);
            ReultadodacorridaLabel.setForeground(Colors.CINZALIGHTB);
            btnFinalizarCorrida.setForeground(Colors.CINZADARKB);
            btnFinalizarCorrida.setBackground(Colors.VERDEDARK);
         
        }
    }
    private void configs() {

        fundo.setSize(Info.MAXSCREENSIZE);

        drawer.setBounds(0, 0, 1280, 100);

        try {

            jScrollPaneCampeonato.setViewportView(tabelaCampeonato);
            jScrollPaneCampeonato.setBounds(30, 150, 600, 400);

            jScrollPaneCorrida.setViewportView(tabelaCorrida);
            jScrollPaneCorrida.setBounds(655, 150, 600, 400);

            logo.setFont(Fonts.SANSSERIFMIN);
            logo.setBounds(20 , 30,500,35);
            logo.setText("RESULTADO DA CORRIDA");

            ReultadodacorridaLabel.setBounds(300, 120, 300, 35);
            ReultadodacorridaLabel.setText("REULTADO DE "+campeonato.getNome());

            GanhadorLabel.setBounds(280, 580, 300, 35);
            
            btnFinalizarCorrida.setBorderPainted(false);
            btnFinalizarCorrida.setFocusPainted(false);
            btnFinalizarCorrida.addActionListener(this);
            btnFinalizarCorrida.setBounds(320 , 640,200,35);
            btnFinalizarCorrida.setText("FINALIZAR CAMPEONATO"); 
            
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

    }

    public void estiloninjaVamo_da_GG_nisso_carai(){
        System.out.println("sdifsifkjsdfksdf  1");
       tabelaCorrida.setModel(new DefaultTableModel(
                new Object[][]{

                },
                new String[]{
                       "CORRIDA","PARTICIPANTE","TEMPO","POSIÇÃO","PONTUAÇÃO"
                }
        ) {
            boolean[] canEdit = new boolean[]{
                    false,false ,false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }

        });
       
        tabelamento = (DefaultTableModel) tabelaCorrida.getModel();
        try {
            List<PilotoParticipandoCampeonato> pilotos = new PilotoParticipandoCampeonatoBO().listarTodosPilotosQuePilotoParticipaNoCampeonato(campeonato);
            for(Corrida corrida : new CorridaBO().listarTodasAsCorridasMarcadas(campeonato)){
                for(int x =0; x < pilotos.size();x++){
                    if(pilotos.get(x).getPresenca().equals("PRESENTE")){
                        PilotoParticipaCorrida pilotoParticipaCorrida = new PilotoParticipaCorrida();
                        pilotoParticipaCorrida.setCorrida(corrida);
                        pilotoParticipaCorrida.setPilotoparticipacampeonato(pilotos.get(x));
                        pilotoParticipaCorrida.setPosicaoDeLargada(x+1);
                        pilotoParticipaCorrida.setTempoParaTerminar(new Time(aleatorio.nextInt(250000)+50000)); // menor tempo 50 seg maior 5 min
                        new PilotoParticipaCorridaBO().criar(pilotoParticipaCorrida);
                    }else{
                        pilotos.get(x).setPontuacao(0);
                        pilotos.get(x).setPosicao(0);
                    }
                }
                int posicao = 1;
                List<PontuacaoPosicao> valoresPontuacao = new PontuacaoPosicaoBO().listarPorCampeonato(campeonato);
                for(PilotoParticipaCorrida pilotoCorrida : new PilotoParticipaCorridaBO().listarTodosAscTime()){
                    //malandragem: pego os valores ordenados do menor tempo para o maior logo eu só preciso atribuir os valores
                    pilotoCorrida.setPosicao(posicao);
                    if(posicao -1 < 10){//o numero de valoresPontuacao só vai até dez então posicao só precisa informar até 10
                        //ok sei que isso ta muito louco mas os valores de valoresPontuacao
                        //estão ordenados por pontuação e da mesma forma que pilotoCorrida
                        //está ordenado pelo menor tempo que leva ao acordo de que é da
                        //primeira posicao a ultima o atributo int posicao - 1 sempre começa no zero ate
                        // o tamanho final do List, enfim não sei dizer se ficou claro mas
                        // a logíca leva aos valores corretos
                        pilotoCorrida.setPontuacao(valoresPontuacao.get(posicao-1).getPontuacao());
                    }else{
                        pilotoCorrida.setPontuacao(0);
                    }
                    new PilotoParticipaCorridaBO().alterar(pilotoCorrida);
                    tabelamento.addRow(new Object[]{
                        pilotoCorrida.getCorrida().getNomeCorrida(),
                        pilotoCorrida.getPilotoparticipacampeonato().getPiloto().getApelido(),
                        pilotoCorrida.getTempoParaTerminar(),
                        pilotoCorrida.getPosicao(),
                        pilotoCorrida.getPontuacao()
                    });
                    
                    posicao++;
                }
                for(int x =0; x < pilotos.size();x++){
                    if(pilotos.get(x).getPresenca().equals("PRESENTE")){
                    
                        for(Corrida corridas : new CorridaBO().listarTodasAsCorridasMarcadas(campeonato)){
                    
                            PilotoParticipaCorrida pilotocorridas = new PilotoParticipaCorridaBO().listarPilotoCorrida(corridas, pilotos.get(x));
                                pilotos.get(x).setPontuacao(pilotos.get(x).getPontuacao()+pilotocorridas.getPontuacao());  
                                new PilotoParticipandoCampeonatoBO().alterar(pilotos.get(x));
        
                        }
                    }
                }
                posicao = 1;
                if(campeonato.getTipoCorrida().equals(Info.CAMPEONATO_OFICIAL)){
                    for(PilotoParticipandoCampeonato pilotoscampeonato : new PilotoParticipandoCampeonatoBO().listarPilotoQueParticipaDeCampeonatoOrderPontuacao(campeonato)){
                        if(pilotoscampeonato.getPresenca().equals("PRESENTE")){
                            pilotoscampeonato.setPosicao(posicao);


                            if(pilotoscampeonato.getPosicao() == 1){//Bonus primeiro lugar
                                pilotoscampeonato.setPontuacao(pilotoscampeonato.getPontuacao()+Info.PRIMEIRO_COLOCADO_EXTRA_PONTOS);  
                                GanhadorLabel.setText("GRANDE GANHADOR: "+pilotoscampeonato.getPiloto().getApelido());
                            }
                            new PilotoParticipandoCampeonatoBO().alterar(pilotoscampeonato);

                            Piloto piloto_ganhos = pilotoscampeonato.getPiloto();
                            piloto_ganhos.setPontuacao_nivel(pilotoscampeonato.getPontuacao()+piloto_ganhos.getPontuacao_nivel());
                            piloto_ganhos.setNivel(piloto_ganhos.getPontuacao_nivel()/2);
                            posicao++;
                        }
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
