package model;

public class Usuario {

    // Variaveis //

    private int codigo;
    private int idade;
    private int numero;
    private String nome;
    private String telefone;
    private String rua;
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

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
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

    public Usuario(int codigo,int idade,int numero,String nome,String telefone,String rua,String cidade,String login,String senha) {
        this.codigo = codigo;
        this.idade = idade;
        this.nome = nome;
        this.telefone = telefone;
        this.rua = rua;
        this.cidade = cidade;
        this.numero = numero;
        this.login = login;
        this.senha = senha;
    }

    // Metodos //

}