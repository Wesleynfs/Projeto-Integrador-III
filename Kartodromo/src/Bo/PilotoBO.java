package Bo;

import Dao.PilotoDAO;
import Model.Piloto;

import java.sql.Date;
import java.util.List;

public class PilotoBO implements GenericBO<Piloto>{

    private PilotoDAO pilotoDAO;

    public PilotoBO() {

    }

    @Override
    public boolean criar(Piloto o) throws Exception {
        if (valida(o)) {
            if (verificarApelido(o)) {
                pilotoDAO = new PilotoDAO();
                return pilotoDAO.salvar(o);
            }
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
    public Piloto getById(int id) throws Exception {
        if (validaId(id)) {
            pilotoDAO = new PilotoDAO();
            return pilotoDAO.getById(id);
        }
        return null;
    }

    @Override
    public boolean valida(Piloto o) throws Exception {

        // Validações de nome //
        if (o.getNomePiloto().equals("")) {
            throw new Exception("Nome do piloto não pode ficar em branco!");
        }
        if (o.getNomePiloto().length() > 50) {
            throw new Exception("Nome Grande de mais! coloque um nome menor");
        }
        if (!ValidarString.isApenasLetras(o.getNomePiloto())) {
            throw new Exception("Nome do piloto inválido, apenas letras são válidas");
        }
        // Validações de senha //
        if (o.getSenhaPiloto().equals("")) {
            throw new Exception("Senha do piloto não pode ficar em branco!");
        }
        // Validações de apelido //
        if (o.getApelido().equals("")) {
            throw new Exception("Apelido do piloto não pode ficar em branco!");
        }
        // Validações de email //
        if (o.getEmailPiloto().equals("")) {
            throw new Exception("Email do piloto nao pode ser nulo!");
        }
        if (!ValidarString.isEmail(o.getEmailPiloto())) {
            throw new Exception("Email do piloto inválido!");
        }
        // Validações de data //
        if (o.getDataNascimentoPiloto().toString().equals("  /  /     ")) {
            throw new Exception("Data do piloto não pode ficar em branco!");
        }
        if (!ValidarString.isDataPadraoEUA(o.getDataNascimentoPiloto().toString())) {
            throw new Exception("Data do piloto deve possuir os 4 digitos do ano, verifique-a novamente!");
        }
        if (!o.getDataNascimentoPiloto().before(new Date(System.currentTimeMillis()))) {
            throw new Exception("Data do piloto não pode ser após a data em que você está agora!");
        }
        // Validações de CPF //
        if (o.getCpfPiloto().equals("   .   .   -  ")) {
            throw new Exception("Cpf do piloto não pode ficar em branco!");
        }
        if (!ValidaCPF.isCPF(o.getCpfPiloto())) {
            throw new Exception("CPF do piloto inválido!");
        }
        return true;
    }

    @Override
    public boolean validaId(int id) throws Exception {
        if (id <= 0) {
            throw new Exception("Id nulo");
        } else {
            return true;
        }
    }
    
    public Piloto listarporapelido(String apelido) throws Exception{
        pilotoDAO = new PilotoDAO();
        return pilotoDAO.listarporapelido(apelido);
    }
        
    public boolean validaLogin(Piloto o) throws Exception {
        if (o.getEmailPiloto().isEmpty()) {
            throw new Exception("Email em branco!");
        } else if (o.getSenhaPiloto().isEmpty()) {
            throw new Exception("Senha em branco!");
        } else {
            return true;
        }
    }

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

    private boolean verificarApelido(Piloto piloto) throws Exception{
        pilotoDAO = new PilotoDAO();
        if (pilotoDAO.VerificarApelidoExistente(piloto.getApelido())) {
            throw new Exception("Este Apelido já existe, por favor tente outro!");
        }
        return true;
    }

}
