package Bo;

import Dao.CorridaDAO;
import Dao.KartodromoDAO;
import Model.Campeonato;
import Model.Corrida;
import Model.Kartodromo;

import javax.swing.*;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;

public class CorridaBO implements GenericBO<Corrida> {

    private CorridaDAO corridaDAO;

    public CorridaBO() {

    }

    @Override
    public boolean criar(Corrida o) throws Exception {
        corridaDAO = new CorridaDAO();
        return corridaDAO.salvar(o);
    }

    @Override
    public boolean deletar(Corrida o) throws Exception {
        corridaDAO = new CorridaDAO();
        return corridaDAO.deletar(o);
    }

    @Override
    public boolean alterar(Corrida o) throws Exception {
        corridaDAO = new CorridaDAO();
        return corridaDAO.alterar(o);
    }

    @Override
    public List<Corrida> listarPorItem(Corrida o) throws Exception {
        corridaDAO = new CorridaDAO();
        return corridaDAO.listarTodos(o);
    }

    @Override
    public List<Corrida> listarTodos() throws Exception {
        corridaDAO = new CorridaDAO();
        return corridaDAO.listarTodos();
    }

    @Override
    public Corrida getById(int id) throws Exception {
        corridaDAO = new CorridaDAO();
        return corridaDAO.getById(id);
    }

    @Override
    public boolean valida(Corrida o) throws Exception {
        return false;
    }

    @Override
    public boolean validaId(long id) throws Exception {
        return false;
    }

    public List<Corrida> listarTodasAsCorridasMarcadas(Campeonato c) throws Exception {
        corridaDAO = new CorridaDAO();
        return corridaDAO.listarTodasAsCorridasMarcadasDeCampeonato(c);
    }

    public Corrida getByNome(String nome) throws Exception {
        corridaDAO = new CorridaDAO();
        return corridaDAO.getByNome(nome);
    }

    public boolean validarTextFieldsDaTelaGerenciarCorrida(String volta, String hora, String data, String nome) throws Exception {
        if (!ValidarString.isApenasLetras(nome)) {
            throw new Exception("Adicionar nome para corrida");
        }
        if (!ValidarString.isApenasNumeros(volta)) {
            throw new Exception("Adicionar voltas da corrida!");
        }
        if (!ValidarString.isHorario(hora)) {
            throw new Exception("Adicionar horário da corrida!");
        }
        if (!ValidarString.isDataPadraoBRA(data)) {
            throw new Exception("Adicionar data da corrida!");
        }
        return true;
    }

    public boolean validarTabelaGerenciarCorrida(List<Corrida> corridaList, Campeonato campeonato) throws Exception {
        if (corridaList.size() != campeonato.getNumeroCorridas()) {
            throw new Exception("Na criação do campeonato voce adicionou um total de [" + campeonato.getNumeroCorridas() + "] corridas, porém foram adicionadas [" + corridaList.size() + "]");
        }
        return true;
    }

    public static boolean validarTelaResultadosTabelaDeParticipantes(JTable tableParticipantesStatus) throws Exception {
        for (int x = 0; x < tableParticipantesStatus.getRowCount(); x++) {
            if (tableParticipantesStatus.getModel().getValueAt(x, 2) == null) {
                throw new Exception("Campo vazio! adicionar tempo de piloto!");
            }
        }
        return true;
    }

    public boolean validarCorrida(Corrida corrida, Campeonato campeonato) throws Exception {
        if (corrida.getDataDaCorrida().before(campeonato.getDataInicio())) {
            throw new Exception("Data da corrida não pode ser antes da data do campeonato");
        }
        if (corrida.getNumeroDeVoltas() <= 0) {
            throw new Exception("Alguma corrida possui um numero de voltas menor ou igual a 0!");
        }
        if (corrida.getNumeroDeVoltas() >= 10) {
            throw new Exception("Numero de corridas maior ou igual a 10, remova algumas!");
        }
        if (corrida.getNomeCorrida().equals("")) {
            throw new Exception("Digite um nome para a corrida!");
        }
        if (!validarDiasDeKartodromoAtivo(corrida.getDataDaCorrida(),corrida.getKartodromo())) {
            throw new Exception("Kartodromo " + corrida.getKartodromo().getNome() + " não funciona nesse dia!");
        }
        return true;
    }

    private boolean validarDiasDeKartodromoAtivo(Date dataCorrida , Kartodromo kartodromo) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dataCorrida);

        switch (calendar.get(Calendar.DAY_OF_WEEK)) {
            case 1:
                return kartodromo.isDiaEmAtividadeDomingo();
            case 2:
                return kartodromo.isDiaEmAtividadeSegunda();
            case 3:
                return kartodromo.isDiaEmAtividadeTerca();
            case 4:
                return kartodromo.isDiaEmAtividadeQuarta();
            case 5:
                return kartodromo.isDiaEmAtividadeQuinta();
            case 6:
                return kartodromo.isDiaEmAtividadeSexta();
            case 7:
                return kartodromo.isDiaEmAtividadeSabado();
            default:
                return false;
        }
    }
}
