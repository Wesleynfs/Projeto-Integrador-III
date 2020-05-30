package View;

import Bo.PilotoParticipandoCampeonatoBO;
import Dao.PilotoParticipandoCampeonatoDAO;
import Model.Piloto;
import Model.PilotoParticipandoCampeonato;
import Utilities.Colors;
import Utilities.Fonts;
import Utilities.Info;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class PerfilPiloto extends JFrame implements ActionListener {

    private JPanel fundo;
    private JPanel drawer;
    private JButton btnRelatar;
    private JButton btnSair;
    private JButton btnParticiparCorrida;
    private JButton btnGerenciarCampeonatos;
    private JButton btnVerificarCorridas;
    private JButton btnAvaliarKartdromo;
    private JLabel infoPiloto;
    private JLabel perfilPilotoLabel;
    private JLabel corridasParticipandoLabel;
    private JLabel corridasMarcadasLabel;
    private JScrollPane jScrollPaneCorridasMarcadas;
    private JTable tableTodasAsCorridasMarcadas;
    private JScrollPane jScrollPaneCorridasParticipando;
    private JTable tableCorridasParticipando;
    private DefaultTableModel tabelamento;
    JTableHeader headerTabelaCorridasParticipando;
    JTableHeader headerTabelaTodasAsCorridasMarcadas;

    private String nivel_elo;

    private Piloto piloto;

    public PerfilPiloto(Piloto piloto) {

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

    public PerfilPiloto() {


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
        btnRelatar = new JButton();
        btnSair = new JButton();
        btnParticiparCorrida = new JButton();
        btnGerenciarCampeonatos = new JButton();
        btnVerificarCorridas = new JButton();
        btnAvaliarKartdromo = new JButton();
        infoPiloto = new JLabel();
        corridasParticipandoLabel = new JLabel();
        corridasMarcadasLabel = new JLabel();
        perfilPilotoLabel = new JLabel();
        jScrollPaneCorridasMarcadas = new JScrollPane();
        tableTodasAsCorridasMarcadas = new JTable();
        jScrollPaneCorridasParticipando = new JScrollPane();
        tableCorridasParticipando = new JTable();
        headerTabelaCorridasParticipando = tableCorridasParticipando.getTableHeader();
        headerTabelaTodasAsCorridasMarcadas = tableTodasAsCorridasMarcadas.getTableHeader();

    }

    private void add() {

        add(btnRelatar);
        add(btnSair);
        add(btnParticiparCorrida);
        add(btnGerenciarCampeonatos);
        add(btnVerificarCorridas);
        add(btnAvaliarKartdromo);
        add(perfilPilotoLabel);
        add(corridasParticipandoLabel);
        add(corridasMarcadasLabel);
        add(infoPiloto);
        add(jScrollPaneCorridasMarcadas);
        add(jScrollPaneCorridasParticipando);
        add(drawer);
        add(fundo);

    }

    private void setTheme() {

        if (SplashScreen.getConfiguracao().isTema()) {
            // Se o tema for escuro, os itens ficam assim //
            fundo.setBackground(Colors.CINZAMEDB);
            drawer.setBackground(Colors.VERDEDARK);
            infoPiloto.setForeground(Colors.CINZALIGHTB);
            corridasParticipandoLabel.setForeground(Colors.CINZALIGHTB);
            corridasMarcadasLabel.setForeground(Colors.CINZALIGHTB);
            btnSair.setForeground(Colors.CINZADARKB);
            btnParticiparCorrida.setForeground(Colors.CINZADARKB);
            btnGerenciarCampeonatos.setForeground(Colors.CINZADARKB);
            btnVerificarCorridas.setForeground(Colors.CINZADARKB);
            btnAvaliarKartdromo.setForeground(Colors.CINZADARKB);
            btnRelatar.setForeground(Colors.CINZAMEDA);
            btnRelatar.setBackground(Colors.CINZAMEDB);
            btnSair.setBackground(Colors.VERDEDARK);
            btnParticiparCorrida.setBackground(Colors.VERDEDARK);
            btnGerenciarCampeonatos.setBackground(Colors.VERDEDARK);
            btnVerificarCorridas.setBackground(Colors.VERDEDARK);
            btnAvaliarKartdromo.setBackground(Colors.VERDEDARK);
            headerTabelaCorridasParticipando.setBackground(Colors.CINZAMEDB);
            headerTabelaCorridasParticipando.setForeground(Colors.CINZAMEDA);
            headerTabelaTodasAsCorridasMarcadas.setBackground(Colors.CINZAMEDB);
            headerTabelaTodasAsCorridasMarcadas.setForeground(Colors.CINZAMEDA);

        } else {

            fundo.setBackground(Colors.CINZAMEDA);
            drawer.setBackground(Colors.VERDEDARK);
            corridasParticipandoLabel.setForeground(Colors.CINZALIGHTB);
            corridasMarcadasLabel.setForeground(Colors.CINZALIGHTB);
            infoPiloto.setForeground(Colors.CINZALIGHTB);
            btnRelatar.setBackground(Colors.CINZAMEDA);
            btnSair.setBackground(Colors.VERDEDARK);
            btnParticiparCorrida.setBackground(Colors.VERDEDARK);
            btnGerenciarCampeonatos.setBackground(Colors.VERDEDARK);
            btnVerificarCorridas.setBackground(Colors.VERDEDARK);
            btnAvaliarKartdromo.setBackground(Colors.VERDEDARK);
            btnRelatar.setForeground(Colors.CINZAMEDB);
            btnSair.setForeground(Colors.CINZADARKB);
            btnParticiparCorrida.setForeground(Colors.CINZADARKB);
            btnGerenciarCampeonatos.setForeground(Colors.CINZADARKB);
            btnVerificarCorridas.setForeground(Colors.CINZADARKB);
            btnAvaliarKartdromo.setForeground(Colors.CINZADARKB);
            headerTabelaCorridasParticipando.setBackground(Colors.CINZAMEDA);
            headerTabelaCorridasParticipando.setForeground(Colors.CINZAMEDB);
            headerTabelaTodasAsCorridasMarcadas.setBackground(Colors.CINZAMEDA);
            headerTabelaTodasAsCorridasMarcadas.setForeground(Colors.CINZAMEDB);
        }
    }

    private void configs() {

        fundo.setSize(Info.MINSCREENSIZE);
        drawer.setBounds(0, 0, 800, 100);

        tableCorridasParticipando.setModel(new DefaultTableModel(
                new Object[][]{

                },
                new String[]{
                        "CAMPEONATOS PARTICIPANDO", "DATA", "TOTAL DE PARTICIPANTES"
                }
        ) {
            boolean[] canEdit = new boolean[]{
                    false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }

        });

        tabelamento = (DefaultTableModel) tableCorridasParticipando.getModel();

        PilotoParticipandoCampeonatoBO pilotoParticipandoCampeonatoBO = new PilotoParticipandoCampeonatoBO();

        try {
            List<PilotoParticipandoCampeonato> listaCampeonatoDoPiloto = pilotoParticipandoCampeonatoBO.listarTodosPilotosQuePilotoParticipaNoCampeonato(piloto);
            if (listaCampeonatoDoPiloto.isEmpty()) {
                tabelamento.addRow(new Object[]{
                        "Nem uma corrida na lista!"
                });
            } else {
                for (PilotoParticipandoCampeonato list : listaCampeonatoDoPiloto) {
                    List<PilotoParticipandoCampeonato> listaTotalPiloto = pilotoParticipandoCampeonatoBO.listarTodosPilotosQuePilotoParticipaNoCampeonato(list.getCampeonato());
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

        jScrollPaneCorridasParticipando.setViewportView(tableCorridasParticipando);
        jScrollPaneCorridasParticipando.setBounds(20, 300, 760, 200);

        tableTodasAsCorridasMarcadas.setModel(new DefaultTableModel(
                new Object[][]{

                },
                new String[]{
                        "CAMPEONATOS", "DATA", "N° DE PILOTOS "
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
            List<PilotoParticipandoCampeonato> listaCampeonatos = pilotoParticipandoCampeonatoBO.listarTodos();
            if (listaCampeonatos.isEmpty()) {
                tabelamento.addRow(new Object[]{
                        "Nem uma corrida na lista!"
                });
            } else {
                for (PilotoParticipandoCampeonato list : listaCampeonatos) {
                    List<PilotoParticipandoCampeonato> listaTotalPiloto = pilotoParticipandoCampeonatoBO.listarTodosPilotosQuePilotoParticipaNoCampeonato(list.getCampeonato());
                    tabelamento.addRow(new Object[]{
                            list.getCampeonato().getNome(),
                            list.getCampeonato().getDataFinalizacao(),
                            listaTotalPiloto.size()
                    });
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        jScrollPaneCorridasMarcadas.setViewportView(tableTodasAsCorridasMarcadas);
        jScrollPaneCorridasMarcadas.setBounds(200, 130, 580, 140);

        if (piloto.getNivel() < 5) {
            nivel_elo = "PILOTO INICIANTE";
        } else if (piloto.getNivel() < 10) {
            nivel_elo = "PILOTO AVANÇADO";
        } else {
            nivel_elo = "PILOTO VETERANO";
        }
        infoPiloto.setText("<html>NOME: " + piloto.getNomePiloto() + "<br/>"
                + "APELIDO: " + piloto.getApelido() + "<br/>"
                + "NÍVEL: " + piloto.getNivel() + "<br/>"
                + nivel_elo + "<br/>"
                + "NÚMERO DE STRIKERS: " + piloto.getNumeroDeStrikesPiloto()
                + "</html>");
        infoPiloto.setBounds(10, 110, 200, 90);

        corridasParticipandoLabel.setText("CAMPEONATOS QUE VOCÊ ESTÁ PARTICIPANDO");
        corridasParticipandoLabel.setBounds(20, 270, 400, 35);

        corridasMarcadasLabel.setText("TODOS OS CAMPEONATOS CRIADOS");
        corridasMarcadasLabel.setBounds(200, 100, 400, 35);

        btnRelatar.setBorderPainted(false);
        btnRelatar.setFocusPainted(false);
        btnRelatar.addActionListener(this);
        btnRelatar.setBounds(570, 30, 220, 35);
        btnRelatar.setText("Relatar Problema");

        btnSair.setBorderPainted(false);
        btnSair.setFocusPainted(false);
        btnSair.addActionListener(this);
        btnSair.setBounds(20, 555, 100, 35);
        btnSair.setText("Voltar");

        btnParticiparCorrida.setBorderPainted(false);
        btnParticiparCorrida.setFocusPainted(false);
        btnParticiparCorrida.addActionListener(this);
        btnParticiparCorrida.setBounds(535, 555, 250, 35);
        btnParticiparCorrida.setText("Participar de uma Corrida");

        btnVerificarCorridas.setBorderPainted(false);
        btnVerificarCorridas.setFocusPainted(false);
        btnVerificarCorridas.addActionListener(this);
        btnVerificarCorridas.setBounds(315, 510, 200, 35);
        btnVerificarCorridas.setText("Verificar Suas Corridas");

        btnAvaliarKartdromo.setBorderPainted(false);
        btnAvaliarKartdromo.setFocusPainted(false);
        btnAvaliarKartdromo.addActionListener(this);
        btnAvaliarKartdromo.setBounds(315, 555, 200, 35);
        btnAvaliarKartdromo.setText("Avaliar Kartodromo");

        btnGerenciarCampeonatos.setBorderPainted(false);
        btnGerenciarCampeonatos.setFocusPainted(false);
        btnGerenciarCampeonatos.addActionListener(this);
        btnGerenciarCampeonatos.setBounds(535, 510, 250, 35);
        btnGerenciarCampeonatos.setText("Gerenciar Corridas e Campeonatos");

        perfilPilotoLabel.setBounds(20, 30, 500, 35);
        perfilPilotoLabel.setText("PERFIL DO PILOTO");
        perfilPilotoLabel.setFont(Fonts.SANSSERIFMIN);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSair) {
            dispose();
            new MenuPrincipal(piloto);
        }
        if (e.getSource() == btnRelatar) {
            dispose();
            new RelatarPorEmail(piloto);
        }
        if (e.getSource() == btnParticiparCorrida) {
            dispose();
            new ParticiparCorrida(piloto);
        }
        if (e.getSource() == btnGerenciarCampeonatos) {
            dispose();
            new GerenciarCampeonato(piloto);
        }
        if (e.getSource() == btnVerificarCorridas) {
            dispose();
            new VerificarCorrida(piloto);
        }
        if (e.getSource() == btnAvaliarKartdromo) {
            dispose();
            new AvaliarKartodromo(piloto);
        }
    }
} 
