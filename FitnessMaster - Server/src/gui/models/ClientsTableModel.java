package gui.models;

import domain.Trainer;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class ClientsTableModel extends AbstractTableModel {
     ArrayList<Trainer> clients;
     String headers[] = {"ID", "USERNAME", "FIRST NAME", "LAST NAME", "DURATION"};

     public ClientsTableModel(ArrayList<Trainer> clients) {
          this.clients = clients;
     }

     @Override
     public String getColumnName(int column) {
          return headers[column];
     }

     
     @Override
     public int getRowCount() {
          return clients.size();
     }

     @Override
     public int getColumnCount() {
          return headers.length;
     }

     @Override
     public Object getValueAt(int rowIndex, int columnIndex) {
          return "N/A";
     }
     
}
