package Dao;

import Connections.ConnectionFactory;
import Model.AvisoCampeonato;
import Model.Piloto;
import javax.persistence.EntityManager;
import java.util.List;

public class AvisoCampeonatoDAO implements GenericDAO<AvisoCampeonato> {

    private EntityManager entityManager;

    public AvisoCampeonatoDAO() {
        entityManager = new ConnectionFactory().getConnection();
    }

    @Override
    public boolean salvar(AvisoCampeonato avisoCampeonato) throws Exception {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(avisoCampeonato);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new Exception("Erro ao salvar Aviso do Campeonato [" + avisoCampeonato.getIdAvisoCampeonato() +"]");
        } finally {
            entityManager.close();
        }
    }

    @Override
    public boolean ler(AvisoCampeonato avisoCampeonato) throws Exception {
        return false;
    }

    @Override
    public boolean alterar(AvisoCampeonato avisoCampeonato) throws Exception {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(avisoCampeonato);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new Exception("Erro ao alterar o aviso do campeonato!");
        } finally {
            entityManager.close();
        }
    }

    @Override
    public boolean deletar(AvisoCampeonato avisoCampeonato) throws Exception {
        try {
            AvisoCampeonato avisoCampeonato1 = entityManager.find(AvisoCampeonato.class, avisoCampeonato.getIdAvisoCampeonato());
            entityManager.getTransaction().begin();
            entityManager.remove(avisoCampeonato1);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            throw new Exception("Erro ao deletar aviso do campeonato!");
        } finally {
            entityManager.close();
        }
    }

    @Override
    public List<AvisoCampeonato> listarTodos(AvisoCampeonato avisoCampeonato) throws Exception {
        return null;
    }

    @Override
    public List<AvisoCampeonato> listarTodos() throws Exception {
        try {
            List<AvisoCampeonato> avisoCampeonato = null;
            avisoCampeonato = entityManager.createQuery("SELECT a FROM AvisoCampeonato a").getResultList();
            return avisoCampeonato;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            entityManager.close();
        }
    }

    @Override
    public AvisoCampeonato getById(long id) throws Exception {
        try {
            return entityManager.find(AvisoCampeonato.class,id);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            entityManager.close();
        }
    }
    
        public List<AvisoCampeonato> listarAvisoNaoVizualizados(Piloto piloto) throws Exception {
        try {
            return entityManager.createQuery("SELECT a FROM AvisoCampeonato a where a.statusAviso = 'Não vizualizado' AND a.pilotos = :piloto").setParameter("piloto", piloto).getResultList();
            
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            entityManager.close();
        }
    }
}
