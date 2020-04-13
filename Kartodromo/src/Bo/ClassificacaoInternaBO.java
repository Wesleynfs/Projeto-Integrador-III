package Bo;

import Dao.ClassificacaoInternaDAO;
import Model.ClassificacaoInterna;
import Model.Piloto;

import java.util.List;

public class ClassificacaoInternaBO {

    private ClassificacaoInternaDAO classificacaoInternaDAO;

    public ClassificacaoInternaBO() {

    }

    public boolean criarClassificacaoInterna(ClassificacaoInterna classificacaoInterna) throws Exception {
        if (validaClassificacaoInterna(classificacaoInterna)) {
            classificacaoInternaDAO = new ClassificacaoInternaDAO();
            return classificacaoInternaDAO.salvar(classificacaoInterna);
        }
        return false;
    }

    public boolean deletarPiloto(ClassificacaoInterna classificacaoInterna) throws Exception {
        if (validaClassificacaoInterna(classificacaoInterna)) {
            classificacaoInternaDAO = new ClassificacaoInternaDAO();
            return classificacaoInternaDAO.deletar(classificacaoInterna);
        }
        return false;
    }

    public boolean alterarPiloto(ClassificacaoInterna classificacaoInterna) throws Exception {
        if (validaClassificacaoInterna(classificacaoInterna)) {
            classificacaoInternaDAO = new ClassificacaoInternaDAO();
            return classificacaoInternaDAO.alterar(classificacaoInterna);
        }
        return false;
    }

    public List<ClassificacaoInterna> listarPilotos() throws Exception {
        return classificacaoInternaDAO.listarTodos();
    }

    public ClassificacaoInterna getById(int id) throws Exception {
        if (validaId(id)) {
            classificacaoInternaDAO = new ClassificacaoInternaDAO();
            return classificacaoInternaDAO.getById(id);
        }
        return null;
    }

    private boolean validaClassificacaoInterna(ClassificacaoInterna classificacaoInterna) throws Exception {
        if (classificacaoInterna.getPiloto() == null) {
            throw new Exception("O Piloto da classificacao interna não pode ser nulo!");
        }
        if (classificacaoInterna.getKartodromo() == null) {
            throw new Exception("O kartodromo da classificacao interna não pode ser nulo!");
        }
        return true;
    }

    private boolean validaId(int id) throws Exception {
        if(id <= 0) {
            throw new Exception("Id da classificacao interna não pode ser menor ou igual a 0");
        }
        return true;
    }

}
