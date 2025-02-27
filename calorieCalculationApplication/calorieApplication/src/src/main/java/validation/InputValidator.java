package validation;

/**
 *  Validates inputs taken from the register/login form.
 *  This class should NOT be modified without careful consideration.
 *  Any changes to this class can impact the other parts of the application.
 */

import java.util.regex.Pattern;

/**
 * @author :Amina
 */
public class InputValidator {

    public static boolean isEmpty(String input){
        return input==null || input.trim().isEmpty();
    }

    public static boolean isValidUserName(String userName){
        return !isEmpty(userName) && userName.length()>=3;
    }

    public static boolean isValidEmail(String email){
        String emailReg = "^[A-Za-z0-9+_.-]+@(.+)$";
        return !isEmpty(email) && Pattern.matches(emailReg, email);
    }

    public static boolean isValidPassword(String password){
        return !isEmpty(password) && password.length()>=6;
    }

    public static String isValidInput(String inputName, String inputEmail, String inputPassword) {
        if(isEmpty(inputName) || isEmpty(inputEmail) || isEmpty(inputPassword)){
            return "All fields must be filled.";
        }

        if(!isValidUserName(inputName))
            return "Name must be at least 3 characters long.";


        if(!isValidEmail(inputEmail))
            return "Email must be a valid email address. \n example@domain.com";


        if(!isValidPassword(inputPassword))
            return "Password must be at least 6 characters long.";

        return null;
    }

    public static String isValidInput(String inputEmail, String inputPassword) {
        if( isEmpty(inputEmail) || isEmpty(inputPassword)){
            return "All fields must be filled.";
        }

        if(!isValidEmail(inputEmail))
            return "Email must be a valid email address. \n example@domain.com";

        if(!isValidPassword(inputPassword))
            return "Password must be at least 6 characters long.";

        return null;
    }

}
