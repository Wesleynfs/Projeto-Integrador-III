package View;

import Connections.ConnectionFactory;
import Utilities.Colors;
import Utilities.Info;
import Utilities.Fonts;

import javax.swing.*;

public class SplashScreen extends JFrame {

    private JLabel logo;
    private JLabel loadingBar;
    private JLabel connectingLabel;
    private JPanel background;

    public SplashScreen() {
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
        // Inicializa banco de dados //
        initAplication();

    }

    private void initAplication() {
        new Thread(() -> {
            // Para inicializar a conexão com o banco junto com a inicialização do aplicativo //
            new ConnectionFactory().getConnection();
        }).start();
        try {
            Thread.sleep(5000);
        } catch (Exception e) {

        }
        this.dispose();
        new LoginFrame();
    }

    private void configurateThis() {
        setUndecorated(true);
        setSize(640,360);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle(Info.APP_NAME);
        setResizable(false);
    }

    private void configs() {

        connectingLabel.setText("Conectando...");
        connectingLabel.setBounds(290,270,160,30);

        logo.setText("Kart on Road");
        logo.setFont(Fonts.SANSSERIF);
        logo.setBounds(30,30,400,50);

        loadingBar.setBounds(250,300,160,30);
        loadingBar.setIcon(new ImageIcon(getClass().getResource("/Utilities/imgs/loading.gif")));

        background.setBounds(0,0,640,360);
    }

    private void add() {
        add(logo);
        add(connectingLabel);
        add(loadingBar);
        add(background);
    }

    private void initializate() {
        loadingBar = new JLabel();
        connectingLabel = new JLabel();
        logo = new JLabel();
        background = new JPanel();
    }

    private void setTheme() {
        background.setBackground(Colors.CINZAMEDB);
        logo.setForeground(Colors.VERDEDARK);
        connectingLabel.setForeground(Colors.CINZALIGHTB);
    }

}
