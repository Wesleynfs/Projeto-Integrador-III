/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bo;

import Dao.Pontuacao_posicaoDAO;
import Model.Pontuacao_posicao;
import java.util.List;

/**
 *
 * @author lino
 */
public class Pontuacao_posicaoBO implements GenericBO<Pontuacao_posicao> {
    private Pontuacao_posicaoDAO pontuacao_posicaoDAO;
    
    @Override
    public boolean criar(Pontuacao_posicao o) throws Exception {
        pontuacao_posicaoDAO = new Pontuacao_posicaoDAO();
        return pontuacao_posicaoDAO.salvar(o);
    }
    
    @Override
    public boolean deletar(Pontuacao_posicao o) throws Exception {
        pontuacao_posicaoDAO = new Pontuacao_posicaoDAO();
        return pontuacao_posicaoDAO.deletar(o);
    }

    @Override
    public boolean alterar(Pontuacao_posicao o) throws Exception {
        pontuacao_posicaoDAO = new Pontuacao_posicaoDAO();
        return pontuacao_posicaoDAO.alterar(o);
    }

    @Override
    public List<Pontuacao_posicao> listarPorItem(Pontuacao_posicao o) throws Exception {
        pontuacao_posicaoDAO = new Pontuacao_posicaoDAO();
        return pontuacao_posicaoDAO.listarTodos(o);
    }

    @Override
    public List<Pontuacao_posicao> listarTodos() throws Exception {
        pontuacao_posicaoDAO = new Pontuacao_posicaoDAO();
        return pontuacao_posicaoDAO.listarTodos();
    }

    @Override
    public Pontuacao_posicao getById(int id) throws Exception {
        pontuacao_posicaoDAO = new Pontuacao_posicaoDAO();
        return pontuacao_posicaoDAO.getById(id);
    }

    @Override
    public boolean valida(Pontuacao_posicao o) throws Exception {
        return false;
    }

    @Override
    public boolean validaId(int id) throws Exception {
        return false;
    }

}
