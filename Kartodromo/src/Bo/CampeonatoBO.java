package Bo;

import Dao.CampeonatoDAO;
import Model.Campeonato;
import Model.Piloto;
import Model.PilotoParticipandoCampeonato;

import java.util.List;

public class CampeonatoBO implements GenericBO<Campeonato>{

    private CampeonatoDAO campeonatoDAO;

    public CampeonatoBO() {

    }

    @Override
    public boolean criar(Campeonato o) throws Exception {
        if (valida(o)) {
            campeonatoDAO = new CampeonatoDAO();
            return campeonatoDAO.salvar(o);
        }
        return false;
    }

    @Override
    public boolean deletar(Campeonato o) throws Exception {
        if (valida(o)) {
            campeonatoDAO = new CampeonatoDAO();
            return campeonatoDAO.deletar(o);
        }
        return false;
    }

    @Override
    public boolean alterar(Campeonato o) throws Exception {
        if (valida(o)) {
            campeonatoDAO = new CampeonatoDAO();
            return campeonatoDAO.alterar(o);
        }
        return false;
    }

    @Override
    public List<Campeonato> listarPorItem(Campeonato o) throws Exception {
        return null;
    }

    @Override
    public List<Campeonato> listarTodos() throws Exception {
        return campeonatoDAO.listarTodos();
    }

    @Override
    public Campeonato logar(Campeonato o) throws Exception {
        return null;
    }

    @Override
    public Campeonato getById(int id) throws Exception {
        if (validaId(id)) {
            campeonatoDAO = new CampeonatoDAO();
            return campeonatoDAO.getById(id);
        }
        return null;
    }

    @Override
    public boolean valida(Campeonato o) throws Exception {
        if (o.getNome().equals("")) {
            throw new Exception("Nome do Campeonato não pode ficar em branco!");
        }
        return true;
    }

    @Override
    public boolean validaId(int id) throws Exception {
        if (id <= 0) {
            throw new Exception("Id do Campeonato não pode ser menor ou igual a 0");
        }
        return true;
    }

    public List<Campeonato> listarCampeonatosFinalizados() throws Exception {
        return campeonatoDAO.listarCampeonatosFinalizados();
    }

    @Override
    public boolean validaLogin(Campeonato o) throws Exception {
        return false;
    }

    public List<PilotoParticipandoCampeonato> listarPilotoParticipandoCampeonato(Piloto piloto) throws Exception {
        return campeonatoDAO.listarPilotoParticipandoCampeonato(piloto);
    }
    public List<PilotoParticipandoCampeonato> listarPilotosParticipando(Campeonato campeonato) throws Exception {
        return campeonatoDAO.listarPilotosParticipando(campeonato);
    }
}

