/**
 * File Name    :   PetService.java
 * Created by   :   Sanjay Khattar (techarch15@icloud.com)
 * Created Date :   Mar 2, 2017 12:03:29 AM
 * Purpose      :   Provides various Pet Store operations.
 *
 */

package tests.sanjay.springjpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Provides various Pet Store operations
 * 
 * @author Sanjay Khattar (techarch15@icloud.com)
 *
 */
public class PetService {
    
    @Autowired
    PetRepository petRepository;
    
    @Autowired
    PetVoteRepository petVoteRepository;

    /**
     * 
     */
    public PetService() {
        super();
    }

    /**
     * Gets all {@link Pet}s grouped by breed.
     * 
     * @return
     */
    public List<Pet> getAllPets() {
        return petRepository.findAllByOrderByBreedAsc();
    }
    
    /**
     * Gets all {@link Pet}s for the given 'breed'.
     * 
     * @return
     */
    public List<Pet> getAllPetsByBreed(String breed) {
        return petRepository.findByBreed(breed);
    }
    
    
    /**
     * Gets all {@link Pet}s for the given 'breed'.
     * 
     * @return
     */
    public List<PetWithVoteCount> getAllPetsOrderedByVoteCount() {
        return petVoteRepository.findAllPetsOrderedByVoteCount();
//        return petRepository.findAll();
    }

    /**
     * Get {@link Pet} by the given 'imageUrl'.
     * 
     * @param id
     * @return
     */
    public Pet getPetByImageUrl(String imageUrl) {
        return petRepository.findOneByImageUrl(imageUrl);
    }

    /**
     * Get {@link Pet} by the given 'id'.
     * 
     * @param id
     * @return
     */
    public Pet getPetById(long id) {
        return petRepository.findOne(id);
    }

    /**
     * Get Pet Vote.
     * 
     * @param pet
     * @param clientId
     * @return
     */
    public PetVote getPetVote(Pet pet, String clientId) {
        PetVotePK petVotePK = new PetVotePK(pet.getId(), clientId);
        return petVoteRepository.findOne(petVotePK);
    }
    
    /**
     * Save a Pet Vote.
     * 
     * @param pet
     * @param clientId
     * @param petVoteType
     */
    public PetVote votePet(Pet pet, String clientId, PetVoteType petVoteType) {
        PetVotePK petVotePK = new PetVotePK(pet.getId(), clientId);
        PetVote petVote = new PetVote(pet, clientId, petVoteType);
        boolean hasVotedAlready = petVoteRepository.exists(petVotePK);
        if (!hasVotedAlready) {
            System.out.println("not yet voted. voting " + petVoteType + " for pet: " + pet);
            petVote = petVoteRepository.save(petVote);            
        }
        else {
            System.out.println("already voted. cannot vote again for pet: " + pet);
        }
        
        return petVote;
    }
    
}
