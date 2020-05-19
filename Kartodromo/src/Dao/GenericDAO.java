package Dao;

import java.util.List;

public interface GenericDAO<T> {

    boolean salvar(T o) throws Exception;
    boolean ler(T o) throws Exception;
    boolean alterar(T o) throws Exception;
    boolean deletar(T o) throws Exception;
    List<T> listarTodos(T o) throws Exception;
    List<T> listarTodos() throws Exception;
    T getById(int id) throws Exception;

}
