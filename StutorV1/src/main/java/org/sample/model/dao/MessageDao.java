package org.sample.model.dao;

import org.sample.model.Message;
import org.springframework.data.repository.CrudRepository;


public interface MessageDao extends CrudRepository<Message,Long>{

}
