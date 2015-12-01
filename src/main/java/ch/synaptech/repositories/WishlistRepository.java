package ch.synaptech.repositories;

import ch.synaptech.domain.Wishlist;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by mwatson on 11/30/15.
 */
public interface WishlistRepository extends CrudRepository<Wishlist, Integer> {
}
