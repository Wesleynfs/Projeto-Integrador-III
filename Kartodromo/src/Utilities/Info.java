package Utilities;

import java.awt.*;
import java.sql.Timestamp;

public class Info {
    public static final String APP_NAME = "KART ON ROAD";
    public static final String APP_VERSION = "Ver. 0.5";
    public static final String USERHOME = System.getProperty("user.home");  // C:\Users\kakoa
    public static final Dimension MAXSCREENSIZE = new Dimension(1280,720);
    public static final Dimension MINSCREENSIZE = new Dimension(800,600);
    public static final Timestamp GETCURRENTTIME = new Timestamp(System.currentTimeMillis());
}
