/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package r2c4.interfaces;

import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import r2c4.modelos.User;

/**
 *
 * @author anita
 */
public interface UserInterface extends MongoRepository<User, Integer> {

    Optional<User> findByEmailAndPassword(String email, String password);

    Optional<User> findByEmail(String email);

}
