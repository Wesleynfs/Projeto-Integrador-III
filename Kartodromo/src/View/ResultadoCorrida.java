
package View;

import Bo.CorridaBO;
import Bo.PilotoParticipandoCampeonatoBO;
import Model.Campeonato;
import Model.Corrida;
import Model.Piloto;
import Model.PilotoParticipandoCampeonato;
import Utilities.Colors;
import Utilities.Fonts;
import Utilities.Info;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
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

            tabelaCampeonato.setModel(new DefaultTableModel(
                    new Object[][]{

                    },
                    new String[]{
                            "PARTICIPANTE","TEMPO FINAL","POSIÇÃO","PONTUAÇÃO"
                    }
            ) {
                boolean[] canEdit = new boolean[]{
                        false,false ,false, false
                };

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit[columnIndex];
                }

            });

            tabelamento = (DefaultTableModel) tabelaCampeonato.getModel();

            
            
            
            
            jScrollPaneCampeonato.setViewportView(tabelaCampeonato);
            jScrollPaneCampeonato.setBounds(30, 150, 600, 400);
            /////////////////////////////////////////////


            
            
            
            
            jScrollPaneCorrida.setViewportView(tabelaCorrida);
            jScrollPaneCorrida.setBounds(655, 150, 600, 400);
            

            logo.setFont(Fonts.SANSSERIFMIN);
            logo.setBounds(20 , 30,500,35);
            logo.setText("RESULTADO DA CORRIDA");

            ReultadodacorridaLabel.setBounds(300, 120, 300, 35);
            ReultadodacorridaLabel.setText("REULTADO DE "+campeonato.getNome());

            GanhadorLabel.setBounds(280, 580, 300, 35);
            GanhadorLabel.setText("GRANDE GANHADOR: NOME PILOTO VENCEDOR");
            //AQUI COLOCA O NOME DO PRIMEIRO COLOCADO DA CORRIDA      
            //        
                    
                    
            btnFinalizarCorrida.setBorderPainted(false);
            btnFinalizarCorrida.setFocusPainted(false);
            btnFinalizarCorrida.addActionListener(this);
            btnFinalizarCorrida.setBounds(320 , 640,200,35);
            btnFinalizarCorrida.setText("FINALIZAR CAMPEONATO"); 
            

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
            for(Corrida corrida : new CorridaBO().listarTodasAsCorridasMarcadas(campeonato)){
                List<PilotoParticipandoCampeonato> pilotos = new PilotoParticipandoCampeonatoBO().listarTodosPilotosQuePilotoParticipaNoCampeonato(campeonato);
                    
                //criar PilotoParticipaCorrida
                
                //caso o piloto falte ao campeonato set 0 em tudo
                //gerar posicaodelargada de PilotoParticipaCorrida
                //gerar tempo de PilotoParticipaCorrida
                //gerar posicao de PilotoParticipaCorrida, caso empate PilotoParticipaCorrida com maior posicaodelargada ganha
                //gerar pontuaco de PilotoParticipaCorrida
                
                //colocar na tabela de corrida os dados PilotoParticipaCorrida caso seja diferente de zero
                
                //somar tempo de todas as corrida e colocar em tempo no pilotoparticipacampeonato
                //somar pontuação das corridas e colocar em pontuação de pilotoparticipacampeonato
                //setar posiçãono campeonato de acordo com a pontuação
                
                //colocar na tabela de campeonato os dados de pilotoparticipacampeonato caso seja diferente de zero
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível Criar o resultado");
        }

    }

} 
