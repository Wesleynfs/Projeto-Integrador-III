package Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Piloto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPiloto;
    private String nomePiloto;
    private String apelido;
    private String senhaPiloto;
    private String cpfPiloto;
    private String emailPiloto;
    private int numeroDeStrikesPiloto;
    private int numeroDeVitoriasPiloto;
    private String dataNascimentoPiloto;
    private boolean ativo;

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }
    
    public int getIdPiloto() {
        return idPiloto;
    }

    public void setIdPiloto(int idPiloto) {
        this.idPiloto = idPiloto;
    }

    public String getNomePiloto() {
        return nomePiloto;
    }

    public void setNomePiloto(String nomePiloto) {
        this.nomePiloto = nomePiloto;
    }

    public String getSenhaPiloto() {
        return senhaPiloto;
    }

    public void setSenhaPiloto(String senhaPiloto) {
        this.senhaPiloto = senhaPiloto;
    }

    public String getCpfPiloto() {
        return cpfPiloto;
    }

    public void setCpfPiloto(String cpfPiloto) {
        this.cpfPiloto = cpfPiloto;
    }

    public String getEmailPiloto() {
        return emailPiloto;
    }

    public void setEmailPiloto(String emailPiloto) {
        this.emailPiloto = emailPiloto;
    }

    public int getNumeroDeStrikesPiloto() {
        return numeroDeStrikesPiloto;
    }

    public void setNumeroDeStrikesPiloto(int numeroDeStrikesPiloto) { this.numeroDeStrikesPiloto = numeroDeStrikesPiloto; }

    public int getNumeroDeVitoriasPiloto() {
        return numeroDeVitoriasPiloto;
    }

    public void setNumeroDeVitoriasPiloto(int numeroDeVitoriasPiloto) { this.numeroDeVitoriasPiloto = numeroDeVitoriasPiloto; }

    public String getDataNascimentoPiloto() {
        return dataNascimentoPiloto;
    }

    public void setDataNascimentoPiloto(String dataNascimentoPiloto) { this.dataNascimentoPiloto = dataNascimentoPiloto; }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public Piloto(int idPiloto, String nomePiloto, String senhaPiloto, String cpfPiloto, String emailPiloto, int numeroDeStrikesPiloto, int numeroDeVitoriasPiloto, String dataNascimentoPiloto, boolean ativo) {
        this.idPiloto = idPiloto;
        this.nomePiloto = nomePiloto;
        this.senhaPiloto = senhaPiloto;
        this.cpfPiloto = cpfPiloto;
        this.emailPiloto = emailPiloto;
        this.numeroDeStrikesPiloto = numeroDeStrikesPiloto;
        this.numeroDeVitoriasPiloto = numeroDeVitoriasPiloto;
        this.dataNascimentoPiloto = dataNascimentoPiloto;
        this.ativo = ativo;
    }

    public Piloto() {

    }

}
