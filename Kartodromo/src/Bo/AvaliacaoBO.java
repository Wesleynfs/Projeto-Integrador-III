package Bo;

import Dao.AvaliacaoDAO;
import Model.Avaliacao;
import Model.Kartodromo;
import Model.Piloto;

import java.util.List;

public class AvaliacaoBO implements GenericBO<Avaliacao>{

    private AvaliacaoDAO avaliacaoDAO;

    public AvaliacaoBO() {

    }

    @Override
    public boolean criar(Avaliacao avaliacao) throws Exception {
        if (valida(avaliacao)) {
            avaliacaoDAO = new AvaliacaoDAO();
            return avaliacaoDAO.salvar(avaliacao);
        }
        return false;
    }

    @Override
    public boolean deletar(Avaliacao avaliacao) throws Exception {
        if (valida(avaliacao)) {
            avaliacaoDAO = new AvaliacaoDAO();
            return avaliacaoDAO.deletar(avaliacao);
        }
        return false;
    }

    @Override
    public boolean alterar(Avaliacao avaliacao) throws Exception {
        if (valida(avaliacao)) {
            
            avaliacaoDAO = new AvaliacaoDAO();
            return avaliacaoDAO.alterar(avaliacao);
        }
        return false;
    }

    @Override
    public List<Avaliacao> listarTodos() throws Exception {
        AvaliacaoDAO dao = new AvaliacaoDAO();
        return dao.listarTodos();
    }

    @Override
    public List<Avaliacao> listarPorItem(Avaliacao o) throws Exception {
        return null;
    }

    @Override
    public Avaliacao logar(Avaliacao o) throws Exception {
        return null;
    }

    public Avaliacao getById(int id) throws Exception {
        if (validaId(id)) {
            avaliacaoDAO = new AvaliacaoDAO();
            return avaliacaoDAO.getById(id);
        }
        return null;
    }
//    
//    public float listarPorMediaNota(Kartodromo kartodromo) throws Exception {
//        AvaliacaoDAO dao = new AvaliacaoDAO();
//        return dao.listarPorMediaNotas(kartodromo);
//    }


    @Override
    public boolean valida(Avaliacao avaliacao) throws Exception {
        if (avaliacao.getComentario().length() > 200) {
            throw new Exception("Comentario grande demais!!!");
        }
        return true;
    }

    @Override
    public boolean validaId(int id) throws Exception {
        if(id <= 0) {
            throw new Exception("Id da avaliação não pode ser menor ou igual a 0");
        }
        return true;
    }
    
    public List<Avaliacao> listarPorKartodromo(Kartodromo kartodromo) throws Exception {
        AvaliacaoDAO dao = new AvaliacaoDAO();
        return dao.listarPorKartodromo(kartodromo);
    }

    @Override
    public boolean validaLogin(Avaliacao o) throws Exception {
        return false;
    }

}
