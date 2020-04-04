package Model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class ClassificacaoCampeonato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idClassificacaoCampeonato;

    private int pontosPiloto;
    private Timestamp melhorVoltaPiloto;
    @ManyToOne
    private Campeonato campeonato;
    @ManyToOne
    private Piloto piloto;

    public int getIdClassificacaoCampeonato() {
        return idClassificacaoCampeonato;
    }

    public void setIdClassificacaoCampeonato(int idClassificacaoCampeonato) {
        this.idClassificacaoCampeonato = idClassificacaoCampeonato;
    }

    public int getPontosPiloto() {
        return pontosPiloto;
    }

    public void setPontosPiloto(int pontosPiloto) {
        this.pontosPiloto = pontosPiloto;
    }

    public Timestamp getMelhorVoltaPiloto() {
        return melhorVoltaPiloto;
    }

    public void setMelhorVoltaPiloto(Timestamp melhorVoltaPiloto) {
        this.melhorVoltaPiloto = melhorVoltaPiloto;
    }

    public Campeonato getCampeonato() {
        return campeonato;
    }

    public void setCampeonato(Campeonato campeonato) {
        this.campeonato = campeonato;
    }

    public Piloto getPiloto() {
        return piloto;
    }

    public void setPiloto(Piloto piloto) {
        this.piloto = piloto;
    }

    public ClassificacaoCampeonato(int idClassificacaoCampeonato, int pontosPiloto, Timestamp melhorVoltaPiloto, Campeonato campeonato, Piloto piloto) {
        this.idClassificacaoCampeonato = idClassificacaoCampeonato;
        this.pontosPiloto = pontosPiloto;
        this.melhorVoltaPiloto = melhorVoltaPiloto;
        this.campeonato = campeonato;
        this.piloto = piloto;
    }

    public ClassificacaoCampeonato() {

    }

    @Override
    public String toString() {
        return "ClassificacaoCampeonato{" +
                "idClassificacaoCampeonato=" + idClassificacaoCampeonato +
                ", pontosPiloto=" + pontosPiloto +
                ", melhorVoltaPiloto=" + melhorVoltaPiloto +
                ", campeonato=" + campeonato +
                ", piloto=" + piloto +
                '}';
    }
}
