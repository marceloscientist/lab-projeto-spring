package one.dio.gof.service.implementation;

import one.dio.gof.model.Address;
import one.dio.gof.model.AddressRepository;
import one.dio.gof.model.Client;
import one.dio.gof.model.ClientRepository;
import one.dio.gof.service.IClientService;
import one.dio.gof.service.IViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public
class ClientService implements IClientService {

    @Autowired
    private
    ClientRepository clientRepository;

    @Autowired
    private
    AddressRepository addressRepository;

    @Autowired
    private
    IViaCepService iViaCepService;

    @Override
    public
    Iterable<Client> findAll ( ) {
        return clientRepository.findAll();
    }

    @Override
    public
    Client findById (Long id) {
        Optional<Client> client = clientRepository.findById(id);
        return client.get();
    }

    @Override
    public
    void insert (Client client) {
        saveClientWithCep(client);
    }

    private
    void saveClientWithCep (Client client) {
        String cep = client.getAddress().getCep();
        Address address = addressRepository.findById(cep).orElseGet(( ) -> {
            Address newAddress = iViaCepService.cepLookUp(cep);
            addressRepository.save(newAddress);
            return newAddress;
        });
        client.setAddress(address);
        clientRepository.save(client);
    }

    @Override
    public
    void update (Long id, Client client) {
        Optional<Client> clientBd = clientRepository.findById(id);
        if(clientBd.isPresent()) {
            saveClientWithCep(client);
        }
    }

    @Override
    public
    void delete (Long id) {
        clientRepository.deleteById(id);
    }
}
