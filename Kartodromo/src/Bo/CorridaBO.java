package Bo;

import Dao.CorridaDAO;
import Model.Campeonato;
import Model.Corrida;

import javax.swing.*;
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

    public boolean validarTelaGerenciarCorrida(List<Corrida> corridaList , Campeonato campeonato) throws Exception {
        if (corridaList.size() != campeonato.getNumeroCorridas()) {
            throw new Exception("Na criação do campeonato voce adicionou um total de [" + campeonato.getNumeroCorridas() + "] corridas, porém foram adicionadas [" + corridaList.size() + "]");
        }
        for (Corrida corrida : corridaList) {
            if (corrida.getNumeroDeVoltas() <= 0) {
                throw new Exception("Alguma corrida possui um numero de voltas menor ou igual a 0!");
            }
            if (corrida.getNumeroDeVoltas() >= 10) {
                throw new Exception("Numero de corridas maior ou igual a 10, remova algumas!");
            }
        }
        return true;
    }

    public static boolean validarTelaResultadosTabelaDeParticipantes(JTable tableParticipantesStatus) throws Exception {
        for (int x = 0 ; x < tableParticipantesStatus.getRowCount() ; x++) {
            if (tableParticipantesStatus.getModel().getValueAt(x,2) == null) {
                throw new Exception("Campo vazio! adicionar tempo de piloto!");
            }
        }
        return true;
    }

}
