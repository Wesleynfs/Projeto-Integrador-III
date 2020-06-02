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
    private Timestamp tempoParaTerminar;
    private int posicaoDeLargada;

    @ManyToOne
    private PilotoParticipandoCampeonato pilotoparticipacampeonato;
    @ManyToOne
    private Corrida corrida;

    public int getIdPilotoParticipaCorrida() {
        return idPilotoParticipaCorrida;
    }

    public void setIdPilotoParticipaCorrida(int idPilotoParticipaCorrida) {
        this.idPilotoParticipaCorrida = idPilotoParticipaCorrida;
    }

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

    public Timestamp getTempoParaTerminar() {
        return tempoParaTerminar;
    }

    public void setTempoParaTerminar(Timestamp tempoParaTerminar) {
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

    public void setPilotoparticipacampeonato(PilotoParticipandoCampeonato pilotoparticipacampeonato) {
        this.pilotoparticipacampeonato = pilotoparticipacampeonato;
    }

    public Corrida getCorrida() {
        return corrida;
    }

    public void setCorrida(Corrida corrida) {
        this.corrida = corrida;
    }
    
    
    
    PilotoParticipaCorrida(){
    
    }
}