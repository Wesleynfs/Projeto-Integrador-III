
package View;

import Bo.AvaliacaoBO;
import Bo.KartodromoBO;
import Model.Avaliacao;
import Model.Kartodromo;
import Utilities.Colors;
import Utilities.Fonts;
import Utilities.Info;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class PerfilKartodromo extends JFrame implements ActionListener {

    private JPanel fundo;
    private JPanel drawer;

    private JLabel version;
    private JLabel logo;
    private JLabel diassemanaLabel;
    private JLabel tipokartsLabel;
    private JButton btn_Voltar;
    private JButton btnMudar;

    private Kartodromo kartodromo;

    private JCheckBox[] listCheckBox;
    
    private JLabel avaliacoesLabel;
    private JLabel MediaLabel;
    private JScrollPane jScrollPanekartodromo;
    private JTable tableKartodromo;
    private DefaultTableModel tabelamento;


    public PerfilKartodromo(Kartodromo kartodromo) {
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
        version = new JLabel();
        logo = new JLabel();
        diassemanaLabel = new JLabel();
        tipokartsLabel = new JLabel();
        btn_Voltar = new JButton();
        btnMudar = new JButton();
        listCheckBox = new JCheckBox[12];
        avaliacoesLabel = new JLabel();
        MediaLabel = new JLabel();

        jScrollPanekartodromo = new JScrollPane();
        tableKartodromo = new JTable();
        for (int x = 0 ; x < listCheckBox.length ; x++) {
            listCheckBox[x] = new JCheckBox();
        }

    }

    private void add() {

        for (JCheckBox checkBox : listCheckBox) {
            add(checkBox);
        }
        add(avaliacoesLabel);
        add(MediaLabel);
        add(jScrollPanekartodromo);
        add(diassemanaLabel);
        add(tipokartsLabel);
        add(version);
        add(logo);
        add(btnMudar);
        add(btn_Voltar);
        add(drawer);
        add(fundo);
    }

    private void setTheme() {

        if (SplashScreen.getConfiguracao().isTema()) {
            // Se o tema for escuro, os itens ficam assim //
            tipokartsLabel.setForeground(Colors.CINZALIGHTB);
            diassemanaLabel.setForeground(Colors.CINZALIGHTB);
            version.setForeground(Colors.CINZALIGHTB);
            logo.setForeground(Colors.CINZAMEDB);
            btn_Voltar.setBackground(Colors.VERDEDARK);
            btn_Voltar.setForeground(Colors.CINZADARKB);
            btnMudar.setBackground(Colors.VERDEDARK);
            btnMudar.setForeground(Colors.CINZADARKB);
            fundo.setBackground(Colors.CINZAMEDB);
            drawer.setBackground(Colors.VERDEDARK);
            tableKartodromo.setBackground(Colors.VERDELIGHT);
            tableKartodromo.setForeground(Colors.CINZADARKB);
            MediaLabel.setForeground(Colors.CINZAMEDA);
            avaliacoesLabel.setForeground(Colors.CINZAMEDA);
            for (JCheckBox checkBox : listCheckBox) {
                checkBox.setForeground(Colors.BRANCO);
                checkBox.setBackground(Colors.CINZALIGHTB);
            }

        } else {
            tableKartodromo.setForeground(Colors.CINZADARKB);
            tableKartodromo.setBackground(Colors.VERDEDARK);
            MediaLabel.setForeground(Colors.CINZALIGHTB);
            avaliacoesLabel.setForeground(Colors.CINZALIGHTB);
            tipokartsLabel.setForeground(Colors.CINZALIGHTB);
            diassemanaLabel.setForeground(Colors.CINZALIGHTB);
            version.setForeground(Colors.CINZALIGHTB);
            logo.setForeground(Colors.CINZAMEDB);
            btn_Voltar.setBackground(Colors.VERDEDARK);
            btn_Voltar.setForeground(Colors.CINZADARKB);
            btnMudar.setBackground(Colors.VERDEDARK);
            btnMudar.setForeground(Colors.CINZADARKB);
            fundo.setBackground(Colors.CINZAMEDA);
            drawer.setBackground(Colors.VERDEDARK);

            for (JCheckBox checkBox : listCheckBox) {
                checkBox.setForeground(Colors.BRANCO);
                checkBox.setBackground(Colors.CINZALIGHTB);
            }
        }
    }

    private void configs() {
        try {
            fundo.setSize(Info.MINSCREENSIZE);
            drawer.setBounds(0, 0, 800, 200);
            diassemanaLabel.setText("Dias de Funcionamento:");
            diassemanaLabel.setBounds(20, 230, 150, 35);
            tipokartsLabel.setText("Tipos de Kart (MOTOR)");
            tipokartsLabel.setBounds(210, 230, 150, 35);

            for (int x = 0; x < listCheckBox.length; x++) {
                if (x == 0) {
                    listCheckBox[0].setText("Domingo");
                    listCheckBox[0].setBounds(20, 260, 150, 30);
 
                }
                if (x == 1) {
                    listCheckBox[1].setText("Sabado");
                    listCheckBox[1].setBounds(20, 290, 150, 30);
                }
                if (x == 2) {
                    listCheckBox[2].setText("Segunda Feira");
                    listCheckBox[2].setBounds(20, 320, 150, 30);
                }
                if (x == 3) {
                    listCheckBox[3].setText("Terça Feira");
                    listCheckBox[3].setBounds(20, 350, 150, 30);
                }
                if (x == 4) {
                    listCheckBox[4].setText("Quarta Feira");
                    listCheckBox[4].setBounds(20, 380, 150, 30);
                }
                if (x == 5) {
                    listCheckBox[5].setText("Quinta Feira");
                    listCheckBox[5].setBounds(20, 410, 150, 30);
                }
                if (x == 6) {
                    listCheckBox[6].setText("Sexta Feira");
                    listCheckBox[6].setBounds(20, 440, 150, 30);
                }
                if (x == 7) {
                    listCheckBox[7].setText("INDOOR");
                    listCheckBox[7].setBounds(210, 260, 150, 35);
                }
                if (x == 8) {
                    listCheckBox[8].setText("MOTOR 2 TEMPOS");
                    listCheckBox[8].setBounds(210, 290, 150, 35);
                }
                if (x == 9) {
                    listCheckBox[9].setText("MOTOR 4 TEMPOS");
                    listCheckBox[9].setBounds(210, 320, 150, 35);
                }
                if (x == 10) {
                    listCheckBox[10].setText("SHIFTER");
                    listCheckBox[10].setBounds(210, 380, 150, 35);
                }
                if (x == 11) {
                    listCheckBox[11].setText("SEM MARCHA");
                    listCheckBox[11].setBounds(210, 350, 150, 35);
                }
                listCheckBox[x].setFocusPainted(false);
            }
            version.setText(Info.APP_VERSION);
            version.setBounds(20, 10, 100, 30);

            logo.setText(Info.APP_NAME);
            logo.setFont(Fonts.SANSSERIF);
            logo.setBounds(20, 40, 700, 180);

            btn_Voltar.setText("VOLTAR");
            btn_Voltar.setBorderPainted(false);
            btn_Voltar.setFocusPainted(false);
            btn_Voltar.addActionListener(this);
            btn_Voltar.setBounds(20, 550, 100, 35);

            btnMudar.setFocusPainted(false);
            btnMudar.setBorderPainted(false);
            btnMudar.addActionListener(this);
            btnMudar.setText("Alterar");
            btnMudar.setBounds(620, 550, 160, 35);
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
        jScrollPanekartodromo.setBounds(400, 260, 380, 240);

        logo.setFont(Fonts.SANSSERIFMIN);
        logo.setBounds(20, 30, 500, 35);
        logo.setText("PERFIL DO KARTÓDROMO");

        avaliacoesLabel.setBounds(400, 230, 300, 35);
        avaliacoesLabel.setText("Avaliações do Kartódromo: " + kartodromo.getNomeKartodromo());

        // AQUI COLOCA O NOME DA CORRIDA //

        MediaLabel.setBounds(400, 500, 300, 35);

        // Pega do mapa a chave que contém o maior valor //
        MediaLabel.setText("MÉDIA DE AVALIAÇÃO: " + Collections.max(mapa.entrySet(),
                Map.Entry.comparingByValue())
                .getKey()
                .toUpperCase());

        } catch (Exception error) {
            JOptionPane.showMessageDialog(null, "Erro ao visualizar avaliações " + error.getMessage(), "Error:", JOptionPane.ERROR_MESSAGE);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btn_Voltar) {
            if (JOptionPane.showConfirmDialog(null, "Tem certeza?", "Confirmação", JOptionPane.YES_NO_OPTION) == 0) {
                dispose();
                new LoginFrame();
            }
        }

        if (e.getSource() == btnMudar) {

            kartodromo.setDiaEmAtividadeDomingo(listCheckBox[0].isSelected());
            kartodromo.setDiaEmAtividadeSabado(listCheckBox[1].isSelected());
            kartodromo.setDiaEmAtividadeSegunda(listCheckBox[2].isSelected());
            kartodromo.setDiaEmAtividadeTerca(listCheckBox[3].isSelected());
            kartodromo.setDiaEmAtividadeQuarta(listCheckBox[4].isSelected());
            kartodromo.setDiaEmAtividadeQuinta(listCheckBox[5].isSelected());
            kartodromo.setDiaEmAtividadeSexta(listCheckBox[6].isSelected());

            kartodromo.setKartIndoor(listCheckBox[7].isSelected());
            kartodromo.setKartMotor2Tempos(listCheckBox[8].isSelected());
            kartodromo.setKartMotor4Tempos(listCheckBox[9].isSelected());
            kartodromo.setKartShifter(listCheckBox[10].isSelected());
            kartodromo.setKartSemMarcha(listCheckBox[11].isSelected());

            kartodromo.setStatusAtividade(true);

            KartodromoBO kartodromoBO = new KartodromoBO();
            try {
                if (kartodromoBO.alterar(kartodromo)) {
                    JOptionPane.showConfirmDialog(null,"Kartódromo alterado com sucesso!","Sucesso",JOptionPane.PLAIN_MESSAGE);
                } else {
                    JOptionPane.showConfirmDialog(null,"Erro ao criar kartodromo, contate aos desenvolvedores", "Erro",JOptionPane.PLAIN_MESSAGE);
                }
            } catch (Exception error) {
                JOptionPane.showConfirmDialog(null,
                        error.getMessage(),
                        "Erro" ,
                        JOptionPane.PLAIN_MESSAGE);
            }

        }
    }

}