package Dao;

import Connections.ConnectionFactory;
import Model.Corrida;
import Model.PilotoParticipaCorrida;
import Model.PilotoParticipandoCampeonato;
import java.util.List;
import javax.persistence.EntityManager;

public class PilotoParticipaCorridaDAO implements GenericDAO<PilotoParticipaCorrida>{
    
    private EntityManager entityManager;
    
    public PilotoParticipaCorridaDAO(){
            entityManager = new ConnectionFactory().getConnection();
    }
    
    @Override
    public boolean salvar(PilotoParticipaCorrida o) throws Exception {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(o);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new Exception("Erro ao salvar PilotoParticipaCorrida [" + o.getIdPilotoParticipaCorrida() +"]");
        } finally {
            entityManager.close();
        }
    }

    @Override
    public boolean ler(PilotoParticipaCorrida o) throws Exception {
        return false;
    }

    @Override
    public boolean alterar(PilotoParticipaCorrida o) throws Exception {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(o);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new Exception("Erro ao alterar a PilotoParticipaCorrida!");
        } finally {
            entityManager.close();
        }
    }

    @Override
    public boolean deletar(PilotoParticipaCorrida o) throws Exception {
        try {
            PilotoParticipaCorrida p = entityManager.find(PilotoParticipaCorrida.class, o.getIdPilotoParticipaCorrida());
            entityManager.getTransaction().begin();
            entityManager.remove(p);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            throw new Exception("Erro ao deletar PilotoParticipaCorrida!");
        } finally {
            entityManager.close();
        }
    }

    @Override
    public List<PilotoParticipaCorrida> listarTodos(PilotoParticipaCorrida o) throws Exception {
        try {
            return entityManager.createQuery("SELECT c FROM PilotoParticipaCorrida c where idPilotoParticipaCorrida = :id")
                    .setParameter("id", o.getIdPilotoParticipaCorrida())
                    .getResultList();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            entityManager.close();
        }
    }

    @Override
    public List<PilotoParticipaCorrida> listarTodos() throws Exception {
        try {
            return entityManager.createQuery("SELECT a FROM PilotoParticipaCorrida a ").getResultList();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            entityManager.close();
        }
    }

    @Override
    public PilotoParticipaCorrida getById(int id) throws Exception {
        try {
            return entityManager.find(PilotoParticipaCorrida.class, id);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            entityManager.close();
        }
    }
    
    public List<PilotoParticipaCorrida> listarTodosAscTime() throws Exception {
        try {
            return entityManager.createQuery("SELECT a FROM PilotoParticipaCorrida a order by a.tempoParaTerminar asc").getResultList();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            entityManager.close();
        }
    }
    public PilotoParticipaCorrida listarPilotoCorrida(Corrida corrida, PilotoParticipandoCampeonato piloto) throws Exception {
        try {
            List<PilotoParticipaCorrida> list = entityManager.createQuery("SELECT a FROM PilotoParticipaCorrida a where a.corrida = :corrida AND a.pilotoparticipacampeonato = :piloto").setParameter("corrida", corrida).setParameter("piloto", piloto).getResultList();
            return list.get(0);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            entityManager.close();
        }
    }
}
