package Model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Piloto {

    // Variaveis //
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPiloto;
    private String cpf;
    private String nome;
    private String senha;
    private String email;
    private int numeroStrikes;
    private int numeroVitorias;
    private String dataNascimento;
    private char ativo;

    @ManyToMany
    @JoinTable(name = "piloto_campeonato",
            joinColumns = @JoinColumn(name = "idpiloto"),
            inverseJoinColumns = @JoinColumn(name = "idcampeonato"))
    private List<Campeonato> campeonatos;

    // Gets and Sets //

    public List<Campeonato> getCampeonatos() { return campeonatos; }

    public void setCampeonatos(List<Campeonato> campeonatos) { this.campeonatos = campeonatos; }

    public String getCpf() { return cpf; }

    public void setCpf(String cpf) { this.cpf = cpf; }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() { return senha; }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() { return email; }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNumeroStrikes() {
        return numeroStrikes;
    }

    public void setNumeroStrikes(int numeroStrikes) {
        this.numeroStrikes = numeroStrikes;
    }

    public int getNumeroVitorias() {
        return numeroVitorias;
    }

    public void setNumeroVitorias(int numeroVitorias) {
        this.numeroVitorias = numeroVitorias;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public char getAtivo() {
        return ativo;
    }

    public void setAtivo(char ativo) {
        this.ativo = ativo;
    }

    public int getIdPiloto() {
        return idPiloto;
    }

    public void setIdPiloto(int idPiloto) {
        this.idPiloto = idPiloto;
    }

    public Piloto(int idPiloto, String cpf, String nome, String senha, String email, int numeroStrikes, int numeroVitorias, String dataNascimento, char ativo) {
        this.idPiloto = idPiloto;
        this.cpf = cpf;
        this.nome = nome;
        this.senha = senha;
        this.email = email;
        this.numeroStrikes = numeroStrikes;
        this.numeroVitorias = numeroVitorias;
        this.dataNascimento = dataNascimento;
        this.ativo = ativo;
    }

    public Piloto() {

    }

    @Override
    public String toString() {
        return "Piloto{" +
                "idPiloto=" + idPiloto +
                ", cpf='" + cpf + '\'' +
                ", nome='" + nome + '\'' +
                ", senha='" + senha + '\'' +
                ", email='" + email + '\'' +
                ", numeroStrikes=" + numeroStrikes +
                ", numeroVitorias=" + numeroVitorias +
                ", dataNascimento='" + dataNascimento + '\'' +
                ", ativo=" + ativo +
                '}';
    }
}