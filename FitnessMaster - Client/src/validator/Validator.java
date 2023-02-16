package validator;

import domain.BodyPart;
import domain.Category;
import domain.Member;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import javax.swing.JOptionPane;

/**
 *
 * @author Uros
 */
public class Validator {
    private static Validator instance;

    private Validator() {
    }
    public static Validator getInstance() {
        if (instance == null) {
            instance = new Validator();
        }
        return instance;
    }

    public ValidateStatus validate(ValidateOperation validateOperation, HashMap<String, Object> data){
        switch (validateOperation) {
            case VALIDATE_MEMBER_INFO:
                return validateMemberInfo(data);
            case VALIDATE_EXERCISE_INFO:
                return validateCreateExerciseInfo(data);
            default:
                return null;
        }
    }

    private ValidateStatus validateMemberInfo(HashMap<String, Object> data) {
        String firstName = (String) data.get("firstName");
        String lastName = (String) data.get("lastName");
//        Object gender = (Object) data.get("gender");      
//        String address = (String) data.get("address");
//        String phoneNumber = (String) data.get("phoneNumber");
        String birthDate = (String) data.get("dateOfBirth");

        if (firstName.trim().isEmpty()) {
            return ValidateStatus.ERROR_FIRST_NAME;
        }
        
        if (lastName.trim().isEmpty()) {
            return ValidateStatus.ERROR_LAST_NAME;
        }
        
        if (birthDate != null && !birthDate.isBlank()) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy.");
            LocalDate bd = LocalDate.parse(birthDate, formatter);
            if (bd.isAfter(LocalDate.now()) || bd.isEqual(LocalDate.now())) return ValidateStatus.ERROR_BIRTH_DATE;
        }

        return ValidateStatus.OK;
    }
    private ValidateStatus validateCreateExerciseInfo(HashMap<String, Object> data){
        String name = (String) data.get("name");
        BodyPart bodyPart = (BodyPart) data.get("bodyPart");
        Category category = (Category) data.get("category");

        if(name.isBlank()){
            return ValidateStatus.ERROR_EXERCISE_NAME;
        }
        if(bodyPart == null){
            return ValidateStatus.ERROR_EXERCISE_BODYPART;
        }
        if (category == null) {
            return ValidateStatus.ERROR_EXERCISE_CATEGORY;
        }
        
        return ValidateStatus.OK;
    }
}
