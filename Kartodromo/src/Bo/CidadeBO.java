package Bo;

import Dao.CidadeDAO;
import Model.Cidade;
import Model.Estado;

import java.util.List;

public class CidadeBO {

    private CidadeDAO cidadeDAO;

    public CidadeBO() {
    }

    public List<Cidade> listarCidadesPorEstado(Estado e) throws Exception {
        cidadeDAO = new CidadeDAO();
        return cidadeDAO.listarCidadesPorEstado(e);
    }

    public Cidade listarCidadePorNome(String n) throws Exception {
        if (n.equals("")) {
            throw new Exception("Selecione uma cidade!");
        } else {
            cidadeDAO = new CidadeDAO();
            return cidadeDAO.listarCidadePorNome(n);
        }
    }

}
