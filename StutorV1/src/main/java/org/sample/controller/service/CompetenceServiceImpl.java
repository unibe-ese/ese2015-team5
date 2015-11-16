package org.sample.controller.service;

import java.util.ArrayList;
import java.util.List;

import org.sample.controller.pojos.AddCompetenceForm;
import org.sample.controller.pojos.EditCompetenceForm;
import org.sample.model.Competence;
import org.sample.model.User;
import org.sample.model.dao.CompetenceDao;
import org.sample.model.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Provides functionalities like searching and saving of Competences in the DB.
 * 
 * @author ESE Team5
 *
 */

@Service
public class CompetenceServiceImpl implements CompetenceService{

	@Autowired
	CompetenceDao compDao;
	@Autowired
	UserDao userDao;
	
	public Iterable<Competence> getCompetences() {
		return compDao.findAll();
	}

	public Competence findCompetenceById(long id) {
		return compDao.findOne(id);	
	}

	public Competence saveCompetence(AddCompetenceForm form) {
		Competence comp = new Competence();
		User user = userDao.findOne(form.getOwnerId());
		comp.setDescription(form.getDescription());
		comp.setOwner(user);
		comp.setisEnabled(user.getEnableTutor());
		return compDao.save(comp);
	}

	public void deleteCompetence(Competence comp) {
		comp.setOwner(null);
		compDao.delete(comp);
	}

	public Competence validateComptence(Competence comp) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Competence> findCompetenceLike(String string){
		List<Competence> comps = new ArrayList<Competence>();
		System.out.println(compDao.findAll().toString());
		for(Competence c : compDao.findAll()){
			
			if(c.getDescription().toLowerCase().contains(string.toLowerCase()) && c.getisEnabled()){
				comps.add(c);
			}
		}
		
		return comps;
	}

	public Competence updateCompetence(EditCompetenceForm editForm) {
		System.out.println(editForm.toString());
		Competence comp = compDao.findOne(editForm.getCompReferenceId());
		if(comp != null){
			comp.setDescription(editForm.getDescription());
			return compDao.save(comp);
		}
		return null;
	}


}
