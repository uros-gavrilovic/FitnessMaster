package domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Member implements Serializable, GenericEntity  {
     int memberID;
     String firstName;
     String lastName;
     Gender gender;
     String address;
     String phoneNumber;
     LocalDate dateOfBirth;

     public Member() {
     }
     public Member(int memberID) {
          this.memberID = memberID;
     }
     public Member(String firstName, String lastName, Gender gender, String address, String phoneNumber, LocalDate dateOfBirth) {
          this.firstName = firstName;
          this.lastName = lastName;
          this.gender = gender;
          this.address = address;
          this.phoneNumber = phoneNumber;
          this.dateOfBirth = dateOfBirth;
     }
     public Member(int memberID, String firstName, String lastName, Gender gender, String address, String phoneNumber, LocalDate dateOfBirth) {
          this.memberID = memberID;
          this.firstName = firstName;
          this.lastName = lastName;
          this.gender = gender;
          this.address = address;
          this.phoneNumber = phoneNumber;
          this.dateOfBirth = dateOfBirth;
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
          final Member other = (Member) obj;
          if (this.memberID != other.memberID) {
               return false;
          }
          if (!Objects.equals(this.firstName, other.firstName)) {
               return false;
          }
          if (!Objects.equals(this.lastName, other.lastName)) {
               return false;
          }
          if (!Objects.equals(this.address, other.address)) {
               return false;
          }
          if (!Objects.equals(this.phoneNumber, other.phoneNumber)) {
               return false;
          }
          if (this.gender != other.gender) {
               return false;
          }
          return Objects.equals(this.dateOfBirth, other.dateOfBirth);
     }
     public String toString() {
          return "Member{" + "memberID=" + memberID + ", firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender + ", address=" + address + ", phoneNumber=" + phoneNumber + ", dateOfBirth=" + dateOfBirth + '}';
     }

     public int getMemberID() {
          return memberID;
     }
     public void setMemberID(int memberID) {
          this.memberID = memberID;
     }
     public String getFirstName() {
          return firstName;
     }
     public void setFirstName(String firstName) {
          this.firstName = firstName;
     }
     public String getLastName() {
          return lastName;
     }
     public void setLastName(String lastName) {
          this.lastName = lastName;
     }
     public Gender getGender() {
          return gender;
     }
     public void setGender(Gender gender) {
          this.gender = gender;
     }
     public String getAddress() {
          return address;
     }
     public void setAddress(String address) {
          this.address = address;
     }
     public String getPhoneNumber() {
          return phoneNumber;
     }
     public void setPhoneNumber(String phoneNumber) {
          this.phoneNumber = phoneNumber;
     }
     public LocalDate getDateOfBirth() {
          return dateOfBirth;
     }
     public void setDateOfBirth(LocalDate dateOfBirth) {
          this.dateOfBirth = dateOfBirth;
     }

    @Override
    public ArrayList<String> getIdNames() {
        return (ArrayList<String>) List.of("memberID");
    }
    @Override
    public void setId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
