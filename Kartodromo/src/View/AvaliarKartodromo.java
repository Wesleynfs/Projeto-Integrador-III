package View;

import Bo.AvaliacaoBO;
import Bo.KartodromoBO;
import Model.Avaliacao;
import Model.Kartodromo;
import Model.Piloto;
import Utilities.Colors;

import Utilities.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.event.ChangeEvent;

public class AvaliarKartodromo extends JFrame implements ActionListener {

    private JPanel fundo;
    private JPanel drawer;
    private JTextPane contextojTextPane1;
    private JScrollPane contextojScrollPane;
    private JLabel logo;
    private JLabel nomeKartodromoLabel;
    private JLabel nota;
    private JLabel comentarioLabel;
    private JLabel valorNotaLabel;
    private InformacoesPiloto informacoesPiloto;
    private JSlider notajSlider;
    private JButton btnVoltar;
    private JButton btnEnviar;
    private JButton btnVerPerfil;
    private JLabel estrelasLabel[] = new JLabel[5];
    private JComboBox<String> kartodromojComboBox;
    private Piloto piloto;

    public AvaliarKartodromo(Piloto piloto) {

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
        logo = new JLabel();
        contextojTextPane1 = new JTextPane();
        nomeKartodromoLabel = new JLabel();
        nota = new JLabel();
        informacoesPiloto = new InformacoesPiloto();
        comentarioLabel = new JLabel();
        valorNotaLabel = new JLabel();
        contextojScrollPane = new JScrollPane();
        kartodromojComboBox = new JComboBox();
        notajSlider = new JSlider();
        btnVoltar = new JButton();
        btnEnviar = new JButton();
        btnVerPerfil = new JButton();

        for (int x = 0; x < estrelasLabel.length; x++) {
            estrelasLabel[x] = new JLabel();
            add(estrelasLabel[x]);
        }

    }

    private void add() {

        add(logo);
        add(contextojScrollPane);
        add(nomeKartodromoLabel);
        add(nota);
        add(comentarioLabel);
        add(valorNotaLabel);
        add(informacoesPiloto);
        add(notajSlider);
        add(valorNotaLabel);
        add(kartodromojComboBox);
        add(btnVerPerfil);
        add(btnVoltar);
        add(btnEnviar);
        add(drawer);
        add(fundo);

    }

    private void setTheme() {

        if (SplashScreen.getConfiguracao().isTema()) {
            // Se o tema for escuro, os itens ficam assim 
            fundo.setBackground(Colors.CINZAMEDB);
            drawer.setBackground(Colors.VERDEDARK);
            contextojTextPane1.setBackground(Colors.CINZALIGHTB);
            contextojTextPane1.setForeground(Colors.BRANCO);
            nomeKartodromoLabel.setForeground(Colors.CINZALIGHTB);
            nota.setForeground(Colors.CINZALIGHTB);
            valorNotaLabel.setForeground(Colors.CINZALIGHTB);
            informacoesPiloto.setForeground(Colors.CINZALIGHTB);
            comentarioLabel.setForeground(Colors.CINZALIGHTB);
            logo.setForeground(Colors.CINZAMEDB);
            btnVoltar.setBackground(Colors.VERDEDARK);
            btnVoltar.setForeground(Colors.CINZADARKB);
            btnEnviar.setBackground(Colors.VERDEDARK);
            btnEnviar.setForeground(Colors.CINZADARKB);
            btnVerPerfil.setBackground(Colors.VERDEDARK);
            btnVerPerfil.setForeground(Colors.CINZADARKB);
            kartodromojComboBox.setBackground(Colors.VERDEDARK);
            kartodromojComboBox.setForeground(Colors.CINZADARKB);
        } else {
            fundo.setBackground(Colors.CINZAMEDA);
            drawer.setBackground(Colors.VERDEDARK);
            contextojTextPane1.setBackground(Colors.CINZALIGHTB);
            contextojTextPane1.setForeground(Colors.CINZADARKA);
            nomeKartodromoLabel.setForeground(Colors.CINZALIGHTB);
            valorNotaLabel.setForeground(Colors.CINZALIGHTB);
            comentarioLabel.setForeground(Colors.CINZALIGHTB);
            informacoesPiloto.setForeground(Colors.CINZALIGHTB);
            nota.setForeground(Colors.CINZALIGHTB);
            logo.setForeground(Colors.CINZAMEDB);
            btnVoltar.setBackground(Colors.VERDEDARK);
            btnVoltar.setForeground(Colors.CINZADARKB);
            btnEnviar.setBackground(Colors.VERDEDARK);
            btnEnviar.setForeground(Colors.CINZADARKB);
            btnVerPerfil.setBackground(Colors.VERDEDARK);
            btnVerPerfil.setForeground(Colors.CINZADARKB);
            kartodromojComboBox.setBackground(Colors.VERDEDARK);
            kartodromojComboBox.setForeground(Colors.CINZADARKB);
        }
    }

    private void configs() {

        try {
            fundo.setSize(Info.MINSCREENSIZE);
            drawer.setBounds(0, 0, 800, 100);

            contextojTextPane1.setBorder(BorderFactory.createEmptyBorder());
            contextojTextPane1.setSize(400, 200);

            contextojScrollPane.setBorder(BorderFactory.createEmptyBorder());
            contextojScrollPane.setBounds(360, 150, 400, 200);
            contextojScrollPane.setViewportView(contextojTextPane1);

            informacoesPiloto.setBounds(10, 110, 200, 90);
            informacoesPiloto.setPiloto(piloto);

            nomeKartodromoLabel.setText("NOME DO KARTÓDROMO:");
            nomeKartodromoLabel.setBounds(360, 350, 200, 35);

            valorNotaLabel.setText("MUITO BOM");
            valorNotaLabel.setBounds(100, 290, 200, 35);

            comentarioLabel.setText("SEU COMENTÁRIO:");
            comentarioLabel.setBounds(360, 120, 200, 35);

            nota.setText("<html>Nota que você está atribuindo:</html>");
            nota.setBounds(40, 245, 100, 60);

            estrelasLabel[0].setBounds(130, 275, 16, 16);
            estrelasLabel[1].setBounds(146, 275, 16, 16);
            estrelasLabel[2].setBounds(162, 275, 16, 16);
            estrelasLabel[3].setBounds(178, 275, 16, 16);
            estrelasLabel[4].setBounds(194, 275, 16, 16);

            for (int x = 0; x < estrelasLabel.length - 1; x++) {
                estrelasLabel[x].setIcon(new ImageIcon(getClass().getResource("/Utilities/imgs/star.png")));
            }

            estrelasLabel[4].setIcon(new ImageIcon(getClass().getResource("/Utilities/imgs/award_star_add.png")));
            logo.setBounds(20, 30, 600, 35);
            logo.setText("AVALIAR KARTÓDROMO");
            logo.setFont(Fonts.SANSSERIFMIN);

            notajSlider.setMaximum(5);
            notajSlider.setMinimum(1);
            notajSlider.setOrientation(JSlider.VERTICAL);
            notajSlider.setBounds(60, 300, 30, 200);
            notajSlider.setBackground(Colors.CINZAMEDB);

            kartodromojComboBox.setBorder(BorderFactory.createEmptyBorder());
            kartodromojComboBox.setBounds(360, 380, 200, 35);

            for (Kartodromo tipo : new KartodromoBO().listarTodos()) {
                kartodromojComboBox.addItem(tipo.getNome());
            }

            btnVoltar.setText("VOLTAR");
            btnVoltar.setBorderPainted(false);
            btnVoltar.setFocusPainted(false);
            btnVoltar.addActionListener(this);
            btnVoltar.setBounds(20, 550, 100, 35);

            btnVerPerfil.setText("VER PERFIL DO KARTÓDROMO");
            btnVerPerfil.setBorderPainted(false);
            btnVerPerfil.setFocusPainted(false);
            btnVerPerfil.addActionListener(this);
            btnVerPerfil.setBounds(250, 550, 250, 35);

            btnEnviar.setFocusPainted(false);
            btnEnviar.setBorderPainted(false);
            btnEnviar.addActionListener(this);
            btnEnviar.setText("MANDAR AVALIAÇÃO");
            btnEnviar.setBounds(600, 550, 180, 35);

            notajSlider.addChangeListener(new javax.swing.event.ChangeListener() {
                public void stateChanged(ChangeEvent e) {
                    notajSliderstateChanged(e);
                }
            });

        } catch (Exception error) {
            JOptionPane.showMessageDialog(null, error.getMessage(), "Error:", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void notajSliderstateChanged(ChangeEvent evt) {
        switch (notajSlider.getValue()) {
            case 5:
                estrelasLabel[4].setVisible(true);
                valorNotaLabel.setText("MUITO BOM");
                valorNotaLabel.setBounds(100, 290, 200, 35);
                break;
            case 4:
                estrelasLabel[3].setVisible(true);
                estrelasLabel[4].setVisible(false);
                valorNotaLabel.setText("BOM");
                valorNotaLabel.setBounds(100, 338, 200, 35);
                break;
            case 3:
                estrelasLabel[1].setVisible(true);
                estrelasLabel[2].setVisible(true);
                estrelasLabel[3].setVisible(false);
                valorNotaLabel.setText("MÉDIO");
                valorNotaLabel.setBounds(100, 384, 200, 35);
                break;
            case 2:
                estrelasLabel[0].setIcon(new ImageIcon(getClass().getResource("/Utilities/imgs/star.png")));
                estrelasLabel[1].setVisible(true);
                estrelasLabel[2].setVisible(false);
                valorNotaLabel.setText("RUIM");
                valorNotaLabel.setBounds(100, 430, 200, 35);
                break;
            default:
                estrelasLabel[0].setIcon(new ImageIcon(getClass().getResource("/Utilities/imgs/award_star_delete.png")));
                estrelasLabel[1].setVisible(false);
                estrelasLabel[2].setVisible(false);
                valorNotaLabel.setText("MUITO RUIM");
                valorNotaLabel.setBounds(100, 478, 200, 35);
                break;
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnVoltar) {
            dispose();
            new PerfilPiloto(piloto);
        }

        if (e.getSource() == btnEnviar) {

            try {

                Avaliacao avaliacao = new Avaliacao();
                avaliacao.setComentario(contextojTextPane1.getText());
                avaliacao.setNumeroEstrelas(this.notajSlider.getValue());
                avaliacao.setKartodromo(new KartodromoBO().getById(kartodromojComboBox.getSelectedIndex() + 1));
                avaliacao.setPiloto(piloto);

                AvaliacaoBO avaliacaoBo = new AvaliacaoBO();
                for (Avaliacao avalia : avaliacaoBo.listarTodos()) {
                    if (avalia.getKartodromo().getId() == avaliacao.getKartodromo().getId()
                            && avalia.getPiloto().getId() == avaliacao.getPiloto().getId()) {
                        if (JOptionPane.showConfirmDialog(null,
                                "Você já fez uma avaliação anteriormente,"
                                        + " deseja altera-lá para sua avaliação atual?",
                                "Substituir?", JOptionPane.YES_NO_OPTION) == 0) {
                            avaliacao.setIdAvaliacao(avalia.getIdAvaliacao());
                            avaliacaoBo.alterar(avaliacao);
                        }
                    }
                }

                if (avaliacaoBo.criar(avaliacao)) {
                    JOptionPane.showMessageDialog(null, "SUA AVALIAÇÃO FOI FEITA COM SUCESSO!");
                }

            } catch (Exception error) {
                JOptionPane.showMessageDialog(null, "Não foi possível enviar sua avaliação");
            }

        }

        if (e.getSource() == btnVerPerfil) {
            System.out.println("AQUI " + (String) kartodromojComboBox.getSelectedItem());
            try {
                dispose();
                new AvaliacoesDeKartodromo(piloto, new KartodromoBO().getByName((String) kartodromojComboBox.getSelectedItem()));
            } catch (Exception error) {
                JOptionPane.showMessageDialog(null, "Você não selecionou nenhum kartódromo!");
            }
        }
    }
}
