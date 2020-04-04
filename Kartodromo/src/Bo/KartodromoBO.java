package Bo;

import Dao.KartodromoDAO;
import Model.Kartodromo;

import java.util.List;

public class KartodromoBO {

    private KartodromoDAO kartodromoDAO;

    public KartodromoBO() {
        kartodromoDAO = new KartodromoDAO();
    }

    public boolean criarKartodromo(Kartodromo kartodromo) throws Exception {
        validaKartodromo(kartodromo);
        return kartodromoDAO.salvar(kartodromo);
    }

    public boolean deletarKartodromo(Kartodromo kartodromo) throws Exception {
        validaKartodromo(kartodromo);
        return kartodromoDAO.deletar(kartodromo);
    }

    public boolean alterarKartodromo(Kartodromo kartodromo) throws Exception {
        validaKartodromo(kartodromo);
        return kartodromoDAO.alterar(kartodromo);
    }

    public List<Kartodromo> listarKartodromos() throws Exception {
        return kartodromoDAO.listarTodos();
    }

    public Kartodromo getById(int id) throws Exception {
        validaId(id);
        return kartodromoDAO.getById(id);
    }

    private void validaKartodromo(Kartodromo kartodromo) throws Exception {
        if (kartodromo.getNome().equals("")) {
            throw new Exception("Nome do kartodromo não pode ficar em branco!");
        } else if (kartodromo.getSenha().length() > 50) {
            throw new Exception("Senha maior do que o permitido");
        }
    }

    private void validaId(int id) throws Exception {
        if(id <= 0) {
            throw new Exception("Id do kartodromo não pode ser menor ou igual a 0");
        }
    }

}
