package Bo;

import Dao.ConfiguracaoDAO;
import Model.Configuracao;

public class ConfiguracaoBO {

    private ConfiguracaoDAO configuracaoDAO;

    public ConfiguracaoBO() {
        configuracaoDAO = new ConfiguracaoDAO();
    }

    public boolean criarConfiguracao(Configuracao configuracao) throws Exception {
        if (validaConfiguracao(configuracao)) {
            return configuracaoDAO.gravarConfiguracao(configuracao);
        }
        return false;
    }

    public Configuracao lerConfiguracao() {
        return configuracaoDAO.lerConfiguracao();
    }

    private boolean validaConfiguracao(Configuracao configuracao) throws Exception {
        return false;
    }

}
