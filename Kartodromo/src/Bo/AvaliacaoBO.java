package Bo;

import Dao.AvaliacaoDAO;
import Model.Avaliacao;
import Model.Piloto;

import java.util.List;

public class AvaliacaoBO {

    private AvaliacaoDAO avaliacaoDAO;

    public AvaliacaoBO() {
        avaliacaoDAO = new AvaliacaoDAO();
    }

    public boolean criarAvaliacao(Avaliacao avaliacao) throws Exception {
        validaAvaliacao(avaliacao);
        return avaliacaoDAO.salvar(avaliacao);
    }

    public boolean deletarAvaliacao(Avaliacao avaliacao) throws Exception {
        validaAvaliacao(avaliacao);
        return avaliacaoDAO.deletar(avaliacao);
    }

    public boolean alterarAvaliacao(Avaliacao avaliacao) throws Exception {
        validaAvaliacao(avaliacao);
        return avaliacaoDAO.alterar(avaliacao);
    }

    public List<Avaliacao> listarAvaliacoes() throws Exception {
        return avaliacaoDAO.listarTodos();
    }

    public Avaliacao getById(int id) throws Exception {
        validaId(id);
        return avaliacaoDAO.getById(id);
    }

    private void validaAvaliacao(Avaliacao avaliacao) throws Exception {
        if (avaliacao.getComentario().equals("")) {
            throw new Exception("Nome do piloto não pode ficar em branco!");
        }
    }

    private void validaId(int id) throws Exception {
        if(id <= 0) {
            throw new Exception("Id da avaliação não pode ser menor ou igual a 0");
        }
    }


}
