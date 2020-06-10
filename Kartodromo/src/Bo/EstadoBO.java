package Bo;

import Dao.EstadoDAO;
import Model.Estado;

import java.util.List;

public class EstadoBO{

    private EstadoDAO estadoDAO;

    public EstadoBO() {

    }

    public Estado listarEstadoPorNome(String n) throws Exception {
        estadoDAO = new EstadoDAO();
        return estadoDAO.listarEstadoPorNome(n);
    }

    public List<Estado> listarTodos() throws Exception {
        estadoDAO = new EstadoDAO();
        return estadoDAO.listarTodos();
    }

}
