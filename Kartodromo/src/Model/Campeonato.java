package Model;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Campeonato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCampeonato;

    private String nome;
    private Date dataCadastro;
    private String situacao;
    private String tipoCorrida;
    private Date dataFinalizacao;
    
    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public int getIdCampeonato() {
        return idCampeonato;
    }

    public void setIdCampeonato(int idCampeonato) {
        this.idCampeonato = idCampeonato;
    }

    public String getNome() { return nome; }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
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
    
    public Campeonato(int idCampeonato, String nome, Date dataCadastro, int totalCorridas, String situacao, String tipoCorrida, Date dataFinalizacao, String tipoKart, Kartodromo kartodromo) {
        this.idCampeonato = idCampeonato;
        this.nome = nome;
        this.dataCadastro = dataCadastro;
        this.situacao = situacao;
        this.tipoCorrida = tipoCorrida;
        this.dataFinalizacao = dataFinalizacao;
    }

    public Campeonato() {

    }

    @Override
    public String toString() {
        return "Campeonato{" +
                "idCampeonato=" + idCampeonato +
                ", nome='" + nome + '\'' +
                ", dataCadastro=" + dataCadastro +
                ", situacao='" + situacao + '\'' +
                ", tipoCorrida='" + tipoCorrida + '\'' +
                ", dataFinalizacao=" + dataFinalizacao +
                '}';
    }
}
