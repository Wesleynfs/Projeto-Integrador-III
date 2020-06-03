/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class PontuacaoPosicao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPontuacao_posicao;
    private int posicao;
    private int pontuacao;
        
    @ManyToOne
    private Campeonato campeonato;

    public int getIdPontuacao_posicao() {
        return idPontuacao_posicao;
    }

    public void setIdPontuacao_posicao(int idPontuacao_posicao) {
        this.idPontuacao_posicao = idPontuacao_posicao;
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

    public Campeonato getCampeonato() {
        return campeonato;
    }

    public void setCampeonato(Campeonato campeonato) {
        this.campeonato = campeonato;
    }

    public PontuacaoPosicao(int idPontuacao_posicao, int posicao, int pontuacao, Campeonato campeonato) {
        this.idPontuacao_posicao = idPontuacao_posicao;
        this.posicao = posicao;
        this.pontuacao = pontuacao;
        this.campeonato = campeonato;
    }

    public PontuacaoPosicao() {

    }
}
