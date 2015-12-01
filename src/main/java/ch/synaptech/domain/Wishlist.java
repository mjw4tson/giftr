package ch.synaptech.domain;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

/**
 * Created by mwatson on 11/28/15.
 */
@Entity
public class Wishlist {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Version
    private Integer version;

    private String name;

    @ManyToMany
    @JoinTable(name = "wishlist_presents",
               joinColumns = @JoinColumn(name = "wishlist_id", referencedColumnName = "id"),
               inverseJoinColumns = @JoinColumn(name = "present_id", referencedColumnName = "id"))
    private Set<Present> presents;

    @ManyToOne(fetch=FetchType.LAZY)
    private User listOwner;

    public User getListOwner() {
        return listOwner;
    }

    public void setListOwner(User listOwner) {
        this.listOwner = listOwner;
    }

    public Set<Present> getPresents() {
        return presents;
    }

    public void setPresents(Set<Present> presents) {
        this.presents = presents;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
