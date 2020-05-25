package Dao;

import Connections.ConnectionFactory;
import Model.Campeonato;
import Model.Piloto;
import Model.PilotoParticipandoCampeonato;

import java.util.List;
import javax.persistence.EntityManager;

public class PilotoParticipandoCampeonatoDAO implements GenericDAO<PilotoParticipandoCampeonato> {

    private EntityManager entityManager;
    
    public PilotoParticipandoCampeonatoDAO(){
            entityManager = new ConnectionFactory().getConnection();
    }
    
    @Override
    public boolean salvar(PilotoParticipandoCampeonato o) throws Exception {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(o);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new Exception("Erro ao salvar PilotoParticipandoCampeonato [" + o.getIdPilotoParticipandoCampeonato() +"]");
        } finally {
            entityManager.close();
        }
    }

    @Override
    public boolean ler(PilotoParticipandoCampeonato o) throws Exception {
        return false;
    }

    @Override
    public boolean alterar(PilotoParticipandoCampeonato o) throws Exception {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(o);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new Exception("Erro ao alterar a PilotoParticipandoCampeonato!");
        } finally {
            entityManager.close();
        }
    }

    @Override
    public boolean deletar(PilotoParticipandoCampeonato o) throws Exception {
        try {
            PilotoParticipandoCampeonato p = entityManager.find(PilotoParticipandoCampeonato.class, o.getIdPilotoParticipandoCampeonato());
            entityManager.getTransaction().begin();
            entityManager.remove(p);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            throw new Exception("Erro ao deletar PilotoParticipandoCampeonato!");
        } finally {
            entityManager.close();
        }
    }

    @Override
    public List<PilotoParticipandoCampeonato> listarTodos(PilotoParticipandoCampeonato o) throws Exception {
        try {
            return entityManager.createQuery("SELECT c FROM PilotoParticipandoCampeonato c where idPilotoParticipandoCampeonato = :id")
                    .setParameter("id", o.getIdPilotoParticipandoCampeonato())
                    .getResultList();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            entityManager.close();
        }
    }

    @Override
    public List<PilotoParticipandoCampeonato> listarTodos() throws Exception {
        try {
            return entityManager.createQuery("SELECT a FROM PilotoParticipandoCampeonato a ").getResultList();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            entityManager.close();
        }
    }

    @Override
    public PilotoParticipandoCampeonato getById(int id) throws Exception {
        try {
            return entityManager.find(PilotoParticipandoCampeonato.class, id);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            entityManager.close();
        }
    }
    public List<PilotoParticipandoCampeonato> ListarPilotoqueParticipadeCameponatos(Piloto piloto) throws Exception {
        try {
            return entityManager.createQuery("SELECT c FROM PilotoParticipandoCampeonato c "
                    + "where piloto = :p").setParameter("p", piloto).getResultList();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            entityManager.close();
        }
    }
    public List<PilotoParticipandoCampeonato> ListarPilotoParticipadeCameponato(Campeonato campeonato) throws Exception {
        try {
            return entityManager.createQuery("SELECT c FROM PilotoParticipandoCampeonato c where c.campeonato = :campeonato").setParameter("campeonato", campeonato).getResultList();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            entityManager.close();
        }
    }

}
