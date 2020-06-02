package Model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class PilotoParticipandoCampeonato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPilotoParticipandoCampeonato;
    private boolean statusAdm;
    private int posicao;
    private int pontuacao;
    private Timestamp tempoParaTerminar;
    private String presenca;

    @ManyToOne
    private Piloto piloto;
    @ManyToOne
    private Campeonato campeonato;

    public String getPresenca() {
        return presenca;
    }

    public void setPresenca(String presenca) {
        this.presenca = presenca;
    }
    
    public boolean isStatusAdm() {
        return statusAdm;
    }

    public void setStatusAdm(boolean statusAdm) {
        this.statusAdm = statusAdm;
    }

    public int getPosicao() {
        return posicao;
    }

    public void setPosicao(int posicao) { this.posicao = posicao; }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public Timestamp getTempoParaTerminar() {
        return tempoParaTerminar;
    }

    public void setTempoParaTerminar(Timestamp tempoParaTerminar) {
        this.tempoParaTerminar = tempoParaTerminar;
    }

    public int getIdPilotoParticipandoCampeonato() {
        return idPilotoParticipandoCampeonato;
    }

    public void setIdPilotoParticipandoCampeonato(int idPilotoParticipandoCampeonato) {
        this.idPilotoParticipandoCampeonato = idPilotoParticipandoCampeonato;
    }

    public Piloto getPiloto() {
        return piloto;
    }

    public void setPiloto(Piloto piloto) {
        this.piloto = piloto;
    }

    public Campeonato getCampeonato() {
        return campeonato;
    }

    public void setCampeonato(Campeonato campeonato) {
        this.campeonato = campeonato;
    }

    public PilotoParticipandoCampeonato(int idPilotoParticipandoCampeonato, boolean statusAdm, int posicao, int pontuacao, Timestamp tempoParaTerminar, Piloto piloto, Campeonato campeonato) {
        this.idPilotoParticipandoCampeonato = idPilotoParticipandoCampeonato;
        this.statusAdm = statusAdm;
        this.posicao = posicao;
        this.pontuacao = pontuacao;
        this.tempoParaTerminar = tempoParaTerminar;
        this.piloto = piloto;
        this.campeonato = campeonato;
    }

    public PilotoParticipandoCampeonato() {


    }

}
