package org.sample.controller.service;

import java.util.List;

import org.sample.controller.pojos.AddCompetenceForm;
import org.sample.model.Competence;

public interface CompetenceService {
	
	public Iterable<Competence> getCompetences();
	
	public Competence findCompetenceById(long id);
	
	public Competence saveCompetence(AddCompetenceForm form);
	
	public Competence updateCompetence(Competence comp);
	
	public void deleteCompetence(Competence comp);
	
	public Competence validateComptence(Competence comp);
	
	public List<Competence> findCompetenceLike(String string);

}
