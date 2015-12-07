package org.sample.controller.service;

import java.util.List;

import org.sample.controller.pojos.ApplicationForm;
import org.sample.model.Application;
import org.sample.model.Course;

public interface ApplicationService {

	Application saveApplication(ApplicationForm application);

	Application findApplicationById(long appId);

	void deleteApplication(Application app);

	Course acceptApplication(Application app);

	List<Application> getFutureApplications();

	boolean notDuplicate(ApplicationForm application);

}
