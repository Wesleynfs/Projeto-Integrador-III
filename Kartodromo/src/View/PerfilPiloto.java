package View;

import Bo.CampeonatoBO;
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
    private JButton btnCriarCorrida;
    private JButton btnVerificarCorridas;
    private JButton btnAvaliarKartdromo;
    private JLabel numeroVitoriasLabel;
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
        btnCriarCorrida = new JButton();
        btnVerificarCorridas = new JButton();
        btnAvaliarKartdromo = new JButton();
        numeroVitoriasLabel = new JLabel();
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
        add(btnCriarCorrida);
        add(btnVerificarCorridas);
        add(btnAvaliarKartdromo);
        add(numeroVitoriasLabel);
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
        if (LoginFrame.getConfiguracao().isTema()) {
            // Se o tema for escuro, os itens ficam assim //
            fundo.setBackground(Colors.CINZAMEDB);
            drawer.setBackground(Colors.VERDEDARK);
            numeroVitoriasLabel.setForeground(Colors.CINZAMEDA);
            nomePilotoLabel.setForeground(Colors.CINZALIGHTB);
            numeroStrikesLabel.setForeground(Colors.CINZAMEDA);
            corridasParticipandoLabel.setForeground(Colors.CINZALIGHTB);
            corridasMarcadasLabel.setForeground(Colors.CINZALIGHTB);
            btnSair.setForeground(Colors.CINZADARKB);
            btnParticiparCorrida.setForeground(Colors.CINZADARKB);
            btnCriarCorrida.setForeground(Colors.CINZADARKB);
            btnVerificarCorridas.setForeground(Colors.CINZADARKB);
            btnAvaliarKartdromo.setForeground(Colors.CINZADARKB);
            btnRelatar.setForeground(Colors.CINZAMEDA);
            btnRelatar.setBackground(Colors.CINZAMEDB);
            btnSair.setBackground(Colors.VERDEDARK);
            btnParticiparCorrida.setBackground(Colors.VERDEDARK);
            btnCriarCorrida.setBackground(Colors.VERDEDARK);
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
            numeroVitoriasLabel.setForeground(Colors.CINZALIGHTB);
            nomePilotoLabel.setForeground(Colors.CINZALIGHTB);
            numeroStrikesLabel.setForeground(Colors.CINZALIGHTB);
            corridasParticipandoLabel.setForeground(Colors.CINZALIGHTB);
            corridasMarcadasLabel.setForeground(Colors.CINZALIGHTB);
            btnRelatar.setBackground(Colors.CINZAMEDA);
            btnSair.setBackground(Colors.VERDEDARK);
            btnParticiparCorrida.setBackground(Colors.VERDEDARK);
            btnCriarCorrida.setBackground(Colors.VERDEDARK);
            btnVerificarCorridas.setBackground(Colors.VERDEDARK);
            btnAvaliarKartdromo.setBackground(Colors.VERDEDARK);
            btnRelatar.setForeground(Colors.CINZAMEDB);
            btnSair.setForeground(Colors.CINZADARKB);
            btnParticiparCorrida.setForeground(Colors.CINZADARKB);
            btnCriarCorrida.setForeground(Colors.CINZADARKB);
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
                            "CORRIDAS PARTICIPANDO", "DATA", "KARTÓDROMO", "TOTAL DE PARTICIPANTES"
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
            CampeonatoBO campeonatobo = new CampeonatoBO();
            try {
                List<PilotoParticipandoCampeonato> lista_campeonato_do_piloto = campeonatobo.listarPilotoParticipandoCampeonato(piloto);
                System.out.println("2333");
                if (lista_campeonato_do_piloto.size() == 0) {
                    tabelamento.addRow(new Object[]{
                            "Nem uma corrida na lista!"
                    });
                } else {
                    System.out.println("23fdsdfd33");
                    for (PilotoParticipandoCampeonato list : lista_campeonato_do_piloto) {
                        System.out.println("23ddddddddddd33");
                        List<PilotoParticipandoCampeonato> lista_total_piloto = campeonatobo.listarPilotosParticipando(list.getCampeonato());
                        System.out.println("2333ggggggggggggggg");
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
            jScrollPaneCorridasParticipando.setBounds(20, 280, 350, 200);

            tableTodasAsCorridasMarcadas.setModel(new DefaultTableModel(
                    new Object[][]{

                    },
                    new String[]{
                            "TODAS AS CORRIDAS MARCADAS"
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

            /*

            List<Corrida> todasAsCorridasMarcadasList = pilotoParticipandoCampeonatoBO.listarTodasAsCorridasMarcadas(piloto);

            if (todasAsCorridasMarcadasList.size() == 0) {
                tabelamento.addRow(new Object[]{
                        "Nenhuma corrida na marcada!"
                });
            } else {
                for (Corrida corrida : todasAsCorridasMarcadasList) {
                    tabelamento.addRow(new Object[]{
                            corrida.getNumeroDeVoltas(),
                            corrida.getTipoKart(),
                            corrida.getDataCorrida()
                    });
                }
            }

            */

            jScrollPaneCorridasMarcadas.setViewportView(tableTodasAsCorridasMarcadas);
            jScrollPaneCorridasMarcadas.setBounds(420, 170, 350, 200);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

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
        btnParticiparCorrida.setBounds(420, 395, 200, 35);
        btnParticiparCorrida.setText("Participar de uma Corrida");

        btnCriarCorrida.setBorderPainted(false);
        btnCriarCorrida.setFocusPainted(false);
        btnCriarCorrida.addActionListener(this);
        btnCriarCorrida.setBounds(420, 445, 200, 35);
        btnCriarCorrida.setText("Criar nova uma Corrida");

        perfilPilotoLabel.setBounds(20, 30, 500, 35);
        perfilPilotoLabel.setText("PERFIL DO PILOTO");
        perfilPilotoLabel.setFont(Fonts.SANSSERIFMIN);

        nomePilotoLabel.setBounds(20, 110, 500, 35);
        nomePilotoLabel.setText("BEM VINDO: " + piloto.getNomePiloto().toUpperCase());

        numeroVitoriasLabel.setBounds(20, 145, 500, 35);
        numeroVitoriasLabel.setText("VITÓRIAS: " + piloto.getNumeroDeVitoriasPiloto());

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
        if (e.getSource() == btnCriarCorrida) {
            dispose();
            new CriarCorrida(piloto);
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
