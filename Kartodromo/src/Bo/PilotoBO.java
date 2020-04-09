package Bo;

import Dao.PilotoDAO;
import Model.Piloto;

import javax.swing.*;
import java.util.List;

public class PilotoBO {

    private PilotoDAO pilotoDAO;

    public PilotoBO() {

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

    public boolean logarPiloto(Piloto piloto) throws Exception {
        if (validaPiloto(piloto)) {
            pilotoDAO = new PilotoDAO();
            List<Piloto> pilotos = pilotoDAO.listarTodos();
            for(Piloto pi : pilotos) {
                if (pi.getNome().equals(piloto.getNome()) && pi.getSenha().equals(piloto.getSenha())) {
                    return true;
                }
            }
        }
        return false;
    }

    public Piloto getById(int id) throws Exception {
        validaId(id);
        return pilotoDAO.getById(id);
    }

    private boolean validaPiloto(Piloto piloto) throws Exception {
         if (piloto.getNome().equals("")) {
            throw new Exception("Nome do piloto não pode ficar em branco!");
         } else if (piloto.getSenha().equals("")) {
             throw new Exception("Senha do piloto não pode ficar em branco!");
         } else if (piloto.getSenha().length() > 50) {
             throw new Exception("Senha maior do que o permitido");
         } else {
             return true;
         }
    }

    private void validaId(int id) throws Exception {
        if(id <= 0) {
            throw new Exception("Id do piloto não pode ser menor ou igual a 0");
        }
    }

}
