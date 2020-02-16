package dao;

import java.sql.ResultSet;

import model.Usuario;

public class UsuarioDAO {

    private DataBase dataBase;
    private StringBuilder stringBuilder;

    public UsuarioDAO() {
        dataBase = new DataBase();
        stringBuilder = new StringBuilder();
    }

    public String CriarUsuario(Usuario usuario) {

        try {

            dataBase.connect();

            stringBuilder.append("INSERT INTO usuarios");
            stringBuilder.append("(codigo,idade,numero,nome,telefone,rua,cidade,login,senha)");
            stringBuilder.append("VALUES");
            stringBuilder.append("(?,?,?,?,?,?,?,?,?);");

            dataBase.Execute(stringBuilder.toString(), new Object[]{
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

            dataBase.disconnect();

            return "Usuário Gravado com sucesso!";

        } catch (Exception e) {
            return "Erro ao gravar usuário!";
        }

    };

    public void localizaUsuario(Usuario usuario) {

    };

    public void Update() {

    };

    public String DeletarUsuario(Usuario usuario) {

        try {

            dataBase.connect();

            stringBuilder.append("DELETE FROM usuarios WHERE ");
            stringBuilder.append(" codigo = ? ");
            stringBuilder.append(" and idade = ? ");
            stringBuilder.append(" and numero = ? ");
            stringBuilder.append(" and nome = ? ");
            stringBuilder.append(" and telefone = ? ");
            stringBuilder.append(" and rua = ? ");
            stringBuilder.append(" and cidade = ? ");
            stringBuilder.append(" and login = ? ");
            stringBuilder.append(" and senha = ? ;");
            
            dataBase.Execute(stringBuilder.toString(), new Object[]{
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

            dataBase.disconnect();

            return "Usuário apagado com sucesso!";

        } catch (Exception e) {
            return "Erro ao apagar usuário!";
        }

    };

}