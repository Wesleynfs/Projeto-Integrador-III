package View;

import Bo.KartodromoBO;
import Bo.PilotoBO;
import Dao.ConfiguracaoDAO;
import Model.Configuracao;
import Model.Kartodromo;
import Model.Piloto;
import Utilities.Colors;
import Utilities.Fonts;
import Utilities.Info;

import javax.swing.*;
import java.awt.event.*;

public class LoginFrame extends JFrame implements ActionListener, MouseListener, ItemListener {

    private JPanel fundo;
    private JPanel drawer;
    private JFormattedTextField emailTextField;
    private JPasswordField senhaJPasswordField;
    private JLabel version;
    private JLabel loginLabel;
    private JLabel senhaLabel;
    private JButton btnLogar;
    private JButton btnExit;
    private JLabel logo;
    private JLabel forgotLogin;
    private JButton btnCadastrar;
    private JLabel labelKartodromo;
    private JMenuItem jmenuitem_Desenvolvedor;
    private JPopupMenu jPopupMenu_Desenvolvedor;
    private JComboBox<String> combo;
    private DefaultListCellRenderer renderer;
    private static Configuracao configuracao;

    public static Configuracao getConfiguracao() {
        return configuracao;
    }

    public LoginFrame() {

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
        configuracao = new ConfiguracaoDAO().getConfiguracao();
        labelKartodromo = new JLabel();
        fundo = new JPanel();
        drawer = new JPanel();
        emailTextField = new JFormattedTextField();
        senhaJPasswordField = new JPasswordField();
        version = new JLabel();
        loginLabel = new JLabel();
        senhaLabel = new JLabel();
        btnLogar = new JButton();
        logo = new JLabel();
        btnExit = new JButton();
        forgotLogin = new JLabel();
        btnCadastrar = new JButton();
        jmenuitem_Desenvolvedor = new JMenuItem();
        jPopupMenu_Desenvolvedor = new JPopupMenu();
        combo = new JComboBox<>();
        renderer = new DefaultListCellRenderer();
    }

    private void add() {
        add(labelKartodromo);
        add(combo);
        add(btnCadastrar);
        add(forgotLogin);
        add(btnExit);
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
        if (configuracao.isTema()) {
            // Se o tema for escuro, os itens ficam assim //
            labelKartodromo.setForeground(Colors.CINZAMEDB);
            fundo.setBackground(Colors.CINZAMEDB);
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
            logo.setForeground(Colors.CINZAMEDB);
            btnExit.setBackground(Colors.VERDEDARK);
            btnExit.setForeground(Colors.CINZADARKB);
            forgotLogin.setForeground(Colors.CINZALIGHTB);
            btnCadastrar.setBackground(Colors.VERDEDARK);
            btnCadastrar.setForeground(Colors.CINZADARKB);
        } else {
            labelKartodromo.setForeground(Colors.CINZAMEDB);
            fundo.setBackground(Colors.CINZAMEDA);
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
            btnExit.setBackground(Colors.VERDEDARK);
            btnExit.setForeground(Colors.CINZADARKB);
            forgotLogin.setForeground(Colors.CINZALIGHTB);
            btnCadastrar.setBackground(Colors.VERDEDARK);
            btnCadastrar.setForeground(Colors.CINZADARKB);
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

        loginLabel.setText("EMAIL");
        loginLabel.setBounds(210, 260, 400, 35);

        senhaLabel.setText("SENHA");
        senhaLabel.setBounds(210, 360, 400, 35);

        version.setText(Info.APP_VERSION);
        version.setBounds(20, 10, 100, 35);

        labelKartodromo.setText("Logar / Cadastrar como: ");
        labelKartodromo.setBounds(500, 20, 150, 35);

        renderer.setHorizontalAlignment(DefaultListCellRenderer.CENTER);

        combo.addItem("Kartodromo");
        combo.addItem("Piloto");
        combo.setBounds(650, 20, 130, 35);
        combo.addItemListener(this);
        combo.setRenderer(renderer);

        btnLogar.setText("Logar Kartodromo");
        btnLogar.setBorderPainted(false);
        btnLogar.setFocusPainted(false);
        btnLogar.addActionListener(this);
        btnLogar.setBounds(640, 550, 140, 35);

        logo.setText("KART ON ROAD");
        logo.setFont(Fonts.SANSSERIF);
        logo.setBounds(20, 40, 700, 180);

        btnExit.setText("SAIR");
        btnExit.setBorderPainted(false);
        btnExit.setFocusPainted(false);
        btnExit.addActionListener(this);
        btnExit.setBounds(20, 550, 100, 35);

        forgotLogin.setText("Esqueci meu login/senha");
        forgotLogin.setBounds(210, 445, 160, 35);
        forgotLogin.addMouseListener(this);

        btnCadastrar.setFocusPainted(false);
        btnCadastrar.setBorderPainted(false);
        btnCadastrar.addActionListener(this);
        btnCadastrar.setText("Cadastrar Kartodromo");
        btnCadastrar.setBounds(450, 550, 170, 35);

        jmenuitem_Desenvolvedor.setText("Entrar como Desenvolvedor");
        jPopupMenu_Desenvolvedor.add(jmenuitem_Desenvolvedor);
        jmenuitem_Desenvolvedor.addActionListener(this);
        fundo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                fundoMouseReleased(evt);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnExit) {
            System.exit(0);
        }
        if (e.getSource() == btnLogar) {

            switch (combo.getSelectedIndex()) {
                case 0:
                    Kartodromo kartodromo = new Kartodromo();
                    kartodromo.setEmailKartodromo(emailTextField.getText().toLowerCase());
                    kartodromo.setSenhaKartodromo(new String(senhaJPasswordField.getPassword()));
                    try {
                        Kartodromo kartodromo1 = new KartodromoBO().logar(kartodromo);
                        if (kartodromo1 != null) {
                            JOptionPane.showMessageDialog(null, "KARTODROMO LOGADO COM SUCESSO!");
                            dispose();
                            new MenuPrincipal(kartodromo);
                        } else {
                            throw new Exception("Erro ao localizar kartodromo no banco!");
                        }
                    } catch (Exception error) {
                        JOptionPane.showMessageDialog(null, error.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                case 1:
                    Piloto piloto = new Piloto();
                    piloto.setEmailPiloto(emailTextField.getText().toLowerCase());
                    piloto.setSenhaPiloto(new String(senhaJPasswordField.getPassword()));
                    try {
                        Piloto piloto1 = new PilotoBO().logar(piloto);
                        if (piloto1 != null) {
                            JOptionPane.showMessageDialog(null, "LOGADO COM SUCESSO!");
                            dispose();
                            new MenuPrincipal(piloto1);
                        } else {
                            throw new Exception("Erro ao localizar piloto/adm no banco!");
                        }
                    } catch (Exception error) {
                        JOptionPane.showMessageDialog(null, error.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    break;

            }
        }

        if (e.getSource() == btnCadastrar) {
            dispose();

            switch (combo.getSelectedIndex()) {
                case 0:
                    new CadastrarKartodromoPt1();
                    break;
                default:
                    new CadastrarUsuario();
                    break;
            }

        }

        if (e.getSource() == jmenuitem_Desenvolvedor) {
            dispose();
            new DesenvolvedorKartodromo();
        }

    }

    public void fundoMouseReleased(MouseEvent evt) {
        if (evt.isPopupTrigger()) {
            jPopupMenu_Desenvolvedor.show(this, evt.getX(), evt.getY());
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
            if (configuracao.isTema()) {
                forgotLogin.setForeground(Colors.BRANCO);
            } else {
                forgotLogin.setForeground(Colors.VERDEDARK);
            }
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == forgotLogin) {
            if (configuracao.isTema()) {
                forgotLogin.setForeground(Colors.CINZALIGHTB);
            } else {
                forgotLogin.setForeground(Colors.CINZALIGHTB);
            }
        }
    }

    @Override
    public void itemStateChanged(ItemEvent itemEvent) {
        if ((itemEvent.getSource() == combo)) {
            if (combo.getSelectedIndex() == 0) {
                btnCadastrar.setText("Cadastrar Kartodromo");
                btnLogar.setText("Logar Kartodromo");
            }

            if (combo.getSelectedIndex() == 1) {
                btnCadastrar.setText("Cadastrar Piloto");
                btnLogar.setText("Logar Piloto");
            }

            if (combo.getSelectedIndex() == 2) {
                btnCadastrar.setEnabled(false);
            } else {
                btnCadastrar.setEnabled(true);
            }
        }
    }
}
