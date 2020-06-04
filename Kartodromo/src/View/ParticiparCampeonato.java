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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class ParticiparCampeonato extends JFrame implements ActionListener {

    private JPanel fundo;
    private JPanel drawer;
    private JButton btnParticiparCorrida;
    private JButton btnVoltar;
    private JButton btnOrdenarNome;
    private JButton btnOrdenarData;
    private JButton btnInfos;
    private JLabel logo;
    private JLabel ordenarporLabel;
    private JLabel corridaLabel;
    private JComboBox<String> CorridasjComboBox;
    private JScrollPane jScrollPaneCorridasMarcadas;
    private JTable tableTodasAsCorridasMarcadas;
    private DefaultTableModel tabelamento;
    private JPanel painelOrdenar;

    private Piloto piloto;

    public ParticiparCampeonato(Piloto piloto) {

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
        btnInfos = new JButton();
        btnOrdenarNome = new JButton();
        btnOrdenarData = new JButton();
        logo = new JLabel();
        ordenarporLabel = new JLabel();
        corridaLabel = new JLabel();
        jScrollPaneCorridasMarcadas = new JScrollPane();
        tableTodasAsCorridasMarcadas = new JTable();
        CorridasjComboBox = new JComboBox<>();
        painelOrdenar = new JPanel();
    }

    private void add() {
        add(btnVoltar);
        add(btnParticiparCorrida);
        add(logo);
        add(ordenarporLabel);
        add(corridaLabel);
        add(btnInfos);
        add(CorridasjComboBox);
        add(jScrollPaneCorridasMarcadas);
        add(painelOrdenar);
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
            btnInfos.setForeground(Colors.CINZADARKB);
            btnInfos.setBackground(Colors.VERDEDARK);
            CorridasjComboBox.setBackground(Colors.VERDEDARK);
            CorridasjComboBox.setForeground(Colors.CINZADARKB);
            btnOrdenarNome.setBackground(Colors.VERDEDARK);
            btnOrdenarNome.setForeground(Colors.CINZADARKB);
            btnOrdenarData.setBackground(Colors.VERDEDARK);
            btnOrdenarData.setForeground(Colors.CINZADARKB);
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
            btnInfos.setForeground(Colors.CINZADARKB);
            btnInfos.setBackground(Colors.VERDEDARK);
            btnVoltar.setForeground(Colors.CINZADARKB);
            btnParticiparCorrida.setForeground(Colors.CINZADARKB);
            CorridasjComboBox.setForeground(Colors.CINZADARKB);
            CorridasjComboBox.setBackground(Colors.VERDEDARK);
            btnOrdenarNome.setForeground(Colors.CINZADARKB);
            btnOrdenarNome.setBackground(Colors.VERDEDARK);
            btnOrdenarData.setForeground(Colors.CINZADARKB);
            btnOrdenarData.setBackground(Colors.VERDEDARK);
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
                            "CAMPEONATO", "DATA", "TIPO"
                    }
            ) {
                boolean[] canEdit = new boolean[]{
                        false, false, false
                };

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit[columnIndex];
                }

            });
            tableTodasAsCorridasMarcadas.getColumnModel().getColumn(0).setPreferredWidth(260);
            tableTodasAsCorridasMarcadas.getColumnModel().getColumn(1).setPreferredWidth(100);
            tableTodasAsCorridasMarcadas.getColumnModel().getColumn(2).setPreferredWidth(300);
            
            tabelamento = (DefaultTableModel) tableTodasAsCorridasMarcadas.getModel();

            PilotoParticipandoCampeonatoBO pilotoParticipandoCampeonatoBo = new PilotoParticipandoCampeonatoBO();
            for (Campeonato campeonato : new CampeonatoBO().listarTodos()) {

                if (pilotoParticipandoCampeonatoBo.Listar_o_piloto_do_campeonato(piloto, campeonato).isEmpty()) {
                    //verificação onde caso o campeonato for nulo quer dizer que o piloto não participa deste campeonato

                    List<PilotoParticipandoCampeonato> numeroDeParticipantes = pilotoParticipandoCampeonatoBo.listarTodosPilotosQuePilotoParticipaNoCampeonato(campeonato);

                    if (numeroDeParticipantes.size() < Info.MAX_PILOTOS_CAMPEONATO) { //incluir regras de negocio como piloto menor de idade e max de pessoas

                        CorridasjComboBox.addItem(campeonato.getNome());
                        tabelamento.addRow(new Object[]{
                                campeonato.getNome(),
                                campeonato.getDataFinalizacao(),
                                campeonato.getTipoCorrida()
                        });

                    }
                }
            }

            jScrollPaneCorridasMarcadas.setViewportView(tableTodasAsCorridasMarcadas);
            jScrollPaneCorridasMarcadas.setBounds(60, 150, 680, 220);
            CorridasjComboBox.setBorder(BorderFactory.createEmptyBorder());
            CorridasjComboBox.setBounds(60, 480, 300, 35);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        painelOrdenar.setLayout(new GridLayout());
        painelOrdenar.setBounds(60, 400, 300, 40);
        painelOrdenar.add(this.btnOrdenarNome);
        painelOrdenar.add(this.btnOrdenarData);
        btnOrdenarNome.setText("NOME");
        btnOrdenarNome.addActionListener(this);
        btnOrdenarData.setText("DATA");
        btnOrdenarData.addActionListener(this);

        btnVoltar.setBorderPainted(false);
        btnVoltar.setFocusPainted(false);
        btnVoltar.addActionListener(this);
        btnVoltar.setBounds(60, 550, 100, 35);
        btnVoltar.setText("Voltar");
        
        btnInfos.setBorderPainted(false);
        btnInfos.setFocusPainted(false);
        btnInfos.addActionListener(this);
        btnInfos.setBounds(520, 400, 230, 35);
        btnInfos.setText("Ver informações do campeonato");
                
        btnParticiparCorrida.setBorderPainted(false);
        btnParticiparCorrida.setFocusPainted(false);
        btnParticiparCorrida.addActionListener(this);
        btnParticiparCorrida.setBounds(520, 550, 230, 35);
        btnParticiparCorrida.setText("Participar de uma Campeonato");

        logo.setBounds(20, 30, 760, 35);
        logo.setText("PARTICIPAR DE CAMPEONATO");
        logo.setFont(Fonts.SANSSERIFMIN);

        // Mudar para valores reais aqui //

        ordenarporLabel.setBounds(60, 370, 200, 30);
        ordenarporLabel.setText("ORDENAR TABELA POR:");

        corridaLabel.setBounds(60, 450, 200, 35);
        corridaLabel.setText("ESCOLHER UM Campeonato:");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnVoltar) {
            dispose();
            new PerfilPiloto(piloto);
        }
        if (e.getSource() == btnInfos) {
            try {
                Campeonato campeonato = new CampeonatoBO().getByNome(CorridasjComboBox.getSelectedItem().toString());
                dispose();
                new InfosGeraisCorridas(piloto,campeonato);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Não foi possível verificar informações de campeonato");
            }
        
        }
        if (e.getSource() == btnParticiparCorrida) {

            try {

                Campeonato campeonato = new CampeonatoBO().getByNome(CorridasjComboBox.getSelectedItem().toString());
                PilotoParticipandoCampeonato pilotoparticipante = new PilotoParticipandoCampeonato();
                pilotoparticipante.setCampeonato(campeonato);
                pilotoparticipante.setPiloto(piloto);
                pilotoparticipante.setStatusAdm(false);
                new PilotoParticipandoCampeonatoBO().criar(pilotoparticipante);
                JOptionPane.showMessageDialog(null, " Você está participando do Campeonato:" + campeonato.getNome() + " !");
                
                dispose();
                new ParticiparCampeonato(piloto);
                
                
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro: " + ex + ", Não foi possível Participar deste campeonato!");
            }

        }

        if (e.getSource() == btnOrdenarNome) {
            PilotoParticipandoCampeonatoBO pilotoparticipandocampeonatobo = new PilotoParticipandoCampeonatoBO();
            try {
                tableTodasAsCorridasMarcadas.setModel(new DefaultTableModel(
                    new Object[][]{

                    },
                    new String[]{
                            "CAMPEONATO", "DATA", "TIPO"
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

                for (Campeonato campeonato : new CampeonatoBO().listarPorNome()) {
                    List<PilotoParticipandoCampeonato> campeonato_para_participar = pilotoparticipandocampeonatobo.Listar_o_piloto_do_campeonato(piloto, campeonato);
                    if (campeonato_para_participar.isEmpty()) {//verificação de se o campeonato for nulo quer dizer que o piloto não participa deste campeonato
                        List<PilotoParticipandoCampeonato> numero_de_participantes = pilotoparticipandocampeonatobo.listarTodosPilotosQuePilotoParticipaNoCampeonato(campeonato);
                        
                        
                        
                        if (numero_de_participantes.size() < Info.MAX_PILOTOS_CAMPEONATO) { //incluir regras de negocio como piloto menor de idade e max de pessoas

                            
                            tabelamento.addRow(new Object[]{
                                    campeonato.getNome(),
                                    campeonato.getDataFinalizacao(),
                                    campeonato.getTipoCorrida()
                            });
                        }
                    }
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }

        if (e.getSource() == btnOrdenarData) {

            PilotoParticipandoCampeonatoBO pilotoparticipandocampeonatobo = new PilotoParticipandoCampeonatoBO();

            try {
                tableTodasAsCorridasMarcadas.setModel(new DefaultTableModel(
                    new Object[][]{

                    },
                    new String[]{
                            "CAMPEONATO", "DATA", "TIPO"
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


                for (Campeonato campeonato : new CampeonatoBO().listarPorData()) {
                    List<PilotoParticipandoCampeonato> campeonato_para_participar = pilotoparticipandocampeonatobo.Listar_o_piloto_do_campeonato(piloto, campeonato);
                    if (campeonato_para_participar.isEmpty()) {//verificação de se o campeonato for nulo quer dizer que o piloto não participa deste campeonato
                        List<PilotoParticipandoCampeonato> numero_de_participantes = pilotoparticipandocampeonatobo.listarTodosPilotosQuePilotoParticipaNoCampeonato(campeonato);
                        
                        
                        
                        if (numero_de_participantes.size() < Info.MAX_PILOTOS_CAMPEONATO) { //incluir regras de negocio como piloto menor de idade e max de pessoas

                            
                            tabelamento.addRow(new Object[]{
                                    campeonato.getNome(),
                                    campeonato.getDataFinalizacao(),
                                    campeonato.getTipoCorrida()
                            });
                        }
                    }
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
    }

} 
