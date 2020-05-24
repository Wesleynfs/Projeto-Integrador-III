package Bo;

import Dao.CorridaDAO;
import Model.Corrida;
import Model.Piloto;

import java.util.List;

public class CorridaBO implements GenericBO<Corrida> {

    private CorridaDAO corridaDAO;

    public CorridaBO() {

    }

    @Override
    public boolean criar(Corrida o) throws Exception {
        return false;
    }

    @Override
    public boolean deletar(Corrida o) throws Exception {
        return false;
    }

    @Override
    public boolean alterar(Corrida o) throws Exception {
        return false;
    }

    @Override
    public List<Corrida> listarPorItem(Corrida o) throws Exception {
        return null;
    }

    @Override
    public List<Corrida> listarTodos() throws Exception {
        return null;
    }

    @Override
    public Corrida getById(int id) throws Exception {
        return null;
    }

    @Override
    public boolean valida(Corrida o) throws Exception {
        return false;
    }

    @Override
    public boolean validaId(int id) throws Exception {
        return false;
    }

    public List<Corrida> listarTodasAsCorridasMarcadas(Piloto piloto) throws Exception {
        corridaDAO = new CorridaDAO();
        return corridaDAO.listarTodasAsCorridasMarcadas(piloto);
    }

}
