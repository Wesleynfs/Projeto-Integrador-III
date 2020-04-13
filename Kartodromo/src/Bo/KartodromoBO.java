package Bo;

import Dao.KartodromoDAO;
import Model.Kartodromo;

import java.util.List;

public class KartodromoBO {

    private KartodromoDAO kartodromoDAO;

    public KartodromoBO() {

    }

    public boolean criarKartodromo(Kartodromo kartodromo) throws Exception {
        if (validaKartodromo(kartodromo)) {
            kartodromoDAO = new KartodromoDAO();
            return kartodromoDAO.salvar(kartodromo);
        }
        return false;
    }

    public boolean deletarKartodromo(Kartodromo kartodromo) throws Exception {
        if (validaKartodromo(kartodromo)){
            kartodromoDAO = new KartodromoDAO();
            return kartodromoDAO.deletar(kartodromo);
        }
        return false;
    }

    public boolean alterarKartodromo(Kartodromo kartodromo) throws Exception {
        if (validaKartodromo(kartodromo)) {
            kartodromoDAO = new KartodromoDAO();
            return kartodromoDAO.alterar(kartodromo);
        }
        return false;
    }

    public List<Kartodromo> listarKartodromos() throws Exception {
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

    private boolean validaKartodromo(Kartodromo kartodromo) throws Exception {
        if (kartodromo.getNome().equals("")) {
            throw new Exception("Nome do kartodromo não pode ficar em branco!");
        } else if (kartodromo.getSenha().length() > 50) {
            throw new Exception("Senha maior do que o permitido");
        }
        return true;
    }

    private boolean validaId(int id) throws Exception {
        if(id <= 0) {
            throw new Exception("Id do kartodromo não pode ser menor ou igual a 0");
        }
        return true;
    }

}
