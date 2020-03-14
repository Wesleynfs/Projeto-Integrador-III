package Model;

public class Usuario {

    // Variaveis //

    private int id_usuario;
    private Endereco endereco;
    private String nome;
    private String email;
    private String senha;
    private boolean isAtivo;

    // Gets e Sets //

    public boolean isAtivo() { return isAtivo; }

    public void setAtivo(boolean ativo) { isAtivo = ativo; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getNome() { return nome; }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int codigo) {
        this.id_usuario = codigo;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    // Construtores //

    public Usuario(int id_usuario, String nome, Endereco endereco, String senha, String email) {
        this.id_usuario = id_usuario;
        this.nome = nome;
        this.endereco = endereco;
        this.email = email;
        this.senha = senha;
    }

    public Usuario() {

    }

    // Metodos //


    @Override
    public String toString() {
        return "Usuario{" +
            "id =" + id_usuario +
            ", nome ='" + nome + '\'' +
            ", endereco =" + endereco +
            ", email ='" + email + '\'' +
            ", senha ='" + senha + '\'' +
            '}';
    }
}