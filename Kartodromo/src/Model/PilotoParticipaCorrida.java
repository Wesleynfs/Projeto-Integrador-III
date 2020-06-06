package Model;

import javax.persistence.*;
import java.sql.Time;

@Entity
public class PilotoParticipaCorrida {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPilotoParticipaCorrida;
    private int posicao;
    private int pontuacao;
    private Time tempoParaTerminar;
    private int posicaoDeLargada;
    private boolean Status_Presenca;

    @ManyToOne
    private PilotoParticipandoCampeonato pilotoparticipacampeonato;
    @ManyToOne
    private Corrida corrida;

    public int getIdPilotoParticipaCorrida() {
        return idPilotoParticipaCorrida;
    }

    public boolean isStatus_Presenca() {
        return Status_Presenca;
    }

    public void setStatus_Presenca(boolean Status_Presenca) {
        this.Status_Presenca = Status_Presenca;
    }

    
    public void setIdPilotoParticipaCorrida(int idPilotoParticipaCorrida) { this.idPilotoParticipaCorrida = idPilotoParticipaCorrida; }

    public int getPosicao() {
        return posicao;
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public Time getTempoParaTerminar() { return tempoParaTerminar; }

    public void setTempoParaTerminar(Time tempoParaTerminar) {
        this.tempoParaTerminar = tempoParaTerminar;
    }

    public int getPosicaoDeLargada() {
        return posicaoDeLargada;
    }

    public void setPosicaoDeLargada(int posicaoDeLargada) {
        this.posicaoDeLargada = posicaoDeLargada;
    }

    public PilotoParticipandoCampeonato getPilotoparticipacampeonato() {
        return pilotoparticipacampeonato;
    }

    public Corrida getCorrida() {
        return corrida;
    }

    public void setCorrida(Corrida corrida) {
        this.corrida = corrida;
    }

    public void setPilotoparticipacampeonato(PilotoParticipandoCampeonato pilotoparticipacampeonato) {
        this.pilotoparticipacampeonato = pilotoparticipacampeonato;
    }

    public PilotoParticipaCorrida(int idPilotoParticipaCorrida, int posicao, int pontuacao, Time tempoParaTerminar, int posicaoDeLargada, PilotoParticipandoCampeonato pilotoparticipacampeonato, Corrida corrida) {
        this.idPilotoParticipaCorrida = idPilotoParticipaCorrida;
        this.posicao = posicao;
        this.pontuacao = pontuacao;
        this.tempoParaTerminar = tempoParaTerminar;
        this.posicaoDeLargada = posicaoDeLargada;
        this.pilotoparticipacampeonato = pilotoparticipacampeonato;
        this.corrida = corrida;
    }

    public PilotoParticipaCorrida() {
    
    }
}