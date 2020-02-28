package Dao;

import java.sql.ResultSet;

import Model.Usuario;

public class UsuarioDAO {

    private DataBase dataBase;
    private StringBuilder string;

    public UsuarioDAO() {
        dataBase = new DataBase();
        string = new StringBuilder();
    }

    public StringBuilder teste() {

        StringBuilder sb = new StringBuilder();
        try {
            dataBase.connect();

            string.append("select * from usuarios");

            ResultSet rs = dataBase.Read(string.toString(), new Object[]{});

            while (rs.next()) {
                sb.append(rs = dataBase.Read(string.toString(), new Object[]{}));
            }

            return sb;

        } catch (Exception e) {
            return null;
        }
    }

    public String criarUsuario(Usuario usuario) {

        try {

            dataBase.connect();

            string.append("INSERT INTO usuarios");
            string.append("(codigo,idade,numero,nome,telefone,rua,cidade,login,senha)");
            string.append("VALUES");
            string.append("(?,?,?,?,?,?,?,?,?);");

            if (dataBase.Execute(string.toString(), new Object[]{
                    usuario.getCodigo(),
                    usuario.getIdade(),
                    usuario.getNumero(),
                    usuario.getNome(),
                    usuario.getTelefone(),
                    usuario.getRua(),
                    usuario.getCidade(),
                    usuario.getLogin(),
                    usuario.getSenha()
            })) {
                return "Usuário Gravado com sucesso!";
            } else {
                return "Erro ao gravar usuário!";
            }

        } catch (Exception e) {
            return e.getMessage();
        } finally {
            dataBase.disconnect();
        }

    };

    public boolean localizarUsuario(Usuario usuario) {

        try {

            dataBase.connect();

            string.append(" SELECT * FROM usuarios ");
            string.append(" WHERE ");
            string.append(" codigo = ? ");
            string.append(" and idade = ? ");
            string.append(" and numero = ? ");
            string.append(" and nome = ? ");
            string.append(" and telefone = ? ");
            string.append(" and rua = ? ");
            string.append(" and cidade = ? ");
            string.append(" and login = ? ");
            string.append(" and senha = ? ;");

            ResultSet rs = dataBase.Read(string.toString(), new Object[]{
                    usuario.getCodigo(),
                    usuario.getIdade(),
                    usuario.getNumero(),
                    usuario.getNome(),
                    usuario.getTelefone(),
                    usuario.getRua(),
                    usuario.getCidade(),
                    usuario.getLogin(),
                    usuario.getSenha(),
            });

            return (rs.next());

        } catch (Exception e) {
            return true;
        } finally {
            dataBase.disconnect();
        }

    };

    public String alterarUsuario(Usuario usuario) {

        try {

            dataBase.connect();

            string.append(" UPDATE usuarios SET ");
            string.append(" idade = ?, ");
            string.append(" numero = ?, ");
            string.append(" nome = ?, ");
            string.append(" telefone = ?, ");
            string.append(" rua = ?, ");
            string.append(" cidade = ?, ");
            string.append(" login = ?, ");
            string.append(" senha = ? ");
            string.append(" WHERE ");
            string.append(" codigo = ? ");

            if (dataBase.Execute(string.toString(), new Object[]{

                    usuario.getIdade(),
                    usuario.getNumero(),
                    usuario.getNome(),
                    usuario.getTelefone(),
                    usuario.getRua(),
                    usuario.getCidade(),
                    usuario.getLogin(),
                    usuario.getSenha(),

                    usuario.getCodigo()

            })) {
                return "Usuário editado com sucesso!";
            } else {
                return "Erro ao editar dados do usuário";
            }

        } catch (Exception e) {
            return e.getMessage();
        } finally {
            dataBase.disconnect();
        }

    };

    public String deletarUsuario(Usuario usuario) {

        try {

            dataBase.connect();

            string.append("DELETE FROM usuarios WHERE ");
            string.append(" codigo = ? ");
            string.append(" and idade = ? ");
            string.append(" and numero = ? ");
            string.append(" and nome = ? ");
            string.append(" and telefone = ? ");
            string.append(" and rua = ? ");
            string.append(" and cidade = ? ");
            string.append(" and login = ? ");
            string.append(" and senha = ? ;");

            if (dataBase.Execute(string.toString(), new Object[]{
                    usuario.getCodigo(),
                    usuario.getIdade(),
                    usuario.getNumero(),
                    usuario.getNome(),
                    usuario.getTelefone(),
                    usuario.getRua(),
                    usuario.getCidade(),
                    usuario.getLogin(),
                    usuario.getSenha(),
            })) {
                return "Usuário apagado com sucesso!";
            } else {
                return "Erro ao apagar usuário!";
            }

        } catch (Exception e) {
            return e.getMessage();
        } finally {
            dataBase.disconnect();
        }

    };

}