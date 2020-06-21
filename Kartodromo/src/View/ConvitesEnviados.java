package View;

import Bo.CampeonatoBO;
import Bo.ConviteCampeonatoBO;
import Bo.PilotoParticipandoCampeonatoBO;
import Model.Campeonato;
import Model.ConviteCampeonato;
import Model.Piloto;
import Model.PilotoParticipandoCampeonato;
import Utilities.*;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.util.List;

public class ConvitesEnviados extends JFrame implements ActionListener {

    private JPanel fundo;
    private JPanel drawer;
    private JButton btnVoltar;
    private JButton btnListar;
    private JLabel labelConvitesEnviados;
    private JScrollPane jScrollPaneTableConvitesEnviados;
    private JTable tableConvitesEnviados;
    private JComboBox<String> comboBoxCampeonatosPiloto;
    private JComboBox<String> comboBoxPesquisaPorStatusConvite;
    private JLabel labelComboBoxCampeonato;
    private JLabel labelComboBoxStatusConvite;
    private DefaultTableModel tabelamento;
    private DefaultTableCellRenderer defaultTableCellRenderer;
    private InformacoesPiloto informacoesPiloto;

    private Piloto piloto;

    public ConvitesEnviados(Piloto piloto) {

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

    private void initializate() {
        informacoesPiloto = new InformacoesPiloto();
        defaultTableCellRenderer = new DefaultTableCellRenderer();
        fundo = new JPanel();
        drawer = new JPanel();
        btnListar = new JButton();
        labelComboBoxStatusConvite = new JLabel();
        labelComboBoxCampeonato = new JLabel();
        comboBoxPesquisaPorStatusConvite = new JComboBox<>();
        comboBoxCampeonatosPiloto = new JComboBox<>();
        tableConvitesEnviados = new JTable();
        jScrollPaneTableConvitesEnviados = new JScrollPane();
        labelConvitesEnviados = new JLabel();
        btnVoltar = new JButton();
    }

    private void setTheme() {
        if (SplashScreen.getConfiguracao().isTema()) {
            // Se o tema for escuro, os itens ficam assim //
            fundo.setBackground(Colors.CINZAMEDB);
            drawer.setBackground(Colors.VERDEDARK);
            btnListar.setForeground(Colors.CINZADARKB);
            btnListar.setBackground(Colors.VERDEDARK);
            btnVoltar.setForeground(Colors.CINZADARKB);
            btnVoltar.setBackground(Colors.VERDEDARK);
            labelComboBoxCampeonato.setForeground(Colors.BRANCO);
            labelComboBoxStatusConvite.setForeground(Colors.BRANCO);
        } else {
            fundo.setBackground(Colors.CINZAMEDA);
            drawer.setBackground(Colors.VERDEDARK);
            btnListar.setForeground(Colors.CINZADARKB);
            btnListar.setBackground(Colors.VERDEDARK);
            btnVoltar.setForeground(Colors.CINZADARKB);
            btnVoltar.setBackground(Colors.VERDEDARK);
            labelComboBoxStatusConvite.setForeground(Colors.CINZADARKB);
            labelComboBoxCampeonato.setForeground(Colors.CINZADARKB);
        }
    }

    private void add() {
        add(btnListar);
        add(labelComboBoxStatusConvite);
        add(informacoesPiloto);
        add(labelComboBoxCampeonato);
        add(comboBoxPesquisaPorStatusConvite);
        add(comboBoxCampeonatosPiloto);
        add(jScrollPaneTableConvitesEnviados);
        add(labelConvitesEnviados);
        add(btnVoltar);
        add(drawer);
        add(fundo);
    }

    private void configs() {

        fundo.setSize(Info.MINSCREENSIZE);
        drawer.setBounds(0, 0, 800, 100);

        informacoesPiloto.setBounds(600, 3, 200, 100);
        informacoesPiloto.setPiloto(piloto);

        comboBoxCampeonatosPiloto.setBounds(20, 120, 200, 35);

        comboBoxPesquisaPorStatusConvite.setBounds(400, 120, 200, 35);
        comboBoxPesquisaPorStatusConvite.addItem("Não Visualizados");
        comboBoxPesquisaPorStatusConvite.addItem("Visualizados");
        comboBoxPesquisaPorStatusConvite.addItem("Aceitos");
        comboBoxPesquisaPorStatusConvite.addItem("Negados");

        labelComboBoxCampeonato.setBounds(240, 120, 200, 35);
        labelComboBoxCampeonato.setText("Selecione o campeonato");

        labelComboBoxStatusConvite.setBounds(610, 120, 200, 35);
        labelComboBoxStatusConvite.setText("Selecione o status do convite");

        defaultTableCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        tableConvitesEnviados.setDefaultRenderer(String.class, defaultTableCellRenderer);

        tableConvitesEnviados.setModel(new DefaultTableModel(
                new Object[][]{

                },
                new String[]{
                        "PILOTO", "CAMPEONATO", "STATUS DO CONVITE", "ADMINISTRADOR"
                }
        ) {
            boolean[] canEdit = new boolean[]{
                    false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }

        });

        tabelamento = (DefaultTableModel) tableConvitesEnviados.getModel();

        Tabelas.alinharCelulasNoCentro(tableConvitesEnviados);

        popularComboBoxCampeonatos();

        jScrollPaneTableConvitesEnviados.setViewportView(tableConvitesEnviados);
        jScrollPaneTableConvitesEnviados.setBounds(20, 175, 760, 365);

        btnVoltar.setBorderPainted(false);
        btnVoltar.setFocusPainted(false);
        btnVoltar.addActionListener(this);
        btnVoltar.setBounds(20, 555, 150, 35);
        btnVoltar.setText("Voltar");

        btnListar.setBorderPainted(false);
        btnListar.setFocusPainted(false);
        btnListar.addActionListener(this);
        btnListar.setBounds(630, 555, 150, 35);
        btnListar.setText("Listar");

        labelConvitesEnviados.setBounds(20, 30, 500, 35);
        labelConvitesEnviados.setText("CONVITES QUE VOCE JÁ ENVIOU");
        labelConvitesEnviados.setFont(Fonts.SANSSERIFMIN);

    }

    private void popularComboBoxCampeonatos() {

        try {

            List<PilotoParticipandoCampeonato> lista = new PilotoParticipandoCampeonatoBO().listarTodosPilotosQuePilotoParticipaNoCampeonato(piloto);

            if (lista.isEmpty()) {
                comboBoxCampeonatosPiloto.addItem("Voce não criou um campeonato");
            } else {
                for (PilotoParticipandoCampeonato p : lista) {
                    comboBoxCampeonatosPiloto.addItem(p.getCampeonato().getNome());
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    e.getMessage(),
                    "Erro",
                    JOptionPane.PLAIN_MESSAGE);
        }

    }

    private void popularTabelaConvitesEnviados() {
        try {
            List<ConviteCampeonato> listaPilotosConvidados = new ConviteCampeonatoBO().listarConvitesJaEnviadosPeloPiloto(piloto,
                    new CampeonatoBO().getByNomeApenas((String) comboBoxCampeonatosPiloto.getModel().getSelectedItem()),
                    getSelectedStatusConvite(comboBoxPesquisaPorStatusConvite.getModel().getSelectedItem()));
            if (!listaPilotosConvidados.isEmpty()) {
                for (ConviteCampeonato list : listaPilotosConvidados) {
                    tabelamento.addRow(new Object[]{
                            list.getPilotoConvidado().getNome(),
                            list.getCampeonato().getNome(),
                            list.getStatusConvite(),
                            list.getPilotoQueConvidou().getNome()
                    });
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
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
            new PerfilPiloto(piloto);
        }
        if (e.getSource() == btnListar) {
            limparTabela();
            try {
                popularTabelaConvitesEnviados();
            } catch (Exception err) {
                JOptionPane.showMessageDialog(null,
                        err.getMessage(),
                        "Erro",
                        JOptionPane.PLAIN_MESSAGE);
            }
        }
    }

    private void limparTabela() {
        tabelamento.setNumRows(0);
    }

    private static String getSelectedStatusConvite(Object o) {
        String valor = (String) o;
        switch (valor) {
            case "Não Visualizados":
                return "Não Visualizado";
            case "Visualizados":
                return "Visualizado";
            case "Negados":
                return "Negado";
            case "Aceitos":
                return "Aceito";
            default:
                return null;
        }
    }
}
