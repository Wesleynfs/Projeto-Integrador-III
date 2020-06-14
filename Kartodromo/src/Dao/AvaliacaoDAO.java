package Dao;

import Connections.ConnectionFactory;
import Model.Avaliacao;
import Model.Kartodromo;

import javax.persistence.EntityManager;
import java.util.List;

public class AvaliacaoDAO implements GenericDAO<Avaliacao> {

    private EntityManager entityManager;

    public AvaliacaoDAO() {
        entityManager = new ConnectionFactory().getConnection();
    }

    @Override
    public boolean salvar(Avaliacao avaliacao) throws Exception {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(avaliacao);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new Exception("Erro ao salvar avaliacao do piloto [" + avaliacao.getPiloto().getNome() + "]");
        } finally {
            entityManager.close();
        }
    }

    @Override
    public boolean ler(Avaliacao o) throws Exception {
        return false;
    }

    @Override
    public boolean alterar(Avaliacao avaliacao) throws Exception {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(avaliacao);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new Exception("Erro ao alterar o avaliacao!");
        } finally {
            entityManager.close();
        }
    }

    @Override
    public boolean deletar(Avaliacao avaliacao) throws Exception {
        try {
            Avaliacao avaliacao1 = entityManager.find(Avaliacao.class, avaliacao.getIdAvaliacao());
            entityManager.getTransaction().begin();
            entityManager.remove(avaliacao1);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            throw new Exception("Erro ao deletar avaliacão!");
        } finally {
            entityManager.close();
        }
    }

    @Override
    public List<Avaliacao> listarTodos(Avaliacao o) throws Exception {
        return null;
    }

    @Override
    public List<Avaliacao> listarTodos() throws Exception {
        try {
            return entityManager.createQuery("SELECT a FROM Avaliacao a").getResultList();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            entityManager.close();
        }
    }

    @Override
    public Avaliacao getById(long id) throws Exception {
        try {
            return entityManager.find(Avaliacao.class, id);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            entityManager.close();
        }
    }
    
    public List<Avaliacao> listarPorKartodromo(Kartodromo kartodromo) throws Exception {
        try {
            return entityManager.createQuery("SELECT a FROM Avaliacao a WHERE kartodromo = :kart")
				.setParameter("kart" , kartodromo)
				.getResultList();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
            
        } finally {
            entityManager.close();
        }
    }
}
