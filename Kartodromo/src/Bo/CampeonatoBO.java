package Bo;

import Dao.CampeonatoDAO;
import Model.Campeonato;

import java.util.List;

public class CampeonatoBO {

    private CampeonatoDAO campeonatoDAO;

    public CampeonatoBO() {

    }

    public boolean criarCampeonato(Campeonato campeonato) throws Exception {
        if (validaKartodromo(campeonato)) {
            campeonatoDAO = new CampeonatoDAO();
            return campeonatoDAO.salvar(campeonato);
        }
        return false;
    }

    public boolean deletarCampeonato(Campeonato campeonato) throws Exception {
        if (validaKartodromo(campeonato)) {
            campeonatoDAO = new CampeonatoDAO();
            return campeonatoDAO.deletar(campeonato);
        }
        return false;
    }

    public boolean alterarCampeonato(Campeonato campeonato) throws Exception {
        if (validaKartodromo(campeonato)) {
            campeonatoDAO = new CampeonatoDAO();
            return campeonatoDAO.alterar(campeonato);
        }
        return false;
    }

    public List<Campeonato> listarCampeonatos() throws Exception {
        return campeonatoDAO.listarTodos();
    }

    public Campeonato getById(int id) throws Exception {
        if (validaId(id)) {
            campeonatoDAO = new CampeonatoDAO();
            return campeonatoDAO.getById(id);
        }
        return null;
    }

    private boolean validaKartodromo(Campeonato campeonato) throws Exception {
        if (campeonato.getNome().equals("")) {
            throw new Exception("Nome do Campeonato não pode ficar em branco!");
        }
        /*
        if (campeonato.getData(). > 50) {
            throw new Exception("Senha maior do que o permitido");
        }
        */
        return true;
    }

    private boolean validaId(int id) throws Exception {
        if (id <= 0) {
            throw new Exception("Id do Campeonato não pode ser menor ou igual a 0");
        }
        return true;
    }

}
