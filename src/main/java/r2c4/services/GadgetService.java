/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package r2c4.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import r2c4.modelos.Gadget;
import r2c4.repository.GadgetRepository;

/**
 *
 * @author anita
 */
@Service
public class GadgetService {
    
    @Autowired
    private GadgetRepository gRepo;
    
    public List<Gadget> getAll() {
        return gRepo.getAll();
    }

    public Optional<Gadget> getById(int Id) {
        return gRepo.getById(Id);
    }

    public Gadget save(Gadget gadget) {
        if (gadget.getId() == null) {
            return gRepo.save(gadget);
        } else {
            Optional<Gadget> existGadget = gRepo.getById(gadget.getId());
            if (existGadget.isPresent()) {
                return gadget;
            } else {
                return gRepo.save(gadget);
            }
        }
    }

    public Gadget update(Gadget gadget) {

        if (gadget.getId() != null) {
            Optional<Gadget> existGadget = gRepo.getById(gadget.getId());
            if (!existGadget.isPresent()) {

                if (gadget.getBrand() != null) {
                    existGadget.get().setBrand(gadget.getBrand());
                }

                if (gadget.getCategory() != null) {
                    existGadget.get().setCategory(gadget.getCategory());
                }
                if (gadget.getName() != null) {
                    existGadget.get().setName(gadget.getName());
                }
                if (gadget.getDescription() != null) {
                    existGadget.get().setDescription(gadget.getDescription());
                }
                if (gadget.getPrice() != 0.0) {
                    existGadget.get().setPrice(gadget.getPrice());
                }

                if (gadget.getQuantity() != 0) {
                    existGadget.get().setQuantity(gadget.getQuantity());
                }
                if (gadget.getPhotography() != null) {
                    existGadget.get().setPhotography(gadget.getPhotography());
                }
                /**
                existGadget.get().setAvailability(gadget.isAvailability());
                gadgetRepository.update(existGadget.get());
                * **/
                return gRepo.save(existGadget.get());
            } else {
                return gadget;
            }
        } else {
            return gadget;
        }
    }

      public void delete(Integer Id) {
        //si obtiene el id, se borra y devuelve true
        Optional<Gadget> ov = gRepo.getById(Id);
        if (ov.isPresent()) {
            gRepo.delete(ov.get());
        }
    }
    
    /**
     public boolean delete(Integer id) {
        Boolean aBoolean = getById(id).map(accesory -> {
            gadgetRepository.delete(accesory);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    * **/
}