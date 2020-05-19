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
    private Timestamp dataCorrida;
    private String tipoKart;
    private int numeroDeVoltas;

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

    public String getTipoKart() {
        return tipoKart;
    }

    public void setTipoKart(String tipoKart) {
        this.tipoKart = tipoKart;
    }

    public int getNumeroDeVoltas() {
        return numeroDeVoltas;
    }

    public void setNumeroDeVoltas(int numeroDeVoltas) {
        this.numeroDeVoltas = numeroDeVoltas;
    }

    public Corrida(int idCorrida, Timestamp dataCorrida, String tipoKart, int numeroDeVoltas) {
        this.idCorrida = idCorrida;
        this.dataCorrida = dataCorrida;
        this.tipoKart = tipoKart;
        this.numeroDeVoltas = numeroDeVoltas;
    }

    public Corrida() {


    }
}
