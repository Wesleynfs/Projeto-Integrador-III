package Bo;

import Dao.UsuarioDAO;
import Model.Usuario;

public class UsuarioBO {

    private UsuarioDAO usuarioDAO;

    public UsuarioBO() {
        usuarioDAO = new UsuarioDAO();
    }

    public void criarUsuario(Usuario usuario) throws Exception {
        validaUsuario(usuario);
        usuarioDAO.criarUsuario(usuario);
    }

    public void deletarUsuario(Usuario usuario) throws Exception {
        validaUsuario(usuario);
        usuarioDAO.deletarUsuario(usuario);
    }

    public void alterarUsuario(Usuario usuario) throws Exception {
        validaUsuario(usuario);
        usuarioDAO.alterarUsuario(usuario);
    }

    private void validaUsuario(Usuario usuario) throws Exception {
        if(usuario.getId() < 0) {
            throw new Exception("Id do usuário não pode ser negativo");
        } else if (usuario.getNome().equals("")) {
            throw new Exception("Nome do usuário não pode ficar em branco!");
        } else if (usuario.getSenha().length() > 50) {
            throw new Exception("Número de caracteres maior do que o permitido");
        }
    }

}
