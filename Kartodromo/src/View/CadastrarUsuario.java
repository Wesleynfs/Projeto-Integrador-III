package View;

import Bo.PilotoBO;
import Model.Piloto;
import Utilities.Colors;
import Utilities.Fonts;
import Utilities.Info;

import javax.swing.*;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastrarUsuario extends JFrame implements ActionListener {

    private JPanel fundo;
    private JPanel drawer;
    private JTextField nomeJTextField;
    private JTextField emailJTextField;
    private JFormattedTextField dataNascJTextField;
    private JFormattedTextField cpfJTextField;
    private JTextField senhaJTextField;
    private JTextField apelidoJTextField;
    private JLabel version;
    private JLabel loginLabel;
    private JLabel senhaLabel;
    private JButton btnDeletar;
    private JLabel logo;
    private JLabel nomeLabel;
    private JLabel cpfLabel;
    private JLabel dataNascLabel;
    private JLabel apelidoLabel;
    private JButton btnCadastrar;
    private JButton btnAlterar;
    private JButton btnVoltar;

    public CadastrarUsuario() {

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
        nomeLabel = new JLabel();
        dataNascLabel = new JLabel();
        cpfLabel = new JLabel();
        apelidoLabel = new JLabel();
        apelidoJTextField = new JTextField();
        fundo = new JPanel();
        drawer = new JPanel();
        nomeJTextField = new JTextField();
        dataNascJTextField = new JFormattedTextField();
        cpfJTextField = new JFormattedTextField();
        emailJTextField = new JTextField();
        senhaJTextField = new JTextField();
        version = new JLabel();
        loginLabel = new JLabel();
        senhaLabel = new JLabel();
        logo = new JLabel();
        btnDeletar = new JButton();
        btnCadastrar = new JButton();
        btnAlterar = new JButton();
        btnVoltar = new JButton();
    }

    private void add() {

        add(nomeJTextField);
        add(cpfJTextField);
        add(dataNascJTextField);
        add(emailJTextField);
        add(senhaJTextField);
        add(btnCadastrar);
        add(btnDeletar);
        add(btnAlterar);
        add(btnVoltar);
        add(apelidoJTextField);
        add(apelidoLabel);
        add(logo);
        add(version);
        add(loginLabel);
        add(senhaLabel);
        add(nomeLabel);
        add(dataNascLabel);
        add(cpfLabel);
        add(drawer);
        add(fundo);

    }

    private void setTheme() {

        if (LoginFrame.getConfiguracao().isTema()) {
            // Se o tema for escuro, os itens ficam assim //
            fundo.setBackground(Colors.CINZAMEDB);
            drawer.setBackground(Colors.VERDEDARK);
            emailJTextField.setBackground(Colors.CINZALIGHTB);
            emailJTextField.setForeground(Colors.BRANCO);
            senhaJTextField.setBackground(Colors.CINZALIGHTB);
            senhaJTextField.setForeground(Colors.BRANCO);
            cpfJTextField.setBackground(Colors.CINZALIGHTB);
            cpfJTextField.setForeground(Colors.BRANCO);
            nomeJTextField.setBackground(Colors.CINZALIGHTB);
            nomeJTextField.setForeground(Colors.BRANCO);
            apelidoJTextField.setBackground(Colors.CINZALIGHTB);
            apelidoJTextField.setForeground(Colors.BRANCO);
            apelidoLabel.setForeground(Colors.CINZALIGHTB);
            dataNascJTextField.setBackground(Colors.CINZALIGHTB);
            dataNascJTextField.setForeground(Colors.BRANCO);
            loginLabel.setForeground(Colors.CINZALIGHTB);
            senhaLabel.setForeground(Colors.CINZALIGHTB);
            nomeLabel.setForeground(Colors.CINZALIGHTB);
            cpfLabel.setForeground(Colors.CINZALIGHTB);
            dataNascLabel.setForeground(Colors.CINZALIGHTB);
            version.setForeground(Colors.CINZALIGHTB);
            logo.setForeground(Colors.CINZAMEDB);
            btnDeletar.setBackground(Colors.VERDEDARK);
            btnDeletar.setForeground(Colors.CINZADARKB);
            btnCadastrar.setBackground(Colors.VERDEDARK);
            btnCadastrar.setForeground(Colors.CINZADARKB);
            btnAlterar.setBackground(Colors.VERDEDARK);
            btnAlterar.setForeground(Colors.CINZADARKB);
            btnVoltar.setBackground(Colors.VERDEDARK);
            btnVoltar.setForeground(Colors.CINZADARKB);
        } else {
            fundo.setBackground(Colors.CINZAMEDA);
            drawer.setBackground(Colors.VERDEDARK);
            emailJTextField.setBackground(Colors.CINZALIGHTB);
            emailJTextField.setForeground(Colors.CINZADARKA);
            senhaJTextField.setBackground(Colors.CINZALIGHTB);
            senhaJTextField.setForeground(Colors.CINZADARKA);
            apelidoJTextField.setBackground(Colors.CINZALIGHTB);
            apelidoJTextField.setForeground(Colors.CINZADARKA);
            apelidoLabel.setForeground(Colors.CINZALIGHTB);
            nomeJTextField.setBackground(Colors.CINZALIGHTB);
            nomeJTextField.setForeground(Colors.CINZADARKA);
            cpfJTextField.setBackground(Colors.CINZALIGHTB);
            cpfJTextField.setForeground(Colors.CINZADARKA);
            dataNascJTextField.setBackground(Colors.CINZALIGHTB);
            dataNascJTextField.setForeground(Colors.CINZADARKA);
            loginLabel.setForeground(Colors.CINZALIGHTB);
            senhaLabel.setForeground(Colors.CINZALIGHTB);
            nomeLabel.setForeground(Colors.CINZALIGHTB);
            cpfLabel.setForeground(Colors.CINZALIGHTB);
            dataNascLabel.setForeground(Colors.CINZALIGHTB);
            version.setForeground(Colors.CINZALIGHTB);
            logo.setForeground(Colors.CINZAMEDB);
            btnDeletar.setBackground(Colors.VERDEDARK);
            btnDeletar.setForeground(Colors.CINZADARKB);
            btnCadastrar.setBackground(Colors.VERDEDARK);
            btnCadastrar.setForeground(Colors.CINZADARKB);
            btnAlterar.setBackground(Colors.VERDEDARK);
            btnAlterar.setForeground(Colors.CINZADARKB);
            btnVoltar.setBackground(Colors.VERDEDARK);
            btnVoltar.setForeground(Colors.CINZADARKB);
        }
    }

    private void configs() {
        fundo.setSize(Info.MINSCREENSIZE);
        drawer.setBounds(0, 0, 800, 200);

        emailJTextField.setBorder(BorderFactory.createEmptyBorder());
        emailJTextField.setBounds(210, 240, 400, 35);
        emailJTextField.setHorizontalAlignment(JFormattedTextField.CENTER);

        nomeJTextField.setBorder(BorderFactory.createEmptyBorder());
        nomeJTextField.setBounds(210, 280, 400, 35);
        nomeJTextField.setHorizontalAlignment(JFormattedTextField.CENTER);

        cpfJTextField.setBorder(BorderFactory.createEmptyBorder());
        cpfJTextField.setBounds(210, 320, 400, 35);
        cpfJTextField.setHorizontalAlignment(JFormattedTextField.CENTER);

        dataNascJTextField.setBorder(BorderFactory.createEmptyBorder());
        dataNascJTextField.setBounds(210, 360, 400, 35);
        dataNascJTextField.setHorizontalAlignment(JFormattedTextField.CENTER);

        senhaJTextField.setBorder(BorderFactory.createEmptyBorder());
        senhaJTextField.setBounds(210, 400, 400, 35);
        senhaJTextField.setHorizontalAlignment(JPasswordField.CENTER);
        
        apelidoJTextField.setBorder(BorderFactory.createEmptyBorder());
        apelidoJTextField.setBounds(210, 440, 400, 35);
        apelidoJTextField.setHorizontalAlignment(JPasswordField.CENTER);
                
        apelidoLabel.setText("APELIDO");
        apelidoLabel.setBounds(150, 440, 400, 35);
                
        loginLabel.setText("EMAIL");
        loginLabel.setBounds(160, 240, 400, 35);

        nomeLabel.setText("NOME");
        nomeLabel.setBounds(160, 280, 400, 35);

        cpfLabel.setText("CPF");
        cpfLabel.setBounds(160, 320, 400, 35);

        dataNascLabel.setText("DATA DE NASCIMENTO");
        dataNascLabel.setBounds(70, 360, 400, 35);

        senhaLabel.setText("SENHA");
        senhaLabel.setBounds(160, 400, 400, 35);

        version.setText(Info.APP_VERSION);
        version.setBounds(20, 10, 100, 35);

        logo.setText("KART ON ROAD");
        logo.setFont(Fonts.SANSSERIF);
        logo.setBounds(20, 40, 600, 180);

        btnDeletar.setText("Deletar");
        btnDeletar.setBorderPainted(false);
        btnDeletar.setFocusPainted(false);
        btnDeletar.addActionListener(this);
        btnDeletar.setBounds(460, 550, 100, 35);

        btnAlterar.setText("Alterar");
        btnAlterar.setBorderPainted(false);
        btnAlterar.setFocusPainted(false);
        btnAlterar.addActionListener(this);
        btnAlterar.setBounds(570, 550, 100, 35);

        btnCadastrar.setText("Cadastrar");
        btnCadastrar.setFocusPainted(false);
        btnCadastrar.setBorderPainted(false);
        btnCadastrar.addActionListener(this);
        btnCadastrar.setBounds(680, 550, 100, 35);

        btnVoltar.setText("Voltar");
        btnVoltar.setFocusPainted(false);
        btnVoltar.setBorderPainted(false);
        btnVoltar.addActionListener(this);
        btnVoltar.setBounds(20, 550, 100, 35);

        // Setando os maskFormatters //

        try {
            dataNascJTextField.setFormatterFactory(new DefaultFormatterFactory(
                    new MaskFormatter("##/##/####")));
            cpfJTextField.setFormatterFactory(new DefaultFormatterFactory(
                    new MaskFormatter("###.###.###-##")));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Piloto piloto = new Piloto();
        piloto.setNomePiloto(nomeJTextField.getText().toLowerCase());
        piloto.setEmailPiloto(emailJTextField.getText().toLowerCase());
        piloto.setSenhaPiloto(senhaJTextField.getText().toLowerCase());
        piloto.setApelido(apelidoJTextField.getText().toLowerCase());
        piloto.setAtivo(true);
        piloto.setCpfPiloto(cpfJTextField.getText().toLowerCase());
        piloto.setDataNascimentoPiloto(dataNascJTextField.getText().toLowerCase());
        PilotoBO pilotoBO = new PilotoBO();

        if (e.getSource() == btnDeletar) {
            try {
                if (pilotoBO.deletar(piloto)) {
                    JOptionPane.showMessageDialog(null,"Piloto deletado com sucesso!","Error",JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (Exception error) {
                JOptionPane.showMessageDialog(null,error.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            }
        }
        if (e.getSource() == btnCadastrar) {
            try {
                if(pilotoBO.verificarapelido(piloto.getApelido())){
                    JOptionPane.showMessageDialog(null,"Este Apelido já existe, por favor tente outro!","Apelido Existente",JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                if (pilotoBO.criar(piloto)) {
                    JOptionPane.showMessageDialog(null,"Piloto criado com sucesso!","Error",JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                    new MenuPrincipal(piloto);
                }
            } catch (Exception error) {
                JOptionPane.showMessageDialog(null,error.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            }
        }

        if (e.getSource() == btnAlterar) {
            try {
                if (pilotoBO.alterar(piloto)) {
                    JOptionPane.showMessageDialog(null,"Piloto criado com sucesso!","Error",JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (Exception error) {
                JOptionPane.showMessageDialog(null,error.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            }
        }

        if (e.getSource() == btnVoltar) {
            dispose();
            new LoginFrame();
        }

    }
}
