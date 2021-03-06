package View;

import Bo.AvisoCampeonatoBO;
import Bo.PilotoParticipandoCampeonatoBO;
import Model.AvisoCampeonato;
import Model.Campeonato;
import Model.Piloto;
import Model.PilotoParticipandoCampeonato;
import Utilities.Colors;

import Utilities.Fonts;
import Utilities.Info;
import Utilities.InformacoesPiloto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class EnviarAviso extends JFrame implements ActionListener {

    private JPanel fundo;
    private JPanel drawer;
    private JFormattedTextField assuntoTextField;
    private JTextPane contextojTextPane1;
    private JLabel logo;
    private JLabel relatoLabel;
    private JLabel assuntoLabel;
    private JLabel contextoLabel;
    private JScrollPane contextojScrollPane;
    private JButton btnVoltar;
    private JButton btnEnviar;
    private InformacoesPiloto informacoesPiloto;
    private Campeonato campeonato;
    private Piloto piloto;

    public EnviarAviso(Piloto piloto, Campeonato campeonato) {
        this.campeonato = campeonato;
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
        assuntoTextField = new JFormattedTextField();
        contextojTextPane1 = new JTextPane();
        relatoLabel = new JLabel();
        assuntoLabel = new JLabel();
        contextoLabel = new JLabel();
        informacoesPiloto = new InformacoesPiloto();
        contextojScrollPane = new JScrollPane();
        btnVoltar = new JButton();
        btnEnviar = new JButton();

    }

    private void add() {
        add(logo);
        add(assuntoTextField);
        add(contextojScrollPane);
        add(informacoesPiloto);
        add(relatoLabel);
        add(assuntoLabel);
        add(contextoLabel);
        add(btnVoltar);
        add(btnEnviar);
        add(drawer);
        add(fundo);
    }

    private void setTheme() {
        if (SplashScreen.getConfiguracao().isTema()) {
            // Se o tema for escuro, os itens ficam assim //
            fundo.setBackground(Colors.CINZAMEDB);
            drawer.setBackground(Colors.VERDEDARK);
            informacoesPiloto.setForeground(Colors.CINZALIGHTB);
            assuntoTextField.setBackground(Colors.CINZALIGHTB);
            assuntoTextField.setForeground(Colors.BRANCO);
            contextojTextPane1.setBackground(Colors.CINZALIGHTB);
            contextojTextPane1.setForeground(Colors.BRANCO);
            relatoLabel.setForeground(Colors.CINZALIGHTB);
            assuntoLabel.setForeground(Colors.CINZALIGHTB);
            contextoLabel.setForeground(Colors.CINZALIGHTB);
            logo.setForeground(Colors.CINZAMEDB);
            btnVoltar.setBackground(Colors.VERDEDARK);
            btnVoltar.setForeground(Colors.CINZADARKB);
            btnEnviar.setBackground(Colors.VERDEDARK);
            btnEnviar.setForeground(Colors.CINZADARKB);
        } else {
            fundo.setBackground(Colors.CINZAMEDA);
            drawer.setBackground(Colors.VERDEDARK);
            contextojTextPane1.setBackground(Colors.CINZALIGHTB);
            contextojTextPane1.setForeground(Colors.CINZADARKA);
            assuntoTextField.setBackground(Colors.CINZALIGHTB);
            informacoesPiloto.setForeground(Colors.CINZALIGHTB);
            assuntoTextField.setForeground(Colors.CINZADARKA);
            relatoLabel.setForeground(Colors.CINZALIGHTB);
            assuntoLabel.setForeground(Colors.CINZALIGHTB);
            contextoLabel.setForeground(Colors.CINZALIGHTB);
            logo.setForeground(Colors.CINZAMEDB);
            btnVoltar.setBackground(Colors.VERDEDARK);
            btnVoltar.setForeground(Colors.CINZADARKB);
            btnEnviar.setBackground(Colors.VERDEDARK);
            btnEnviar.setForeground(Colors.CINZADARKB);
        }
    }

    private void configs() {

        fundo.setSize(Info.MINSCREENSIZE);
        drawer.setBounds(0, 0, 800, 100);

        relatoLabel.setText("AVISO DO PILOTO ADM: "+piloto.getApelido());
        relatoLabel.setBounds(280, 150, 300, 35);

        contextojScrollPane.setBorder(BorderFactory.createEmptyBorder());
        contextojScrollPane.setBounds(200, 280, 400, 240);
        contextojScrollPane.setViewportView(contextojTextPane1);

        assuntoLabel.setText("AVISO DO CAMPEONATO: "+campeonato.getNome());
        assuntoLabel.setBounds(280, 200, 300, 35);

        contextoLabel.setText("CONTEXTO DO AVISO:");
        contextoLabel.setBounds(200, 250, 300, 35);

        informacoesPiloto.setBounds(10, 110, 200, 90);
        informacoesPiloto.setPiloto(piloto);

        logo.setBounds(20, 30, 600, 35);
        logo.setText("ENVIAR AVISO AOS PILOTOS");
        logo.setFont(Fonts.SANSSERIFMIN);

        btnVoltar.setText("VOLTAR");
        btnVoltar.setBorderPainted(false);
        btnVoltar.setFocusPainted(false);
        btnVoltar.addActionListener(this);
        btnVoltar.setBounds(20, 550, 100, 35);

        btnEnviar.setFocusPainted(false);
        btnEnviar.setBorderPainted(false);
        btnEnviar.addActionListener(this);
        btnEnviar.setText("ENVIAR AVISO");
        btnEnviar.setBounds(620, 550, 160, 35);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnVoltar) {
            dispose();
            new PerfilPiloto(piloto);
        }

        if (e.getSource() == btnEnviar) {
            try {
                for(PilotoParticipandoCampeonato pilotos : new PilotoParticipandoCampeonatoBO().listarTodosPilotosQuePilotoParticipaNoCampeonato(campeonato)){
                    AvisoCampeonato avisoCampeonato = new AvisoCampeonato();
                    avisoCampeonato.setAviso(contextojTextPane1.getText());
                    avisoCampeonato.setCampeonato(campeonato);
                    avisoCampeonato.setPilotoqueenviou(piloto);
                    avisoCampeonato.setStatusAviso("Não vizualizado");
                    avisoCampeonato.setPilotos(pilotos.getPiloto());
                    new AvisoCampeonatoBO().criar(avisoCampeonato);
                }
                JOptionPane.showMessageDialog(null, "Aviso enviado aos outros piltos!");
                
                dispose();
                new VerificarCampeonatos(piloto);
            } catch (Exception error) {
                JOptionPane.showMessageDialog(null, "Não foi possível enviar o aviso");
            }
        }
    }

}
