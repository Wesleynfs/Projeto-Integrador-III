package Dao;

import Connections.ConnectionFactory;
import Model.Cidade;
import Model.Estado;

import javax.persistence.EntityManager;
import java.util.List;

public class CidadeDAO {

    private EntityManager entityManager;

    public CidadeDAO() {
        entityManager = new ConnectionFactory().getConnection();
    }

    public Cidade listarCidadePorNome(String cidade) throws Exception {
        try {
            return (Cidade) entityManager.createQuery("SELECT c FROM Cidade c WHERE c.nome = :cidade ORDER BY c.nome")
                    .setParameter("cidade", cidade).getSingleResult();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            entityManager.close();
        }
    }

    public List<Cidade> listarCidadesPorEstado(Estado estado) throws Exception {
        try {
            return entityManager.createQuery("SELECT c FROM Cidade c WHERE c.estado = :estado ORDER BY c.nome")
                    .setParameter("estado", estado).getResultList();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            entityManager.close();
        }
    }
}
