package Dao;

import Model.Configuracao;
import Utilities.Info;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class ConfiguracaoDAO {

    private File file;
    private StringBuilder stringBuilder;

    public ConfiguracaoDAO() {
        file = new File(Info.USERHOME + "\\Documents\\Config.txt");
        stringBuilder = new StringBuilder();
    }

    public boolean gravarConfiguracao(Configuracao configuracao) throws Exception {
        try {
            FileWriter fileWriter;
            if (!file.exists()) {
                file.createNewFile();
            } else {
                stringBuilder.append("tema: " + configuracao.isTema());
                fileWriter = new FileWriter(file);
                fileWriter.write(stringBuilder.toString());
                fileWriter.close();
            }
            return true;
        } catch (Exception e) {
            throw new Exception("Arquivo de configurações! " + e.getMessage());
        }
    }

    public Configuracao lerConfiguracao() {
        if (file.exists()) {
            Configuracao configuracao = new Configuracao();
            try {
                String texto = "";
                FileReader ler = new FileReader(file);
                BufferedReader buffer = new BufferedReader(ler);
                while (true) {
                    texto = buffer.readLine();
                    if (texto != null) {
                        if(texto.startsWith("tema: ")) {
                            configuracao.setTema(Boolean.valueOf(texto.substring(6,10)));
                        }
                    } else {
                        break;
                    }
                }
                buffer.close();
                return configuracao;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else {
            // Caso o arquivo não exista tem uma config padrão //
            Configuracao configuracao = new Configuracao();
            configuracao.setTema(false);
        }
        return null;
    }

}
