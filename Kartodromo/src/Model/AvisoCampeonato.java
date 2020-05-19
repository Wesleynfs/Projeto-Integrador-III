package Model;

import javax.persistence.*;

@Entity
public class AvisoCampeonato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAvisoCampeonato;
    private String statusAviso;
    private String aviso;

    @ManyToOne
    private Campeonato campeonato;
    @ManyToOne
    private Piloto piloto;

    public int getIdAvisoCampeonato() {
        return idAvisoCampeonato;
    }

    public void setIdAvisoCampeonato(int idAvisoCampeonato) {
        this.idAvisoCampeonato = idAvisoCampeonato;
    }

    public String getStatusAviso() {
        return statusAviso;
    }

    public void setStatusAviso(String statusAviso) { this.statusAviso = statusAviso; }

    public String getAviso() {
        return aviso;
    }

    public void setAviso(String aviso) {
        this.aviso = aviso;
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

    public AvisoCampeonato(int idAvisoCampeonato, String statusAviso,
                           String aviso, Campeonato campeonato,
                           Piloto piloto) {
        this.idAvisoCampeonato = idAvisoCampeonato;
        this.statusAviso = statusAviso;
        this.aviso = aviso;
        this.campeonato = campeonato;
        this.piloto = piloto;
    }
}
