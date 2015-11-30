package org.sample.controller.service;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import org.sample.controller.exceptions.InvalidUserException;
import org.sample.controller.pojos.ModifyUserForm;
import org.sample.controller.pojos.NewsFeedArticleInterface;
import org.sample.controller.pojos.SignupForm;
import org.sample.controller.pojos.StudentNews;
import org.sample.controller.pojos.TutorNews;
import org.sample.model.Competence;
import org.sample.model.Course;
import org.sample.model.ProfilePicture;
import org.sample.model.User;
import org.sample.model.dao.CompetenceDao;
import org.sample.model.dao.ProfilePictureDao;
import org.sample.model.dao.UserDao;
import org.sample.security.UsernamePasswordIDAuthenticationToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

/**
 * Provides functionalities like searching, modifying and saving of {@link User} in the DB.
 * 
 * @author ESE Team5
 *
 */

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserDao userDao;
	@Autowired
	CompetenceDao compDao;
	@Autowired
	ProfilePictureDao profilePicDao;
	@Autowired 
	CourseService courseService;
	
	public User getUserByEmail(String email) {
		for (User u:userDao.findAll())
		{
			if(u.getEmail().equals(email))
			return u;
		}
		return null;
	}
	
	public User getUserById(long userId) {
		return userDao.findOne(userId);
	}

	public User getCurrentUser() {
		UsernamePasswordIDAuthenticationToken authtok;
		try{
			authtok = (UsernamePasswordIDAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
		}catch(ClassCastException e){
			return null;
		}
		return userDao.findOne(authtok.getId());
		
	}
	
	@Transactional
	public User saveUser(SignupForm sgnUp) throws InvalidUserException {
		
		MultipartFile file = sgnUp.getProfilePic();
        ProfilePicture profilePicture = new ProfilePicture();
        try {       	
        	profilePicture.setFile(file.getBytes());    	
        	saveProfilePicture(profilePicture);
        } catch (Exception e) {
            throw new InvalidUserException("Picture could not be processed");
        }
        if(emailAlreadyExists(sgnUp.getEmail())){
        	throw new InvalidUserException("Username is already in use");
        }
        User user = new User();
        user.setFirstName(sgnUp.getFirstName());
        user.setEmail(sgnUp.getEmail());
        user.setLastName(sgnUp.getLastName());
        user.setPassword(sgnUp.getPassword());
        user.setEnableTutor(false);
        user.setPic(profilePicture);
        user.setAboutYou(null);
        userDao.save(user);
        
        return user;
	}

	private boolean emailAlreadyExists(String email) {
		for(User user : userDao.findAll()){
			if(user.getEmail().equals(email)){
				return true;
			}
		}
		return false;
	}

	/**
	 * Only call this method after calling validateModifyUserForm.
	 * 
	 */
	public User updateUser(ModifyUserForm mod) throws InvalidUserException {
		User user  = userDao.findOne(mod.getId());
		if(user.getEnableTutor() != mod.getEnableTutor()){
			for(Competence c : user.getCompetences()){
				c.setisEnabled(mod.getEnableTutor());
				compDao.save(c);
			}
		}
		user.setFirstName(mod.getFirstName());
		user.setLastName(mod.getLastName());
		user.setPassword(mod.getPassword());
		user.setEnableTutor(mod.getEnableTutor());
		user.setAboutYou(mod.getAboutYou());
		return userDao.save(user);
	}

	public boolean validateModifyUserForm(ModifyUserForm mod) {
		User user = userDao.findOne(mod.getId());
    	if(user == null || !mod.getPassword().equals(mod.getPasswordControll())){
    		return false;
    	}
    	
    	return true;
	}

    public void saveProfilePicture(ProfilePicture profilePicture){
    	profilePicDao.save(profilePicture);
    }

	public void updateProfilePicture(ProfilePicture profilePicture) {
		User user = getCurrentUser();
		ProfilePicture pic = user.getPic();
		pic.setFile(profilePicture.getFile());
		userDao.save(user);
		profilePicDao.save(pic);		
	}

	@Override
	public User setHouerlyRate(User user, float houerlyRate) {
		double rate = Math.round(houerlyRate * 100.0) / 100.0;
		user.setHouerlyRate((float) rate);
		return userDao.save(user);
	}

	@Override
	public List<NewsFeedArticleInterface> buildNewsFeed() {
		User user = getCurrentUser();
		List<Course> courses = user.getCourses();
		removeNotBookedCourses(courses);
		courses.addAll(courseService.findStudenCoursesFor(user));
		Collections.sort(courses, new Comparator<Course>() {
		    @Override
		    public int compare(Course c1, Course c2) {
		        return c1.getDate().compareTo(c2.getDate());
		    }
		});
		removePastCourses(courses);
		circumciseList(courses);
		return buildArticles(courses, user);
	}

	private void removePastCourses(List<Course> courses) {
		Iterator<Course> iter = courses.iterator();
		Course course;
		while(iter.hasNext()){
			course = iter.next();
			if(course.isInThePast()){
				updateBalance(course.getOwner());
				courseService.deleteCourse(course);
				
			}
		}
		
	}

	private void updateBalance(User owner) {
		float percentage = Math.round(owner.getHouerlyRate() * 100) / 100;
		System.out.println(owner.getHouerlyRate());
		System.out.println(percentage);
		owner.setBalance(owner.getBalance() + percentage);
		userDao.save(owner);
		
	}

	private void removeNotBookedCourses(List<Course> courses) {
		List<Course> toRemove = new ArrayList<Course>();
		for(Course c : courses){
			if(c.getCustomer() == null)
				toRemove.add(c);
		}
		courses.removeAll(toRemove);		
	}

	private void circumciseList(List<Course> courses) {
		for(int i = 10; i < courses.size(); i++){
			courses.remove(i);
		}
	}

	private List<NewsFeedArticleInterface> buildArticles(List<Course> courses,
			User user) {
		List<NewsFeedArticleInterface> news = new ArrayList<NewsFeedArticleInterface>();
		for(Course c : courses){
			if(user.equals(c.getOwner()))
				news.add(buildTutorNews(c));
			else if(user.equals(c.getCustomer())){
				news.add(buildStudentNews(c));
			}	
		}
		return news;
	}

	private NewsFeedArticleInterface buildStudentNews(Course c) {
		StudentNews news = new StudentNews();
		DateFormat format = CalendarServiceImpl.FORMAT;
		news.setDateRepresentation(format.format(c.getDate()));
		news.setPartner(c.getOwner());
		return news;
	}

	private NewsFeedArticleInterface buildTutorNews(Course c) {
		TutorNews news = new TutorNews();
		DateFormat format = CalendarServiceImpl.FORMAT;
		news.setDateRepresentation(format.format(c.getDate()));
		news.setPartner(c.getCustomer());
		return news;
	}

}
