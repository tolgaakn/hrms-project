package myproject.hrms.core.adapters;

import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

@Service
public class MernisDemo {
	
	private final String idendidtyNumberPattern = "[0-9]*";
	
	public boolean isValidNationalIdentity(String identityNumber) {
		if (identityNumber.length()!=11) {
			return false;
		}
		
		Pattern pattern = Pattern.compile(idendidtyNumberPattern, Pattern.CASE_INSENSITIVE);
		return pattern.matcher(identityNumber).find();
	}
}
