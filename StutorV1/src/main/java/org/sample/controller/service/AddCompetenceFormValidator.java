package org.sample.controller.service;

import org.sample.controller.pojos.AddCompetenceForm;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class AddCompetenceFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return AddCompetenceForm.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		AddCompetenceForm form = (AddCompetenceForm)target;
		ValidationUtils.rejectIfEmpty(errors, "description", "field.required", "Description is required");
		ValidationUtils.rejectIfEmpty(errors, "grade", "field.required", "Grade is required");
		float gradeFloat = 0;
		try{
			 gradeFloat = Float.parseFloat(form.getGrade());
		}catch(NumberFormatException e){
			errors.rejectValue("grade", "grade.format", "Grade can only be numbers ( 0 - 6 ) ");
		}
		if(!gradeIsValid(gradeFloat)){
			errors.rejectValue("grade", "grade.range", "Grade has to be between 0 and 6");
		}
		if(form.getDescription().length() > 35){
			errors.rejectValue("description", "grade.length", "Max length is 35");
		}
	}
	
	private boolean gradeIsValid(float grade) {
		return 0 <= grade && grade <= 6;
	}

}
