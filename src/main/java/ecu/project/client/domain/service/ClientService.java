package ecu.project.client.domain.service;

import ecu.project.client.domain.dto.Client;
import ecu.project.client.domain.repository.IClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private IClientRepository iClientRepository;

    public List<Client> getAll() {
        return iClientRepository.getAll();
    }
    public Optional<Client> getById(long id) {
        return iClientRepository.getClient(id);
    }

    public void getByClientId(String clientId) {
         iClientRepository.getClientId(clientId);
    }

    public Client save (Client client){
       return iClientRepository.save(client);
    }
    public boolean delete (long id){
        return getById(id).map(product -> {
            iClientRepository.delete(id);
            return true;
        }).orElse(false);

    }
}
