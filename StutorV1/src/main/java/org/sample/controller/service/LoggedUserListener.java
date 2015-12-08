package org.sample.controller.service;

import javax.servlet.http.HttpSession;

import org.sample.model.User;
import org.sample.model.dao.UserDao;
import org.sample.security.UsernamePasswordIDAuthenticationToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Component;

@Component
public class LoggedUserListener implements ApplicationListener<AuthenticationSuccessEvent> {

	@Autowired
    private HttpSession session;
	@Autowired
	UserDao userDao;
	
	@Override
	public void onApplicationEvent(AuthenticationSuccessEvent event) {
		UsernamePasswordIDAuthenticationToken auth = (UsernamePasswordIDAuthenticationToken) event.getAuthentication();
		long id = auth.getId();
		User user = userDao.findOne(id);
		session.setAttribute("user", user);

	}

}
