package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.Endereco;
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

    public boolean criarUsuario(Usuario usuario) throws Exception {

        try {

            postgres.connect();

            string.append("INSERT INTO usuario ");
            string.append("(id_usuario,nome,email,senha,id_endereco,ativo)");
            string.append("VALUES");
            string.append("(?,?,?,?,?,TRUE)");

            if (postgres.Execute(string.toString(), new Object[]{
                    usuario.getId_usuario(),
                    usuario.getNome(),
                    usuario.getEmail(),
                    usuario.getSenha(),
                    usuario.getEndereco().getId_endereco()
            })) {
                return true;
            } else {
                throw new Exception("Usuario não gravado no banco!");
            }

        } catch (Exception e) {
            throw new Exception("Erro ao criar usuario [" + usuario.getNome() +"]");
        } finally {
            postgres.disconnect();
        }

    }

    public Usuario recuperarUsuario(Usuario usuario) throws Exception {

        try {

            postgres.connect();

            string.append(" SELECT * FROM usuario ");
            string.append(" LEFT OUTER JOIN endereco ");
            string.append(" on usuario.id_usuario = endereco.id_endereco ");
            string.append(" WHERE ");
            string.append(" id_usuario = ? ");
            string.append(" and nome = ? ");
            string.append(" and email = ? ");
            string.append(" and senha = ? ;");

            ResultSet rs = postgres.Read(string.toString(), new Object[]{
                    usuario.getId_usuario(),
                    usuario.getNome(),
                    usuario.getEmail(),
                    usuario.getSenha(),
            });

            if (rs.next()) {
                Endereco novoEndereco = new Endereco();
                novoEndereco.setId_endereco(rs.getInt("id_endereco"));
                novoEndereco.setTelefone(rs.getString("telefone"));
                novoEndereco.setCep(rs.getString("cep"));
                novoEndereco.setRua(rs.getString("rua"));
                novoEndereco.setBairro(rs.getString("bairro"));
                novoEndereco.setCidade(rs.getString("cidade"));

                Usuario novoUsuario = new Usuario();
                novoUsuario.setId_usuario(rs.getInt("id_usuario"));
                novoUsuario.setNome(rs.getString("nome"));
                novoUsuario.setEndereco(novoEndereco);
                novoUsuario.setEmail(rs.getString("email"));
                novoUsuario.setSenha(rs.getString("senha"));
                return novoUsuario;
            } else {
                return null;
            }

        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        } finally {
            postgres.disconnect();
        }

    }

    public boolean usuarioExiste(Usuario usuario) throws Exception {
        try {

            postgres.connect();

            string.append("SELECT * FROM usuario ");
            string.append(" WHERE ");
            string.append("(id_usuario = ?)");

            ResultSet rs = postgres.Read(string.toString(),new Object[]{
                    usuario.getId_usuario()
            });

            if (rs.next()) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            throw new Exception("Erro ao visualizar se usuário existe!");
        } finally {
            postgres.disconnect();
        }
    }

    public boolean alterarUsuario(Usuario usuario) throws Exception {

        try {

            postgres.connect();

            string.append(" UPDATE usuario SET ");
            string.append(" nome = ?, ");
            string.append(" email = ?, ");
            string.append(" senha = ?, ");
            string.append(" ativo = ? ");
            string.append(" WHERE ");
            string.append(" id_usuario = ? ");

            if (postgres.Execute(string.toString(), new Object[]{

                    usuario.getNome(),
                    usuario.getEmail(),
                    usuario.getSenha(),
                    usuario.isAtivo(),

                    usuario.getId_usuario()

            })) {
                return true;
            } else {
                throw new Exception("Erro ao editar dados do usuário");
            }

        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        } finally {
            postgres.disconnect();
        }

    };

    public boolean deletarUsuario(Usuario usuario) throws Exception {

        try {

            postgres.connect();

            string.append(" UPDATE usuario SET ativo = FALSE WHERE ");
            string.append(" id_usuario = ? ");
            string.append(" and nome = ? ");
            string.append(" and email = ? ");
            string.append(" and senha = ? ;");

            if (postgres.Execute(string.toString(), new Object[]{
                    usuario.getId_usuario(),
                    usuario.getNome(),
                    usuario.getEmail(),
                    usuario.getSenha(),
            })) {
                return true;
            } else {
                throw new Exception("Erro ao deletar usuário");
            }

        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        } finally {
            postgres.disconnect();
        }

    }

}