package Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;
import java.sql.Time;
import javax.persistence.ManyToOne;

@Entity
public class Corrida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCorrida;
    private String nomeCorrida;
    private int numeroDeVoltas;
    private Time horaDaCorrida;
    private Date dataDaCorrida;
    private String tipoKart;
    
    @ManyToOne
    private Campeonato campeonato;

    @ManyToOne
    private Kartodromo kartodromo;

    public int getIdCorrida() {
        return idCorrida;
    }

    public void setIdCorrida(int idCorrida) {
        this.idCorrida = idCorrida;
    }

    public String getNomeCorrida() {
        return nomeCorrida;
    }

    public void setNomeCorrida(String nomeCorrida) {
        this.nomeCorrida = nomeCorrida;
    }

    public int getNumeroDeVoltas() {
        return numeroDeVoltas;
    }

    public void setNumeroDeVoltas(int numeroDeVoltas) {
        this.numeroDeVoltas = numeroDeVoltas;
    }

    public Time getHoraDaCorrida() {
        return horaDaCorrida;
    }

    public void setHoraDaCorrida(Time horaDaCorrida) {
        this.horaDaCorrida = horaDaCorrida;
    }

    public Date getDataDaCorrida() {
        return dataDaCorrida;
    }

    public void setDataDaCorrida(Date dataDaCorrida) {
        this.dataDaCorrida = dataDaCorrida;
    }

    public String getTipoKart() {
        return tipoKart;
    }

    public void setTipoKart(String tipoKart) {
        this.tipoKart = tipoKart;
    }

    public Campeonato getCampeonato() {
        return campeonato;
    }

    public void setCampeonato(Campeonato campeonato) {
        this.campeonato = campeonato;
    }

    public Kartodromo getKartodromo() {
        return kartodromo;
    }

    public void setKartodromo(Kartodromo kartodromo) {
        this.kartodromo = kartodromo;
    }

    public Corrida(int idCorrida, String nomeCorrida, int numeroDeVoltas, Time horaDaCorrida, Date dataDaCorrida, String tipoKart, Campeonato campeonato, Kartodromo kartodromo) {
        this.idCorrida = idCorrida;
        this.nomeCorrida = nomeCorrida;
        this.numeroDeVoltas = numeroDeVoltas;
        this.horaDaCorrida = horaDaCorrida;
        this.dataDaCorrida = dataDaCorrida;
        this.tipoKart = tipoKart;
        this.campeonato = campeonato;
        this.kartodromo = kartodromo;
    }

    public Corrida() {

    }

}
