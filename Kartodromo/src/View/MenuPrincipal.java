package View;

import Model.Piloto;
import Utilities.Colors;
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

    private void configurateThis() {
        setSize(Info.MAXSCREENSIZE);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle(Info.APP_NAME);
        setResizable(false);
    }

    private void add() {
        add(drawer);
        add(selecao);
        add(panel);
        add(background);
    }

    private void initializate() {
        drawer = new JPanel();
        selecao = new JPanel();
        panel = new JPanel();
        background = new JPanel();
    }

    private void configs() {
        drawer.setBounds(0,0,300,720);
        panel.setBounds(300,0,1180,80);
        background.setSize(Info.MAXSCREENSIZE);
        selecao.setVisible(false);
    }

    private void setTheme() {
        if(Info.TEMA) {
            // Tema Escuro //

            panel.setBackground(Colors.CINZALIGHTB);
            background.setBackground(Colors.CINZAMEDB);
            drawer.setBackground(Colors.VERDEDARK);
        } else {
            // Tema Claro //
            
            panel.setBackground(Colors.CINZALIGHTB);
            background.setBackground(Colors.CINZAMEDA);
            drawer.setBackground(Colors.VERDEDARK);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

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
