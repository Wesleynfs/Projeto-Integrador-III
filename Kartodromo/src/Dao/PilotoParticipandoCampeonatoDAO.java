package Dao;

import Connections.ConnectionFactory;
import Model.Campeonato;
import Model.Piloto;
import Model.PilotoParticipandoCampeonato;

import java.util.List;
import javax.persistence.EntityManager;

public class PilotoParticipandoCampeonatoDAO implements GenericDAO<PilotoParticipandoCampeonato> {

    private EntityManager entityManager;

    public PilotoParticipandoCampeonatoDAO() {
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
            throw new Exception("Erro ao salvar PilotoParticipandoCampeonato [" + o.getIdPilotoParticipandoCampeonato() + "]");
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
            return entityManager.createQuery("SELECT c FROM PilotoParticipandoCampeonato c where idPilotoParticipandoCampeonato = :id AND c.campeonato.situacao != 'Finalizado'")
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
            return entityManager.createQuery("SELECT a FROM PilotoParticipandoCampeonato a where a.campeonato.situacao != 'Finalizado'").getResultList();
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

    public List<PilotoParticipandoCampeonato> listarPilotoQueParticipaDeCampeonato(Piloto piloto) throws Exception {
        try {
            entityManager = new ConnectionFactory().getConnection();
            return entityManager.createQuery("SELECT c FROM PilotoParticipandoCampeonato c where piloto = :p AND c.campeonato.situacao != 'Finalizado'").setParameter("p", piloto).getResultList();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            entityManager.close();
        }
    }

    public List<PilotoParticipandoCampeonato> listarPilotoQueParticipaDeCampeonato(Campeonato campeonato) throws Exception {
        try {
            entityManager = new ConnectionFactory().getConnection();
            return entityManager.createQuery("SELECT c FROM PilotoParticipandoCampeonato c where campeonato = :campeonato AND c.campeonato.situacao != 'Finalizado'").setParameter("campeonato", campeonato).getResultList();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            entityManager.close();
        }
    }


    public List<PilotoParticipandoCampeonato> Listar_o_piloto_do_campeonato(Piloto piloto, Campeonato campeonato) throws Exception {
        try {
            entityManager = new ConnectionFactory().getConnection();
            return entityManager.createQuery("SELECT c FROM PilotoParticipandoCampeonato c where c.piloto = :piloto AND c.campeonato = :campeonato AND c.campeonato.situacao != 'Finalizado'")
                    .setParameter("piloto", piloto)
                    .setParameter("campeonato", campeonato)
                    .getResultList();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            entityManager.close();
        }
    }

    public List<PilotoParticipandoCampeonato> listarPilotoCampeonatoFinalizados(Piloto piloto) throws Exception {
        try {
            entityManager = new ConnectionFactory().getConnection();
            return entityManager.createQuery("SELECT c FROM PilotoParticipandoCampeonato c where c.piloto = :piloto AND c.campeonato.situacao = 'Finalizado'")
                    .setParameter("piloto", piloto)
                    .getResultList();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            entityManager.close();
        }

    }

    public List<PilotoParticipandoCampeonato> listarPilotoCampeonatoFinalizadosPorNome(Piloto piloto , String nome) throws Exception {
        try {
            entityManager = new ConnectionFactory().getConnection();
            return entityManager.createQuery("SELECT c FROM PilotoParticipandoCampeonato c where c.piloto = :piloto AND c.campeonato.situacao = 'Finalizado' AND c.campeonato.nome = :nome")
                    .setParameter("piloto", piloto)
                    .setParameter("nome", nome)
                    .getResultList();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            entityManager.close();
        }

    }

    public List<PilotoParticipandoCampeonato> listarPilotoQueParticipaDeCampeonatoOrderPontuacao(Campeonato campeonato) throws Exception {
        try {
            entityManager = new ConnectionFactory().getConnection();
            return entityManager.createQuery("SELECT c FROM PilotoParticipandoCampeonato c where campeonato = :campeonato order by c.pontuacao desc").setParameter("campeonato", campeonato).getResultList();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            entityManager.close();
        }
    }


}
