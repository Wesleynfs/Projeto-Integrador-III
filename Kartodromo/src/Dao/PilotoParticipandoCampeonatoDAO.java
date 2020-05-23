package Dao;

import Model.PilotoParticipandoCampeonato;

import java.util.List;

public class PilotoParticipandoCampeonatoDAO implements GenericDAO<PilotoParticipandoCampeonato> {

    @Override
    public boolean salvar(PilotoParticipandoCampeonato o) throws Exception {
        return false;
    }

    @Override
    public boolean ler(PilotoParticipandoCampeonato o) throws Exception {
        return false;
    }

    @Override
    public boolean alterar(PilotoParticipandoCampeonato o) throws Exception {
        return false;
    }

    @Override
    public boolean deletar(PilotoParticipandoCampeonato o) throws Exception {
        return false;
    }

    @Override
    public List<PilotoParticipandoCampeonato> listarTodos(PilotoParticipandoCampeonato o) throws Exception {
        return null;
    }

    @Override
    public List<PilotoParticipandoCampeonato> listarTodos() throws Exception {
        return null;
    }

    @Override
    public PilotoParticipandoCampeonato getById(int id) throws Exception {
        return null;
    }
}
