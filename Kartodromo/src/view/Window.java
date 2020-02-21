package view;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {

    public Window(String title,Dimension size) {

        setSize(size);
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle(title);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public Window() {
        
        setSize(800,600);
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}