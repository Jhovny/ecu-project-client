package ecu.project.client.domain.service;


import ecu.project.client.domain.dto.Person;
import ecu.project.client.domain.repository.IPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    @Autowired
    private IPersonRepository iPersonRepository;

    public List<Person> getAll() {
        return iPersonRepository.getAll();
    }
    public Optional<Person> getById(long id) {
        return iPersonRepository.getPerson(id);
    }
    public Person save (Person person){
       return iPersonRepository.save(person);
    }
    public boolean delete (long id){
        return getById(id).map(product -> {
            iPersonRepository.delete(id);
            return true;
        }).orElse(false);

    }
}
