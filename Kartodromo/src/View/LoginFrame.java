package View;

import Model.Configuracao;
import Utilities.Colors;
import Utilities.Fonts;
import Utilities.Info;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class LoginFrame extends JFrame implements ActionListener, MouseListener {

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
    private JButton btnKartodromo;
    private JMenuItem jmenuitem_Desenvolvedor;
    private JPopupMenu jPopupMenu_Desenvolvedor;
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
        configuracao = new Configuracao();
        btnKartodromo = new JButton();
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
    }

    private void add() {
        add(btnKartodromo);
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
            btnKartodromo.setBackground(Colors.CINZAMEDB);
            btnKartodromo.setForeground(Colors.CINZADARKA);
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
            btnKartodromo.setBackground(Colors.CINZAMEDB);
            btnKartodromo.setForeground(Colors.CINZADARKA);
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

        fundo.setSize(800, 600);

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

        btnKartodromo.setText("Sou Kartodromo");
        btnKartodromo.setBounds(650,20,130,35);
        btnKartodromo.setFocusPainted(false);
        btnKartodromo.setBorderPainted(false);
        btnKartodromo.addActionListener(this);

        btnLogar.setText("ENTRAR");
        btnLogar.setBorderPainted(false);
        btnLogar.setFocusPainted(false);
        btnLogar.addActionListener(this);
        btnLogar.setBounds(680, 550, 100, 35);

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
        btnCadastrar.setText("Cadastrar Usuário");
        btnCadastrar.setBounds(520, 550, 140, 35);
        
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
//            Piloto piloto = new Piloto();
//            piloto.setEmail(emailTextField.getText().toLowerCase());
//            piloto.setSenha(new String(senhaJPasswordField.getPassword()));
//            PilotoBO pilotoBO = new PilotoBO();
//            try {
//                if (pilotoBO.logarPiloto(piloto)) {
//                    JOptionPane.showMessageDialog(null, "LOGADO COM SUCESSO!");
//                    new MenuPrincipal(piloto);
//                } else {
//                    throw new Exception("Erro ao localizar usuário no banco!");
//                }
//            } catch (Exception error) {
//                JOptionPane.showMessageDialog(null, error.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
//            }
//  deixei comentado apenas para acessar a tela mais rapidamente
            dispose();
            new MenuPrincipal();
        }

        if (e.getSource() == btnKartodromo) {
            dispose();
            new CadastrarKartodromoPt1();
        }

        if (e.getSource() == btnCadastrar) {
            dispose();
            try {
                new CadastrarUsuario();
            } catch (Exception error) {
                JOptionPane.showConfirmDialog(null,error.getMessage());
            }
        }
        if(e.getSource() == jmenuitem_Desenvolvedor){
            dispose();
            new Desenvolvedor_Kartodromo();
        }
    }
    public void fundoMouseReleased(MouseEvent evt) {
        if(evt.isPopupTrigger()){
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
}
