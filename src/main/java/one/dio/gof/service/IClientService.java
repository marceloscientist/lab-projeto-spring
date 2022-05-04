package one.dio.gof.service;

import one.dio.gof.model.Client;

public
interface IClientService {
    Iterable<Client> findAll();
    Client findById(Long id);
    void insert(Client client);
    void update(Long id, Client client);
    void delete(Long id);
}
