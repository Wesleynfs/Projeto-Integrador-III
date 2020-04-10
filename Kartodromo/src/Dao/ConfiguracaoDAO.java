package Dao;

import Model.Configuracao;
import Utilities.Info;

import java.io.*;

public class ConfiguracaoDAO {

    private File file;
    private StringBuilder stringBuilder;

    public ConfiguracaoDAO() {
        file = new File(Info.USERHOME + "\\Documents\\Config.txt");
        stringBuilder = new StringBuilder();
    }

    public boolean gravarConfiguracao(Configuracao configuracao) throws Exception {
        try {
            file.createNewFile();
            stringBuilder.append("tema: " + configuracao.isTema());
            FileWriter fileWriter = new FileWriter(file, false);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.append(stringBuilder + "\n");
            bufferedWriter.close();
            fileWriter.close();
            return true;
        } catch (Exception e) {
            throw new Exception("Erro ao gravar aquivo de configurações " + e.getMessage());
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
                        if (texto.startsWith("tema: ")) {
                            configuracao.setTema(Boolean.valueOf(texto.substring(6, 10)));
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
            // Caso o arquivo não exista
            Configuracao configuracao = new Configuracao();
            configuracao.setTema(false);
            try {
                gravarConfiguracao(configuracao);
            } catch (Exception e) {
                System.out.println("Não foi possivel criar nova configuração");
            }
            return configuracao;
        }
        return null;
    }

}
