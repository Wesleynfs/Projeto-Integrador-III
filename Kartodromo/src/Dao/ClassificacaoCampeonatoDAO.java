package Dao;

import Connections.ConnectionFactory;
import Model.Avaliacao;
import Model.ClassificacaoCampeonato;

import javax.persistence.EntityManager;
import java.util.List;

public class ClassificacaoCampeonatoDAO {

    private EntityManager entityManager;

    public ClassificacaoCampeonatoDAO() {
        entityManager =  new ConnectionFactory().getConnection();
    }

    public boolean salvar(ClassificacaoCampeonato classificacaoCampeonato) throws Exception {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(classificacaoCampeonato);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new Exception("Erro ao salvar classificação do campeonato: Piloto" +
                    " [" + classificacaoCampeonato.getPiloto().getNome() +"]");
        } finally {
            entityManager.close();
        }
    }

    public boolean alterar(ClassificacaoCampeonato classificacaoCampeonato) throws Exception {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(classificacaoCampeonato);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new Exception("Erro ao alterar o classificação do campeonato!");
        } finally {
            entityManager.close();
        }
    }

    public boolean deletar(ClassificacaoCampeonato classificacaoCampeonato) throws Exception {
        try {
            ClassificacaoCampeonato classificacaoCampeonato1 = entityManager.find(ClassificacaoCampeonato.class, classificacaoCampeonato.getIdClassificacaoCampeonato());
            entityManager.getTransaction().begin();
            entityManager.remove(classificacaoCampeonato1);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            throw new Exception("Erro ao deletar classificação do campeonato!");
        } finally {
            entityManager.close();
        }
    }

    public List<ClassificacaoCampeonato> listarTodos() throws Exception {
        try {
            return entityManager.createQuery("SELECT c FROM ClassificacaoCampeonato c").getResultList();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            entityManager.close();
        }
    };

    public ClassificacaoCampeonato getById(int id) throws Exception {
        try {
            return entityManager.find(ClassificacaoCampeonato.class,id);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            entityManager.close();
        }
    }

}
