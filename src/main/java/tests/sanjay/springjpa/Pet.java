/**
 * File Name    :   Pet.java
 * Created by   :   Sanjay Khattar (techarch15@icloud.com)
 * Created Date :   Mar 1, 2017 11:55:57 PM
 * Purpose      :   Represents a Pet.
 *
 */

package tests.sanjay.springjpa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Represents a Pet.
 * 
 * @author Sanjay Khattar (techarch15@icloud.com)
 *
 */
@Entity
public class Pet implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 8639435239453867596L;

    @Id
    @GeneratedValue
    @Column(name="petId")
    private Long id;

    @Column(nullable = false)
    private String breed;

    @Column(nullable = false)
    private String imageUrl;
    
//    private Set<PetVote> votes;
//     
//    @OneToMany(mappedBy = "pet", cascade = CascadeType.ALL)
//    public Set<PetVote> getVotes() {
//        return votes;
//    }

    /**
     * 
     */
    protected Pet() {
        super();
    }

    public Pet(String breed, String imageUrl) {
        super();
        this.breed = breed;
        this.imageUrl = imageUrl;
    }

        
    public Long getId() {
        return id;
    }

    
    public String getBreed() {
        return breed;
    }

    
    public void setBreed(String breed) {
        this.breed = breed;
    }

    
    public String getImageUrl() {
        return imageUrl;
    }

    
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    
//    public void setVotes(Set<PetVote> votes) {
//        this.votes = votes;
//    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((breed == null) ? 0 : breed.hashCode());
        result = prime * result + ((imageUrl == null) ? 0 : imageUrl.hashCode());
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
        Pet other = (Pet) obj;
        if (breed == null) {
            if (other.breed != null)
                return false;
        }
        else if (!breed.equals(other.breed))
            return false;
        if (imageUrl == null) {
            if (other.imageUrl != null)
                return false;
        }
        else if (!imageUrl.equals(other.imageUrl))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Pet [id=" + id + ", breed=" + breed + ", imageUrl=" + imageUrl + "]";
    }
    

}
