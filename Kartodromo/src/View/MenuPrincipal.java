package View;

import Model.Piloto;
import Utilities.Colors;
import Utilities.Fonts;
import Utilities.Info;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MenuPrincipal extends JFrame implements ActionListener , MouseListener {

    private JPanel panel;
    private JPanel drawer;
    private JPanel background;
    private JPanel selecao;
    private JButton btnPerfilPiloto;
    private JButton btnSair;
    private JButton btnOpcoes;
    private JButton btnInstrucoes;
    private JLabel labelInformacoes;

    public MenuPrincipal(Piloto piloto) {

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

    // Construtor ABAIXO para testes, EXCLUIR //

    public MenuPrincipal() {

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
        add(labelInformacoes);
        add(btnInstrucoes);
        add(btnOpcoes);
        add(btnSair);
        add(btnPerfilPiloto);
        add(drawer);
        add(selecao);
        add(panel);
        add(background);
    }

    private void initializate() {
        labelInformacoes = new JLabel();
        btnInstrucoes = new JButton();
        btnOpcoes = new JButton();
        btnSair = new JButton();
        btnPerfilPiloto = new JButton();
        drawer = new JPanel();
        selecao = new JPanel();
        panel = new JPanel();
        background = new JPanel();
    }

    private void configs() {

        btnOpcoes.setBounds(0,540,300,50);
        btnOpcoes.setBorderPainted(false);
        btnOpcoes.setFocusPainted(false);
        btnOpcoes.setText("Opções");
        btnOpcoes.addActionListener(this);

        btnPerfilPiloto.setBounds(0,600,300,50);
        btnPerfilPiloto.setBorderPainted(false);
        btnPerfilPiloto.setFocusPainted(false);
        btnPerfilPiloto.setText("Perfil Piloto");
        btnPerfilPiloto.addActionListener(this);

        btnSair.setBounds(0,660,300,50);
        btnSair.setBorderPainted(false);
        btnSair.setFocusPainted(false);
        btnSair.setText("Sair");
        btnSair.addActionListener(this);

        btnInstrucoes.setBounds(0,480,300,50);
        btnInstrucoes.setBorderPainted(false);
        btnInstrucoes.setFocusPainted(false);
        btnInstrucoes.setText("Como Usar");
        btnInstrucoes.addActionListener(this);

        labelInformacoes.setBounds(325,20,500,40);
        labelInformacoes.setText("ULTIMOS CAMPEONATOS");
        labelInformacoes.setFont(Fonts.SANSSERIFMIN);

        drawer.setBounds(0,0,300,720);
        panel.setBounds(300,0,1180,80);
        background.setSize(Info.MAXSCREENSIZE);
        selecao.setVisible(false);

    }

    private void setTheme() {
        if(LoginFrame.getConfiguracao().isTema()) {
            // Tema Escuro //
            panel.setBackground(Colors.CINZALIGHTB);
            background.setBackground(Colors.PRETO);
            drawer.setBackground(Colors.VERDEDARK);
            btnPerfilPiloto.setBackground(Colors.CINZAMEDB);
            btnPerfilPiloto.setForeground(Colors.CINZAMEDA);
            btnSair.setBackground(Colors.CINZAMEDB);
            btnSair.setForeground(Colors.CINZAMEDA);
            btnOpcoes.setBackground(Colors.CINZAMEDB);
            btnOpcoes.setForeground(Colors.CINZAMEDA);
            btnInstrucoes.setBackground(Colors.CINZAMEDB);
            btnInstrucoes.setForeground(Colors.CINZAMEDA);
            labelInformacoes.setForeground(Colors.CINZAMEDA);

        } else {
            // Tema Claro //
            panel.setBackground(Colors.CINZALIGHTB);
            background.setBackground(Colors.CINZAMEDA);
            drawer.setBackground(Colors.VERDEDARK);
            btnPerfilPiloto.setBackground(Colors.CINZAMEDB);
            btnPerfilPiloto.setForeground(Colors.CINZAMEDA);
            btnSair.setBackground(Colors.CINZAMEDB);
            btnSair.setForeground(Colors.CINZAMEDA);
            btnOpcoes.setBackground(Colors.CINZAMEDB);
            btnOpcoes.setForeground(Colors.CINZAMEDA);
            btnInstrucoes.setBackground(Colors.CINZAMEDB);
            btnInstrucoes.setForeground(Colors.CINZAMEDA);
            labelInformacoes.setForeground(Colors.CINZAMEDA);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnPerfilPiloto) {
            dispose();
            new PerfilPiloto();
        }
        if (e.getSource() == btnSair) {
            // Acredito que tenha que salvar algum processo em andamento aqui antes de sair por completo //
            System.exit(0);
        }
        if (e.getSource() == btnOpcoes) {
            dispose();
            //new Opcoes();
            System.exit(0);
        }
        if (e.getSource() == btnInstrucoes) {
            // Acredito que tenha que salvar algum processo em andamento aqui antes de sair por completo //
            System.exit(0);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
