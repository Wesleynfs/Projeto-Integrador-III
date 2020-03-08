package Model;

public class Usuario {

    // Variaveis //

    private int id;
    private int idade;
    private String nome;
    private String telefone;
    private String Endereco;
    private String cidade;
    private String login;
    private String senha;

    // Gets e Sets //

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getId() {
        return id;
    }

    public void setId(int codigo) {
        this.id = codigo;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return Endereco;
    }

    public void setEndereco(String endereco) {
        this.Endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    // Construtores //

    public Usuario() {

    }

    public Usuario(int id,int idade,int numero,String nome,String telefone,String rua,String cidade,String login,String senha) {
        this.id = id;
        this.idade = idade;
        this.nome = nome;
        this.telefone = telefone;
        this.Endereco = rua;
        this.cidade = cidade;
        this.login = login;
        this.senha = senha;
    }

    // Metodos //

    public String toString() {
        return this.getNome() +
                ";" + this.getIdade() + ";" + this.getTelefone() + ";" + this.getEndereco() +
                ";" + this.getCidade() + ";" + this.getLogin() + ";" + this.getSenha();
    }

}