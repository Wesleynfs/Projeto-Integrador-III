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
    private JButton btnLogar;
    private JButton btnExit;
    private JLabel logo;
    private JLabel forgotLogin;
    private JButton btnThemeChooser;

    public LoginFrame() {

        initializate();
        setTheme(Info.isThemeDark);
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
        btnLogar = new JButton();
        logo = new JLabel();
        btnExit = new JButton();
        forgotLogin = new JLabel();
        btnThemeChooser = new JButton();
    }

    private void add() {
        add(btnThemeChooser);
        add(forgotLogin);
        add(btnExit);
        add(logo);
        add(version);
        add(btnLogar);
        add(loginLabel);
        add(senhaLabel);
        add(login);
        add(senha);
        add(drawer);
        add(fundo);
    }

    private void setTheme(boolean isDark) {
        if (isDark) {
            fundo.setBackground(Colors.CINZAMEDB);
            drawer.setBackground(Colors.VERDEDARK);
            login.setBackground(Colors.CINZALIGHTB);
            login.setForeground(Colors.BRANCO);
            senha.setBackground(Colors.CINZALIGHTB);
            senha.setForeground(Colors.BRANCO);
            loginLabel.setForeground(Colors.CINZALIGHTB);
            senhaLabel.setForeground(Colors.CINZALIGHTB);
            version.setForeground(Colors.CINZALIGHTB);
            btnLogar.setBackground(Colors.VERDEDARK);
            btnLogar.setForeground(Colors.CINZADARKB);
            logo.setForeground(Colors.CINZAMEDB);
            btnExit.setBackground(Colors.VERDEDARK);
            btnExit.setForeground(Colors.CINZADARKB);
            forgotLogin.setForeground(Colors.CINZALIGHTB);
            btnThemeChooser.setBackground(Colors.CINZAMEDB);
            btnThemeChooser.setForeground(Colors.CINZALIGHTB);
        } else {
            fundo.setBackground(Colors.CINZAMEDA);
            drawer.setBackground(Colors.VERDEDARK);
            login.setBackground(Colors.CINZALIGHTB);
            login.setForeground(Colors.CINZADARKA);
            senha.setBackground(Colors.CINZALIGHTB);
            senha.setForeground(Colors.CINZADARKA);
            loginLabel.setForeground(Colors.CINZALIGHTB);
            senhaLabel.setForeground(Colors.CINZALIGHTB);
            version.setForeground(Colors.CINZALIGHTB);
            btnLogar.setBackground(Colors.VERDEDARK);
            btnLogar.setForeground(Colors.CINZADARKB);
            logo.setForeground(Colors.CINZAMEDA);
            btnExit.setBackground(Colors.VERDEDARK);
            btnExit.setForeground(Colors.CINZADARKB);
            forgotLogin.setForeground(Colors.CINZALIGHTB);
            btnThemeChooser.setBackground(Colors.CINZAMEDA);
            btnThemeChooser.setForeground(Colors.CINZALIGHTB);
        }
    }

    private void configs() {

        fundo.setSize(800,600);

        drawer.setBounds(0,0,800,200);

        login.setBorder(BorderFactory.createEmptyBorder());
        login.setBounds(210,300,400,35);
        login.setHorizontalAlignment(JFormattedTextField.CENTER);

        senha.setBorder(BorderFactory.createEmptyBorder());
        senha.setBounds(210,400,400,35);
        senha.setHorizontalAlignment(JPasswordField.CENTER);

        loginLabel.setText("LOGIN");
        loginLabel.setBounds(160,300,400,35);

        senhaLabel.setText("SENHA");
        senhaLabel.setBounds(160,400,400,35);

        version.setText(Info.APP_VERSION);
        version.setBounds(20,550 , 100,35);

        btnLogar.setText("ENTRAR");
        btnLogar.setBorderPainted(false);
        btnLogar.setFocusPainted(false);
        btnLogar.addActionListener(this);
        btnLogar.setBounds(680,550, 100,35);

        logo.setText("KART ON ROAD");
        logo.setFont(Fonts.SANSSERIF);
        logo.setBounds(20,40,700,180);

        btnExit.setText("SAIR");
        btnExit.setBorderPainted(false);
        btnExit.setFocusPainted(false);
        btnExit.addActionListener(this);
        btnExit.setBounds(560,550, 100,35);

        forgotLogin.setText("Esqueci meu login/senha");
        forgotLogin.setBounds(210,445,160,35);
        forgotLogin.addMouseListener(this);

        btnThemeChooser.setFocusPainted(false);
        btnThemeChooser.setBorderPainted(false);
        btnThemeChooser.addActionListener(this);
        btnThemeChooser.setText("Mudar Tema");
        btnThemeChooser.setBounds(650,115,120,35);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnExit) {
            System.exit(0);
        }
        if (e.getSource() == btnThemeChooser) {
            JOptionPane.showMessageDialog(null, "Tema Mudado com sucesso!" ,
                    "Fabrica de Temas",
                    JOptionPane.INFORMATION_MESSAGE);
        }
        if (e.getSource() == btnLogar) {

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
            forgotLogin.setForeground(Colors.CINZALIGHTB);
        }
    }
}
