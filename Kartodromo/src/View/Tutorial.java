
package View;

import Model.Kartodromo;
import Model.Piloto;
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
    private Piloto piloto;
    private JLabel tutoriaisLabel;
    private JLabel logo;
    
    private int posicao_tutorial;

    public Piloto getPiloto() {
        return piloto;
    }

    public void setPiloto(Piloto piloto) {
        this.piloto = piloto;
    }

    public Tutorial(Piloto piloto) {

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
        background = new JPanel();
    }

    private void configs() {
        
        posicao_tutorial = 0;
                
        logo.setIcon(new ImageIcon(getClass().getResource("/Utilities/imgs/logo.png")));
        logo.setBounds(20,20,250,250);
        logo.setBackground(Colors.CINZALIGHTB);

        btnavancar.setBounds(520, 640, 150, 30);
        btnavancar.setBorderPainted(false);
        btnavancar.setFocusPainted(false);
        btnavancar.setText("Avançar");
        btnavancar.addActionListener(this);

        btnVoltar.setBounds(0, 660, 300, 50);
        btnVoltar.setBorderPainted(false);
        btnVoltar.setFocusPainted(false);
        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(this);

        btnAnterior.setBounds(350, 640, 150, 30);
        btnAnterior.setBorderPainted(false);
        btnAnterior.setFocusPainted(false);
        btnAnterior.setText("Anterior");
        btnAnterior.addActionListener(this);

        tutoriaisLabel.setBounds(350, 50, 800, 600);
        tutoriaisLabel.setText(Info_tutorial.infos[posicao_tutorial]);
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

        if (LoginFrame.getConfiguracao().isTema()) {
            // Tema Escuro //
            panel.setBackground(Colors.CINZALIGHTB);
            background.setBackground(Colors.CINZAMEDA);
            drawer.setBackground(Colors.VERDEDARK);
            btnVoltar.setBackground(Colors.CINZAMEDB);
            btnVoltar.setForeground(Colors.CINZAMEDA);
            btnavancar.setBackground(Colors.CINZAMEDB);
            btnavancar.setForeground(Colors.CINZAMEDA);
            btnAnterior.setBackground(Colors.CINZAMEDB);
            btnAnterior.setForeground(Colors.CINZAMEDA);
            labelInformacoes.setForeground(Colors.CINZAMEDA);
            tutoriaisLabel.setForeground(Colors.VERDEDARK);
        } else {
            // Tema Claro //
            panel.setBackground(Colors.CINZALIGHTB);
            background.setBackground(Colors.CINZAMEDA);
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
                dispose();
                new PerfilPiloto(piloto);

        }
        if (e.getSource() == btnavancar) {
            if(posicao_tutorial == Info_tutorial.infos.length -1){
                posicao_tutorial = 0; 
                tutoriaisLabel.setText(Info_tutorial.infos[posicao_tutorial]);
            } else{
                posicao_tutorial++;
                tutoriaisLabel.setText(Info_tutorial.infos[posicao_tutorial]);
            }
        }
        if (e.getSource() == btnAnterior) {
            if(posicao_tutorial > 0){
                posicao_tutorial -=1;
                tutoriaisLabel.setText(Info_tutorial.infos[posicao_tutorial]);
            }else{
                posicao_tutorial = Info_tutorial.infos.length -1;
                tutoriaisLabel.setText(Info_tutorial.infos[posicao_tutorial]);
            }
            
        }
    }
}
