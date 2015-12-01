package ch.synaptech.domain;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by mwatson on 11/29/15.
 */
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String firstName;
    private String lastName;
    private String email;

    @OneToMany(mappedBy = "listOwner")
    private Set<Wishlist> wishlists;

    @OneToMany(mappedBy = "presentOwner")
    private Set<Present> presents;

    @OneToMany(mappedBy = "purchaser")
    private Set<Present> purchasedPresents;


    public Set<Present> getPresents() {
        return presents;
    }

    public void setPresents(Set<Present> presents) {
        this.presents = presents;
    }

    public Set<Present> getPurchasedPresents() {
        return purchasedPresents;
    }

    public void setPurchasedPresents(Set<Present> purchasedPresents) {
        this.purchasedPresents = purchasedPresents;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Wishlist> getWishlists() {
        return wishlists;
    }

    public void setWishlists(Set<Wishlist> wishlists) {
        this.wishlists = wishlists;
    }
}
