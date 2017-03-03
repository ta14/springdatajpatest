/**
 * File Name    :   PetRepository.java
 * Created by   :   Sanjay Khattar (techarch15@icloud.com)
 * Created Date :   Mar 2, 2017 12:48:42 AM
 * Purpose      :   PetRepository.
 *
 */

package tests.sanjay.springjpa;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


/**
 * 
 * @author Sanjay Khattar (techarch15@icloud.com)
 *
 */
public interface PetRepository extends CrudRepository<Pet, Long> {

    /**
     * 
     * @param imageUrl
     * @return
     */
    Pet findOneByImageUrl(String imageUrl);
    
    /**
     * 
     * @return
     */
    List<Pet> findAllByOrderByBreedAsc();
    
    /**
     * 
     * @param breed
     * @return
     */
    List<Pet> findByBreed(String breed);
    
}
