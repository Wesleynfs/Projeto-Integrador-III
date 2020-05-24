package Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class Corrida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCorrida;
    private String nomeCorrida;
    private Timestamp dataCorrida;
    private int numeroDeVoltas;

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

    public Timestamp getDataCorrida() {
        return dataCorrida;
    }

    public void setDataCorrida(Timestamp dataCorrida) {
        this.dataCorrida = dataCorrida;
    }

    public int getNumeroDeVoltas() {
        return numeroDeVoltas;
    }

    public void setNumeroDeVoltas(int numeroDeVoltas) {
        this.numeroDeVoltas = numeroDeVoltas;
    }

    public Corrida(int idCorrida, String nomeCorrida, Timestamp dataCorrida, int numeroDeVoltas) {
        this.idCorrida = idCorrida;
        this.nomeCorrida = nomeCorrida;
        this.dataCorrida = dataCorrida;
        this.numeroDeVoltas = numeroDeVoltas;
    }

    public Corrida() {


    }
}
