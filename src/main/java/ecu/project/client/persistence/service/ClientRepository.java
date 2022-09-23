package ecu.project.client.persistence.service;

import ecu.project.client.domain.dto.Client;
import ecu.project.client.domain.repository.IClientRepository;
import ecu.project.client.persistence.mapper.IClientMapper;
import ecu.project.client.persistence.model.dao.IClientCrudRepository;
import ecu.project.client.persistence.model.entity.ClientEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClientRepository implements IClientRepository {

    @Autowired
    private IClientCrudRepository iClientCrudRepository;

    @Autowired
    private IClientMapper iClientMapper;


    @Override
    public List<Client> getAll() {
        return  iClientMapper.toClients((List<ClientEntity>) iClientCrudRepository.findAll());

    }

    @Override
    public Optional<Client> getClient(long id) {

        return iClientCrudRepository.findById(id).map(c -> iClientMapper.toClient(c));
    }

    @Override
    public Optional<Client> getClientId(String clientId) {
        return iClientCrudRepository.findByClientId(clientId).map(c -> iClientMapper.toClient(c));

    }

    @Override
    public Client save(Client client) {
        return iClientMapper.toClient(iClientCrudRepository.save( iClientMapper.toClientEntity(client)));

    }

    @Override
    public void delete(long id) {
        iClientCrudRepository.deleteById(id);
    }

    @Override
    public void deleteClientId(String clientId) {
        Optional<Client> client0 = iClientCrudRepository.findByClientId(clientId).map(x -> iClientMapper.toClient(x));

        if (client0.isPresent()) {
            delete(client0.get().getIdClient());
        }
    }
}
