package Utilities;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Tempo {

    public static Timestamp stringToTimestamp(String data) {
        try {
            Date date = (Date) new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").parse(data);
            return new Timestamp(date.getTime());
        } catch (Exception e) {
            System.out.println("Não foi possivel converter [" + data + "] em um TIMESTAMP");
            return null;
        }
    }

    public static Timestamp stringToLapTime(String lapTime) {
        try {
            Date date = (Date) new SimpleDateFormat("mm:ss.SSS").parse(lapTime);
            return new Timestamp(date.getTime());
        } catch (Exception e) {
            System.out.println("Não foi possivel converter tempo de volta: [" + lapTime + "] em um TIMESTAMP");
            return null;
        }
    }

}
