package Bo;

import Dao.AvaliacaoDAO;
import Dao.ClassificacaoCampeonatoDAO;
import Model.Avaliacao;
import Model.ClassificacaoCampeonato;

import java.util.List;

public class ClassificacaoCampeonatoBO {

    private ClassificacaoCampeonatoDAO classificacaoCampeonatoDAO;

    public ClassificacaoCampeonatoBO() {
        classificacaoCampeonatoDAO = new ClassificacaoCampeonatoDAO();
    }

    public boolean criarClassificacaoCampeonato(ClassificacaoCampeonato classificacaoCampeonato) throws Exception {
        validaClassificacaoCampeonato(classificacaoCampeonato);
        return classificacaoCampeonatoDAO.salvar(classificacaoCampeonato);
    }

    public boolean deletarAvaliacao(ClassificacaoCampeonato classificacaoCampeonato) throws Exception {
        validaClassificacaoCampeonato(classificacaoCampeonato);
        return classificacaoCampeonatoDAO.deletar(classificacaoCampeonato);
    }

    public boolean alterarAvaliacao(ClassificacaoCampeonato classificacaoCampeonato) throws Exception {
        validaClassificacaoCampeonato(classificacaoCampeonato);
        return classificacaoCampeonatoDAO.alterar(classificacaoCampeonato);
    }

    public List<ClassificacaoCampeonato> listarAvaliacoes() throws Exception {
        return classificacaoCampeonatoDAO.listarTodos();
    }

    public ClassificacaoCampeonato getById(int id) throws Exception {
        validaId(id);
        return classificacaoCampeonatoDAO.getById(id);
    }

    private void validaClassificacaoCampeonato(ClassificacaoCampeonato classificacaoCampeonato) throws Exception {
        if (classificacaoCampeonato.getPontosPiloto() < 0) {
            throw new Exception("Classificação dos pontos do piloto não podem ser menores que 0");
        }
    }

    private void validaId(int id) throws Exception {
        if(id <= 0) {
            throw new Exception("Id da classificação do campeonato não pode ser menor ou igual a 0");
        }
    }


}
