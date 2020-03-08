package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.Usuario;

public class UsuarioDAO {

    private Postgres postgres;
    private StringBuilder string;
    private Connection connection;

    public UsuarioDAO() {
        postgres = new Postgres();
        string = new StringBuilder();
        connection = null;
    }

    public String criarUsuario(Usuario usuario) throws Exception {

        try {

            postgres.connect();

            string.append("INSERT INTO usuarios");
            string.append("(id,nome,idade,telefone,endereco,cidade,login,senha)");
            string.append("VALUES");
            string.append("(default,?,?,?,?,?,?,?);");

            if (postgres.Execute(string.toString(), new Object[]{
                    usuario.getNome(),
                    usuario.getIdade(),
                    usuario.getTelefone(),
                    usuario.getEndereco(),
                    usuario.getCidade(),
                    usuario.getLogin(),
                    usuario.getSenha()
            })) {
                return "Usuário Gravado com sucesso!";
            } else {
                throw new Exception("Erro ao gravar usuário!");
            }

        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        } finally {
            postgres.disconnect();
        }

    };

    public int getIdUsuario(Usuario usuario) throws Exception {
        try {

            postgres.connect();

            string.append("SELECT ID FROM usuarios WHERE");
            string.append(" nome = ? ");
            string.append(" and idade = ? ");
            string.append(" and telefone = ? ");
            string.append(" and endereco = ? ");
            string.append(" and cidade = ? ");
            string.append(" and login = ? ");
            string.append(" and senha = ? ;");

            ResultSet rs = postgres.Read(string.toString(), new Object[]{
                    usuario.getNome(),
                    usuario.getIdade(),
                    usuario.getTelefone(),
                    usuario.getEndereco(),
                    usuario.getCidade(),
                    usuario.getLogin(),
                    usuario.getSenha(),
            });

            int id = -1;

            while (rs.next()) {
                id = rs.getInt("id");
            }

            return id;

        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        }
    }

    public boolean localizarUsuario(Usuario usuario) throws Exception {

        try {

            postgres.connect();

            string.append(" SELECT * FROM usuarios ");
            string.append(" WHERE ");
            string.append(" id = ? ");
            string.append(" and nome = ? ");
            string.append(" and idade = ? ");
            string.append(" and telefone = ? ");
            string.append(" and endereco = ? ");
            string.append(" and cidade = ? ");
            string.append(" and login = ? ");
            string.append(" and senha = ? ;");

            ResultSet rs = postgres.Read(string.toString(), new Object[]{
                    usuario.getId(),
                    usuario.getNome(),
                    usuario.getIdade(),
                    usuario.getTelefone(),
                    usuario.getEndereco(),
                    usuario.getCidade(),
                    usuario.getLogin(),
                    usuario.getSenha(),
            });

            return (rs.next());

        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        } finally {
            postgres.disconnect();
        }

    };

    public String alterarUsuario(Usuario usuario) throws Exception {

        try {

            postgres.connect();

            string.append(" UPDATE usuarios SET ");
            string.append(" nome = ?, ");
            string.append(" idade = ?, ");
            string.append(" telefone = ?, ");
            string.append(" endereco = ?, ");
            string.append(" cidade = ?, ");
            string.append(" login = ?, ");
            string.append(" senha = ? ");
            string.append(" WHERE ");
            string.append(" id = ? ");

            if (postgres.Execute(string.toString(), new Object[]{

                    usuario.getNome(),
                    usuario.getIdade(),
                    usuario.getTelefone(),
                    usuario.getEndereco(),
                    usuario.getCidade(),
                    usuario.getLogin(),
                    usuario.getSenha(),

                    usuario.getId()

            })) {
                return "Usuário editado com sucesso!";
            } else {
                throw new Exception("Erro ao editar dados do usuário");
            }

        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        } finally {
            postgres.disconnect();
        }

    };

    public String deletarUsuario(Usuario usuario) throws Exception {

        try {

            postgres.connect();

            string.append("DELETE FROM usuarios WHERE ");
            //string.append(" id = ? ");
            string.append(" nome = ? ");
            string.append(" and idade = ? ");
            string.append(" and telefone = ? ");
            string.append(" and endereco = ? ");
            string.append(" and cidade = ? ");
            string.append(" and login = ? ");
            string.append(" and senha = ? ;");

            if (postgres.Execute(string.toString(), new Object[]{
                    //usuario.getId(),
                    usuario.getNome(),
                    usuario.getIdade(),
                    usuario.getTelefone(),
                    usuario.getEndereco(),
                    usuario.getCidade(),
                    usuario.getLogin(),
                    usuario.getSenha(),
            })) {
                return "Usuário apagado com sucesso!";
            } else {
                throw new Exception("Erro ao deletar usuário");
            }

        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        } finally {
            postgres.disconnect();
        }

    };

}