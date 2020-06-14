package Dao;

import java.util.List;

import Connections.ConnectionFactory;
import Model.Piloto;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

public class PilotoDAO implements GenericDAO<Piloto> {

    private EntityManager entityManager;

    public PilotoDAO() {
        entityManager = new ConnectionFactory().getConnection();
    }

    @Override
    public boolean salvar(Piloto piloto) throws Exception {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(piloto);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new Exception("Erro ao salvar piloto [" + piloto.getNome() + "]");
        } finally {
            entityManager.close();
        }
    }

    @Override
    public boolean ler(Piloto o) throws Exception {
        return false;
    }

    @Override
    public boolean alterar(Piloto piloto) throws Exception {
        try {
            
            entityManager.getTransaction().begin();
            entityManager.merge(piloto);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new Exception("Erro ao alterar o piloto!");
        } finally {
            entityManager.close();
        }
    }

    @Override
    public boolean deletar(Piloto piloto) throws Exception {
        try {

            Piloto piloto1 = entityManager.find(Piloto.class, getIdPiloto(piloto));
            entityManager.getTransaction().begin();
            entityManager.remove(piloto1);
            entityManager.getTransaction().commit();

            return true;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            entityManager.close();
        }
    }

    @Override
    public List<Piloto> listarTodos(Piloto piloto) throws Exception {
        try {
            Query query = entityManager.createQuery("SELECT p FROM Piloto p WHERE email = :email and senha = :senha");
            query.setParameter("email", piloto.getEmail());
            query.setParameter("senha", piloto.getSenha());
            return query.getResultList();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            entityManager.close();
        }
    }

    @Override
    public List<Piloto> listarTodos() throws Exception {
        try {
            Query query = entityManager.createQuery("SELECT p FROM Piloto p");
            return query.getResultList();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            entityManager.close();
        }
    }
    
    public Piloto listarporapelido(String apelido) throws Exception {
        try {
            Query query = entityManager.createQuery("SELECT p FROM Piloto p where p.apelido = :apelido").setParameter("apelido", apelido);
            List<Piloto> list = query.getResultList();
            return list.get(0);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            entityManager.close();
        }
    }

    @Override
    public Piloto getById(long id) throws Exception {
        try {
            return entityManager.find(Piloto.class, id);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            entityManager.close();
        }
    }

    private long getIdPiloto(Piloto piloto) throws Exception {

        // Monta query //
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SELECT p FROM Piloto p ");
        stringBuilder.append("WHERE p.nomePiloto = :nome ");
        stringBuilder.append("and p.cpfPiloto = :cpf ");
        stringBuilder.append("and p.dataNascimentoPiloto = :data ");
        stringBuilder.append("and p.emailPiloto = :email ");
        stringBuilder.append("and p.senhaPiloto = :senha ");

        // Pega o piloto para resgatar o id do mesmo //
        Query query = entityManager.createQuery(stringBuilder.toString());
        query.setParameter("nome", piloto.getNome());
        query.setParameter("cpf", piloto.getCpfPiloto());
        query.setParameter("data", piloto.getDataNascimentoPiloto());
        query.setParameter("email", piloto.getEmail());
        query.setParameter("senha", piloto.getSenha());

        try {
            Piloto pi = (Piloto) query.getSingleResult();
            return pi.getId();
        } catch (NoResultException noResultException) {
            throw new Exception("Nenhum piloto encontrado! Revise os campos");
        }

    }
    public boolean VerificarApelidoExistente(String apelido) throws Exception {
        try {
            List <Piloto> list = entityManager.createQuery
        ("SELECT p FROM Piloto p where p.apelido = :apelido ")
                    .setParameter("apelido", apelido).getResultList();
            for(Piloto piloto : list){
                return true;
            }
            return false;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            entityManager.close();
        }
    }

}