package Dao;

import java.util.List;
import Connections.ConnectionFactory;
import Model.Piloto;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class PilotoDAO {

    private EntityManager entityManager;

    public PilotoDAO() {
        entityManager = new ConnectionFactory().getConnection();
    }

    public boolean salvar(Piloto piloto) throws Exception {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(piloto);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new Exception("Erro ao salvar piloto [" + piloto.getNome() +"]");
        } finally {
            entityManager.close();
        }
    }

    public boolean alterar(Piloto piloto) throws Exception {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(piloto);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new Exception("Erro ao alterar o piloto!");
        } finally {
            entityManager.close();
        }
    }

    public boolean deletar(Piloto piloto) throws Exception {
        try {
            Piloto piloto1 = entityManager.find(Piloto.class, piloto.getIdPiloto());
            entityManager.getTransaction().begin();
            entityManager.remove(piloto1);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            throw new Exception("Erro ao deletar piloto!");
        } finally {
            entityManager.close();
        }
    }

    public List<Piloto> listarTodos(Piloto piloto) throws Exception {
        try {
            Query query = entityManager.createQuery("SELECT p FROM Piloto p WHERE email = :email and senha = :senha");
            query.setParameter("email",piloto.getEmail());
            query.setParameter("senha",piloto.getSenha());
            System.out.println("AQUI " + query.getResultList());
            return query.getResultList();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            entityManager.close();
        }
    }

    public List<Piloto> listarTodos() throws Exception {
        try {
            Query query = entityManager.createQuery("SELECT p FROM Piloto p");
            return query.getResultList();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            entityManager.close();
        }
    }

    public Piloto getById(int id) throws Exception {
        try {
            return entityManager.find(Piloto.class,id);
        } catch (Exception  e) {
            throw new Exception(e.getMessage());
        } finally {
            entityManager.close();
        }
    }

}