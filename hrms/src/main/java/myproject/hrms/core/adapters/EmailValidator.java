package myproject.hrms.core.adapters;

import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

@Service
public class EmailValidator {
	
	private final String EMAIL_PATTERN = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+.(com|org|net|edu|gov|mil|biz|info|mobi)(.[A-Z]{2})?$";
	
	public boolean isEmailValid(String email) {
		Pattern pattern = Pattern.compile(EMAIL_PATTERN, Pattern.CASE_INSENSITIVE);
		return pattern.matcher(email).find();
	}
	
	
	public boolean isEmailMatchesWebAddress(String email, String webAddress) {
		return true;
	}
}
