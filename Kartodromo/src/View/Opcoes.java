package View;

import Dao.ConfiguracaoDAO;
import Model.Configuracao;
import Utilities.Colors;
import Utilities.Info;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Opcoes extends JFrame implements ActionListener , ItemListener {

    private JButton[] buttons = new JButton[2];
    private JPanel background;
    private Configuracao configuracao;
    private JComboBox comboBoxTema;
    private JFrame menuPrincipal;
    private DefaultListCellRenderer renderer;
    private JLabel labelTema;
    private JPanel drawer;

    public Opcoes(Configuracao configuracao , JFrame frame) {

        this.configuracao = configuracao;
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

    private void initializate() {

        for (int x = 0 ; x < buttons.length ; x++) {
            buttons[x] = new JButton();
        }

        drawer = new JPanel();
        labelTema = new JLabel();
        comboBoxTema = new JComboBox();
        renderer = new DefaultListCellRenderer();
        background = new JPanel();
    }

    private void setTheme() {

        if (configuracao.isTema()) {

            background.setBackground(Colors.CINZAMEDB);
            drawer.setBackground(Colors.VERDEDARK);

            for (int x = 0 ; x < buttons.length ; x++) {
                buttons[x].setBackground(Colors.VERDEDARK);
                buttons[x].setForeground(Colors.CINZADARKB);
            }


        } else {

            background.setBackground(Colors.CINZAMEDA);
            drawer.setBackground(Colors.VERDEDARK);

            for (int x = 0 ; x < buttons.length ; x++) {
                buttons[x].setBackground(Colors.VERDEDARK);
                buttons[x].setForeground(Colors.CINZADARKB);
            }

        }
    }

    private void add() {

        for (int x = 0 ; x < buttons.length ; x++) {
            add(buttons[x]);
        }

        add(labelTema);
        add(comboBoxTema);
        add(drawer);
        add(background);
    }

    private void configs() {

        for (int x = 0 ; x < buttons.length ; x++) {
            buttons[x].setBorderPainted(false);
            buttons[x].setFocusPainted(false);
            buttons[x].addActionListener(this);
        }

        buttons[0].setText("Voltar");
        buttons[0].setBounds(20, 550, 100, 35);

        buttons[1].setText("Salvar");
        buttons[1].setBounds(680, 550, 100, 35);

        labelTema.setText("TEMA: ");
        labelTema.setBounds(50,300,130,35);

        renderer.setHorizontalAlignment(DefaultListCellRenderer.CENTER);

        comboBoxTema.addItem("ESCURO");
        comboBoxTema.addItem("CLARO");
        comboBoxTema.setBounds(100, 300, 130, 35);
        comboBoxTema.addItemListener(this);
        comboBoxTema.setRenderer(renderer);

        drawer.setBounds(0, 0, 800, 200);
        background.setSize(Info.MINSCREENSIZE);

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
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == buttons[0]) {
            dispose();
            menuPrincipal.setVisible(true);
        }
        if (actionEvent.getSource() == buttons[1]) {
            if (new ConfiguracaoDAO().setConfiguracao(configuracao)) {
                JOptionPane.showConfirmDialog(null,"Salvo!" , "Mensagem",JOptionPane.PLAIN_MESSAGE);
            } else {
                JOptionPane.showConfirmDialog(null,"Erro ao Salvar configurações!" , "Mensagem",JOptionPane.PLAIN_MESSAGE);
            }
        }
    }

    @Override
    public void itemStateChanged(ItemEvent itemEvent) {
        if (itemEvent.getSource() == comboBoxTema) {
            if (comboBoxTema.getSelectedIndex() == 0) {
                configuracao.setTema(true);
            } else {
                configuracao.setTema(false);
            }
        }
    }
}
