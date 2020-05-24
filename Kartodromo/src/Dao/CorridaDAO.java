package Dao;

import Connections.ConnectionFactory;
import Model.Corrida;
import Model.Piloto;

import javax.persistence.EntityManager;
import java.util.List;

public class CorridaDAO implements GenericDAO<Corrida> {

    private EntityManager entityManager;

    public CorridaDAO() {
        entityManager = new ConnectionFactory().getConnection();
    }

    @Override
    public boolean salvar(Corrida o) throws Exception {
        return false;
    }

    @Override
    public boolean ler(Corrida o) throws Exception {
        return false;
    }

    @Override
    public boolean alterar(Corrida o) throws Exception {
        return false;
    }

    @Override
    public boolean deletar(Corrida o) throws Exception {
        return false;
    }

    @Override
    public List<Corrida> listarTodos(Corrida o) throws Exception {
        return null;
    }

    @Override
    public List<Corrida> listarTodos() throws Exception {
        return null;
    }

    @Override
    public Corrida getById(int id) throws Exception {
        return null;
    }

    public List<Corrida> listarTodasAsCorridasMarcadas(Piloto piloto) throws Exception {
        try {
            return entityManager.createQuery("SELECT c FROM Corrida c WHERE kartodromo = :kart")
                    .setParameter("piloto" , piloto)
                    .getResultList();
        } catch (Exception e) {
            throw new Exception(e.getMessage());

        } finally {
            entityManager.close();
        }
    }

}
