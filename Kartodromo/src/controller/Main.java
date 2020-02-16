package controller;

import java.sql.ResultSetMetaData;

import dao.UsuarioDAO;
import model.Usuario;

public class Main {
    public static void main(String[] args) throws Exception {

        Usuario wesley = new Usuario(0,21,1170,"Wesley de Araujo","(41)9 9273-4129","Rua Malva","Araucária - PR","wesleynfs","123456");

        UsuarioDAO usuarioDAO = new UsuarioDAO();

        //usuarioDAO.CriarUsuario(wesley);

        //usuarioDAO.DeletarUsuario(wesley);

        //usuarioDAO.Update(wesley);
/*
        ResultSet rs = dataBase.Read("select * from usuarios", new Object[]{});

        while (rs.next()) {
            System.out.println(rs.getString("idade"));
        }
*/

    }
}