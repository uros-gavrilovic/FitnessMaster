package gui.models;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import domain.Member;
import java.time.LocalDate;

public class MemberTableModel extends AbstractTableModel{
    ArrayList<Member> members ;
    String headers[] = {"FIRST NAME", "LAST NAME", "GENDER", "ADDRESS", "PHONE", "BIRTH DATE"};

    public MemberTableModel(ArrayList members) {
        this.members = members;
    }

    @Override
    public int getRowCount() {
        return members.size();
    }
    @Override
    public int getColumnCount() {
        return headers.length;
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Member member = members.get(rowIndex);

            try{
                switch (columnIndex) {
                    case 0: return member.getFirstName();
                    case 1: return member.getLastName();
                    case 2: return member.getGender().toString();
                    case 3: return member.getAddress();
                    case 4: return member.getPhoneNumber();
                    case 5: return member.getDateOfBirth();
//                    case 5:       // TODO: Add membership status - (IN)ACTIVE
//                        if(){
//                            
//                        } else {
//                            
//                        }
                    default: return "N/A";
                }
            } catch (NullPointerException e) {
                return "N/A";
            }
    }
    @Override
    public String getColumnName(int column) {
        return headers[column];
    }
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public void addMember(Member member) {
        members.add(member);
        fireTableRowsInserted(members.size()-1, members.size()-1);
    }
    public Member getMemberAt(int row) {
        return members.get(row);
    }
    public ArrayList<Member> getMembers(){
        return members;
    }
}
