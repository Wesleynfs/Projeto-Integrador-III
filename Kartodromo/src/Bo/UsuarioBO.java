package Bo;

import Dao.UsuarioDAO;
import Model.Usuario;

public class UsuarioBO {

    private UsuarioDAO usuarioDAO;

    public UsuarioBO() {
        usuarioDAO = new UsuarioDAO();
    }

    public boolean usuarioExiste(Usuario usuario) throws Exception {
        validaUsuario(usuario);
        return usuarioDAO.usuarioExiste(usuario);
    }

    public Usuario recuperarUsuario(Usuario usuario) throws Exception {
        validaUsuario(usuario);
        return usuarioDAO.recuperarUsuario(usuario);
    }

    public boolean criarUsuario(Usuario usuario) throws Exception {
        validaUsuario(usuario);
        return usuarioDAO.criarUsuario(usuario);
    }

    public boolean deletarUsuario(Usuario usuario) throws Exception {
        validaUsuario(usuario);
        return usuarioDAO.deletarUsuario(usuario);
    }

    public boolean alterarUsuario(Usuario usuario) throws Exception {
        validaUsuario(usuario);
        return usuarioDAO.alterarUsuario(usuario);
    }

    private void validaUsuario(Usuario usuario) throws Exception {
        if(usuario.getId_usuario() < 0) {
            throw new Exception("Id do usuário não pode ser negativo");
        } else if (usuario.getNome().equals("")) {
            throw new Exception("Nome do usuário não pode ficar em branco!");
        } else if (usuario.getSenha().length() > 50) {
            throw new Exception("Número de caracteres maior do que o permitido");
        }
    }

}
