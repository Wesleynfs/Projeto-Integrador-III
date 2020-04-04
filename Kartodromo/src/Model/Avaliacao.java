package Model;

import javax.persistence.*;

@Entity
public class Avaliacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAvalicao;

    @ManyToOne
    private Piloto piloto;
    @ManyToOne
    private Kartodromo kartodromo;

    private String comentario;

    public int getIdAvalicao() {
        return idAvalicao;
    }

    public void setIdAvalicao(int idAvalicao) {
        this.idAvalicao = idAvalicao;
    }

    public Piloto getPiloto() {
        return piloto;
    }

    public void setPiloto(Piloto piloto) {
        this.piloto = piloto;
    }

    public Kartodromo getKartodromo() {
        return kartodromo;
    }

    public void setKartodromo(Kartodromo kartodromo) {
        this.kartodromo = kartodromo;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Avaliacao(int idAvalicao, Piloto piloto, Kartodromo kartodromo, String comentario) {
        this.idAvalicao = idAvalicao;
        this.piloto = piloto;
        this.kartodromo = kartodromo;
        this.comentario = comentario;
    }

    public Avaliacao() {

    }

    @Override
    public String toString() {
        return "Avaliacao{" +
                "idAvalicao=" + idAvalicao +
                ", piloto=" + piloto +
                ", kartodromo=" + kartodromo +
                ", comentario='" + comentario + '\'' +
                '}';
    }
}
