package View;

import Bo.CampeonatoBO;
import Bo.ConviteCampeonatoBO;
import Bo.CorridaBO;
import Bo.PilotoBO;
import Bo.PilotoParticipandoCampeonatoBO;
import Bo.PontuacaoPosicaoBO;
import Model.*;
import Utilities.Colors;
import Utilities.Fonts;
import Utilities.Info;
import Utilities.InformacoesPiloto;
import Utilities.TabelaConvidarPilotos;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GerenciarPiloto extends JFrame implements ActionListener {

    private JLabel logo;
    private JLabel ajuda;
    private JLabel infostabelapilotos;
    private JLabel infostabelapilotosconvidados;
    private JPanel fundo;
    private JPanel drawer;
    private JButton btnVoltar;
    private JButton btnFinalizar;
    private Piloto piloto;
    private TabelaConvidarPilotos tabelaConvidarPilotos;
    private TabelaConvidarPilotos tabelaConvidados;
    private JScrollPane jScrollPanePilotosConvidar;
    private JScrollPane jScrollPanePilotosquesaoconvidados;
    private JFormattedTextField apelidoJTextField;
    private JButton btnpesquisaapelido;
    private JButton btnconvidarpiloto;
    private InformacoesPiloto informacoesPiloto;
    private JTable tablepilotosquesaoconvidados;
    private JTable table;
    private Campeonato campeonato;
    private DefaultTableModel tabelamento;
    private List<Corrida> corridaList;
    private List<ConviteCampeonato> convites;

    public GerenciarPiloto(Piloto piloto, Campeonato campeonato, DefaultTableModel tabelamento, List<Corrida> corridaList) {

        this.piloto = piloto;
        this.campeonato = campeonato;
        this.tabelamento = tabelamento;
        this.corridaList = corridaList;
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

    private void add() {
        add(ajuda);
        add(btnVoltar);
        add(informacoesPiloto);
        add(jScrollPanePilotosConvidar);
        add(jScrollPanePilotosquesaoconvidados);
        add(infostabelapilotos);
        add(infostabelapilotosconvidados);
        add(apelidoJTextField);
        add(btnconvidarpiloto);
        add(btnpesquisaapelido);
        add(btnFinalizar);
        add(logo);
        add(drawer);
        add(fundo);
    }

    private void initializate() {

        table = new JTable();
        ajuda = new JLabel();
        jScrollPanePilotosConvidar = new JScrollPane();
        tabelaConvidarPilotos = new TabelaConvidarPilotos();
        tabelaConvidados = new TabelaConvidarPilotos();
        jScrollPanePilotosquesaoconvidados = new JScrollPane();
        apelidoJTextField = new JFormattedTextField();
        tablepilotosquesaoconvidados = new JTable();
        fundo = new JPanel();
        informacoesPiloto = new InformacoesPiloto();
        logo = new JLabel();
        infostabelapilotos = new JLabel();
        infostabelapilotosconvidados = new JLabel();
        drawer = new JPanel();
        btnVoltar = new JButton();
        btnconvidarpiloto = new JButton();
        btnFinalizar = new JButton();
        btnpesquisaapelido = new JButton();
        convites = new ArrayList<>();

    }

    private void setTheme() {

        if (SplashScreen.getConfiguracao().isTema()) {
            // Se o tema for escuro, os itens ficam assim //
            fundo.setBackground(Colors.CINZAMEDB);
            drawer.setBackground(Colors.VERDEDARK);
            logo.setForeground(Colors.CINZAMEDB);
            informacoesPiloto.setForeground(Colors.CINZAMEDB);
            btnVoltar.setBackground(Colors.VERDEDARK);
            btnVoltar.setForeground(Colors.CINZADARKB);
            btnFinalizar.setBackground(Colors.VERDEDARK);
            btnFinalizar.setForeground(Colors.CINZADARKB);
            apelidoJTextField.setBackground(Colors.CINZALIGHTB);
            apelidoJTextField.setForeground(Colors.BRANCO);
            btnpesquisaapelido.setBackground(Colors.VERDEDARK);
            btnpesquisaapelido.setForeground(Colors.CINZADARKB);
            btnconvidarpiloto.setBackground(Colors.VERDEDARK);
            btnconvidarpiloto.setForeground(Colors.CINZADARKB);
            tablepilotosquesaoconvidados.setBackground(Colors.VERDELIGHT);
            tablepilotosquesaoconvidados.setForeground(Colors.CINZADARKB);
            ajuda.setForeground(Colors.BRANCO);
        } else {
            ajuda.setForeground(Colors.CINZAMEDB);
            fundo.setBackground(Colors.CINZAMEDA);
            btnpesquisaapelido.setBackground(Colors.VERDEDARK);
            btnpesquisaapelido.setForeground(Colors.CINZADARKB);
            apelidoJTextField.setBackground(Colors.CINZALIGHTB);
            apelidoJTextField.setForeground(Colors.CINZADARKA);
            btnconvidarpiloto.setBackground(Colors.VERDEDARK);
            btnconvidarpiloto.setForeground(Colors.CINZADARKB);
            tablepilotosquesaoconvidados.setForeground(Colors.CINZADARKB);
            tablepilotosquesaoconvidados.setBackground(Colors.VERDELIGHT);
            informacoesPiloto.setForeground(Colors.BRANCO);
            drawer.setBackground(Colors.VERDEDARK);
            logo.setForeground(Colors.CINZAMEDB);
            btnVoltar.setBackground(Colors.VERDEDARK);
            btnVoltar.setForeground(Colors.CINZADARKB);
            btnFinalizar.setBackground(Colors.VERDEDARK);
            btnFinalizar.setForeground(Colors.CINZADARKB);
        }
    }

    private void configs() {

        fundo.setSize(Info.MINSCREENSIZE);
        drawer.setBounds(0, 0, 800, 100);

        informacoesPiloto.setBounds(620, 3, 180, 100);
        informacoesPiloto.setPiloto(piloto);

        btnVoltar.setText("VOLTAR");
        btnVoltar.setBorderPainted(false);
        btnVoltar.setFocusPainted(false);
        btnVoltar.addActionListener(this);
        btnVoltar.setBounds(20, 550, 100, 35);

        btnFinalizar.setText("FINALIZAR");
        btnFinalizar.setBorderPainted(false);
        btnFinalizar.setFocusPainted(false);
        btnFinalizar.addActionListener(this);
        btnFinalizar.setBounds(680, 550, 100, 35);

        btnpesquisaapelido.setText("PESQUISAR APELIDO");
        btnpesquisaapelido.setBorderPainted(false);
        btnpesquisaapelido.setFocusPainted(false);
        btnpesquisaapelido.addActionListener(this);
        btnpesquisaapelido.setBounds(450, 120, 300, 35);

        btnconvidarpiloto.setText("CONVIDAR PILOTO");
        btnconvidarpiloto.setBorderPainted(false);
        btnconvidarpiloto.setFocusPainted(false);
        btnconvidarpiloto.addActionListener(this);
        btnconvidarpiloto.setBounds(250, 550, 300, 35);

        logo.setBounds(20, 30, 760, 35);
        logo.setText("GERENCIAR PILOTOS - " + campeonato.getNome());
        logo.setFont(Fonts.SANSSERIFMIN);

        ajuda.setBounds(200, 490, 500, 35);
        ajuda.setText("Ao terminar de selecionar os pilotos, clique em 'FINALIZAR' para concluir");

        jScrollPanePilotosConvidar.setViewportView(table);
        jScrollPanePilotosConvidar.setBounds(30, 200, 350, 300);

        jScrollPanePilotosquesaoconvidados.setViewportView(tablepilotosquesaoconvidados);
        jScrollPanePilotosquesaoconvidados.setBounds(410, 200, 350, 300);

        infostabelapilotos.setText("Convidar Pilotos:");
        infostabelapilotos.setBounds(30, 160, 350, 35);

        infostabelapilotosconvidados.setText("Pilotos que foram convidados:");
        infostabelapilotosconvidados.setBounds(410, 160, 350, 35);

        apelidoJTextField.setBorder(BorderFactory.createEmptyBorder());
        apelidoJTextField.setBounds(30, 120, 400, 35);
        apelidoJTextField.setHorizontalAlignment(JPasswordField.CENTER);
        apelidoJTextField.setFocusLostBehavior(JFormattedTextField.PERSIST);

        tablepilotosquesaoconvidados.setModel(tabelaConvidados);
        tablepilotosquesaoconvidados.setRowSelectionAllowed(true);
        tablepilotosquesaoconvidados.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        table.setModel(tabelaConvidarPilotos);
        table.setRowSelectionAllowed(true);
        table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        try {

            for (Piloto pilotos : new PilotoBO().listarTodos()) {
                if (pilotos.getId() != piloto.getId()) {
                    tabelaConvidarPilotos.addRow(pilotos);
                }
            }

        } catch (Exception error) {
            JOptionPane.showMessageDialog(null, "Não foi possível encontrar os piloto para convidar");
        }

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

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnconvidarpiloto) {
            try {

                int[] index = table.getSelectedRows();

                for (int i : index) {

                    Piloto pilotoConvidado = (Piloto) tabelaConvidarPilotos.getPilotoPelaLinha(i);

                    boolean verificacaoDuplicata = true;
                    for (Piloto piloto : tabelaConvidados.getListPiloto()) {
                        if (pilotoConvidado.getApelido().equals(piloto.getApelido())) {
                            verificacaoDuplicata = false;
                            break;
                        }
                    }
                    if (verificacaoDuplicata) {
                        tabelaConvidados.addRow(pilotoConvidado);
                    }
                }
                tablepilotosquesaoconvidados.setModel(tabelaConvidados);
                pesquisaapelido();

            } catch (Exception error) {
                JOptionPane.showMessageDialog(null, "Não foi possível encontrar os piloto para convidar");
            }
        }

        if (e.getSource() == btnpesquisaapelido) {
            pesquisaapelido();
        }

        if (e.getSource() == btnVoltar) {
            dispose();
            new GerenciarCorrida(piloto, campeonato, tabelamento);
        }

        if (e.getSource() == btnFinalizar) {

            try {

                tabelaConvidados.getListPiloto().stream().map((pilotoConvidado) -> {
                    ConviteCampeonato conviteCampeonato = new ConviteCampeonato();
                    conviteCampeonato.setPilotoQueConvidou(piloto);
                    conviteCampeonato.setCampeonato(campeonato);
                    conviteCampeonato.setPilotoConvidado(pilotoConvidado);
                    return conviteCampeonato;
                }).map((conviteCampeonato) -> {
                    conviteCampeonato.setStatusConvite("Não Visualizado");
                    return conviteCampeonato;
                }).forEachOrdered((conviteCampeonato) -> {
                    convites.add(conviteCampeonato);
                });

                if (new CampeonatoBO().validarTelaAdicionarPiloto(convites)) {

                    // Cria um campeonato //

                    try {
                        new CampeonatoBO().criar(campeonato);
                    } catch (Exception err) {
                        JOptionPane.showMessageDialog(null, err.getMessage());
                    }

                    // Cria convites //

                    try {
                        for (ConviteCampeonato conviteCampeonato : convites) {
                            if (new ConviteCampeonatoBO().verificarConviteExistente(conviteCampeonato) == false) {
                                new ConviteCampeonatoBO().criar(conviteCampeonato);
                            }
                        }
                    } catch (Exception err) {
                        JOptionPane.showMessageDialog(null, err.getMessage());
                    }

                    // Cria as posições e pontuações //

                    try {

                        PontuacaoPosicaoBO pontuacaoPosicaoBo = new PontuacaoPosicaoBO();
                        for (int i = 0; tabelamento.getRowCount() > i; i++) {
                            PontuacaoPosicao pontuacaoPosicao = new PontuacaoPosicao();
                            pontuacaoPosicao.setPontuacao(Integer.valueOf(tabelamento.getValueAt(i, 1).toString()));
                            pontuacaoPosicao.setPosicao(Integer.valueOf(tabelamento.getValueAt(i, 0).toString()));
                            pontuacaoPosicao.setCampeonato(campeonato);
                            pontuacaoPosicaoBo.criar(pontuacaoPosicao);
                        }

                    } catch (Exception err) {
                        JOptionPane.showMessageDialog(null,
                                err, "Erro", JOptionPane.PLAIN_MESSAGE);
                    }

                    // Cria as corridas //

                    try {

                        int x = 1;//olá sou eu a gambiarra!
                        CorridaBO corridabo = new CorridaBO();
                        for (Corrida corrida : corridaList) {
                            corrida.setCampeonato(campeonato);
                            corrida.setNomeCorrida(corrida.getNomeCorrida() + " " + x + "°");
                            corridabo.criar(corrida);
                            x++;
                        }

                    } catch (Exception err) {
                        JOptionPane.showMessageDialog(null,
                                err.getMessage(),
                                "Erro", JOptionPane.PLAIN_MESSAGE);
                    }

                    // Cria o piloto que está participando do campeonato //

                    try {
                        PilotoParticipandoCampeonato pilotoadm = new PilotoParticipandoCampeonato();
                        pilotoadm.setPiloto(piloto);
                        pilotoadm.setStatusAdm(true);
                        pilotoadm.setCampeonato(campeonato);
                        pilotoadm.setPontuacao(0);
                        pilotoadm.setPosicao(0);
                        new PilotoParticipandoCampeonatoBO().criar(pilotoadm);
                    } catch (Exception err) {
                        JOptionPane.showMessageDialog(null,
                                err, "Erro", JOptionPane.PLAIN_MESSAGE);
                    }

                    JOptionPane.showMessageDialog(null, "Campeonato Criado com sucesso!", "Sucesso!", JOptionPane.PLAIN_MESSAGE);

                    dispose();
                    new PerfilPiloto(piloto);

                }

            } catch (Exception error) {
                JOptionPane.showMessageDialog(null, error.getMessage());
            }
        }
    }

    public void pesquisaapelido() {
        try {
            tabelaConvidarPilotos = new TabelaConvidarPilotos();
            List<Piloto> pilotos = null;
            if (!apelidoJTextField.getText().equals("")) {
                pilotos = new PilotoBO().listarPilotosPorapelido(this.apelidoJTextField.getText());
            } else {
                pilotos = new PilotoBO().listarTodos();
            }
            for (Piloto pilotopesquisa : pilotos) {
                boolean verificacaoDuplicata = true;
                for (Piloto piloto1 : tabelaConvidados.getListPiloto()) {
                    if (pilotopesquisa.getApelido().equals(piloto1.getApelido())) {
                        verificacaoDuplicata = false;
                    }

                }
                if (verificacaoDuplicata) {
                    if (!pilotopesquisa.getApelido().equals(piloto.getApelido())) {
                        tabelaConvidarPilotos.addRow(pilotopesquisa);
                    }
                }
            }
            table.setModel(tabelaConvidarPilotos);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível fazer a pesquisa");
        }

    }

}