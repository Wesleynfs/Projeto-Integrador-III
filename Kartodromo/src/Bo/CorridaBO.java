package Bo;

import Dao.CorridaDAO;
import Model.Campeonato;
import Model.Corrida;
import Model.Piloto;

import java.util.List;

public class CorridaBO implements GenericBO<Corrida> {

    private CorridaDAO corridaDAO;

    public CorridaBO() {

    }

    @Override
    public boolean criar(Corrida o) throws Exception {
        corridaDAO = new CorridaDAO();
        return corridaDAO.salvar(o);
    }

    @Override
    public boolean deletar(Corrida o) throws Exception {
        corridaDAO = new CorridaDAO();
        return corridaDAO.deletar(o);
    }

    @Override
    public boolean alterar(Corrida o) throws Exception {
        corridaDAO = new CorridaDAO();
        return corridaDAO.alterar(o);
    }

    @Override
    public List<Corrida> listarPorItem(Corrida o) throws Exception {
        corridaDAO = new CorridaDAO();
        return corridaDAO.listarTodos(o);
    }

    @Override
    public List<Corrida> listarTodos() throws Exception {
        corridaDAO = new CorridaDAO();
        return corridaDAO.listarTodos();
    }

    @Override
    public Corrida getById(int id) throws Exception {
        corridaDAO = new CorridaDAO();
        return corridaDAO.getById(id);
    }

    @Override
    public boolean valida(Corrida o) throws Exception {
        return false;
    }

    @Override
    public boolean validaId(int id) throws Exception {
        return false;
    }

    public List<Corrida> listarTodasAsCorridasMarcadas(Campeonato c) throws Exception {
        corridaDAO = new CorridaDAO();
        return corridaDAO.listarTodasAsCorridasMarcadasDeCampeonato(c);
    }

}
