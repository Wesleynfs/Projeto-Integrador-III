package Utilities;

public class Numeros {

    public static Integer stringToInt(String valor) {
        try {
            return Integer.valueOf(valor);
        } catch (Exception e) {
            return 0;
        }
    }

}
