package View;

import Utilities.Colors;
import Utilities.Fonts;
import Utilities.Info;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class LoginFrame extends JFrame implements ActionListener , MouseListener {

    private JPanel fundo;
    private JPanel drawer;
    private JFormattedTextField login;
    private JPasswordField senha;
    private JLabel version;
    private JLabel loginLabel;
    private JLabel senhaLabel;
    private JButton logar;
    private JButton exit;
    private JLabel logo;
    private JLabel forgotLogin;

    public LoginFrame() {

        initializate();
        add();
        configs();

        setUndecorated(true);
        setSize(800,600);
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
        login = new JFormattedTextField();
        senha = new JPasswordField();
        version = new JLabel();
        loginLabel = new JLabel();
        senhaLabel = new JLabel();
        logar = new JButton();
        logo = new JLabel();
        exit = new JButton();
        forgotLogin = new JLabel();
    }

    private void add() {
        add(forgotLogin);
        add(exit);
        add(logo);
        add(version);
        add(logar);
        add(loginLabel);
        add(senhaLabel);
        add(login);
        add(senha);
        add(drawer);
        add(fundo);
    }

    private void configs() {
        fundo.setBackground(Colors.CINZAMED);
        fundo.setSize(800,600);

        drawer.setBackground(Colors.CINZALIGHT);
        drawer.setBounds(0,0,800,200);

        login.setBackground(Colors.CINZALIGHT);
        login.setBorder(BorderFactory.createEmptyBorder());
        login.setForeground(Colors.BRANCO);
        login.setBounds(210,300,400,35);
        login.setHorizontalAlignment(JFormattedTextField.CENTER);

        senha.setBackground(Colors.CINZALIGHT);
        senha.setBorder(BorderFactory.createEmptyBorder());
        senha.setForeground(Colors.BRANCO);
        senha.setBounds(210,400,400,35);
        senha.setHorizontalAlignment(JPasswordField.CENTER);

        loginLabel.setForeground(Colors.CINZALIGHT);
        loginLabel.setText("LOGIN");
        loginLabel.setBounds(160,300,400,35);

        senhaLabel.setForeground(Colors.CINZALIGHT);
        senhaLabel.setText("SENHA");
        senhaLabel.setBounds(160,400,400,35);

        version.setText(Info.APP_VERSION);
        version.setBounds(20,550 , 100,35);
        version.setForeground(Colors.CINZALIGHT);

        logar.setText("ENTRAR");
        logar.setBackground(Colors.VERDEDARK);
        logar.setForeground(Colors.CINZADARK);
        logar.setBorderPainted(false);
        logar.setFocusPainted(false);
        logar.addActionListener(this);
        logar.setBounds(680,550, 100,35);

        logo.setText("KART ON ROAD");
        logo.setForeground(Colors.CINZAMED);
        logo.setFont(Fonts.SANSSERIF);
        logo.setBounds(20,40,700,180);

        exit.setText("SAIR");
        exit.setBackground(Colors.VERDEDARK);
        exit.setForeground(Colors.CINZADARK);
        exit.setBorderPainted(false);
        exit.setFocusPainted(false);
        exit.addActionListener(this);
        exit.setBounds(560,550, 100,35);

        forgotLogin.setText("Esqueci meu login/senha");
        forgotLogin.setBounds(210,445,160,35);
        forgotLogin.setForeground(Colors.CINZALIGHT);
        forgotLogin.addMouseListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == exit) {
            System.exit(0);
        }
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == forgotLogin) {
            forgotLogin.setForeground(Colors.BRANCO);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == forgotLogin) {
            forgotLogin.setForeground(Colors.CINZALIGHT);
        }
    }
}
