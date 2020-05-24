package Bo;

import Dao.PilotoDAO;
import Dao.PilotoParticipandoCampeonatoDAO;
import Model.PilotoParticipandoCampeonato;

import java.sql.Timestamp;
import java.util.List;

public class PilotoParticipandoCampeonatoBO implements GenericBO<PilotoParticipandoCampeonato> {

    private PilotoParticipandoCampeonatoDAO pilotoDAO;

    public PilotoParticipandoCampeonatoBO() {

    }

    @Override
    public boolean criar(PilotoParticipandoCampeonato o) throws Exception {
        if (valida(o)) {
            pilotoDAO = new PilotoParticipandoCampeonatoDAO();
            return pilotoDAO.salvar(o);
        }
        return false;
    }

    @Override
    public boolean deletar(PilotoParticipandoCampeonato o) throws Exception {
        if (valida(o)) {
            pilotoDAO = new PilotoParticipandoCampeonatoDAO();
            return pilotoDAO.deletar(o);
        }
        return false;
    }

    @Override
    public boolean alterar(PilotoParticipandoCampeonato o) throws Exception {
        if (valida(o)) {
            pilotoDAO = new PilotoParticipandoCampeonatoDAO();
            return pilotoDAO.alterar(o);
        }
        return false;
    }

    @Override
    public List<PilotoParticipandoCampeonato> listarPorItem(PilotoParticipandoCampeonato o) throws Exception {
        return null;
    }

    @Override
    public List<PilotoParticipandoCampeonato> listarTodos() throws Exception {
        pilotoDAO = new PilotoParticipandoCampeonatoDAO();
        return pilotoDAO.listarTodos();
    }

    @Override
    public PilotoParticipandoCampeonato getById(int id) throws Exception {
        if (validaId(id)) {
            pilotoDAO = new PilotoParticipandoCampeonatoDAO();
            return pilotoDAO.getById(id);
        }
        return null;
    }

    @Override
    public boolean valida(PilotoParticipandoCampeonato o) throws Exception {
        /* Fazer validações aqui */
        if (o.getPiloto().getIdPiloto() < 0) {
            throw new Exception("Piloto não localizado!");
        } else if (o.getCampeonato().getIdCampeonato() < 0) {
            throw new Exception("Campeonato não localizado!");
        } else if (o.isStatusAdm()) {
            throw new Exception("Piloto administrador");
        } else {
            return true;
        }
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
