package Utilities;

import Bo.ConfiguracaoBO;

import java.awt.*;

public class Info {
    public static final String APP_NAME = "KART_ON_ROAD";
    public static final String APP_VERSION = "Ver. 0.1";
    public static final String USERHOME = System.getProperty("user.home");  // C:\Users\kakoa
    public static final Dimension SCREENSIZE = Toolkit.getDefaultToolkit().getScreenSize();
    public static final Dimension SCREENHIGH = new Dimension(1280,720);
    public static final boolean TEMA = new ConfiguracaoBO().lerConfiguracao().isTema();
}
