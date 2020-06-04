package Bo;

import Dao.PilotoParticipaCorridaDAO;
import Dao.PilotoParticipandoCampeonatoDAO;
import Model.Corrida;
import Model.PilotoParticipaCorrida;
import Model.PilotoParticipandoCampeonato;
import java.util.List;

public class PilotoParticipaCorridaBO implements GenericBO<PilotoParticipaCorrida>{
    
    private PilotoParticipaCorridaDAO pilotoDAO;

    public PilotoParticipaCorridaBO() {

    }

    @Override
    public boolean criar(PilotoParticipaCorrida o) throws Exception {
        if (valida(o)) {
            pilotoDAO = new PilotoParticipaCorridaDAO();
            return pilotoDAO.salvar(o);
        }
        return false;
    }

    @Override
    public boolean deletar(PilotoParticipaCorrida o) throws Exception {
        if (valida(o)) {
            pilotoDAO = new PilotoParticipaCorridaDAO();
            return pilotoDAO.deletar(o);
        }
        return false;
    }

    @Override
    public boolean alterar(PilotoParticipaCorrida o) throws Exception {
        if (valida(o)) {
            pilotoDAO = new PilotoParticipaCorridaDAO();
            return pilotoDAO.alterar(o);
        }
        return false;
    }

    @Override
    public List<PilotoParticipaCorrida> listarPorItem(PilotoParticipaCorrida o) throws Exception {
        if (valida(o)) {
            pilotoDAO = new PilotoParticipaCorridaDAO();
            return pilotoDAO.listarTodos(o);
        }
        return null;
    }

    @Override
    public List<PilotoParticipaCorrida> listarTodos() throws Exception {
        pilotoDAO = new PilotoParticipaCorridaDAO();
        return pilotoDAO.listarTodos();
    }

    @Override
    public PilotoParticipaCorrida getById(int id) throws Exception {
        if (validaId(id)) {
            pilotoDAO = new PilotoParticipaCorridaDAO();
            return pilotoDAO.getById(id);
        }
        return null;
    }
    
    public List<PilotoParticipaCorrida> listarTodosAscTimePorCorrida(Corrida corrida) throws Exception {
        pilotoDAO = new PilotoParticipaCorridaDAO();
        return pilotoDAO.listarTodosAscTimePorCorrida(corrida);
    }
    public PilotoParticipaCorrida listarPilotoCorrida(Corrida corrida, PilotoParticipandoCampeonato piloto) throws Exception {
        pilotoDAO = new PilotoParticipaCorridaDAO();
        return pilotoDAO.listarPilotoCorrida(corrida, piloto);
    }

    @Override
    public boolean valida(PilotoParticipaCorrida o) throws Exception {
        return true;
    }

    @Override
    public boolean validaId(int id) throws Exception {
        if (id <= 0) {
            throw new Exception("Id nulo");
        } else {
            return true;
        }
    }

}
