package Bo;

import Dao.PilotoDAO;
import Model.Piloto;
import java.util.List;

public class PilotoBO implements GenericBO<Piloto>{

    private PilotoDAO pilotoDAO;

    public PilotoBO() {

    }

    @Override
    public boolean criar(Piloto o) throws Exception {
        if (valida(o)) {
            pilotoDAO = new PilotoDAO();
            return pilotoDAO.salvar(o);
        }
        return false;
    }

    @Override
    public boolean deletar(Piloto o) throws Exception {
        if (valida(o)) {
            pilotoDAO = new PilotoDAO();
            return pilotoDAO.deletar(o);
        }
        return false;
    }

    @Override
    public boolean alterar(Piloto o) throws Exception {
        if (valida(o)) {
            pilotoDAO = new PilotoDAO();
            return pilotoDAO.alterar(o);
        }
        return false;
    }

    @Override
    public List<Piloto> listarPorItem(Piloto o) throws Exception {
        return null;
    }

    @Override
    public List<Piloto> listarTodos() throws Exception {
        pilotoDAO = new PilotoDAO();
        return pilotoDAO.listarTodos();
    }

    @Override
    public Piloto logar(Piloto o) throws Exception {
        if (validaLogin(o)) {
            List<Piloto> list = new PilotoDAO().listarTodos(o);
            if (list.size() > 0) {
                return list.get(0);
            } else {
                throw new Exception("Piloto não encontrado!");
            }
        } else {
            throw new Exception("Piloto não validado!");
        }
    }

    @Override
    public Piloto getById(int id) throws Exception {
        if (validaId(id)) {
            pilotoDAO = new PilotoDAO();
            return pilotoDAO.getById(id);
        }
        return null;
    }

    @Override
    public boolean valida(Piloto o) throws Exception {
        if (o.getNomePiloto().equals("")) {
            throw new Exception("Nome do piloto não pode ficar em branco!");
        } else if (o.getSenhaPiloto().equals("")) {
            throw new Exception("Senha do piloto não pode ficar em branco!");
        } else if (o.getSenhaPiloto().length() > 50) {
            throw new Exception("Senha maior do que o permitido");
        } else if (o.getEmailPiloto().equals("")) {
            throw new Exception("Email do piloto nao pode ser nulo!");
        } else if (o.getCpfPiloto().equals("   .   .   -  ")) {
            throw new Exception("Cpf do piloto não pode ficar em branco!");
        } else if (o.getDataNascimentoPiloto().equals("  /  /     ")) {
            throw new Exception("Data do piloto não pode ficar em branco!");
        } else  {
            return true;
        }
    }

    @Override
    public boolean validaId(int id) throws Exception {
        if (id <= 0) {
            throw new Exception("Id nulo");
        } else {
            return true;
        }
    }

    @Override
    public boolean validaLogin(Piloto o) throws Exception {
        if (o.getEmailPiloto().isEmpty()) {
            throw new Exception("Email em branco!");
        } else if (o.getSenhaPiloto().isEmpty()) {
            throw new Exception("Senha em branco!");
        } else {
            return true;
        }
    }

}
