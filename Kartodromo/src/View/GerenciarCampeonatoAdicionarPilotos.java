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
import Utilities.TabelaConvidarPilotos;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class GerenciarCampeonatoAdicionarPilotos extends JFrame implements ActionListener {

    private JLabel logo;
    private JLabel ajuda;
    private JPanel fundo;
    private JPanel drawer;
    private JButton btnVoltar;
    private JButton btnFinalizar;
    private JFrame retornarPara;
    private Piloto piloto;
    private TabelaConvidarPilotos tabelaConvidarPilotos;
    private JScrollPane jScrollPane;
    private JTable table;
    private Campeonato campeonato;
    private DefaultTableModel tabelamento;
    private List<Corrida> corridaList;
    private List<ConviteCampeonato> convites;

    public GerenciarCampeonatoAdicionarPilotos(JFrame retornarPara, Piloto piloto, Campeonato campeonato, DefaultTableModel tabelamento, List<Corrida> corridaList) {

        this.retornarPara = retornarPara;
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
        add(jScrollPane);
        add(btnFinalizar);
        add(logo);
        add(drawer);
        add(fundo);
    }

    private void initializate() {

        table = new JTable();
        ajuda = new JLabel();
        jScrollPane = new JScrollPane();
        tabelaConvidarPilotos = new TabelaConvidarPilotos();
        fundo = new JPanel();
        logo = new JLabel();
        drawer = new JPanel();
        btnVoltar = new JButton();
        btnFinalizar = new JButton();
        convites = new ArrayList<>();

    }

    private void setTheme() {

        if (SplashScreen.getConfiguracao().isTema()) {
            // Se o tema for escuro, os itens ficam assim //
            fundo.setBackground(Colors.CINZAMEDB);
            drawer.setBackground(Colors.VERDEDARK);
            logo.setForeground(Colors.CINZAMEDB);
            btnVoltar.setBackground(Colors.VERDEDARK);
            btnVoltar.setForeground(Colors.CINZADARKB);
            btnFinalizar.setBackground(Colors.VERDEDARK);
            btnFinalizar.setForeground(Colors.CINZADARKB);
            ajuda.setForeground(Colors.BRANCO);
        } else {
            ajuda.setForeground(Colors.CINZAMEDB);
            fundo.setBackground(Colors.CINZAMEDA);
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

        logo.setBounds(20, 30, 700, 35);
        logo.setText("GERENCIAR PILOTOS");
        logo.setFont(Fonts.SANSSERIFMIN);

        ajuda.setBounds(200,450,500,35);
        ajuda.setText("Ao terminar de selecionar os pilotos, clique em 'FINALIZAR' para concluir");

        jScrollPane.setViewportView(table);
        jScrollPane.setBounds(30, 150, 740, 300);

        table.setModel(tabelaConvidarPilotos);
        table.setRowSelectionAllowed(true);
        table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        try {

            for (Piloto pilotos : new PilotoBO().listarTodos()) {
                if (pilotos.getIdPiloto() != piloto.getIdPiloto()) {
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

        if (e.getSource() == btnVoltar) {
            dispose();
            this.retornarPara.setVisible(true);
        }

        if (e.getSource() == btnFinalizar) {

            criarConvites();

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

                for (Corrida corrida : corridaList) {
                    System.out.println(corrida.toString());
                }

                CorridaBO corridabo = new CorridaBO();
                for (Corrida corrida : corridaList) {
                    corrida.setCampeonato(campeonato);
                    corridabo.criar(corrida);
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

            retornarPara.dispose();
            dispose();
            new PerfilPiloto(piloto);
        }
    }

    private void criarConvites() {
        try {

            int[] index = table.getSelectedRows();

            for (int x = 0; x < index.length; x++) {

                Piloto pilotoConvidado = new PilotoBO().listarPorPiloto((Piloto) tabelaConvidarPilotos.getPilotoPelaLinha(index[x]));
                ConviteCampeonato conviteCampeonato = new ConviteCampeonato();
                conviteCampeonato.setPilotoQueConvidou(piloto);
                conviteCampeonato.setCampeonato(campeonato);
                conviteCampeonato.setPilotoConvidado(pilotoConvidado);
                conviteCampeonato.setStatusConvite("Não respondido");
                convites.add(conviteCampeonato);

            }

            JOptionPane.showMessageDialog(null, "Convites enviados a todos os pilotos selecionados!");

        } catch (Exception error) {
            JOptionPane.showMessageDialog(null, "Não foi possível enviar o convite aos pilotos");
        }
    }

}