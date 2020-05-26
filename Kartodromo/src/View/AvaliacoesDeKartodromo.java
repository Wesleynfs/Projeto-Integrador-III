package View;

import Bo.AvaliacaoBO;
import Model.Avaliacao;
import Model.Kartodromo;
import Model.Piloto;
import Utilities.Colors;
import Utilities.Fonts;
import Utilities.Info;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.Key;
import java.util.*;
import javax.swing.table.DefaultTableModel;

public class AvaliacoesDeKartodromo extends JFrame implements ActionListener {

    private JPanel fundo;
    private JPanel drawer;
    private JButton btnVoltar;
    private JLabel logo;
    private JLabel avaliacoesLabel;
    private JLabel MediaLabel;
    private JScrollPane jScrollPanekartodromo;
    private JTable tableKartodromo;
    private DefaultTableModel tabelamento;

    private Piloto piloto;
    private Kartodromo kartodromo;

    public AvaliacoesDeKartodromo(Piloto piloto, Kartodromo kartodromo) throws Exception {
        this.piloto = piloto;
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
        avaliacoesLabel = new JLabel();
        MediaLabel = new JLabel();

        jScrollPanekartodromo = new JScrollPane();
        tableKartodromo = new JTable();

    }

    private void add() {
        add(btnVoltar);
        add(avaliacoesLabel);
        add(MediaLabel);
        add(logo);
        add(jScrollPanekartodromo);
        add(drawer);
        add(fundo);
    }

    private void setTheme() {
        if (SplashScreen.getConfiguracao().isTema()) {
            // Se o tema for escuro, os itens ficam assim //
            fundo.setBackground(Colors.CINZAMEDB);
            drawer.setBackground(Colors.VERDEDARK);

            logo.setForeground(Colors.CINZAMEDB);
            tableKartodromo.setBackground(Colors.VERDELIGHT);
            tableKartodromo.setForeground(Colors.CINZADARKB);
            MediaLabel.setForeground(Colors.CINZAMEDA);
            avaliacoesLabel.setForeground(Colors.CINZAMEDA);
            btnVoltar.setForeground(Colors.CINZADARKB);
            btnVoltar.setBackground(Colors.VERDEDARK);

        } else {

            fundo.setBackground(Colors.CINZAMEDA);
            drawer.setBackground(Colors.VERDEDARK);
            logo.setForeground(Colors.CINZAMEDB);
            tableKartodromo.setForeground(Colors.CINZADARKB);
            tableKartodromo.setBackground(Colors.VERDEDARK);
            MediaLabel.setForeground(Colors.CINZALIGHTB);
            avaliacoesLabel.setForeground(Colors.CINZALIGHTB);
            btnVoltar.setForeground(Colors.CINZADARKB);
            btnVoltar.setBackground(Colors.VERDEDARK);

        }
    }

    private void configs() throws Exception {

        fundo.setSize(Info.MINSCREENSIZE);
        drawer.setBounds(0, 0, 800, 100);


        tableKartodromo.setModel(new DefaultTableModel(
                new Object[][]{

                },
                new String[]{
                        "NOME DO PILOTO", "COMENTÁRIOS", "AVALIAÇÃO"
                }
        ) {
            boolean[] canEdit = new boolean[]{
                    false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }

        });


        tabelamento = (DefaultTableModel) tableKartodromo.getModel();

        HashMap<String, Integer> mapa = new HashMap<>();

        int muitoRuim = 0;
        int ruim = 0;
        int media = 0;
        int boa = 0;
        int muitoBoa = 0;

        String aval = null;

        try {

            for (Avaliacao avaliacao : new AvaliacaoBO().listarPorKartodromo(kartodromo)) {

                switch (avaliacao.getNumeroEstrelas()) {
                    case 1:
                        muitoRuim++;
                        aval = "Muito Ruim";
                        break;
                    case 2:
                        ruim++;
                        aval = "Ruim";
                        break;
                    case 3:
                        media++;
                        aval = "Médio";
                        break;
                    case 4:
                        boa++;
                        aval = "Bom";
                        break;
                    case 5:
                        muitoBoa++;
                        aval = "Muito Bom";
                        break;
                }

                tabelamento.addRow(new Object[]{
                        avaliacao.getPiloto().getNomePiloto(),
                        avaliacao.getComentario(),
                        aval
                });

            }

        } catch (Exception error) {
            JOptionPane.showMessageDialog(null, "Erro ao visualizar avaliações " + error.getMessage(), "Error:", JOptionPane.ERROR_MESSAGE);
        }

        mapa.put("Muito Ruim", muitoRuim);
        mapa.put("Ruim", ruim);
        mapa.put("Media", media);
        mapa.put("Boa", boa);
        mapa.put("Muito Boa", muitoBoa);

        // Caso o mapa esteja vazio //
        if (mapa.values().stream().distinct().count() == 0) {
            mapa.put("Media", 1);
        }

        jScrollPanekartodromo.setViewportView(tableKartodromo);
        jScrollPanekartodromo.setBounds(60, 150, 680, 300);

        logo.setFont(Fonts.SANSSERIFMIN);
        logo.setBounds(20, 30, 500, 35);
        logo.setText("PERFIL DO KARTÓDROMO");

        avaliacoesLabel.setBounds(300, 120, 300, 35);
        avaliacoesLabel.setText("Avaliações do Kartódromo: " + kartodromo.getNomeKartodromo());

        // AQUI COLOCA O NOME DA CORRIDA //

        MediaLabel.setBounds(320, 480, 300, 35);

        // Pega do mapa a chave que contém o maior valor //
        MediaLabel.setText("MÉDIA DE AVALIAÇÃO: " + Collections.max(mapa.entrySet(),
                Map.Entry.comparingByValue())
                .getKey()
                .toUpperCase());

        // AQUI COLOCA O NOME DO PRIMEIRO COLOCADO DA CORRIDA //


        btnVoltar.setBorderPainted(false);
        btnVoltar.setFocusPainted(false);
        btnVoltar.addActionListener(this);
        btnVoltar.setBounds(320, 540, 200, 35);
        btnVoltar.setText("VOLTAR");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnVoltar) {
            dispose();
            new AvaliarKartodromo(piloto);
        }

    }


} 
