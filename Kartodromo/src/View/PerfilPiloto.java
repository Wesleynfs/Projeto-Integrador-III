package View;

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
    private JLabel nivelLabel;
    private JLabel nomePilotoLabel;
    private JLabel perfilPilotoLabel;
    private JLabel numeroStrikesLabel;
    private JLabel corridasParticipandoLabel;
    private JLabel corridasMarcadasLabel;
    private JScrollPane jScrollPaneCorridasMarcadas;
    private JTable tableTodasAsCorridasMarcadas;
    private JScrollPane jScrollPaneCorridasParticipando;
    private JTable tableCorridasParticipando;
    private DefaultTableModel tabelamento;
    JTableHeader headerTabelaCorridasParticipando;
    JTableHeader headerTabelaTodasAsCorridasMarcadas;

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
        nivelLabel = new JLabel();
        nomePilotoLabel = new JLabel();
        numeroStrikesLabel = new JLabel();
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
        add(nivelLabel);
        add(perfilPilotoLabel);
        add(nomePilotoLabel);
        add(numeroStrikesLabel);
        add(corridasParticipandoLabel);
        add(corridasMarcadasLabel);
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
            nivelLabel.setForeground(Colors.CINZAMEDA);
            nomePilotoLabel.setForeground(Colors.CINZALIGHTB);
            numeroStrikesLabel.setForeground(Colors.CINZAMEDA);
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
            nomePilotoLabel.setForeground(Colors.CINZAMEDA);

        } else {

            fundo.setBackground(Colors.CINZAMEDA);
            drawer.setBackground(Colors.VERDEDARK);
            nivelLabel.setForeground(Colors.CINZALIGHTB);
            nomePilotoLabel.setForeground(Colors.CINZALIGHTB);
            numeroStrikesLabel.setForeground(Colors.CINZALIGHTB);
            corridasParticipandoLabel.setForeground(Colors.CINZALIGHTB);
            corridasMarcadasLabel.setForeground(Colors.CINZALIGHTB);
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
            nomePilotoLabel.setForeground(Colors.CINZALIGHTB);
        }
    }

    private void configs() {

        fundo.setSize(Info.MINSCREENSIZE);
        drawer.setBounds(0, 0, 800, 100);

        try {

            tableCorridasParticipando.setModel(new DefaultTableModel(
                    new Object[][]{

                    },
                    new String[]{
                            "CAMPEONATOS PARTICIPANDO", "DATA", "KARTÓDROMO", "TOTAL DE PARTICIPANTES"
                    }
            ) {
                boolean[] canEdit = new boolean[]{
                        false, false, false, false
                };

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit[columnIndex];
                }

            });

            tabelamento = (DefaultTableModel) tableCorridasParticipando.getModel();
            PilotoParticipandoCampeonatoDAO pilotoparticipandocampeonatodao = new PilotoParticipandoCampeonatoDAO();
            try {
                List<PilotoParticipandoCampeonato> lista_campeonato_do_piloto = pilotoparticipandocampeonatodao.ListarPilotoqueParticipadeCameponatos(piloto);
                if (lista_campeonato_do_piloto.isEmpty()) {
                    tabelamento.addRow(new Object[]{
                            "Nem uma corrida na lista!"
                    });
                } else {
                    for (PilotoParticipandoCampeonato list : lista_campeonato_do_piloto) {
                        List<PilotoParticipandoCampeonato> lista_total_piloto = pilotoparticipandocampeonatodao.ListarPilotoParticipadeCameponato(list.getCampeonato());
                        tabelamento.addRow(new Object[]{
                                list.getCampeonato().getNome(),
                                list.getCampeonato().getDataFinalizacao(),
                                /*

                                Fazer a converção da data para o dia/mes/ano PT BR

                                */
                                list.getCampeonato().getKartodromo().getNomeKartodromo(),
                                lista_total_piloto.size()
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
                            "CAMPEONATOS", "DATA", "KARTÓDROMO", "TOTAL DE PARTICIPANTES"
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
            pilotoparticipandocampeonatodao = new PilotoParticipandoCampeonatoDAO();
            try {
                List<PilotoParticipandoCampeonato> lista_campeonatos = pilotoparticipandocampeonatodao.listarTodos();
                if (lista_campeonatos.isEmpty()) {
                    tabelamento.addRow(new Object[]{
                            "Nem uma corrida na lista!"
                    });
                } else {
                    for (PilotoParticipandoCampeonato list : lista_campeonatos) {
                        List<PilotoParticipandoCampeonato> lista_total_piloto = pilotoparticipandocampeonatodao.ListarPilotoParticipadeCameponato(list.getCampeonato());
                        tabelamento.addRow(new Object[]{
                                list.getCampeonato().getNome(),
                                list.getCampeonato().getDataFinalizacao(),
                                /*

                                Fazer a converção da data para o dia/mes/ano PT BR

                                */
                                list.getCampeonato().getKartodromo().getNomeKartodromo(),
                                lista_total_piloto.size()
                        });
                    }
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            jScrollPaneCorridasMarcadas.setViewportView(tableTodasAsCorridasMarcadas);
            jScrollPaneCorridasMarcadas.setBounds(200, 130, 580, 140);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

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
        btnSair.setBounds(670, 550, 100, 35);
        btnSair.setText("Voltar");

        btnVerificarCorridas.setBorderPainted(false);
        btnVerificarCorridas.setFocusPainted(false);
        btnVerificarCorridas.addActionListener(this);
        btnVerificarCorridas.setBounds(20, 505, 200, 35);
        btnVerificarCorridas.setText("Verificar Suas Corridas");

        btnAvaliarKartdromo.setBorderPainted(false);
        btnAvaliarKartdromo.setFocusPainted(false);
        btnAvaliarKartdromo.addActionListener(this);
        btnAvaliarKartdromo.setBounds(20, 550, 200, 35);
        btnAvaliarKartdromo.setText("Avaliar Kartodromo");

        btnParticiparCorrida.setBorderPainted(false);
        btnParticiparCorrida.setFocusPainted(false);
        btnParticiparCorrida.addActionListener(this);
        btnParticiparCorrida.setBounds(400, 555, 200, 35);
        btnParticiparCorrida.setText("Participar de uma Corrida");

        btnGerenciarCampeonatos.setBorderPainted(false);
        btnGerenciarCampeonatos.setFocusPainted(false);
        btnGerenciarCampeonatos.addActionListener(this);
        btnGerenciarCampeonatos.setBounds(400, 505, 250, 35);
        btnGerenciarCampeonatos.setText("Gerenciar Corridas e Campeonatos");

        perfilPilotoLabel.setBounds(20, 30, 500, 35);
        perfilPilotoLabel.setText("PERFIL DO PILOTO");
        perfilPilotoLabel.setFont(Fonts.SANSSERIFMIN);

        nomePilotoLabel.setBounds(20, 110, 500, 35);
        nomePilotoLabel.setText("BEM VINDO: " + piloto.getNomePiloto().toUpperCase());

        nivelLabel.setBounds(20, 145, 500, 35);
        nivelLabel.setText("VITÓRIAS: " + piloto.getNumeroDeVitoriasPiloto());

        numeroStrikesLabel.setBounds(20, 180, 500, 35);
        numeroStrikesLabel.setText("STRIKES: " + piloto.getNumeroDeStrikesPiloto());

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
