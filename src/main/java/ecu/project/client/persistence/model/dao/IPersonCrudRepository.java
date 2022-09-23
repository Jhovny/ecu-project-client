package ecu.project.client.persistence.model.dao;

import ecu.project.client.persistence.model.entity.PersonEntity;
import org.springframework.data.repository.CrudRepository;

public interface IPersonCrudRepository extends CrudRepository<PersonEntity, Long> {


}
