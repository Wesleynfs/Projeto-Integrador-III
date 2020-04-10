package View;

import Bo.PilotoBO;
import Model.Piloto;
import Utilities.Colors;
import Utilities.Fonts;
import Utilities.Info;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastrarUsuario extends JFrame implements ActionListener {

    private JPanel fundo;
    private JPanel drawer;
    private JFormattedTextField nome;
    private JFormattedTextField email;
    private JFormattedTextField dataNasc;
    private JFormattedTextField cpf;
    private JFormattedTextField senha;
    private JLabel version;
    private JLabel loginLabel;
    private JLabel senhaLabel;
    private JButton btnVoltar;
    private JLabel logo;
    private JLabel nomeLabel;
    private JLabel cpfLabel;
    private JLabel dataNascLabel;
    private JButton btnCadastrar;

    public CadastrarUsuario() throws Exception {

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
        setSize(800,600);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle(Info.APP_NAME);
        setResizable(false);
    }

    private void initializate() throws Exception {
        nomeLabel = new JLabel();
        dataNascLabel = new JLabel();
        cpfLabel = new JLabel();
        fundo = new JPanel();
        drawer = new JPanel();
        nome = new JFormattedTextField();
        dataNasc = new JFormattedTextField(new MaskFormatter("##/##/####"));
        cpf = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
        email = new JFormattedTextField();
        senha = new JFormattedTextField();
        version = new JLabel();
        loginLabel = new JLabel();
        senhaLabel = new JLabel();
        logo = new JLabel();
        btnVoltar = new JButton();
        btnCadastrar = new JButton();
    }

    private void add() {
        add(nome);
        add(cpf);
        add(dataNasc);
        add(email);
        add(senha);
        add(btnCadastrar);
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
        if (Info.TEMA) {
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
            btnVoltar.setBackground(Colors.VERDEDARK);
            btnVoltar.setForeground(Colors.CINZADARKB);
            btnCadastrar.setBackground(Colors.VERDEDARK);
            btnCadastrar.setForeground(Colors.CINZADARKB);
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
            logo.setForeground(Colors.CINZAMEDA);
            btnVoltar.setBackground(Colors.VERDEDARK);
            btnVoltar.setForeground(Colors.CINZADARKB);
            btnCadastrar.setBackground(Colors.VERDEDARK);
            btnCadastrar.setForeground(Colors.CINZADARKB);
        }
    }

    private void configs() {

        fundo.setSize(800,600);

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

        version.setText(Info.APP_VERSION);
        version.setBounds(20,10 , 100,35);

        logo.setText("KART ON ROAD");
        logo.setFont(Fonts.SANSSERIF);
        logo.setBounds(20,40,700,180);

        btnVoltar.setText("VOLTAR");
        btnVoltar.setBorderPainted(false);
        btnVoltar.setFocusPainted(false);
        btnVoltar.addActionListener(this);
        btnVoltar.setBounds(20,550, 100,35);

        btnCadastrar.setFocusPainted(false);
        btnCadastrar.setBorderPainted(false);
        btnCadastrar.addActionListener(this);
        btnCadastrar.setText("Cadastrar Usuário");
        btnCadastrar.setBounds(640,550,140,35);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnVoltar) {
            dispose();
            new LoginFrame();
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
    }

}
