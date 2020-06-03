package Utilities;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.sql.Date;

public class Tempo {

    public static Date getCurrentDate() {
        try {
            return new Date(new java.util.Date().getTime());
        } catch (Exception e) {
            System.out.println("Não foi possivel pegar a data do sistema");
            return null;
        }
    }

    public static Time getCurrentTime() {
        try {
            return new Time(new java.util.Date().getTime());
        } catch (Exception e) {
            System.out.println("Não foi possivel pegar horario do sistema");
            return null;
        }
    }

    public static Date stringToTime(String myTime) {
        try {
            return null;
        } catch (Exception e) {
            System.out.println("Não foi possivel pegar horario do sistema");
            return null;
        }
    }

    public static Date stringToDate(String data) {
        try {
            return Date.valueOf(LocalDate.parse(data, DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        } catch (Exception e) {
            return Date.valueOf(LocalDate.parse("01/01/1000", DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        }
    }

}
