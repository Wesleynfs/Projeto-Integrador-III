package Bo;

import Dao.KartodromoDAO;
import Dao.PilotoDAO;
import Model.Kartodromo;
import Model.Piloto;

import java.util.List;

public class KartodromoBO implements GenericBO<Kartodromo> {

    private KartodromoDAO kartodromoDAO;

    public KartodromoBO() {

    }

    @Override
    public boolean criar(Kartodromo o) throws Exception {
        if (valida(o)) {
            kartodromoDAO = new KartodromoDAO();
            return kartodromoDAO.salvar(o);
        }
        return false;
    }

    @Override
    public boolean deletar(Kartodromo o) throws Exception {
        if (valida(o)){
            kartodromoDAO = new KartodromoDAO();
            return kartodromoDAO.deletar(o);
        }
        return false;
    }

    @Override
    public boolean alterar(Kartodromo o) throws Exception {
        if (valida(o)) {
            kartodromoDAO = new KartodromoDAO();
            return kartodromoDAO.alterar(o);
        }
        return false;
    }

    @Override
    public List<Kartodromo> listarPorItem(Kartodromo o) throws Exception {
        return null;
    }

    @Override
    public List<Kartodromo> listarTodos() throws Exception {
        kartodromoDAO = new KartodromoDAO();
        return kartodromoDAO.listarTodos();
    }

    public Kartodromo getById(int id) throws Exception {
        if (validaId(id)) {
            kartodromoDAO = new KartodromoDAO();
            return kartodromoDAO.getById(id);
        }
        return null;
    }

    @Override
    public boolean valida(Kartodromo o) throws Exception {
        if (o.getNomeKartodromo().equals("")) {
            throw new Exception("Nome do kartodromo não pode ficar em branco!");
        } else if (o.getSenhaKartodromo().length() > 50) {
            throw new Exception("Senha maior do que o permitido");
        }
        return true;
    }

    @Override
    public boolean validaId(int id) throws Exception {
        if(id <= 0) {
            throw new Exception("Id do kartodromo não pode ser menor ou igual a 0");
        }
        return true;
    }

    public boolean validaLogin(Kartodromo o) throws Exception {
        if (o.getEmailKartodromo().equals("")) {
            throw new Exception("Email do kartodromo não pode ficar em branco!");
        } else if (o.getSenhaKartodromo().length() > 50) {
            throw new Exception("Senha maior do que o permitido");
        } else if (o.getCidade().equals("")) {
            throw new Exception("Cidade em branco!");
        } else if (o.getNomeKartodromo().length() > 50) {
            throw new Exception("Nome maior do que o permitido");
        }else if (o.getEstado().equals("")) {
            throw new Exception("Estado em branco!");
        } else if (o.getRua().equals("")) {
            throw new Exception("Rua em branco!");
        } else if (o.getSenhaKartodromo().equals("")) {
            throw new Exception("senha em branco!");
        } else if (o.getRua().length() > 100) {
            throw new Exception("Rua maior do que o permitido");
        }else if (o.getEstado().length() > 50) {
            throw new Exception("Estado maior do que o permitido");
        }
        return true;
    }

    public Kartodromo logar(Kartodromo o) throws Exception {
        if (!o.getEmailKartodromo().equals("") && !o.getSenhaKartodromo().equals("")) {
            List<Kartodromo> list = new KartodromoDAO().listarTodos(o);
            if (list.size() > 0) {
                return list.get(0);
            } else {
                throw new Exception("Kartodromo não encontrado!");
            }
        } else {
            throw new Exception("Kartodromo não validado!");
        }
    }

}
