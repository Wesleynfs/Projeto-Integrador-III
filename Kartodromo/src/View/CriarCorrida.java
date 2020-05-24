package View;

import Model.Corrida;
import Model.Piloto;
import Utilities.Colors;
import Utilities.Fonts;
import Utilities.Info;
import Utilities.Tempo;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


public class CriarCorrida extends JFrame implements ActionListener {

    private JPanel fundo;
    private JPanel drawer;
    private JLabel logo;
    private JLabel lblDataDaCorrida;
    private JLabel lblNumeroDeVoltas;
    private JLabel lblNomeDaCorrida;
    private JFormattedTextField textFieldNomeCorrida;
    private JFormattedTextField textFieldVoltasDaCorrida;
    private JFormattedTextField textFieldDataCorrida;
    private JButton btnVoltar;
    private JButton btnCriarCorrida;
    private JTable tableKartodromo;
    private List<Corrida> listCorrida;
    private JFrame frame;

    private Piloto piloto;
    private DefaultTableModel tabelamento;

    public CriarCorrida(Piloto piloto , JFrame frame) {

        this.piloto = piloto;
        this.frame = frame;

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
        logo = new JLabel();
        lblDataDaCorrida = new JLabel();
        lblNumeroDeVoltas = new JLabel();
        lblNomeDaCorrida = new JLabel();
        textFieldDataCorrida = new JFormattedTextField();
        textFieldNomeCorrida = new JFormattedTextField();
        textFieldVoltasDaCorrida = new JFormattedTextField();
        btnVoltar = new JButton();
        btnCriarCorrida = new JButton();
        tableKartodromo = new JTable();
        listCorrida = new ArrayList<>();

    }

    private void add() {
        add(logo);
        add(btnVoltar);
        add(lblDataDaCorrida);
        add(lblNumeroDeVoltas);
        add(lblNomeDaCorrida);
        add(textFieldDataCorrida);
        add(textFieldNomeCorrida);
        add(textFieldVoltasDaCorrida);
        add(tableKartodromo);
        add(btnCriarCorrida);
        add(drawer);
        add(fundo);
    }

    private void setTheme() {

        //LoginFrame.getConfiguracao().isTema()

        if (true) {
            // Se o tema for escuro, os itens ficam assim //
            fundo.setBackground(Colors.CINZAMEDB);
            drawer.setBackground(Colors.VERDEDARK);
            logo.setForeground(Colors.CINZAMEDB);
            btnVoltar.setBackground(Colors.VERDEDARK);
            lblNomeDaCorrida.setForeground(Colors.CINZALIGHTB);
            lblNumeroDeVoltas.setForeground(Colors.CINZALIGHTB);
            lblDataDaCorrida.setForeground(Colors.CINZALIGHTB);
            textFieldDataCorrida.setBackground(Colors.CINZALIGHTB);
            textFieldDataCorrida.setForeground(Colors.BRANCO);
            textFieldNomeCorrida.setBackground(Colors.CINZALIGHTB);
            textFieldNomeCorrida.setForeground(Colors.BRANCO);
            textFieldVoltasDaCorrida.setBackground(Colors.CINZALIGHTB);
            textFieldVoltasDaCorrida.setForeground(Colors.BRANCO);
            btnVoltar.setForeground(Colors.CINZADARKB);
            btnCriarCorrida.setBackground(Colors.VERDEDARK);
            btnCriarCorrida.setForeground(Colors.CINZADARKB);
        } else {
            fundo.setBackground(Colors.CINZAMEDA);
            drawer.setBackground(Colors.VERDEDARK);
            logo.setForeground(Colors.CINZAMEDB);
            lblDataDaCorrida.setForeground(Colors.CINZALIGHTB);
            lblNumeroDeVoltas.setForeground(Colors.CINZALIGHTB);
            lblNomeDaCorrida.setForeground(Colors.CINZALIGHTB);
            textFieldVoltasDaCorrida.setBackground(Colors.CINZALIGHTB);
            textFieldVoltasDaCorrida.setForeground(Colors.CINZADARKA);
            textFieldNomeCorrida.setBackground(Colors.CINZALIGHTB);
            textFieldNomeCorrida.setForeground(Colors.CINZADARKA);
            textFieldDataCorrida.setBackground(Colors.CINZALIGHTB);
            textFieldDataCorrida.setForeground(Colors.CINZADARKA);
            btnVoltar.setBackground(Colors.VERDEDARK);
            btnVoltar.setForeground(Colors.CINZADARKB);
            btnCriarCorrida.setBackground(Colors.VERDEDARK);
            btnCriarCorrida.setForeground(Colors.CINZADARKB);
        }
    }

    private void configs() {

        fundo.setSize(Info.MINSCREENSIZE);
        drawer.setBounds(0, 0, 800, 100);

        logo.setBounds(20, 30, 700, 35);
        logo.setText("GERENCIAR CORRIDAS");
        logo.setFont(Fonts.SANSSERIFMIN);

//        ClasseDao dao = new ClasseDao();
//        for(classe c:dao.FindALL()){
//            NomeKartodromojComboBox.addItem(c);
//        }
        //se selecionar um kartodromo em especifico ele

        tableKartodromo.setBounds(30,220,740,300);
        tableKartodromo.setModel(new DefaultTableModel(
                new Object[][]{

                },
                new String[]{
                        "NOME DA CORRIDA","DATA DA CORRIDA", "NÚMERO DE VOLTAS"
                }
        ) {
            boolean[] canEdit = new boolean[]{
                    false, false , false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }

        });

        tabelamento = (DefaultTableModel) tableKartodromo.getModel();

        tabelamento.addRow(new Object[]{
                "",
                "",
        });

        textFieldVoltasDaCorrida.setBorder(BorderFactory.createEmptyBorder());
        textFieldVoltasDaCorrida.setBounds(540,140,230,35);
        textFieldVoltasDaCorrida.setHorizontalAlignment(JFormattedTextField.CENTER);

        textFieldNomeCorrida.setBorder(BorderFactory.createEmptyBorder());
        textFieldNomeCorrida.setBounds(30,140,230,35);
        textFieldNomeCorrida.setHorizontalAlignment(JFormattedTextField.CENTER);

        textFieldDataCorrida.setBorder(BorderFactory.createEmptyBorder());
        textFieldDataCorrida.setBounds(285,140,230,35);
        textFieldDataCorrida.setHorizontalAlignment(JFormattedTextField.CENTER);

        lblNumeroDeVoltas.setText("Numero de voltas da corrida");
        lblNumeroDeVoltas.setBounds(540,100,200,35);

        lblDataDaCorrida.setText("Data da corrida");
        lblDataDaCorrida.setBounds(285,100,200,35);

        lblNomeDaCorrida.setText("Nome da corrida");
        lblNomeDaCorrida.setBounds(30,100,200,35);

        btnVoltar.setText("SALVAR / DESCARTAR");
        btnVoltar.setBorderPainted(false);
        btnVoltar.setFocusPainted(false);
        btnVoltar.addActionListener(this);
        btnVoltar.setBounds(20, 550, 170, 35);

        btnCriarCorrida.setFocusPainted(false);
        btnCriarCorrida.setBorderPainted(false);
        btnCriarCorrida.addActionListener(this);
        btnCriarCorrida.setText("ADICIONAR CORRIDA");
        btnCriarCorrida.setBounds(620, 550, 160, 35);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnVoltar) {


            if (JOptionPane.showConfirmDialog(null,
                    "Deseja salvar alterações?",
                    "Salvar",
                    JOptionPane.YES_NO_OPTION) == 0) {
                this.dispose();
                new CriarCampeonato(piloto , listCorrida);
            } else {
                this.dispose();
                frame.setVisible(true);
            }

        }

        if (e.getSource() == btnCriarCorrida) {

            // AQUI CRIA TODAS AS CORRIDAS E DEVOLVE PARA A TELA "CRIAR CAMPEONATO" //

            Corrida corrida = new Corrida();
            corrida.setNumeroDeVoltas(2);
            corrida.setDataCorrida(Tempo.getCurrentTime());

            listCorrida.add(corrida);

            // Adiciona na tabela //

        }
    }
}
