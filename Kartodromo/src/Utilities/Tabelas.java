package Utilities;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;

public class Tabelas {
    public static void alinharCelulasNoCentro(JTable table) {
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int columnIndex = 0; columnIndex < table.getModel().getColumnCount(); columnIndex++) {
            table.getColumnModel().getColumn(columnIndex).setCellRenderer(rightRenderer);
        }
    }
}
