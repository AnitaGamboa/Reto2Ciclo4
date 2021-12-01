/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package r2c4.modelos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author anita
 */
@Document(collection = "gadgets")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Gadget {
@Id
private Integer id;
private String brand;
private String category;
private String name;
private String description;
private double price;
private boolean availability = true;
private int quantity;
private String photography;
}
