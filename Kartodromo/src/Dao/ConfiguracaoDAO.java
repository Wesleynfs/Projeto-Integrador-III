package Dao;

import Model.Configuracao;
import Utilities.Info;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ConfiguracaoDAO {

    private File file;
    private Properties properties;
    private InputStream arquivoLer;
    private OutputStream arquivoGravar;
    private Configuracao configuracao;

    public Configuracao getConfiguracao() {
        return configuracao;
    }

    public boolean setConfiguracao(Configuracao configuracao) {
        return setPreferences(configuracao);
    }

    public ConfiguracaoDAO() {
        configuracao = new Configuracao();
        properties = new Properties();
        file = new File(Info.USERHOME + "\\Documents\\props.xml");
        loadPreferences();
    }

    private boolean setPreferences(Configuracao configuracao) {
        try {
            Map<String, Object> map = new HashMap<>();
            map.put("tema", configuracao.isTema());
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                setPreferences(entry.getKey(), entry.getValue());
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private boolean setPreferences(String key, Object value) {
        try {
            arquivoLer = new FileInputStream(file);
            properties.loadFromXML(arquivoLer);
            arquivoLer.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        properties.setProperty(key, value.toString());
        try {
            arquivoGravar = new FileOutputStream(file);
            properties.storeToXML(arquivoGravar, "Configuração KartOnRoad");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return true;
    }

    private boolean loadPreferences() {
        if (!file.exists()) {
            try {
                file.createNewFile();
                setPreferences("tema", true);
            } catch (Exception e) {
            }
        }
        try {
            arquivoLer = new FileInputStream(file);
            properties.loadFromXML(arquivoLer);
            configuracao.setTema(Boolean.valueOf(properties.getProperty("tema")));
            arquivoLer.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
