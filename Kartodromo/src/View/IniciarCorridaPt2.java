package View;

import Bo.CampeonatoBO;
import Bo.CorridaBO;
import Bo.PilotoBO;
import Bo.PilotoParticipaCorridaBO;
import Bo.PilotoParticipandoCampeonatoBO;
import Model.Campeonato;
import Model.Corrida;
import Model.Piloto;
import Model.PilotoParticipaCorrida;
import Model.PilotoParticipandoCampeonato;
import Utilities.Colors;
import Utilities.Fonts;
import Utilities.Info;
import Utilities.InformacoesPiloto;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class IniciarCorridaPt2 extends JFrame implements ActionListener {

    private JPanel fundo;
    private JPanel drawer;
    private JButton btnVoltar;
    private JButton btndarfalta;
    private JButton btndarpresenca;
    private JButton btnIniciarCorrida;
    private JLabel logo;
    private JLabel SelecioneLabel;
    private JScrollPane jScrollPaneParticipantes;
    private InformacoesPiloto informacoesPiloto;
    private JTable tableParticipantes_status;
    private DefaultTableModel tabelamento;
    private JComboBox<String> CorridasjComboBox;

    private Piloto piloto;
    private Campeonato campeonato;

    public IniciarCorridaPt2(Piloto piloto, Campeonato campeonato) {
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
        btnIniciarCorrida = new JButton();
        CorridasjComboBox = new JComboBox<>();
        logo = new JLabel();
        jScrollPaneParticipantes = new JScrollPane();
        tableParticipantes_status = new JTable();
        SelecioneLabel = new JLabel();
        btndarfalta = new JButton();
        btndarpresenca = new JButton();
        informacoesPiloto = new InformacoesPiloto();

    }

    private void add() {
        add(btnVoltar);
        add(btnIniciarCorrida);
        add(logo);
        add(SelecioneLabel);
        add(btndarfalta);
        add(btndarpresenca);
        add(CorridasjComboBox);
        add(informacoesPiloto);
        add(jScrollPaneParticipantes);
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
            btnIniciarCorrida.setForeground(Colors.CINZADARKB);
            btnIniciarCorrida.setBackground(Colors.VERDEDARK);
            logo.setForeground(Colors.CINZAMEDB);
            tableParticipantes_status.setBackground(Colors.VERDELIGHT);
            tableParticipantes_status.setForeground(Colors.CINZADARKB);
            SelecioneLabel.setForeground(Colors.CINZAMEDA);
            btndarfalta.setForeground(Colors.CINZADARKB);
            btndarfalta.setBackground(Colors.VERDEDARK);
            CorridasjComboBox.setBackground(Colors.VERDEDARK);
            CorridasjComboBox.setForeground(Colors.CINZADARKB);
            btndarpresenca.setForeground(Colors.CINZADARKB);
            btndarpresenca.setBackground(Colors.VERDEDARK);
            informacoesPiloto.setForeground(Colors.CINZAMEDA);

        } else {

            fundo.setBackground(Colors.CINZAMEDA);
            drawer.setBackground(Colors.VERDEDARK);            
            btnVoltar.setForeground(Colors.CINZADARKB);
            btnVoltar.setBackground(Colors.VERDEDARK);
            CorridasjComboBox.setForeground(Colors.CINZADARKB);
            CorridasjComboBox.setBackground(Colors.VERDEDARK);
            informacoesPiloto.setForeground(Colors.BRANCO);
            btnIniciarCorrida.setForeground(Colors.CINZADARKB);
            btnIniciarCorrida.setBackground(Colors.VERDEDARK);
            logo.setForeground(Colors.CINZAMEDB);
            tableParticipantes_status.setForeground(Colors.CINZADARKB);
            tableParticipantes_status.setBackground(Colors.VERDEDARK);
            SelecioneLabel.setForeground(Colors.CINZALIGHTB);
            btndarfalta.setForeground(Colors.CINZADARKB);
            btndarfalta.setBackground(Colors.VERDEDARK);
            btndarpresenca.setForeground(Colors.CINZADARKB);
            btndarpresenca.setBackground(Colors.VERDEDARK);

        }
    }

    private void configs() {

        fundo.setSize(Info.MINSCREENSIZE);

        drawer.setBounds(0, 0, 800, 100);

        informacoesPiloto.setBounds(600, 3, 200, 100);
        informacoesPiloto.setPiloto(piloto);
        
        try {

            tableParticipantes_status.setModel(new DefaultTableModel(
                    new Object[][]{

                    },
                    new String[]{
                            "NOME DO PARTICIPANTE","STATUS"
                    }
            ) {
                boolean[] canEdit = new boolean[]{
                        false, false
                };

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit[columnIndex];
                }

            });

            tabelamento = (DefaultTableModel) tableParticipantes_status.getModel();

            for (PilotoParticipandoCampeonato pilotosparticipantes : new PilotoParticipandoCampeonatoBO().listarTodosPilotosQuePilotoParticipaNoCampeonato(campeonato)) {
                tabelamento.addRow(new Object[]{
                    pilotosparticipantes.getPiloto().getApelido(),
                    "PRESENTE"
                });
                
            }
            
            jScrollPaneParticipantes.setViewportView(tableParticipantes_status);
            jScrollPaneParticipantes.setBounds(60, 150, 680, 250);

            logo.setFont(Fonts.SANSSERIFMIN);
            logo.setBounds(20 , 30,500,35);
            logo.setText("INICIAR CAMPEONATO");

            SelecioneLabel.setBounds(60, 120, 680, 35);
            SelecioneLabel.setText("Selecione os pilotos participante para atribuir FALTA OU PRESENÇA:");

            btndarfalta.setBorderPainted(false);
            btndarfalta.setFocusPainted(false);
            btndarfalta.addActionListener(this);
            btndarfalta.setBounds(540, 500, 200, 35);
            btndarfalta.setText("Atribuir Falta"); 
            
            btndarpresenca.setBorderPainted(false);
            btndarpresenca.setFocusPainted(false);
            btndarpresenca.addActionListener(this);
            btndarpresenca.setBounds(540, 450, 200, 35);
            btndarpresenca.setText("Atribuir Presenca");   

            btnIniciarCorrida.setBorderPainted(false);
            btnIniciarCorrida.setFocusPainted(false);
            btnIniciarCorrida.addActionListener(this);
            btnIniciarCorrida.setBounds(540, 550, 200, 35);
            btnIniciarCorrida.setText("Iniciar Campeonato");
            
            btnVoltar.setBorderPainted(false);
            btnVoltar.setFocusPainted(false);
            btnVoltar.addActionListener(this);
            btnVoltar.setBounds(60 , 550,200,35);
            btnVoltar.setText("Voltar");
            
            criarpilotoscorrida();
            
            CorridasjComboBox.setBorder(BorderFactory.createEmptyBorder());
            CorridasjComboBox.setBounds(60, 500, 200, 35);
            CorridasjComboBox.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        mudarTabelaCorrida();
                    }
                }
            });
            for(Corrida corridas : new CorridaBO().listarTodasAsCorridasMarcadas(campeonato)){
                 CorridasjComboBox.addItem(corridas.getNomeCorrida());
            }
            mudarTabelaCorrida();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
      
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnVoltar) {
            dispose();
            new IniciarCorridaPt1(piloto);
        }
        if (e.getSource() == btndarfalta) {
            int[] index = tableParticipantes_status.getSelectedRows();

            for (int x = 0; x < index.length; x++) {
                if(piloto.getApelido().equals(tableParticipantes_status.getValueAt(index[x],0))){
                        JOptionPane.showMessageDialog(null, "Você não pode dar falta a você mesmo!");
                }else{
                    tableParticipantes_status.setValueAt("FALTOU",index[x],1);
                    mudarstatuspresencapiloto(x);
                }
            }
        }
        if (e.getSource() == btndarpresenca) {
            
            int[] index = tableParticipantes_status.getSelectedRows();

            for (int x = 0; x < index.length; x++) {
                tableParticipantes_status.setValueAt("PRESENTE",index[x],1);
                mudarstatuspresencapiloto(x);
            }
        }
        if (e.getSource() == btnIniciarCorrida) {
            for(int x = 0; x < tableParticipantes_status.getRowCount();x++){
                try {
                    for(Corrida corridas : new CorridaBO().listarTodasAsCorridasMarcadas(campeonato)){
                        for(PilotoParticipaCorrida pilotocorrida : new PilotoParticipaCorridaBO().listarPilotoCorridaOrderApelido(corridas)){
                            if(pilotocorrida.isStatus_Presenca() == false){
                                Piloto pilotostrike = pilotocorrida.getPilotoparticipacampeonato().getPiloto();
                                pilotostrike.setNumeroDeStrikesPiloto(pilotostrike.getNumeroDeStrikesPiloto()+1);
                                if(pilotostrike.getNumeroDeStrikesPiloto() > 3){
                                    pilotostrike.setAtivo(false);
                                }
                                new PilotoBO().alterar(pilotostrike);
                            }
                        }                      
                    }     
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Não foi pssivel modificar o status dos pilotos!");
                }
            }
            
            dispose();
            new ResultadosCampeonato(piloto,campeonato);
        }

    }
    
    public void criarpilotoscorrida() throws Exception{
        for(PilotoParticipandoCampeonato pilotoparticipacampeonato : new PilotoParticipandoCampeonatoBO().listarTodosPilotosQuePilotoParticipaNoCampeonato(campeonato)){
            for(Corrida corrida : new CorridaBO().listarTodasAsCorridasMarcadas(campeonato)){
                PilotoParticipaCorrida pilotocorrida = new PilotoParticipaCorrida();
                pilotocorrida.setStatus_Presenca(true);
                if(new PilotoParticipaCorridaBO().listarPilotoApelidoCorrida(corrida, pilotoparticipacampeonato.getPiloto().getApelido())==null){

                    pilotocorrida.setCorrida(corrida);
                    pilotocorrida.setPilotoparticipacampeonato(pilotoparticipacampeonato);
                    new PilotoParticipaCorridaBO().criar(pilotocorrida);
                }else{
                    PilotoParticipaCorrida pilotocorridaaltera = new PilotoParticipaCorridaBO().listarPilotoApelidoCorrida(corrida, pilotoparticipacampeonato.getPiloto().getApelido());
                    new PilotoParticipaCorridaBO().alterar(pilotocorridaaltera);
                }
            }
        }
    }
    public void mudarstatuspresencapiloto(int x){
        try {
            Corrida corrida = new CorridaBO().getByNome(CorridasjComboBox.getSelectedItem().toString());
            PilotoParticipaCorrida pilotocorrida = new PilotoParticipaCorridaBO().listarPilotoApelidoCorrida(corrida, tableParticipantes_status.getValueAt(x, 0).toString());
            
            if(tableParticipantes_status.getValueAt(x, 1).equals("PRESENTE")){
                pilotocorrida.setStatus_Presenca(true);
            }else{
                pilotocorrida.setStatus_Presenca(false);
            }
            new PilotoParticipaCorridaBO().alterar(pilotocorrida);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "não foi possível mutar o status");
        }
    }

    public void mudarTabelaCorrida(){
        try {
            tableParticipantes_status.setModel(new DefaultTableModel(
                    new Object[][]{

                    },
                    new String[]{
                            "NOME DO PARTICIPANTE","STATUS"
                    }
            ) {
                boolean[] canEdit = new boolean[]{
                        false, false
                };

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit[columnIndex];
                }

            });

            tabelamento = (DefaultTableModel) tableParticipantes_status.getModel();
                Corrida corrida = new CorridaBO().getByNome(CorridasjComboBox.getSelectedItem().toString());
                String presenca = null;
                for(PilotoParticipaCorrida pilotoscorrida : new PilotoParticipaCorridaBO().listarPilotoCorridaOrderApelido(corrida)){
                    if(pilotoscorrida.isStatus_Presenca()){
                        presenca = "PRESENTE";
                    }else{
                        presenca = "FALTOU";
                    }
                    tabelamento.addRow(new Object[]{
                        pilotoscorrida.getPilotoparticipacampeonato().getPiloto().getApelido(),
                        presenca
                    });   
                }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível Localizar Corridas na Combo");
        }
        
    }
   
 
} 

