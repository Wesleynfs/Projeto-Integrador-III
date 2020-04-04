package Model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class ClassificacaoInterna {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idClassificacaoInterna;
    private Timestamp tempoDeVolta;

    @ManyToOne
    private Kartodromo kartodromo;
    @ManyToOne
    private Piloto piloto;

    // Gets and Sets //

    public int getIdClassificacaoInterna() {
        return idClassificacaoInterna;
    }

    public void setIdClassificacaoInterna(int idClassificacaoInterna) {
        this.idClassificacaoInterna = idClassificacaoInterna;
    }

    public Kartodromo getKartodromo() {
        return kartodromo;
    }

    public void setKartodromo(Kartodromo kartodromo) {
        this.kartodromo = kartodromo;
    }

    public Piloto getPiloto() {
        return piloto;
    }

    public void setPiloto(Piloto piloto) {
        this.piloto = piloto;
    }

    public Timestamp getTempoDeVolta() {
        return tempoDeVolta;
    }

    public void setTempoDeVolta(Timestamp tempoDeVolta) {
        this.tempoDeVolta = tempoDeVolta;
    }

    public ClassificacaoInterna(Kartodromo kartodromo, Piloto piloto, Timestamp tempoDeVolta) {
        this.kartodromo = kartodromo;
        this.piloto = piloto;
        this.tempoDeVolta = tempoDeVolta;
    }

    public ClassificacaoInterna() {

    }

    @Override
    public String toString() {
        return "ClassificacaoInterna{" +
                "kartodromo=" + kartodromo +
                ", piloto=" + piloto +
                ", tempoDeVolta=" + tempoDeVolta +
                '}';
    }
}
