
package lib.generators;

import domain.Gender;
import domain.Member;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class RandomMemberGenerator {
    private List<String> firstNames = Arrays.asList("John", "Daniel", "Alex", "Max", "Anna", "Emma", "Sarah", "Frank", "Morgan", "Rick", "Bobby", "Michael", "Lisa", "Olivia", "Sophia");
    private List<String> lastNames = Arrays.asList("Richardson", "Specter", "Paulsen", "Axelrod", "Alderson", "Smith", "Wellington", "Allen", "Williamson", "Dalton", "Odenkirk", "Cooper");
    private List<String> addresses = Arrays.asList("698 Candlewood Lane, Cabot Cove, Maine" , "221B Baker St., London", "1313 Mockingbird Lane, Mockingbird Heights", "1600 Pennsylvania Avenue, Washington, D.C.", "350 Fifth Avenue, New York City, NY", "7 Savile Row, Burlington Gardens, London", "62 West Wallaby Street, Wigan, Lancashire", "31 Spooner Street, Quahog, Rhode Island", "17 Cherry Tree Lane, London", "52 Festive Road, Putney, London", "24 Oil Drum Lane, Shepherd's Bush, London", "30 St Mary Axe, London", "9764 Jeopardy Lane, Chicago, Illinois");
    private List<Gender> genders = Arrays.asList(Gender.MALE, Gender.FEMALE);
    private List<LocalDate> dateInterval = Arrays.asList(LocalDate.of(1950, 1, 1), LocalDate.of(2002, 1, 1));
    
    private Random rn = new Random();
    
    public String getFirstName(){
        return firstNames.get(rn.nextInt(firstNames.size()));
    }
    public String getLastName() {
        return lastNames.get(rn.nextInt(lastNames.size()));
    }
   public String getAddress(){
         return addresses.get(rn.nextInt(addresses.size()));      
   } 
    public Gender getGender(){
         return genders.get(rn.nextInt(genders.size()));      
   } 
    public String getPhoneNumber(){
        Random rand = new Random();
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < 10; i++) {
            sb.append(rand.nextInt(10));
        }
        return sb.toString();
    }
    public LocalDate getDateOfBirth(){
        LocalDate start = dateInterval.get(0);
        LocalDate end = dateInterval.get(1);

        long numDays = ChronoUnit.DAYS.between(start, end);
        Random rand = new Random();
        long randomDays = rand.nextInt((int) numDays + 1);
        LocalDate randomDate = start.plusDays(randomDays);
        
        return randomDate;
    }
    public Member getRandomMember(){
        return new Member(Integer.MAX_VALUE, getFirstName(), getLastName(), getGender(), getAddress(), getPhoneNumber(), getDateOfBirth());
    }
}
