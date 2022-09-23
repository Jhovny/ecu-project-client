package ecu.project.client.persistence.model.dao;

import ecu.project.client.persistence.model.entity.ClientEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface IClientCrudRepository extends CrudRepository<ClientEntity, Long> {

    Optional<ClientEntity> findByClientId(String clientId);

}
