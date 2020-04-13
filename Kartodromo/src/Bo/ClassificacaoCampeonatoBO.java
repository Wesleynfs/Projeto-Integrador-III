package Bo;

import Dao.AvaliacaoDAO;
import Dao.ClassificacaoCampeonatoDAO;
import Model.Avaliacao;
import Model.ClassificacaoCampeonato;

import java.util.List;

public class ClassificacaoCampeonatoBO {

    private ClassificacaoCampeonatoDAO classificacaoCampeonatoDAO;

    public ClassificacaoCampeonatoBO() {

    }

    public boolean criarClassificacaoCampeonato(ClassificacaoCampeonato classificacaoCampeonato) throws Exception {
        if (validaClassificacaoCampeonato(classificacaoCampeonato)) {
            classificacaoCampeonatoDAO = new ClassificacaoCampeonatoDAO();
            return classificacaoCampeonatoDAO.salvar(classificacaoCampeonato);
        }
        return false;
    }

    public boolean deletarAvaliacao(ClassificacaoCampeonato classificacaoCampeonato) throws Exception {
        if (validaClassificacaoCampeonato(classificacaoCampeonato)) {
            classificacaoCampeonatoDAO = new ClassificacaoCampeonatoDAO();
            return classificacaoCampeonatoDAO.deletar(classificacaoCampeonato);
        }
        return false;
    }

    public boolean alterarAvaliacao(ClassificacaoCampeonato classificacaoCampeonato) throws Exception {
        if (validaClassificacaoCampeonato(classificacaoCampeonato)) {
            classificacaoCampeonatoDAO = new ClassificacaoCampeonatoDAO();
            return classificacaoCampeonatoDAO.alterar(classificacaoCampeonato);
        }
        return false;
    }

    public List<ClassificacaoCampeonato> listarAvaliacoes() throws Exception {
        return classificacaoCampeonatoDAO.listarTodos();
    }

    public ClassificacaoCampeonato getById(int id) throws Exception {
        if (validaId(id)) {
            classificacaoCampeonatoDAO = new ClassificacaoCampeonatoDAO();
            return classificacaoCampeonatoDAO.getById(id);
        }
        return null;
    }

    private boolean validaClassificacaoCampeonato(ClassificacaoCampeonato classificacaoCampeonato) throws Exception {
        if (classificacaoCampeonato.getPontosPiloto() < 0) {
            throw new Exception("Classificação dos pontos do piloto não podem ser menores que 0");
        }
        return true;
    }

    private boolean validaId(int id) throws Exception {
        if (id <= 0) {
            throw new Exception("Id da classificação do campeonato não pode ser menor ou igual a 0");
        }
        return true;
    }


}
