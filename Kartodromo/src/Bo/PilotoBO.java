package Bo;

import Dao.PilotoDAO;
import Model.Piloto;

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
        if (validaLoginPiloto(piloto)) {
            pilotoDAO = new PilotoDAO();
            // Verifica se a lista de piloto é vazia //
            if (!pilotoDAO.listarTodos(piloto).isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public Piloto getById(int id) throws Exception {
        validaIdPiloto(id);
        return pilotoDAO.getById(id);
    }

    private boolean validaPiloto(Piloto piloto) throws Exception {
         if (piloto.getNome().equals("")) {
            throw new Exception("Nome do piloto não pode ficar em branco!");
         } else if (piloto.getSenha().equals("")) {
             throw new Exception("Senha do piloto não pode ficar em branco!");
         } else if (piloto.getSenha().length() > 50) {
             throw new Exception("Senha maior do que o permitido");
         } else if (piloto.getEmail().equals("")) {
             throw new Exception("Email do usuário nao pode ser nulo!");
         } else {
             return true;
         }
    }

    private boolean validaLoginPiloto(Piloto piloto) throws Exception {
        if (piloto.getEmail().isEmpty()) {
            throw new Exception("Email em branco!");
        } else if (piloto.getSenha().isEmpty()) {
            throw new Exception("Senha em branco!");
        } else {
            return true;
        }
    }

    public boolean validaIdPiloto(int id) throws Exception {
        if (id <= 0) {
            throw new Exception("Id nulo");
        } else {
            return true;
        }
    }

}
