package Bo;

import Dao.CampeonatoDAO;
import Model.Campeonato;
import Model.ConviteCampeonato;
import Utilities.Tempo;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class CampeonatoBO implements GenericBO<Campeonato> {

    private CampeonatoDAO campeonatoDAO;

    public CampeonatoBO() {

    }

    @Override
    public boolean criar(Campeonato o) throws Exception {
        if (valida(o)) {
            campeonatoDAO = new CampeonatoDAO();
            return campeonatoDAO.salvar(o);
        }
        return false;
    }

    @Override
    public boolean deletar(Campeonato o) throws Exception {
        if (valida(o)) {
            campeonatoDAO = new CampeonatoDAO();
            return campeonatoDAO.deletar(o);
        }
        return false;
    }

    @Override
    public boolean alterar(Campeonato o) throws Exception {
        if (valida(o)) {
            campeonatoDAO = new CampeonatoDAO();
            return campeonatoDAO.alterar(o);
        }
        return false;
    }

    @Override
    public List<Campeonato> listarPorItem(Campeonato o) throws Exception {
        return null;
    }

    @Override
    public List<Campeonato> listarTodos() throws Exception {
        campeonatoDAO = new CampeonatoDAO();
        return campeonatoDAO.listarTodos();
    }

    @Override
    public Campeonato getById(int id) throws Exception {
        if (validaId(id)) {
            campeonatoDAO = new CampeonatoDAO();
            return campeonatoDAO.getById(id);
        }
        return null;
    }

    public Campeonato getByNome(String nome) throws Exception {
        campeonatoDAO = new CampeonatoDAO();
        for (Campeonato campeonato : campeonatoDAO.getByNome(nome)) {
            return campeonato;
        }
        return null;
    }

    @Override
    public boolean valida(Campeonato o) throws Exception {
        if (o.getNome().equals("")) {
            throw new Exception("Nome do Campeonato não pode ficar em branco!");
        }
        if (o.getDataInicio().toString().equals("1000-01-01")) {
            throw new Exception("Por favor adicione uma data de finalização para o campeonato!");
        }
        return true;
    }

    @Override
    public boolean validaId(long id) throws Exception {
        if (id <= 0) {
            throw new Exception("Id do Campeonato não pode ser menor ou igual a 0");
        }
        return true;
    }

    public List<Campeonato> listarCampeonatosFinalizados() throws Exception {
        campeonatoDAO = new CampeonatoDAO();
        return campeonatoDAO.listarCampeonatosFinalizados();
    }

    public List<Campeonato> listarPorData() throws Exception {
        campeonatoDAO = new CampeonatoDAO();
        return campeonatoDAO.listarPorData();
    }

    public List<Campeonato> listarPorNome() throws Exception {
        campeonatoDAO = new CampeonatoDAO();
        return campeonatoDAO.listarPorNome();
    }

    public boolean validarTabelaPontuacaoCampeonato(DefaultTableModel tabelamento) {
        int verificarConsistencia = 0;
        for (int i = 0; tabelamento.getRowCount() > i; i++) {
            if (Integer.valueOf(tabelamento.getValueAt(i, 1).toString()) > 100) {
                JOptionPane.showMessageDialog(null,
                        "<html>Sua pontuação está muito elevada!<br/>Use pontuações menores que 100!</html>",
                        "Erro", JOptionPane.PLAIN_MESSAGE);
            }
            if (i == 0) {
                verificarConsistencia = Integer.valueOf(tabelamento.getValueAt(i, 1).toString());
                continue;
            }
            if (verificarConsistencia < Integer.valueOf(tabelamento.getValueAt(i, 1).toString())) {
                JOptionPane.showMessageDialog(null,
                        "<html>Sua pontuação está incoerente!<br/>Coloque em ordem do maior para menor</html>",
                        "Erro", JOptionPane.PLAIN_MESSAGE);
            }
            verificarConsistencia = Integer.valueOf(tabelamento.getValueAt(i, 1).toString());
        }
        return true;
    }

    public boolean validarTelaGerenciarCampeonato(Campeonato campeonato) throws Exception {
        if (campeonato.getNumeroCorridas() <= 0) {
            throw new Exception("Numero de corridas inválido");
        }
        if (campeonato.getDataInicio().before(Tempo.getCurrentDate())) {
            throw new Exception("Data do campeonato inválida");
        }
        return true;
    }

    public boolean validarTelaAdicionarPiloto(List<ConviteCampeonato> convites) throws Exception {
        if (convites.isEmpty()) {
            throw new Exception("Pelo menos adicione um piloto");
        }
        if (convites.size() > 25) {
            throw new Exception("Numero de pilotos maior que o permitido!");
        }
        return true;
    }

    public boolean validaTelaVerificarCampeonatos(String t) throws Exception {
        if (t.equals("Aguardando pilotos aceitarem")) {
            throw new Exception("Nenhum piloto selecionado! Verifique se algum aceitou sua solicitação para o campeonato");
        }
        return true;
    }

}

