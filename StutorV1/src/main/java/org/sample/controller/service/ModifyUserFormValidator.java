package org.sample.controller.service;

import org.sample.controller.pojos.ModifyUserForm;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class ModifyUserFormValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return ModifyUserForm.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ModifyUserForm form = (ModifyUserForm) target;
		if( !form.getPassword().equals(form.getPasswordControll())){
			errors.rejectValue("password", "mustMatch", "Passwort and Password Controll need to match!");
			errors.rejectValue("passwordControll", "mustMatch", "Passwort and Password Controll need to match!");
		}
	}

}
