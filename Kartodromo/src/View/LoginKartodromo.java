package View;

import Utilities.Colors;
import Utilities.Fonts;
import Utilities.Info;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class LoginKartodromo extends JFrame implements ActionListener, MouseListener {

    private JPanel fundo;
    private JPanel drawer;
    private JFormattedTextField emailTextField;
    private JPasswordField senhaJPasswordField;
    private JLabel version;
    private JLabel loginLabel;
    private JLabel senhaLabel;
    private JButton btnLogar;
    private JButton btnVoltar;
    private JLabel logo;
    private JLabel forgotLogin;

    public LoginKartodromo() {

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
        emailTextField = new JFormattedTextField();
        senhaJPasswordField = new JPasswordField();
        version = new JLabel();
        loginLabel = new JLabel();
        senhaLabel = new JLabel();
        btnLogar = new JButton();
        logo = new JLabel();
        btnVoltar = new JButton();
        forgotLogin = new JLabel();
    }

    private void add() {

        add(forgotLogin);
        add(btnVoltar);
        add(logo);
        add(version);
        add(btnLogar);
        add(loginLabel);
        add(senhaLabel);
        add(emailTextField);
        add(senhaJPasswordField);
        add(drawer);
        add(fundo);

    }

    private void setTheme() {
        if (SplashScreen.getConfiguracao().isTema()) {
            // Se o tema for escuro, os itens ficam assim //
            fundo.setBackground(Colors.CINZAMEDB);
            drawer.setBackground(Colors.VERDEDARK);
            emailTextField.setBackground(Colors.CINZALIGHTB);
            emailTextField.setForeground(Colors.CINZADARKA);
            senhaJPasswordField.setBackground(Colors.CINZALIGHTB);
            senhaJPasswordField.setForeground(Colors.CINZADARKA);
            loginLabel.setForeground(Colors.CINZALIGHTB);
            senhaLabel.setForeground(Colors.CINZALIGHTB);
            version.setForeground(Colors.CINZALIGHTB);
            btnLogar.setBackground(Colors.VERDEDARK);
            btnLogar.setForeground(Colors.CINZADARKB);
            logo.setForeground(Colors.CINZAMEDB);
            btnVoltar.setBackground(Colors.VERDEDARK);
            btnVoltar.setForeground(Colors.CINZADARKB);
            forgotLogin.setForeground(Colors.CINZALIGHTB);
        } else {
            fundo.setBackground(Colors.BRANCO);
            drawer.setBackground(Colors.VERDEDARK);
            emailTextField.setBackground(Colors.CINZALIGHTB);
            emailTextField.setForeground(Colors.BRANCO);
            senhaJPasswordField.setBackground(Colors.CINZALIGHTB);
            senhaJPasswordField.setForeground(Colors.BRANCO);
            loginLabel.setForeground(Colors.CINZALIGHTB);
            senhaLabel.setForeground(Colors.CINZALIGHTB);
            version.setForeground(Colors.CINZALIGHTB);
            btnLogar.setBackground(Colors.VERDEDARK);
            btnLogar.setForeground(Colors.CINZADARKB);
            logo.setForeground(Colors.CINZAMEDA);
            btnVoltar.setBackground(Colors.VERDEDARK);
            btnVoltar.setForeground(Colors.CINZADARKB);
            forgotLogin.setForeground(Colors.CINZALIGHTB);
        }
    }

    private void configs() {

        fundo.setSize(Info.MINSCREENSIZE);

        drawer.setBounds(0, 0, 800, 200);

        emailTextField.setBorder(BorderFactory.createEmptyBorder());
        emailTextField.setBounds(210, 300, 400, 35);
        emailTextField.setHorizontalAlignment(JFormattedTextField.CENTER);

        senhaJPasswordField.setBorder(BorderFactory.createEmptyBorder());
        senhaJPasswordField.setBounds(210, 400, 400, 35);
        senhaJPasswordField.setHorizontalAlignment(JPasswordField.CENTER);

        loginLabel.setText("EMAIL DO KARTÓDROMO");
        loginLabel.setBounds(210, 270, 400, 35);

        senhaLabel.setText("SENHA DO KARTÓDROMO");
        senhaLabel.setBounds(210, 370, 400, 35);

        version.setText(Info.APP_VERSION);
        version.setBounds(20, 10, 100, 35);

        btnLogar.setText("ENTRAR");
        btnLogar.setBorderPainted(false);
        btnLogar.setFocusPainted(false);
        btnLogar.addActionListener(this);
        btnLogar.setBounds(680, 550, 100, 35);

        logo.setText(Info.APP_NAME);
        logo.setFont(Fonts.SANSSERIF);
        logo.setBounds(20, 40, 700, 180);

        btnVoltar.setText("VOLTAR");
        btnVoltar.setBorderPainted(false);
        btnVoltar.setFocusPainted(false);
        btnVoltar.addActionListener(this);
        btnVoltar.setBounds(20, 550, 100, 35);

        forgotLogin.setText("Esqueci minha senha");
        forgotLogin.setBounds(210, 445, 160, 35);
        forgotLogin.addMouseListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnVoltar) {
            System.exit(0);
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
            if (SplashScreen.getConfiguracao().isTema()) {
                forgotLogin.setForeground(Colors.CINZADARKA);
            } else {
                forgotLogin.setForeground(Colors.CINZADARKA);
            }
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == forgotLogin) {
            if (SplashScreen.getConfiguracao().isTema()) {
                forgotLogin.setForeground(Colors.CINZALIGHTB);
            } else {
                forgotLogin.setForeground(Colors.CINZALIGHTB);
            }
        }
    }
}