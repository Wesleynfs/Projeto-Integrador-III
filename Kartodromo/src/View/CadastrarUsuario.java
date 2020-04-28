package View;

import Bo.PilotoBO;
import Model.Piloto;
import Utilities.Colors;
import Utilities.Info;

import java.awt.Font;

import javax.swing.*;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastrarUsuario extends JFrame implements ActionListener {

    private JPanel fundo;
    private JPanel drawer;
    private JTextField nome;
    private JTextField email;
    private JFormattedTextField dataNasc;
    private JFormattedTextField cpf;
    private JTextField senha;
    private JLabel version;
    private JLabel loginLabel;
    private JLabel senhaLabel;
    private JButton btnDeletar;
    private JLabel logo;
    private JLabel nomeLabel;
    private JLabel cpfLabel;
    private JLabel dataNascLabel;
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
        fundo = new JPanel();
        drawer = new JPanel();
        nome = new JTextField();
        dataNasc = new JFormattedTextField();
        cpf = new JFormattedTextField();
        email = new JTextField();
        senha = new JTextField();
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
        add(nome);
        add(cpf);
        add(dataNasc);
        add(email);
        add(senha);
        add(btnCadastrar);
        add(btnDeletar);
        add(btnAlterar);
        add(btnVoltar);
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
            email.setBackground(Colors.CINZALIGHTB);
            email.setForeground(Colors.BRANCO);
            senha.setBackground(Colors.CINZALIGHTB);
            senha.setForeground(Colors.BRANCO);
            cpf.setBackground(Colors.CINZALIGHTB);
            cpf.setForeground(Colors.BRANCO);
            nome.setBackground(Colors.CINZALIGHTB);
            nome.setForeground(Colors.BRANCO);
            dataNasc.setBackground(Colors.CINZALIGHTB);
            dataNasc.setForeground(Colors.BRANCO);
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
            email.setBackground(Colors.CINZALIGHTB);
            email.setForeground(Colors.CINZADARKA);
            senha.setBackground(Colors.CINZALIGHTB);
            senha.setForeground(Colors.CINZADARKA);
            nome.setBackground(Colors.CINZALIGHTB);
            nome.setForeground(Colors.CINZADARKA);
            cpf.setBackground(Colors.CINZALIGHTB);
            cpf.setForeground(Colors.CINZADARKA);
            dataNasc.setBackground(Colors.CINZALIGHTB);
            dataNasc.setForeground(Colors.CINZADARKA);
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

        email.setBorder(BorderFactory.createEmptyBorder());
        email.setBounds(210, 240, 400, 35);
        email.setHorizontalAlignment(JFormattedTextField.CENTER);

        nome.setBorder(BorderFactory.createEmptyBorder());
        nome.setBounds(210, 280, 400, 35);
        nome.setHorizontalAlignment(JFormattedTextField.CENTER);

        cpf.setBorder(BorderFactory.createEmptyBorder());
        cpf.setBounds(210, 320, 400, 35);
        cpf.setHorizontalAlignment(JFormattedTextField.CENTER);

        dataNasc.setBorder(BorderFactory.createEmptyBorder());
        dataNasc.setBounds(210, 360, 400, 35);
        dataNasc.setHorizontalAlignment(JFormattedTextField.CENTER);

        senha.setBorder(BorderFactory.createEmptyBorder());
        senha.setBounds(210, 400, 400, 35);
        senha.setHorizontalAlignment(JPasswordField.CENTER);

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

        logo.setText("TELA DE CADASTRO");
        logo.setFont(new Font("Monospaced", Font.ITALIC, 40));
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
            dataNasc.setFormatterFactory(new DefaultFormatterFactory(
                    new MaskFormatter("##/##/####")));
            cpf.setFormatterFactory(new DefaultFormatterFactory(
                    new MaskFormatter("###.###.###-##")));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnDeletar) {

        }
        if (e.getSource() == btnCadastrar) {
            Piloto piloto = new Piloto();
            piloto.setNome(nome.getText().toLowerCase());
            piloto.setEmail(email.getText().toLowerCase());
            piloto.setSenha(senha.getText().toLowerCase());
            piloto.setAtivo('S');
            piloto.setCpf(cpf.getText().toLowerCase());
            piloto.setDataNascimento(dataNasc.getText().toLowerCase());
            PilotoBO pilotoBO = new PilotoBO();
            try {
                if (pilotoBO.criarPiloto(piloto)) {
                    JOptionPane.showMessageDialog(null,"Piloto criado com sucesso!","Error",JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception error) {
                JOptionPane.showMessageDialog(null,error.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            }
        }
        if (e.getSource() == btnAlterar) {

        }
        if (e.getSource() == btnVoltar) {
            dispose();
            new LoginFrame();
        }
    }

}
