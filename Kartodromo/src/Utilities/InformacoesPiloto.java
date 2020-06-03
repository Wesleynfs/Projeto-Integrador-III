package Utilities;

import Model.Piloto;

import javax.swing.*;

public class InformacoesPiloto extends JLabel {

    private String nomePiloto;
    private String apelidoPiloto;
    private String eloPiloto;
    private int nivelPiloto;
    private int numeroStrikesPiloto;
    private Piloto piloto;

    public Piloto getPiloto() {
        return piloto;
    }

    public void setPiloto(Piloto piloto) {
        this.piloto = piloto;
        showInfo();
    }

    public String getEloPiloto() {
        if (piloto.getNivel() < 5) {
            eloPiloto = "PILOTO INICIANTE";
        } else if (piloto.getNivel() < 10) {
            eloPiloto = "PILOTO AVANÇADO";
        } else {
            eloPiloto = "PILOTO VETERANO";
        }
        return eloPiloto;
    }

    public InformacoesPiloto() {

    }

    private void showInfo() {
        this.setText("<html>NOME: " + piloto.getNomePiloto().toUpperCase() + "<br/>" + "APELIDO: " + piloto.getApelido().toUpperCase() + "<br/>" + "NÍVEL: " + piloto.getNivel() + "<br/>" + getEloPiloto() + "<br/>" + "NÚMERO DE STRIKERS: " + piloto.getNumeroDeStrikesPiloto() + "</html>");
    }

}
