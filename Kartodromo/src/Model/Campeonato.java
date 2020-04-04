package Model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
public class Campeonato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCampeonato;

    private Timestamp data;

    @ManyToMany(mappedBy = "campeonatos")
    private List<Piloto> pilotos;

    @ManyToOne
    private Kartodromo kartodromo;

    private String nome;

    // Gets and Sets //

    public Kartodromo getKartodromo() { return kartodromo; }

    public void setKartodromo(Kartodromo kartodromo) { this.kartodromo = kartodromo; }

    public List<Piloto> getPilotos() { return pilotos; }

    public void setPilotos(List<Piloto> pilotos) { this.pilotos = pilotos; }

    public int getIdCampeonato() {
        return idCampeonato;
    }

    public void setIdCampeonato(int idCampeonato) {
        this.idCampeonato = idCampeonato;
    }

    public Timestamp getData() {
        return data;
    }

    public void setData(Timestamp data) {
        this.data = data;
    }
/*
    public Kartodromo getKartodromo() {
        return kartodromo;
    }

    public void setKartodromo(Kartodromo kartodromo) {
        this.kartodromo = kartodromo;
    }
*/
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Campeonato(int idCampeonato, Timestamp data,/* Kartodromo kartodromo,*/ String nome) {
        this.idCampeonato = idCampeonato;
        this.data = data;
        //this.kartodromo = kartodromo;
        this.nome = nome;
    }

    public Campeonato() {
    }

    @Override
    public String toString() {
        return "Campeonato{" +
                "idCampeonato=" + idCampeonato +
                ", data=" + data +
                //", kartodromo=" + kartodromo +
                ", nome='" + nome + '\'' +
                '}';
    }
}
