/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bo;

import Dao.Pontuacao_posicaoDAO;
import Model.PontuacaoPosicao;
import java.util.List;

/**
 *
 * @author lino
 */
public class PontuacaoPosicaoBO implements GenericBO<PontuacaoPosicao> {
    private Pontuacao_posicaoDAO pontuacao_posicaoDAO;
    
    @Override
    public boolean criar(PontuacaoPosicao o) throws Exception {
        pontuacao_posicaoDAO = new Pontuacao_posicaoDAO();
        return pontuacao_posicaoDAO.salvar(o);
    }
    
    @Override
    public boolean deletar(PontuacaoPosicao o) throws Exception {
        pontuacao_posicaoDAO = new Pontuacao_posicaoDAO();
        return pontuacao_posicaoDAO.deletar(o);
    }

    @Override
    public boolean alterar(PontuacaoPosicao o) throws Exception {
        pontuacao_posicaoDAO = new Pontuacao_posicaoDAO();
        return pontuacao_posicaoDAO.alterar(o);
    }

    @Override
    public List<PontuacaoPosicao> listarPorItem(PontuacaoPosicao o) throws Exception {
        pontuacao_posicaoDAO = new Pontuacao_posicaoDAO();
        return pontuacao_posicaoDAO.listarTodos(o);
    }

    @Override
    public List<PontuacaoPosicao> listarTodos() throws Exception {
        pontuacao_posicaoDAO = new Pontuacao_posicaoDAO();
        return pontuacao_posicaoDAO.listarTodos();
    }

    @Override
    public PontuacaoPosicao getById(int id) throws Exception {
        pontuacao_posicaoDAO = new Pontuacao_posicaoDAO();
        return pontuacao_posicaoDAO.getById(id);
    }

    @Override
    public boolean valida(PontuacaoPosicao o) throws Exception {
        return false;
    }

    @Override
    public boolean validaId(int id) throws Exception {
        return false;
    }

}
