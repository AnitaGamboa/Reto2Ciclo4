/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package r2c4.interfaces;

import org.springframework.data.mongodb.repository.MongoRepository;
import r2c4.modelos.Gadget;

/**
 *
 * @author anita // como 
 */
public interface GadgetInterface extends MongoRepository<Gadget, Integer> {
    
}
