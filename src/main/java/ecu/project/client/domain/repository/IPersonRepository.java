package ecu.project.client.domain.repository;



import ecu.project.client.domain.dto.Person;

import java.util.List;
import java.util.Optional;

public interface IPersonRepository {
    List<Person> getAll();
    Optional<Person> getPerson(long id);
    Person save(Person person);
    void delete(long id);

}
