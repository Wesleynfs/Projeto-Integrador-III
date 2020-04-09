package View;

import Model.Piloto;
import Utilities.Info;

import javax.swing.*;

public class MenuPrincipal extends JFrame {

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
        setUndecorated(true);
        setSize(1280,720);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle(Info.APP_NAME);
        setResizable(false);
    }

    private void add() {

    }

    private void initializate() {
    }

    private void configs() {
    }

    private void setTheme() {
        if(Info.TEMA) {
            // Tema Escuro //
        } else {
            // Tema Claro //
        }
    }
}
