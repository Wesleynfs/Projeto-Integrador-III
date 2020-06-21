package Dao;

import Connections.ConnectionFactory;
import Model.Campeonato;
import Model.ConviteCampeonato;
import Model.Piloto;
import java.util.List;
import javax.persistence.EntityManager;


public class ConviteCampeonatoDAO  implements GenericDAO<ConviteCampeonato> {
    
    private EntityManager entityManager;
    
    public ConviteCampeonatoDAO(){
            entityManager = new ConnectionFactory().getConnection();
    }
    
    @Override
    public boolean salvar(ConviteCampeonato o) throws Exception {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(o);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new Exception("Erro ao salvar ConviteCampeonato [" + o.getIdPilotoConviteCampeonato() +"]");
        } finally {
            entityManager.close();
        }
    }

    @Override
    public boolean ler(ConviteCampeonato o) throws Exception {
        return false;
    }

    @Override
    public boolean alterar(ConviteCampeonato o) throws Exception {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(o);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new Exception("Erro ao alterar a ConviteCampeonato!");
        } finally {
            entityManager.close();
        }
    }

    @Override
    public boolean deletar(ConviteCampeonato o) throws Exception {
        try {
            ConviteCampeonato p = entityManager.find(ConviteCampeonato.class, o.getIdPilotoConviteCampeonato());
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
    public List<ConviteCampeonato> listarTodos(ConviteCampeonato o) throws Exception {
        try {
            return entityManager.createQuery("SELECT c FROM ConviteCampeonato c where idPilotoConviteCampeonato = :id")
                    .setParameter("id", o.getIdPilotoConviteCampeonato())
                    .getResultList();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            entityManager.close();
        }
    }

    public List<ConviteCampeonato> listarConvitesJaEnviadosPeloPiloto(Piloto piloto , Campeonato campeonato , String statusConvite) throws Exception {
        try {
            return entityManager.createQuery("SELECT c FROM ConviteCampeonato c WHERE c.campeonato = :campeonato AND c.pilotoQueConvidou = :piloto AND c.statusConvite = :status")
                    .setParameter("piloto",piloto)
                    .setParameter("campeonato",campeonato)
                    .setParameter("status" , statusConvite).getResultList();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            entityManager.close();
        }
    }

    public boolean verificarConviteExistente(ConviteCampeonato o) throws Exception {
        try {
            List <ConviteCampeonato> list = entityManager.createQuery("SELECT c FROM ConviteCampeonato c where c.campeonato = :campeonato AND c.pilotoConvidado = :piloto")
                    .setParameter("piloto", o.getPilotoConvidado())
                    .setParameter("campeonato", o.getCampeonato())
                    .getResultList();

            return !list.isEmpty();
            
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            entityManager.close();
        }
    }

    @Override
    public List<ConviteCampeonato> listarTodos() throws Exception {
        try {
            return entityManager.createQuery("SELECT c FROM ConviteCampeonato c").getResultList();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            entityManager.close();
        }
    }

    @Override
    public ConviteCampeonato getById(long id) throws Exception {
        try {
            return entityManager.find(ConviteCampeonato.class, id);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            entityManager.close();
        }
    }
    public List<ConviteCampeonato> ListarConviteNaoVisualizadosPorPiloto(Piloto piloto) throws Exception {
        try {
            return entityManager.createQuery("SELECT c FROM ConviteCampeonato c WHERE c.pilotoConvidado = :p AND c.statusConvite = 'Não Visualizado' OR c.pilotoConvidado = :p AND c.statusConvite = 'Visualizado'")
                    .setParameter("p", piloto)
                    .getResultList();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            entityManager.close();
        }
    }

}
