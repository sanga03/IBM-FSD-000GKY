package code.Assesments.PasswordValidation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserMainCode {
	public static boolean checkPassword(String password){
		if(password.length()<8)
		return false;
		Pattern pattern = Pattern.compile("(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\\\S+$).{8,}");
		Matcher matcher = pattern.matcher(password);
        return matcher.matches();
	}
}
