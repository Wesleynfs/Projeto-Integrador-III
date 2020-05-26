package Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;
import java.sql.Timestamp;
import javax.persistence.ManyToOne;

@Entity
public class Corrida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCorrida;
    private String nomeCorrida;
    private Date dataCorrida;
    private int numeroDeVoltas;
    
    @ManyToOne
    private Campeonato campeonato;

    public Campeonato getCampeonato() {
        return campeonato;
    }

    public void setCampeonato(Campeonato campeonato) {
        this.campeonato = campeonato;
    }

    public String getNomeCorrida() {
        return nomeCorrida;
    }

    public void setNomeCorrida(String nomeCorrida) {
        this.nomeCorrida = nomeCorrida;
    }

    public int getIdCorrida() {
        return idCorrida;
    }

    public void setIdCorrida(int idCorrida) {
        this.idCorrida = idCorrida;
    }

    public Date getDataCorrida() {
        return dataCorrida;
    }

    public void setDataCorrida(Date dataCorrida) {
        this.dataCorrida = dataCorrida;
    }

    public int getNumeroDeVoltas() {
        return numeroDeVoltas;
    }

    public void setNumeroDeVoltas(int numeroDeVoltas) {
        this.numeroDeVoltas = numeroDeVoltas;
    }

    public Corrida(int idCorrida, String nomeCorrida, Date dataCorrida, int numeroDeVoltas) {
        this.idCorrida = idCorrida;
        this.nomeCorrida = nomeCorrida;
        this.dataCorrida = dataCorrida;
        this.numeroDeVoltas = numeroDeVoltas;
    }

    public Corrida() {

    }

}
