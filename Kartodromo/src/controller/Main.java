package controller;

import dao.UsuarioDAO;
import model.Usuario;

public class Main {
    public static void main(String[] args) throws Exception {

        Usuario wesley = new Usuario(0,22,1170,"Wesley de Araujo","(41)9 9999-9999","Rua Malva","Araucária - PR","wesleyLogin","123456");

        UsuarioDAO usuarioDAO = new UsuarioDAO();

        //usuarioDAO.criarUsuario(wesley);

        //usuarioDAO.localizarUsuario(wesley)   //  Retorna true se achar o usuário

        //usuarioDAO.alterarUsuario(wesley);

        //usuarioDAO.deletarUsuario(wesley);

    }
}