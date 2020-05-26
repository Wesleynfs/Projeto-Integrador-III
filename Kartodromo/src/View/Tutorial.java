
package View;

import Utilities.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tutorial extends JFrame implements ActionListener {

    private JPanel panel;
    private JPanel drawer;
    private JPanel background;
    private JPanel selecao;
    private JButton btnVoltar;
    private JButton btnavancar;
    private JButton btnAnterior;
    private JLabel labelInformacoes;
    private JLabel tutoriaisLabel;
    private JFrame menuPrincipal;
    private JPanel panelLabel;
    private JLabel logo;

    private int posicaoTutorial;

    public Tutorial(JFrame frame) {

        this.menuPrincipal = frame;

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
        add(btnAnterior);
        add(btnavancar);
        add(btnVoltar);
        add(tutoriaisLabel);
        add(panelLabel);
        add(labelInformacoes);
        add(drawer);
        add(selecao);
        add(panel);
        add(background);
    }

    private void initializate() {
        logo = new JLabel();
        labelInformacoes = new JLabel();
        tutoriaisLabel = new JLabel();
        btnAnterior = new JButton();
        btnavancar = new JButton();
        btnVoltar = new JButton();
        drawer = new JPanel();
        selecao = new JPanel();
        panel = new JPanel();
        panelLabel = new JPanel();
        background = new JPanel();
    }

    private void configs() {

        posicaoTutorial = 0;

        logo.setIcon(new ImageIcon(getClass().getResource("/Utilities/imgs/logo.png")));
        logo.setBounds(20, 20, 250, 250);
        logo.setBackground(Colors.CINZALIGHTB);

        btnavancar.setBounds(1100, 670, 150, 30);
        btnavancar.setBorderPainted(false);
        btnavancar.setFocusPainted(false);
        btnavancar.setText("Avançar");
        btnavancar.addActionListener(this);

        btnVoltar.setBounds(0, 660, 300, 50);
        btnVoltar.setBorderPainted(false);
        btnVoltar.setFocusPainted(false);
        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(this);

        btnAnterior.setBounds(900, 670, 150, 30);
        btnAnterior.setBorderPainted(false);
        btnAnterior.setFocusPainted(false);
        btnAnterior.setText("Anterior");
        btnAnterior.addActionListener(this);

        panelLabel.setBounds(400, 130, 800, 400);

        tutoriaisLabel.setBounds(450, 130, 700, 400);
        tutoriaisLabel.setText(InformacoesTutoriais.textosParaOsTutoriais[posicaoTutorial]);
        tutoriaisLabel.setHorizontalTextPosition(2);

        labelInformacoes.setBounds(325, 20, 500, 40);
        labelInformacoes.setText("TUTORIAIS");
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
            background.setBackground(Colors.CINZAMEDB);
            panelLabel.setBackground(Colors.CINZALIGHTB);
            drawer.setBackground(Colors.VERDEDARK);
            btnVoltar.setBackground(Colors.CINZAMEDB);
            btnVoltar.setForeground(Colors.CINZAMEDA);
            btnavancar.setBackground(Colors.VERDEDARK);
            btnavancar.setForeground(Colors.CINZADARKB);
            btnAnterior.setBackground(Colors.VERDEDARK);
            btnAnterior.setForeground(Colors.CINZADARKB);
            labelInformacoes.setForeground(Colors.CINZAMEDA);
            tutoriaisLabel.setForeground(Colors.CINZALIGHTA);
        } else {
            // Tema Claro //
            panel.setBackground(Colors.CINZALIGHTB);
            background.setBackground(Colors.CINZAMEDA);
            panelLabel.setBackground(Colors.CINZADARKA);
            drawer.setBackground(Colors.VERDEDARK);
            btnVoltar.setBackground(Colors.CINZAMEDB);
            btnVoltar.setForeground(Colors.CINZAMEDA);
            btnavancar.setBackground(Colors.CINZAMEDB);
            btnavancar.setForeground(Colors.CINZAMEDA);
            btnAnterior.setBackground(Colors.CINZAMEDB);
            btnAnterior.setForeground(Colors.CINZAMEDA);
            labelInformacoes.setForeground(Colors.CINZAMEDA);
            tutoriaisLabel.setForeground(Colors.PRETO);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnVoltar) {
            if(menuPrincipal != null){
                dispose();
                menuPrincipal.setVisible(true);
            }else{
                dispose();
                new LoginFrame();
            }
            
        }

        if (e.getSource() == btnavancar) {
            if (posicaoTutorial == InformacoesTutoriais.textosParaOsTutoriais.length - 1) {
                posicaoTutorial = 0;
                tutoriaisLabel.setText(InformacoesTutoriais.textosParaOsTutoriais[posicaoTutorial]);
            } else {
                posicaoTutorial++;
                tutoriaisLabel.setText(InformacoesTutoriais.textosParaOsTutoriais[posicaoTutorial]);
            }
        }

        if (e.getSource() == btnAnterior) {
            if (posicaoTutorial > 0) {
                posicaoTutorial -= 1;
                tutoriaisLabel.setText(InformacoesTutoriais.textosParaOsTutoriais[posicaoTutorial]);
            } else {
                posicaoTutorial = InformacoesTutoriais.textosParaOsTutoriais.length - 1;
                tutoriaisLabel.setText(InformacoesTutoriais.textosParaOsTutoriais[posicaoTutorial]);
            }
        }
    }
}
