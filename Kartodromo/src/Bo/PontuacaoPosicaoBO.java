/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bo;

import Dao.PontuacaoPosicaoDAO;
import Model.Campeonato;
import Model.PontuacaoPosicao;
import java.util.List;

/**
 *
 * @author lino
 */
public class PontuacaoPosicaoBO implements GenericBO<PontuacaoPosicao> {

    private PontuacaoPosicaoDAO pontuacao_posicaoDAO;

    public PontuacaoPosicaoBO() {

    }
    
    @Override
    public boolean criar(PontuacaoPosicao o) throws Exception {
        pontuacao_posicaoDAO = new PontuacaoPosicaoDAO();
        return pontuacao_posicaoDAO.salvar(o);
    }
    
    @Override
    public boolean deletar(PontuacaoPosicao o) throws Exception {
        pontuacao_posicaoDAO = new PontuacaoPosicaoDAO();
        return pontuacao_posicaoDAO.deletar(o);
    }

    @Override
    public boolean alterar(PontuacaoPosicao o) throws Exception {
        pontuacao_posicaoDAO = new PontuacaoPosicaoDAO();
        return pontuacao_posicaoDAO.alterar(o);
    }

    @Override
    public List<PontuacaoPosicao> listarPorItem(PontuacaoPosicao o) throws Exception {
        pontuacao_posicaoDAO = new PontuacaoPosicaoDAO();
        return pontuacao_posicaoDAO.listarTodos(o);
    }

    @Override
    public List<PontuacaoPosicao> listarTodos() throws Exception {
        pontuacao_posicaoDAO = new PontuacaoPosicaoDAO();
        return pontuacao_posicaoDAO.listarTodos();
    }
    
    public List<PontuacaoPosicao> listarPorCampeonato(Campeonato campeonato) throws Exception {
        pontuacao_posicaoDAO = new PontuacaoPosicaoDAO();
        return pontuacao_posicaoDAO.listarPorCampeonato(campeonato);
    }
    
    @Override
    public PontuacaoPosicao getById(int id) throws Exception {
        pontuacao_posicaoDAO = new PontuacaoPosicaoDAO();
        return pontuacao_posicaoDAO.getById(id);
    }

    @Override
    public boolean valida(PontuacaoPosicao o) throws Exception {
        return false;
    }

    @Override
    public boolean validaId(long id) throws Exception {
        return false;
    }

}
