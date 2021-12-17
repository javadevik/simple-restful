package com.ua.simplerestful.service;

import com.ua.simplerestful.model.Client;

import java.util.List;

public interface ClientService {

    /**
     * Create a new client
     * @param client for creating
     * */
    void create(Client client);

    /**
     * Return all clients are exists
     * @return list of all clients
     * */
    List<Client> readAll();

    /**
     * Return client by id
     * @param id client
     * @return client's object by id
     * */
    Client read(Integer id);

    /**
     * Update information of client by id
     * @param client - new client for updating
     * @param id - client's id for updating
     * @return true if updating access, else return false
     * */
    boolean update(Client client, Integer id);

    /**
     * Delete client by id
     * @param id - client's id to delete
     * @return true when delete has success, and false when failure
     * */
    boolean delete(Integer id);
}
