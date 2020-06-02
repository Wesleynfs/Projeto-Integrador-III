package Utilities;

import java.awt.*;
import java.sql.Timestamp;

public class Info {
    public static final String APP_NAME = "KART ON ROAD";
    public static final String APP_VERSION = "Ver. 0.6";
    public static final String USERHOME = System.getProperty("user.home");  // C:\Users\kakoa
    public static final Dimension MAXSCREENSIZE = new Dimension(1280,720);
    public static final Dimension MINSCREENSIZE = new Dimension(800,600);
    public static final int numero_minimo_de_pilotos_em_campeonato_oficial = 10;
    public static final String campeonato_oficial = "CAMPEONATO OFICIAL (VALE PONTUAÇÕES)";
    public static final String campeonato_normal = "CAMPEONATO NORMAL (CORRIDA RÁPIDA)";
}
