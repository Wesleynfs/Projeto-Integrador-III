package Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Kartodromo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idKartodromo;
    private String nomeKartodromo;
    private boolean diaEmAtividadeSegunda;
    private boolean diaEmAtividadeTerca;
    private boolean diaEmAtividadeQuarta;
    private boolean diaEmAtividadeQuinta;
    private boolean diaEmAtividadeSexta;
    private boolean diaEmAtividadeSabado;
    private boolean diaEmAtividadeDomingo;
    private String senhaKartodromo;
    private String emailKartodromo;
    private boolean statusAtividade;
    private boolean kartIndoor;
    private boolean kartMotor2Tempos;
    private boolean kartMotor4Tempos;
    private boolean kartSemMarcha;
    private boolean kartShifter;
    private String rua;
    private int numero;
    private String estado;
    private String cidade;
    private String telefone;

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getIdKartodromo() {
        return idKartodromo;
    }

    public void setIdKartodromo(int idKartodromo) {
        this.idKartodromo = idKartodromo;
    }

    public String getNomeKartodromo() {
        return nomeKartodromo;
    }

    public void setNomeKartodromo(String nomeKartodromo) {
        this.nomeKartodromo = nomeKartodromo;
    }

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

    public String getSenhaKartodromo() {
        return senhaKartodromo;
    }

    public void setSenhaKartodromo(String senhaKartodromo) {
        this.senhaKartodromo = senhaKartodromo;
    }

    public String getEmailKartodromo() {
        return emailKartodromo;
    }

    public void setEmailKartodromo(String emailKartodromo) {
        this.emailKartodromo = emailKartodromo;
    }

    public boolean isStatusAtividade() {
        return statusAtividade;
    }

    public void setStatusAtividade(boolean statusAtividade) {
        this.statusAtividade = statusAtividade;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Kartodromo(int idKartodromo, String nomeKartodromo, boolean diaEmAtividadeSegunda, boolean diaEmAtividadeTerca, boolean diaEmAtividadeQuarta, boolean diaEmAtividadeQuinta, boolean diaEmAtividadeSexta, boolean diaEmAtividadeSabado, boolean diaEmAtividadeDomingo, String senhaKartodromo, String emailKartodromo, boolean statusAtividade, boolean kartIndoor, boolean kartMotor2Tempos, boolean kartMotor4Tempos, boolean kartSemMarcha, boolean kartShifter, String rua, int numero, String estado, String cidade, String telefone) {
        this.idKartodromo = idKartodromo;
        this.nomeKartodromo = nomeKartodromo;
        this.diaEmAtividadeSegunda = diaEmAtividadeSegunda;
        this.diaEmAtividadeTerca = diaEmAtividadeTerca;
        this.diaEmAtividadeQuarta = diaEmAtividadeQuarta;
        this.diaEmAtividadeQuinta = diaEmAtividadeQuinta;
        this.diaEmAtividadeSexta = diaEmAtividadeSexta;
        this.diaEmAtividadeSabado = diaEmAtividadeSabado;
        this.diaEmAtividadeDomingo = diaEmAtividadeDomingo;
        this.senhaKartodromo = senhaKartodromo;
        this.emailKartodromo = emailKartodromo;
        this.statusAtividade = statusAtividade;
        this.kartIndoor = kartIndoor;
        this.kartMotor2Tempos = kartMotor2Tempos;
        this.kartMotor4Tempos = kartMotor4Tempos;
        this.kartSemMarcha = kartSemMarcha;
        this.kartShifter = kartShifter;
        this.rua = rua;
        this.numero = numero;
        this.estado = estado;
        this.cidade = cidade;
        this.telefone = telefone;
    }

    public Kartodromo() {


    }
}
