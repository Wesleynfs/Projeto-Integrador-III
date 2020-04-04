package Bo;

import Dao.PilotoDAO;
import Model.Piloto;

import java.util.List;

public class PilotoBO {

    private PilotoDAO pilotoDAO;

    public PilotoBO() {
        pilotoDAO = new PilotoDAO();
    }

    public boolean criarPiloto(Piloto piloto) throws Exception {
        validaPiloto(piloto);
        return pilotoDAO.salvar(piloto);
    }

    public boolean deletarPiloto(Piloto piloto) throws Exception {
        validaPiloto(piloto);
        return pilotoDAO.deletar(piloto);
    }

    public boolean alterarPiloto(Piloto piloto) throws Exception {
        validaPiloto(piloto);
        return pilotoDAO.alterar(piloto);
    }

    public List<Piloto> listarPilotos() throws Exception {
        return pilotoDAO.listarTodos();
    }

    public Piloto getById(int id) throws Exception {
        validaId(id);
        return pilotoDAO.getById(id);
    }

    private void validaPiloto(Piloto piloto) throws Exception {
         if (piloto.getNome().equals("")) {
            throw new Exception("Nome do piloto não pode ficar em branco!");
        }
         if (piloto.getSenha().length() > 50) {
            throw new Exception("Senha maior do que o permitido");
        }
    }

    private void validaId(int id) throws Exception {
        if(id <= 0) {
            throw new Exception("Id do piloto não pode ser menor ou igual a 0");
        }
    }

}
