package Dao;

import Connections.ConnectionFactory;
import Model.Cidade;
import Model.Estado;

import javax.persistence.EntityManager;
import java.util.List;

public class EstadoDAO{

    private EntityManager entityManager;

    public EstadoDAO() {
        entityManager = new ConnectionFactory().getConnection();
    }

    public Estado listarEstadoPorNome(String nome) throws Exception {
        try {
            return (Estado) entityManager.createQuery("SELECT e FROM Estado e WHERE e.nome = :nome ORDER BY e.nome").
            setParameter("nome",nome).getSingleResult();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            entityManager.close();
        }
    }

    public List<Estado> listarTodos() throws Exception {
        try {
            return entityManager.createQuery("SELECT e FROM Estado e ORDER BY e.nome").getResultList();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            entityManager.close();
        }
    }
}
