package gui.models;

import domain.Membership;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class MembershipTableModel extends AbstractTableModel{
     ArrayList<Membership> memberships;
     String headers[] = {"PACKAGE", "START DATE", "END DATE", "STATUS"};

     public MembershipTableModel(ArrayList<Membership> memberships) {
          this.memberships = memberships;
     }
     
          
     @Override
     public int getRowCount() {
          return memberships.size();
     }

     @Override
     public int getColumnCount() {
          return headers.length;
     }

     @Override
     public Object getValueAt(int rowIndex, int columnIndex) {
          Membership membership = memberships.get(rowIndex);
          try {
               switch (columnIndex) {
                    case 0: return membership.getMembershipPackage().getName();
                    case 1: return membership.getStartDate();
                    case 2: return membership.getEndDate();
                    case 4:
                         LocalDate currentDate = LocalDate.now();
                         if(currentDate.isAfter(membership.getStartDate()) && currentDate.isBefore(membership.getEndDate())){
                              return "ACTIVE";
                         } else {
                              return "";
                         }
                    default: return "N/A";
               }
          } catch (Exception ex) {
               return "N/A";
          }
     }
     
}
