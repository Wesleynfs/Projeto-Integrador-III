package Utilities;

import java.awt.*;
import java.sql.Timestamp;

public class Info {
    public static final String APP_NAME = "KART ON ROAD";
    public static final String APP_VERSION = "Ver. 0.7";
    public static final String USERHOME = System.getProperty("user.home");  // C:\Users\***
    public static final Dimension MAXSCREENSIZE = new Dimension(1280,720);
    public static final Dimension MINSCREENSIZE = new Dimension(800,600);
    public static final String CAMPEONATO_OFICIAL = "CAMPEONATO OFICIAL (VALE PONTUAÇÕES)";
    public static final String CAMPEONATO_NORMAL = "CAMPEONATO NORMAL (CORRIDA RÁPIDA)";
    public static final int NUMERO_MINIMO_DE_PILOTOS_CAMPEONATO_OFFICIAL = 10;
    public static final int PRIMEIRO_COLOCADO_EXTRA_PONTOS = 100;
}
