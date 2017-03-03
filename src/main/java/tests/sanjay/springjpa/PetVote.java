/**
 * File Name    :   PetFavorite.java
 * Created by   :   Sanjay Khattar (techarch15@icloud.com)
 * Created Date :   Mar 2, 2017 1:05:11 AM
 * Purpose      :   Represents a Vote up/down for a Pet Picture.
 *
 */

package tests.sanjay.springjpa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Represents a Vote up/down for a Pet Picture.
 * 
 * @author Sanjay Khattar (techarch15@icloud.com)
 *
 */
@Entity
public class PetVote implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -4944146263272548418L;

    @EmbeddedId
    private PetVotePK petVoteId;
   
    @ManyToOne
    @JoinColumn(name="petId", referencedColumnName="petId", insertable=false, updatable=false)
    private Pet pet;
    
    @Column(insertable=false, updatable=false)
    private String clientId;
    
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private PetVoteType voteType = PetVoteType.NONE;
    
    /**
     * 
     */
    protected PetVote() {
        super();
    }

    
    /**
     * @param pet
     * @param clientId
     * @param voteType
     */
    public PetVote(Pet pet, String clientId, PetVoteType voteType) {
        super();
        this.petVoteId = new PetVotePK(pet.getId(), clientId);
        this.pet = pet;
        this.clientId = clientId;
        this.voteType = voteType;
    }

    
    public Pet getPet() {
        return pet;
    }

    public String getClientId() {
        return clientId;
    }
    
    public PetVoteType getVoteType() {
        return voteType;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((clientId == null) ? 0 : clientId.hashCode());
        result = prime * result + ((petVoteId == null) ? 0 : petVoteId.hashCode());
        result = prime * result + ((voteType == null) ? 0 : voteType.hashCode());
        return result;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PetVote other = (PetVote) obj;
        if (clientId == null) {
            if (other.clientId != null)
                return false;
        }
        else if (!clientId.equals(other.clientId))
            return false;
        if (petVoteId == null) {
            if (other.petVoteId != null)
                return false;
        }
        else if (!petVoteId.equals(other.petVoteId))
            return false;
        if (voteType != other.voteType)
            return false;
        return true;
    }


    @Override
    public String toString() {
        return "PetVote [petVoteId=" + petVoteId + ", pet=" + pet + ", clientId=" + clientId
                + ", voteType=" + voteType + "]";
    }

    
}
