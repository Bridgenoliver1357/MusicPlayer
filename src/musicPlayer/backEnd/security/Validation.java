package musicPlayer.backEnd.security;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
	
	//this function uses regular expressions to determine if the password has a characteristic
	//regular expressions were used because they allowed me to check the whole password without
	//having to loop through the string and check each individual character
	public static int getPasswordStrength(String password) {
		Matcher hasLowerCase = Pattern.compile("[a-z]").matcher(password);
		Matcher hasUpperCase = Pattern.compile("[A-Z]").matcher(password);
		Matcher hasNumber = Pattern.compile("[0-9]").matcher(password);
		Matcher hasSpecial = Pattern.compile("[$&+,:{}\\[\\];=?_@#|'<>.^*()%!-]").matcher(password);
		Matcher hasConsecutive = Pattern.compile("((\\w)\\2+\\2)+.*").matcher(password);
		Matcher hasRepeated = Pattern.compile("(.{2,})\\1+").matcher(password);
		
		int score = 0;
		
		if (hasLowerCase.find()) {
			score += 20;
		}
		if (hasUpperCase.find()) {
			score += 20;
		}
		if (hasNumber.find()) {
			score += 20;
		}
		if (hasSpecial.find()) {
			score += 20;
		}
		if (password.length() >= 8) {
			score += 20;
		}
		if (hasConsecutive.find()) {
			score -= 20;
		}
		if (hasRepeated.find()) {
			score -= 20;
		}
		return score;
	}

	//checks if the given email is valid based on a regular expression
	public static boolean checkEMailIsValid(String eMail) {
		Matcher hasEMailPattern = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$").matcher(eMail);
		return hasEMailPattern.find();
	}

	//checks if the given URL is valid based on a regular expression
	public static boolean checkURLIsValid(String url) {
		Matcher hasURLPattern = Pattern.compile("[-a-zA-Z0-9@:%._\\+~#=]{1,256}\\.[a-zA-Z0-9()]{1,6}\\b([-a-zA-Z0-9()@:%_\\+.~#?&//=]*)").matcher(url);
		return hasURLPattern.find();
	}
}
