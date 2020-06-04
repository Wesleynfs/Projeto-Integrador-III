package View;

import Bo.CampeonatoBO;
import Bo.PilotoParticipandoCampeonatoBO;
import Model.Campeonato;
import Model.Piloto;
import Model.PilotoParticipandoCampeonato;
import Utilities.Colors;
import Utilities.Fonts;
import Utilities.Info;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class IniciarCorridaPt1 extends JFrame implements ActionListener {

    private JPanel fundo;
    private JPanel drawer;
    private JButton btnVoltar;
    private JButton btnIniciarCorrida;
    private JLabel logo;
    private JLabel corrida_escolhidaLabel;
    private JLabel corridas_participandoLabel;
    private JComboBox<Object> corridasjComboBox;
    private JScrollPane jScrollPanePilotosCorrida;
    private JScrollPane jScrollPaneCorridasMarcadas;
    private JTable tableTodasAsCorridasMarcadas;
    private JTable tablePilotosCorrida;
    private DefaultTableModel tabelamento;
    private Piloto piloto;

    public IniciarCorridaPt1(Piloto piloto) {
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
        btnIniciarCorrida = new JButton();
        logo = new JLabel();
        corrida_escolhidaLabel = new JLabel();
        corridas_participandoLabel = new JLabel();
        corridasjComboBox = new JComboBox();
        jScrollPaneCorridasMarcadas = new JScrollPane();
        tableTodasAsCorridasMarcadas = new JTable();
        jScrollPanePilotosCorrida = new JScrollPane();
        tablePilotosCorrida = new JTable();
    }

    private void add() {
        add(corrida_escolhidaLabel);
        add(btnVoltar);
        add(corridasjComboBox);
        add(jScrollPanePilotosCorrida);
        add(btnIniciarCorrida);
        add(logo);
        add(corridas_participandoLabel);
        add(jScrollPaneCorridasMarcadas);
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
            corrida_escolhidaLabel.setForeground(Colors.CINZAMEDA);
            corridas_participandoLabel.setForeground(Colors.CINZAMEDA);
            corridasjComboBox.setBackground(Colors.CINZALIGHTB);
            corridasjComboBox.setForeground(Colors.BRANCO);
            tableTodasAsCorridasMarcadas.setBackground(Colors.VERDELIGHT);
            tableTodasAsCorridasMarcadas.setForeground(Colors.CINZADARKB);
            tablePilotosCorrida.setBackground(Colors.VERDELIGHT);
            tablePilotosCorrida.setForeground(Colors.CINZADARKB);

        } else {

            fundo.setBackground(Colors.CINZAMEDA);
            drawer.setBackground(Colors.VERDEDARK);            
            btnVoltar.setForeground(Colors.CINZADARKB);
            btnVoltar.setBackground(Colors.VERDEDARK);
            btnIniciarCorrida.setForeground(Colors.CINZADARKB);
            btnIniciarCorrida.setBackground(Colors.VERDEDARK);
            logo.setForeground(Colors.CINZAMEDB);
            corrida_escolhidaLabel.setForeground(Colors.CINZALIGHTB);
            corridas_participandoLabel.setForeground(Colors.CINZALIGHTB);
            corridasjComboBox.setForeground(Colors.CINZADARKA);
            corridasjComboBox.setBackground(Colors.CINZALIGHTB);
            tableTodasAsCorridasMarcadas.setForeground(Colors.CINZADARKB);
            tableTodasAsCorridasMarcadas.setBackground(Colors.VERDEDARK);
            tablePilotosCorrida.setForeground(Colors.CINZADARKB);
            tablePilotosCorrida.setBackground(Colors.VERDEDARK);
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
                            "NOME DO CAMPEONATO","DATA DO CAMPEONATO","PILOTOS CONFIRMADOS"
                    }
            ) {
                boolean[] canEdit = new boolean[]{
                        false, false, false
                };

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit[columnIndex];
                }

            });

            tabelamento = (DefaultTableModel) tableTodasAsCorridasMarcadas.getModel();

            try {
                List<PilotoParticipandoCampeonato> listaCampeonatoDoPiloto = new PilotoParticipandoCampeonatoBO().listarTodosPilotosQuePilotoParticipaNoCampeonato(piloto);
                if (listaCampeonatoDoPiloto.isEmpty()) {
                    tabelamento.addRow(new Object[]{
                            "Nem um campeonato na lista!"
                    });
                } else {
                    for (PilotoParticipandoCampeonato list : listaCampeonatoDoPiloto) {
                        corridasjComboBox.addItem(list.getCampeonato().getNome());
                        List<PilotoParticipandoCampeonato> listaTotalPiloto = new PilotoParticipandoCampeonatoBO().listarTodosPilotosQuePilotoParticipaNoCampeonato(list.getCampeonato());
                        tabelamento.addRow(new Object[]{
                                list.getCampeonato().getNome(),
                                list.getCampeonato().getDataFinalizacao(),
                                listaTotalPiloto.size()
                        });
                    }
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            jScrollPaneCorridasMarcadas.setViewportView(tableTodasAsCorridasMarcadas);
            jScrollPaneCorridasMarcadas.setBounds(60, 150, 680, 200);

            mudarPilotosParticipando();
            jScrollPanePilotosCorrida.setBounds(60, 370, 230 , 150);

            logo.setFont(Fonts.SANSSERIFMIN);
            logo.setBounds(20 , 30,500,35);
            logo.setText("INICIAR CAMPEONATO");

            corrida_escolhidaLabel.setBounds(540 , 355,300,30);
            corrida_escolhidaLabel.setText("Selecionar Campeonato:");

            corridas_participandoLabel.setBounds(60 , 120,300,30);
            corridas_participandoLabel.setText("Corridas participando:");
                    
            corridasjComboBox.setBorder(BorderFactory.createEmptyBorder());
            corridasjComboBox.setBounds(540,390,200,35);

            btnIniciarCorrida.setBorderPainted(false);
            btnIniciarCorrida.setFocusPainted(false);
            btnIniciarCorrida.addActionListener(this);
            btnIniciarCorrida.setBounds(540, 550, 200, 35);
            btnIniciarCorrida.setText("Iniciar Corrida");
            
            btnVoltar.setBorderPainted(false);
            btnVoltar.setFocusPainted(false);
            btnVoltar.addActionListener(this);
            btnVoltar.setBounds(60 , 550,200,35);
            btnVoltar.setText("Voltar");
            
            this.corridasjComboBox.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        mudarPilotosParticipando();
                    }
                }
            });

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

        if (e.getSource() == btnIniciarCorrida) {
            try{
               
                Campeonato campeonato = new CampeonatoBO().getByNome(corridasjComboBox.getSelectedItem().toString());
                List<PilotoParticipandoCampeonato> list = new PilotoParticipandoCampeonatoBO().listarTodosPilotosQuePilotoParticipaNoCampeonato(campeonato);
                if ((list.size() >= Info.NUMERO_MINIMO_DE_PILOTOS_CAMPEONATO_OFFICIAL
                        && Info.CAMPEONATO_OFICIAL.equals(campeonato.getTipoCorrida()))){
                    dispose();
                    new IniciarCorridaPt2(piloto,campeonato); 
                }else if (Info.CAMPEONATO_NORMAL.equals(campeonato.getTipoCorrida())) {
                    dispose();
                    new IniciarCorridaPt2(piloto,campeonato);
                } else {
                        JOptionPane.showMessageDialog(null, "Você não pode iniciar essa corrida, ela não possui competidores suficientes");
                }
                            
                
            } catch (Exception error) {
                JOptionPane.showMessageDialog(null, "Você não selecionou nenhuma corrida!");
            }
        }

    }

    private void mudarPilotosParticipando() {

        try {
                        tablePilotosCorrida.setModel(new DefaultTableModel(
                    new Object[][]{

                    },
                    new String[]{
                            "PARTICIPANTES","NÍVEL"
                    }
            ) {
                boolean[] canEdit = new boolean[]{
                        false, false
                };

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit[columnIndex];
                }

            });

            tabelamento = (DefaultTableModel) tablePilotosCorrida.getModel();
            Campeonato campeonato = new CampeonatoBO().getByNome(corridasjComboBox.getSelectedItem().toString());
         
            for (PilotoParticipandoCampeonato pilotosparticipantes : new PilotoParticipandoCampeonatoBO().listarTodosPilotosQuePilotoParticipaNoCampeonato(campeonato)) {
                tabelamento.addRow(new Object[]{
                    pilotosparticipantes.getPiloto().getApelido(),
                    pilotosparticipantes.getPiloto().getNivel()
                });
                
            }
            
            
            
            
            jScrollPanePilotosCorrida.setViewportView(tablePilotosCorrida);
            

        } catch (Exception error) {
            JOptionPane.showMessageDialog(null, "Não foi possível encontrar os piloto para convidar");
        }

    }
    
} 