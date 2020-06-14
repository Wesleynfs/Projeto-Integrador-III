package Model;

import javax.persistence.*;

@Entity
public class Kartodromo extends Pessoa {

    private boolean diaEmAtividadeSegunda;
    private boolean diaEmAtividadeTerca;
    private boolean diaEmAtividadeQuarta;
    private boolean diaEmAtividadeQuinta;
    private boolean diaEmAtividadeSexta;
    private boolean diaEmAtividadeSabado;
    private boolean diaEmAtividadeDomingo;
    private boolean kartIndoor;
    private boolean kartMotor2Tempos;
    private boolean kartMotor4Tempos;
    private boolean kartSemMarcha;
    private boolean kartShifter;
    private String rua;
    private String telefone;
    private int numero;
    @ManyToOne
    private Cidade cidade;

    public boolean isDiaEmAtividadeSegunda() {
        return diaEmAtividadeSegunda;
    }

    public void setDiaEmAtividadeSegunda(boolean diaEmAtividadeSegunda) {
        this.diaEmAtividadeSegunda = diaEmAtividadeSegunda;
    }

    public boolean isDiaEmAtividadeTerca() {
        return diaEmAtividadeTerca;
    }

    public void setDiaEmAtividadeTerca(boolean diaEmAtividadeTerca) {
        this.diaEmAtividadeTerca = diaEmAtividadeTerca;
    }

    public boolean isDiaEmAtividadeQuarta() {
        return diaEmAtividadeQuarta;
    }

    public void setDiaEmAtividadeQuarta(boolean diaEmAtividadeQuarta) {
        this.diaEmAtividadeQuarta = diaEmAtividadeQuarta;
    }

    public boolean isDiaEmAtividadeQuinta() {
        return diaEmAtividadeQuinta;
    }

    public void setDiaEmAtividadeQuinta(boolean diaEmAtividadeQuinta) {
        this.diaEmAtividadeQuinta = diaEmAtividadeQuinta;
    }

    public boolean isDiaEmAtividadeSexta() {
        return diaEmAtividadeSexta;
    }

    public void setDiaEmAtividadeSexta(boolean diaEmAtividadeSexta) {
        this.diaEmAtividadeSexta = diaEmAtividadeSexta;
    }

    public boolean isDiaEmAtividadeSabado() {
        return diaEmAtividadeSabado;
    }

    public void setDiaEmAtividadeSabado(boolean diaEmAtividadeSabado) {
        this.diaEmAtividadeSabado = diaEmAtividadeSabado;
    }

    public boolean isDiaEmAtividadeDomingo() {
        return diaEmAtividadeDomingo;
    }

    public void setDiaEmAtividadeDomingo(boolean diaEmAtividadeDomingo) {
        this.diaEmAtividadeDomingo = diaEmAtividadeDomingo;
    }

    public boolean isKartIndoor() {
        return kartIndoor;
    }

    public void setKartIndoor(boolean kartIndoor) {
        this.kartIndoor = kartIndoor;
    }

    public boolean isKartMotor2Tempos() {
        return kartMotor2Tempos;
    }

    public void setKartMotor2Tempos(boolean kartMotor2Tempos) {
        this.kartMotor2Tempos = kartMotor2Tempos;
    }

    public boolean isKartMotor4Tempos() {
        return kartMotor4Tempos;
    }

    public void setKartMotor4Tempos(boolean kartMotor4Tempos) {
        this.kartMotor4Tempos = kartMotor4Tempos;
    }

    public boolean isKartSemMarcha() {
        return kartSemMarcha;
    }

    public void setKartSemMarcha(boolean kartSemMarcha) {
        this.kartSemMarcha = kartSemMarcha;
    }

    public boolean isKartShifter() {
        return kartShifter;
    }

    public void setKartShifter(boolean kartShifter) {
        this.kartShifter = kartShifter;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Kartodromo() {

    }

    @Override
    public String toString() {
        return "Kartodromo{" +
                "diaEmAtividadeSegunda=" + diaEmAtividadeSegunda +
                ", diaEmAtividadeTerca=" + diaEmAtividadeTerca +
                ", diaEmAtividadeQuarta=" + diaEmAtividadeQuarta +
                ", diaEmAtividadeQuinta=" + diaEmAtividadeQuinta +
                ", diaEmAtividadeSexta=" + diaEmAtividadeSexta +
                ", diaEmAtividadeSabado=" + diaEmAtividadeSabado +
                ", diaEmAtividadeDomingo=" + diaEmAtividadeDomingo +
                ", kartIndoor=" + kartIndoor +
                ", kartMotor2Tempos=" + kartMotor2Tempos +
                ", kartMotor4Tempos=" + kartMotor4Tempos +
                ", kartSemMarcha=" + kartSemMarcha +
                ", kartShifter=" + kartShifter +
                ", rua='" + rua + '\'' +
                ", telefone='" + telefone + '\'' +
                ", numero=" + numero +
                ", cidade=" + cidade +
                '}';
    }
}
