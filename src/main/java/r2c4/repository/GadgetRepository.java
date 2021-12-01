/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package r2c4.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import r2c4.interfaces.GadgetInterface;
import r2c4.modelos.Gadget;

/**
 *
 * @author anita
 */
@Repository
public class GadgetRepository {

    @Autowired
    private GadgetInterface repository;

    public List<Gadget> getAll() {
        return (List<Gadget>) repository.findAll();
    }

    public Optional<Gadget> getById(int id) {
        return repository.findById(id);
    }

    public Gadget save(Gadget gadget) {
        return repository.save(gadget);
    }
public void update(Gadget gadget) {
        repository.save(gadget);
}

    public void delete(Gadget gadget) {
        repository.delete(gadget);
    }
}