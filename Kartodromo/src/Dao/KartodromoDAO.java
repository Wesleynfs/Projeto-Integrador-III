package Dao;

import Connections.ConnectionFactory;
import Model.Kartodromo;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class KartodromoDAO implements GenericDAO<Kartodromo> {

    private EntityManager entityManager;

    public KartodromoDAO() {
        entityManager = new ConnectionFactory().getConnection();
    }

    @Override
    public boolean salvar(Kartodromo kartodromo) throws Exception {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(kartodromo);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new Exception("Erro ao salvar kartodromo [" + kartodromo.getNomeKartodromo() + "]");
        } finally {
            entityManager.close();
        }
    }

    @Override
    public boolean ler(Kartodromo o) throws Exception {
        return false;
    }

    @Override
    public boolean alterar(Kartodromo kartodromo) throws Exception {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(kartodromo);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new Exception("Erro ao alterar o kartodromo!");
        } finally {
            entityManager.close();
        }
    }

    @Override
    public boolean deletar(Kartodromo kartodromo) throws Exception {
        try {
            Kartodromo kartodromo1 = entityManager.find(Kartodromo.class, kartodromo.getIdKartodromo());
            entityManager.getTransaction().begin();
            entityManager.remove(kartodromo1);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            throw new Exception("Erro ao deletar kartodromo!");
        } finally {
            entityManager.close();
        }
    }

    @Override
    public List<Kartodromo> listarTodos(Kartodromo o) throws Exception {
        try {

            Query query = entityManager.createQuery("SELECT k FROM Kartodromo k WHERE emailkartodromo = :email and senhakartodromo = :senha");
            query.setParameter("email", o.getEmailKartodromo());
            query.setParameter("senha", o.getSenhaKartodromo());
            return query.getResultList();

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            entityManager.close();
        }
    }

    @Override
    public List<Kartodromo> listarTodos() throws Exception {
        try {
            Query query = entityManager.createQuery("SELECT k FROM Kartodromo k");
            return query.getResultList();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            entityManager.close();
        }
    }

    @Override
    public Kartodromo getById(int id) throws Exception {
        try {
            return entityManager.find(Kartodromo.class, id);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            entityManager.close();
        }
    }
}
