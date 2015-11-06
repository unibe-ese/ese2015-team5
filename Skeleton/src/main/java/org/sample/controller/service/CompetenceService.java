package org.sample.controller.service;

import org.sample.model.Competence;

public interface CompetenceService {
	
	public Iterable<Competence> getCompetences();
	
	public Competence getCompetenceByName();
	
	public Competence findCompetenceById(long id);
	
	public Iterable<Competence> findCompetencesByName();
	
	public Competence saveCompetence(Competence comp);
	
	public Competence updateCompetence(Competence comp);
	
	public Competence deleteCompetence(Competence comp);
	
	public Competence validateComptence(Competence comp);

}
