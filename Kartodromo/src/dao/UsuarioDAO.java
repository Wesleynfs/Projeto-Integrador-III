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

            sql = "insert into clientes (codigo,nome,telefone,rua,cidade,numero) values (?,?,?,?,?,?)";
            
            dataBase.Execute(sql, new Object[]{
                usuario.getCodigo(),
                usuario.getNome(),
                usuario.getTelefone(),
                usuario.getRua(),
                usuario.getCidade(),
                usuario.getNumero()
            });

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

            sql = "delete from clientes where codigo = '?' and nome = '?' and telefone = '?' and rua = '?' and cidade = '?' and numero = '?'";
            
            dataBase.Execute(sql, new Object[]{
                usuario.getCodigo(),
                usuario.getNome(),
                usuario.getTelefone(),
                usuario.getRua(),
                usuario.getCidade(),
                usuario.getNumero()
            });

            return "Usuário apagado com sucesso!";

        } catch (Exception e) {
            return "Erro ao apagar usuário!";
        }

    };

}