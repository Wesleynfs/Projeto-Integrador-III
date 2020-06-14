package Dao;

import Connections.ConnectionFactory;
import Model.Campeonato;
import Model.Corrida;

import javax.persistence.EntityManager;
import java.util.List;

public class CorridaDAO implements GenericDAO<Corrida> {

    private EntityManager entityManager;

    public CorridaDAO() {
        entityManager = new ConnectionFactory().getConnection();
    }

    @Override
    public boolean salvar(Corrida o) throws Exception {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(o);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new Exception("Erro ao salvar Corrida [" + o.getIdCorrida() +"]");
        } finally {
            entityManager.close();
        }
    }

    @Override
    public boolean ler(Corrida o) throws Exception {
        return false;
    }

    @Override
    public boolean alterar(Corrida o) throws Exception {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(o);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new Exception("Erro ao alterar a Corrida!");
        } finally {
            entityManager.close();
        }
    }

    @Override
    public boolean deletar(Corrida o) throws Exception {
        try {
            Corrida corrida1 = entityManager.find(Corrida.class, o.getIdCorrida());
            entityManager.getTransaction().begin();
            entityManager.remove(corrida1);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            throw new Exception("Erro ao deletar corrida!");
        } finally {
            entityManager.close();
        }
    }

    @Override
    public List<Corrida> listarTodos(Corrida o) throws Exception {
        try {
            return entityManager.createQuery("SELECT c FROM Corrida c "
                    + "where c.idCorrida = :id")
                    .setParameter("id", o.getIdCorrida())
                    .getResultList();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            entityManager.close();
        }
    }

    @Override
    public List<Corrida> listarTodos() throws Exception {
        try {
            return entityManager.createQuery("SELECT c FROM Corrida c").getResultList();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            entityManager.close();
        }
    }

    @Override
    public Corrida getById(long id) throws Exception {
        try {
            return entityManager.find(Corrida.class, id);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            entityManager.close();
        }
    }

    public List<Corrida> listarTodasAsCorridasMarcadasDeCampeonato(Campeonato o) throws Exception {
        try {
            return entityManager.createQuery("SELECT c FROM Corrida c WHERE c.campeonato = :campeonato")
                    .setParameter("campeonato" , o)
                    .getResultList();
        } catch (Exception e) {
            throw new Exception(e.getMessage());

        } finally {
            entityManager.close();
        }
    }
    
        public Corrida getByNome(String nome) throws Exception {
        try {
            List<Corrida> lista = entityManager.createQuery("SELECT c FROM Corrida c where c.nomeCorrida = :nome ").setParameter("nome", nome).getResultList();
            return lista.get(0);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            entityManager.close();
        }
    }

}
