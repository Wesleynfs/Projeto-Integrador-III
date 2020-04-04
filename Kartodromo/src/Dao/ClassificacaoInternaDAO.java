package Dao;

import Connections.ConnectionFactory;
import Model.Avaliacao;
import Model.ClassificacaoInterna;

import javax.persistence.EntityManager;
import java.util.List;

public class ClassificacaoInternaDAO {

    private EntityManager entityManager;

    public ClassificacaoInternaDAO() {
        entityManager = new ConnectionFactory().getConnection();
    }

    public boolean salvar(ClassificacaoInterna classificacaoInterna) throws Exception {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(classificacaoInterna);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new Exception("Erro ao salvar classificação interna do piloto [" + classificacaoInterna.getPiloto().getNome() +"]");
        } finally {
            entityManager.close();
        }
    }

    public boolean alterar(ClassificacaoInterna classificacaoInterna) throws Exception {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(classificacaoInterna);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new Exception("Erro ao alterar o classificação interna!");
        } finally {
            entityManager.close();
        }
    }

    public boolean deletar(ClassificacaoInterna classificacaoInterna) throws Exception {
        try {
            ClassificacaoInterna classificacaoInterna1 = entityManager.find(ClassificacaoInterna.class, classificacaoInterna.getIdClassificacaoInterna());
            entityManager.getTransaction().begin();
            entityManager.remove(classificacaoInterna1);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            throw new Exception("Erro ao deletar avaliacão!");
        } finally {
            entityManager.close();
        }
    }

    public List<ClassificacaoInterna> listarTodos() throws Exception {
        try {
            return entityManager.createQuery("SELECT c FROM ClassificacaoInterna c").getResultList();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            entityManager.close();
        }
    };

    public ClassificacaoInterna getById(int id) throws Exception {
        try {
            return entityManager.find(ClassificacaoInterna.class,id);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            entityManager.close();
        }
    }


}
