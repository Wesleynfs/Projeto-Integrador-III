package Bo;

import java.util.List;

public interface GenericBO<T> {

    boolean criar(T o) throws Exception;
    boolean deletar(T o) throws Exception;
    boolean alterar(T o) throws Exception;
    List<T> listarPorItem(T o) throws Exception;
    List<T> listarTodos() throws Exception;
    T logar(T o) throws Exception;
    T getById(int id) throws Exception;
    boolean valida(T o) throws Exception;
    boolean validaId(int id) throws Exception;
    boolean validaLogin(T o) throws Exception;

}
