package org.sample.model.dao;

import org.sample.model.Application;
import org.springframework.data.repository.CrudRepository;

public interface ApplicationDao extends CrudRepository<Application,Long>{

}
