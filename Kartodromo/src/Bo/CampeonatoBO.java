package Bo;

import Dao.CampeonatoDAO;
import Model.Campeonato;

import java.util.List;

public class CampeonatoBO {

    private CampeonatoDAO campeonatoDAO;

    public CampeonatoBO() {
        campeonatoDAO = new CampeonatoDAO();
    }

    public boolean criarCampeonato(Campeonato campeonato) throws Exception {
        validaKartodromo(campeonato);
        return campeonatoDAO.salvar(campeonato);
    }

    public boolean deletarCampeonato(Campeonato campeonato) throws Exception {
        validaKartodromo(campeonato);
        return campeonatoDAO.deletar(campeonato);
    }

    public boolean alterarCampeonato(Campeonato campeonato) throws Exception {
        validaKartodromo(campeonato);
        return campeonatoDAO.alterar(campeonato);
    }

    public List<Campeonato> listarCampeonatos() throws Exception {
        return campeonatoDAO.listarTodos();
    }

    public Campeonato getById(int id) throws Exception {
        validaId(id);
        return campeonatoDAO.getById(id);
    }

    private void validaKartodromo(Campeonato campeonato) throws Exception {
        if (campeonato.getNome().equals("")) {
            throw new Exception("Nome do Campeonato não pode ficar em branco!");
        }
        /*
        if (campeonato.getData(). > 50) {
            throw new Exception("Senha maior do que o permitido");
        }
        */
    }

    private void validaId(int id) throws Exception {
        if(id <= 0) {
            throw new Exception("Id do Campeonato não pode ser menor ou igual a 0");
        }
    }

}
