/* UNIVERSIDADE UNIFACEAR
 * Cidade : Araucária - PR
 * Alunos : Wesley de Araujo , Felipe Fillus
 * Turma : Análise e Desenvolvimento de Sistemas III
 */
package kartodromo;

import Bo.*;
import Dao.ConfiguracaoDAO;
import Model.*;
import Utilities.Info;
import Utilities.Tempo;
import View.LoginFrame;

public class Main {

    public static void main(String[] args) {
/*
        PilotoBO pilotoBO = new PilotoBO();
        KartodromoBO kartodromoBO = new KartodromoBO();
        CampeonatoBO campeonatoBO = new CampeonatoBO();
        AvaliacaoBO avaliacaoBO = new AvaliacaoBO();
        ClassificacaoInternaBO classificacaoInternaBO = new ClassificacaoInternaBO();
        ClassificacaoCampeonatoBO classificacaoCampeonatoBO = new ClassificacaoCampeonatoBO();

        Piloto piloto = new Piloto();
        piloto.setCpf("999.888.777.66");
        piloto.setNome("Wesley");
        piloto.setSenha("123456");
        piloto.setNumeroStrikes(0);
        piloto.setNumeroVitorias(15);
        piloto.setDataNascimento("24-05-1998 09:30:20");
        piloto.setEmail("kako.araujo.24@gmail.com");
        piloto.setAtivo('S');

        Kartodromo kartodromo = new Kartodromo();

        // Salvar sempre sem o ID //
        // Deletar sempre com o ID //
        // Alterar sempre com o ID //

        kartodromo.setNome("ROSCA_VOADORA");
        kartodromo.setEmail("Maior@roscaEnterprises.net");
        kartodromo.setEndereco("Campus Unifacear Araucária");
        kartodromo.setLogin("MAIOR@MENOR");
        kartodromo.setSenha("MENORZINHO");
        kartodromo.setDiasInativo("SABADO E DOMINGO");

        Campeonato campeonato = new Campeonato();
        campeonato.setNome("FIA GT3");
        campeonato.setData(Tempo.stringToTimestamp("23/02/2014 09:00:00"));
        campeonato.setKartodromo(kartodromo);

        Avaliacao avaliacao = new Avaliacao();
        avaliacao.setComentario("Kartodromo mir de bão");
        avaliacao.setKartodromo(kartodromo);
        avaliacao.setPiloto(piloto);

        ClassificacaoInterna classificacaoInterna = new ClassificacaoInterna();
        classificacaoInterna.setTempoDeVolta(Tempo.stringToLapTime("6:44.97"));
        classificacaoInterna.setKartodromo(kartodromo);
        classificacaoInterna.setPiloto(piloto);

        ClassificacaoCampeonato classificacaoCampeonato = new ClassificacaoCampeonato();
        classificacaoCampeonato.setCampeonato(campeonato);
        classificacaoCampeonato.setPiloto(piloto);
        classificacaoCampeonato.setPontosPiloto(17);
        classificacaoCampeonato.setMelhorVoltaPiloto(Tempo.stringToLapTime("6:43.45"));

        try {

            kartodromoBO.criarKartodromo(kartodromo);
            campeonatoBO.criarCampeonato(campeonato);
            pilotoBO.criarPiloto(piloto);
            avaliacaoBO.criarAvaliacao(avaliacao);
            classificacaoInternaBO.criarClassificacaoInterna(classificacaoInterna);
            classificacaoCampeonatoBO.criarClassificacaoCampeonato(classificacaoCampeonato);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
*/

        try {

            new LoginFrame();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
