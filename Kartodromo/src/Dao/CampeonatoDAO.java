package Dao;

import Connections.ConnectionFactory;
import Model.Campeonato;

import javax.persistence.EntityManager;
import java.util.List;

public class CampeonatoDAO implements GenericDAO<Campeonato> {

    private EntityManager entityManager;

    public CampeonatoDAO() {
        entityManager = new ConnectionFactory().getConnection();
    }

    @Override
    public boolean salvar(Campeonato campeonato) throws Exception {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(campeonato);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new Exception("Erro ao salvar Campeonato [" + campeonato.getNome() +"]");
        } finally {
            entityManager.close();
        }
    }

    @Override
    public boolean ler(Campeonato o) throws Exception {
        return false;
    }

    @Override
    public boolean alterar(Campeonato campeonato) throws Exception {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(campeonato);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new Exception("Erro ao alterar o Campeonato!");
        } finally {
            entityManager.close();
        }
    }

    @Override
    public boolean deletar(Campeonato campeonato) throws Exception {
        try {
            Campeonato campeonato1 = entityManager.find(Campeonato.class, campeonato.getIdCampeonato());
            entityManager.getTransaction().begin();
            entityManager.remove(campeonato1);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            throw new Exception("Erro ao deletar Campeonato!");
        } finally {
            entityManager.close();
        }
    }

    @Override
    public List<Campeonato> listarTodos(Campeonato o) throws Exception {
        return null;
    }

    public List<Campeonato> listarCampeonatosFinalizados() throws Exception {
        try {
            entityManager = new ConnectionFactory().getConnection();
            return entityManager.createQuery("SELECT c FROM Campeonato c where c.situacao = 'Finalizado' order by c.dataInicio").getResultList();

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            entityManager.close();
        }
    }

    @Override
    public List<Campeonato> listarTodos() throws Exception {
        try {
            entityManager = new ConnectionFactory().getConnection();
            return entityManager.createQuery("SELECT c FROM Campeonato c where c.situacao != 'Finalizado' order by c.dataInicio").getResultList();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            entityManager.close();
        }
    }

    @Override
    public Campeonato getById(long id) throws Exception {
        try {
            return entityManager.find(Campeonato.class,id);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            entityManager.close();
        }
    }

    public List<Campeonato> getByNomeApenas(String nome) throws Exception {
        try {
            entityManager = new ConnectionFactory().getConnection();
            return entityManager.createQuery("SELECT c FROM Campeonato c where c.nome = :nome order by c.nome").setParameter("nome", nome).getResultList();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            entityManager.close();
        }
    }

    public List<Campeonato> getByNome(String nome) throws Exception {
        try {
            entityManager = new ConnectionFactory().getConnection();
            return entityManager.createQuery("SELECT c FROM Campeonato c where c.nome = :nome and c.situacao != 'Finalizado' order by c.dataInicio").setParameter("nome", nome).getResultList();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            entityManager.close();
        }
    }
    
    public List<Campeonato> listarPorNome() throws Exception {
        try {
            entityManager = new ConnectionFactory().getConnection();
            return entityManager.createQuery("SELECT c FROM Campeonato c where c.situacao != 'Finalizado' order by c.nome").getResultList();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            entityManager.close();
        }
    }
    
    public List<Campeonato> listarPorData() throws Exception {
        try {
            entityManager = new ConnectionFactory().getConnection();
            return entityManager.createQuery("SELECT c FROM Campeonato c where c.situacao != 'Finalizado' order by c.dataInicio").getResultList();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            entityManager.close();
        }
    }
    
    
}
