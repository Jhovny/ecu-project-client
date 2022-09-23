package ecu.project.client.persistence.mapper;


import ecu.project.client.domain.dto.Client;
import ecu.project.client.domain.dto.Person;
import ecu.project.client.persistence.model.entity.ClientEntity;
import ecu.project.client.persistence.model.entity.PersonEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IPersonMapper {

    @Mappings({
            @Mapping(source = "idPerson", target = "idPerson"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "gender", target = "gender"),
            @Mapping(source = "age", target = "age"),
            @Mapping(source = "addres", target = "addres"),
            @Mapping(source = "phone", target = "phone"),
            @Mapping(source = "identification", target = "identification")
    })
    Person toPerson(PersonEntity personEntity);
    List<Person> toPersons(List<PersonEntity> personEntities);

    @InheritInverseConfiguration
    @Mapping(target = "clients", ignore = true)
    PersonEntity toPersonEntity(Person person);

}
