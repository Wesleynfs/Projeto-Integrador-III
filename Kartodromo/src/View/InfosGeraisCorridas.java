package View;

import Bo.CorridaBO;
import Bo.PilotoParticipandoCampeonatoBO;
import Model.Campeonato;
import Model.Corrida;
import Model.Piloto;
import Model.PilotoParticipandoCampeonato;
import Utilities.Colors;
import Utilities.Fonts;
import Utilities.Info;
import Utilities.InformacoesPiloto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class InfosGeraisCorridas extends JFrame implements ActionListener {

    private JPanel fundo;
    private JPanel drawer;
    private JButton btnVoltar;
    private InformacoesPiloto informacoesPiloto;
    private JLabel logo;
    private JLabel corridasgeralLabel;
    private JScrollPane jScrollPaneCorridas;
    private JTable tableTodasAsCorridas;
    private DefaultTableModel tabelamento;

    private Piloto piloto;
    private Campeonato campeonato;

    public InfosGeraisCorridas(Piloto piloto, Campeonato campeonato) {
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
        logo = new JLabel();
        corridasgeralLabel = new JLabel();
        informacoesPiloto = new InformacoesPiloto();
        jScrollPaneCorridas = new JScrollPane();
        tableTodasAsCorridas = new JTable();
    }

    private void add() {
        add(btnVoltar);
        add(logo);
        add(corridasgeralLabel);
        add(jScrollPaneCorridas);
        add(informacoesPiloto);
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
            logo.setForeground(Colors.CINZAMEDB);
            informacoesPiloto.setForeground(Colors.CINZALIGHTB);
            corridasgeralLabel.setForeground(Colors.CINZAMEDA);
            tableTodasAsCorridas.setBackground(Colors.VERDELIGHT);
            tableTodasAsCorridas.setForeground(Colors.CINZADARKB);

        } else {

            fundo.setBackground(Colors.CINZAMEDA);
            drawer.setBackground(Colors.VERDEDARK);

            informacoesPiloto.setForeground(Colors.CINZALIGHTB);
            btnVoltar.setForeground(Colors.CINZADARKB);
            btnVoltar.setBackground(Colors.VERDEDARK);
            logo.setForeground(Colors.CINZAMEDB);
            corridasgeralLabel.setForeground(Colors.CINZALIGHTB);
            tableTodasAsCorridas.setForeground(Colors.CINZADARKB);
            tableTodasAsCorridas.setBackground(Colors.VERDEDARK);

        }
    }

    private void configs() {

        try {

            tableTodasAsCorridas.setModel(new DefaultTableModel(
                    new Object[][]{

                    },
                    new String[]{
                            "CORRIDAS"
                    }
            ) {
                boolean[] canEdit = new boolean[]{
                        false
                };

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit[columnIndex];
                }

            });
            tableTodasAsCorridas.setRowHeight(60);
            
            tabelamento = (DefaultTableModel) tableTodasAsCorridas.getModel();
            
            for(Corrida corridas : new CorridaBO().listarTodasAsCorridasMarcadas(campeonato)){
                tabelamento.addRow(new Object[]{
                                    corridas.toString()
            });
            
            }
            
            fundo.setSize(Info.MINSCREENSIZE);
            drawer.setBounds(0, 0, 800, 100);

            jScrollPaneCorridas.setViewportView(tableTodasAsCorridas);
            jScrollPaneCorridas.setBounds(60, 230, 680, 300);

            informacoesPiloto.setBounds(10, 110, 200, 90);
            informacoesPiloto.setPiloto(piloto);

            btnVoltar.setBorderPainted(false);
            btnVoltar.setFocusPainted(false);
            btnVoltar.addActionListener(this);
            btnVoltar.setBounds(60, 550, 200, 35);
            btnVoltar.setText("Voltar");

            logo.setFont(Fonts.SANSSERIFMIN);
            logo.setBounds(20, 30, 760, 35);
            logo.setText("CORRIDAS DO CAMPEONATO - "+campeonato.getNome());

            corridasgeralLabel.setBounds(60, 200, 300, 30);
            corridasgeralLabel.setText("Tabela com as corridas:");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnVoltar) {
            dispose();
            new CampeonatosParticipanto(piloto);
        }
    }


} 
