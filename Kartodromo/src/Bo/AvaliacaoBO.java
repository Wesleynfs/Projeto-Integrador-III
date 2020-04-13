package Bo;

import Dao.AvaliacaoDAO;
import Model.Avaliacao;
import Model.Piloto;

import java.util.List;

public class AvaliacaoBO {

    private AvaliacaoDAO avaliacaoDAO;

    public AvaliacaoBO() {

    }

    public boolean criarAvaliacao(Avaliacao avaliacao) throws Exception {
        if (validaAvaliacao(avaliacao)) {
            avaliacaoDAO = new AvaliacaoDAO();
            return avaliacaoDAO.salvar(avaliacao);
        }
        return false;
    }

    public boolean deletarAvaliacao(Avaliacao avaliacao) throws Exception {
        if (validaAvaliacao(avaliacao)) {
            avaliacaoDAO = new AvaliacaoDAO();
            return avaliacaoDAO.deletar(avaliacao);
        }
        return false;
    }

    public boolean alterarAvaliacao(Avaliacao avaliacao) throws Exception {
        if (validaAvaliacao(avaliacao)) {
            avaliacaoDAO = new AvaliacaoDAO();
            return avaliacaoDAO.alterar(avaliacao);
        }
        return false;
    }

    public List<Avaliacao> listarAvaliacoes() throws Exception {
        return avaliacaoDAO.listarTodos();
    }

    public Avaliacao getById(int id) throws Exception {
        if (validaId(id)) {
            avaliacaoDAO = new AvaliacaoDAO();
            return avaliacaoDAO.getById(id);
        }
        return null;
    }

    private boolean validaAvaliacao(Avaliacao avaliacao) throws Exception {
        if (avaliacao.getComentario().equals("")) {
            throw new Exception("Nome do piloto não pode ficar em branco!");
        }
        return true;
    }

    private boolean validaId(int id) throws Exception {
        if(id <= 0) {
            throw new Exception("Id da avaliação não pode ser menor ou igual a 0");
        }
        return true;
    }


}
