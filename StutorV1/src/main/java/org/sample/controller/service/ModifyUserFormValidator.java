package org.sample.controller.service;

import org.sample.controller.pojos.ModifyUserForm;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class ModifyUserFormValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return ModifyUserForm.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ModifyUserForm form = (ModifyUserForm) target;
		ValidationUtils.rejectIfEmpty(errors, "password", "field.required", "Password is required");
		ValidationUtils.rejectIfEmpty(errors, "passwordControll", "field.required", "Password Controll is required");
		
	}

}
