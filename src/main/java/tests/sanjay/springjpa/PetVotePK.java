/**
 * File Name    :   PetVotePK.java
 * Created by   :   Sanjay Khattar (techarch15@icloud.com)
 * Created Date :   Mar 2, 2017 7:20:00 PM
 * Purpose      :   PetVotePK.
 *
 */

package tests.sanjay.springjpa;

import java.io.Serializable;

import javax.persistence.Embeddable;

/**
 * 
 * @author Sanjay Khattar (techarch15@icloud.com)
 *
 */
@Embeddable
public class PetVotePK implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 448470961238414227L;
    
    private long petId;
    private String clientId;
    
    /**
     * 
     */
    public PetVotePK() {
        super();
    }
    
    public PetVotePK(long petId, String clientId) {
        this.petId = petId;
        this.clientId = clientId;
    }

    
    public long getPetId() {
        return petId;
    }

    
    public void setPetId(long petId) {
        this.petId = petId;
    }

    
    public String getClientId() {
        return clientId;
    }

    
    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((clientId == null) ? 0 : clientId.hashCode());
        result = prime * result + (int) (petId ^ (petId >>> 32));
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
        PetVotePK other = (PetVotePK) obj;
        if (clientId == null) {
            if (other.clientId != null)
                return false;
        }
        else if (!clientId.equals(other.clientId))
            return false;
        if (petId != other.petId)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "PetVotePK [petId=" + petId + ", clientId=" + clientId + "]";
    }
    
    

}
