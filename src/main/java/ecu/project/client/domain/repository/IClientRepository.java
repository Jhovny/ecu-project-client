package ecu.project.client.domain.repository;

import ecu.project.client.domain.dto.Client;

import java.util.List;
import java.util.Optional;

public interface IClientRepository {

    List<Client> getAll();
    Optional<Client> getClient(long id);
    Optional<Client> getClientId(String clientId);
    Client save(Client client);
    void delete(long id);
    void deleteClientId(String clientId);

}
