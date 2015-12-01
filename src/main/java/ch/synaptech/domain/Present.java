package ch.synaptech.domain;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

/**
 * Created by mwatson on 11/28/2015.
 */
@Entity
public class Present {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Version
    private Integer version;

    private String name;
    private String description;
    private String itemUrl;
    private BigDecimal price;
    private Integer priority;

    @ManyToOne(fetch = FetchType.LAZY)
    private User presentOwner;

    @ManyToOne(fetch=FetchType.LAZY)
    private User purchaser;

    @ManyToMany(mappedBy = "presents")
    private Set<Wishlist> wishlists;

    public User getPurchaser() {
        return purchaser;
    }

    public void setPurchaser(User purchaser) {
        this.purchaser = purchaser;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getItemUrl() {
        return itemUrl;
    }

    public void setItemUrl(String itemUrl) {
        this.itemUrl = itemUrl;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }
}
