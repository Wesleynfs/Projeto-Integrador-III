package Bo;

import Dao.ConfiguracaoDAO;

import java.util.List;

public class ConfiguracaoBO implements GenericBO<ConfiguracaoDAO> {
    @Override
    public boolean criar(ConfiguracaoDAO o) throws Exception {
        return false;
    }

    @Override
    public boolean deletar(ConfiguracaoDAO o) throws Exception {
        return false;
    }

    @Override
    public boolean alterar(ConfiguracaoDAO o) throws Exception {
        return false;
    }

    @Override
    public List<ConfiguracaoDAO> listarPorItem(ConfiguracaoDAO o) throws Exception {
        return null;
    }

    @Override
    public List<ConfiguracaoDAO> listarTodos() throws Exception {
        return null;
    }

    @Override
    public ConfiguracaoDAO getById(int id) throws Exception {
        return null;
    }

    @Override
    public boolean valida(ConfiguracaoDAO o) throws Exception {
        return false;
    }

    @Override
    public boolean validaId(int id) throws Exception {
        return false;
    }

}
