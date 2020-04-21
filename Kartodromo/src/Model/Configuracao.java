package Model;

import Utilities.Info;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Configuracao {

    private boolean tema;

    private File file;
    private Properties properties;
    private InputStream arquivoLer;
    private OutputStream arquivoGravar;

    public boolean isTema() {
        return tema;
    }

    public void setTema(boolean tema) {
        this.tema = tema;
    }

    public Configuracao(boolean tema) {
        this.tema = tema;
    }

    public Configuracao() {
        properties = new Properties();
        file = new File(Info.USERHOME + "\\Documents\\props.xml");
        loadPreferences();
    }

    // METODO DELICIOSO QUE LÊ TODAS AS CONFIGS Q VC COLOCAR NO MAPA //
    private void setPreferences() {
        Map<String, Object> map = new HashMap<>();
        map.put("tema" , isTema());
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            setPreferences(entry.getKey(),entry.getValue());
        }
    }

    public boolean setPreferences(String key, Object value) {
        properties.setProperty(key, value.toString());
        try {
            arquivoLer = new FileInputStream(file);
            properties.loadFromXML(arquivoLer);
            arquivoLer.close();
        } catch (Exception e) { }
        try {
            arquivoGravar = new FileOutputStream(file);
            properties.storeToXML(arquivoGravar, "Configuração KartOnRoad");
        } catch (Exception e) { }
        return true;
    }

    private boolean loadPreferences() {
        if (!file.exists()) {
            try {
                file.createNewFile();
                setPreferences("tema",true);
            } catch (Exception e) { }
        }
        try {
            arquivoLer = new FileInputStream(file);
            properties.loadFromXML(arquivoLer);
            setTema(Boolean.valueOf(properties.getProperty("tema")));
            arquivoLer.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
