package controller;

import dao.UsuarioDAO;
import model.Usuario;

public class UsuarioController {

    private UsuarioDAO usuarioDAO;
    private Usuario usuario;

    public UsuarioController() {
        usuarioDAO = new UsuarioDAO();
        usuario = new Usuario();
    }

    public void localizarUsuario(Usuario usuario) {
        usuarioDAO.localizarUsuario(usuario);
    }

    public void criarUsuario(Usuario usuario) {
        usuarioDAO.criarUsuario(usuario);
    }

    public void deletarUsuario(Usuario usuario) {
        usuarioDAO.deletarUsuario(usuario);
    }

    public void alterarUsuario(Usuario usuario) {
        usuarioDAO.alterarUsuario(usuario);
    }

}