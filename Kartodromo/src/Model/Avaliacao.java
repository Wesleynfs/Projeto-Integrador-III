package Model;

import javax.persistence.*;

@Entity
public class Avaliacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAvaliacao;
    private int numeroEstrelas;
    private String Comentario;

    @ManyToOne
    private Piloto piloto;
    @ManyToOne
    private Kartodromo kartodromo;

    public int getIdAvaliacao() {
        return idAvaliacao;
    }

    public void setIdAvaliacao(int idAvaliacao) {
        this.idAvaliacao = idAvaliacao;
    }

    public int getNumeroEstrelas() {
        return numeroEstrelas;
    }

    public void setNumeroEstrelas(int numeroEstrelas) {
        this.numeroEstrelas = numeroEstrelas;
    }

    public String getComentario() {
        return Comentario;
    }

    public void setComentario(String comentario) {
        Comentario = comentario;
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

    public Avaliacao(int idAvaliacao, int numeroEstrelas,
                     String comentario, Piloto piloto,
                     Kartodromo kartodromo) {
        this.idAvaliacao = idAvaliacao;
        this.numeroEstrelas = numeroEstrelas;
        Comentario = comentario;
        this.piloto = piloto;
        this.kartodromo = kartodromo;
    }

    public Avaliacao() {


    }
}
