package Model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class PilotoParticipaCorrida {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPilotoParticipaCorrida;
    private int posicao;
    private int pontuacao;
    private Timestamp tempoAoTerminar;
    private int posicaoDeLargada;
    private boolean statusPresenca;

    @ManyToOne
    private PilotoParticipandoCampeonato pilotoparticipacampeonato;
    @ManyToOne
    private Corrida corrida;

    public int getIdPilotoParticipaCorrida() {
        return idPilotoParticipaCorrida;
    }

    public boolean isStatusPresenca() {
        return statusPresenca;
    }

    public void setStatusPresenca(boolean Status_Presenca) { this.statusPresenca = Status_Presenca; }
    
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

    public Timestamp getTempoAoTerminar() { return tempoAoTerminar; }

    public void setTempoAoTerminar(Timestamp tempoAoTerminar) { this.tempoAoTerminar = tempoAoTerminar; }

    public int getPosicaoDeLargada() {
        return posicaoDeLargada;
    }

    public void setPosicaoDeLargada(int posicaoDeLargada) { this.posicaoDeLargada = posicaoDeLargada; }

    public PilotoParticipandoCampeonato getPilotoParticipaCampeonato() { return pilotoparticipacampeonato; }

    public Corrida getCorrida() {
        return corrida;
    }

    public void setCorrida(Corrida corrida) {
        this.corrida = corrida;
    }

    public void setPilotoparticipacampeonato(PilotoParticipandoCampeonato pilotoparticipacampeonato) { this.pilotoparticipacampeonato = pilotoparticipacampeonato; }

    public PilotoParticipaCorrida(int idPilotoParticipaCorrida, int posicao, int pontuacao, Timestamp tempoAoTerminar, int posicaoDeLargada, PilotoParticipandoCampeonato pilotoparticipacampeonato, Corrida corrida) {
        this.idPilotoParticipaCorrida = idPilotoParticipaCorrida;
        this.posicao = posicao;
        this.pontuacao = pontuacao;
        this.tempoAoTerminar = tempoAoTerminar;
        this.posicaoDeLargada = posicaoDeLargada;
        this.pilotoparticipacampeonato = pilotoparticipacampeonato;
        this.corrida = corrida;
    }

    public PilotoParticipaCorrida() {
    
    }
}