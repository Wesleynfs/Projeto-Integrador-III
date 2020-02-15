package dao;

import model.Usuario;

public class UsuarioDAO {

    private DataBase dataBase;
    private String sql;

    public UsuarioDAO() {
        dataBase = new DataBase();
    }

    public String CriarUsuario(Usuario usuario) {

        try {

            dataBase.connect();

            sql = "INSERT INTO usuarios (codigo,idade,numero,nome,telefone,rua,cidade)" 
            + " VALUES (?,?,?,?,?,?,?)";
            
            dataBase.Execute(sql, new Object[]{
                usuario.getCodigo(),
                usuario.getIdade(),
                usuario.getNumero(),
                usuario.getNome(),
                usuario.getTelefone(),
                usuario.getRua(),
                usuario.getCidade()
            });

            dataBase.disconnect();

            return "Usuário Gravado com sucesso!";

        } catch (Exception e) {
            return "Erro ao gravar usuário!";
        }

    };

    public void LocalizarUsuario() throws Exception {
        
    };

    public void Update() {

    };

    public String DeletarUsuario(Usuario usuario) {

        try {

            dataBase.connect();

            sql = "DELETE FROM usuarios WHERE codigo = ? and idade = ? and numero = ? and nome = ? and telefone = ? and rua = ? and cidade = ?;";
            
            dataBase.Execute(sql, new Object[]{
                usuario.getCodigo(),
                usuario.getNome(),
                usuario.getTelefone(),
                usuario.getRua(),
                usuario.getCidade(),
                usuario.getNumero()
            });

            dataBase.disconnect();

            return "Usuário apagado com sucesso!";

        } catch (Exception e) {
            return "Erro ao apagar usuário!";
        }

    };

}