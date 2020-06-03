/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Connections.ConnectionFactory;
import Model.Campeonato;
import Model.PontuacaoPosicao;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author lino
 */
public class PontuacaoPosicaoDAO implements GenericDAO<PontuacaoPosicao> {
    
    private EntityManager entityManager;

    public PontuacaoPosicaoDAO() {
        entityManager = new ConnectionFactory().getConnection();
    }

    @Override
    public boolean salvar(PontuacaoPosicao pontuacaoPosicao) throws Exception {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(pontuacaoPosicao);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new Exception("Erro ao salvar pontuacao posicao [" + pontuacaoPosicao.getIdPontuacao_posicao() +"]");
        } finally {
            entityManager.close();
        }
    }

    @Override
    public boolean ler(PontuacaoPosicao pontuacaoPosicao) throws Exception {
        return false;
    }

    @Override
    public boolean alterar(PontuacaoPosicao pontuacaoPosicao) throws Exception {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(pontuacaoPosicao);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new Exception("Erro ao alterar o pontuacao posicao!");
        } finally {
            entityManager.close();
        }
    }

    @Override
    public boolean deletar(PontuacaoPosicao pontuacaoPosicao) throws Exception {
        try {
            PontuacaoPosicao pontuacaoPosicao1 = entityManager.find(PontuacaoPosicao.class, pontuacaoPosicao.getIdPontuacao_posicao());
            entityManager.getTransaction().begin();
            entityManager.remove(pontuacaoPosicao1);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            throw new Exception("Erro ao deletar pontuacao_posicao!");
        } finally {
            entityManager.close();
        }
    }

    @Override
    public List<PontuacaoPosicao> listarTodos(PontuacaoPosicao pontuacao_posicao) throws Exception {
        return null;
    }

    @Override
    public List<PontuacaoPosicao> listarTodos() throws Exception {
        try {
            return entityManager.createQuery("SELECT a FROM PontuacaoPosicao a").getResultList();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            entityManager.close();
        }
    }

    @Override
    public PontuacaoPosicao getById(int id) throws Exception {
        try {
            return entityManager.find(PontuacaoPosicao.class,id);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            entityManager.close();
        }
    }
    
        public List<PontuacaoPosicao> listarPorCampeonato(Campeonato campeonato) throws Exception {
        try {
            return entityManager.createQuery("SELECT a FROM PontuacaoPosicao a where a.campeonato = :campeonato order by a.posicao").setParameter("campeonato", campeonato).getResultList();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            entityManager.close();
        }
    }
}
