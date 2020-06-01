/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bo;

import Dao.AvisoCampeonatoDAO;
import Model.AvisoCampeonato;
import Model.Piloto;
import java.util.List;

public class AvisoCampeonatoBO implements GenericBO<AvisoCampeonato> {
        private AvisoCampeonatoDAO avisocampeonatodao;
        
        public  AvisoCampeonatoBO(){
        
        }
        
        @Override
    public boolean criar(AvisoCampeonato o) throws Exception {
        if (valida(o)) {
            avisocampeonatodao = new AvisoCampeonatoDAO();
            return avisocampeonatodao.salvar(o);
        }
        return false;
    }

    @Override
    public boolean deletar(AvisoCampeonato o) throws Exception {
        if (valida(o)) {
            avisocampeonatodao = new AvisoCampeonatoDAO();
            return avisocampeonatodao.deletar(o);
        }
        return false;
    }

    @Override
    public boolean alterar(AvisoCampeonato o) throws Exception {
        if (valida(o)) {
            avisocampeonatodao = new AvisoCampeonatoDAO();
            return avisocampeonatodao.alterar(o);
        }
        return false;
    }

    @Override
    public List<AvisoCampeonato> listarPorItem(AvisoCampeonato o) throws Exception {
        return null;
    }

    @Override
    public List<AvisoCampeonato> listarTodos() throws Exception {
        avisocampeonatodao = new AvisoCampeonatoDAO();
        return avisocampeonatodao.listarTodos();
    }

    @Override
    public AvisoCampeonato getById(int id) throws Exception {
        if (validaId(id)) {
            avisocampeonatodao = new AvisoCampeonatoDAO();
            return avisocampeonatodao.getById(id);
        }
        return null;
    }
    public List<AvisoCampeonato> listarAvisoNaoVizualizados(Piloto piloto) throws Exception {
        avisocampeonatodao = new AvisoCampeonatoDAO();
        return avisocampeonatodao.listarAvisoNaoVizualizados(piloto);
    
    }
    
    
    @Override
    public boolean valida(AvisoCampeonato o) throws Exception {
        if (o.getAviso().equals("")) {
            throw new Exception("Aviso não pode ficar em branco!");
        }
        return true;
    }

    @Override
    public boolean validaId(int id) throws Exception {
        if (id <= 0) {
            throw new Exception("Id do AvisoCampeonato não pode ser menor ou igual a 0");
        }
        return true;
    }
        
}
