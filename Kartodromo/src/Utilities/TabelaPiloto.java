package Utilities;

import Model.Corrida;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class TabelaPiloto extends AbstractTableModel {

    private List<Corrida> listCorrida;
    private String[] colunas = {"NOME DA CORRIDA",
            "NÚMERO DE VOLTAS","KARTODROMO","TIPO KART"};

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    @Override
    public int getRowCount() {
        return listCorrida.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        switch (coluna) {
            case 0 :
                return listCorrida.get(linha).getNomeCorrida();
            case 1 :
                return listCorrida.get(linha).getNumeroDeVoltas();
            case 2 :
                return listCorrida.get(linha).getKartodromo().getNomeKartodromo();
            case 3 :
                return listCorrida.get(linha).getTipoKart();
        }
        return null;
    }

    public void addRow(Corrida c) {
        listCorrida.add(c);
        this.fireTableDataChanged();
    }

    public void removeRow(int x) {
        listCorrida.remove(x);
        this.fireTableRowsDeleted(x,x);
    }

    public TabelaPiloto() {
        listCorrida = new ArrayList<>();
    }

    public List<Corrida> getListCorrida() {
        return listCorrida;
    }
}
