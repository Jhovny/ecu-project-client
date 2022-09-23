package ecu.project.client.persistence.mapper;

import ecu.project.client.domain.dto.Client;
import ecu.project.client.persistence.model.entity.ClientEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring")
public interface IClientMapper {

    @Mappings({
            @Mapping(source = "idClient", target = "idClient"),
            @Mapping(source = "idPerson", target = "idPerson"),
            @Mapping(source = "estado", target = "estado"),
            @Mapping(source = "clientId", target = "clientId"),
            @Mapping(source = "person", target = "person"),
            @Mapping(target = "contrasenia", ignore = true)
    })
    Client toClient(ClientEntity clientEntity);

    List<Client> toClients(List<ClientEntity> clientsEntity);

    @InheritInverseConfiguration

    ClientEntity toClientEntity(Client client);

}
