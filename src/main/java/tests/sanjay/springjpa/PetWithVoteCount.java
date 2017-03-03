/**
 * File Name    :   PetWithVoteCount.java
 * Created by   :   Sanjay Khattar (techarch15@icloud.com)
 * Created Date :   Mar 3, 2017 1:07:24 AM
 * Purpose      :   PetWithVoteCount.
 *
 */

package tests.sanjay.springjpa;


/**
 * 
 * @author Sanjay Khattar (techarch15@icloud.com)
 *
 */
public class PetWithVoteCount {

    private Pet pet;
    private Long count;
    
    /**
     * 
     */
    public PetWithVoteCount() {
        super();
    }

    /**
     * @param petId
     * @param count
     */
    public PetWithVoteCount(Pet pet, Long count) {
        super();
        this.pet = pet;
        this.count = count;
    }

    
    public Pet getPet() {
        return pet;
    }

    
    public void setPet(Pet pet) {
        this.pet = pet;
    }

    
    public Long getCount() {
        return count;
    }

    
    public void setCount(Long count) {
        this.count = count;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((count == null) ? 0 : count.hashCode());
        result = prime * result + ((pet == null) ? 0 : pet.hashCode());
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
        PetWithVoteCount other = (PetWithVoteCount) obj;
        if (count == null) {
            if (other.count != null)
                return false;
        }
        else if (!count.equals(other.count))
            return false;
        if (pet == null) {
            if (other.pet != null)
                return false;
        }
        else if (!pet.equals(other.pet))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "PetWithVoteCount [pet=" + pet + ", count=" + count + "]";
    }
    
}
