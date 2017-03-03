/**
 * File Name    :   PetVoteRepository.java
 * Created by   :   Sanjay Khattar (techarch15@icloud.com)
 * Created Date :   Mar 2, 2017 1:28:03 AM
 * Purpose      :   PetVoteRepository.
 *
 */

package tests.sanjay.springjpa;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * 
 * @author Sanjay Khattar (techarch15@icloud.com)
 *
 */
public interface PetVoteRepository extends CrudRepository<PetVote, PetVotePK> {
//    @Query("SELECT p, COUNT(pv) FROM Pet p LEFT JOIN p.vote pv GROUP BY p ORDER BY COUNT(pv)")
    @Query("SELECT new tests.sanjay.springjpa.PetWithVoteCount(pv.pet, COUNT(pv.clientId)) FROM PetVote pv GROUP BY pv.pet ORDER BY COUNT(pv.clientId) DESC")
    public List<PetWithVoteCount> findAllPetsOrderedByVoteCount();
}
