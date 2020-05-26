package Model;

import javax.persistence.*;
import java.sql.Date;
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
    private Date dataFinalizacao;
    private String tipoKart;
    private Date dataInicio;

    @ManyToOne
    private Kartodromo kartodromo;

    @ManyToOne
    private Corrida[] corrida;

    public Kartodromo getKartodromo() {
        return kartodromo;
    }

    public void setKartodromo(Kartodromo kartodromo) {
        this.kartodromo = kartodromo;
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

    public Date getDataFinalizacao() {
        return dataFinalizacao;
    }

    public void setDataFinalizacao(Date dataFinalizacao) {
        this.dataFinalizacao = dataFinalizacao;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getTipoKart() {
        return tipoKart;
    }

    public void setTipoKart(String tipoKart) {
        this.tipoKart = tipoKart;
    }

    public Corrida[] getCorrida() {
        return corrida;
    }

    public void setCorrida(Corrida[] corrida) {
        this.corrida = corrida;
    }

    public Campeonato(int idCampeonato, String nome, Timestamp dataCadastro, int totalCorridas, boolean situacao, String tipoCorrida, Date dataFinalizacao, String tipoKart, Date dataInicio, Kartodromo kartodromo, Corrida[] corrida) {
        this.idCampeonato = idCampeonato;
        this.nome = nome;
        this.dataCadastro = dataCadastro;
        this.totalCorridas = totalCorridas;
        this.situacao = situacao;
        this.tipoCorrida = tipoCorrida;
        this.dataFinalizacao = dataFinalizacao;
        this.tipoKart = tipoKart;
        this.dataInicio = dataInicio;
        this.kartodromo = kartodromo;
        this.corrida = corrida;
    }

    public Campeonato() {

    }

}
