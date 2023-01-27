package operation.member;

import domain.Gender;
import domain.GenericEntity;
import domain.Member;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Date;
import operation.AbstractGenericOperation;

public class GetAllMembers extends AbstractGenericOperation{
    private ArrayList<Member> members = new ArrayList();
    
    @Override
    protected void preconditions(GenericEntity entity) throws Exception {
          // NONE
    }
    @Override
    protected void executeOperation(GenericEntity entity) throws Exception {
        ResultSet rs = repository.getAll(entity);
        while (rs.next()) {
            Member m = new Member();
            
            int memberID = rs.getInt("memberID");
            String firstName = rs.getString("firstName");
            String lastName = rs.getString("lastName");
            String gender = rs.getString("gender");
            String address = rs.getString("address");
            String phoneNumber = rs.getString("phoneNumber");
            Date dateOfBirth = rs.getDate("dateOfBirth");
            
            m.setMemberID(memberID);
            m.setFirstName(firstName);
            m.setLastName(lastName);
            m.setGender(gender != null ? Gender.valueOf(gender) : null);    // these fields are optional
            m.setAddress(address != null ? address : null);
            m.setPhoneNumber(phoneNumber != null ? phoneNumber : null);
            m.setDateOfBirth(dateOfBirth != null ? dateOfBirth.toLocalDate() : null);

            members.add(m);
        }
    }

    public ArrayList<Member> getMembers() {
        return members;
    }
}
