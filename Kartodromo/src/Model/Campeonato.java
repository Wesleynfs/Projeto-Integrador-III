package Model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Campeonato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCampeonato;

    private String nome;
    private Timestamp dataCadastro;
    private int totalCorridas;
    private boolean situacao;
    private String tipoCorrida;
    private Timestamp dataFinalizacao;

    @ManyToOne
    private Kartodromo kartodromo;
    @ManyToOne
    private Corrida corrida;

    public Timestamp getDataFinalizacao() {
        return dataFinalizacao;
    }

    public void setDataFinalizacao(Timestamp dataFinalizacao) {
        this.dataFinalizacao = dataFinalizacao;
    }

    public int getIdCampeonato() {
        return idCampeonato;
    }

    public void setIdCampeonato(int idCampeonato) {
        this.idCampeonato = idCampeonato;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Timestamp getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Timestamp dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public int getTotalCorridas() {
        return totalCorridas;
    }

    public void setTotalCorridas(int totalCorridas) {
        this.totalCorridas = totalCorridas;
    }

    public boolean isSituacao() {
        return situacao;
    }

    public void setSituacao(boolean situacao) {
        this.situacao = situacao;
    }

    public String getTipoCorrida() {
        return tipoCorrida;
    }

    public void setTipoCorrida(String tipoCorrida) {
        this.tipoCorrida = tipoCorrida;
    }

    public Campeonato(int idCampeonato, String nome, Timestamp dataCadastro, int totalCorridas, boolean situacao, String tipoCorrida, Timestamp dataFinalizacao) {
        this.idCampeonato = idCampeonato;
        this.nome = nome;
        this.dataCadastro = dataCadastro;
        this.totalCorridas = totalCorridas;
        this.situacao = situacao;
        this.tipoCorrida = tipoCorrida;
        this.dataFinalizacao = dataFinalizacao;
    }

    public Campeonato() {

    }

}
