package View;

import Bo.AvaliacaoBO;
import Model.Avaliacao;
import Model.Kartodromo;
import Model.Piloto;
import Utilities.Colors;
import Utilities.Fonts;
import Utilities.Info;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

public class PerfilKartodromo extends JFrame implements ActionListener {

    private JPanel fundo;
    private JPanel drawer;
    private JButton btnVoltar;
    private JLabel logo;
    private JLabel avaliacoesLabel;
    private JLabel MediaLabel;
    private JScrollPane jScrollPanekartodromo;
    private JTable tableKartodromo;
    private DefaultTableModel tabelamento;

    private Piloto piloto;
    private Kartodromo kartodromo;
    public PerfilKartodromo(Piloto piloto, Kartodromo kartodromo) throws Exception {
        this.piloto = piloto;
        this.kartodromo = kartodromo;
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

        btnVoltar = new JButton();
        logo = new JLabel();
        avaliacoesLabel = new JLabel();
        MediaLabel = new JLabel();
                
        jScrollPanekartodromo = new JScrollPane();
        tableKartodromo = new JTable();

    }

    private void add() {
        add(btnVoltar);
        add(avaliacoesLabel);
        add(MediaLabel);
        add(logo);
        add(jScrollPanekartodromo);
        add(drawer);
        add(fundo);
    }

    private void setTheme() {
        if (LoginFrame.getConfiguracao().isTema()) {
            // Se o tema for escuro, os itens ficam assim //
            fundo.setBackground(Colors.CINZAMEDB);
            drawer.setBackground(Colors.VERDEDARK);
   
            logo.setForeground(Colors.CINZAMEDB);
            tableKartodromo.setBackground(Colors.VERDELIGHT);
            tableKartodromo.setForeground(Colors.CINZADARKB);
            MediaLabel.setForeground(Colors.CINZAMEDA);
            avaliacoesLabel.setForeground(Colors.CINZAMEDA);
            btnVoltar.setForeground(Colors.CINZADARKB);
            btnVoltar.setBackground(Colors.VERDEDARK);

        } else {

            fundo.setBackground(Colors.CINZAMEDA);
            drawer.setBackground(Colors.VERDEDARK);          
            logo.setForeground(Colors.CINZAMEDB);
            tableKartodromo.setForeground(Colors.CINZADARKB);
            tableKartodromo.setBackground(Colors.VERDEDARK);
            MediaLabel.setForeground(Colors.CINZALIGHTB);
            avaliacoesLabel.setForeground(Colors.CINZALIGHTB);
            btnVoltar.setForeground(Colors.CINZADARKB);
            btnVoltar.setBackground(Colors.VERDEDARK);
         
        }
    }
    private void configs() throws Exception {
        try {
        fundo.setSize(Info.MINSCREENSIZE);

        drawer.setBounds(0, 0, 800, 100);

        

            tableKartodromo.setModel(new DefaultTableModel(
                    new Object[][]{

                    },
                    new String[]{
                            "NOME DO PILOTO","COMENTÁRIOS","NOTAS"
                    }
            ) {
                boolean[] canEdit = new boolean[]{
                        false ,false, false
                };
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit[columnIndex];
                }

            });

            tabelamento = (DefaultTableModel) tableKartodromo.getModel();

            AvaliacaoBO list = new AvaliacaoBO(); 
            String nota = null;
            for (Avaliacao avaliacao : list.listarPorKartodromo(kartodromo)){
                
                switch (avaliacao.getNumeroEstrelas()){
                    case 1:
                        nota = "Muito Ruim";
                        break;
                    case 2:
                        nota = "Ruim";
                        break;
                    case 3:
                        nota = "Médio";
                        break;
                    case 4:
                        nota = "Bom";
                        break;
                    case 5:
                        nota = "Muito Bom";
                        break;
                }
                
                tabelamento.addRow(new Object[]{
                    avaliacao.getPiloto().getNomePiloto(),
                    avaliacao.getComentario(),
                    nota
                });
            }
            jScrollPanekartodromo.setViewportView(tableKartodromo);
            jScrollPanekartodromo.setBounds(60, 150, 680, 300);

            logo.setFont(Fonts.SANSSERIFMIN);
            logo.setBounds(20 , 30,500,35);
            logo.setText("PERFIL DO KARTÓDROMO");

            avaliacoesLabel.setBounds(300, 120, 300, 35);
            avaliacoesLabel.setText("Avaliações do Kartódromo: " + kartodromo.getNomeKartodromo());
            // AQUI COLOCA O NOME DA CORRIDA
            //
            
            
            
            
           
            
            MediaLabel.setBounds(320, 480, 300, 35);
            MediaLabel.setText("MÉDIA DAS NOTAS: " );
            //AQUI COLOCA O NOME DO PRIMEIRO COLOCADO DA CORRIDA      
            //        
                    
                    
            btnVoltar.setBorderPainted(false);
            btnVoltar.setFocusPainted(false);
            btnVoltar.addActionListener(this);
            btnVoltar.setBounds(320 , 540,200,35);
            btnVoltar.setText("VOLTAR"); 
            

        
        } catch (Exception error) {
            JOptionPane.showMessageDialog(null, "Erro ao visualizar avaliações", "Error:", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnVoltar) {
            dispose();
            new AvaliarKartodromo(piloto);
        }

    }


} 
