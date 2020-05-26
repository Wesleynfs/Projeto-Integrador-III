package View;

import Model.Campeonato;
import Model.Corrida;
import Model.Piloto;
import Utilities.*;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    private JButton btnRemoverCorrida;
    private JTable table;
    private GerenciarCampeonato gerenciarCampeonato;
    private JScrollPane scroll;
    private DefaultTableCellRenderer renderer;

    private Piloto piloto;
    private Campeonato campeonato;
    private TabelaPiloto tabelaPiloto;

    public CriarCorrida(Piloto piloto, Campeonato campeonato, GerenciarCampeonato gerenciarCampeonato) {

        this.piloto = piloto;
        this.gerenciarCampeonato = gerenciarCampeonato;
        this.campeonato = campeonato;

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
        btnRemoverCorrida = new JButton();
        btnCriarCorrida = new JButton();
        table = new JTable();
        tabelaPiloto = new TabelaPiloto();
        renderer = new DefaultTableCellRenderer();
        scroll = new JScrollPane(table);

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
        add(table);
        add(scroll);
        add(btnRemoverCorrida);
        add(btnCriarCorrida);
        add(drawer);
        add(fundo);
    }

    private void setTheme() {

        if (SplashScreen.getConfiguracao().isTema()) {
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
            btnRemoverCorrida.setBackground(Colors.VERDEDARK);
            btnRemoverCorrida.setForeground(Colors.CINZADARKB);
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
            btnRemoverCorrida.setBackground(Colors.VERDEDARK);
            btnRemoverCorrida.setForeground(Colors.CINZADARKB);
        }
    }

    private void configs() {

        fundo.setSize(Info.MINSCREENSIZE);
        drawer.setBounds(0, 0, 800, 100);

        logo.setBounds(20, 30, 700, 35);
        logo.setText("GERENCIAR CORRIDAS");
        logo.setFont(Fonts.SANSSERIFMIN);

        scroll.setViewportView(table);
        scroll.setBounds(30, 220, 740, 300);

        renderer.setHorizontalTextPosition(JLabel.CENTER);
        table.setModel(tabelaPiloto);
        table.setDefaultRenderer(String.class, renderer);

        textFieldVoltasDaCorrida.setBorder(BorderFactory.createEmptyBorder());
        textFieldVoltasDaCorrida.setBounds(540, 140, 230, 35);
        textFieldVoltasDaCorrida.setHorizontalAlignment(JFormattedTextField.CENTER);

        textFieldNomeCorrida.setBorder(BorderFactory.createEmptyBorder());
        textFieldNomeCorrida.setBounds(30, 140, 230, 35);
        textFieldNomeCorrida.setHorizontalAlignment(JFormattedTextField.CENTER);

        textFieldDataCorrida.setBorder(BorderFactory.createEmptyBorder());
        textFieldDataCorrida.setBounds(285, 140, 230, 35);
        textFieldDataCorrida.setHorizontalAlignment(JFormattedTextField.CENTER);

        try {
            textFieldDataCorrida.setFormatterFactory(
                    new DefaultFormatterFactory(
                            new MaskFormatter("##/##/####")));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        lblNumeroDeVoltas.setText("Numero de voltas da corrida");
        lblNumeroDeVoltas.setBounds(540, 100, 200, 35);

        lblDataDaCorrida.setText("Data da corrida");
        lblDataDaCorrida.setBounds(285, 100, 200, 35);

        lblNomeDaCorrida.setText("Nome da corrida");
        lblNomeDaCorrida.setBounds(30, 100, 200, 35);

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

        btnRemoverCorrida.setFocusPainted(false);
        btnRemoverCorrida.setBorderPainted(false);
        btnRemoverCorrida.addActionListener(this);
        btnRemoverCorrida.setText("REMOVER CORRIDA");
        btnRemoverCorrida.setBounds(430, 550, 160, 35);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnVoltar) {

            if (JOptionPane.showConfirmDialog(null,
                    "Deseja salvar alterações?",
                    "Salvar",
                    JOptionPane.YES_NO_OPTION) == 0) {
                this.dispose();

                int tamanho = tabelaPiloto.getListCorrida().size();
                campeonato.setCorrida(tabelaPiloto.getListCorrida().toArray(new Corrida[tamanho]));
                gerenciarCampeonato.setCampeonato(campeonato);
                gerenciarCampeonato.getBtnCriarCampeonato().setEnabled(true);
                gerenciarCampeonato.setVisible(true);
            } else {
                this.dispose();
                gerenciarCampeonato.setVisible(true);
            }

        }

        if (e.getSource() == btnCriarCorrida) {
            Corrida corrida = new Corrida();
            corrida.setNomeCorrida(textFieldNomeCorrida.getText());
            corrida.setNumeroDeVoltas(Integer.valueOf(textFieldVoltasDaCorrida.getText()));
            corrida.setDataCorrida(Tempo.stringToDate(textFieldDataCorrida.getText()));
            tabelaPiloto.addRow(corrida);
        }

        if (e.getSource() == btnRemoverCorrida) {
            if (table.getSelectedRow() != -1) {
                tabelaPiloto.removeRow(table.getSelectedRow());
            }
        }

    }
}
