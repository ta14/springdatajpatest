/**
 * File Name    :   PetController.java
 * Created by   :   Sanjay Khattar (techarch15@icloud.com)
 * Created Date :   Mar 1, 2017 11:44:42 PM
 * Purpose      :   Spring MVC Controller provide REST Endpoints for Pet Store.
 *
 */

package tests.sanjay.springjpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Spring MVC Controller provide REST Endpoints for Pet Store.
 * 
 * @author Sanjay Khattar (techarch15@icloud.com)
 *
 */
@RestController
public class PetController {

    @Autowired
    PetService petService;
    
    @RequestMapping(value = "/pets", method = RequestMethod.GET)
    public List<Pet> getAllPets(@RequestParam(name="breed", required=false) String breed) {
        if ((breed != null) && !breed.isEmpty()) {
            return petService.getAllPetsByBreed(breed);
        }
        else {
            return petService.getAllPets();
        }
    }

    @RequestMapping(value = "/pets/{id}", method = RequestMethod.GET)
    public Pet getPet(@PathVariable long id) {
        return petService.getPetById(id);
    }

    @RequestMapping(value = "/pets/{id}", method = RequestMethod.POST)
    public ResponseEntity<?> votePet(@PathVariable long id, String userId, PetVoteType petVoteType ) {
        ResponseEntity<?> response = null;
        Pet pet = petService.getPetById(id);
        if (pet != null) {
            PetVote petVote = petService.votePet(pet, userId, petVoteType);
            response = ResponseEntity.status(HttpStatus.CREATED).body(petVote);
        }
        else {
            response = ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }

        return response;
    }
    
}
