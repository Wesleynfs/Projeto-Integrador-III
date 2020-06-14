package Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Date;

@Entity
public class Piloto extends Pessoa {

    private String apelido;
    private String cpfPiloto;
    private int numeroDeStrikesPiloto;
    private int nivel;
    private int pontuacao_nivel;
    private Date dataNascimentoPiloto;

    public void setPontuacao_nivel(int pontuacao_nivel) {
        this.pontuacao_nivel = pontuacao_nivel;
    }

    public int getPontuacao_nivel() {
        return pontuacao_nivel;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getCpfPiloto() {
        return cpfPiloto;
    }

    public void setCpfPiloto(String cpfPiloto) {
        this.cpfPiloto = cpfPiloto;
    }

    public int getNumeroDeStrikesPiloto() {
        return numeroDeStrikesPiloto;
    }

    public void setNumeroDeStrikesPiloto(int numeroDeStrikesPiloto) {
        this.numeroDeStrikesPiloto = numeroDeStrikesPiloto;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public Date getDataNascimentoPiloto() {
        return dataNascimentoPiloto;
    }

    public void setDataNascimentoPiloto(Date dataNascimentoPiloto) {
        this.dataNascimentoPiloto = dataNascimentoPiloto;
    }

    public Piloto() {

    }

    @Override
    public String toString() {
        return "Piloto{" +
                "apelido='" + apelido + '\'' +
                ", cpfPiloto='" + cpfPiloto + '\'' +
                ", numeroDeStrikesPiloto=" + numeroDeStrikesPiloto +
                ", nivel=" + nivel +
                ", pontuacao_nivel=" + pontuacao_nivel +
                ", dataNascimentoPiloto=" + dataNascimentoPiloto +
                '}';
    }
}
