package Utilities;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Tempo {

    public static Timestamp getCurrentTime() {
        try {
            return new Timestamp(System.currentTimeMillis());
        } catch (Exception e) {
            System.out.println("Não foi possivel pegar horario do sistema");
            return null;
        }
    }

    public static java.sql.Date stringToDate(String data) {
        try {
            return java.sql.Date.valueOf(LocalDate.parse(data, DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        } catch (Exception e) {
            return java.sql.Date.valueOf(LocalDate.parse("01/01/1000", DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        }
    }

    public static Timestamp stringToTimestamp(String data) {
        try {
            Date date = (Date) new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").parse(data);
            return new Timestamp(date.getTime());
        } catch (Exception e) {
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
