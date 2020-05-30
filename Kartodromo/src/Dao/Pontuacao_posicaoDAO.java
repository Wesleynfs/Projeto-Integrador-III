/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Connections.ConnectionFactory;
import Model.PontuacaoPosicao;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author lino
 */
public class Pontuacao_posicaoDAO implements GenericDAO<PontuacaoPosicao> {
    
    private EntityManager entityManager;

    public Pontuacao_posicaoDAO() {
        entityManager = new ConnectionFactory().getConnection();
    }

    @Override
    public boolean salvar(PontuacaoPosicao pontuacao_posicao) throws Exception {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(pontuacao_posicao);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new Exception("Erro ao salvar pontuacao_posicao [" + pontuacao_posicao.getIdPontuacao_posicao() +"]");
        } finally {
            entityManager.close();
        }
    }

    @Override
    public boolean ler(PontuacaoPosicao pontuacao_posicao) throws Exception {
        return false;
    }

    @Override
    public boolean alterar(PontuacaoPosicao pontuacao_posicao) throws Exception {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(pontuacao_posicao);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new Exception("Erro ao alterar o pontuacao_posicao!");
        } finally {
            entityManager.close();
        }
    }

    @Override
    public boolean deletar(PontuacaoPosicao pontuacao_posicao) throws Exception {
        try {
            PontuacaoPosicao pontuacao_posicao1 = entityManager.find(PontuacaoPosicao.class, pontuacao_posicao.getIdPontuacao_posicao());
            entityManager.getTransaction().begin();
            entityManager.remove(pontuacao_posicao1);
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
            List<PontuacaoPosicao> pontuacao_posicao = null;
            pontuacao_posicao = entityManager.createQuery("SELECT a FROM Pontuacao_posicao a").getResultList();
            return pontuacao_posicao;
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
}
