package ecu.project.client.persistence.service;

import ecu.project.client.domain.dto.Person;
import ecu.project.client.domain.repository.IPersonRepository;
import ecu.project.client.persistence.mapper.IPersonMapper;
import ecu.project.client.persistence.model.dao.IPersonCrudRepository;
import ecu.project.client.persistence.model.entity.ClientEntity;
import ecu.project.client.persistence.model.entity.PersonEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public class PersonRepository implements IPersonRepository {

    @Autowired
    private IPersonCrudRepository iPersonCrudRepository;

    @Autowired
    private IPersonMapper iPersonMapper;

    @Override
    public List<Person> getAll() {

        return  iPersonMapper.toPersons((List<PersonEntity>) iPersonCrudRepository.findAll());
    }

    @Override
    public Optional<Person> getPerson(long id) {
        return iPersonCrudRepository.findById(id).map(p -> iPersonMapper.toPerson(p));
    }

    @Override
    public Person save(Person person) {
        return iPersonMapper.toPerson(iPersonCrudRepository.save( iPersonMapper.toPersonEntity(person)));

    }

    @Override
    public void delete(long id) {
        iPersonCrudRepository.deleteById(id);
    }
}
