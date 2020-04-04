package Dao;

import Connections.ConnectionFactory;
import Model.Kartodromo;

import javax.persistence.EntityManager;
import java.util.List;

public class KartodromoDAO {

    private EntityManager entityManager;

    public KartodromoDAO() {
        entityManager = new ConnectionFactory().getConnection();
    }

    public boolean salvar(Kartodromo kartodromo) throws Exception {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(kartodromo);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new Exception("Erro ao salvar kartodromo [" + kartodromo.getNome() +"]");
        } finally {
            entityManager.close();
        }
    }

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

    public boolean deletar(Kartodromo kartodromo) throws Exception {
        try {
            Kartodromo kartodromo1 = entityManager.find(Kartodromo.class, kartodromo.getId_kartodromo());
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

    public List<Kartodromo> listarTodos() throws Exception {
        try {
            List<Kartodromo> kartodromos = null;
            kartodromos = entityManager.createQuery("SELECT k FROM Kartodromo k").getResultList();
            return kartodromos;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            entityManager.close();
        }
    };

    public Kartodromo getById(int id) throws Exception {
        try {
            return entityManager.find(Kartodromo.class,id);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            entityManager.close();
        }
    }


}
