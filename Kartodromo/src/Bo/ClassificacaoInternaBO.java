package Bo;

import Dao.ClassificacaoInternaDAO;
import Model.ClassificacaoInterna;
import Model.Piloto;

import java.util.List;

public class ClassificacaoInternaBO {

    private ClassificacaoInternaDAO classificacaoInternaDAO;

    public ClassificacaoInternaBO() {
        classificacaoInternaDAO = new ClassificacaoInternaDAO();
    }

    public boolean criarClassificacaoInterna(ClassificacaoInterna classificacaoInterna) throws Exception {
        validaClassificacaoInterna(classificacaoInterna);
        return classificacaoInternaDAO.salvar(classificacaoInterna);
    }

    public boolean deletarPiloto(ClassificacaoInterna classificacaoInterna) throws Exception {
        validaClassificacaoInterna(classificacaoInterna);
        return classificacaoInternaDAO.deletar(classificacaoInterna);
    }

    public boolean alterarPiloto(ClassificacaoInterna classificacaoInterna) throws Exception {
        validaClassificacaoInterna(classificacaoInterna);
        return classificacaoInternaDAO.alterar(classificacaoInterna);
    }

    public List<ClassificacaoInterna> listarPilotos() throws Exception {
        return classificacaoInternaDAO.listarTodos();
    }

    public ClassificacaoInterna getById(int id) throws Exception {
        validaId(id);
        return classificacaoInternaDAO.getById(id);
    }

    private void validaClassificacaoInterna(ClassificacaoInterna classificacaoInterna) throws Exception {
        if (classificacaoInterna.getPiloto() == null) {
            throw new Exception("O Piloto da classificacao interna não pode ser nulo!");
        }
        if (classificacaoInterna.getKartodromo() == null) {
            throw new Exception("O kartodromo da classificacao interna não pode ser nulo!");
        }
    }

    private void validaId(int id) throws Exception {
        if(id <= 0) {
            throw new Exception("Id da classificacao interna não pode ser menor ou igual a 0");
        }
    }

}
