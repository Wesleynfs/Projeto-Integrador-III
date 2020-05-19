package Model;

import javax.persistence.*;

@Entity
public class ConviteCampeonato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPilotoConviteCampeonato;
    private String statusConvite;

    @ManyToOne
    private Piloto pilotoQueConvidou;
    @ManyToOne
    private Piloto pilotoConvidado;
    @ManyToOne
    private Campeonato campeonato;

    public int getIdPilotoConviteCampeonato() {
        return idPilotoConviteCampeonato;
    }

    public void setIdPilotoConviteCampeonato(int idPilotoConviteCampeonato) {
        this.idPilotoConviteCampeonato = idPilotoConviteCampeonato;
    }

    public String getStatusConvite() {
        return statusConvite;
    }

    public void setStatusConvite(String statusConvite) {
        this.statusConvite = statusConvite;
    }

    public Piloto getPilotoQueConvidou() {
        return pilotoQueConvidou;
    }

    public void setPilotoQueConvidou(Piloto pilotoQueConvidou) {
        this.pilotoQueConvidou = pilotoQueConvidou;
    }

    public Piloto getPilotoConvidado() {
        return pilotoConvidado;
    }

    public void setPilotoConvidado(Piloto pilotoConvidado) {
        this.pilotoConvidado = pilotoConvidado;
    }

    public Campeonato getCampeonato() {
        return campeonato;
    }

    public void setCampeonato(Campeonato campeonato) {
        this.campeonato = campeonato;
    }

    public ConviteCampeonato(int idPilotoConviteCampeonato, String statusConvite,
                             Piloto pilotoQueConvidou, Piloto pilotoConvidado,
                             Campeonato campeonato) {
        this.idPilotoConviteCampeonato = idPilotoConviteCampeonato;
        this.statusConvite = statusConvite;
        this.pilotoQueConvidou = pilotoQueConvidou;
        this.pilotoConvidado = pilotoConvidado;
        this.campeonato = campeonato;
    }

    public ConviteCampeonato() {


    }
}
