package View;

import Bo.CampeonatoBO;
import Bo.PilotoBO;
import Bo.PilotoParticipandoCampeonatoBO;
import Model.Campeonato;
import Model.Piloto;
import Model.PilotoParticipandoCampeonato;
import Utilities.Colors;
import Utilities.Fonts;
import Utilities.Info;
import Utilities.InformacoesPiloto;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
            btndarpresenca.setForeground(Colors.CINZADARKB);
            btndarpresenca.setBackground(Colors.VERDEDARK);
            informacoesPiloto.setForeground(Colors.CINZAMEDA);

        } else {

            fundo.setBackground(Colors.CINZAMEDA);
            drawer.setBackground(Colors.VERDEDARK);            
            btnVoltar.setForeground(Colors.CINZADARKB);
            btnVoltar.setBackground(Colors.VERDEDARK);
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
                }
            }
        }
        if (e.getSource() == btndarpresenca) {
            
            int[] index = tableParticipantes_status.getSelectedRows();

            for (int x = 0; x < index.length; x++) {
                tableParticipantes_status.setValueAt("PRESENTE",index[x],1);
            }
        }
        if (e.getSource() == btnIniciarCorrida) {
            for(int x = 0; x < tableParticipantes_status.getRowCount();x++){
                try {
                    Piloto pilotoparticipante = new PilotoBO().listarPorApelido((String) tableParticipantes_status.getValueAt(x, 0));
                    
                    List<PilotoParticipandoCampeonato> list = new PilotoParticipandoCampeonatoBO().Listar_o_piloto_do_campeonato(pilotoparticipante, campeonato);
                    list.get(0).setPresenca((String) tableParticipantes_status.getValueAt(x, 1));
                    new PilotoParticipandoCampeonatoBO().alterar(list.get(0));
                
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Não foi pssivel modificar o status dos pilotos!");
                }
            }
            
            
            dispose();
            new ResultadoCorrida(piloto,campeonato);
        }

    }

} 

