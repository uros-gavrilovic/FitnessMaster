package operation.member;

import domain.BodyPart;
import domain.Category;
import domain.Exercise;
import domain.Gender;
import domain.GenericEntity;
import domain.Member;
import java.sql.Date;
import java.sql.ResultSet;
import operation.AbstractGenericOperation;

public class FindMember extends AbstractGenericOperation{
    Member member;
    
    @Override
    protected void preconditions(GenericEntity entity) throws Exception {
        // NONE
    }
    @Override
    protected void executeOperation(GenericEntity entity) throws Exception {
           ResultSet rs = repository.find(entity);
           
            int memberID = rs.getInt("memberID");
            String firstName = rs.getString("firstName");
            String lastName = rs.getString("lastName");
            String gender = rs.getString("gender");
            String address = rs.getString("address");
            String phoneNumber = rs.getString("phoneNumber");
            Date dateOfBirth = rs.getDate("dateOfBirth");
            
            member.setMemberID(memberID);
            member.setFirstName(firstName);
            member.setLastName(lastName);
            member.setGender(gender != null ? Gender.valueOf(gender) : null);    // these fields are optional
            member.setAddress(address != null ? address : null);
            member.setPhoneNumber(phoneNumber != null ? phoneNumber : null);
            member.setDateOfBirth(dateOfBirth != null ? dateOfBirth.toLocalDate() : null);
    }

    public Member getMember() {
        return member;
    }
}
