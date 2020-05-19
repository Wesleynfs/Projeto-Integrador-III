package View;

import Bo.KartodromoBO;
import Model.Kartodromo;
import Utilities.Colors;
import Utilities.Fonts;
import Utilities.Info;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

public class CadastrarKartodromoPt2 extends JFrame implements ActionListener {

    private JPanel fundo;
    private JPanel drawer;
    private JFormattedTextField estadoTextField;
    private JFormattedTextField cidadeTextField;
    private JFormattedTextField ruaTextField;
    private JSpinner numeroJSpinner;
    private JLabel version;
    private JLabel logo;
    private JLabel diassemanaLabel;
    private JLabel tipokartsLabel;
    private JLabel estadoLabel;
    private JLabel cidadeLabel;
    private JLabel ruaLabel;
    private JLabel numeroLabel;
    private JButton btn_Voltar;
    private JButton btnCadastrar;
    private JLabel telefoneLabel;
    private JFormattedTextField telefoneTextField;

    private Kartodromo kartodromo;

    private JCheckBox[] listCheckBox;

    public CadastrarKartodromoPt2(Kartodromo kartodromo) {
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

        this.kartodromo = kartodromo;

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
        numeroJSpinner = new JSpinner();
        estadoTextField = new JFormattedTextField();
        cidadeTextField = new JFormattedTextField();
        ruaTextField = new JFormattedTextField();
        version = new JLabel();
        logo = new JLabel();
        estadoLabel = new JLabel();
        cidadeLabel = new JLabel();
        ruaLabel = new JLabel();
        numeroLabel = new JLabel();
        diassemanaLabel = new JLabel();
        tipokartsLabel = new JLabel();
        btn_Voltar = new JButton();
        btnCadastrar = new JButton();
        listCheckBox = new JCheckBox[12];
        telefoneTextField = new JFormattedTextField();
        telefoneLabel = new JLabel();

        for (int x = 0 ; x < listCheckBox.length ; x++) {
            listCheckBox[x] = new JCheckBox();
        }

    }

    private void add() {

        for (JCheckBox checkBox : listCheckBox) {
            add(checkBox);
        }

        add(telefoneLabel);
        add(telefoneTextField);
        add(numeroJSpinner);
        add(estadoTextField);
        add(cidadeTextField);
        add(ruaTextField);
        add(estadoLabel);
        add(cidadeLabel);
        add(ruaLabel);
        add(numeroLabel);
        add(diassemanaLabel);
        add(tipokartsLabel);
        add(version);
        add(logo);
        add(btnCadastrar);
        add(btn_Voltar);
        add(drawer);
        add(fundo);

    }

    private void setTheme() {

        if (LoginFrame.getConfiguracao().isTema()) {
            // Se o tema for escuro, os itens ficam assim //
            estadoTextField.setBackground(Colors.CINZALIGHTB);
            estadoTextField.setForeground(Colors.BRANCO);
            cidadeTextField.setBackground(Colors.CINZALIGHTB);
            telefoneTextField.setForeground(Colors.BRANCO);
            telefoneTextField.setBackground(Colors.CINZALIGHTB);
            cidadeTextField.setForeground(Colors.BRANCO);
            ruaTextField.setBackground(Colors.CINZALIGHTB);
            ruaTextField.setForeground(Colors.BRANCO);
            numeroJSpinner.getEditor().getComponent(0).setBackground(Colors.CINZALIGHTB);
            numeroJSpinner.getEditor().getComponent(0).setForeground(Colors.BRANCO);
            estadoLabel.setForeground(Colors.CINZALIGHTB);
            cidadeLabel.setForeground(Colors.CINZALIGHTB);
            telefoneLabel.setForeground(Colors.CINZALIGHTB);
            ruaLabel.setForeground(Colors.CINZALIGHTB);
            numeroLabel.setForeground(Colors.CINZALIGHTB);
            tipokartsLabel.setForeground(Colors.CINZALIGHTB);
            diassemanaLabel.setForeground(Colors.CINZALIGHTB);
            version.setForeground(Colors.CINZALIGHTB);
            logo.setForeground(Colors.CINZAMEDB);
            btn_Voltar.setBackground(Colors.VERDEDARK);
            btn_Voltar.setForeground(Colors.CINZADARKB);
            btnCadastrar.setBackground(Colors.VERDEDARK);
            btnCadastrar.setForeground(Colors.CINZADARKB);
            fundo.setBackground(Colors.CINZAMEDB);
            drawer.setBackground(Colors.VERDEDARK);

            for (JCheckBox checkBox : listCheckBox) {
                checkBox.setForeground(Colors.BRANCO);
                checkBox.setBackground(Colors.CINZALIGHTB);
            }

        } else {

            estadoTextField.setBackground(Colors.CINZALIGHTB);
            estadoTextField.setForeground(Colors.CINZADARKA);
            cidadeTextField.setBackground(Colors.CINZALIGHTB);
            cidadeTextField.setForeground(Colors.CINZADARKA);
            telefoneTextField.setBackground(Colors.CINZALIGHTB);
            telefoneTextField.setForeground(Colors.CINZADARKA);
            ruaTextField.setBackground(Colors.CINZALIGHTB);
            ruaTextField.setForeground(Colors.CINZADARKA);
            numeroJSpinner.getEditor().getComponent(0).setBackground(Colors.CINZALIGHTB);
            numeroJSpinner.getEditor().getComponent(0).setForeground(Colors.BRANCO);
            numeroLabel.setForeground(Colors.CINZALIGHTB);
            estadoLabel.setForeground(Colors.CINZALIGHTB);
            cidadeLabel.setForeground(Colors.CINZALIGHTB);
            telefoneLabel.setForeground(Colors.CINZALIGHTB);
            ruaLabel.setForeground(Colors.CINZALIGHTB);
            tipokartsLabel.setForeground(Colors.CINZALIGHTB);
            diassemanaLabel.setForeground(Colors.CINZALIGHTB);
            version.setForeground(Colors.CINZALIGHTB);
            logo.setForeground(Colors.CINZAMEDB);
            btn_Voltar.setBackground(Colors.VERDEDARK);
            btn_Voltar.setForeground(Colors.CINZADARKB);
            btnCadastrar.setBackground(Colors.VERDEDARK);
            btnCadastrar.setForeground(Colors.CINZADARKB);
            fundo.setBackground(Colors.CINZAMEDA);
            drawer.setBackground(Colors.VERDEDARK);

            for (JCheckBox checkBox : listCheckBox) {
                checkBox.setForeground(Colors.BRANCO);
                checkBox.setBackground(Colors.CINZALIGHTB);
            }
        }
    }

    private void configs() {

        fundo.setSize(Info.MINSCREENSIZE);
        drawer.setBounds(0, 0, 800, 200);
        diassemanaLabel.setText("Dias de Funcionamento:");
        diassemanaLabel.setBounds(20, 230, 150, 35);
        tipokartsLabel.setText("Tipos de Kart (MOTOR)");
        tipokartsLabel.setBounds(210, 230, 150, 35);

        for (int x = 0; x < listCheckBox.length; x++) {
            if (x == 0) {
                listCheckBox[0].setText("Domingo");
                listCheckBox[0].setBounds(20, 260, 150, 30);
            }
            if (x == 1) {
                listCheckBox[1].setText("Sabado");
                listCheckBox[1].setBounds(20, 290, 150, 30);
            }
            if (x == 2) {
                listCheckBox[2].setText("Segunda Feira");
                listCheckBox[2].setBounds(20, 320, 150, 30);
            }
            if (x == 3) {
                listCheckBox[3].setText("Terça Feira");
                listCheckBox[3].setBounds(20, 350, 150, 30);
            }
            if (x == 4) {
                listCheckBox[4].setText("Quarta Feira");
                listCheckBox[4].setBounds(20, 380, 150, 30);
            }
            if (x == 5) {
                listCheckBox[5].setText("Quinta Feira");
                listCheckBox[5].setBounds(20, 410, 150, 30);
            }
            if (x == 6) {
                listCheckBox[6].setText("Sexta Feira");
                listCheckBox[6].setBounds(20, 440, 150, 30);
            }
            if (x == 7) {
                listCheckBox[7].setText("INDOOR");
                listCheckBox[7].setBounds(210, 260, 150, 35);
            }
            if (x == 8) {
                listCheckBox[8].setText("MOTOR 2 TEMPOS");
                listCheckBox[8].setBounds(210, 290, 150, 35);
            }
            if (x == 9) {
                listCheckBox[9].setText("MOTOR 4 TEMPOS");
                listCheckBox[9].setBounds(210, 320, 150, 35);
            }
            if (x == 10) {
                listCheckBox[10].setText("SHIFTER");
                listCheckBox[10].setBounds(210, 380, 150, 35);
            }
            if (x == 11) {
                listCheckBox[11].setText("SEM MARCHA");
                listCheckBox[11].setBounds(210, 350, 150, 35);
            }
            listCheckBox[x].setFocusPainted(false);
        }

        estadoLabel.setText("Estado:");
        estadoLabel.setBounds(600, 230, 200, 35);

        telefoneLabel.setText("Telefone Comercial:");
        telefoneLabel.setBounds(400, 230, 200, 35);

        telefoneTextField.setBorder(BorderFactory.createEmptyBorder());
        telefoneTextField.setBounds(400, 260, 150, 35);
        telefoneTextField.setHorizontalAlignment(JFormattedTextField.CENTER);

        try {
            telefoneTextField.setFormatterFactory(new DefaultFormatterFactory(
                    new MaskFormatter("(##)####-####")));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        estadoTextField.setBorder(BorderFactory.createEmptyBorder());
        estadoTextField.setBounds(600, 260, 150, 35);
        estadoTextField.setHorizontalAlignment(JFormattedTextField.CENTER);

        cidadeLabel.setText("Cidade:");
        cidadeLabel.setBounds(400, 310, 200, 35);

        cidadeTextField.setBorder(BorderFactory.createEmptyBorder());
        cidadeTextField.setBounds(400, 340, 150, 35);
        cidadeTextField.setHorizontalAlignment(JFormattedTextField.CENTER);

        numeroLabel.setText("Número (Endereço) :");
        numeroLabel.setBounds(600, 310, 200, 35);

        numeroJSpinner.setBounds(600, 340, 150, 35);
        numeroJSpinner.setBorder(BorderFactory.createEmptyBorder());

        ruaLabel.setText("Rua:");
        ruaLabel.setBounds(400, 390, 200, 35);

        ruaTextField.setBorder(BorderFactory.createEmptyBorder());
        ruaTextField.setBounds(400, 420, 350, 35);
        ruaTextField.setHorizontalAlignment(JFormattedTextField.CENTER);

        version.setText(Info.APP_VERSION);
        version.setBounds(20, 10, 100, 30);

        logo.setText(Info.APP_NAME);
        logo.setFont(Fonts.SANSSERIF);
        logo.setBounds(20, 40, 700, 180);

        btn_Voltar.setText("VOLTAR");
        btn_Voltar.setBorderPainted(false);
        btn_Voltar.setFocusPainted(false);
        btn_Voltar.addActionListener(this);
        btn_Voltar.setBounds(20, 550, 100, 35);

        btnCadastrar.setFocusPainted(false);
        btnCadastrar.setBorderPainted(false);
        btnCadastrar.addActionListener(this);
        btnCadastrar.setText("CADASTRAR");
        btnCadastrar.setBounds(620, 550, 160, 35);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btn_Voltar) {
            if (JOptionPane.showConfirmDialog(null, "Tem certeza?", "Confirmação", JOptionPane.YES_NO_OPTION) == 0) {
                dispose();
                new CadastrarKartodromoPt1();
            }
        }

        if (e.getSource() == btnCadastrar) {
            if ((!estadoTextField.getText().isEmpty())
                    || (!cidadeTextField.getText().isEmpty())
                    || (!ruaTextField.getText().isEmpty())
                    || (!numeroJSpinner.getValue().toString().equals(""))
                    || (validarCheckBox())) {

                kartodromo.setEstado(estadoTextField.getText());
                kartodromo.setCidade(cidadeTextField.getText());
                kartodromo.setRua(ruaTextField.getText());
                kartodromo.setNumero(Integer.valueOf(numeroJSpinner.getValue().toString()));
                kartodromo.setTelefone(telefoneTextField.getText());

                kartodromo.setDiaEmAtividadeDomingo(listCheckBox[0].isSelected());
                kartodromo.setDiaEmAtividadeSabado(listCheckBox[1].isSelected());
                kartodromo.setDiaEmAtividadeSegunda(listCheckBox[2].isSelected());
                kartodromo.setDiaEmAtividadeTerca(listCheckBox[3].isSelected());
                kartodromo.setDiaEmAtividadeQuarta(listCheckBox[4].isSelected());
                kartodromo.setDiaEmAtividadeQuinta(listCheckBox[5].isSelected());
                kartodromo.setDiaEmAtividadeSexta(listCheckBox[6].isSelected());

                kartodromo.setKartIndoor(listCheckBox[7].isSelected());
                kartodromo.setKartMotor2Tempos(listCheckBox[8].isSelected());
                kartodromo.setKartMotor4Tempos(listCheckBox[9].isSelected());
                kartodromo.setKartShifter(listCheckBox[10].isSelected());
                kartodromo.setKartSemMarcha(listCheckBox[11].isSelected());

                kartodromo.setStatusAtividade(true);

                KartodromoBO kartodromoBO = new KartodromoBO();
                try {
                    if (kartodromoBO.criar(kartodromo)) {
                        JOptionPane.showConfirmDialog(null,"Conta criada com sucesso","Sucesso",JOptionPane.PLAIN_MESSAGE);
                    } else {
                        JOptionPane.showConfirmDialog(null,"Erro ao criar kartodromo, contate aos desenvolvedores", "Erro",JOptionPane.PLAIN_MESSAGE);
                    }
                    dispose();
                    new LoginFrame();
                } catch (Exception error) {
                    JOptionPane.showConfirmDialog(null,
                            error.getMessage(),
                            "Erro" ,
                            JOptionPane.PLAIN_MESSAGE);
                }
            }
        }
    }

    private boolean validarCheckBox() {
        boolean validar = false;
        for (int x = 0; x < listCheckBox.length; x++) {
            if (!listCheckBox[x].isSelected()) {
                validar = false;
            } else {
                validar = true;
                break;
            }
        }
        return validar;
    }

}