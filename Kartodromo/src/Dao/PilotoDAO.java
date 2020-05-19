package Dao;

import java.util.List;
import Connections.ConnectionFactory;
import Model.Piloto;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class PilotoDAO implements GenericDAO<Piloto> {

    private EntityManager entityManager;

    public PilotoDAO() {
        entityManager = new ConnectionFactory().getConnection();
    }

    @Override
    public boolean salvar(Piloto piloto) throws Exception {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(piloto);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new Exception("Erro ao salvar piloto [" + piloto.getNomePiloto() +"]");
        } finally {
            entityManager.close();
        }
    }

    @Override
    public boolean ler(Piloto o) throws Exception {
        return false;
    }

    @Override
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

    @Override
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

    @Override
    public List<Piloto> listarTodos(Piloto piloto) throws Exception {
        try {
            Query query = entityManager.createQuery("SELECT p FROM Piloto p WHERE emailpiloto = :email and senhapiloto = :senha");
            query.setParameter("email",piloto.getEmailPiloto());
            query.setParameter("senha",piloto.getSenhaPiloto());
            return query.getResultList();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            entityManager.close();
        }
    }

    @Override
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

    @Override
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