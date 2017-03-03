/**
 * File Name    :   PetServiceTest.java
 * Created by   :   Sanjay Khattar (techarch15@icloud.com)
 * Created Date :   Mar 2, 2017 12:20:14 AM
 * Purpose      :   PetServiceTest.
 *
 */

package tests.sanjay.springjpa;

import static org.junit.Assert.*;

import java.time.Instant;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import tests.sanjay.springjpa.Application;
import tests.sanjay.springjpa.Pet;
import tests.sanjay.springjpa.PetService;
import tests.sanjay.springjpa.PetVoteType;


/**
 * 
 * @author Sanjay Khattar (techarch15@icloud.com)
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
public class PetServiceTest {

    @Autowired
    PetService petService;
    
    /**
     * Test method for {@link tests.sanjay.springjpa.PetService#getAllPets()}.
     */
    @Test
    public void testGetAllPets() {
        List<Pet> allPets = petService.getAllPets();
        
        System.out.println("allPets: " + allPets);
        
        assertNotNull(allPets);
        
        int numPets = allPets.size();
        
        System.out.println("numPets: " + numPets);

        assertTrue("number of All Pets should be greater than 0", numPets > 0);
        
    }

    /**
     * Test method for {@link tests.sanjay.springjpa.PetService#getAllPetsOrderedByVoteCount()()}.
     */
    @Test
    public void testGetAllPetsOrderedByVoteCount() {
        List<PetWithVoteCount> allPets = petService.getAllPetsOrderedByVoteCount();
        
        System.out.println("allPets: " + allPets);
        
        assertNotNull(allPets);
        
        int numPets = allPets.size();
        
        System.out.println("numPets: " + numPets);

        assertTrue("number of All Pets should be greater than 0", numPets > 0);
        
    }

    /**
     * Test method for {@link tests.sanjay.springjpa.PetService#getAllPetsByBreed(String)}.
     */
    @Test
    public void testGetAllPetsByBreed() {
        String breed = "Labrador";
        int expectedNumPets = 15;
        
        List<Pet> allPetsByBreed = petService.getAllPetsByBreed(breed);
        
        System.out.println("For breed:" + breed + ", allPets: " + allPetsByBreed);
        
        assertNotNull(allPetsByBreed);
        
        int numPets = allPetsByBreed.size();
        
        System.out.println("numPets: " + numPets);

        assertEquals(
                "number of All Pets for " + breed + " breed should be equal to " + expectedNumPets,
                expectedNumPets,
                numPets);
    }

    /**
     * Test method for {@link tests.sanjay.springjpa.PetService#getPetById(long)}.
     */
    @Test
    public void testGetPetById() {
        long id = 10;
        
        Pet pet = petService.getPetById(id);
        
        System.out.println("For id:" + id + ", got pet: " + pet);
        
        assertNotNull(pet);
        
    }

    /**
     * Test method for {@link tests.sanjay.springjpa.PetService#getPetByImageUrl(String)}.
     */
    @Test
    public void testGetPetByImageUrl() {
        String imageUrl = "http://i.imgur.com/Mda3xXr.png";
        
        Pet pet = petService.getPetByImageUrl(imageUrl);
        
        System.out.println("For imageUrl:" + imageUrl + ", got pet: " + pet);
        
        assertNotNull(pet);
        
        String retrievedImageUrl = pet.getImageUrl();
        
        assertEquals("ImageUrl in the retirved pet does not match the one pet was retrieved with",
                imageUrl, retrievedImageUrl);
    }

    /**
     * Test method for {@link tests.sanjay.springjpa.PetService#votePet(Pet, String, PetVoteType)}.
     */
    @Test
    public void testVotePet() {
        long id = 10;
        
        Pet pet = petService.getPetById(id);
        
        System.out.println("For id:" + id + ", got pet: " + pet);
        
        assertNotNull(pet);
        
        Instant now = Instant.now();
        long epochSecond = now.getEpochSecond();
        String clientId = "Client-" + epochSecond;
        PetVoteType petVoteType = PetVoteType.DOWN;
        petService.votePet(pet, clientId, petVoteType);
        
        PetVote petVote = petService.getPetVote(pet, clientId);
        assertNotNull(petVote);
        
        System.out.println("retrieved petVote: " + petVote);
        
        PetVoteType retrievedPetVoteType = petVote.getVoteType();
        assertEquals("pet vote should be same as that was saved", petVoteType,
                retrievedPetVoteType);

        PetVoteType newPetVoteType = PetVoteType.UP;

        // Once voted, should not allow voting again.
        try {
            petService.votePet(pet, clientId, newPetVoteType);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        petVote = petService.getPetVote(pet, clientId);
        PetVoteType newlyRetrievedPetVoteType = petVote.getVoteType();
        assertEquals("pet vote should be same as that was originally saved", retrievedPetVoteType,
                newlyRetrievedPetVoteType);
        
    }
    
    

}
