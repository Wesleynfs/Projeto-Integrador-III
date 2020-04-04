package Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Kartodromo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_kartodromo;
    private String nome;
    private String diasInativo;
    private String endereco;
    private String senha;
    private String login;
    private String email;

    public int getId_kartodromo() {
        return id_kartodromo;
    }

    public void setId_kartodromo(int id_kartodromo) {
        this.id_kartodromo = id_kartodromo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDiasInativo() {
        return diasInativo;
    }

    public void setDiasInativo(String diasInativo) {
        this.diasInativo = diasInativo;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Kartodromo(int id_kartodromo, String nome, String diasInativo, String endereco, String senha, String login, String email) {
        this.id_kartodromo = id_kartodromo;
        this.nome = nome;
        this.diasInativo = diasInativo;
        this.endereco = endereco;
        this.senha = senha;
        this.login = login;
        this.email = email;
    }

    public Kartodromo() {

    }

    @Override
    public String toString() {
        return "Kartodromo{" +
                "id_kartodromo=" + id_kartodromo +
                ", nome='" + nome + '\'' +
                ", diasInativo='" + diasInativo + '\'' +
                ", endereco='" + endereco + '\'' +
                ", senha='" + senha + '\'' +
                ", login='" + login + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
