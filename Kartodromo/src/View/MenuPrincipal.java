package View;

import Bo.CampeonatoBO;
import Bo.CorridaBO;
import Model.Campeonato;
import Model.Corrida;
import Model.Kartodromo;
import Model.Piloto;
import Utilities.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MenuPrincipal extends JFrame implements ActionListener {

    private JPanel panel;
    private JPanel drawer;
    private JPanel background;
    private JPanel selecao;
    private JButton btnPerfilPiloto;
    private JButton btnSair;
    private JButton btnOpcoes;
    private JButton btnInstrucoes;
    private JLabel labelInformacoes;
    private Piloto piloto;
    private Kartodromo kartodromo;
    private JTable tableUltimosCampeonatos;
    private InformacoesPiloto informacoesPiloto;
    private JScrollPane jScrollPaneUltimosCampeonatos;
    private DefaultTableModel tabelamento;
    private JLabel logo;
    private boolean pilotoAvisado;

    public Piloto getPiloto() {
        return piloto;
    }

    public void setPiloto(Piloto piloto) {
        this.piloto = piloto;
    }

    public Kartodromo getKartodromo() {
        return kartodromo;
    }

    public void setKartodromo(Kartodromo kartodromo) {
        this.kartodromo = kartodromo;
    }

    public MenuPrincipal(Piloto piloto, boolean pilotoAvisado) {

        this.piloto = piloto;
        this.pilotoAvisado = pilotoAvisado;

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

    public MenuPrincipal(Piloto piloto) {

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

    public MenuPrincipal(Kartodromo kartodromo) {

        this.kartodromo = kartodromo;

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

    private void add() {
        add(logo);
        add(labelInformacoes);
        add(jScrollPaneUltimosCampeonatos);
        add(btnInstrucoes);
        add(btnOpcoes);
        add(btnSair);
        add(btnPerfilPiloto);
        add(informacoesPiloto);
        add(drawer);
        add(selecao);
        add(panel);
        add(background);
    }

    private void initializate() {
        logo = new JLabel();
        tableUltimosCampeonatos = new JTable();
        labelInformacoes = new JLabel();
        btnInstrucoes = new JButton();
        btnOpcoes = new JButton();
        informacoesPiloto = new InformacoesPiloto();
        btnSair = new JButton();
        btnPerfilPiloto = new JButton();
        drawer = new JPanel();
        selecao = new JPanel();
        panel = new JPanel();
        background = new JPanel();
        jScrollPaneUltimosCampeonatos = new JScrollPane();
    }

    private void configs() {

        logo.setIcon(new ImageIcon(getClass().getResource("/Utilities/imgs/logo.png")));
        logo.setBounds(20, 20, 250, 250);
        logo.setBackground(Colors.CINZALIGHTB);

        tableUltimosCampeonatos.setModel(new DefaultTableModel(
                new Object[][]{

                },
                new String[]{
                        "NOME DO CAMPEONATO",
                        "TIPO DE CAMPEONATO",
                        "TOTAL DE CORRIDAS",
                        "DATA DE CADASTRO",
                        "DATA DE FINALIZAÇÃO"
                }
        ) {
            boolean[] canEdit = new boolean[]{
                    false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }

        });

        for (int x = 0 ; x < 5 ; x++) {
            if (x == 1) {
                tableUltimosCampeonatos.getColumnModel().getColumn(x).setPreferredWidth(300);
            } else {
                tableUltimosCampeonatos.getColumnModel().getColumn(x).setPreferredWidth(190);
            }
        }
        tabelamento = (DefaultTableModel) tableUltimosCampeonatos.getModel();

        try {

            for (Campeonato campeonato : new CampeonatoBO().listarCampeonatosFinalizados()) {
                List<Corrida> listacorrida = new CorridaBO().listarTodasAsCorridasMarcadas(campeonato);

                tabelamento.addRow(new Object[]{
                                campeonato.getNome(),
                                campeonato.getTipoCorrida(),
                                listacorrida.size(),
                                Tempo.dateToPadraoBrasil(campeonato.getDataCadastro()),
                                Tempo.dateToPadraoBrasil(campeonato.getDataInicio())
                        }
                );
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        informacoesPiloto.setFont(Fonts.SANSSERIFMIN20);
        informacoesPiloto.setBounds(20, 270, 250, 250);
        informacoesPiloto.setPiloto(piloto);

        jScrollPaneUltimosCampeonatos.setViewportView(tableUltimosCampeonatos);
        jScrollPaneUltimosCampeonatos.setBounds(300, 80, 980, 640);

        btnOpcoes.setBounds(0, 540, 300, 50);
        btnOpcoes.setBorderPainted(false);
        btnOpcoes.setFocusPainted(false);
        btnOpcoes.setText("Opções");
        btnOpcoes.addActionListener(this);

        btnPerfilPiloto.setBounds(0, 600, 300, 50);
        btnPerfilPiloto.setBorderPainted(false);
        btnPerfilPiloto.setFocusPainted(false);
        btnPerfilPiloto.setText("Perfil Piloto");
        btnPerfilPiloto.addActionListener(this);

        btnSair.setBounds(0, 660, 300, 50);
        btnSair.setBorderPainted(false);
        btnSair.setFocusPainted(false);
        btnSair.setText("Sair");
        btnSair.addActionListener(this);

        btnInstrucoes.setBounds(0, 480, 300, 50);
        btnInstrucoes.setBorderPainted(false);
        btnInstrucoes.setFocusPainted(false);
        btnInstrucoes.setText("Como Usar");
        btnInstrucoes.addActionListener(this);

        labelInformacoes.setBounds(325, 20, 500, 40);
        labelInformacoes.setText("ULTIMOS CAMPEONATOS");
        labelInformacoes.setFont(Fonts.SANSSERIFMIN);

        drawer.setBounds(0, 0, 300, 720);
        panel.setBounds(300, 0, 1180, 80);
        background.setSize(Info.MAXSCREENSIZE);
        selecao.setVisible(false);

    }

    private void setTheme() {

        if (SplashScreen.getConfiguracao().isTema()) {
            // Tema Escuro //
            panel.setBackground(Colors.CINZALIGHTB);
            background.setBackground(Colors.PRETO);
            drawer.setBackground(Colors.VERDEDARK);
            informacoesPiloto.setForeground(Colors.CINZAMEDB);
            btnPerfilPiloto.setBackground(Colors.CINZAMEDB);
            btnPerfilPiloto.setForeground(Colors.CINZAMEDA);
            btnSair.setBackground(Colors.CINZAMEDB);
            btnSair.setForeground(Colors.CINZAMEDA);
            btnOpcoes.setBackground(Colors.CINZAMEDB);
            btnOpcoes.setForeground(Colors.CINZAMEDA);
            btnInstrucoes.setBackground(Colors.CINZAMEDB);
            btnInstrucoes.setForeground(Colors.CINZAMEDA);
            labelInformacoes.setForeground(Colors.CINZAMEDA);
            tableUltimosCampeonatos.setBackground(Colors.VERDELIGHT);
            tableUltimosCampeonatos.setForeground(Colors.CINZADARKB);

        } else {
            // Tema Claro //
            panel.setBackground(Colors.CINZALIGHTB);
            background.setBackground(Colors.CINZAMEDA);
            drawer.setBackground(Colors.VERDEDARK);
            btnPerfilPiloto.setBackground(Colors.CINZAMEDB);
            btnPerfilPiloto.setForeground(Colors.CINZAMEDA);
            btnSair.setBackground(Colors.CINZAMEDB);
            btnSair.setForeground(Colors.CINZAMEDA);
            btnOpcoes.setBackground(Colors.CINZAMEDB);
            informacoesPiloto.setForeground(Colors.BRANCO);
            btnOpcoes.setForeground(Colors.CINZAMEDA);
            btnInstrucoes.setBackground(Colors.CINZAMEDB);
            btnInstrucoes.setForeground(Colors.CINZAMEDA);
            labelInformacoes.setForeground(Colors.CINZAMEDA);
            tableUltimosCampeonatos.setForeground(Colors.CINZADARKB);
            tableUltimosCampeonatos.setBackground(Colors.VERDELIGHT);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnPerfilPiloto) {
            dispose();
            new PerfilPiloto(piloto);
        }
        if (e.getSource() == btnSair) {

            if (JOptionPane.showConfirmDialog(null, "Voce tem certeza?", "Deslogar", JOptionPane.OK_OPTION) == 0) {
                piloto = null;
                kartodromo = null;
                dispose();
                new LoginFrame();
            }

        }
        if (e.getSource() == btnOpcoes) {
            this.setVisible(false);
            new Opcoes(this);
        }
        if (e.getSource() == btnInstrucoes) {
            this.setVisible(false);
            new Tutorial(this);
        }
    }
}
