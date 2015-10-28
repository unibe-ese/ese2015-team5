package Validation;

import org.sample.model.File;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


public class FileValidator implements Validator {
	
	

	public void validate(Object obj, Errors errors) {
		File file = (File) obj;
		  if (file.getFile().getSize() == 0) {
		   errors.rejectValue("file", "valid.file");
		  }
	}

	public boolean supports(Class paramClass) {
		return File.class.equals(paramClass);
	}
}
