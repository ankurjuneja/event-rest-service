package services;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import models.Event;

@Repository
public interface EventRepository extends CrudRepository<Event, Long> {

}
