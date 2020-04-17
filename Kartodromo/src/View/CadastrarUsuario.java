package View;

import Bo.PilotoBO;
import Model.Piloto;
import Utilities.Colors;
import Utilities.Fonts;
import Utilities.Info;
import java.awt.Font;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastrarUsuario extends JFrame implements ActionListener {

    private JPanel fundo;
    private JPanel drawer;
    private JTextField nome;
    private JTextField email;
    private JTextField dataNasc;
    private JTextField cpf;
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
        setSize(800,700);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("CADASTRO");
        setResizable(false);
    }

    private void initializate() {
        nomeLabel = new JLabel();
        dataNascLabel = new JLabel();
        cpfLabel = new JLabel();
        fundo = new JPanel();
        drawer = new JPanel();
        nome = new JTextField();
        dataNasc = new JTextField();
        cpf = new JTextField();
        email = new JTextField();
        senha = new JTextField();
        version = new JLabel();
        loginLabel = new JLabel();
        senhaLabel = new JLabel();
        logo = new JLabel();
        btnDeletar = new JButton();
        btnCadastrar = new JButton();
        btnAlterar = new JButton();
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
        }

    private void configs() {

        fundo.setSize(800,700);

        drawer.setBounds(0,0,800,200);

        email.setBorder(BorderFactory.createEmptyBorder());
        email.setBounds(210,280,400,35);
        email.setHorizontalAlignment(JFormattedTextField.CENTER);

        nome.setBorder(BorderFactory.createEmptyBorder());
        nome.setBounds(210,320,400,35);
        nome.setHorizontalAlignment(JFormattedTextField.CENTER);

        cpf.setBorder(BorderFactory.createEmptyBorder());
        cpf.setBounds(210,360,400,35);
        cpf.setHorizontalAlignment(JFormattedTextField.CENTER);

        dataNasc.setBorder(BorderFactory.createEmptyBorder());
        dataNasc.setBounds(210,400,400,35);
        dataNasc.setHorizontalAlignment(JFormattedTextField.CENTER);

        senha.setBorder(BorderFactory.createEmptyBorder());
        senha.setBounds(210,440,400,35);
        senha.setHorizontalAlignment(JPasswordField.CENTER);

        loginLabel.setText("EMAIL");
        loginLabel.setBounds(160,280,400,35);

        nomeLabel.setText("NOME");
        nomeLabel.setBounds(160,320,400,35);

        cpfLabel.setText("CPF");
        cpfLabel.setBounds(160,360,400,35);

        dataNascLabel.setText("DATA DE NASCIMENTO");
        dataNascLabel.setBounds(70,400,400,35);

        senhaLabel.setText("SENHA");
        senhaLabel.setBounds(160,440,400,35);

        version.setText("1.0");
        version.setBounds(20,10 , 100,35);

        logo.setText("TELA DE CADASTRO");
        logo.setFont(new Font("Monospaced", Font.ITALIC, 40));
        logo.setBounds(20,40,700,180);

        btnDeletar.setText("DELETAR");
        btnDeletar.setBorderPainted(false);
        btnDeletar.setFocusPainted(false);
        btnDeletar.addActionListener(this);
        btnDeletar.setBounds(20,550, 100,35);
        
        btnAlterar.setText("ALTERAR");
        btnAlterar.setBorderPainted(false);
        btnAlterar.setFocusPainted(false);
        btnAlterar.addActionListener(this);
        btnAlterar.setBounds(350,550, 100,35);

        btnCadastrar.setFocusPainted(false);
        btnCadastrar.setBorderPainted(false);
        btnCadastrar.addActionListener(this);
        btnCadastrar.setText("Cadastrar");
        btnCadastrar.setBounds(640,550,140,35);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnDeletar) {
            
        }
        if (e.getSource() == btnCadastrar) {

        }
        if (e.getSource() == btnAlterar) {

        }
    }

}
