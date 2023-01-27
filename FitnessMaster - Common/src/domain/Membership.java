package domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Membership implements Serializable, GenericEntity  {
    Member member;
    Package membershipPackage;
    LocalDate startDate;
    LocalDate endDate;

    public Membership() {
    }
    public Membership(Member member, Package membershipPackage, LocalDate startDate, LocalDate endDate) {
        this.member = member;
        this.membershipPackage = membershipPackage;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Membership other = (Membership) obj;
        if (!Objects.equals(this.member, other.member)) {
            return false;
        }
        if (!Objects.equals(this.membershipPackage, other.membershipPackage)) {
            return false;
        }
        if (!Objects.equals(this.startDate, other.startDate)) {
            return false;
        }
        return Objects.equals(this.endDate, other.endDate);
    }
    public String toString() {
        return "Membership{" + "member=" + member + ", membershipPackage=" + membershipPackage + ", startDate=" + startDate + ", endDate=" + endDate + '}';
    }

    public Member getMember() {
        return member;
    }
    public void setMember(Member member) {
        this.member = member;
    }
    public Package getMembershipPackage() {
        return membershipPackage;
    }
    public void setMembershipPackage(Package membershipPackage) {
        this.membershipPackage = membershipPackage;
    }
    public LocalDate getStartDate() {
        return startDate;
    }
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
    public LocalDate getEndDate() {
        return endDate;
    }
    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    @Override
    public ArrayList<String> getColumnNames() {
        return (ArrayList<String>) List.of("memberID", "packageID", "startDate", "endDate");
    }
    @Override
    public ArrayList<Object> getColumnValues() {
        List<Object> columnValues = List.of(member.getMemberID(), membershipPackage.getPackageID(), startDate, endDate);
        return (ArrayList<Object>) columnValues;
    }
    @Override
    public ArrayList<String> getIdNames() {
        return new ArrayList<>(Arrays.asList("memberID", "packageID"));
    }
    @Override
    public ArrayList<Object> getIdValues() {
        List<Object> idValues = List.of(member.getMemberID(), membershipPackage.getPackageID());
        return (ArrayList<Object>) idValues;
    }
    @Override
    public void setId(int id) {
        
    }
}
