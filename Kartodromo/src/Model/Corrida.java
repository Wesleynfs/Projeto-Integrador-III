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
    private int numeroDeVoltas;
    private String tipoKart;

    public String getTipoKart() {
        return tipoKart;
    }

    public void setTipoKart(String tipoKart) {
        this.tipoKart = tipoKart;
    }
    
    @ManyToOne
    private Campeonato campeonato;

    @ManyToOne
    private Kartodromo kartodromo;

    
    public Kartodromo getKartodromo() {
        return kartodromo;
    }

    public void setKartodromo(Kartodromo kartodromo) {
        this.kartodromo = kartodromo;
    }

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

    public int getNumeroDeVoltas() {
        return numeroDeVoltas;
    }

    public void setNumeroDeVoltas(int numeroDeVoltas) {
        this.numeroDeVoltas = numeroDeVoltas;
    }

    public Corrida(int idCorrida, String nomeCorrida, Date dataCorrida, int numeroDeVoltas) {
        this.idCorrida = idCorrida;
        this.nomeCorrida = nomeCorrida;
        this.numeroDeVoltas = numeroDeVoltas;
    }

    public Corrida() {

    }

    @Override
    public String toString() {
        return "<html>Corrida:" + nomeCorrida + "do kartódormo " 
                + kartodromo.getNomeKartodromo()
                + "<br>localizado em "+kartodromo.getEstado()+", "+kartodromo.getCidade()+", "
                +kartodromo.getRua()+", "+kartodromo.getNumero()
                +"<br> usando o tipo kart: "+tipoKart+" com um total de "
                +numeroDeVoltas+" voltas</html>";
    }
}
